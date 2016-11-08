package com.tw.study.springboot.endpoint;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/api/name")
public class Endpoint {

    @GET
    public String message() {
        return "Hello";
    }

}