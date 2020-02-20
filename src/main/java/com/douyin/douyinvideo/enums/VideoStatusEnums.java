package com.douyin.douyinvideo.enums;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/14 9:57
 */
public enum  VideoStatusEnums {

    SUCCESS(1),   //发布成功
    FORBID(2);    //禁止播放


    private final int value;

    VideoStatusEnums(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }
}
