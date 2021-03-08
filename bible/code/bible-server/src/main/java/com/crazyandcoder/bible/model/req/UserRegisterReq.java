package com.crazyandcoder.bible.model.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterReq implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String userPassword;
    private String userNormalPassword;
    private String userNickName;
    private String userName;
    private String userAvatar;
    private String userAddress;
    private String userCity;
    private String userPhone;
    private String userEmail;
    private String userIntroduction;
    private int userAge;
    private int userGender;

}
