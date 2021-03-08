package com.crazyandcoder.bible.model.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserGetReq implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String userName;
}
