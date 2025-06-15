package com.nt.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonBatchController {

	@Autowired
	private JobLauncher jobLancher;

	@Autowired
	private Job job;

	@GetMapping("/launch")
	public String jobExecutor() {
		
		System.out.println("PersonBatchController.jobExecutor()");

		try {

			JobParameters jobParameter = new JobParametersBuilder()

					.addLong("startAt", System.currentTimeMillis()).toJobParameters();

			JobExecution jobExecution = jobLancher.run(job, jobParameter);

			return "Job Execution Status" + jobExecution.getStatus();

		} catch (Exception e) {

			return "Job Not Executed DueTo" + e.getMessage();

		}

	}

}
