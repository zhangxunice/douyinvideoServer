package com.douyin.douyinvideo.serviceimpl;

import com.douyin.douyinvideo.mapper.SearchRecordsMapper;
import com.douyin.douyinvideo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/15 10:21
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRecordsMapper searchRecordsMapper;

    @Override
    public List<String> getHotWords() {
        List<String> hotWords = searchRecordsMapper.getHotWords();
        return hotWords;
    }
}
