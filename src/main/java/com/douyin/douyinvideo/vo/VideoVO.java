package com.douyin.douyinvideo.vo;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VideoVO {

    private String id;

    /**
     * 发布者id
     */

    private String userId;

    /**
     * 用户使用音频的信息
     */

    private String audioId;

    /**
     * 视频描述
     */

    private String videoDesc;

    /**
     * 视频存放的路径
     */

    private String videoPath;

    /**
     * 视频秒数
     */

    private Float videoSeconds;

    /**
     * 视频宽度
     */

    private Integer videoWidth;

    /**
     * 视频高度
     */

    private Integer videoHeight;

    /**
     * 视频封面图
     */

    private String coverPath;

    /**
     * 喜欢/赞美的数量
     */

    private Long likeCounts;

    /**
     * 视频状态：
     * 1、发布成功
     * 2、禁止播放，管理员操作
     */
    private Integer status;

    /**
     * 创建时间
     */

    private Date createTime;

    private String faceImage;

    private String nickname;

}