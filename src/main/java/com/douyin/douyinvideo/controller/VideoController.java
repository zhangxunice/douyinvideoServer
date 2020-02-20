package com.douyin.douyinvideo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douyin.douyinvideo.entity.Bgm;
import com.douyin.douyinvideo.entity.Comments;
import com.douyin.douyinvideo.entity.Users;
import com.douyin.douyinvideo.entity.Videos;
import com.douyin.douyinvideo.enums.VideoStatusEnums;
import com.douyin.douyinvideo.service.BgmService;
import com.douyin.douyinvideo.service.VideoService;
import com.douyin.douyinvideo.utils.FetchVideoCover;
import com.douyin.douyinvideo.utils.JSONResult;
import com.douyin.douyinvideo.utils.MergeVideoMp3;
import com.douyin.douyinvideo.vo.CommentsVO;
import com.douyin.douyinvideo.vo.VideoVO;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @author zhangxu
 * @title
 * @date 2020/1/13 11:11
 */

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private BgmService bgmService;

    @Autowired
    private VideoService videoService;

    @PostMapping(value = "/uploadVideo",headers = "content-type=multipart/form-data")
    public JSONResult uploadFace(String userId,
                                 String bgmId,double videoSecond,
                                 int videoHeight,int videoWidth,
                                 String desc,
                                 MultipartFile multipartFiles) throws Exception {

        String ffmpeg="E:\\ffmpeg\\bin\\ffmpeg.exe";
        //文件命名空间
        String fileSpace="E:\\Douyin";
        //保存到数据库的相对路径
        String uploadPathDB="/"+userId+"/video";
        String coverPathDB="/"+userId+"/video";

        FileOutputStream fileOutputStream=null;
        InputStream inputStream=null;

        String finalPath="";

        try {
            if (multipartFiles!=null){


                String fileName=multipartFiles.getOriginalFilename();
                String fileNamePrefix=fileName.split("\\.")[0];

                if (StringUtils.isNotBlank(fileName)){
                    finalPath=fileSpace+uploadPathDB+"/"+fileName;
                    uploadPathDB+=("/"+fileName);
                    coverPathDB=coverPathDB+"/"+fileNamePrefix+".jpg";

                    File outfile=new File(finalPath);
                    if (outfile.getParentFile()!=null||!outfile.getParentFile().isDirectory()){
                        //创建父文件夹
                        outfile.getParentFile().mkdirs();
                    }
                    fileOutputStream=new FileOutputStream(outfile);
                    inputStream= multipartFiles.getInputStream();
                    IOUtils.copy(inputStream,fileOutputStream);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        if (StringUtils.isNotBlank(bgmId)){
            Bgm bgm= bgmService.queryBgmByBgmId(bgmId);
            String map3InputPath=fileSpace+bgm.getPath();


            MergeVideoMp3 tools=new MergeVideoMp3(ffmpeg);
            String videoInputPath=finalPath;
            String videoOutPutName= UUID.randomUUID().toString()+".mp4";
            String finalVideoOutPutName= UUID.randomUUID().toString()+".mp4";
            String middlePath=fileSpace+"/"+userId+"/video"+"/"+videoOutPutName;

            uploadPathDB="/"+userId+"/video"+"/"+finalVideoOutPutName;
            finalPath=fileSpace+uploadPathDB;

            String removeAudio = tools.removeAudio(videoInputPath, middlePath);

            tools.convertor(removeAudio,map3InputPath,videoSecond,finalPath);

        }


        FetchVideoCover fetchVideoCover=new FetchVideoCover(ffmpeg);
        fetchVideoCover.convertor(finalPath,fileSpace+coverPathDB);

        Videos video=new Videos();
        video.setAudioId(bgmId);
        video.setUserId(userId);
        video.setVideoDesc(desc);
        video.setVideoHeight(videoHeight);
        video.setVideoWidth(videoWidth);
        video.setVideoSeconds((float) videoSecond);
        video.setVideoPath(uploadPathDB);
        video.setCoverPath(coverPathDB);
        video.setCreateTime(new Date());
        video.setStatus(VideoStatusEnums.SUCCESS.getValue());

        String videoId=videoService.saveVideo(video);

        return JSONResult.ok(videoId);
    }


    @PostMapping(value = "/uploadCover",headers = "content-type=multipart/form-data")
    public JSONResult uploadFace(String videoId,
                                 String userId,
                                 MultipartFile multipartFiles) throws Exception {
        //文件命名空间
        String fileSpace = "E:\\Douyin";
        //保存到数据库的相对路径
        String uploadPathDB = "/" + userId + "/video";
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;

        String finalPath = "";

        try {
            if (multipartFiles != null) {


                String fileName = multipartFiles.getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    finalPath = fileSpace + uploadPathDB + "/" + fileName;
                    uploadPathDB += ("/" + fileName);

                    File outfile = new File(finalPath);
                    if (outfile.getParentFile() != null || !outfile.getParentFile().isDirectory()) {
                        //创建父文件夹
                        outfile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outfile);
                    inputStream = multipartFiles.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        videoService.updateCover(videoId,uploadPathDB);
        return JSONResult.ok();
    }

    @PostMapping("/allVideos")
    public JSONResult getAllVideos(@RequestBody Videos videos,Integer isSaveRecord, Integer page){
        if (page==null){
            page=1;
        }
        Page<VideoVO> videoVOPage=new Page<>(page,6);
        IPage<VideoVO> allVideos = videoService.getAllVideos(videoVOPage,videos,isSaveRecord);
        return JSONResult.ok(allVideos);
    }

    @PostMapping("/userLike")
    public JSONResult userLike(String userId,String videoId,String videoCreaterId){
        videoService.userLikeVideo(userId,videoId,videoCreaterId);
        return JSONResult.ok();
    }

    @PostMapping("/userUnLike")
    public JSONResult userUnLike(String userId,String videoId,String videoCreaterId){
        videoService.userUnLikeVideo(userId,videoId,videoCreaterId);
        return JSONResult.ok();
    }

    @PostMapping("/showmylike")
    public JSONResult showMyLike(String userId,Integer page){
        if (page==null){
            page=1;
        }
        Page<VideoVO> videoVOPage=new Page<>(page,6);
        IPage<VideoVO> myLikeVideo = videoService.queryMyLikeVideo(videoVOPage,userId);
        return JSONResult.ok(myLikeVideo);
    }

    @PostMapping("/showmyfollow")
    public JSONResult showMyFollow(String userId,Integer page){
        if (page==null){
            page=1;
        }
        Page<VideoVO> videoVOPage=new Page<>(page,6);
        IPage<VideoVO> myLikeVideo = videoService.queryMyFollow(videoVOPage,userId);
        return JSONResult.ok(myLikeVideo);
    }

    @PostMapping("/savecomment")
    public JSONResult saveComment(@RequestBody Comments comments,String fatherCommentId,String toUserId){
        comments.setFatherCommentId(fatherCommentId);
        comments.setToUserId(toUserId);
        videoService.saveComments(comments);
        return JSONResult.ok();
    }

    @PostMapping("/getvideocomment")
    public JSONResult getVideoComment(String videoId,Integer page){
        if (page==null){
            page=1;
        }
        Page<CommentsVO> commentsPage=new Page<>(page,10);
        IPage<CommentsVO> commentsIPage = videoService.getAllComments(commentsPage,videoId);
        return JSONResult.ok(commentsIPage);
    }
}
