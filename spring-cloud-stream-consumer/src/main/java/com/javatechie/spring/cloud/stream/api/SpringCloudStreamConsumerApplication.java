package com.javatechie.spring.cloud.stream.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamConsumerApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

    /*@StreamListener("input")
    public void consumeMessage(Email email) {
        log.info("Received...{} {} for {} ", email.getTo(), email.getCc(), email.getBody());
    }*/


    @StreamListener("input")
    public void consumeMessage(@Payload OsmEvent osmEvent, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY)String  key) {

            log.info("Received...{} {} for {} ", osmEvent.getEventdate(),osmEvent.getEventstatus(),key);



    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
    }

}
