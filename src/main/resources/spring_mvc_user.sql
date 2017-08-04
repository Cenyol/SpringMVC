/*
 Navicat MySQL Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 50542
 Source Host           : 127.0.0.1
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50542
 File Encoding         : utf-8

 Date: 08/04/2017 21:20:53 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `spring_mvc_user`
-- ----------------------------
DROP TABLE IF EXISTS `spring_mvc_user`;
CREATE TABLE `spring_mvc_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(32) DEFAULT NULL,
  `lastName` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `spring_mvc_user`
-- ----------------------------
BEGIN;
INSERT INTO `spring_mvc_user` VALUES ('1', 'taylor', 'hanqun', '123456'), ('2', 'Kobe', 'Bryant', '131415');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
