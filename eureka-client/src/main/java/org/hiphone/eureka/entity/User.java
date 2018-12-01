package org.hiphone.eureka.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author HiPhone
 */
@Getter
@Setter
@ApiModel(value = "User", description = "用户定义的java bean")
public class User implements Serializable {

    private static final long serialVersionUID = 9090193765846268264L;

    @ApiModelProperty(name = "username", value = "用户名")
    private String username;

    @ApiModelProperty(name = "password", value = "密码")
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
