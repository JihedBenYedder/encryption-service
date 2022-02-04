package com.richemont.ccp.encryptionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.vault.authentication.SessionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EncryptionServiceApplication {

	@Autowired
	private SessionManager sessionManager;

	public static void main(String[] args) {
		SpringApplication.run(EncryptionServiceApplication.class, args);
	}

	@PostConstruct
	public void initIt() throws Exception {
		System.out.println("Got Vault Token: " + sessionManager.getSessionToken().getToken());
	}

}
