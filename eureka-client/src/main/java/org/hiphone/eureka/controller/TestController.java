package org.hiphone.eureka.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiPhone
 */
@RestController
@Api(value = "TestController", description = "用于测试服务是否存活的Controller")
public class TestController {

    public static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @GetMapping("/echo-test")
    @ApiOperation(value = "用于确认服务是否存活的接口", notes = "返回自身状态")
    public String test() {
        logger.info("Receive a request for testing eureka client");

        return "Eureka Client is alive";
    }

}
