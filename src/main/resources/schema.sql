/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : ireland_light

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-12-03 23:01:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新',
  `visibility` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '省份',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '城市',
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '区县',
  `street` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '街道',
  `post` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '邮编',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '详细地址',
  `consumer_id` int(11) unsigned NOT NULL COMMENT '消费者表的逻辑外键',
  `is_default` tinyint(3) unsigned NOT NULL COMMENT '默认地址标示，如果是默认地址为“1”，不是为“0”',
  `consumer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收货人姓名，未必会是注册用户的真实姓名',
  `consumer_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收货人联系方式',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_last_update` (`last_update`) USING BTREE,
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES ('1', '2016-12-02 23:17:52', '2016-12-03 14:38:10', '0', '陕西省', '西安市', '长安区', '西长安街', '710100', '西安邮电大学东区', '1002', '1', '陈象', '13279233333');
INSERT INTO `tb_address` VALUES ('2', '2016-12-02 23:19:10', '2016-12-03 14:38:17', '0', '陕西省', '西安市', '长安区', '西长安街', '710100', '西安邮电大学', '1002', '0', '高爽', '15809333333');
INSERT INTO `tb_address` VALUES ('3', '2016-12-02 23:21:22', '2016-12-03 14:38:22', '0', '陕西省', '西安市', '长安区', '西长安街', '710100', '春天花园1102', '1003', '1', '高爽', '15809243242');
INSERT INTO `tb_address` VALUES ('4', '2016-12-02 23:22:51', '2016-12-03 15:00:34', '1', '陕西省', '西安市', '蓝田县', '孟村乡', '710521', '姚村四组', '1002', '0', '陈象', '15129432343');
INSERT INTO `tb_address` VALUES ('5', '2016-12-02 23:24:49', '2016-12-03 14:38:29', '0', '陕西省', '西安市', '天界', '南街', '710038', '南天门外', '1004', '1', '张起灵', '18509432424');
INSERT INTO `tb_address` VALUES ('6', '2016-12-02 23:27:31', '2016-12-03 14:38:36', '0', '陕西省', '西安市', '长安区', '西长安街', '710100', '西安邮电大学东区', '1001', '1', '会长', '15596842342');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '评论内容',
  `consumer_id` int(11) unsigned DEFAULT NULL COMMENT '消费者表主键做逻辑外键，与productor_id互斥',
  `productor_id` int(11) unsigned DEFAULT NULL COMMENT '管理者表主键做逻辑外键，与consumer_id互斥',
  `goods_id` int(11) unsigned NOT NULL COMMENT '商品表主键做逻辑外键',
  `commented_id` int(11) unsigned DEFAULT NULL COMMENT '评论表主键做逻辑外键，用于存储子环一对多关系',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_last_update` (`last_update`) USING BTREE,
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('1', '2016-12-03 13:24:00', '2016-12-03 14:22:39', '0', '好吃好吃好吃好吃', '1001', null, '1', null);
INSERT INTO `tb_comment` VALUES ('2', '2016-12-03 13:24:33', '2016-12-03 14:22:39', '0', '真的很好吃', null, '2', '1', '1');
INSERT INTO `tb_comment` VALUES ('3', '2016-12-03 13:25:18', '2016-12-03 14:22:40', '0', '我也觉得好吃', '1002', null, '1', '2');
INSERT INTO `tb_comment` VALUES ('4', '2016-12-03 13:27:16', '2016-12-03 14:22:42', '0', '这个好吃不', '1003', null, '2', null);

-- ----------------------------
-- Table structure for tb_consumer
-- ----------------------------
DROP TABLE IF EXISTS `tb_consumer`;
CREATE TABLE `tb_consumer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否可见',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '盐值',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '昵称',
  `head_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户头像链接',
  `score` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户积分',
  `wallet` decimal(11,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '余额',
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '性别',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '电子邮件',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '联系方式',
  `birthday` datetime NOT NULL COMMENT '生日',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_last_update` (`last_update`) USING BTREE,
  KEY `idx_user_name` (`user_name`) USING BTREE,
  KEY `idx_password` (`password`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_consumer
-- ----------------------------
INSERT INTO `tb_consumer` VALUES ('1001', '2016-12-02 05:30:35', '2016-12-03 15:16:45', '0', 'destiny', '123456', '123456', '会长', 'http://ohke25t3s.bkt.clouddn.com/22dc4faf-ed74-46e7-8491-0e0e1f5b7ba9.jpg', '999', '123.45', '男', 'destinywk@163.com', '15596825802', '1994-03-31 15:13:39');
INSERT INTO `tb_consumer` VALUES ('1002', '2016-12-02 21:44:32', '2016-12-03 15:16:56', '0', 'elechen', 'qq519211', '116322', '大象', 'http://ohke25t3s.bkt.clouddn.com/10fd8d27-98b4-46a0-9ac2-7dd818b3fee1.jpg', '232', '234.56', '男', 'cx1041684034@hotmail.com', '13279252532', '1995-02-02 15:13:46');
INSERT INTO `tb_consumer` VALUES ('1003', '2016-12-02 21:45:13', '2016-12-03 15:17:08', '0', 'glady', '123456', '123456', '爽哥', 'http://ohke25t3s.bkt.clouddn.com/7f9ee2c7-055c-43e4-8719-b1302bdd2b71.jpg', '23', '345.67', '女', '838581982@qq.com', '15809235235', '1995-06-04 15:15:47');
INSERT INTO `tb_consumer` VALUES ('1004', '2016-12-02 21:51:52', '2016-12-03 15:17:25', '0', 'laosi', '123456', '123456', '老九门', 'http://ohke25t3s.bkt.clouddn.com/506bb2c8-719c-46e7-8c4e-49e7e9a4c88d.jpg', '1', '456.78', '男', '491888888@qq.com', '18503452525', '1994-12-20 15:14:42');

-- ----------------------------
-- Table structure for tb_consumer_goods_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_consumer_goods_relation`;
CREATE TABLE `tb_consumer_goods_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL COMMENT '逻辑删除',
  `consumer_id` int(11) unsigned NOT NULL COMMENT '消费者表主键做逻辑外键',
  `goods_id` int(11) unsigned NOT NULL COMMENT '商品表主键做逻辑外键',
  PRIMARY KEY (`id`),
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_consumer_goods_relation
-- ----------------------------
INSERT INTO `tb_consumer_goods_relation` VALUES ('1', '2016-12-03 11:55:44', '2016-12-03 14:22:56', '0', '1001', '1');
INSERT INTO `tb_consumer_goods_relation` VALUES ('2', '2016-12-03 11:55:53', '2016-12-03 14:22:57', '0', '1001', '2');
INSERT INTO `tb_consumer_goods_relation` VALUES ('3', '2016-12-03 11:56:01', '2016-12-03 14:22:59', '0', '1002', '1');
INSERT INTO `tb_consumer_goods_relation` VALUES ('4', '2016-12-03 11:56:39', '2016-12-03 14:22:58', '0', '1003', '2');

-- ----------------------------
-- Table structure for tb_coupon
-- ----------------------------
DROP TABLE IF EXISTS `tb_coupon`;
CREATE TABLE `tb_coupon` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `target` int(11) unsigned NOT NULL COMMENT '消费金额',
  `reduce` int(11) unsigned NOT NULL COMMENT '优惠金额',
  `consumer_id` int(11) unsigned NOT NULL COMMENT '消费者表主键做逻辑外键',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '满减券内容',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_last_update` (`last_update`) USING BTREE,
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_coupon
-- ----------------------------
INSERT INTO `tb_coupon` VALUES ('1', '2016-12-03 00:50:29', '2016-12-03 14:58:14', '1', '100', '10', '1001', '圣诞大欢乐,满100减10!!!!');
INSERT INTO `tb_coupon` VALUES ('2', '2016-12-03 00:51:31', '2016-12-03 14:58:12', '0', '200', '30', '1001', '平安夜大促销,满200减30!!!');
INSERT INTO `tb_coupon` VALUES ('3', '2016-12-03 00:51:57', '2016-12-03 13:59:37', '0', '100', '10', '1002', '圣诞大欢乐,满100减10!!!!');
INSERT INTO `tb_coupon` VALUES ('4', '2016-12-03 00:54:23', '2016-12-03 13:59:39', '0', '200', '30', '1002', '平安夜大促销,满200减30!!!');
INSERT INTO `tb_coupon` VALUES ('5', '2016-12-03 11:52:59', '2016-12-03 14:57:52', '1', '50', '3', '1003', '小小心意,满五十减3块');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) NOT NULL,
  `is_putaway` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否上架',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '商品名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '商品描述',
  `price` decimal(11,2) unsigned NOT NULL COMMENT '商品单价',
  `preference` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '蛋糕偏好',
  `use` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '蛋糕用途',
  `taste` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '蛋糕口味',
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '尺寸',
  `quantity` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `sale_count` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '销售量',
  `weight` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '蛋糕权重',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_last_update` (`last_update`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('1', '2016-12-02 23:00:53', '2016-12-03 15:19:25', '0', '0', '脆皮朱古力蛋糕', '香甜可口的脆皮朱古力蛋糕', '123.23', '脆皮', '吃', '香甜', '1', '10', '13', '20');
INSERT INTO `tb_goods` VALUES ('2', '2016-12-03 00:20:42', '2016-12-03 16:32:38', '0', '0', '奶油蛋糕', '奶油', '23.88', '奶油', '吃', '奶油', '1', '10', '33', '20');

-- ----------------------------
-- Table structure for tb_goods_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_image`;
CREATE TABLE `tb_goods_image` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `is_major` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否为主图（非轮播图）',
  `goods_id` int(11) unsigned NOT NULL COMMENT '商品表主键做逻辑外键',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '图片链接',
  `position` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '在轮播图中的位置',
  PRIMARY KEY (`id`),
  KEY `idx_goods_id` (`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods_image
-- ----------------------------
INSERT INTO `tb_goods_image` VALUES ('1', '2016-12-02 23:36:25', '2016-12-03 15:25:53', '0', '1', '1', 'http://ohke25t3s.bkt.clouddn.com/4004fd8c-5812-4ec5-a34b-f6d529b1c5d2.jpg', '1');
INSERT INTO `tb_goods_image` VALUES ('2', '2016-12-03 00:12:29', '2016-12-03 15:25:57', '0', '0', '1', 'http://ohke25t3s.bkt.clouddn.com/824e2f6a-bead-4163-abe4-b8700ab8a8f3.jpeg.jpg', '2');
INSERT INTO `tb_goods_image` VALUES ('3', '2016-12-03 00:12:43', '2016-12-03 15:25:58', '0', '0', '1', 'http://ohke25t3s.bkt.clouddn.com/327011d1-88f4-4af0-90e3-a8b1d8fc2ed5.jpg', '3');
INSERT INTO `tb_goods_image` VALUES ('4', '2016-12-03 00:13:04', '2016-12-03 15:25:59', '0', '0', '1', 'http://ohke25t3s.bkt.clouddn.com/0a79f197-9a12-41b3-b432-7d832114ec1e.jpg', '4');
INSERT INTO `tb_goods_image` VALUES ('5', '2016-12-03 00:24:19', '2016-12-03 15:26:03', '0', '1', '2', 'http://ohke25t3s.bkt.clouddn.com/fea463d0-76b4-406a-88b4-30f9c4fce232.jpg', '1');
INSERT INTO `tb_goods_image` VALUES ('6', '2016-12-03 00:24:26', '2016-12-03 15:26:03', '0', '0', '2', 'http://ohke25t3s.bkt.clouddn.com/00d66a16-4d1c-4b58-ad03-5b366c3fb6cc.jpg', '2');
INSERT INTO `tb_goods_image` VALUES ('7', '2016-12-03 00:24:27', '2016-12-03 15:26:04', '0', '0', '2', 'http://ohke25t3s.bkt.clouddn.com/e4ce155a-8739-4d50-8ed7-17c52c0dd1ef.jpeg', '3');
INSERT INTO `tb_goods_image` VALUES ('8', '2016-12-03 00:24:28', '2016-12-03 15:26:04', '0', '0', '2', 'http://ohke25t3s.bkt.clouddn.com/d83aa057-574b-45d1-b764-aea7f6c1e7c7.jpeg', '4');

-- ----------------------------
-- Table structure for tb_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_history`;
CREATE TABLE `tb_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `consumer_id` int(11) unsigned NOT NULL COMMENT '消费者表主键做逻辑外键',
  `goods_id` int(11) unsigned NOT NULL COMMENT '商品表主键做逻辑外键',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_history
-- ----------------------------
INSERT INTO `tb_history` VALUES ('1', '2016-12-03 13:27:36', '2016-12-03 14:02:03', '0', '1001', '1');
INSERT INTO `tb_history` VALUES ('2', '2016-12-03 13:27:52', '2016-12-03 14:02:06', '0', '1002', '2');
INSERT INTO `tb_history` VALUES ('3', '2016-12-03 13:28:51', '2016-12-03 15:27:12', '1', '1002', '2');
INSERT INTO `tb_history` VALUES ('4', '2016-12-03 13:29:16', '2016-12-03 14:02:21', '0', '1003', '1');
INSERT INTO `tb_history` VALUES ('5', '2016-12-03 13:29:28', '2016-12-03 15:27:16', '0', '1004', '2');

-- ----------------------------
-- Table structure for tb_login_ticket
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_ticket`;
CREATE TABLE `tb_login_ticket` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `consumer_id` int(11) unsigned DEFAULT NULL COMMENT '消费者表主键做逻辑外键，与productor_id字段互斥',
  `productor_id` int(11) unsigned DEFAULT NULL COMMENT '管理者表主键做逻辑外键，与consumer_id互斥',
  `expired` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  `ticket` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户登录凭据(MD5加密)',
  `status` tinyint(4) unsigned NOT NULL COMMENT 'ticket状态',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_last_update` (`last_update`) USING BTREE,
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_login_ticket
-- ----------------------------
INSERT INTO `tb_login_ticket` VALUES ('1', '2016-12-03 15:47:30', '2016-12-03 15:47:30', '0', '1', null, '2016-12-09 15:47:20', 'agfsdgaegadfg', '0');
INSERT INTO `tb_login_ticket` VALUES ('2', '2016-12-03 15:47:46', '2016-12-03 15:47:46', '0', null, '1', '2016-12-15 15:47:37', 'dfhxdfhh', '1');
INSERT INTO `tb_login_ticket` VALUES ('3', '2016-12-03 15:48:11', '2016-12-03 15:50:00', '0', null, '1', '2017-12-01 15:47:53', 'gdsrghghdfh', '0');
INSERT INTO `tb_login_ticket` VALUES ('4', '2016-12-03 15:48:30', '2016-12-03 15:50:44', '0', '2', null, '2017-12-02 15:48:18', 'gdsfgsr', '0');

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `from_id` int(11) unsigned NOT NULL COMMENT '发送方的逻辑外键',
  `to_id` int(11) unsigned NOT NULL COMMENT '接收方主键',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '消息内容',
  `type` tinyint(4) unsigned NOT NULL COMMENT '消息类型，0为文本，1为图片',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_from_id` (`from_id`) USING BTREE,
  KEY `idx_to_id` (`to_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ('1', '2016-12-03 13:31:26', '2016-12-03 14:26:16', '0', '1001', '1', '请问这个蛋糕是什么口味的', '1');
INSERT INTO `tb_message` VALUES ('2', '2016-12-03 13:32:55', '2016-12-03 15:53:39', '1', '1002', '1', '你好,在吗?', '1');
INSERT INTO `tb_message` VALUES ('3', '2016-12-03 13:37:13', '2016-12-03 15:51:38', '0', '1002', '1', '店家你好,请问这个蛋糕含糖量高吗?', '1');
INSERT INTO `tb_message` VALUES ('4', '2016-12-03 14:08:06', '2016-12-03 14:26:14', '0', '1', '1001', '好吃的很!', '1');
INSERT INTO `tb_message` VALUES ('5', '2016-12-03 14:16:14', '2016-12-03 14:26:14', '0', '1', '1002', '这是款无糖的蛋糕.适合高血糖的人群吃', '1');
INSERT INTO `tb_message` VALUES ('6', '2016-12-03 14:26:07', '2016-12-03 15:51:04', '0', '1004', '1', 'http://ohke25t3s.bkt.clouddn.com/39817a62-8165-4e53-b312-49f3738754fc.jpg', '2');
INSERT INTO `tb_message` VALUES ('7', '2016-12-03 15:52:42', '2016-12-03 15:52:42', '0', '1', '0', '新活动来了!快来参加吧!!!', '1');

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `productor_id` int(11) unsigned NOT NULL COMMENT '管理员逻辑主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '内容',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_title` (`title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES ('1', '2016-12-03 14:18:19', '2016-12-03 14:36:37', '0', '1', '新店开张,欢迎光临!', 'Ireland_light蛋糕店开张啦,欢迎各位新朋友的加入.');
INSERT INTO `tb_news` VALUES ('2', '2016-12-03 14:33:43', '2016-12-03 16:13:41', '0', '2', '我的老板娘进驻新店', '老板娘来了,活动多多的!');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '订单编号',
  `consumer_id` int(11) unsigned NOT NULL COMMENT '消费者表主键做逻辑外键',
  `address_id` int(11) unsigned NOT NULL COMMENT '订单地址主键做逻辑外键',
  `pay_way` tinyint(4) NOT NULL COMMENT '付款方式',
  `transfer_way` tinyint(4) NOT NULL COMMENT '配送方式',
  `transfer_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户期望的送货时间',
  `gift` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户希望附赠的礼物',
  `table_ware_count` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '附赠餐具',
  `coupon_id` int(11) unsigned NOT NULL COMMENT '活动表主键做逻辑外键',
  `price` decimal(11,2) unsigned NOT NULL COMMENT '订单的价格',
  `transfer_begin` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '配送开始时间',
  `transfer_end` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '配送结束时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '消费者的留言',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_last_update` (`last_update`) USING BTREE,
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', '2016-12-02 23:33:03', '2016-12-03 14:55:54', '0', 'cx04141057', '1002', '1', '1', '1', '明天中午', '生日帽', '1', '0', '170.99', '2016-12-02 23:33:03', '2016-12-02 23:33:03', '1', '来之前打电话,餐具要带齐全');
INSERT INTO `tb_order` VALUES ('2', '2016-12-03 14:43:45', '2016-12-03 16:32:37', '0', 'cx04141058', '1004', '5', '1', '2', '今天下午', '生日牌,气球', '4', '1', '123.23', '2016-12-03 14:43:45', '2016-12-03 14:43:45', '0', '我没有留言');
INSERT INTO `tb_order` VALUES ('3', '2016-12-03 14:53:11', '2016-12-03 16:17:59', '0', 'cx04141058', '1003', '1', '2', '1', '明天中午', '生日帽', '1', '0', '170.99', '2016-12-03 14:53:11', '2016-12-03 14:53:11', '2', '我要快快收到蛋糕');

-- ----------------------------
-- Table structure for tb_order_goods_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_goods_relation`;
CREATE TABLE `tb_order_goods_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `order_id` int(11) unsigned NOT NULL COMMENT '订单表主键做逻辑外键',
  `goods_id` int(11) unsigned NOT NULL COMMENT '商品表主键做逻辑外键',
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order_goods_relation
-- ----------------------------
INSERT INTO `tb_order_goods_relation` VALUES ('1', '2016-12-02 23:33:36', '2016-12-02 23:33:36', '0', '1', '1', '1');
INSERT INTO `tb_order_goods_relation` VALUES ('2', '2016-12-03 14:39:51', '2016-12-03 14:39:51', '0', '1', '2', '2');
INSERT INTO `tb_order_goods_relation` VALUES ('3', '2016-12-03 14:40:20', '2016-12-03 14:40:20', '0', '2', '1', '1');
INSERT INTO `tb_order_goods_relation` VALUES ('4', '2016-12-03 14:55:13', '2016-12-03 14:55:13', '0', '3', '1', '1');
INSERT INTO `tb_order_goods_relation` VALUES ('5', '2016-12-03 14:55:27', '2016-12-03 14:55:27', '0', '3', '2', '2');

-- ----------------------------
-- Table structure for tb_productor
-- ----------------------------
DROP TABLE IF EXISTS `tb_productor`;
CREATE TABLE `tb_productor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL COMMENT '逻辑删除',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '管理员名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_productor
-- ----------------------------
INSERT INTO `tb_productor` VALUES ('1', '2016-12-03 13:47:06', '2016-12-03 14:35:35', '0', 'admin', '123456', '23435');
INSERT INTO `tb_productor` VALUES ('2', '2016-12-03 13:47:51', '2016-12-03 14:35:37', '0', 'boss', '123456', '23454');
INSERT INTO `tb_productor` VALUES ('3', '2016-12-03 13:49:03', '2016-12-03 13:49:03', '0', 'boss\swife', '123456', '23135');

-- ----------------------------
-- Table structure for tb_productor_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_productor_log`;
CREATE TABLE `tb_productor_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `productor_id` int(11) unsigned NOT NULL COMMENT '管理员表的外键',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作内容',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_productor_log
-- ----------------------------
INSERT INTO `tb_productor_log` VALUES ('1', '2016-12-03 14:34:36', '2016-12-03 14:34:36', '0', '1', '添加商品');
INSERT INTO `tb_productor_log` VALUES ('2', '2016-12-03 14:34:54', '2016-12-03 14:34:54', '0', '2', '下架商品');
INSERT INTO `tb_productor_log` VALUES ('3', '2016-12-03 22:58:23', '2016-12-03 22:58:23', '0', '1', '修改权重');

-- ----------------------------
-- Table structure for tb_shop_car
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_car`;
CREATE TABLE `tb_shop_car` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `consumer_id` int(11) unsigned NOT NULL COMMENT '消费者表主键',
  PRIMARY KEY (`id`),
  KEY `idx_consumer_id` (`consumer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shop_car
-- ----------------------------
INSERT INTO `tb_shop_car` VALUES ('1', '2016-12-03 00:13:59', '2016-12-03 00:13:59', '0', '1');
INSERT INTO `tb_shop_car` VALUES ('2', '2016-12-03 00:14:12', '2016-12-03 00:14:12', '0', '2');
INSERT INTO `tb_shop_car` VALUES ('3', '2016-12-03 00:14:13', '2016-12-03 00:14:13', '0', '3');
INSERT INTO `tb_shop_car` VALUES ('4', '2016-12-03 00:14:14', '2016-12-03 00:14:14', '0', '4');
INSERT INTO `tb_shop_car` VALUES ('5', '2016-12-03 21:16:16', '2016-12-03 21:16:16', '0', '5');

-- ----------------------------
-- Table structure for tb_shop_car_goods_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_car_goods_relation`;
CREATE TABLE `tb_shop_car_goods_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `visibility` tinyint(4) unsigned NOT NULL COMMENT '逻辑删除',
  `shop_car_id` int(11) unsigned NOT NULL COMMENT '购物车表主键做逻辑外键',
  `goods_id` int(11) unsigned NOT NULL COMMENT '商品表主键做逻辑外键',
  `count` int(11) unsigned NOT NULL COMMENT '每周商品的数量',
  PRIMARY KEY (`id`),
  KEY `idx_shop_car_id` (`shop_car_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shop_car_goods_relation
-- ----------------------------
INSERT INTO `tb_shop_car_goods_relation` VALUES ('1', '2016-12-03 00:19:14', '2016-12-03 14:35:55', '0', '1', '1', '1');
INSERT INTO `tb_shop_car_goods_relation` VALUES ('2', '2016-12-03 00:19:34', '2016-12-03 14:35:55', '0', '1', '2', '3');
INSERT INTO `tb_shop_car_goods_relation` VALUES ('3', '2016-12-03 00:30:29', '2016-12-03 14:35:55', '0', '2', '1', '1');
INSERT INTO `tb_shop_car_goods_relation` VALUES ('4', '2016-12-03 00:30:44', '2016-12-03 14:35:58', '0', '2', '2', '2');
INSERT INTO `tb_shop_car_goods_relation` VALUES ('5', '2016-12-03 00:31:37', '2016-12-03 14:35:56', '0', '3', '2', '2');
SET FOREIGN_KEY_CHECKS=1;
