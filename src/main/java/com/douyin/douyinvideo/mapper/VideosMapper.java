package com.douyin.douyinvideo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douyin.douyinvideo.entity.Videos;
import com.douyin.douyinvideo.vo.VideoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideosMapper extends BaseMapper<Videos> {

    IPage<VideoVO> queryAllVideos(Page<VideoVO> page,@Param("videoDesc")String videoDesc,String userId);

    //增加点赞数
    void addVideoLikeCount(String videoId);

    //减少点赞数
    void reduceVideoLikeCount(String videoId);

    //查询我喜欢的视频
    IPage<VideoVO> queryMyLikeVideo(Page<VideoVO> videoVOPage, String userId);

    //查询我关注的人发的视频
    IPage<VideoVO> queryMyFollowVideo(Page<VideoVO> videoVOPage, String userId);
}
