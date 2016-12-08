package uk.co.redsoft.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class ExampleController {

    @Value("#{systemEnvironment['MESSAGE']}")
    private String message;

    @RequestMapping("/")
    public ExampleResponse home() {
        ExampleResponse messages = new ExampleResponse();
        messages.addMessage("Java system property (server.port): [" + System.getProperty("server.port") + "]");
        messages.addMessage("Environment variable via System.getenv(MESSAGE): [" + System.getenv("MESSAGE") + "]");
        messages.addMessage("Environment variable via @Value annotation (MESSAGE): [" + this.message + "]");

        return messages;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleController.class, args);
    }
    
    private static class ExampleResponse {
        private final List<String> message = new ArrayList<>();

        public void addMessage(String message) {
            this.message.add(message);
        }

        public List<String> getMessage() {
            return message;
        }
    }
}