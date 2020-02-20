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
public class MergeVideoMp3 {

    private String ffmpegEXE;

    public MergeVideoMp3(String ffmpegEXE){
        super();
        this.ffmpegEXE=ffmpegEXE;
    }

    public String removeAudio(String videoInputPath,String videoOutputPath) throws IOException {
        //将原有视频的音频消除
        //ffmpeg.exe -i video.mp4 -vcodec copy -an video2.mp4
        List<String> command=new ArrayList<>();
        command.add(ffmpegEXE);

        command.add("-i");
        command.add(videoInputPath);

        command.add("-vcodec");

        command.add("copy");

        command.add("-an");
        command.add(videoOutputPath);

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

        return videoOutputPath;
    }

    public void convertor(String videoInputPath,String mp3InputPath,
                          double seconds,String videoOutputPath) throws IOException {
        //ffmpeg.exe -i 1.mp4 -i 1.mp3 -t 7 -y 1.mp4
        List<String> command=new ArrayList<>();
        command.add(ffmpegEXE);

        command.add("-i");
        command.add(videoInputPath);

        command.add("-i");
        command.add(mp3InputPath);

        command.add("-t");
        command.add(String.valueOf(seconds));

        command.add("-y");
        command.add(videoOutputPath);

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
        MergeVideoMp3 mergeVideoMp3=new MergeVideoMp3("E:\\ffmpeg\\bin\\ffmpeg.exe");
//        String removeAudio = mergeVideoMp3.removeAudio("E:\\ffmpeg\\bin\\test.mp4",
//                "E:\\ffmpeg\\bin\\video.mp4");
        mergeVideoMp3.convertor("E:\\ffmpeg\\bin\\video.mp4",
                "E:\\ffmpeg\\bin\\new.mp3",18,
                "E:\\ffmpeg\\bin\\daixiahu.mp4");
    }

}
