package com.douyin.douyinvideo.serviceimpl;

import com.douyin.douyinvideo.entity.Bgm;
import com.douyin.douyinvideo.mapper.BgmMapper;
import com.douyin.douyinvideo.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/13 10:26
 */

@Service
public class BgmServiceImpl implements BgmService {

    @Autowired
    private BgmMapper bgmMapper;

    @Override
    public List<Bgm> queryBgm() {
        List<Bgm> bgms = bgmMapper.selectList(null);
        return bgms;
    }

    @Override
    public Bgm queryBgmByBgmId(String bgmId) {
        Bgm bgm=bgmMapper.selectById(bgmId);
        return bgm;
    }
}
