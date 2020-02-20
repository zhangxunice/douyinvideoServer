package com.douyin.douyinvideo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.douyin.douyinvideo.mapper")
@ComponentScan(basePackages = {"com.douyin", "org.n3r.idworker"})
public class DouyinvideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DouyinvideoApplication.class, args);
    }

}
