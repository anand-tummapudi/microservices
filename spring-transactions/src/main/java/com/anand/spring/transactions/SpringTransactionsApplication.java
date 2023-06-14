package com.anand.spring.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionsApplication.class, args);
	}

}
