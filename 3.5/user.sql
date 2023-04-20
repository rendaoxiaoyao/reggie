

DROP DATABASE IF EXISTS `mydatabase`;
CREATE DATABASE `mydatabase` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `mydatabase`;


CREATE TABLE `user` (
  `Id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;
INSERT INTO `user` VALUES (1,'李国华','admin');
INSERT INTO `user` VALUES (2,'王老五','wlw');
INSERT INTO `user` VALUES (3,'张淑芳','zsf');
UNLOCK TABLES;

