package org.edu.ka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SplunkTryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SplunkTryApplication.class, args);
		SplunkLogWriter logWriter = context.getBean(SplunkLogWriter.class);
		logWriter.generateLogMessages();
	}
}
