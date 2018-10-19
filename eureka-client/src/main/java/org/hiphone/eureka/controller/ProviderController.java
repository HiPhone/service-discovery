package org.hiphone.eureka.controller;

import org.hiphone.eureka.entity.ResultMessage;
import org.hiphone.eureka.service.ValueOperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiPhone
 */
@RestController
public class ProviderController {

    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private ValueOperateService valueOperateService;

    @GetMapping("/value/add")
    public ResultMessage getAddResult(@RequestParam(name = "a") int a,
                                       @RequestParam(name = "b") int b) {
        logger.info("Received a request for adding a and b, a = {}, b = {}", a, b);
        return valueOperateService.add(a, b);
    }
}
