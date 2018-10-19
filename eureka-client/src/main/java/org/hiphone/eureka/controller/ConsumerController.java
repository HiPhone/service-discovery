package org.hiphone.eureka.controller;

import org.hiphone.eureka.entity.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author HiPhone
 */
@RestController
public class ConsumerController {

    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate loadBalanced;

    @GetMapping("/call/origin")
    public ResultMessage callByOrigin(@RequestParam(name = "a")int a,
                                       @RequestParam(name = "b")int b) {
        String requestUrl = "http://localhost:8080/value/add?a=" + a + "&b=" + b;
        logger.info("Constructed request url for origin restTemplate, request url is {}", requestUrl );
        return restTemplate.getForEntity(requestUrl, ResultMessage.class).getBody();
    }

    @GetMapping("/call/eureka")
    public ResultMessage callByEureka(@RequestParam(name = "a")int a,
                                       @RequestParam(name = "b")int b) {
        String requestUrl = "http://eureka-client/value/add?a=" + a + "&b=" + b;
        logger.info("Constructed request url for eureka restTemplate, request url is {}", requestUrl );
        return loadBalanced.getForEntity(requestUrl, ResultMessage.class).getBody();
    }
}
