package com.ovi.springbatch.batch.step1;

import com.ovi.springbatch.entity.Customer;
import com.ovi.springbatch.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Step1Processor implements ItemProcessor<Employee, Customer> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Customer process(Employee item) {

        logger.info("Processing: {}", item);

        Customer customer = new Customer();
        customer.setName(item.getName());
        customer.setEmail(item.getEmail());
        customer.setPassword(UUID.randomUUID().toString());
        customer.setVerified(false);
        return customer;
    }
}