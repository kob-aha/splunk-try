package org.edu.ka;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SplunkTryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SplunkTryApplication.class, args);
		SplunkLogWriter logWriter = context.getBean(SplunkLogWriter.class);
		logWriter.generateLogMessages();

		// Clean up resources used by logback
		// assume SLF4J is bound to logback-classic in the current environment
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		loggerContext.stop();
	}
}
