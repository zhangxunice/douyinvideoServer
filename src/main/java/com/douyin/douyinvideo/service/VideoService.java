package com.douyin.douyinvideo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douyin.douyinvideo.entity.Comments;
import com.douyin.douyinvideo.entity.Videos;
import com.douyin.douyinvideo.vo.CommentsVO;
import com.douyin.douyinvideo.vo.VideoVO;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/14 10:03
 */
public interface VideoService {

    //保存视频到数据库
    public String saveVideo(Videos videos);

    //保存封面
    public void updateCover(String videoId,String coverPath);

    //分页查询视频
    public IPage<VideoVO> getAllVideos(Page<VideoVO> videoVOPage,Videos videos,Integer isSaveRecord);

    //用户点赞视频
    public void userLikeVideo(String userId,String videoId,String videoCreaterId);

    //用户取消点赞
    public void userUnLikeVideo(String userId,String videoId,String videoCreaterId);

    //查询我喜欢的视频
    IPage<VideoVO> queryMyLikeVideo(Page<VideoVO> videoVOPage, String userId);

    //我关注的人发的视频
    IPage<VideoVO> queryMyFollow(Page<VideoVO> videoVOPage, String userId);

    //保存留言
    void saveComments(Comments comments);

    //留言分页
    IPage<CommentsVO> getAllComments(Page<CommentsVO> commentsPage, String videoId);
}
