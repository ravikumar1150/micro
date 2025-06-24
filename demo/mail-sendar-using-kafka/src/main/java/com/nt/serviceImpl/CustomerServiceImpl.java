package com.nt.serviceImpl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.Customer;
import com.nt.maill.CustomerMail;
import com.nt.repo.CustomerRepo;
import com.nt.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CustomerMail customerMail;

	@Override
	public void customerSave(Customer customer) throws Exception {

		customerRepo.save(customer);

		long start = System.currentTimeMillis();
		

		/*
		 * customerMail.sendMail(customer.getCEmail(), "SucessMessage", "Dear    " +
		 * customer.getCName().toUpperCase() +
		 * ",\n\nYour registration is successful.\n\nThanks,\nTeam");
		 */
		
		String img = "C:\\Users\\Ravikumar\\Pictures\\Screenshots\\im.png";
		
		String to = customer.getCEmail();
		String subject = "Success Message";
		String text = "Dear " + customer.getCName().toUpperCase() 
		            + ",<br><br>Your registration is successful.<br><br>Thanks,<br>Team";
		
		customerMail.sendMail(to, subject, text, img);

		long end = System.currentTimeMillis();
		
		
		
		System.out.println(start - end);
		
		CustomerServiceImpl.timecalculate(start, end);

	}
	
	public  static void   timecalculate(long start,long end) {
		
	long tota=	start-end;
		
		System.out.println(tota);
		
	}

}
