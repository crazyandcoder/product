package com.crazyandcoder.bible.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crazyandcoder.bible.entity.User;
import com.crazyandcoder.bible.model.Response;
import com.crazyandcoder.bible.model.req.*;
import com.crazyandcoder.bible.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bible/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    IUserService userService;

    @RequestMapping("/hello")
    public String index() {
        logger.info("test 测试成功！");
        return "Hello World!";
    }

    /**
     * 用户注册
     *
     * @param registerReq
     * @return
     */
    @PostMapping("/register")
    public Response registerUserByName(@RequestBody @Validated UserRegisterReq registerReq) {
        return userService.addUserbyName(registerReq);
    }


    /**
     * 用户登录
     *
     * @param loginReq
     * @return
     */
    @PostMapping("/login")
    public Response<User> loginByNameAndPassword(@RequestBody @Validated UserLoginReq loginReq) {
        return userService.selectUserByNameAndPassword(loginReq);
    }

    /**
     * 用户列表
     *
     * @param req
     * @return
     */
    @GetMapping("/list")
    public Response<Page<User>> getUserList(String userId, String pageNo, String pageSize) {
        Page<User> page = new Page<>();
        if (StringUtils.isNotBlank(pageNo)) {
            page.setCurrent(Long.parseLong(pageNo));
        }
        if (StringUtils.isNotBlank(pageSize)) {
            page.setSize(Long.parseLong(pageSize));
        }
        return userService.getUserList(userId, page);
    }


    /**
     * 查询用户信息
     *
     * @param req
     * @return
     */
    @PostMapping("/getUserInfoByUserName")
    public Response<User> getUserInfoByUserName(@RequestBody @Validated UserGetReq req) {
        return userService.selectUserByUserName(req);
    }


    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/getUserInfoByUserId")
    public Response<User> getUserInfoByUserId(String userId) {
        return userService.getUserInfoByUserId(userId);
    }


    /**
     * 更新用户信息
     *
     * @param req
     * @return
     */
    @PostMapping("/updateUserInfo")
    public Response<User> updateUserInfo(@RequestBody @Validated UserUpdateReq req) {
        return userService.updateUserInfo(req);
    }


    /**
     * 更新用户信息
     *
     * @param req
     * @return
     */
    @PostMapping("/updateUserPwd")
    public Response<User> updateUserPwd(@RequestBody @Validated UserUpdatePwdReq req) {
        return userService.updateUserPwd(req);
    }


}
