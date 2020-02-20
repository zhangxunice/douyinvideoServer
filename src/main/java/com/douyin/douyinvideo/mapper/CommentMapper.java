package com.douyin.douyinvideo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douyin.douyinvideo.entity.Comments;
import com.douyin.douyinvideo.vo.CommentsVO;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/3 12:29
 */
public interface CommentMapper extends BaseMapper<Comments> {
    IPage<CommentsVO> queryAllComment(Page<CommentsVO> commentsPage, String videoId);
}
