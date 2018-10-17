package org.hiphone.eureka.service;

import org.hiphone.eureka.entity.ResultMessage;

/**
 * @author HiPhone
*/
public interface ValueOperateService {

    /**
     * 加法
     * @param elementA 加法参数A
     * @param elementB 加法参数B
     * @return 封装的结果值
     */
    ResultMessage add(int elementA, int elementB);
}
