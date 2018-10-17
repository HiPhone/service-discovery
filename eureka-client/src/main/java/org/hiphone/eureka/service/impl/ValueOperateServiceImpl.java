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
        ResultMessage resultMessage = new ResultMessage();
        int result = elementA + elementB;
        resultMessage.setCode(ReturnCode.SUCCESS.getCode());
        resultMessage.setMessage(ReturnCode.SUCCESS.getMessage());
        resultMessage.setData(result);
        return resultMessage;
    }
}
