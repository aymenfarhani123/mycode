package com.example.demobatchlistener;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemobatchlistenerApplication {

    public static void main(String[] args)
    {
        String[] str = {"spring/context-config.xml", "spring/job-config.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(str);
        Job job = (Job) ctx.getBean("dbToXml");
        JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
        try{
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Execution Status: "+ execution.getStatus());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
