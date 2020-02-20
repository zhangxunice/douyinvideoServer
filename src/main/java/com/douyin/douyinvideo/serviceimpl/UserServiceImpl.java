package com.douyin.douyinvideo.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.douyin.douyinvideo.entity.Users;
import com.douyin.douyinvideo.entity.UsersFans;
import com.douyin.douyinvideo.entity.UsersLikeVideos;
import com.douyin.douyinvideo.entity.UsersReport;
import com.douyin.douyinvideo.mapper.UserFansMapper;
import com.douyin.douyinvideo.mapper.UsersLikeVideosMapper;
import com.douyin.douyinvideo.mapper.UsersMapper;
import com.douyin.douyinvideo.mapper.UsersReportMapper;
import com.douyin.douyinvideo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/6 12:51
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UsersLikeVideosMapper usersLikeVideosMapper;

    @Autowired
    private UserFansMapper userFansMapper;

    @Autowired
    private UsersReportMapper usersReportMapper;

    @Autowired
    private Sid sid;


    @Override
    public boolean queryUsernameIsExist(String username) {
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Users users = usersMapper.selectOne(queryWrapper);
        return users==null?false:true;
    }

    @Override
    public void save(Users users) {
        String id=sid.nextShort();
        users.setId(id);
        usersMapper.insert(users);
    }

    @Override
    public Users queryUserLogin(String username, String password) {
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("password",password);
        Users users = usersMapper.selectOne(queryWrapper);
        return users;
    }

    @Override
    public void updateUser(Users users) {
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",users.getId());
        usersMapper.update(users,queryWrapper);
    }

    @Override
    public Users queryUser(String userId) {
        Users users = usersMapper.selectById(userId);
        return users;
    }

    @Override
    public boolean isUserLikeVideos(String userId, String videoId) {

        if (StringUtils.isBlank(userId)||StringUtils.isBlank(videoId)){
            return false;
        }

        QueryWrapper<UsersLikeVideos> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("video_id",videoId);
        List<UsersLikeVideos> usersLikeVideos = usersLikeVideosMapper.selectList(queryWrapper);
        if (usersLikeVideos!=null&&usersLikeVideos
        .size()>0){
            return true;
        }
        return false;
    }

    @Override
    public void saveUserFans(String userId, String fansId) {

        String id=sid.nextShort();
        UsersFans usersFans=new UsersFans();
        usersFans.setId(id);
        usersFans.setUserId(userId);
        usersFans.setFanId(fansId);
        userFansMapper.insert(usersFans);

        usersMapper.addFanCount(userId);
        usersMapper.addFollersCount(fansId);
    }

    @Override
    public void reduceFans(String userId, String fansId) {

        QueryWrapper<UsersFans> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("fans_id",fansId);
        userFansMapper.delete(queryWrapper);

        usersMapper.reduceFanCount(userId);
        usersMapper.reduceFollersCount(fansId);


    }

    @Override
    public boolean queryIsFollow(String userId, String fansId) {
        QueryWrapper<UsersFans> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("fan_id",fansId);
        List<UsersFans> usersFans = userFansMapper.selectList(queryWrapper);
        if (usersFans.size()>0&&usersFans!=null&&!usersFans.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public void reportUser(UsersReport usersReport) {
        String id=sid.nextShort();
        usersReport.setId(id);
        usersReport.setCreateDate(new Date());
        usersReportMapper.insert(usersReport);
    }
}
