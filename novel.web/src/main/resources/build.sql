/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.50-0ubuntu0.14.04.1 : Database - db_novelV3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_novel` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_novel`;

/*Table structure for table `tbl_novel` */

DROP TABLE IF EXISTS `tbl_novel`;

CREATE TABLE `tbl_novel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '小说表自增主键',
  `NAME` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '书名',
  `author` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '作者名',
  `url` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '小说的链接',
  `TYPE` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '小说的类别：如武侠修真，都市言情',
  `last_update_chapter` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '最后一章的章节名',
  `last_update_chapter_url` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '最后一章的url',
  `last_update_time` datetime DEFAULT NULL COMMENT '小说最后的更新时间',
  `STATUS` int(5) DEFAULT NULL COMMENT '小说的状态：1 连载 2 完结',
  `first_letter` char(1) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '书名的首字母',
  `platform_id` int(5) DEFAULT NULL COMMENT '小说平台的id',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '这本小说存储到我们数据库的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;