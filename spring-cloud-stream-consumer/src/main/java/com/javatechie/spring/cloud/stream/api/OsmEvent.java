package com.javatechie.spring.cloud.stream.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OsmEvent {

    private String eventdate;
    private String eventstatus;


}
