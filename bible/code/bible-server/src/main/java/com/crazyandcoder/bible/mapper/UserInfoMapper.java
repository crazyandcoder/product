package com.crazyandcoder.bible.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crazyandcoder.bible.entity.User;
import com.crazyandcoder.bible.model.req.UserRegisterReq;
import com.crazyandcoder.bible.model.req.UserUpdatePwdReq;
import com.crazyandcoder.bible.model.req.UserUpdateReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<User> {

    /**
     * 注册时需要先查询是否存在该用户
     *
     * @param name
     * @return
     */
    public User selectUserByName(@Param("userName") String name);

    /**
     * 插入一条用户信息数据
     *
     * @param registerReq
     * @return
     */
    int addUserByName(UserRegisterReq registerReq);

    /**
     * 根据用户名和密码查询（登录使用）
     *
     * @param userName
     * @param userPassword
     * @return
     */
    User selectUserByNameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    /**
     * 根据用户id进行查询
     *
     * @param userId
     * @return
     */
    User selectUserByUserId(@Param("userId") String userId);

    /**
     * 更新用户信息
     *
     * @param req
     * @return
     */
    int updateUserInfo(UserUpdateReq req);


    /**
     * 修改密码
     *
     * @param req
     * @return
     */
    int updateUserPwd(UserUpdatePwdReq req);


    /**
     * 根据用户id和密码查询是否存在相应的用户，修改密码使用
     *
     * @param userId
     * @return
     */
    User selectUserByUserIdAndPwd(@Param("userId") String userId, @Param("userPassword") String userPassword);

    /**
     * 获取用户列表
     *
     * @param userId
     * @param page
     * @return
     */
    List<User> getUserList(@Param("userId")String userId, Page<User> page);
}
