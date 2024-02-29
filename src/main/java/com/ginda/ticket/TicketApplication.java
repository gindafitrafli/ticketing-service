package com.ginda.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(scanBasePackages = {"com.ginda.ticket"}, exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.ginda.ticket"})
public class TicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketApplication.class, args);
	}

}
