package com.douyin.douyinvideo.service;

import com.douyin.douyinvideo.entity.Users;
import com.douyin.douyinvideo.entity.UsersReport;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/6 12:49
 */
public interface UserService {
    //判断用户名是否存在
    public boolean queryUsernameIsExist(String username);

    //保存用户
    public void save(Users users);

    //登录验证
    public Users queryUserLogin(String username,String password);

    //修改用户信息
    public void updateUser(Users users);

    //查询用户信息
    public Users queryUser(String userId);

    //查询用户是否点赞
    boolean isUserLikeVideos(String userId,String videoId);

    //增加粉丝
    void saveUserFans(String userId,String fansId);

    //减少粉丝
    void reduceFans(String userId,String fansId);

    //查询是否关注
    boolean queryIsFollow(String userId,String fansId);

    //保存举报信息
    void reportUser(UsersReport usersReport);
}
