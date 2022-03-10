package com.ovi.springbatch.batch.step2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;

public class CustomJpaPagingItemReader<T> extends JpaPagingItemReader<T> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected T doRead() throws Exception {
        T item = super.doRead();
        log.info("Reading customer = {}", item);
        return item;
    }

}