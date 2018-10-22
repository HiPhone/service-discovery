package org.hiphone.consul.service.impl;

import org.hiphone.consul.constants.ReturnCode;
import org.hiphone.consul.entity.ResultMessage;
import org.hiphone.consul.service.ValueOperationService;
import org.springframework.stereotype.Service;

@Service
public class ValueOperationServiceImpl implements ValueOperationService {

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
