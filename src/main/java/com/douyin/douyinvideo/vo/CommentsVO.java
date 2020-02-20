package com.douyin.douyinvideo.vo;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentsVO {

    private String id;



    /**
     * 视频id
     */

    private String videoId;

    /**
     * 留言者，评论的用户id
     */

    private String fromUserId;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 评论内容
     */
    private String comment;
    private String toNickname;
    private String faceImage;
    private String nickname;

}