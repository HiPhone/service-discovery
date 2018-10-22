package org.hiphone.consul.service;

import org.hiphone.consul.entity.ResultMessage;

/**
 * @author HiPhone
 */
public interface ValueOperationService {

    /**
     * 加法
     * @param elementA 加法参数A
     * @param elementB 加法参数B
     * @return 封装的结果值
     */
     ResultMessage add(int elementA, int elementB);
}
