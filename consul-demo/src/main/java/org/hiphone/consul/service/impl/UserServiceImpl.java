package org.hiphone.consul.service.impl;

import org.hiphone.consul.constants.Constant;
import org.hiphone.consul.constants.ReturnCode;
import org.hiphone.consul.entity.ResultMessage;
import org.hiphone.consul.entity.User;
import org.hiphone.consul.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author HiPhone
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public ResultMessage userLogin(User user) {

        ResultMessage resultMessage;

        if (user.getUsername().equals(Constant.USER_USERNAME) && user.getPassword().equals(Constant.USER_PASSWORD)) {
            resultMessage = new ResultMessage(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMessage(), Constant.LOGIN_SUCCESS);
        } else {
            resultMessage = new ResultMessage(ReturnCode.UNAUTHORIZED.getCode(), ReturnCode.UNAUTHORIZED.getMessage(), Constant.LOGIN_FAIL);
        }
        return resultMessage;
    }

}