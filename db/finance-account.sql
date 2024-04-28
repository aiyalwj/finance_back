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

 Date: 26/04/2024 16:52:18
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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支出类别表' ROW_FORMAT = Dynamic;

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
INSERT INTO `ex_cate` VALUES (9, '默认类别', '系统');

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
INSERT INTO `in_cate` VALUES (5, '默认类别', '系统');

-- ----------------------------
-- Table structure for shouzhi
-- ----------------------------
DROP TABLE IF EXISTS `shouzhi`;
CREATE TABLE `shouzhi`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '收支id',
  `time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '时间(YYYY-MM-DD HH：MM：SS)',
  `income` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入',
  `expenses` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支出',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '默认类别' COMMENT '类别',
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `belong` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '隶属于',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收支明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shouzhi
-- ----------------------------
INSERT INTO `shouzhi` VALUES (1, '2024-04-01 08:05:55', '25', '', '默认类别', '', 'xiaoming');
INSERT INTO `shouzhi` VALUES (2, '2024-04-02 08:05:56', '', '20', '餐饮', '', 'xiaofang');
INSERT INTO `shouzhi` VALUES (3, '2024-04-03 08:05:58', '', '36', '日用品', '', 'xiaofang');
INSERT INTO `shouzhi` VALUES (4, '2024-04-03 08:05:59', '', '20', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (5, '2024-04-03 08:06:00', '6.8', '', '默认类别', '', 'xiaofang');
INSERT INTO `shouzhi` VALUES (6, '2024-04-05 08:06:01', '', '7.5', '交通', '', 'xiaofang');
INSERT INTO `shouzhi` VALUES (7, '2024-04-07 08:06:02', '10', '', '转账', '', 'xiaofang');
INSERT INTO `shouzhi` VALUES (13, '2024-04-08 13:59:41', '', '123', '默认类别', '', 'test');
INSERT INTO `shouzhi` VALUES (14, '2024-04-09 14:02:55', '', '23', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (15, '2024-04-09 14:23:21', '', '159', '日用品', '1', 'test');
INSERT INTO `shouzhi` VALUES (16, '2024-04-10 14:26:34', '', '20', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (17, '2024-04-12 14:27:06', '', '20', '餐饮', '', 'test3');
INSERT INTO `shouzhi` VALUES (18, '2024-04-16 22:25:19', '', '20', '餐饮', '', 'test3');
INSERT INTO `shouzhi` VALUES (19, '2024-04-09 22:31:49', '', '123', '日用品', '556', 'test3');
INSERT INTO `shouzhi` VALUES (20, '2024-04-09 22:31:49', '', '200', '日用品', '556', 'test3');
INSERT INTO `shouzhi` VALUES (21, '2024-04-16 22:25:19', '', '20', '餐饮', '', 'test3');
INSERT INTO `shouzhi` VALUES (22, '2024-04-16 14:25:19', '', '20', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (23, '2024-03-05 14:31:49', '', '123', '日用品', '556', 'test');
INSERT INTO `shouzhi` VALUES (24, '2024-04-08 15:06:11', '50', '', '奖金', '', 'test');
INSERT INTO `shouzhi` VALUES (25, '2024-04-08 15:06:11', '123', '', '奖金', '123', 'test');
INSERT INTO `shouzhi` VALUES (38, '2024-04-08 09:30:26', '', '20', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (45, '2024-04-23 09:42:48', '', '33', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (46, '2024-04-23 09:44:09', '', '12', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (47, '2024-04-23 09:47:40', '', '20', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (48, '2024-04-23 09:48:48', '', '20', '日用品', '', 'test');
INSERT INTO `shouzhi` VALUES (49, '2024-04-23 09:52:42', '', '20', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (50, '2024-04-23 09:58:00', '', '2', '餐饮', '', 'test');
INSERT INTO `shouzhi` VALUES (51, '2024-04-23 10:33:22', '', '3', '默认类别', '', 'test');
INSERT INTO `shouzhi` VALUES (52, '2024-04-01 09:41:01', '', '20', '日用品', '', 'xiaoming');

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usermng
-- ----------------------------
INSERT INTO `usermng` VALUES (1, 'xiaoming', 'C4yzDc6adacab05fb4c04f33c7d973f069477', '12345678911', 'test@123.com');
INSERT INTO `usermng` VALUES (2, 'xiaofang', 'nG02d92a18d5694c3ee7deffec8c18bcd7dae', '12345678900', 'xiaofang@123.com');
INSERT INTO `usermng` VALUES (3, 'test', 'nG02d92a18d5694c3ee7deffec8c18bcd7dae', '22222222222', '123@123.com');
INSERT INTO `usermng` VALUES (4, 'test2', 'RvzZHe051fcde78c6c8155bc21b9f14d03fea', '12345678910', '123@123.com');
INSERT INTO `usermng` VALUES (5, 'test3', 'DLHJb58909b9fdec6a246e40ed369f7cad7be', '12345678910', '232323');
INSERT INTO `usermng` VALUES (6, 'test4', 'qBGTf41978c680580100f829596763a058e63', '12345678910', 'dsadsfd');
INSERT INTO `usermng` VALUES (7, 'test5', 'A6uPt917acd991f423e1b4edf159a24e7a355', '12345678910', 'ewfefswf');
INSERT INTO `usermng` VALUES (8, 'test6', 'Eo76b3972c373f729fb0b854a2307eecf9f33', '12345678910', 'dwdqwqd');
INSERT INTO `usermng` VALUES (9, 'test7', 'vXrumb37a85d25e451c2c2c7b8fa0b9fb6fb7', '12345678901', 'asdasdas');
INSERT INTO `usermng` VALUES (10, 'test8', 'R70Gi055dbb95c08527c352121099fa79751e', '12345678900', 'dawdwad');
INSERT INTO `usermng` VALUES (11, 'test9', '5b2er06ab85b99d329a64c2f0a950c8d06f5a', '12453534534', 'fsedfsf');
INSERT INTO `usermng` VALUES (12, 'test10', '8yl6A410542b4c78ac28de7cd60e2872cbb23', '12345678901', '123@123.com');
INSERT INTO `usermng` VALUES (13, 'test11', 'qaEUN4a9d3283ab96dfb89e00164944419497', '12345678901', '123@123.com');
INSERT INTO `usermng` VALUES (14, 'test12', 'zm8D66cbd68afacf39fee83da194de360e10f', '222222', '123@123.com');

SET FOREIGN_KEY_CHECKS = 1;

-- SELECT category AS name, COUNT(*) * 100.0/MAX(total_table.total_count) AS value,count(*) as hhh
-- FROM shouzhi
--     CROSS JOIN
--     (
--     SELECT count(*)as total_count
--     FROM shouzhi
--     WHERE category IN
--     (
--     SELECT category
--     FROM ex_cate
--     )
--     and belong = "test"
--     ) AS total_table
-- WHERE category IN (
--     select category
--     from ex_cate
--     )
--   and belong = "test"
-- GROUP BY category
