package com.douyin.douyinvideo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.douyin.douyinvideo.entity.SearchRecords;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SearchRecordsMapper extends BaseMapper<SearchRecords> {

    //查询热搜词
    List<String> getHotWords();
}