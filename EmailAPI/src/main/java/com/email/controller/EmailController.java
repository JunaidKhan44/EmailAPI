/**
 * 
 */
package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emai.model.EmailModel;
import com.emai.model.EmailResponse;
import com.email.services.EmailService;

/**
 * @author hp
 *
 */
@RestController
@CrossOrigin
public class EmailController {

	
//	localhost:8080/sendemail
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "hello this is email api";
	}
	
	
	//sending email 
	@RequestMapping(value="/sendEmailHandler",method=RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailModel  model){
		boolean flag=false;
		if(model != null && model.getTo() !=null
				&& model.getSubject() != null && model.getMessage() != null) {
			System.out.println(model);
			flag=this.emailService.sendEmail(model.getSubject(), model.getMessage(), model.getTo());
		
		}

		if(flag) {
			return ResponseEntity.ok(new EmailResponse("Email is sent successfully..."));
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email sending failed..."));
		
	}
}
