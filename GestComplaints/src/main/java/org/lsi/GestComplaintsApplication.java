package org.lsi;

import javax.mail.MessagingException;

import org.lsi.services.EmailSenderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
@EnableDiscoveryClient
public class GestComplaintsApplication {

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(GestComplaintsApplication.class, args);
	}

	
}
