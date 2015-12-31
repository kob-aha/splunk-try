package org.edu.ka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SplunkLogWriter {

    private static final Logger logger = LoggerFactory.getLogger(SplunkTryApplication.class);

    public void generateLogMessages() {
        logger.info("Start writing log messages");

        int messagesNum = 20;
        for (int i = 0; i < messagesNum; i++) {
            logger.info("Writing log message number {} out of {}", i, messagesNum);
        }

        logger.info("Finish writing log messages");
    }

}
