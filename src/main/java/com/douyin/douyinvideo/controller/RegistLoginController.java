package com.douyin.douyinvideo.controller;

import com.douyin.douyinvideo.entity.Users;
import com.douyin.douyinvideo.service.UserService;
import com.douyin.douyinvideo.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/6 12:42
 */
@RestController
public class RegistLoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public JSONResult regist(@RequestBody Users users){
//        1.判断用户名密码是否为空
        if (StringUtils.isBlank(users.getUsername())||StringUtils.isBlank(users.getPassword())){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }
//        2.判断用户名是否存在
        Boolean isExist=userService.queryUsernameIsExist(users.getUsername());
//        3.保存用户注册信息
        if (!isExist){
            users.setNickname(users.getUsername());
            users.setPassword(users.getPassword());
            users.setFansCounts(0);
            users.setFollowCounts(0);
            users.setReceiveLikeCounts(0);
            userService.save(users);
        }else {
            return JSONResult.errorMsg("用户名已存在");
        }
        return JSONResult.ok(users);
    }

    @PostMapping("/login")
    public JSONResult login(@RequestBody Users users){
        String username=users.getUsername();
        String password=users.getPassword();

        //        1.判断用户名密码是否为空
        if (StringUtils.isBlank(users.getUsername())||StringUtils.isBlank(users.getPassword())){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        Users users1=userService.queryUserLogin(username,password);
        if (users==null){
            return JSONResult.errorMsg("用户名或密码错误");
        }else {
            return JSONResult.ok(users1);
        }

    }
}
