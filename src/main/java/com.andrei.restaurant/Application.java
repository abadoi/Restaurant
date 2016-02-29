package com.andrei.restaurant;

/**
 * Created by andreibadoi on 29/02/16.
 */

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.context.annotation.*;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan
@Configuration

public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}
@RestController
class GreetingController {

    @RequestMapping
    String hello() {
        return "Hello, !:P";
    }
}
