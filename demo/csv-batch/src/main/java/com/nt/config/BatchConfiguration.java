package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.itemProcesser.PersonItemProcesser;
import com.nt.person.Person;

@Configuration
public class BatchConfiguration {

    
	
	
	@Bean
	public FlatFileItemReader<Person> reader(){
		
		System.out.println("BatchConfiguration.reader()");
	
		return new FlatFileItemReaderBuilder<Person>()
				   .name("PersonItemReader")
				   .resource(new ClassPathResource("sample-data.csv"))
				   .delimited()
				   .names("firstName","lastName")
				   .targetType(Person.class)
				   .build();
		
		
		
	}
	
	@Bean
	public PersonItemProcesser processor() {

		System.out.println("BatchConfiguration.processor()");
		
		return new PersonItemProcesser();
	}
	
	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource){
		
		System.out.println("BatchConfiguration.writer()");
		
		return new JdbcBatchItemWriterBuilder<Person>()
				   .sql("insert into people(first_name,last_name)values(:firstName,:lastName)")
				   .dataSource(dataSource)
				   .beanMapped()
				   .build();
		
		
	}
	/*@Bean
	public JpaItemWriter<Person> writer(EntityManagerFactory entityManagerFactory) {
	    JpaItemWriter<Person> writer = new JpaItemWriter<>();
	          writer
	         .setEntityManagerFactory(entityManagerFactory);
	          return writer;
	}
	*/
	@Bean
	public Job importUserJob(JobRepository jobRepository ,Step step1) {
		
          System.out.println("BatchConfiguration.importUserJob()"+jobRepository.toString());
		
		return new JobBuilder("importUserJob",jobRepository)
				   
				   .start(step1)
				   .build();
		
		
	}
	
	
	@Bean
	public Step step1(JobRepository jobRespository ,PlatformTransactionManager dataSourceTransactionManager,
			          FlatFileItemReader<Person> reader,PersonItemProcesser processer ,JdbcBatchItemWriter<Person> writer) {
				System.out.println("BatchConfiguration.step1()");
		return new StepBuilder("step1",jobRespository)
				   .<Person,Person>chunk(4,dataSourceTransactionManager)
				   .reader(reader)
				   .writer(writer)
				   .build();
		
		
	}
	
	
	

}
