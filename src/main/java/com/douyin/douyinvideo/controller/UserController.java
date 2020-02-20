package com.douyin.douyinvideo.controller;

import com.douyin.douyinvideo.entity.Users;
import com.douyin.douyinvideo.entity.UsersReport;
import com.douyin.douyinvideo.service.UserService;
import com.douyin.douyinvideo.utils.JSONResult;
import com.douyin.douyinvideo.vo.UserVo;
import com.douyin.douyinvideo.vo.UsersVO;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/6 21:39
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/uploadFace")
    public JSONResult uploadFace(String userId,@RequestParam("file") MultipartFile[] multipartFiles) throws Exception {
        //文件命名空间
        String fileSpace="E:\\Douyin";
        //保存到数据库的相对路径
        String uploadPathDB="/"+userId+"/face";
        FileOutputStream fileOutputStream=null;
        InputStream inputStream=null;

        try {
            if (multipartFiles!=null&&multipartFiles.length>0){


                String fileName=multipartFiles[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)){
                    String finalPath=fileSpace+uploadPathDB+"/"+fileName;
                    uploadPathDB+=("/"+fileName);

                    File outfile=new File(finalPath);
                    if (outfile.getParentFile()!=null||!outfile.getParentFile().isDirectory()){
                        //创建父文件夹
                        outfile.getParentFile().mkdirs();
                    }
                    fileOutputStream=new FileOutputStream(outfile);
                    inputStream= multipartFiles[0].getInputStream();
                    IOUtils.copy(inputStream,fileOutputStream);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        Users users=new Users();
        users.setId(userId);
        users.setFaceImage(uploadPathDB);
        userService.updateUser(users);
        return JSONResult.ok(uploadPathDB);
    }

    @PostMapping("/queryUser")
    public JSONResult queryUser(String userId,String fansId){
        Users users = userService.queryUser(userId);
        UsersVO usersVO=new UsersVO();
        BeanUtils.copyProperties(users,usersVO);
        boolean isFollow = userService.queryIsFollow(userId, fansId);
        usersVO.setIsFollow(isFollow);
        return JSONResult.ok(usersVO);
    }

    @PostMapping("/queryPublisher")
    public JSONResult queryUser(String userId,String videoId,String publisherId){
        //查询视频发布者信息
        Users users = userService.queryUser(publisherId);


        //查询点赞关系
        boolean userLikeVideos = userService.isUserLikeVideos(userId, videoId);

        UserVo userVo=new UserVo();
        userVo.setUsers(users);
        userVo.setUserLikeVideo(userLikeVideos);

        return JSONResult.ok(userVo);
    }

    @PostMapping("/tobefans")
    public JSONResult toBeFans(String userId,String fansId){
        userService.saveUserFans(userId,fansId);
        return JSONResult.ok("关注成功");
    }

    @PostMapping("/unbefans")
    public JSONResult unBeFans(String userId,String fansId){
        userService.reduceFans(userId,fansId);
        return JSONResult.ok("取消关注");
    }

    @PostMapping("/reportuser")
    public JSONResult reportUser(@RequestBody UsersReport usersReport){
        userService.reportUser(usersReport);
        return JSONResult.ok("举报成功，感谢你的反馈！");
    }
}
