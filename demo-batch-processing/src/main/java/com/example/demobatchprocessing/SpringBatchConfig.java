package com.example.demobatchprocessing;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired private JobBuilderFactory jobBuilderFactory;
    @Autowired private StepBuilderFactory stepBuilderFactory;
    @Autowired private ItemReader<Person> itemReader;
    @Autowired private PersonItemProcessor itemProcessor;
    @Autowired private PersonItemWriter itemWriter;


    @Bean
    public Job jobPerson(){
        Step step=stepBuilderFactory.get("PersonStep")
                .<Person,Person>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("PersonJob")
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<Person> itemReader(@Value("${inputFile}")Resource resource){
        FlatFileItemReader<Person> flatFileItemReader=new FlatFileItemReader<>();
        flatFileItemReader.setName("READER-CSV");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    public LineMapper<Person> lineMapper() {
        DefaultLineMapper<Person> lineMapper=new DefaultLineMapper<>();
        DelimitedLineTokenizer lineToKenizer=new DelimitedLineTokenizer();
        lineToKenizer.setDelimiter(",");
        lineToKenizer.setStrict(false);
        lineToKenizer.setNames(new String[]{"id","firstName","lastName","email","activeAccount"});
        lineMapper.setLineTokenizer(lineToKenizer);
        BeanWrapperFieldSetMapper<Person> beanWrapperFieldSetMapper=new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(Person.class);
        lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        return lineMapper;
    }


}
