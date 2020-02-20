package com.douyin.douyinvideo.controller;

import com.douyin.douyinvideo.service.SearchService;
import com.douyin.douyinvideo.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/15 10:20
 */

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;


    @GetMapping("/hotwords")
    public JSONResult getHotWords(){
        List<String> hotWords = searchService.getHotWords();
        return JSONResult.ok(hotWords);
    }
}
