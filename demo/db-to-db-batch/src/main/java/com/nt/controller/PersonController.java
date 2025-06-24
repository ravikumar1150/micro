package com.nt.controller;

import com.nt.DbToDbBatchApplication;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/p")
public class PersonController {

    private final DataSource dataSource;

    private final DbToDbBatchApplication dbToDbBatchApplication;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    PersonController(DbToDbBatchApplication dbToDbBatchApplication, DataSource dataSource) {
        this.dbToDbBatchApplication = dbToDbBatchApplication;
        this.dataSource = dataSource;
    }

    @GetMapping("/job")
    public String startJob() {
    	System.out.print("pathc recor");
        try {
        
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            JobExecution execution = jobLauncher.run(job, jobParameters);
            return "Job Status: " + execution.getStatus();
        } catch (Exception e) {
            return "Job failed: " + e.getMessage();
        }
    }
}
