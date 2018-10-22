package org.hiphone.consul.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hiphone.consul.entity.ResultMessage;
import org.hiphone.consul.service.ValueOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiPhone
 */
@RestController
@Api(value = "ProviderController", description = "生产者的接口定义类")
public class ProviderController {

    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private ValueOperationService valueOperationService;

    @ResponseBody
    @GetMapping("/value/add")
    @ApiOperation(value = "计算加法", notes = "根据传入的a和b的值计算a + b")
    public ResultMessage getAddResult(@RequestParam(name = "a") @ApiParam(name = "a", value = "计算参数a") int a,
                                      @RequestParam(name = "b") @ApiParam(name = "b", value = "计算参数b") int b) {

        logger.info("Received a request for adding a and b, a = {}, b = {}", a, b);

        return valueOperationService.add(a, b);
    }
}
