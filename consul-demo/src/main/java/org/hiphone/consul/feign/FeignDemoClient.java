package org.hiphone.consul.feign;

import org.hiphone.consul.entity.ResultMessage;
import org.hiphone.consul.config.FeignClientConfiguration;
import org.hiphone.consul.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HiPhone
 */
@FeignClient(name = "consul-demo", configuration = FeignClientConfiguration.class)
public interface FeignDemoClient {

    /**
     * 定义feign调用的接口
     * @param a 参数a
     * @param b 参数b
     * @return 调用结果
     */
    @GetMapping("/value/add")
    ResultMessage getAddResult(@RequestParam(value = "a") int a , @RequestParam(value = "b") int b);

    /**
     * 基于feign用户登陆接口
     * @param user 用户封装信息
     * @return 调用结果
     */
    @PostMapping("/user/login")
    ResultMessage userLogin(@RequestBody User user);

}
