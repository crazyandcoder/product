package com.crazyandcoder.bible.model.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdatePwdReq implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userNormalPassword;
    private String userPassword;
    private String userPrePassword;
    private String userId;

}
