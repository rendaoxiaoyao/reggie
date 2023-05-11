# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: students
# ------------------------------------------------------
# Server version 5.0.45-community-nt

DROP DATABASE IF EXISTS `students`;
CREATE DATABASE `students` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `students`;

#
# Table structure for table student
#

CREATE TABLE `student` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `sex` varchar(2) default NULL,
  `age` int(11) default NULL,
  `grade` varchar(20) default NULL,
  `score` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;
INSERT INTO `student` VALUES (1,'张国强','男',22,'12网编2班',80);
INSERT INTO `student` VALUES (2,'张国红','女',21,'12网编1班',91.2);
INSERT INTO `student` VALUES (3,'Tom','F',20,'3',70);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
