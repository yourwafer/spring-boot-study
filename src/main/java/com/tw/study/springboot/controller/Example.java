package com.tw.study.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hwwei on 2016/11/8.
 */
@RestController
@RequestMapping("example")
public class Example {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
