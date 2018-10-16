package org.hiphone.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiPhone
 */
@RestController
public class TestController {

    @GetMapping("/echo-test")
    public String test() {
        return "Eureka is alive";
    }
}
