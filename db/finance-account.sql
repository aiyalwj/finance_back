/*
 Navicat MySQL Data Transfer

 Source Server         : lwj_local
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : finance-account

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 03/04/2024 16:55:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ex_cate
-- ----------------------------
DROP TABLE IF EXISTS `ex_cate`;
CREATE TABLE `ex_cate`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '支出类别id',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '支出类别名称',
  `belong` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '隶属于',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支出类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ex_cate
-- ----------------------------
INSERT INTO `ex_cate` VALUES (1, '餐饮', '系统');
INSERT INTO `ex_cate` VALUES (2, '日用品', '系统');
INSERT INTO `ex_cate` VALUES (3, '游戏', '系统');
INSERT INTO `ex_cate` VALUES (4, '服饰', '系统');
INSERT INTO `ex_cate` VALUES (5, '交通', '系统');
INSERT INTO `ex_cate` VALUES (6, '电子产品', '系统');
INSERT INTO `ex_cate` VALUES (7, '快递', '系统');
INSERT INTO `ex_cate` VALUES (8, '话费', '系统');

-- ----------------------------
-- Table structure for in_cate
-- ----------------------------
DROP TABLE IF EXISTS `in_cate`;
CREATE TABLE `in_cate`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '收入类别id',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收入类别名称',
  `belong` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '隶属于',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of in_cate
-- ----------------------------
INSERT INTO `in_cate` VALUES (1, '工资', '系统');
INSERT INTO `in_cate` VALUES (2, '奖金', '系统');
INSERT INTO `in_cate` VALUES (3, '红包', '系统');
INSERT INTO `in_cate` VALUES (4, '转账', '系统');

-- ----------------------------
-- Table structure for shouzhi
-- ----------------------------
DROP TABLE IF EXISTS `shouzhi`;
CREATE TABLE `shouzhi`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '收支id',
  `time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间(YYYY-MM-DD HH：MM：SS)',
  `income` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入',
  `expenses` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支出',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '默认类别' COMMENT '类别',
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `belong` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '隶属于',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收支明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shouzhi
-- ----------------------------
INSERT INTO `shouzhi` VALUES (1, '2024-04-03 16:21:27', '25', '', '默认类别', NULL, 'xiaoming');
INSERT INTO `shouzhi` VALUES (2, '2024-04-03 14:09:28', '20', '', '餐饮', '', 'xiaofang');

-- ----------------------------
-- Table structure for usermng
-- ----------------------------
DROP TABLE IF EXISTS `usermng`;
CREATE TABLE `usermng`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usermng
-- ----------------------------
INSERT INTO `usermng` VALUES (1, 'xiaoming', '123456', '12345678911', 'test@123.com');
INSERT INTO `usermng` VALUES (2, 'xiaofang', '85484', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
