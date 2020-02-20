package com.douyin.douyinvideo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.douyin.douyinvideo.entity.Users;

public interface UsersMapper extends BaseMapper<Users> {

    //增加收到收藏的数量
    void addReceiveLikeCount(String userId);

    //减少收到收藏的数量
    void reduceReceiveLikeCount(String userId);

    //增加粉丝数量
    void addFanCount(String userId);

    //减少粉丝数量
    void reduceFanCount(String userId);

    //增加关注数量
    void addFollersCount(String userId);

    //减少关注数量
    void reduceFollersCount(String userId);

}