package com.ovi.springbatch.batch.step2;

import com.ovi.springbatch.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Step2Processor implements ItemProcessor<Customer, Customer> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Customer process(Customer item) {

        logger.info("Processing: {}", item);

        item.setVerified(true);
        return item;
    }
}