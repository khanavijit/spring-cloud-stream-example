package com.javatechie.spring.cloud.stream.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String to;
    private String cc;
    private String body;

}
