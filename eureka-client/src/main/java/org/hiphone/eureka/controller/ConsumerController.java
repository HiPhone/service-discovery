package org.hiphone.eureka.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hiphone.eureka.entity.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate loadBalanced;

    @ResponseBody
    @GetMapping("/call/origin/get")
    @ApiOperation(value = "远程GET调用生产者加法接口", notes = "使用原生restTemplate进行远程调用")
    public ResultMessage getByOrigin(@RequestParam(name = "a") @ApiParam(name = "a", value = "计算参数a") int a,
                                       @RequestParam(name = "b") @ApiParam(name = "b", value = "计算参数b") int b) {

        String requestUrl = "http://localhost:8080/value/add?a=" + a + "&b=" + b;
        logger.info("Constructed request url for origin restTemplate, request url is {}", requestUrl );

        HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());

        return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, ResultMessage.class).getBody();
    }

    @ResponseBody
    @GetMapping("/call/eureka/get")
    @ApiOperation(value = "远程GET调用生产者加法接口", notes = "使用Ribbon的restTemplate进行远程调用")
    public ResultMessage getByEureka(@RequestParam(name = "a") @ApiParam(name = "a", value = "计算参数a") int a,
                                       @RequestParam(name = "b") @ApiParam(name = "b", value = "计算参数b") int b) {

        String requestUrl = "http://eureka-client/value/add?a=" + a + "&b=" + b;
        logger.info("Constructed request url for eureka restTemplate, request url is {}", requestUrl );

        return loadBalanced.getForEntity(requestUrl, ResultMessage.class).getBody();
    }

    /**
     * 展示post请求的用法，eureka的restTemplate换成loadBalanced即可
     * @return
     */
    @ResponseBody
    @GetMapping("/call/origin/post")
    @ApiOperation(value = "远程POST调用用户登陆接口", notes = "原生restTemplate调用用户登陆接口,带上header信息")
    public ResultMessage postByOrigin() {
        String requestUrl = "http://localhost:8080/user/login";

        logger.info("Starting to login...");

        HttpHeaders headers = new HttpHeaders();
        JSONObject loginData = new JSONObject();
        loginData.put("username", "hiphone");
        loginData.put("password", "hiphoneX");
        HttpEntity<JSONObject> entity = new HttpEntity<>(loginData, headers);

        return restTemplate.postForEntity(requestUrl, entity, ResultMessage.class).getBody();
    }

}
