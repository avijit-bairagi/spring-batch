package com.ovi.springbatch.controller;

import com.ovi.springbatch.service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BatchService batchService;

    public LoadController(BatchService batchService) {
        this.batchService = batchService;
    }

    @GetMapping("/job1")
    public String loadJob1() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {

        batchService.loadJob1();
        logger.info("JobExecution: {}", "invoked");
        return "job1-Ok";
    }

    @GetMapping("/job2")
    public String loadJob2() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {

        batchService.loadJob2();
        logger.info("JobExecution: {}", "invoked");
        return "Ok-job2";
    }

    @GetMapping("/job3")
    public String loadJob3() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {

        batchService.loadJob3();
        logger.info("JobExecution: {}", "invoked");
        return "Ok-job3";
    }
}