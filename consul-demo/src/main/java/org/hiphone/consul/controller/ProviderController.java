package org.hiphone.consul.controller;

import com.netflix.client.http.HttpRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hiphone.consul.entity.ResultMessage;
import org.hiphone.consul.entity.User;
import org.hiphone.consul.service.UserService;
import org.hiphone.consul.service.ValueOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HiPhone
 */
@Slf4j
@RestController
@Api(value = "ProviderController", description = "生产者的接口定义类")
public class ProviderController {

    @Autowired
    private ValueOperationService valueOperationService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/value/add")
    @ApiOperation(value = "计算加法", notes = "根据传入的a和b的值计算a + b")
    public ResultMessage getAddResult(@RequestParam(name = "a") @ApiParam(name = "a", value = "计算参数a") int a,
                                      @RequestParam(name = "b") @ApiParam(name = "b", value = "计算参数b") int b) {

        log.info("Received a request for adding a and b, a = {}, b = {}", a, b);

        return valueOperationService.add(a, b);
    }

    @ResponseBody
    @PostMapping("/user/login")
    @ApiOperation(value = "用户登陆接口", notes = "用户登陆，并解析header的数据")
    public ResultMessage userLogin(@ApiParam(name = "httpRequest", value = "http请求信息") HttpRequest httpRequest,
                                   @ApiParam(name = "user", value = "用户登陆的请求体，转换为User") @RequestBody User user) {
        log.info("Receive a login request...start to check username and password");

        return userService.userLogin(user);
    }

}
