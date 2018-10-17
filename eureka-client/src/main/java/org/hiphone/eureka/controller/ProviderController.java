package org.hiphone.eureka.controller;

import org.hiphone.eureka.entity.ResultMessage;
import org.hiphone.eureka.service.ValueOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HiPhone
 */
@RestController
public class ProviderController {

    @Autowired
    private ValueOperateService valueOperateService;

    @GetMapping("/value/add")
    public ResultMessage getAddResult(@RequestParam(name = "a", required = true) int a,
                                       @RequestParam(name = "b", required = true) int b) {
        return valueOperateService.add(a, b);
    }
}
