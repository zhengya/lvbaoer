/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : lvbaoer

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-01-22 16:14:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(500) NOT NULL,
  `TITLEID` int(10) NOT NULL,
  `CONTENT` text,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', 'user001', '2', '123456789', '2018-01-20 18:05:27');
INSERT INTO `comment` VALUES ('3', 'user001', '2', '123456789', '2018-01-20 18:05:30');
INSERT INTO `comment` VALUES ('4', 'user001', '2', '123456789', '2018-01-21 17:54:11');
INSERT INTO `comment` VALUES ('5', 'user001', '2', '123456789', '2018-01-21 18:10:24');
INSERT INTO `comment` VALUES ('6', 'user001', '2', '123456789', '2018-01-21 18:10:26');
INSERT INTO `comment` VALUES ('7', 'user001', '2', '123456789', '2018-01-21 18:12:22');
INSERT INTO `comment` VALUES ('8', 'user001', '2', '123456789', '2018-01-21 18:12:46');
INSERT INTO `comment` VALUES ('9', 'user001', '3', '123456789', '2018-01-21 18:48:52');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPEID` int(11) DEFAULT NULL,
  `NAME` varchar(500) CHARACTER SET utf8 NOT NULL,
  `PRICE` float NOT NULL,
  `LOCALPRICE` float DEFAULT NULL,
  `HEADIMAGE` varchar(500) CHARACTER SET utf8 NOT NULL,
  `IMAGES` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CONTENT` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', '商品1商品1商品1商品1', '109', null, 'https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif___https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 20:45:24');
INSERT INTO `goods` VALUES ('2', '1', '商品2商品2商品2商品2', '109', '99', 'https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif___https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 20:45:24');
INSERT INTO `goods` VALUES ('3', '1', '商品3商品3商品3商品3', '109', '99', 'https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif___https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 20:45:24');
INSERT INTO `goods` VALUES ('4', '2', '商品4商品4商品4商品4', '109', '99', 'https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif___https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 20:45:24');
INSERT INTO `goods` VALUES ('5', '2', '商品5商品5商品5商品5', '109', '99', 'https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif___https://www.baidu.com/img/baidu_jgylogo3.gif', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 20:45:24');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 NOT NULL,
  `URL` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `IMAGE` varchar(500) CHARACTER SET utf8 NOT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('1', '购健康', null, 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 20:43:11');
INSERT INTO `goods_type` VALUES ('2', '必选专区', null, 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 20:44:18');

-- ----------------------------
-- Table structure for health_center
-- ----------------------------
DROP TABLE IF EXISTS `health_center`;
CREATE TABLE `health_center` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(500) CHARACTER SET utf8 NOT NULL,
  `SHORTNAME` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `WORKSTARTTIME` time NOT NULL,
  `WORKENDTIME` time NOT NULL,
  `RESTTIME` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `PROVINCE` varchar(50) CHARACTER SET utf8 NOT NULL,
  `CITY` varchar(50) CHARACTER SET utf8 NOT NULL,
  `AREA` varchar(50) CHARACTER SET utf8 NOT NULL,
  `DETAIL` varchar(500) CHARACTER SET utf8 NOT NULL,
  `IMAGE` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `SERVES` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of health_center
-- ----------------------------
INSERT INTO `health_center` VALUES ('1', '军区医协体检中心', '奥体店', '07:30:00', '11:30:00', '周日休息', '北京市', '北京市', '海淀区', '奥体中心', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516603135206&di=87fe40ee233f02600ab1d8790418b559&imgtype=0&src=http%3A%2F%2Fpic.newssc.org%2F0%2F12%2F13%2F94%2F12139414_035561.jpg', '2018-01-21 14:55:08', '^1$___^2$___^3$___^4$');
INSERT INTO `health_center` VALUES ('2', '军区医协体检中心', '奥体店', '09:00:00', '12:30:00', '周日休息', '北京市', '北京市', '朝阳区', '奥体中心', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516603280403&di=33a95aeba33df55a00b32882102092e5&imgtype=0&src=http%3A%2F%2Fqjwb.zjol.com.cn%2Fimages%2F2015-07%2F03%2Fqjwb20150703z0004v01b004.jpg', '2018-01-21 14:55:08', '^1$___^3$___^4$');
INSERT INTO `health_center` VALUES ('3', '军区医协体检中心', '奥体店', '08:30:00', '11:30:00', '周日休息', '北京市', '北京市', '昌平区', '奥体中心', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516618233669&di=761e32873663a264bf04d11d5c055090&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fbaike%2Fw%253D268%2Fsign%3D50c6bca27cd98d1076d40b37193fb807%2Fbd315c6034a85edff3aad47d49540923dd54754d.jpg', '2018-01-21 14:55:08', '^1$___^2$___^4$');
INSERT INTO `health_center` VALUES ('4', '军区医协体检中心', '奥体店', '08:00:00', '11:30:00', '周日休息', '北京市', '北京市', '朝阳区', '奥体中心', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516618265187&di=ac7c5140fe147190f7730ba93ddf3083&imgtype=0&src=http%3A%2F%2Fwww.gs.xinhuanet.com%2Fnews%2F2016-12%2F23%2F1120176445_14824786008781n.jpg', '2018-01-21 14:55:08', '^2$___^3$___^4$');

-- ----------------------------
-- Table structure for health_title
-- ----------------------------
DROP TABLE IF EXISTS `health_title`;
CREATE TABLE `health_title` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(500) NOT NULL,
  `IMAGE` varchar(500) NOT NULL,
  `CONTENT` text NOT NULL,
  `VIDEO` varchar(500) DEFAULT NULL,
  `TYPE` varchar(10) NOT NULL,
  `BROWERNUM` int(11) NOT NULL DEFAULT '0',
  `COMMENTNUM` int(11) NOT NULL DEFAULT '0',
  `CREATETIME` datetime NOT NULL,
  `ISBANNER` int(1) NOT NULL DEFAULT '0' COMMENT '是否置顶',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of health_title
-- ----------------------------
INSERT INTO `health_title` VALUES ('1', '123', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '1323', '23123', 'IMAGE', '0', '0', '2018-01-17 15:09:25', '1');
INSERT INTO `health_title` VALUES ('2', '2222', 'https://www.baidu.com/img/baidu_jgylogo3.gif___https://www.baidu.com/img/baidu_jgylogo3.gif___https://www.baidu.com/img/baidu_jgylogo3.gif', '222', '222', 'IMAGE', '5', '7', '2018-01-20 16:43:48', '0');
INSERT INTO `health_title` VALUES ('3', '3333', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '3333', '333', 'VIDEO', '0', '1', '2018-01-20 16:44:03', '0');
INSERT INTO `health_title` VALUES ('4', '4444', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '4444', '4444', 'VIDEO', '0', '0', '2018-01-20 16:44:26', '0');
INSERT INTO `health_title` VALUES ('5', '5555', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '5555', '5555', 'VIDEO', '0', '0', '2018-01-20 16:44:39', '1');

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(500) CHARACTER SET utf8 NOT NULL,
  `ORDERID` varchar(500) CHARACTER SET utf8 NOT NULL,
  `WXORDERID` varchar(500) CHARACTER SET utf8 NOT NULL,
  `STATUS` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PRICE` float NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `PAYTIME` datetime DEFAULT NULL,
  `COMPLETETIME` datetime DEFAULT NULL,
  `ADDRID` int(11) DEFAULT NULL,
  `DELIVERYNAME` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `DELIVERYNO` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods
-- ----------------------------
INSERT INTO `order_goods` VALUES ('8', 'user001', '1516542058647', 'test', '已完成', '288', '2018-01-21 21:40:59', null, null, '2', null, null);

-- ----------------------------
-- Table structure for order_goods_list
-- ----------------------------
DROP TABLE IF EXISTS `order_goods_list`;
CREATE TABLE `order_goods_list` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `STANDARDID` int(10) NOT NULL,
  `AMOUNT` int(5) NOT NULL,
  `ORDERID` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods_list
-- ----------------------------
INSERT INTO `order_goods_list` VALUES ('1', '1', '1', '8');
INSERT INTO `order_goods_list` VALUES ('2', '8', '1', '8');

-- ----------------------------
-- Table structure for order_serve
-- ----------------------------
DROP TABLE IF EXISTS `order_serve`;
CREATE TABLE `order_serve` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(500) CHARACTER SET utf8 NOT NULL,
  `ORDERID` varchar(500) CHARACTER SET utf8 NOT NULL,
  `WXORDERID` varchar(500) CHARACTER SET utf8 NOT NULL,
  `STATUS` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PRICE` float NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `PAYTIME` datetime DEFAULT NULL,
  `COMPLETETIME` datetime DEFAULT NULL,
  `ADDRID` int(11) DEFAULT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PHONE` varchar(11) CHARACTER SET utf8 NOT NULL,
  `TIME` datetime NOT NULL,
  `CENTERID` int(11) NOT NULL,
  `SERVEID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_serve
-- ----------------------------
INSERT INTO `order_serve` VALUES ('3', 'user001', '1516527904502', 'test', '已完成', '799', '2018-01-21 17:45:05', null, null, '2', '李舒', '13661309890', '2018-01-30 09:00:00', '1', '1');
INSERT INTO `order_serve` VALUES ('4', 'user001', '1516528077619', 'test', '已完成', '799', '2018-01-21 17:47:58', null, null, '2', '李舒', '13661309890', '2018-01-31 09:00:00', '1', '1');
INSERT INTO `order_serve` VALUES ('5', 'user001', '1516528078233', 'test', '已完成', '799', '2018-01-21 17:47:58', null, null, '2', '李舒', '13661309890', '2018-01-21 09:00:00', '1', '1');
INSERT INTO `order_serve` VALUES ('6', 'user001', '1516528468424', 'test', '已完成', '799', '2018-01-21 17:54:28', null, null, '2', '李舒', '13661309890', '2018-01-21 09:00:00', '1', '1');
INSERT INTO `order_serve` VALUES ('7', 'user001', '1516529277693', 'test', '已完成', '799', '2018-01-21 18:07:58', null, null, '2', '李舒', '13661309890', '2018-01-21 09:00:00', '1', '1');

-- ----------------------------
-- Table structure for recive_address
-- ----------------------------
DROP TABLE IF EXISTS `recive_address`;
CREATE TABLE `recive_address` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(500) CHARACTER SET utf8 NOT NULL,
  `NAME` varchar(10) CHARACTER SET utf8 NOT NULL,
  `PHONE` varchar(11) CHARACTER SET utf8 NOT NULL,
  `PROVINCE` varchar(10) CHARACTER SET utf8 NOT NULL,
  `CITY` varchar(10) CHARACTER SET utf8 NOT NULL,
  `AREA` varchar(10) CHARACTER SET utf8 NOT NULL,
  `DETAIL` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recive_address
-- ----------------------------
INSERT INTO `recive_address` VALUES ('2', 'user001', '李舒', '13661309890', '北京', '北京', '通州', '宋庄镇', '2018-01-20 15:58:44');
INSERT INTO `recive_address` VALUES ('3', 'user001', '李舒', '13661309890', '北京', '北京', '通州', '宋庄镇', '2018-01-20 16:00:06');
INSERT INTO `recive_address` VALUES ('4', 'user001', '李舒', '13661309890', '北京', '北京', '通州', '宋庄镇', '2018-01-20 16:38:34');
INSERT INTO `recive_address` VALUES ('5', 'user001', '李舒', '13661309890', '北京', '北京', '通州', '宋庄镇', '2018-01-21 17:53:47');
INSERT INTO `recive_address` VALUES ('6', 'user001', '李舒', '13661309890', '北京', '北京', '通州', '宋庄镇', '2018-01-21 18:07:26');

-- ----------------------------
-- Table structure for serve
-- ----------------------------
DROP TABLE IF EXISTS `serve`;
CREATE TABLE `serve` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(500) CHARACTER SET utf8 NOT NULL,
  `PRICE` float DEFAULT NULL,
  `LOCALPRICE` float DEFAULT NULL,
  `HEADIMAGE` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CONTENT` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `IMAGES` text CHARACTER SET utf8,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serve
-- ----------------------------
INSERT INTO `serve` VALUES ('1', '出入境体检', '850', '1255', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516593577932&di=fa1466f2384391acf5fc248553dbae79&imgtype=0&src=http%3A%2F%2Fimages.qudao.com%2Fbrandimgs%2F2015-12-07%2F56654d1a82fad_520_430.jpg', '<div style=\'font-size:16px; color: gray\' >图文详情</div>', '2018-01-21 14:34:47', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516593577932&di=fa1466f2384391acf5fc248553dbae79&imgtype=0&src=http%3A%2F%2Fimages.qudao.com%2Fbrandimgs%2F2015-12-07%2F56654d1a82fad_520_430.jpg___https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516601049255&di=bea00d51906971d2bb4a50524bbad262&imgtype=0&src=http%3A%2F%2Fpic.qbaobei.com%2FUploads%2FPicture%2F2016-08-27%2F57c1098a1bbfc.jpg___https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516601262877&di=b53b49a05b0f819b77725e03cbe605f5&imgtype=0&src=http%3A%2F%2Fhealth.365jia.cn%2Fuploads%2Fnews%2Ffolder_1617590%2Fimages%2F6e4893db3be901aeadc56fa1dc11ab08.jpg');
INSERT INTO `serve` VALUES ('2', '入职体检', '299', '375', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516593515989&di=962d547a44042022c6048f1df594af51&imgtype=0&src=http%3A%2F%2Fimg1.100ye.com%2Fimg1%2F4%2F1450%2F1458%2F11176458%2Fmsgpic%2Ff6241616082c5764beba21d1113b7213.jpg', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 14:34:50', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516593515989&di=962d547a44042022c6048f1df594af51&imgtype=0&src=http%3A%2F%2Fimg1.100ye.com%2Fimg1%2F4%2F1450%2F1458%2F11176458%2Fmsgpic%2Ff6241616082c5764beba21d1113b7213.jpg');
INSERT INTO `serve` VALUES ('3', '健康体检', '1899', '2500', 'http://image.ytcutv.com/material/news/img/2016/03/677aa2a27e9f0d614153fdf66a7c9553.jpg', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 14:34:53', 'http://image.ytcutv.com/material/news/img/2016/03/677aa2a27e9f0d614153fdf66a7c9553.jpg');
INSERT INTO `serve` VALUES ('4', '疫苗', '200', '358', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516593200745&di=b8349e97b9bda5afd1c18e538ced07e0&imgtype=0&src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ffd%2Ftuangou%2Fg4%2FM07%2F63%2FFD%2FCggYHVaVDlaAOVBvAABO18l2uus897_720_480_s.jpg', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-21 14:34:55', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516593200745&di=b8349e97b9bda5afd1c18e538ced07e0&imgtype=0&src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ffd%2Ftuangou%2Fg4%2FM07%2F63%2FFD%2FCggYHVaVDlaAOVBvAABO18l2uus897_720_480_s.jpg');

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `GOODSID` int(10) NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 NOT NULL,
  `PRICE` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of standard
-- ----------------------------
INSERT INTO `standard` VALUES ('1', '1', '一盒三瓶装', '109');
INSERT INTO `standard` VALUES ('2', '1', '一盒五瓶装', '179');
INSERT INTO `standard` VALUES ('3', '2', '一盒三瓶装', '109');
INSERT INTO `standard` VALUES ('4', '2', '一盒五瓶装', '179');
INSERT INTO `standard` VALUES ('5', '3', '一盒三瓶装', '109');
INSERT INTO `standard` VALUES ('6', '3', '一盒五瓶装', '179');
INSERT INTO `standard` VALUES ('7', '4', '300mL', '109');
INSERT INTO `standard` VALUES ('8', '4', '500mL', '179');
INSERT INTO `standard` VALUES ('9', '5', '一箱6瓶', '109');
INSERT INTO `standard` VALUES ('10', '5', '一箱12瓶', '179');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `NAME` varchar(500) CHARACTER SET utf8 NOT NULL,
  `IMAGE` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user001', 'user001', 'https://www.baidu.com/img/baidu_jgylogo3.gif', '2018-01-20 15:57:06');
