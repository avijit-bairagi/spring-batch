package com.ovi.springbatch.batch.step1.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class Step1ExecutionListener implements StepExecutionListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void beforeStep(StepExecution stepExecution) {

        logger.info("Step: {} started with exit status: {}, batch status: {}.",
                stepExecution.getStepName(), stepExecution.getExitStatus(), stepExecution.getStatus());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        logger.info("Step: {} finished with exit status: {}, batch status: {}.",
                stepExecution.getStepName(), stepExecution.getExitStatus(), stepExecution.getStatus());

        return stepExecution.getExitStatus();
    }
}
