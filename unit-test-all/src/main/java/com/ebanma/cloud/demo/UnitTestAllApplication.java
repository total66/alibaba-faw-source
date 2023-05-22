package com.ebanma.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {com.ebanma.cloud.demo.data.dao.UserDao.class})
public class UnitTestAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestAllApplication.class, args);
	}

}
