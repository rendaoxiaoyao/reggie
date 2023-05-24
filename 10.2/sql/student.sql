-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 11 月 22 日 03:18
-- 服务器版本: 5.5.16
-- PHP 版本: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `student`
--

-- --------------------------------------------------------

--
-- 表的结构 `cla2sub`
--

CREATE TABLE IF NOT EXISTS `cla2sub` (
  `cla2sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `cla_id` int(11) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  `tec_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cla2sub_id`),
  UNIQUE KEY `uni_cla_sub` (`cla_id`,`sub_id`),
  KEY `fk_cla2sub_sub` (`sub_id`),
  KEY `fk_cla2sub_cla` (`cla_id`),
  KEY `tec_id` (`tec_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- 转存表中的数据 `cla2sub`
--

INSERT INTO `cla2sub` (`cla2sub_id`, `cla_id`, `sub_id`, `tec_id`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 2, 1, 1),
(4, 2, 3, 2),
(5, 2, 4, 2),
(7, 3, 2, 3),
(8, 4, 4, 3),
(9, 4, 5, 4),
(12, 5, 4, 4),
(13, 7, 1, 1),
(14, 7, 4, 7),
(15, 7, 5, 7),
(16, 5, 3, 7),
(17, 5, 5, 7);

--
-- 触发器 `cla2sub`
--
DROP TRIGGER IF EXISTS `TG_5`;
DELIMITER //
CREATE TRIGGER `TG_5` AFTER DELETE ON `cla2sub`
 FOR EACH ROW BEGIN
DELETE FROM score WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id = old.cla_id ) AND sub_id = old.sub_id;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `classes`
--

CREATE TABLE IF NOT EXISTS `classes` (
  `cla_id` int(11) NOT NULL AUTO_INCREMENT,
  `cla_name` varchar(22) DEFAULT NULL,
  `maj_id` int(11) DEFAULT NULL,
  `cla_tec` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`cla_id`),
  UNIQUE KEY `uni_name` (`cla_name`),
  KEY `fk_cla_maj` (`maj_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `classes`
--

INSERT INTO `classes` (`cla_id`, `cla_name`, `maj_id`, `cla_tec`) VALUES
(1, '12网编1班', 1, '李红'),
(2, '12ERP1班', 2, '陈鑫'),
(3, '12UI1班', 3, '王伟'),
(4, '12智能楼宇1班', 4, '钟宁涛'),
(5, '12网络1班', 5, '陶月敏'),
(7, '12游软1班', 6, '刘海');

--
-- 触发器 `classes`
--
DROP TRIGGER IF EXISTS `TG_7`;
DELIMITER //
CREATE TRIGGER `TG_7` BEFORE DELETE ON `classes`
 FOR EACH ROW BEGIN
DELETE FROM operator WHERE ope_id IN (SELECT ope_id FROM student WHERE cla_id = old.cla_id);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `major`
--

CREATE TABLE IF NOT EXISTS `major` (
  `maj_id` int(11) NOT NULL AUTO_INCREMENT,
  `maj_name` varchar(22) DEFAULT NULL,
  `maj_prin` varchar(22) DEFAULT NULL,
  `maj_link` varchar(22) DEFAULT NULL,
  `maj_phone` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`maj_id`),
  UNIQUE KEY `uni_name` (`maj_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `major`
--

INSERT INTO `major` (`maj_id`, `maj_name`, `maj_prin`, `maj_link`, `maj_phone`) VALUES
(1, '软件', '李红', '李红', '123456'),
(2, '信管', '刘海', '刘海', '1234567'),
(3, '游美', '钱五', '钱五', '1234567'),
(4, '蓝盾', '陶月敏', '陶月敏', '1234567'),
(5, '网络', '陈鑫', '陈鑫', '1234567'),
(6, '游软', '王伟', '王伟', '1234567');

--
-- 触发器 `major`
--
DROP TRIGGER IF EXISTS `TG_8`;
DELIMITER //
CREATE TRIGGER `TG_8` BEFORE DELETE ON `major`
 FOR EACH ROW BEGIN
DELETE FROM operator WHERE ope_id IN(SELECT ope_id FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE maj_id = old.maj_id));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `operator`
--

CREATE TABLE IF NOT EXISTS `operator` (
  `ope_id` int(11) NOT NULL AUTO_INCREMENT,
  `ope_name` varchar(22) DEFAULT NULL,
  `ope_pwd` varchar(22) DEFAULT NULL,
  `rol_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ope_id`),
  UNIQUE KEY `uni_name` (`ope_name`),
  KEY `fk_ope_rol` (`rol_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=41 ;

--
-- 转存表中的数据 `operator`
--

INSERT INTO `operator` (`ope_id`, `ope_name`, `ope_pwd`, `rol_id`) VALUES
(1, 'admin', 'admin', 1),
(2, 'tec1', 'tec1', 2),
(3, 'tec2', 'tec2', 2),
(4, 'tec3', 'tec3', 2),
(5, 'tec4', 'tec4', 2),
(6, 'tec5', 'tec5', 2),
(7, 'tec6', 'tec6', 2),
(8, 'stu01', 'stu01', 3),
(9, 'stu02', 'stu02', 3),
(10, 'stu03', 'stu03', 3),
(11, 'stu04', 'stu04', 3),
(12, 'stu05', 'stu05', 3),
(13, 'stu06', 'stu06', 3),
(14, 'stu07', 'stu07', 3),
(36, 'stu08', 'stu08', 3),
(37, 'tec7', 'tec7', 2),
(38, 'stu09', 'stu09', 3),
(39, 'stu10', 'stu10', 3),
(40, '田静', '田静', 2);

-- --------------------------------------------------------

--
-- 表的结构 `privilege`
--

CREATE TABLE IF NOT EXISTS `privilege` (
  `pri_id` int(11) NOT NULL AUTO_INCREMENT,
  `pri_name` varchar(22) DEFAULT NULL,
  `pri_url` varchar(55) DEFAULT NULL,
  `menu_name` varchar(22) DEFAULT NULL,
  `rol_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- 转存表中的数据 `privilege`
--

INSERT INTO `privilege` (`pri_id`, `pri_name`, `pri_url`, `menu_name`, `rol_id`) VALUES
(1, '我的资料', '/Student/InfoStudentServlet', '学生管理', 3),
(2, '查询成绩', '/Student/pages/search_score.jsp', '成绩管理', 3),
(3, '查询课程', '/Student/pages/search_subject.jsp', '课程管理', 3),
(4, '同班同学', '/Student/SearchClassmatesServlet', '班级管理', 3),
(5, '我的资料', '/Student/InfoTeacherServlet', '教师管理', 2),
(6, '查找学生', '/Student/pages/search_student.jsp', '学生管理', 2),
(7, '学生成绩', '/Student/pages/search_score.jsp', '成绩管理', 2),
(8, '我的班级', '/Student/SearchTeacherClassServlet', '班级管理', 2),
(9, '我的课程', '/Student/pages/search_subject.jsp', '课程管理', 2),
(10, '添加学生', '/Student/PlanAddStudentServlet', '学生管理', 1),
(11, '查询学生', '/Student/pages/search_student.jsp', '学生管理', 1),
(12, '添加班级', '/Student/PlanAddClassesServlet', '班级管理', 1),
(13, '查询班级', '/Student/pages/search_classes.jsp', '班级管理', 1),
(14, '添加班级课程', '/Student/PlanAddCla2SubSevlet', '班级管理', 1),
(15, '查询班级课程', '/Student/pages/search_classes_subject.jsp', '班级管理', 1),
(16, '添加教师', '/Student/pages/add_teacher.jsp', '教师管理', 1),
(17, '查询教师', '/Student/pages/search_teacher.jsp', '教师管理', 1),
(18, '查询成绩', '/Student/pages/search_score.jsp', '成绩管理', 1),
(19, '添加课程', '/Student/pages/add_subject.jsp', '课程管理', 1),
(20, '查询课程', '/Student/pages/search_subject.jsp', '课程管理', 1),
(21, '添加专业', '/Student/pages/add_major.jsp', '专业管理', 1),
(22, '查询专业', '/Student/pages/search_major.jsp', '专业管理', 1),
(23, '班级课程表', '/Student/pages/export_classes_subject.jsp', '班级管理', 1),
(24, '班级课程表', '/Student/pages/export_classes_subject.jsp', '班级管理', 2),
(25, '班级课程表', '/Student/pages/export_classes_subject.jsp', '班级管理', 3),
(26, '导出班级成绩', '/Student/ReportScoreServlet', '班级管理', 2);

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `rol_id` int(11) NOT NULL AUTO_INCREMENT,
  `rol_name` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`rol_id`),
  UNIQUE KEY `uni_name` (`rol_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`rol_id`, `rol_name`) VALUES
(3, '学生'),
(2, '教师'),
(1, '管理员');

-- --------------------------------------------------------

--
-- 表的结构 `score`
--

CREATE TABLE IF NOT EXISTS `score` (
  `sco_id` int(11) NOT NULL AUTO_INCREMENT,
  `sco_daily` float DEFAULT '0',
  `sco_exam` float DEFAULT '0',
  `sco_count` float DEFAULT '0',
  `stu_id` int(11) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  `cla2sub_id` int(11) NOT NULL,
  `cla_id` int(11) NOT NULL,
  PRIMARY KEY (`sco_id`),
  UNIQUE KEY `uni_stu_sub` (`stu_id`,`sub_id`,`cla2sub_id`),
  KEY `fk_sco_sub` (`sub_id`),
  KEY `fk_sco_stu` (`stu_id`),
  KEY `fk_sco_cla` (`cla2sub_id`),
  KEY `cla_id` (`cla_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- 转存表中的数据 `score`
--

INSERT INTO `score` (`sco_id`, `sco_daily`, `sco_exam`, `sco_count`, `stu_id`, `sub_id`, `cla2sub_id`, `cla_id`) VALUES
(1, 66, 30, 96, 1, 1, 1, 1),
(2, 20, 72, 92, 1, 2, 2, 1),
(3, 33, 64, 97, 2, 1, 1, 1),
(4, 28, 62, 90, 2, 2, 2, 1),
(5, 18, 61, 79, 3, 1, 3, 2),
(6, 31, 66, 97, 3, 3, 4, 2),
(7, 28, 60, 88, 3, 4, 5, 2),
(8, 33, 56, 89, 4, 1, 3, 2),
(9, 21, 45, 66, 4, 3, 4, 2),
(10, 25, 65, 90, 4, 4, 5, 2),
(12, 0, 0, 0, 5, 2, 7, 3),
(14, 30, 66, 96, 6, 2, 7, 3),
(15, 0, 0, 0, 7, 4, 8, 4),
(16, 0, 0, 0, 7, 5, 9, 4),
(25, 0, 0, 0, 8, 4, 8, 4),
(26, 0, 0, 0, 8, 5, 9, 4),
(27, 0, 0, 0, 9, 3, 16, 5),
(28, 0, 0, 0, 10, 3, 16, 5),
(29, 0, 0, 0, 9, 5, 17, 5),
(30, 0, 0, 0, 10, 5, 17, 5);

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `ope_id` int(11) DEFAULT NULL,
  `stu_no` varchar(22) DEFAULT NULL,
  `stu_name` varchar(22) DEFAULT NULL,
  `stu_sex` enum('男','女') DEFAULT '男',
  `stu_birth` date DEFAULT NULL,
  `stu_pic` varchar(22) DEFAULT NULL,
  `cla_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `uni_no` (`stu_no`),
  UNIQUE KEY `uni_ope` (`ope_id`),
  KEY `fk_stu_cla` (`cla_id`),
  KEY `fk_stu_ope` (`ope_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`stu_id`, `ope_id`, `stu_no`, `stu_name`, `stu_sex`, `stu_birth`, `stu_pic`, `cla_id`) VALUES
(1, 8, '01', '陈美丽', '女', '2013-02-26', '../images/person.png', 1),
(2, 9, '02', '王伟强', '男', '2013-11-23', '../images/person.png', 1),
(3, 10, '03', '蔡佳金', '女', '2013-11-19', '../images/person.png', 2),
(4, 11, '04', '何凤', '男', '2013-11-05', '../images/person.png', 2),
(5, 12, '05', '李言春', '女', '2013-11-19', '../images/person.png', 3),
(6, 13, '06', '董明', '男', '2013-11-03', '../images/person.png', 3),
(7, 14, '07', '吴小娟', '女', '2013-11-03', '../images/person.png', 4),
(8, 36, '08', '周建国', '男', '2013-09-06', '../images/person.png', 4),
(9, 38, '09', '魏坤', '女', '2013-11-19', '../images/person.png', 5),
(10, 39, '10', '管华山', '男', '2013-11-21', '../images/person.png', 5);

--
-- 触发器 `student`
--
DROP TRIGGER IF EXISTS `TG_3`;
DELIMITER //
CREATE TRIGGER `TG_3` AFTER DELETE ON `student`
 FOR EACH ROW BEGIN
DELETE FROM operator WHERE ope_id = old.ope_id;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_name` varchar(22) DEFAULT NULL,
  `sub_type` varchar(22) DEFAULT NULL,
  `sub_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`sub_id`),
  UNIQUE KEY `uni_name` (`sub_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `subject`
--

INSERT INTO `subject` (`sub_id`, `sub_name`, `sub_type`, `sub_times`) VALUES
(1, 'J2SE', '必修', 108),
(2, 'C语言', '必修', 108),
(3, 'PhotoShop', '选修', 56),
(4, 'DIV+CSS', '必修', 96),
(5, '矢量图', '选修', 56);

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `tec_id` int(11) NOT NULL AUTO_INCREMENT,
  `ope_id` int(11) DEFAULT NULL,
  `tec_name` varchar(22) DEFAULT NULL,
  `tec_birth` date DEFAULT NULL,
  `tec_sex` enum('男','女') DEFAULT '男',
  `tec_major` varchar(22) DEFAULT NULL,
  `tec_phone` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`tec_id`),
  UNIQUE KEY `uni_ope` (`ope_id`),
  UNIQUE KEY `fk_tec_ope` (`ope_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`tec_id`, `ope_id`, `tec_name`, `tec_birth`, `tec_sex`, `tec_major`, `tec_phone`) VALUES
(1, 2, '李红', '1988-04-14', '女', 'J2SE', '1234567'),
(2, 3, '陈鑫', '1990-07-21', '女', 'C语言', '1234567'),
(3, 4, '王伟', '2013-10-07', '男', 'DIV+CSS', '1234567'),
(4, 5, '钟宁涛', '2013-10-24', '女', 'PhotoShop', '1234567'),
(5, 6, '陶月敏', '1990-08-06', '男', '矢量图', '1234567'),
(6, 7, '刘海', '2013-11-19', '女', 'J2SE', '1234567'),
(7, 37, '钱五', '1987-11-11', '男', 'PhotoShop', '1234567'),
(8, 40, '田静', '2013-10-29', '女', 'PHP', '1234576');

--
-- 触发器 `teacher`
--
DROP TRIGGER IF EXISTS `TG_4`;
DELIMITER //
CREATE TRIGGER `TG_4` AFTER DELETE ON `teacher`
 FOR EACH ROW BEGIN
DELETE FROM operator WHERE ope_id = old.ope_id;
END
//
DELIMITER ;

--
-- 限制导出的表
--

--
-- 限制表 `cla2sub`
--
ALTER TABLE `cla2sub`
  ADD CONSTRAINT `cla2sub_ibfk_1` FOREIGN KEY (`tec_id`) REFERENCES `teacher` (`tec_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cla2sub_cla` FOREIGN KEY (`cla_id`) REFERENCES `classes` (`cla_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cla2sub_sub` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `fk_cla_maj` FOREIGN KEY (`maj_id`) REFERENCES `major` (`maj_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `operator`
--
ALTER TABLE `operator`
  ADD CONSTRAINT `fk_ope_rol` FOREIGN KEY (`rol_id`) REFERENCES `role` (`rol_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `score_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `score_ibfk_2` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `score_ibfk_3` FOREIGN KEY (`cla2sub_id`) REFERENCES `cla2sub` (`cla2sub_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `score_ibfk_4` FOREIGN KEY (`cla_id`) REFERENCES `classes` (`cla_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk_stu_cla` FOREIGN KEY (`cla_id`) REFERENCES `classes` (`cla_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_stu_ope` FOREIGN KEY (`ope_id`) REFERENCES `operator` (`ope_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
