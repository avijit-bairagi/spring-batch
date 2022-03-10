package com.ovi.springbatch.batch.step2;

import com.ovi.springbatch.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class Step2ItemReaderConfig {

    @Bean
    public CustomJpaPagingItemReader<Customer> customerJpaPagingItemReader(EntityManagerFactory entityManagerFactory) {
        CustomJpaPagingItemReader<Customer> customJpaPagingItemReader = new CustomJpaPagingItemReader<>();
        customJpaPagingItemReader.setName("customerItemReader");
        customJpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
        customJpaPagingItemReader.setPageSize(5);
        customJpaPagingItemReader.setQueryString("select c from Customer c where c.isVerified = 0");

        return customJpaPagingItemReader;
    }
}
