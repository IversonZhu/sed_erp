/*
 Navicat Premium Data Transfer

 Source Server         : Iverson
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : sed_market

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 17/07/2019 08:51:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sed_market_brand
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_brand`;
CREATE TABLE `sed_market_brand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `brand_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌名称',
  `status` int(255) NOT NULL COMMENT '状态  0:启用, 1:禁用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_brand
-- ----------------------------
INSERT INTO `sed_market_brand` VALUES (4, 'bn20190611114355131735', 'Li-Ning', 0, '2019-06-11 11:43:55', '2019-07-11 17:19:17');
INSERT INTO `sed_market_brand` VALUES (5, 'bn20190611153205719340', '耐克', 0, '2019-06-11 15:32:05', '2019-06-11 15:32:05');
INSERT INTO `sed_market_brand` VALUES (6, 'bn20190611155008374035', '阿迪达斯', 0, '2019-06-11 15:50:08', '2019-06-11 15:50:22');
INSERT INTO `sed_market_brand` VALUES (7, 'bn20190611155138572613', '匹克', 0, '2019-06-11 15:51:38', '2019-06-11 15:51:38');
INSERT INTO `sed_market_brand` VALUES (8, 'bn20190627114307211489', 'deli得力', 0, '2019-06-27 11:43:07', '2019-07-09 14:50:29');
INSERT INTO `sed_market_brand` VALUES (9, 'bn20190627114432887479', '乐趣生活', 0, '2019-06-27 11:44:32', '2019-06-27 11:44:32');
INSERT INTO `sed_market_brand` VALUES (10, 'bn20190627114837860577', '怡宝', 0, '2019-06-27 11:48:38', '2019-06-27 11:48:38');
INSERT INTO `sed_market_brand` VALUES (11, 'bn20190703094351981434', 'acer', 0, '2019-07-03 09:43:51', '2019-07-03 09:52:21');
INSERT INTO `sed_market_brand` VALUES (12, 'bn20190703102647366862', '维达', 0, '2019-07-03 10:26:47', '2019-07-11 09:52:55');
INSERT INTO `sed_market_brand` VALUES (13, 'bn20190709145052971655', 'dell', 0, '2019-07-09 14:50:52', '2019-07-09 14:51:06');
INSERT INTO `sed_market_brand` VALUES (14, 'bn20190711093924804920', '达利园', 0, '2019-07-11 09:39:24', '2019-07-11 09:39:24');

-- ----------------------------
-- Table structure for sed_market_category
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_category`;
CREATE TABLE `sed_market_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `parent_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级分类编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_category
-- ----------------------------
INSERT INTO `sed_market_category` VALUES (13, 'cn20190614160514708893', '电脑配件', '0', '2019-06-14 16:05:15', '2019-07-10 16:03:48');
INSERT INTO `sed_market_category` VALUES (14, 'cn20190614160539300877', '显示器', 'cn20190614160514708893', '2019-06-14 16:05:40', '2019-06-14 16:05:40');
INSERT INTO `sed_market_category` VALUES (15, 'cn20190614160624597832', 'cpu', 'cn20190614160514708893', '2019-06-14 16:06:24', '2019-06-14 16:06:24');
INSERT INTO `sed_market_category` VALUES (16, 'cn20190614160638745454', '硬盘', 'cn20190614160514708893', '2019-06-14 16:06:38', '2019-06-14 16:06:38');
INSERT INTO `sed_market_category` VALUES (17, 'cn20190614160645830499', '显卡', 'cn20190614160514708893', '2019-06-14 16:06:46', '2019-06-14 16:06:46');
INSERT INTO `sed_market_category` VALUES (18, 'cn20190614160656345090', '电源', 'cn20190614160514708893', '2019-06-14 16:06:56', '2019-06-14 16:06:56');
INSERT INTO `sed_market_category` VALUES (19, 'cn20190614160710872627', '主板', 'cn20190614160514708893', '2019-06-14 16:07:10', '2019-06-14 16:07:10');
INSERT INTO `sed_market_category` VALUES (20, 'cn20190627111459329286', '生活用品', '0', '2019-06-27 11:14:59', '2019-07-10 16:03:47');
INSERT INTO `sed_market_category` VALUES (21, 'cn20190627111816675021', '学习用品/文具', '0', '2019-06-27 11:18:16', '2019-07-10 16:03:51');
INSERT INTO `sed_market_category` VALUES (22, 'cn20190627111906437589', '饮料', 'cn20190627111459329286', '2019-06-27 11:19:06', '2019-06-27 11:19:06');
INSERT INTO `sed_market_category` VALUES (23, 'cn20190627112246992509', '胶水', 'cn20190627111816675021', '2019-06-27 11:22:46', '2019-07-11 10:48:31');
INSERT INTO `sed_market_category` VALUES (24, 'cn20190627120101343207', '玻璃制品', 'cn20190627111459329286', '2019-06-27 12:01:01', '2019-06-27 12:01:01');
INSERT INTO `sed_market_category` VALUES (25, 'cn20190703105319602938', '家居日用', 'cn20190627111459329286', '2019-07-03 10:53:19', '2019-07-03 10:53:19');
INSERT INTO `sed_market_category` VALUES (27, '0', '分类', NULL, '2019-07-10 16:03:35', '2019-07-10 16:03:35');
INSERT INTO `sed_market_category` VALUES (28, 'cn20190711103817167434', '食品', '0', '2019-07-11 10:38:17', '2019-07-11 10:38:17');
INSERT INTO `sed_market_category` VALUES (29, 'cn20190711103934890644', '糕点', 'cn20190711103817167434', '2019-07-11 10:39:34', '2019-07-11 10:39:34');
INSERT INTO `sed_market_category` VALUES (30, 'cn20190711104443245836', '书籍', 'cn20190627111816675021', '2019-07-11 10:44:43', '2019-07-11 10:44:43');
INSERT INTO `sed_market_category` VALUES (31, 'cn20190711104605143655', '数码', '0', '2019-07-11 10:46:05', '2019-07-11 10:46:05');
INSERT INTO `sed_market_category` VALUES (32, 'cn20190711104614821501', '手机', 'cn20190711104605143655', '2019-07-11 10:46:14', '2019-07-11 10:46:14');

-- ----------------------------
-- Table structure for sed_market_department
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_department`;
CREATE TABLE `sed_market_department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `parent_department_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级部门No',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_department
-- ----------------------------
INSERT INTO `sed_market_department` VALUES (1, 'DN20190628103616649402', '开发中心', 0, '2019-06-28 10:36:17', '2019-07-11 15:25:09', '0');
INSERT INTO `sed_market_department` VALUES (2, 'DN20190628111650494827', '经营中心', 0, '2019-06-28 11:16:50', '2019-07-11 15:27:14', '0');
INSERT INTO `sed_market_department` VALUES (3, 'DN20190702102837810737', '运营中心', 0, '2019-07-02 10:28:38', '2019-07-11 15:27:28', '0');
INSERT INTO `sed_market_department` VALUES (5, 'DN20190703133852891944', '生产中心', 0, '2019-07-03 13:38:52', '2019-07-11 15:27:44', '0');
INSERT INTO `sed_market_department` VALUES (6, '0', '桑达商用机器有限公司', 0, '2019-07-11 12:00:52', '2019-07-11 12:00:52', NULL);
INSERT INTO `sed_market_department` VALUES (7, 'DN20190711152626299289', '产品部', 0, '2019-07-11 15:26:26', '2019-07-11 15:26:26', 'DN20190628103616649402');
INSERT INTO `sed_market_department` VALUES (8, 'DN20190711152640354214', '技术部', 0, '2019-07-11 15:26:40', '2019-07-11 15:26:40', 'DN20190628103616649402');
INSERT INTO `sed_market_department` VALUES (9, 'DN20190711152649600731', '软件开发部', 0, '2019-07-11 15:26:49', '2019-07-11 15:26:49', 'DN20190628103616649402');
INSERT INTO `sed_market_department` VALUES (10, 'DN20190711152757614920', '服务中心', 0, '2019-07-11 15:27:57', '2019-07-11 15:27:57', '0');
INSERT INTO `sed_market_department` VALUES (11, 'DN20190711152813512497', '销售部', 0, '2019-07-11 15:28:13', '2019-07-11 15:28:13', 'DN20190628111650494827');
INSERT INTO `sed_market_department` VALUES (12, 'DN20190711152822981301', '市场管理部', 0, '2019-07-11 15:28:22', '2019-07-11 15:28:22', 'DN20190628111650494827');
INSERT INTO `sed_market_department` VALUES (13, 'DN20190711152840416454', '财务部', 0, '2019-07-11 15:28:40', '2019-07-11 15:28:40', 'DN20190702102837810737');
INSERT INTO `sed_market_department` VALUES (14, 'DN20190711152849290676', '行政人事部', 0, '2019-07-11 15:28:49', '2019-07-11 15:28:49', 'DN20190702102837810737');
INSERT INTO `sed_market_department` VALUES (15, 'DN20190711152906498742', '生产部', 0, '2019-07-11 15:29:06', '2019-07-11 15:29:06', 'DN20190703133852891944');
INSERT INTO `sed_market_department` VALUES (16, 'DN20190711152925597678', '物供部', 0, '2019-07-11 15:29:25', '2019-07-11 15:29:25', 'DN20190703133852891944');
INSERT INTO `sed_market_department` VALUES (17, 'DN20190711152932524650', '质量部', 0, '2019-07-11 15:29:32', '2019-07-11 15:29:32', 'DN20190703133852891944');
INSERT INTO `sed_market_department` VALUES (18, 'DN20190711152953770511', '天虹项目组', 0, '2019-07-11 15:29:53', '2019-07-11 15:29:53', 'DN20190711152757614920');
INSERT INTO `sed_market_department` VALUES (19, 'DN20190711153002746620', '福州', 0, '2019-07-11 15:30:02', '2019-07-11 15:30:02', 'DN20190711152757614920');
INSERT INTO `sed_market_department` VALUES (20, 'DN20190711153013936801', '上海', 0, '2019-07-11 15:30:13', '2019-07-11 15:30:13', 'DN20190711152757614920');
INSERT INTO `sed_market_department` VALUES (21, 'DN20190711153029382470', '深圳服务台', 0, '2019-07-11 15:30:29', '2019-07-11 15:30:29', 'DN20190711152757614920');
INSERT INTO `sed_market_department` VALUES (22, 'DN20190711153041566387', '深圳维修间', 0, '2019-07-11 15:30:41', '2019-07-11 15:30:41', 'DN20190711152757614920');
INSERT INTO `sed_market_department` VALUES (23, 'DN20190711153050841034', '浙江', 0, '2019-07-11 15:30:50', '2019-07-11 15:30:50', 'DN20190711152757614920');
INSERT INTO `sed_market_department` VALUES (24, 'DN20190711153056775357', '湖南', 0, '2019-07-11 15:30:56', '2019-07-11 15:30:56', 'DN20190711152757614920');
INSERT INTO `sed_market_department` VALUES (25, 'DN20190711153103549615', '江西', 0, '2019-07-11 15:31:03', '2019-07-11 15:31:03', 'DN20190711152757614920');

-- ----------------------------
-- Table structure for sed_market_goods
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_goods`;
CREATE TABLE `sed_market_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `barcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品条码',
  `weight` decimal(18, 2) NOT NULL COMMENT '重量',
  `price` decimal(18, 2) NOT NULL COMMENT '价格',
  `category_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类编号',
  `brand_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌编号',
  `store` int(11) NOT NULL COMMENT '库存',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_goods
-- ----------------------------
INSERT INTO `sed_market_goods` VALUES (1, 'gd20190627115507553999', 'deli 得力 固体胶', '6921734971036', 36.00, 2.00, 'cn20190627112246992509', 'bn20190627114307211489', 100, '2019-06-27 11:55:08', '2019-06-27 11:55:08');
INSERT INTO `sed_market_goods` VALUES (2, 'gd20190627115746193085', '怡宝 纯净水', '6901285991219', 555.00, 2.50, 'cn20190627111906437589', 'bn20190627114837860577', 100, '2019-06-27 11:57:47', '2019-06-27 11:57:47');
INSERT INTO `sed_market_goods` VALUES (3, 'gd20190627134521769506', '乐趣生活 马克杯', '6932346702376', 300.00, 7.50, 'cn20190627120101343207', 'bn20190627114432887479', 100, '2019-06-27 13:45:21', '2019-06-27 13:45:21');
INSERT INTO `sed_market_goods` VALUES (4, 'gd20190703110134277617', '维达卷纸', '6901236373958', 200.00, 2.50, 'cn20190703105319602938', 'bn20190703102647366862', 200, '2019-07-03 11:01:35', '2019-07-11 10:06:38');
INSERT INTO `sed_market_goods` VALUES (5, 'gd20190711094825654945', '达利园.派', '6911988004512', 50.00, 1.50, 'cn20190711103934890644', 'bn20190711093924804920', 100, '2019-07-11 09:48:25', '2019-07-11 10:42:23');

-- ----------------------------
-- Table structure for sed_market_membership_card
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_membership_card`;
CREATE TABLE `sed_market_membership_card`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `holder` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_membership_card
-- ----------------------------
INSERT INTO `sed_market_membership_card` VALUES (1, 'mscn20190611135010687904', 'Allen Iverson', '13822528774', 0, 70, '2019-06-11 13:50:10', '2019-07-09 11:09:10');
INSERT INTO `sed_market_membership_card` VALUES (2, 'mscn20190614095203516220', 'Stephen Curry', '13822528777', 3, 80, '2019-06-14 09:52:03', '2019-07-03 09:36:52');
INSERT INTO `sed_market_membership_card` VALUES (3, 'mscn20190703093754478055', 'Kobe Bryant', '13822528776', 3, 60, '2019-07-03 09:37:54', '2019-07-03 09:37:54');
INSERT INTO `sed_market_membership_card` VALUES (4, 'mscn20190709094305499307', 'LeBron James', '13822528779', 1, 50, '2019-07-09 09:43:05', '2019-07-09 09:43:05');
INSERT INTO `sed_market_membership_card` VALUES (5, 'mscn20190709094438716679', 'Kevin Durant', '13822528780', 1, 50, '2019-07-09 09:44:38', '2019-07-09 09:44:38');
INSERT INTO `sed_market_membership_card` VALUES (6, 'mscn20190709094609171408', 'Paul George', '13822528781', 2, 60, '2019-07-09 09:46:09', '2019-07-09 09:46:09');
INSERT INTO `sed_market_membership_card` VALUES (7, 'mscn20190709094823429572', 'Kawhi Leonard', '13822528782', 1, 60, '2019-07-09 09:48:23', '2019-07-09 09:48:23');

-- ----------------------------
-- Table structure for sed_market_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_order_detail`;
CREATE TABLE `sed_market_order_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_detail_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单详情编号',
  `order_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `goods_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号',
  `goods_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `goods_barcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品条码',
  `goods_price` decimal(18, 2) NOT NULL COMMENT '商品价格',
  `goods_weight` decimal(18, 2) NOT NULL COMMENT '商品重量',
  `goods_quantity` int(11) NOT NULL COMMENT '商品数量',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_order_detail
-- ----------------------------
INSERT INTO `sed_market_order_detail` VALUES (1, 'ODN20190716174142726779', 'ON20190716174142924359', 'gd20190703110134277617', '维达卷纸', '6901236373958', 2.50, 200.00, 1, '2019-07-16 17:41:42', '2019-07-16 17:41:42');
INSERT INTO `sed_market_order_detail` VALUES (2, 'ODN20190716185212282334', 'ON20190716185212451049', 'gd20190703110134277617', '维达卷纸', '6901236373958', 2.50, 200.00, 2, '2019-07-16 18:52:12', '2019-07-16 18:52:12');
INSERT INTO `sed_market_order_detail` VALUES (3, 'ODN20190716185212372101', 'ON20190716185212451049', 'gd20190627115507553999', 'deli 得力 固体胶', '6921734971036', 2.00, 36.00, 1, '2019-07-16 18:52:12', '2019-07-16 18:52:12');
INSERT INTO `sed_market_order_detail` VALUES (4, 'ODN20190716185212443401', 'ON20190716185212451049', 'gd20190627115746193085', '怡宝 纯净水', '6901285991219', 2.50, 555.00, 1, '2019-07-16 18:52:12', '2019-07-16 18:52:12');
INSERT INTO `sed_market_order_detail` VALUES (5, 'ODN20190716185547208623', 'ON20190716185547369282', 'gd20190703110134277617', '维达卷纸', '6901236373958', 2.50, 200.00, 2, '2019-07-16 18:55:47', '2019-07-16 18:55:47');
INSERT INTO `sed_market_order_detail` VALUES (6, 'ODN20190716185547602190', 'ON20190716185547369282', 'gd20190627115507553999', 'deli 得力 固体胶', '6921734971036', 2.00, 36.00, 1, '2019-07-16 18:55:47', '2019-07-16 18:55:47');
INSERT INTO `sed_market_order_detail` VALUES (7, 'ODN20190716185547815811', 'ON20190716185547369282', 'gd20190627115746193085', '怡宝 纯净水', '6901285991219', 2.50, 555.00, 1, '2019-07-16 18:55:47', '2019-07-16 18:55:47');

-- ----------------------------
-- Table structure for sed_market_order_master
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_order_master`;
CREATE TABLE `sed_market_order_master`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `machine_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机器编号',
  `order_amount` decimal(18, 2) NOT NULL COMMENT '订单总金额',
  `order_status` int(11) NOT NULL COMMENT '订单状态',
  `pay_status` int(11) NOT NULL COMMENT '支付状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_order_master
-- ----------------------------
INSERT INTO `sed_market_order_master` VALUES (1, 'ON20190716174142924359', 'XA4354343434', 2.50, 0, 0, '2019-07-16 17:41:42', '2019-07-16 17:41:42');
INSERT INTO `sed_market_order_master` VALUES (2, 'ON20190716185212451049', 'XA4354343434', 5.00, 0, 0, '2019-07-16 18:52:12', '2019-07-16 18:52:12');
INSERT INTO `sed_market_order_master` VALUES (3, 'ON20190716185212451049', 'XA4354343434', 7.00, 0, 0, '2019-07-16 18:52:12', '2019-07-16 18:52:12');
INSERT INTO `sed_market_order_master` VALUES (4, 'ON20190716185212451049', 'XA4354343434', 9.50, 0, 0, '2019-07-16 18:52:12', '2019-07-16 18:52:12');
INSERT INTO `sed_market_order_master` VALUES (5, 'ON20190716185547369282', 'XA4354343555', 9.50, 0, 0, '2019-07-16 18:55:47', '2019-07-16 18:55:47');

-- ----------------------------
-- Table structure for sed_market_shop
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_shop`;
CREATE TABLE `sed_market_shop`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '超市编号',
  `shop_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '超市名称',
  `token` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鉴权token',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_shop
-- ----------------------------
INSERT INTO `sed_market_shop` VALUES (1, 'TN20190715161621339749', 'Okman', 'IxjHSYJuwG2apSTpAVW6Hw==', 0, '2019-07-15 16:16:22', '2019-07-15 16:16:22');
INSERT INTO `sed_market_shop` VALUES (2, 'SPN20190715163356958350', '人人乐超市', 'E7Babba9HwlnCIINTc2UyQ==', 0, '2019-07-15 16:33:57', '2019-07-15 16:33:57');

-- ----------------------------
-- Table structure for sed_market_staff
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_staff`;
CREATE TABLE `sed_market_staff`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `birth` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_staff
-- ----------------------------
INSERT INTO `sed_market_staff` VALUES (1, 'SN20190702103103515454', 'Allen Iverson', '13822528774', 44, 0, '1975-06-07', '费城76人', 'DN20190711152649600731', '2019-07-02 10:31:03', '2019-07-12 09:18:13');
INSERT INTO `sed_market_staff` VALUES (2, 'SN20190702105737970895', 'Stephen Curry', '13822528775', 31, 0, '1988-03-14', '金州勇士', 'DN20190711152649600731', '2019-07-02 10:57:38', '2019-07-12 09:18:21');
INSERT INTO `sed_market_staff` VALUES (3, 'SN20190703100125846792', 'LeBron James', '13822528776', 36, 0, '1984-12-30', '洛杉矶湖人', 'DN20190711152649600731', '2019-07-03 10:01:25', '2019-07-12 09:18:28');

-- ----------------------------
-- Table structure for sed_market_value_card
-- ----------------------------
DROP TABLE IF EXISTS `sed_market_value_card`;
CREATE TABLE `sed_market_value_card`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `card_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卡号',
  `holder` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '持有者',
  `balance` decimal(18, 2) NOT NULL COMMENT '余额',
  `phone_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sed_market_value_card
-- ----------------------------
INSERT INTO `sed_market_value_card` VALUES (1, 'vcn20190611140042788866', 'Stephen Curry', 1000.00, '13822528774', '2019-06-11 14:00:43', '2019-07-09 11:44:47');
INSERT INTO `sed_market_value_card` VALUES (2, 'vcn20190612163704196125', 'Allen Iverson', 100.00, '13822528774', '2019-06-12 16:37:04', '2019-07-09 11:45:15');
INSERT INTO `sed_market_value_card` VALUES (3, 'vcn20190612164832485499', 'Kobe Bryant', 200.00, '13822528776', '2019-06-12 16:48:32', '2019-07-09 11:45:26');
INSERT INTO `sed_market_value_card` VALUES (4, 'vcn20190612165252461543', 'LeBron James', 100.50, '13822528774', '2019-06-12 16:52:53', '2019-07-09 11:45:32');
INSERT INTO `sed_market_value_card` VALUES (5, 'vcn20190703092337549983', 'Kevin Durant', 100.55, '13822528774', '2019-07-03 09:23:37', '2019-07-09 11:45:39');
INSERT INTO `sed_market_value_card` VALUES (6, 'vcn20190709115153292336', 'Paul George', 9999.00, '13822528780', '2019-07-09 11:51:53', '2019-07-09 11:51:53');

SET FOREIGN_KEY_CHECKS = 1;
