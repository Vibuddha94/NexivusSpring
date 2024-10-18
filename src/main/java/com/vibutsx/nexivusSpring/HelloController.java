package com.vibutsx.nexivusSpring;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getMethodName() {
        String hello = "Hello Nexivus";
        return hello;
    }
    
}
