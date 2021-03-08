package com.crazyandcoder.bible.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazyandcoder.bible.entity.User;
import com.crazyandcoder.bible.mapper.UserInfoMapper;
import com.crazyandcoder.bible.model.Response;
import com.crazyandcoder.bible.model.req.*;
import com.crazyandcoder.bible.service.IUserService;
import com.crazyandcoder.bible.util.RecordNoUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserInfoMapper, User> implements IUserService {


    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 注册
     *
     * @param registerReq
     * @return
     */
    @Override
    public Response addUserbyName(UserRegisterReq registerReq) {
        if (StringUtils.isBlank(registerReq.getUserName()) || StringUtils.isBlank(registerReq.getUserPassword()) || StringUtils.isBlank(registerReq.getUserNormalPassword())) {
            logger.error("用户名或密码不能为空");
            return Response.failResult("用户名或密码为空");
        }
        User userInfo = userInfoMapper.selectUserByName(registerReq.getUserName());
        if (userInfo != null && !StringUtils.isBlank(userInfo.getUserName())) {
            logger.error("用户名已存在");
            return Response.failResult("用户名已存在");
        } else {
            registerReq.setUserNickName("匿名");
            registerReq.setUserGender(1);
            registerReq.setUserAge(0);
            registerReq.setUserAddress("未知");
            registerReq.setUserPhone("");
            registerReq.setUserAvatar("");
            registerReq.setUserIntroduction("这个人什么都没有留下");
            registerReq.setUserCity("");
            registerReq.setUserEmail("");
            registerReq.setUserId("" + RecordNoUtils.getInstance().get("u") + System.currentTimeMillis());
            int result = userInfoMapper.addUserByName(registerReq);
            if (result == 1) {
                logger.info("注册成功");
                return Response.successResult("注册成功");
            } else {
                logger.info("注册失败");
                return Response.failResult("注册失败");
            }
        }
    }

    /**
     * 登录
     *
     * @param loginReq
     * @return
     */
    @Override
    public Response<User> selectUserByNameAndPassword(UserLoginReq loginReq) {
        if (StringUtils.isBlank(loginReq.getUserName()) || StringUtils.isBlank(loginReq.getUserPassword())) {
            logger.error("用户名或密码不能为空");
            return Response.failResult("用户名或密码为空");
        }
        User user = userInfoMapper.selectUserByName(loginReq.getUserName());
        if (user == null) {
            logger.error("用户不存在");
            return Response.failResult("用户不存在");
        }

        User userInfo = userInfoMapper.selectUserByNameAndPassword(loginReq.getUserName(), loginReq.getUserPassword());
        if (userInfo == null || StringUtils.isBlank(userInfo.getUserId())) {
            logger.error("用户名或密码错误");
            return Response.failResult("用户名或密码错误");
        } else {
            logger.info("登录成功");
            userInfo.setLoginTime(new Date());
            return Response.successResult("登录成功", userInfo);
        }

    }

    @Override
    public Response<User> selectUserByUserName(UserGetReq req) {
        if (StringUtils.isBlank(req.getUserName())) {
            logger.error("用户名为空");
            return Response.failResult("用户名为空");
        }
        User user = userInfoMapper.selectUserByName(req.getUserName());
        if (user == null) {
            logger.error("用户名不存在");
            return Response.failResult("用户名不存在");
        } else {
            logger.info("用户信息查询成功" + user.toString());
            return Response.successResult("用户信息查询成功", user);
        }
    }

    @Override
    public Response<User> getUserInfoByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            logger.error("用户Id为空");
            return Response.failResult("用户Id为空");
        }
        User user = userInfoMapper.selectUserByUserId(userId);
        if (user == null) {
            logger.error("用户名不存在");
            return Response.failResult("用户名不存在");
        } else {
            logger.info("用户信息查询成功" + user.toString());
            return Response.successResult("用户信息查询成功", user);
        }
    }

    @Override
    public Response<User> updateUserInfo(UserUpdateReq req) {
        if (StringUtils.isBlank(req.getUserId())) {
            logger.error("用户Id为空");
            return Response.failResult("用户Id为空");
        }

        int update = userInfoMapper.updateUserInfo(req);
        if (update == 1) {
            logger.info("用户信息更新成功");
            return Response.successResult("用户信息更新成功", null);
        } else {
            logger.error("用户信息更新失败");
            return Response.failResult("用户信息更新失败");
        }

    }

    @Override
    public Response<User> updateUserPwd(UserUpdatePwdReq req) {
        if (StringUtils.isBlank(req.getUserId())) {
            logger.error("用户Id为空");
            return Response.failResult("用户Id为空");
        }

        User user = userInfoMapper.selectUserByUserIdAndPwd(req.getUserId(), req.getUserPrePassword());
        if (user == null) {
            logger.error("原始密码错误");
            return Response.failResult("原始密码错误");
        }

        int update = userInfoMapper.updateUserPwd(req);
        if (update == 1) {
            logger.info("密码修改成功");
            return Response.successResult("密码修改成功", null);
        } else {
            logger.error("密码修改失败");
            return Response.failResult("密码修改失败");
        }

    }

    @Override
    public Response<Page<User>> getUserList(String userId, Page<User> page) {
        List<User> list = userInfoMapper.getUserList(userId, page);
        page.setRecords(list);
        return Response.successResult("列表查询成功", page);
    }
}
