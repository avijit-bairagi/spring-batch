package com.ovi.springbatch.batch.step1;

import com.ovi.springbatch.entity.Customer;
import com.ovi.springbatch.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Step1Writer implements ItemWriter<Customer> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomerRepository customerRepository;

    public Step1Writer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void write(List<? extends Customer> items) {

        logger.info("Write data size: {}", items.size());

        customerRepository.saveAll(items);
    }
}