package com.edu.QickJob.controller;



import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.QucikJob.dal.UserRepository;
import com.edu.QucikJob.dal.Userdao;
import com.edu.QucikJob.dal.WorkRepository;
import com.edu.QucikJob.dal.Workdao;

@RestController("QuickJobDB")
public class Controller {

	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	public Userdao WorkerProfile;
	public Workdao DelarProfile;

	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private WorkRepository WorkRepository;
	
	private final UserRepository repo;
	private final WorkRepository Wrepo;
	
	@Autowired
	public Controller(UserRepository repo,WorkRepository Wrepo) {
		this.repo = repo;
		this.Wrepo = Wrepo;
	}
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@GetMapping("my")
	public String getStuff() {

		System.out.println("User count: " + repo.count());
		return "All clear";

	}

	@PostMapping("formSubmit")
	public void onSubmit(@RequestBody Userdao s) {

		log.info("{}", s);
		System.out.println(s.getUserName());
		java.util.List<Userdao> customers = UserRepository.findAll();
		
		int number=(int) (Math.random()*1000);
		Userdao contor;
		for(int i=0;i<customers.size();i++) {
			contor=customers.get(i);
			if(contor.getId_number()==number) {
				number=(int) (Math.random()*1000);
				i=0;
			}
		}
		s.setId_number(number);
        //s.setId_number(customers.size()+1);
		repo.save(s);

	}
	
	@PostMapping("SaveDataWProfile")
	public void SaveWProfile(@RequestBody Userdao s) {

		log.info("{}", s);
		System.out.println(s.getId_number());
		repo.save(s);

	}

	@PostMapping("LogInSubmit")
	public String LogInSubmit(@RequestBody Userdao login) {

		log.info("{}", login);

		
		java.util.List<Userdao> customers = UserRepository.findAll();

		for (Userdao c : customers) {

			if (c.getUserName().equals(login.getUserName()) && c.getPassword().equals(login.getPassword())) {
		
		
				log.info("yes is good {}",c.getUserName());
				WorkerProfile=c;
				return "http://localhost:8080/QuickJob/Choice/WorkChoice.html";
			}
		}
		return "http://localhost:8080/QuickJob/MainPage/QuickJobLogIn.html";
	}
	
	@PostMapping("workerProfiledate")
	public Userdao getDateforWorkerProfiel() {
     
		
		java.util.List<Userdao> customers = UserRepository.findAll();

		for (Userdao c : customers) {

			if (c.getUserName().equals(WorkerProfile.getUserName()) && c.getPassword().equals(WorkerProfile.getPassword())) {
		
		
				log.info("yes is good {}",c.getUserName());
				WorkerProfile=c;
				
			}
		}
	
		return WorkerProfile;
	}
	
	
	@PostMapping("FindWorkData")
	public java.util.List<Workdao> FindWorkData() {
		java.util.List<Workdao> wokrs = WorkRepository.findAll();
		return wokrs;
	}

	@PostMapping("DealarProfile")
	public Userdao DealarProfile(@RequestBody Workdao s) {
		
		s.setUserIdnumber(WorkerProfile.getId_number());
		
		java.util.List<Workdao> wokrs = WorkRepository.findAll();
		int number=(int) (Math.random()*1000);
		
		Workdao contor;
		for(int i=0;i<wokrs.size();i++) {
			contor=wokrs.get(i);
			if(contor.getId_number()==number) {
				number=(int) (Math.random()*1000);
				i=0;
			}
		}
		s.setId_number(number);
		
		
		Wrepo.save(s);
		return null;
	}
	
	
	
	@PostMapping("DealarProfiledate")
	public Workdao getDateforDealarProfiel() {
		
		  java.util.List<Workdao> customers = WorkRepository.findAll();
		  log.info("{}", customers.size());
	for (Workdao c : customers) { 
		
		 if (WorkerProfile.getId_number()==c.getId_number()) {
		  return c;
		  }
		 } 
		return null;
	}
	
	@PostMapping("ForgotPassword")
	
	public String ForgotPassword(@RequestBody Userdao ForgotPassword) {
	  
	  log.info("{}", ForgotPassword);
	  
	  ForgotPassword.sendemails(); java.util.List<Userdao> customers =
	  UserRepository.findAll();
	  
	  
	  for (Userdao c : customers) {
	  
	  if(c.getEmail().equals(ForgotPassword.getEmail())) {
	  
		  System.out.println(ForgotPassword.getUserName());
		  System.out.println(ForgotPassword.getPassword());
		  log.info("yes is good {}",c.getUserName());
		  
  		  SimpleMailMessage message=new SimpleMailMessage();
		  message.setTo(ForgotPassword.getEmail());
		  message.setSubject("QuickJob Password");
		  message.setText("Your password is"+c.getPassword());
		  javaMailSender.send(message);
		  
	  return "Exist"; 
	  	} 
	  
	  }
	  
	 return "Dont exist"; 
	 
	}
	
	@PostConstruct
	public void postConsruct() {
		System.err.println("Was here!");
	}
}
