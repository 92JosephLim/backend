
package com.adamsoft.chat_front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.adamsoft.chat_front.repository")
public class ChatFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatFrontApplication.class, args);
    }
}

