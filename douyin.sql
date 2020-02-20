/*
 Navicat Premium Data Transfer

 Source Server         : zhangxu
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : douyin

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 20/02/2020 23:12:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bgm
-- ----------------------------
DROP TABLE IF EXISTS `bgm`;
CREATE TABLE `bgm`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '播放地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bgm
-- ----------------------------
INSERT INTO `bgm` VALUES ('18052674D26HH3X6', '测试歌手名字', 'abc歌曲~~', '\\bgm\\排骨教主 - 霜雪千年.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X7', '测试歌手名字', 'abc歌曲~~', '\\bgm\\排骨教主 - 霜雪千年.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X8', '测试歌手名字', 'abc歌曲~~', '\\bgm\\排骨教主 - 霜雪千年.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X9', '测试歌手名字', 'abc歌曲~~', '\\bgm\\beatmaniaMermaidgirl.mp3');
INSERT INTO `bgm` VALUES ('1805290R3WTDMT9P', 'aa', 'aa', '\\bgm\\排骨教主 - 霜雪千年.mp3');
INSERT INTO `bgm` VALUES ('180530DXKK4YYGTC', '达瓦', 'dwadw', '\\bgm\\action.mp3');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `father_comment_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `to_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `video_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频id',
  `from_user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '留言者，评论的用户id',
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('135240CW46894', NULL, NULL, '180510CC3819RHBC', '1001', 'hhhh 测试啊哈哈哈1', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('18034CW46894', NULL, NULL, '180510CC3819RHBC', '1001', 'hhhh 测试啊哈哈哈2', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('1803F50CW46894', NULL, NULL, '180510CC3819RHBC', '1001', 'hhhh 测试啊哈哈哈3', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('18052150CW46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈4', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F50626894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈5', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F50C126894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈6', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F50CW46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈7', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F5346894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈8', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F54CW46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈9', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180523F533Y0837C', NULL, NULL, '180510CD0A6K3SRP', '180425CFA4RB6T0H', 'dwdawdwa', '2018-05-23 19:52:19');
INSERT INTO `comments` VALUES ('180523FATAR6C2Y8', '135240CW46894', '1001', '180510CC3819RHBC', '180425CFA4RB6T0H', '回复评论', '2018-05-23 20:09:30');
INSERT INTO `comments` VALUES ('180523FB1BYS43HH', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '野马~~', '2018-05-23 20:10:09');
INSERT INTO `comments` VALUES ('180523FC0MKCTS3C', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', 'dwdw', '2018-05-23 20:13:04');
INSERT INTO `comments` VALUES ('180523FCZM2CTCZC', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', 'dwqdwqdqw', '2018-05-23 20:15:58');
INSERT INTO `comments` VALUES ('180523FD1H5HG9P0', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '1fewdew', '2018-05-23 20:16:10');
INSERT INTO `comments` VALUES ('180523FDBT3S3C00', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '123', '2018-05-23 20:17:16');
INSERT INTO `comments` VALUES ('180523FDFX4HS5P0', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '43trgtew', '2018-05-23 20:17:36');
INSERT INTO `comments` VALUES ('180523H79060HNHH', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '哈多好玩聊哦', '2018-05-23 22:47:06');
INSERT INTO `comments` VALUES ('180523HATXR841KP', NULL, NULL, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '大家诶哦大家欧文', '2018-05-23 22:57:42');
INSERT INTO `comments` VALUES ('180523K2DG3SGAA8', NULL, NULL, '180522FB4BZ1N9P0', '180518CKMAAM5TXP', 'dwdw', '2018-05-23 23:56:38');
INSERT INTO `comments` VALUES ('180523K2YRF1WNXP', NULL, NULL, '180522FB4BZ1N9P0', '180518CKMAAM5TXP', 'ddew', '2018-05-23 23:58:03');
INSERT INTO `comments` VALUES ('180523K3FH1WT7R4', NULL, NULL, '180522FB4BZ1N9P0', '180518CKMAAM5TXP', 'tgergre', '2018-05-23 23:59:45');
INSERT INTO `comments` VALUES ('1805240G4G19R0PH', '180523HATXR841KP', '180425CFA4RB6T0H', '180522FB4BZ1N9P0', '180518CKMAAM5TXP', '回复测试，final', '2018-05-24 00:45:31');
INSERT INTO `comments` VALUES ('18055W46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈11', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180565016894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈22', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('1805650CW46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈33', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('1805twW46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈44', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('200203A8BZ960XD4', NULL, NULL, '180510CC3819RHBC', '1001', '测试评论', '2020-02-03 14:26:00');
INSERT INTO `comments` VALUES ('200203AY1A2RA894', '180523FATAR6C2Y8', '180425CFA4RB6T0H', '180510CC3819RHBC', '1001', '测试回复功能', '2020-02-03 15:18:55');
INSERT INTO `comments` VALUES ('280522F50CW46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈55', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('qq1805twW46894', NULL, NULL, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈66', '2018-05-22 19:52:02');

-- ----------------------------
-- Table structure for search_records
-- ----------------------------
DROP TABLE IF EXISTS `search_records`;
CREATE TABLE `search_records`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '搜索的内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频搜索的记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of search_records
-- ----------------------------
INSERT INTO `search_records` VALUES ('1', '慕课网');
INSERT INTO `search_records` VALUES ('18051309YBCMHYRP', '风景');
INSERT INTO `search_records` VALUES ('1805130DAXX58ARP', '风景');
INSERT INTO `search_records` VALUES ('1805130DMG6P0ZC0', '风景');
INSERT INTO `search_records` VALUES ('1805130FNGHD3B0H', '慕课网');
INSERT INTO `search_records` VALUES ('180513C94W152Z7C', 'dwqdwq');
INSERT INTO `search_records` VALUES ('180513DXNT7SY04H', '风景');
INSERT INTO `search_records` VALUES ('19070901F74SMRP0', '海');
INSERT INTO `search_records` VALUES ('190709021YC0GW28', '海');
INSERT INTO `search_records` VALUES ('19070906B3FM6HSW', '海');
INSERT INTO `search_records` VALUES ('19070906XT2F3TR4', '海');
INSERT INTO `search_records` VALUES ('190722F3A2N2YZHH', '海');
INSERT INTO `search_records` VALUES ('190722F3Z1K48B2W', '海贼 ');
INSERT INTO `search_records` VALUES ('190722F425CBF1D4', '海贼王');
INSERT INTO `search_records` VALUES ('190722F457TT06W0', '海贼');
INSERT INTO `search_records` VALUES ('2', '慕课网');
INSERT INTO `search_records` VALUES ('2001158KPMYX7KWH', '野子');
INSERT INTO `search_records` VALUES ('2001158XBHMCRHPH', '野子');
INSERT INTO `search_records` VALUES ('2001158Y799YFDGC', '野子');
INSERT INTO `search_records` VALUES ('200115926R9KMNC0', '野子');
INSERT INTO `search_records` VALUES ('200115938S2P8CBC', '野子');
INSERT INTO `search_records` VALUES ('20011593HXPMH5WH', '风');
INSERT INTO `search_records` VALUES ('3', '慕课网');
INSERT INTO `search_records` VALUES ('4', '慕课网');
INSERT INTO `search_records` VALUES ('5', '慕课');
INSERT INTO `search_records` VALUES ('6', '慕课');
INSERT INTO `search_records` VALUES ('7', 'zookeeper');
INSERT INTO `search_records` VALUES ('8', 'zookeeper');
INSERT INTO `search_records` VALUES ('9', 'zookeeper');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `face_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '我的头像，如果没有默认给一张',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `fans_counts` int(11) NULL DEFAULT 0 COMMENT '我的粉丝数量',
  `follow_counts` int(11) NULL DEFAULT 0 COMMENT '我关注的人总数',
  `receive_like_counts` int(11) NULL DEFAULT 0 COMMENT '我接受到的赞美/收藏 的数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1001', 'zx', '123', '/1001/face/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.AlIvbXKUyJSOb745f7ca6d4d0b78f303cea852151c86.jpg', '慕课网好牛十分牛~', 123456, 113, 1);
INSERT INTO `users` VALUES ('180425B0B3N6B25P', 'imooc11', 'wzNncBURtPYCDsYd7TUgWQ==', NULL, 'imooc', 0, 0, 0);
INSERT INTO `users` VALUES ('180425BNSR1CG0H0', 'abc', '4QrcOUm6Wau+VuBX8g+IPg==', NULL, 'abc', 0, 0, 0);
INSERT INTO `users` VALUES ('180425CFA4RB6T0H', 'imooc', 'kU8h64TG/bK2Y91vRT9lyg==', '/190630HP2BB240ZC/face/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.lzhyRLYKZpiTc7a9f2229ea9cb8331b69708d167b67a.jpg', 'imooc1', 2, 2, 0);
INSERT INTO `users` VALUES ('180426F4D35R04X4', 'aaa', 'R7zlx09Yn0hn29V+nKn4CA==', NULL, 'aaa', 0, 0, 0);
INSERT INTO `users` VALUES ('180426F55CZPA9YW', 'aaaa', 'R7zlx09Yn0hn29V+nKn4CA==', NULL, 'aaaa', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GA3SBB4DP0', '1001', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '1001', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GAK87AB0X4', '10401', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '10401', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GAWCC17KWH', '104701', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '104701', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GBDFKDG5D4', '10re4701', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '10re4701', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GBKN0YRFRP', '10rwee4701', 'bfw1xHdW6WLvBV0QSfH47A==', NULL, '10rwee4701', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GH49XRZHX4', '390213890', 'H9V/tnfgt6nniqH5bDZ0hQ==', NULL, '390213890', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GHH12WXPZC', '390ewqewq213890', 'H9V/tnfgt6nniqH5bDZ0hQ==', NULL, '390ewqewq213890', 0, 0, 0);
INSERT INTO `users` VALUES ('180426GHHPZ7NTC0', '390ewqewq21ewqe3890', 'H9V/tnfgt6nniqH5bDZ0hQ==', NULL, '390ewqewq21ewqe3890', 0, 0, 0);
INSERT INTO `users` VALUES ('180426H0GWP0C3HH', 'jdiowqjodij', 'wEmTz54sy+StEzB+TrtGSQ==', NULL, 'jdiowqjodij', 0, 0, 0);
INSERT INTO `users` VALUES ('180518CHS7SXMCX4', 'aaaaa', 'WU+AOzgKQTlu1j3KOVA1Qg==', NULL, 'aaaaa', 0, 0, 0);
INSERT INTO `users` VALUES ('180518CKMAAM5TXP', 'abc123', '6ZoYxCjLONXyYIU2eJIuAw==', '/190630HP2BB240ZC/face/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.lzhyRLYKZpiTc7a9f2229ea9cb8331b69708d167b67a.jpg', 'abc123', 0, 0, 0);
INSERT INTO `users` VALUES ('190630HP2BB240ZC', 'left', '123', '/190630HP2BB240ZC/face/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.lzhyRLYKZpiTc7a9f2229ea9cb8331b69708d167b67a.jpg', 'left', 0, 0, 0);
INSERT INTO `users` VALUES ('200106B9RPH8WG0H', 'hxc', '123', NULL, 'hxc', 0, 0, 0);
INSERT INTO `users` VALUES ('200106BBZ4F32DGC', 'ch', '123', NULL, 'ch', 0, 0, 0);

-- ----------------------------
-- Table structure for users_fans
-- ----------------------------
DROP TABLE IF EXISTS `users_fans`;
CREATE TABLE `users_fans`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户',
  `fan_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '粉丝',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `fan_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户粉丝关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_fans
-- ----------------------------
INSERT INTO `users_fans` VALUES ('200201AFDZB4CZ2W', '180425CFA4RB6T0H', '1001');

-- ----------------------------
-- Table structure for users_like_videos
-- ----------------------------
DROP TABLE IF EXISTS `users_like_videos`;
CREATE TABLE `users_like_videos`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户',
  `video_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_video_rel`(`user_id`, `video_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户喜欢的/赞过的视频' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_like_videos
-- ----------------------------
INSERT INTO `users_like_videos` VALUES ('20012186T7B5P18H', '1001', '180510CC3819RHBC');
INSERT INTO `users_like_videos` VALUES ('180520HBA054FPPH', '180518CKMAAM5TXP', '180510CCX05TABHH');
INSERT INTO `users_like_videos` VALUES ('180520HSBDW6M0SW', '180518CKMAAM5TXP', '180510CD0A6K3SRP');

-- ----------------------------
-- Table structure for users_report
-- ----------------------------
DROP TABLE IF EXISTS `users_report`;
CREATE TABLE `users_report`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `deal_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '被举报用户id',
  `deal_video_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型标题，让用户选择，详情见 枚举',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `userid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '举报人的id',
  `create_date` datetime(0) NOT NULL COMMENT '举报时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '举报用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_report
-- ----------------------------
INSERT INTO `users_report` VALUES ('180521FZ501ABDYW', '180425CFA4RB6T0H', '180510CD0A6K3SRP', '引人不适', '不合时宜的视频', '180518CKMAAM5TXP', '2018-05-21 20:58:35');
INSERT INTO `users_report` VALUES ('180521FZK44ZRWX4', '180425CFA4RB6T0H', '180510CD0A6K3SRP', '引人不适', '不合时宜的视频', '180518CKMAAM5TXP', '2018-05-21 20:59:53');
INSERT INTO `users_report` VALUES ('180521FZR1TYRTXP', '180425CFA4RB6T0H', '180510CD0A6K3SRP', '辱骂谩骂', 't4t43', '180518CKMAAM5TXP', '2018-05-21 21:00:18');
INSERT INTO `users_report` VALUES ('200202D8GS13AT9P', '180425CFA4RB6T0H', '180510CC3819RHBC', '广告垃圾', '测试举报', '1001', '2020-02-02 18:38:37');

-- ----------------------------
-- Table structure for videos
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发布者id',
  `audio_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户使用音频的信息',
  `video_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频描述',
  `video_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频存放的路径',
  `video_seconds` float(6, 2) NULL DEFAULT NULL COMMENT '视频秒数',
  `video_width` int(6) NULL DEFAULT NULL COMMENT '视频宽度',
  `video_height` int(6) NULL DEFAULT NULL COMMENT '视频高度',
  `cover_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频封面图',
  `like_counts` bigint(20) NOT NULL DEFAULT 0 COMMENT '喜欢/赞美的数量',
  `status` int(1) NOT NULL COMMENT '视频状态：\r\n1、发布成功\r\n2、禁止播放，管理员操作',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of videos
-- ----------------------------
INSERT INTO `videos` VALUES ('180510CC3819RHBC', '180425CFA4RB6T0H', '', '风景', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 10.05, 960, 540, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 1, 1, '2018-05-10 17:25:13');
INSERT INTO `videos` VALUES ('180510CCCK8A6S14', '180425CFA4RB6T0H', '', '夏天夏天', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 10.00, 960, 540, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-10 17:26:13');
INSERT INTO `videos` VALUES ('180510CCK95WNG7C', '180425CFA4RB6T0H', '', '海贼王', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 10.02, 544, 960, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-10 17:26:43');
INSERT INTO `videos` VALUES ('180510CCNC7C9FCH', '180425CFA4RB6T0H', '', '吃饭吃饭', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 6.02, 960, 544, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-10 17:26:57');
INSERT INTO `videos` VALUES ('180510CCSFC45A5P', '180425CFA4RB6T0H', '', '风景可以', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 9.90, 960, 404, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-10 17:27:17');
INSERT INTO `videos` VALUES ('180510CCX05TABHH', '180425CFA4RB6T0H', '', '变魔术', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 6.02, 540, 960, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-10 17:27:33');
INSERT INTO `videos` VALUES ('180510CD0A6K3SRP', '180425CFA4RB6T0H', '', '来一场说走就走的旅行', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 5.02, 960, 544, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-10 17:27:54');
INSERT INTO `videos` VALUES ('180513FW054FFRAW', '180425CFA4RB6T0H', '', '复用上传测试', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 7.52, 544, 960, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-13 20:49:03');
INSERT INTO `videos` VALUES ('180522FB4BZ1N9P0', '180425CFA4RB6T0H', '', '骑着野马出去浪………~~', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 9.00, 540, 960, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2018-05-22 20:10:28');
INSERT INTO `videos` VALUES ('190516DH5TM2G540', '190425CFA4RB6T0H', NULL, '风景', 'b852f57296ef.mp4', 25.97, 700, 1080, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2019-07-09 08:10:04');
INSERT INTO `videos` VALUES ('190705DH5TM2G540', '190630HP2BB240ZC', '18052674D26HH32P', '12345', '/190630HP2BB240ZC/video/015d9c22-19ff-41b7-9323-b852f57296ef.mp4', 25.97, 700, 1080, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2019-07-05 11:01:35');
INSERT INTO `videos` VALUES ('200114118874703921152', '1001', '', '野子', '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.3xg6Y2gmuCgJ7316d621243b6ced77975e063b2ad047.mp4', 26.00, 700, 1080, '/1001/video/wx094047c54a0a03e1.jpg', 0, 1, '2020-01-14 15:44:44');
INSERT INTO `videos` VALUES ('20011480875391811584', '1001', '180530DXKK4YYGTC', '测试上传视频与封面', '/1001/video/222f01a0-54b1-448d-b315-05b1e9c810b4.mp4', 17.51, 480, 960, '/1001/video/wx094047c54a0a03e1.o6zAJs55hQd4bAw9hytEAxsQ_fYY.IhuWcZFlrLGQ2d43822e3474ee8fe5a2b6b61d15e050.jpg', 0, 1, '2020-01-14 10:42:44');

SET FOREIGN_KEY_CHECKS = 1;
