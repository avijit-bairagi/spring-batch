package com.ovi.springbatch.batch.step2;

import com.ovi.springbatch.entity.Customer;
import com.ovi.springbatch.lintener.Step2ChunkListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step2Config {

    private final StepBuilderFactory stepBuilderFactory;

    private final CustomJpaPagingItemReader<Customer> customerJpaPagingItemReader;

    private final Step2Processor step2Processor;

    private final Step2Writer step2Writer;

    private final Step2ChunkListener step2ChunkListener;

    private final int chunkSize;

    public Step2Config(StepBuilderFactory stepBuilderFactory,
                       CustomJpaPagingItemReader<Customer> customerJpaPagingItemReader,
                       Step2Processor step2Processor,
                       Step2Writer step2Writer,
                       Step2ChunkListener step2ChunkListener,
                       @Value("${batch.chunk.step2.size}") int chunkSize) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.customerJpaPagingItemReader = customerJpaPagingItemReader;
        this.step2Processor = step2Processor;
        this.step2Writer = step2Writer;
        this.step2ChunkListener = step2ChunkListener;
        this.chunkSize = chunkSize;
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory
                .get("customer-processing-step")
                .<Customer, Customer>chunk(chunkSize)
                .reader(customerJpaPagingItemReader)
                .processor(step2Processor)
                .writer(step2Writer)
                .listener(step2ChunkListener)
                .build();
    }
}
