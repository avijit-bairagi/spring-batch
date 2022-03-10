package com.ovi.springbatch.lintener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Step1ChunkListener implements ChunkListener {

    private final int chunkSize;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private long startTimeInMs;

    public Step1ChunkListener(@Value("${batch.chunk.step1.size}") int chunkSize) {
        this.chunkSize = chunkSize;
    }

    @Override
    public void beforeChunk(ChunkContext context) {
        startTimeInMs = System.currentTimeMillis();
    }

    @Override
    public void afterChunk(ChunkContext context) {
        long duration = System.currentTimeMillis() - startTimeInMs;
        logger.info("Job: {}, Step:{}, Chunk of size: {} computed in: {}sms",
                context.getStepContext().getJobName(), context.getStepContext().getStepName(),
                chunkSize, duration);
    }

    @Override
    public void afterChunkError(ChunkContext context) {


    }
}