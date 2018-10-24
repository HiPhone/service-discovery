package org.hiphone.consul.service;

import org.hiphone.consul.entity.ResultMessage;
import org.hiphone.consul.entity.User;

/**
 * @author HiPhone
 */
public interface UserService {

    /**
     * 判断用户是否登陆成功的方法
     * @param user 用户封装信息
     * @return ResultMessage
     */
    ResultMessage userLogin(User user);
}
