package com.douyin.douyinvideo.controller;

import com.douyin.douyinvideo.entity.Bgm;
import com.douyin.douyinvideo.service.BgmService;
import com.douyin.douyinvideo.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/13 10:36
 */

@RestController
@RequestMapping("/bgm")
public class BgmController {

    @Autowired
    private BgmService bgmService;

    @GetMapping("/bgmlist")
    public JSONResult bgmlist(){
        List<Bgm> bgmList=bgmService.queryBgm();
        return JSONResult.ok(bgmList);
    }

}
