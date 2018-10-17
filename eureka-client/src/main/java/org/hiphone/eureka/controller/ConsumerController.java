package org.hiphone.eureka.controller;

import org.hiphone.eureka.entity.ResultMessage;
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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate loadBalanced;

    @GetMapping("/call/origin")
    public ResultMessage callByOrigin(@RequestParam(name = "a")int a,
                                       @RequestParam(name = "b")int b) {
        String requestUrl = "http://localhost:8080/value/add?a=" + a + "&b=" + b;
        return restTemplate.getForEntity(requestUrl, ResultMessage.class).getBody();
    }

    @GetMapping("/call/eureka")
    public ResultMessage callByEureka(@RequestParam(name = "a")int a,
                                       @RequestParam(name = "b")int b) {
        String requestUrl = "http://eureka-client/value/add?a=" + a + "&b=" + b;
        return loadBalanced.getForEntity(requestUrl, ResultMessage.class).getBody();
    }
}
