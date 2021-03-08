package com.crazyandcoder.bible.model.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateReq implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String userNickName;
    private String userAvatar;
    private String userAddress;
    private String userCity;
    private String userPhone;
    private String userEmail;
    private String userIntroduction;
    private int userAge;
    private int userGender;

}
