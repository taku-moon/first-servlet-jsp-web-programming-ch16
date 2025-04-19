package com.example.ch16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FirstServletJspWebProgrammingCh16Application {

	public static void main(String[] args) {
		SpringApplication.run(FirstServletJspWebProgrammingCh16Application.class, args);
	}

}
