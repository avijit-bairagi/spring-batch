package com.ovi.springbatch.config;

import com.ovi.springbatch.lintener.MyJobExecutionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final Step step1;

    private final Step step2;

    private final MyJobExecutionListener jobExecutionListener;

    public SpringJobConfig(JobBuilderFactory jobBuilderFactory,
                           Step step1, Step step2,
                           MyJobExecutionListener jobExecutionListener) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.step1 = step1;
        this.step2 = step2;
        this.jobExecutionListener = jobExecutionListener;
    }

    @Bean
    public Job job1() {

        return jobBuilderFactory
                .get("file-processing")
                .incrementer(new RunIdIncrementer())
                .listener(jobExecutionListener)
                .start(step1)
                .next(step2)
                .build();
    }

    @Bean
    public Job job2() {

        return jobBuilderFactory
                .get("file-processing-2")
                .incrementer(new RunIdIncrementer())
                .listener(jobExecutionListener)
                .start(step1)
                .next(step2)
                .build();
    }
}
