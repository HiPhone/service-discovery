package org.hiphone.consul.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hiphone.consul.entity.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author HiPhone
 */
@RestController
@Api(value = "ConsumerController", description = "消费者接口定义类")
public class ConsumerController {

    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate loadBalanced;

    @ResponseBody
    @GetMapping("/call/consul/get")
    @ApiOperation(value = "远程GET调用生产者加法接口", notes = "使用Ribbon的restTemplate进行远程调用")
    public ResultMessage getByEureka(@RequestParam(name = "a") @ApiParam(name = "a", value = "计算参数a") int a,
                                     @RequestParam(name = "b") @ApiParam(name = "b", value = "计算参数b") int b) {

        String requestUrl = "http://consul-demo/value/add?a=" + a + "&b=" + b;
        logger.info("Constructed request url for ribbon restTemplate throw consul, request url is {}", requestUrl );

        return loadBalanced.getForEntity(requestUrl, ResultMessage.class).getBody();
    }
}
