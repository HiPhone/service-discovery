package org.hiphone.eureka.service.impl;

import org.hiphone.eureka.constants.ReturnCode;
import org.hiphone.eureka.entity.ResultMessage;
import org.hiphone.eureka.service.ValueOperateService;
import org.springframework.stereotype.Service;

/**
 * @author HiPhone
 */
@Service
public class ValueOperateServiceImpl implements ValueOperateService {

    @Override
    public ResultMessage add(int elementA, int elementB) {
        return new ResultMessage(ReturnCode.SUCCESS.getCode(),
                 ReturnCode.SUCCESS.getMessage(),
                        elementA + elementB );
    }
}
