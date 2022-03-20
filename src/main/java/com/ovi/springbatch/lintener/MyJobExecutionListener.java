package com.ovi.springbatch.lintener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class MyJobExecutionListener implements JobExecutionListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void beforeJob(JobExecution jobExecution) {

        logger.info("Job: {} started with batch status: {}, exit status: {}",
                jobExecution.getJobConfigurationName(), jobExecution.getStatus(), jobExecution.getExitStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        logger.info("Job: {} finished with batch status: {}, exit status: {}",
                jobExecution.getJobConfigurationName(), jobExecution.getStatus(), jobExecution.getExitStatus());
    }
}
