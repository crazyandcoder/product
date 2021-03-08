package com.crazyandcoder.bible.model.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BasePageReq {
    private String pageNo;
    private String pageSize;
}
