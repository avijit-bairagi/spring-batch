package com.ovi.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final Step step1;

    private final Step step2;

    public SpringBatchConfig(JobBuilderFactory jobBuilderFactory,
                             Step step1, Step step2) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.step1 = step1;
        this.step2 = step2;
    }

    @Bean
    public Job job1() {

        return jobBuilderFactory
                .get("file-processing")
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .next(step2)
                .build();
    }
}
