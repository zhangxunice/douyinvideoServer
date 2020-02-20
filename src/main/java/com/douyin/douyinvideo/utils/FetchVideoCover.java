package com.douyin.douyinvideo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/13 13:23
 */
public class FetchVideoCover {

    private String ffmpegEXE;

    public FetchVideoCover(String ffmpegEXE){
        super();
        this.ffmpegEXE=ffmpegEXE;
    }


    public void convertor(String videoInputPath,String coverOutputPath) throws IOException {

        List<String> command=new ArrayList<>();
        command.add(ffmpegEXE);

        command.add("-ss");
        command.add("00:00:01");
        command.add("-y");
        command.add("-i");
        command.add(videoInputPath);

        command.add("-vframes");
        command.add("1");


        command.add(coverOutputPath);

        ProcessBuilder builder=new ProcessBuilder(command);
        Process process = builder.start();
        InputStream errorStream=process.getErrorStream();
        InputStreamReader inputStreamReader=new InputStreamReader(errorStream);
        BufferedReader br=new BufferedReader(inputStreamReader);

        String line="";
        while ((line=br.readLine())!=null){

        }
        if (br!=null){
            br.close();
        }
        if (inputStreamReader!=null){
            inputStreamReader.close();
        }
        if (errorStream!=null){
            errorStream.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FetchVideoCover mergeVideoMp3=new FetchVideoCover("E:\\ffmpeg\\bin\\ffmpeg.exe");
        mergeVideoMp3.convertor("E:\\ffmpeg\\bin\\video.mp4","E:\\ffmpeg\\bin\\video.jpg");
    }

}
