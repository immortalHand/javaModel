/*
Navicat MySQL Data Transfer

Source Server         : picc_sz
Source Server Version : 50709
Source Host           : 192.168.1.234:3306
Source Database       : cip_dev

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2019-04-22 13:15:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_type` varchar(100) NOT NULL COMMENT '字典类型',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `dict_value` varchar(100) NOT NULL COMMENT '字典键值',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `operate_status` varchar(2) NOT NULL DEFAULT '1' COMMENT '操作状态（1-正常，0-删除）',
  `valid_ind` varchar(2) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `created_user` varchar(50) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', 'PermissionType', '一级审核', '1', '1', '1', '1', 'system', '2019-02-22 13:46:31', 'system', '2019-02-22 13:46:34');
INSERT INTO `sys_dict_data` VALUES ('2', 'PermissionType', '二级审核', '2', '2', '1', '1', 'system', '2019-02-22 13:57:13', 'system', '2019-02-22 13:57:13');
INSERT INTO `sys_dict_data` VALUES ('3', 'PermissionType', '理赔申请人', '3', '3', '1', '1', 'system', '2019-02-22 13:57:13', 'system', '2019-02-22 13:57:13');
INSERT INTO `sys_dict_data` VALUES ('4', 'PermissionType', '系统管理人', '4', '4', '1', '1', 'system', '2019-02-22 13:57:13', 'system', '2019-02-22 13:57:13');
INSERT INTO `sys_dict_data` VALUES ('5', 'ValidInd', '有效', '1', '1', '1', '1', 'system', '2019-02-22 13:58:20', 'system', '2019-02-22 13:58:20');
INSERT INTO `sys_dict_data` VALUES ('6', 'ValidInd', '无效', '0', '2', '1', '1', 'system', '2019-02-22 13:58:20', 'system', '2019-02-22 13:58:20');
INSERT INTO `sys_dict_data` VALUES ('7', 'Department', '理赔事业部', '44039928', '1', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('8', 'Department', '个人贷款保证保险业务部', '44033300', '2', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('9', 'Department', '产险营业部', '44039300', '3', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('10', 'Department', '车险营业部', '44030100', '4', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('11', 'Department', '罗湖支公司', '44030200', '5', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('12', 'Department', '西湖支公司', '44030300', '6', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('13', 'Department', '华强支公司', '44030600', '7', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('14', 'Department', '梅林支公司', '44030700', '8', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('15', 'Department', '福田支公司', '44030800', '9', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('16', 'Department', '沙河支公司', '44031000', '10', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('17', 'Department', '南山支公司', '44031100', '11', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('18', 'Department', '宝安支公司', '44031200', '12', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('19', 'Department', '龙岗支公司', '44031300', '13', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('20', 'Department', '龙华支公司', '44031400', '14', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('21', 'Department', '布吉支公司', '44031500', '15', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('22', 'Department', '盐田支公司', '44031600', '16', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('23', 'Department', '松岗支公司', '44031700', '17', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('24', 'Department', '特殊风险营业部', '44032100', '18', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('25', 'Department', '电子商务营销服务部', '44032300', '19', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('26', 'Department', '国际业务营业部', '44032400', '20', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('27', 'Department', '西湖营业部', '44032800', '21', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('28', 'Department', '新洲支公司', '44032700', '22', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('29', 'Department', '业务发展营业部', '44032900', '23', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('30', 'Department', '重大项目营业部', '44032600', '24', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('31', 'Department', '车险直属支公司', '44033100', '25', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('32', 'Department', '国际业务支公司', '44033000', '26', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');
INSERT INTO `sys_dict_data` VALUES ('33', 'Department', '坪山支公司', '44033200', '27', '1', '1', 'system', '2019-02-23 12:10:35', 'system', '2019-02-23 12:10:35');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) NOT NULL COMMENT '字典名称',
  `dict_type` varchar(100) NOT NULL COMMENT '字典类型',
  `operate_status` varchar(2) NOT NULL DEFAULT '1' COMMENT '操作状态（1-正常，0-删除）',
  `valid_ind` varchar(2) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `created_user` varchar(50) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '权限类型', 'PermissionType', '1', '1', 'system', '2019-02-23 16:12:50', 'system', '2019-02-23 16:12:50', null);
INSERT INTO `sys_dict_type` VALUES ('2', '有效状态', 'ValidInd', '1', '1', 'system', '2019-02-23 16:12:50', 'system', '2019-02-23 16:12:50', null);
INSERT INTO `sys_dict_type` VALUES ('15', '部门', 'Department', '1', '1', 'system', '2019-02-23 16:12:51', 'system', '2019-02-23 16:12:51', null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '修改菜单', 'io.piccsz.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":2,\"parentId\":1,\"name\":\"人员配置\",\"url\":\"sys/user\",\"type\":1,\"icon\":\"admin\",\"orderNum\":1,\"page\":0,\"rows\":0,\"sord\":\"desc\"}]', '62', '0:0:0:0:0:0:0:1', '2019-04-22 12:54:19');
INSERT INTO `sys_log` VALUES ('2', 'admin', '修改菜单', 'io.piccsz.modules.sys.controller.SysMenuController.update()', '[{\"menuId\":2,\"parentId\":1,\"name\":\"人员配置\",\"url\":\"sys/user\",\"type\":1,\"icon\":\"admin\",\"orderNum\":1,\"page\":0,\"rows\":0,\"sord\":\"desc\"}]', '44', '0:0:0:0:0:0:0:1', '2019-04-22 12:54:21');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `operate_status` varchar(2) NOT NULL DEFAULT '1' COMMENT '操作状态（1-正常，0-删除）',
  `valid_ind` varchar(2) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `created_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'system', '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '1', '人员配置', 'sys/user', null, '1', 'admin', '1', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'sys/role', null, '1', 'role', '2', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'sys/menu', null, '1', 'menu', '3', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('5', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('6', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('7', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '3', '删除', null, 'sys:role:delete', '2', null, '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('9', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('10', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('11', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0', '1', '1', null, null, null, null);
INSERT INTO `sys_menu` VALUES ('12', '4', '删除', null, 'sys:menu:delete', '2', null, '0', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(100) NOT NULL COMMENT '角色',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `operate_status` varchar(2) NOT NULL DEFAULT '1' COMMENT '操作状态（1-正常，0-删除）',
  `valid_ind` varchar(2) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `created_user` varchar(50) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', null, '1', '1', 'system', '2019-04-22 12:49:35', null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `operate_status` varchar(2) NOT NULL DEFAULT '1' COMMENT '操作状态（1-正常，0-删除）',
  `valid_ind` varchar(2) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `created_user` varchar(50) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('4', '1', '4', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('5', '1', '5', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('6', '1', '6', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('7', '1', '7', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('8', '1', '8', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('9', '1', '9', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('10', '1', '10', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('11', '1', '11', '1', '1', 'system', '2019-04-22 12:35:32', null, null);
INSERT INTO `sys_role_menu` VALUES ('12', '1', '12', '1', '1', 'system', '2019-04-22 12:35:32', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_code` varchar(50) NOT NULL COMMENT '工号',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `dept_code` varchar(20) DEFAULT NULL COMMENT '归属部门',
  `mobile` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `operate_status` varchar(2) NOT NULL DEFAULT '1' COMMENT '操作状态（1-正常，0-删除）',
  `valid_ind` varchar(2) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `created_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_code` (`user_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'superAdmin', 'superAdmin', 'cdac762d0ba79875489f6a8b430fa8b5dfe0cdd81da38b80f02f33328af7fd4a', 'YzcmCZNvbXocrsz9dm8e', '44039928', '12323213', '1', '1', null, '2019-02-23 19:18:34', null, null);
INSERT INTO `sys_user` VALUES ('2', 'admin', 'admin', 'cdac762d0ba79875489f6a8b430fa8b5dfe0cdd81da38b80f02f33328af7fd4a', 'YzcmCZNvbXocrsz9dm8e', '44039928', '32132132222', '1', '1', null, '2019-02-19 19:18:39', '1', '2019-03-14 19:34:17');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `operate_status` varchar(2) NOT NULL DEFAULT '1' COMMENT '操作状态（1-正常，0-删除）',
  `valid_ind` varchar(2) NOT NULL DEFAULT '1' COMMENT '有效状态',
  `created_user` varchar(50) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', '0', '0', '1', '2019-03-14 19:34:50', '1', '2019-03-14 19:34:50');
INSERT INTO `sys_user_role` VALUES ('2', '2', '1', '0', '0', '1', '2019-03-14 19:34:50', '1', '2019-03-14 19:34:50');

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL COMMENT '主键',
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('2', '185fd2127ece3a2945a734777c3491d9', '2019-04-23 00:54:34', '2019-04-22 12:54:34');
