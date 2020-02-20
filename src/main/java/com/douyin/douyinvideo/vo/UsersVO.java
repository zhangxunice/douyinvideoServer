package com.douyin.douyinvideo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="用户对象", description="这是用户对象")
public class UsersVO {


    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名", name="username", example="imoocuser", required=true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码", name="password", example="123456", required=true)
    private String password;

    /**
     * 我的头像，如果没有默认给一张
     */
    @ApiModelProperty(hidden=true)

    private String faceImage;

    /**
     * 昵称
     */
    @ApiModelProperty(hidden=true)
    private String nickname;

    /**
     * 我的粉丝数量
     */
    @ApiModelProperty(hidden=true)

    private Integer fansCounts;

    /**
     * 我关注的人总数
     */
    @ApiModelProperty(hidden=true)

    private Integer followCounts;

    /**
     * 我接受到的赞美/收藏 的数量
     */
    @ApiModelProperty(hidden=true)

    private Integer receiveLikeCounts;

    private Boolean isFollow;

    public UsersVO() {
		super();
	}

    public UsersVO(String id, String username, String password, String faceImage, String nickname, Integer fansCounts, Integer followCounts, Integer receiveLikeCounts, Boolean isFollow) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.faceImage = faceImage;
        this.nickname = nickname;
        this.fansCounts = fansCounts;
        this.followCounts = followCounts;
        this.receiveLikeCounts = receiveLikeCounts;
        this.isFollow = isFollow;
    }
}