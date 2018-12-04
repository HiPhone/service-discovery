package org.hiphone.consul.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hiphone.consul.constants.Constant;
import org.hiphone.consul.entity.ResultMessage;
import org.hiphone.consul.entity.User;
import org.hiphone.consul.feign.FeignDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiPhone
 */
@Slf4j
@RestController
@Api(value = "ConsumerController", description = "消费者接口定义类")
public class ConsumerController {

    @Autowired
    private FeignDemoClient feignDemoClient;

    @ResponseBody
    @GetMapping("/call/feign/get")
    @ApiOperation(value = "远程GET调用生产者加法接口", notes = "使用Feign进行声明式调用")
    public ResultMessage getByFeign(@RequestParam(name = "a") @ApiParam(name = "a", value = "计算参数a") int a,
                                     @RequestParam(name = "b") @ApiParam(name = "b", value = "计算参数b") int b) {

        log.info("Constructed request url for ribbon restTemplate throw consul, request url is {}" );

        return feignDemoClient.getAddResult(a, b);
    }

    @ResponseBody
    @GetMapping("/call/feign/login")
    @ApiOperation(value = "远程POST调用用户登陆接口", notes = "使用feign进行登陆post调用")
    public ResultMessage postByFeign() {

        log.info("Starting to login...");

        User user = new User(Constant.USER_USERNAME, Constant.USER_PASSWORD);

        return feignDemoClient.userLogin(user);
    }

}
