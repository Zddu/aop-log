/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : customer

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-03-14 11:36:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `logtype` varchar(255) DEFAULT NULL,
  `requestip` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `browser` varchar(255) DEFAULT NULL,
  `createdate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('3', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-13');
INSERT INTO `log` VALUES ('4', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-13');
INSERT INTO `log` VALUES ('5', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-13');
INSERT INTO `log` VALUES ('6', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-13');
INSERT INTO `log` VALUES ('7', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello2()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-13');
INSERT INTO `log` VALUES ('8', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '192.168.0.9', '内网IP', 'Chrome', '2020-03-13 15:02:49');
INSERT INTO `log` VALUES ('9', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '192.168.0.9', '内网IP', 'Chrome', '2020-03-13 23:03:24');
INSERT INTO `log` VALUES ('10', 'zdde', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-14 10:14:15');
INSERT INTO `log` VALUES ('11', 'zdde', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-14 10:14:15');
INSERT INTO `log` VALUES ('12', 'zdde', '查询测试', 'com.cidp.aoplog.controller.TestController.hello()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-14 10:15:56');
INSERT INTO `log` VALUES ('13', 'zdde', '查询测试', 'com.cidp.aoplog.controller.TestController.hello2()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Chrome', '2020-03-14 10:16:23');
INSERT INTO `log` VALUES ('14', 'zdde', '查询测试', 'com.cidp.aoplog.controller.TestController.hello2()', 'INFO', '0:0:0:0:0:0:0:1', '内网IP', 'Microsoft Edge', '2020-03-14 10:17:16');
INSERT INTO `log` VALUES ('15', 'test', '查询测试', 'com.cidp.aoplog.controller.TestController.hello2()', 'INFO', '192.168.192.33', '内网IP', 'Microsoft Edge', '2020-03-14 10:17:55');
