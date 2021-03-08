package com.crazyandcoder.bible.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户登录密码MD5加密后
     */
    private String userPassword;

    /**
     * 原始密码
     */
    private String userNormalPassword;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户性别
     * 0：未知
     * 1：男
     * 2：女
     */
    private Integer userGender;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户地址
     */
    private String userAddress;

    /**
     * 用户所在城市
     */
    private String userCity;

    /**
     * 用户简介
     */
    private String userIntroduction;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;


}
