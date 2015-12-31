package org.edu.ka;

import com.splunk.Service;
import com.splunk.TcpInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SplunkLogWriter {

    private static final Logger logger = LoggerFactory.getLogger(SplunkTryApplication.class);

    public void generateLogMessages() {
        logger.info("Start writing log messages");

        int messagesNum = 20;
        for (int i = 0; i < messagesNum; i++) {
            logger.info("Writing log message num={} out of {}", i, messagesNum);
        }

        logger.info("Finish writing log messages");
    }

    public void socketWrite() throws IOException {

        Service service = new Service("localhost", 8000);

        // Retrieve the input
        TcpInput myInput = (TcpInput)service.getInputs().get("10000");

// Open a socket
        Socket socket = myInput.attach();

// Wrap the socket in a try block so we can close it in case of an error
        try {
            OutputStream ostream = socket.getOutputStream();
            Writer out = new OutputStreamWriter(ostream, "UTF8");

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
            String date = dateFormat.format(new Date());

            // Send events to the socket then close it
            out.write(date + "Event one!\r\n");
            out.write(date + "Event two!\r\n");
            out.flush();
        } finally {
            socket.close();
        }
    }

}
