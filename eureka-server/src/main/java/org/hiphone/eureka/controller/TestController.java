package org.hiphone.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiPhone
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @GetMapping("/echo-test")
    public String test() {
        logger.info("Receive a request for testing eureka server");

        return "Eureka Server is alive";
    }
}
