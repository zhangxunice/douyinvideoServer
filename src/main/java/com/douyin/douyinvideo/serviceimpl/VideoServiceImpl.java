package com.douyin.douyinvideo.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douyin.douyinvideo.entity.Comments;
import com.douyin.douyinvideo.entity.SearchRecords;
import com.douyin.douyinvideo.entity.UsersLikeVideos;
import com.douyin.douyinvideo.entity.Videos;
import com.douyin.douyinvideo.mapper.*;
import com.douyin.douyinvideo.service.VideoService;
import com.douyin.douyinvideo.utils.JSONResult;
import com.douyin.douyinvideo.vo.CommentsVO;
import com.douyin.douyinvideo.vo.VideoVO;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/14 10:03
 */

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideosMapper videosMapper;

    @Autowired
    private SearchRecordsMapper searchRecordsMapper;

    @Autowired
    private UsersLikeVideosMapper usersLikeVideosMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private Sid sid;

    @Override
    public String saveVideo(Videos videos) {
        String id=sid.nextShort();
        videos.setId(id);
        videosMapper.insert(videos);
        return id;
    }

    @Override
    public void updateCover(String videoId, String coverPath) {
        Videos videos=new Videos();
        videos.setId(videoId);
        videos.setCoverPath(coverPath);
        videosMapper.update(videos,null);
    }

    @Override
    public IPage<VideoVO> getAllVideos(Page<VideoVO> page,Videos videos,Integer isSaveRecord) {

        String userId=videos.getUserId();

        //保存热搜词
        String desc=videos.getVideoDesc();
        if (isSaveRecord!=null&&isSaveRecord==1){
            SearchRecords searchRecords=new SearchRecords();
            String id=sid.nextShort();
            searchRecords.setId(id);
            searchRecords.setContent(desc);
            searchRecordsMapper.insert(searchRecords);
        }

        IPage<VideoVO> videoVOIPage = videosMapper.queryAllVideos(page,desc,userId);
        return videoVOIPage;
    }

    @Override
    public void userLikeVideo(String userId, String videoId, String videoCreaterId) {

        //保存用户视频关联
        String id=sid.nextShort();
        UsersLikeVideos usersLikeVideos=new UsersLikeVideos();
        usersLikeVideos.setId(id);
        usersLikeVideos.setUserId(userId);
        usersLikeVideos.setVideoId(videoId);
        usersLikeVideosMapper.insert(usersLikeVideos);

        //视频喜欢数量累加
        videosMapper.addVideoLikeCount(videoId);


        //用户视频被喜欢数量累加
        usersMapper.addReceiveLikeCount(userId);
    }

    @Override
    public void userUnLikeVideo(String userId, String videoId, String videoCreaterId) {

        //删除用户视频关联
        QueryWrapper<UsersLikeVideos> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("video_id",videoId);
        usersLikeVideosMapper.delete(queryWrapper);

        //视频喜欢数量累减
        videosMapper.reduceVideoLikeCount(videoId);


        //用户视频被喜欢数量累减
        usersMapper.reduceReceiveLikeCount(userId);
    }

    @Override
    public IPage<VideoVO> queryMyLikeVideo(Page<VideoVO> videoVOPage, String userId) {

        IPage<VideoVO> videoVOIPage = videosMapper.queryMyLikeVideo(videoVOPage,userId);
        return videoVOIPage;
    }

    @Override
    public IPage<VideoVO> queryMyFollow(Page<VideoVO> videoVOPage, String userId) {
        IPage<VideoVO> videoVOIPage = videosMapper.queryMyFollowVideo(videoVOPage,userId);
        return videoVOIPage;
    }

    @Override
    public void saveComments(Comments comments) {
        String id=sid.nextShort();
        comments.setId(id);
        comments.setCreateTime(new Date());
        commentMapper.insert(comments);
    }

    @Override
    public IPage<CommentsVO> getAllComments(Page<CommentsVO> commentsPage, String videoId) {
        IPage<CommentsVO> commentsIPage = commentMapper.queryAllComment(commentsPage,videoId);
        return commentsIPage;
    }
}
