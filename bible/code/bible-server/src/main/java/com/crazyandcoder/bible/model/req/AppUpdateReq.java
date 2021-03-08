package com.crazyandcoder.bible.model.req;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppUpdateReq implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pkg;
    private int versionCode;
}
