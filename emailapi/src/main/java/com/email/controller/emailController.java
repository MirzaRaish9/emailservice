package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.email.model.emailRequest;
import com.email.service.emailService;

@RestController
public class emailController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private emailService eservice;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return " this is email api";
	}
	
	//api send 
	@PostMapping(value = "/sendemail"  )
	public ResponseEntity<?> sendEmail(@RequestBody emailRequest req ){
		
		System.out.println(req);
		boolean result = this.eservice.sendEmail(req.getSubject(), req.getMessage(), req.getTo());
		
		
		
		
		if(result ) {
			ResponseEntity<String> noti = restTemplate.exchange("http://localhost:8082/unotification/email/USER_1", HttpMethod.GET, null, String.class);
			ResponseEntity<String> user = restTemplate.exchange("http://localhost:8081/person/name/USER_1", HttpMethod.GET, null, String.class);
			emailRequest e = new emailRequest();
			e.setTo(user.getBody());
			e.setMessage(noti.getBody());
			
			//return ResponseEntity.ok(e);
			return ResponseEntity.ok("done!! Email sent successfully ."+e);
		} else {
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent .");
			
		}
		
		
	}
	
	
}
