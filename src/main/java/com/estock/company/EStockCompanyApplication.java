package com.estock.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EStockCompanyApplication {
	/*
	 * @Bean public TimedAspect timedAspect(MeterRegistry registry) { return new
	 * TimedAspect(registry); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(EStockCompanyApplication.class, args);
	}

}
