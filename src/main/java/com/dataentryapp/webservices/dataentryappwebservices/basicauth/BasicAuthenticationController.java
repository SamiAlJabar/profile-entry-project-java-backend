package com.dataentryapp.webservices.dataentryappwebservices.basicauth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class BasicAuthenticationController {
	
	@GetMapping(path="/basicauth")
	public BasicAuthentication getAuth() {
		return new BasicAuthentication("Successfully authenticated!");
	}
}
