package com.ovi.springbatch.batch.step1;

import com.ovi.springbatch.batch.step1.listener.Step1ChunkListener;
import com.ovi.springbatch.batch.step1.listener.Step1ExecutionListener;
import com.ovi.springbatch.entity.Customer;
import com.ovi.springbatch.model.Employee;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step1Config {

    private final StepBuilderFactory stepBuilderFactory;

    private final FlatFileItemReader<Employee> flatFileItemReader;

    private final Step1Processor step1Processor;

    private final Step1Writer step1Writer;

    private final Step1ChunkListener step1ChunkListener;

    private final Step1ExecutionListener step1ExecutionListener;

    private final int chunkSize;

    public Step1Config(StepBuilderFactory stepBuilderFactory,
                       FlatFileItemReader<Employee> flatFileItemReader,
                       Step1Processor step1Processor,
                       Step1Writer step1Writer,
                       Step1ChunkListener step1ChunkListener,
                       Step1ExecutionListener step1ExecutionListener,
                       @Value("${batch.chunk.step1.size}") int chunkSize) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.flatFileItemReader = flatFileItemReader;
        this.step1Processor = step1Processor;
        this.step1Writer = step1Writer;
        this.step1ChunkListener = step1ChunkListener;
        this.step1ExecutionListener = step1ExecutionListener;
        this.chunkSize = chunkSize;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("file-processing-step")
                .<Employee, Customer>chunk(chunkSize)
                .reader(flatFileItemReader)
                .processor(step1Processor)
                .writer(step1Writer)
                .listener(step1ChunkListener)
                .listener(step1ExecutionListener)
                .build();
    }
}
