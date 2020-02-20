package com.douyin.douyinvideo.service;

import com.douyin.douyinvideo.entity.Bgm;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/13 10:25
 */
public interface BgmService {

    //查询 bgm 列表
    public List<Bgm> queryBgm();

    //根据 bgmId 查询bgm
    public Bgm queryBgmByBgmId(String bgmId);
}
