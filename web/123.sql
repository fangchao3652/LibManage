/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : project

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2016-07-10 13:04:19
*/
 
use libmanage;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `cno` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `tno` int(16) NOT NULL,
  `total` int(16) DEFAULT NULL,
  `classroom` varchar(50) DEFAULT NULL,
  `credit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `tno` (`tno`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`tno`) REFERENCES `teacher` (`tno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1434222 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1410012', '计算机基础', '2', '4', '哲理楼318', '6');
INSERT INTO `class` VALUES ('1410034', '面向对象程序设计', '5', '11', '机关楼315', '10');
INSERT INTO `class` VALUES ('1410044', '高级语言程序设计', '3', '8', '机关楼215', '7');
INSERT INTO `class` VALUES ('1420023', '工程制图与ＣＡＤ', '4', '11', '哲理楼419', '10');
INSERT INTO `class` VALUES ('1424181', '模拟电子技术实验', '3', '10', '彗星楼814', '9');
INSERT INTO `class` VALUES ('1424251', '通信电子线路实验', '1', '8', '哲理楼517', '7');
INSERT INTO `class` VALUES ('1434221', '认知实验', '2', '8', '理贤楼514', '7');

-- ----------------------------
-- Table structure for evaluate_standard
-- ----------------------------
DROP TABLE IF EXISTS `evaluate_standard`;
CREATE TABLE `evaluate_standard` (
  `id` int(16) NOT NULL,
  `eno` int(16) NOT NULL,
  `stanDesc` varchar(255) NOT NULL,
  `rankA` varchar(255) DEFAULT NULL,
  `rankB` varchar(255) DEFAULT NULL,
  `rankC` varchar(255) DEFAULT NULL,
  `rankD` varchar(255) DEFAULT NULL,
  `rankE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `evaluate_standard_ibfk_1` (`eno`),
  CONSTRAINT `evaluate_standard_ibfk_1` FOREIGN KEY (`eno`) REFERENCES `experiment` (`eno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate_standard
-- ----------------------------
INSERT INTO `evaluate_standard` VALUES ('9', '14241811', '实验方案选择情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('10', '14241811', '实验器材使用情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('11', '14241811', '实验实际操作情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('12', '14241811', '实验最终结果情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('13', '14241812', '实验方案选择情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('14', '14241812', '实验器材使用情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('15', '14241812', '实验实际操作情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('16', '14241812', '实验最终结果情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('17', '14241813', '实验方案选择情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('18', '14241813', '实验器材使用情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('19', '14241813', '实验实际操作情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');
INSERT INTO `evaluate_standard` VALUES ('20', '14241813', '实验最终结果情况', 'A优秀', 'B良好', 'C中等', 'D及格', 'E不及格');

-- ----------------------------
-- Table structure for experiment
-- ----------------------------
DROP TABLE IF EXISTS `experiment`;
CREATE TABLE `experiment` (
  `eno` int(16) NOT NULL AUTO_INCREMENT,
  `lesson` int(16) DEFAULT NULL,
  `cno` int(16) NOT NULL,
  `time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eno`),
  KEY `cno` (`cno`),
  CONSTRAINT `experiment_ibfk_1` FOREIGN KEY (`cno`) REFERENCES `class` (`cno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14342219 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of experiment
-- ----------------------------
INSERT INTO `experiment` VALUES ('14100121', '1', '1410012', null, 'WindoswXP操作系统');
INSERT INTO `experiment` VALUES ('14100122', '2', '1410012', null, 'Word2003的使用');
INSERT INTO `experiment` VALUES ('14100123', '3', '1410012', null, 'Excel 2003的使用');
INSERT INTO `experiment` VALUES ('14100124', '4', '1410012', null, 'PowerPoint2003的使用');
INSERT INTO `experiment` VALUES ('14100441', '1', '1410044', null, '顺序结构程序设计');
INSERT INTO `experiment` VALUES ('14100442', '2', '1410044', null, '分支结构程序设计');
INSERT INTO `experiment` VALUES ('14100443', '3', '1410044', null, '循环结构程序设计');
INSERT INTO `experiment` VALUES ('14100444', '4', '1410044', null, '一维数组、二维数组程序设计');
INSERT INTO `experiment` VALUES ('14100445', '5', '1410044', null, '带参数函数的程序设计');
INSERT INTO `experiment` VALUES ('14100446', '6', '1410044', null, '指针程序设计');
INSERT INTO `experiment` VALUES ('14100447', '7', '1410044', null, '结构体与链表程序设计');
INSERT INTO `experiment` VALUES ('14100448', '8', '1410044', null, '文件');
INSERT INTO `experiment` VALUES ('14241811', '1', '1424181', null, '数字电子技术实验');
INSERT INTO `experiment` VALUES ('14241812', '2', '1424181', null, '嵌入式系统');
INSERT INTO `experiment` VALUES ('14241813', '3', '1424181', null, '光纤通信系统');
INSERT INTO `experiment` VALUES ('14342211', '1', '1434221', null, '电路基础知识');
INSERT INTO `experiment` VALUES ('14342212', '2', '1434221', null, '焊接工艺');
INSERT INTO `experiment` VALUES ('14342213', '3', '1434221', null, '电路仿真软件使用');
INSERT INTO `experiment` VALUES ('14342214', '4', '1434221', null, '常用电子仪器使用');
INSERT INTO `experiment` VALUES ('14342215', '5', '1434221', null, '电子元件的伏安特性');
INSERT INTO `experiment` VALUES ('14342216', '6', '1434221', null, '基尔霍夫定律和叠加原理');
INSERT INTO `experiment` VALUES ('14342217', '7', '1434221', null, '戴维南定理和诺顿定理');
INSERT INTO `experiment` VALUES ('14342218', '8', '1434221', null, 'RC一阶电路的响应');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mno` int(16) NOT NULL,
  `password` char(255) DEFAULT '123456',
  `limitation` char(255) CHARACTER SET utf8 DEFAULT '管理员',
  PRIMARY KEY (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '123456', '管理员');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(16) NOT NULL,
  `eno` int(16) NOT NULL,
  `quesNum` int(16) NOT NULL,
  `topic` varchar(80) NOT NULL,
  `optionA` varchar(255) DEFAULT NULL,
  `optionB` varchar(255) DEFAULT NULL,
  `optionC` varchar(255) DEFAULT NULL,
  `optionD` varchar(255) DEFAULT NULL,
  `answer` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `question_ibfk_1` (`eno`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`eno`) REFERENCES `experiment` (`eno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('9', '14241811', '1', '测试1', 'A', 'B', 'C', 'D', 'A');
INSERT INTO `question` VALUES ('10', '14241811', '2', '测试2', 'A', 'B', 'C', 'D', 'B');
INSERT INTO `question` VALUES ('11', '14241811', '3', '测试3', 'A', 'B', 'C', 'D', 'C');
INSERT INTO `question` VALUES ('12', '14241811', '4', '测试4', 'A', 'B', 'C', 'D', 'D');
INSERT INTO `question` VALUES ('13', '14241812', '1', '测试1', 'A', 'B', 'C', 'D', 'A');
INSERT INTO `question` VALUES ('14', '14241812', '2', '测试2', 'A', 'B', 'C', 'D', 'B');
INSERT INTO `question` VALUES ('15', '14241812', '3', '测试3', 'A', 'B', 'C', 'D', 'C');
INSERT INTO `question` VALUES ('16', '14241812', '4', '测试4', 'A', 'B', 'C', 'D', 'D');
INSERT INTO `question` VALUES ('17', '14241813', '1', '测试1', 'A', 'B', 'C', 'D', 'A');
INSERT INTO `question` VALUES ('18', '14241813', '2', '测试2', 'A', 'B', 'C', 'D', 'B');
INSERT INTO `question` VALUES ('19', '14241813', '3', '测试3', 'A', 'B', 'C', 'D', 'C');
INSERT INTO `question` VALUES ('20', '14241813', '4', '测试4', 'A', 'B', 'C', 'D', 'D');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `sno` int(16) NOT NULL,
  `eno` int(16) NOT NULL,
  `tno` int(16) NOT NULL,
  `cno` int(16) NOT NULL,
  `prepStatus` char(255) CHARACTER SET utf8 DEFAULT '',
  `prepResult` text CHARACTER SET utf8,
  `prepScore` float DEFAULT NULL,
  `login` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `evaStatus` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `evaResult` text CHARACTER SET utf8,
  `evaScore` float DEFAULT NULL,
  `picture` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `code` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `video` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `audio` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `score` float DEFAULT NULL,
  PRIMARY KEY (`sno`,`eno`),
  KEY `score_ibfk_2` (`eno`),
  KEY `score_ibfk_3` (`tno`),
  KEY `score_ibfk_4` (`cno`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`eno`) REFERENCES `experiment` (`eno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_ibfk_3` FOREIGN KEY (`tno`) REFERENCES `teacher` (`tno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_ibfk_4` FOREIGN KEY (`cno`) REFERENCES `class` (`cno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('131405101', '14241811', '3', '1424181', '预习', '{题目：本次课主要内容}', '75', '登录', '评价', null, '85', '', '', null, null, null);
INSERT INTO `score` VALUES ('131405103', '14241811', '1', '1424181', '', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` int(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` char(10) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT '123456',
  `limitation` char(255) CHARACTER SET utf8 DEFAULT '学生',
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('131405101', '周天时', '男', '13级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('131405102', '何更旭', '男', '13级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('131405103', '李潮', '男', '13级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('131405104', '周成涛', '男', '13级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('131405105', '耿闯', '男', '13级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('131406101', '和世帅', '男', '13级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('131406102', '王钊', '男', '13级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('131406103', '张学文', '男', '13级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('131406104', '张明迪', '女', '13级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('131406105', '贺攀', '男', '13级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('141403101', '张翼', '男', '14级', '硬件1', '123456', '学生');
INSERT INTO `student` VALUES ('141403102', '关欣荣', '女', '14级', '硬件1', '123456', '学生');
INSERT INTO `student` VALUES ('141403103', '吴昊', '男', '14级', '硬件1', '123456', '学生');
INSERT INTO `student` VALUES ('141403104', '付成鹏', '男', '14级', '硬件1', '123456', '学生');
INSERT INTO `student` VALUES ('141403105', '祝金思', '女', '14级', '硬件1', '123456', '学生');
INSERT INTO `student` VALUES ('141405101', '孙跃', '男', '14级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('141405102', '罗健', '男', '14级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('141405103', '卢誉', '女', '14级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('141405104', '肖坛', '男', '14级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('141405105', '郭仪芳', '女', '14级', '电信1', '123456', '学生');
INSERT INTO `student` VALUES ('141405201', '李强', '男', '14级', '电信2', '123456', '学生');
INSERT INTO `student` VALUES ('141405202', '刘泽阳', '女', '14级', '电信2', '123456', '学生');
INSERT INTO `student` VALUES ('141405203', '曲学磊', '男', '14级', '电信2', '123456', '学生');
INSERT INTO `student` VALUES ('141405204', '孙继伟', '男', '14级', '电信2', '123456', '学生');
INSERT INTO `student` VALUES ('141405205', '霍那日苏', '女', '14级', '电信2', '123456', '学生');
INSERT INTO `student` VALUES ('141406101', '邱少煜', '男', '14级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('141406102', '安越', '女', '14级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('141406103', '孟凡凯', '男', '14级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('141406104', '唐峰', '男', '14级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('141406105', '李达', '男', '14级', '通信1', '123456', '学生');
INSERT INTO `student` VALUES ('141407101', '赵亮', '男', '14级', '软件1', '123456', '学生');
INSERT INTO `student` VALUES ('141407102', '刘子豪', '男', '14级', '软件1', '123456', '学生');
INSERT INTO `student` VALUES ('141407103', '张皓栋', '男', '14级', '软件1', '123456', '学生');
INSERT INTO `student` VALUES ('141407104', '王灵鑫', '女', '14级', '软件1', '123456', '学生');
INSERT INTO `student` VALUES ('141407105', '刘帅', '男', '14级', '软件1', '123456', '学生');
INSERT INTO `student` VALUES ('141407201', '王善斌', '男', '14级', '软件2', '123456', '学生');
INSERT INTO `student` VALUES ('141407202', '远继圣', '男', '14级', '软件2', '123456', '学生');
INSERT INTO `student` VALUES ('141407203', '石林', '男', '14级', '软件2', '123456', '学生');
INSERT INTO `student` VALUES ('141407204', '王广栋', '男', '14级', '软件2', '123456', '学生');
INSERT INTO `student` VALUES ('141407205', '柳岸青', '女', '14级', '软件2', '123456', '学生');

-- ----------------------------
-- Table structure for take_class
-- ----------------------------
DROP TABLE IF EXISTS `take_class`;
CREATE TABLE `take_class` (
  `sno` int(16) NOT NULL,
  `cno` int(16) NOT NULL,
  PRIMARY KEY (`sno`,`cno`),
  KEY `take_class_ibfk_2` (`cno`),
  CONSTRAINT `take_class_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `take_class_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `class` (`cno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of take_class
-- ----------------------------
INSERT INTO `take_class` VALUES ('131405101', '1410044');
INSERT INTO `take_class` VALUES ('131405103', '1410044');
INSERT INTO `take_class` VALUES ('141407102', '1410044');
INSERT INTO `take_class` VALUES ('131405101', '1424181');
INSERT INTO `take_class` VALUES ('131406102', '1424181');
INSERT INTO `take_class` VALUES ('131406104', '1424181');
INSERT INTO `take_class` VALUES ('141403104', '1424181');
INSERT INTO `take_class` VALUES ('131405101', '1434221');
INSERT INTO `take_class` VALUES ('131405102', '1434221');
INSERT INTO `take_class` VALUES ('131405103', '1434221');
INSERT INTO `take_class` VALUES ('131405104', '1434221');
INSERT INTO `take_class` VALUES ('131405105', '1434221');
INSERT INTO `take_class` VALUES ('131406101', '1434221');
INSERT INTO `take_class` VALUES ('131406103', '1434221');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tno` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` char(10) DEFAULT NULL,
  `title` char(255) DEFAULT NULL,
  `password` char(255) DEFAULT '123456',
  `limitation` char(255) DEFAULT '教师',
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '张玉奇', '男', '讲师', '123456', '教师');
INSERT INTO `teacher` VALUES ('2', '胡彬彬', '男', '讲师', '123456', '教师');
INSERT INTO `teacher` VALUES ('3', '王玉梅', '女', '教师', '123456', '管理员');
INSERT INTO `teacher` VALUES ('4', '李淑琴', '女', '教授', '456789', '教师');
INSERT INTO `teacher` VALUES ('5', '张丹', '女', '副教授', 'jaychou', 'admin');
