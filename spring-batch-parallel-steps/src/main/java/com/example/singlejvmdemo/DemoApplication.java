package com.example.singlejvmdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class DemoApplication {

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public FlatFileItemReader<Transaction> fileItemReader(@Value("${inputFlatFile}") Resource resource){
        return new FlatFileItemReaderBuilder<Transaction>()
                .name("transactionItemReader")
                .resource(resource)
                .delimited()
                .names(new String[]{"account","amount","timestamp"})
                .fieldSetMapper(fieldSet -> {
                    Transaction transaction=new Transaction();
                    transaction.setAccount(fieldSet.readString("account"));
                    transaction.setAmount(fieldSet.readBigDecimal("amount"));
                    transaction.setTimestamp(fieldSet.readDate("timestamp", "yyyy-MM-dd HH:mm:ss"));
                    return transaction;
                }).build();
    }

    @Bean
    @StepScope
    public ItemReader<? extends Transaction> fileXmlReader(@Value("${inputXmlFile}") Resource resource) {
        Jaxb2Marshaller unMarshaller=new Jaxb2Marshaller();
        unMarshaller.setClassesToBeBound(Transaction.class);
        return new StaxEventItemReaderBuilder<Transaction>()
                .name("StaxItemReader")
                .resource(resource)
                .addFragmentRootElements("transaction")
                .unmarshaller(unMarshaller)
                .build();
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<Transaction> jdbcBatchItemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Transaction>()
                .dataSource(dataSource)
                .sql("INSERT INTO transaction (ACCOUNT, AMOUNT, TIMESTAMP) values(:account,:amount,:timestamp)")
                .beanMapped()
                .build();
    }

    @Bean
    public Job multithreadedJob(){
        return this.jobBuilderFactory.get("multithreadedJob")
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        /*ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setMaxPoolSize(4);
        taskExecutor.afterPropertiesSet();*/
        return this.stepBuilderFactory.get("step1")
                .<Transaction,Transaction>chunk(100)
                .reader(fileItemReader(null))
                .writer(jdbcBatchItemWriter(null))
                //.taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Step step2() {
        return this.stepBuilderFactory.get("step2")
                .<Transaction,Transaction>chunk(100)
                .reader(fileXmlReader(null))
                .writer(jdbcBatchItemWriter(null))
                .build();
    }



    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
