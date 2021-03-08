package com.crazyandcoder.bible.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazyandcoder.bible.entity.User;
import com.crazyandcoder.bible.model.Response;
import com.crazyandcoder.bible.model.req.*;

/**
 * 用户信息
 */
public interface IUserService extends IService<User> {


    /**
     * 注册用户
     *
     * @param registerReq
     * @return
     */
    Response addUserbyName(UserRegisterReq registerReq);


    /**
     * 用户登录
     *
     * @param loginReq
     * @return
     */
    Response<User> selectUserByNameAndPassword(UserLoginReq loginReq);

    /**
     * 查询用户信息
     *
     * @param req
     * @return
     */
    Response<User> selectUserByUserName(UserGetReq req);

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    Response<User> getUserInfoByUserId(String userId);

    /**
     * 更新用户信息
     *
     * @param req
     * @return
     */
    Response<User> updateUserInfo(UserUpdateReq req);

    /**
     * 更改密码
     *
     * @param req
     * @return
     */
    Response<User> updateUserPwd(UserUpdatePwdReq req);

    /**
     * 获取用户列表
     *
     * @param userId
     * @param page
     * @return
     */
    Response<Page<User>> getUserList(String userId, Page<User> page);
}
