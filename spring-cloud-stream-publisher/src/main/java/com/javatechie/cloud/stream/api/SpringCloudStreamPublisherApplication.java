package com.javatechie.cloud.stream.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class SpringCloudStreamPublisherApplication {
    @Autowired
    private MessageChannel output;

    /*@PostMapping("/publish")
    public Email publishEvent(@RequestBody Email email) {



        output.send(MessageBuilder.withPayload(email)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "abc123".getBytes())
                .build());
        return email;
    }*/

    @PostMapping("/publish")
    public OsmEvent publishEvent(@RequestBody OsmEvent osmEvent) {

        System.out.println("publish event ..");

        output.send(MessageBuilder.withPayload(osmEvent)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "abc123".getBytes())
                .build());
        return osmEvent;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
    }

}
