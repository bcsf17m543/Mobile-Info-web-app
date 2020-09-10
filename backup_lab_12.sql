/*
SQLyog Ultimate - MySQL GUI v8.21 
MySQL - 5.1.29-rc-community : Database - mobileinfo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mobileinfo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mobileinfo`;

/*Table structure for table `mobileoutlet` */

DROP TABLE IF EXISTS `mobileoutlet`;

CREATE TABLE `mobileoutlet` (
  `CompanyName` varchar(100) NOT NULL,
  `Model` varchar(100) NOT NULL,
  `price` int(8) NOT NULL,
  PRIMARY KEY (`Model`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mobileoutlet` */

insert  into `mobileoutlet`(`CompanyName`,`Model`,`price`) values ('Iphone','11',1098765),('Huawei','123er',123000),('Nokia','3310',2000),('Telenor','4g',13000),('Huawei','4gada',1300),('Huawei','a37',15000),('Huawei','blachu',1300),('Paglon ki Company','farigh tareen model',9999999),('Iphone','s11',1234567),('Huawei','s234',12000),('Huawei','s53',26000),('Nokia','we5',12000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
