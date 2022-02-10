/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.24-community-nt : Database - kehuhuikuan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kehuhuikuan` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kehuhuikuan`;

/*Table structure for table `bills` */

DROP TABLE IF EXISTS `bills`;

CREATE TABLE `bills` (
  `BillId` int(11) NOT NULL auto_increment COMMENT 'id',
  `spid` int(11) default NULL COMMENT '业务员id',
  `ClientId` int(11) default NULL COMMENT '客户号',
  `CtrctId` int(11) default NULL COMMENT '合同号',
  `Arrear` double default NULL COMMENT '欠款',
  `RepayT` int(11) default NULL COMMENT '还款次数',
  `pubtime` varchar(30) default NULL COMMENT '添加时间',
  PRIMARY KEY  (`BillId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='账单表';

/*Data for the table `bills` */

insert  into `bills`(`BillId`,`spid`,`ClientId`,`CtrctId`,`Arrear`,`RepayT`,`pubtime`) values (3,12,16,2,900,1,'2021-12-27 22:12:37'),(4,12,20,3,2900,1,'2021-12-27 22:30:49');

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `ClientId` int(11) NOT NULL auto_increment COMMENT 'id',
  `CName` varchar(100) default NULL COMMENT '姓名',
  `CSex` varchar(20) default NULL COMMENT '性别',
  `CTele` varchar(30) default NULL COMMENT '电话',
  `CLocation` varchar(255) default NULL COMMENT '地址',
  `pwd` varchar(50) default NULL COMMENT '密码',
  `uname` varchar(30) default NULL COMMENT '用户名',
  PRIMARY KEY  (`ClientId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='客户表';

/*Data for the table `clients` */

/*Table structure for table `commodity` */

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `ComId` int(11) NOT NULL auto_increment COMMENT 'id',
  `ComName` varchar(100) default NULL COMMENT '货物名',
  `UnitPrice` double default NULL COMMENT '货物单价',
  `Reserve` int(11) default NULL COMMENT '库存',
  PRIMARY KEY  (`ComId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='货物表';

/*Data for the table `commodity` */

insert  into `commodity`(`ComId`,`ComName`,`UnitPrice`,`Reserve`) values (1,'货物1',25,2000),(2,'货物2',10,800),(3,'货物3',30,900);

/*Table structure for table `contracts` */

DROP TABLE IF EXISTS `contracts`;

CREATE TABLE `contracts` (
  `CtrctId` int(11) NOT NULL auto_increment COMMENT 'id',
  `CtrctName` varchar(100) default NULL COMMENT '合同名称',
  `ClientId` int(11) default NULL COMMENT '客户 Id',
  `SpId` int(11) default NULL COMMENT '业务员 Id',
  `SignedT` varchar(30) default NULL COMMENT '签订时间',
  `ExpireT` varchar(30) default NULL COMMENT '到期时间',
  `ComId` int(11) default NULL COMMENT '商品 Id',
  `ComQuant` int(11) default NULL COMMENT '商品数量',
  `Amount` double default NULL COMMENT '合同总金额',
  `status` varchar(30) default NULL COMMENT '目前状态',
  `pubtime` varchar(30) default NULL COMMENT '添加时间',
  PRIMARY KEY  (`CtrctId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='合同表';

/*Data for the table `contracts` */

insert  into `contracts`(`CtrctId`,`CtrctName`,`ClientId`,`SpId`,`SignedT`,`ExpireT`,`ComId`,`ComQuant`,`Amount`,`status`,`pubtime`) values (2,'11',16,12,'2021-12-22T17:14','2021-12-31T17:14',2,100,1000,'待还款','2021-12-27 17:14:24'),(3,'测试合同1',20,12,'2021-12-26T22:30','2022-01-07T22:30',3,100,3000,'待还款','2021-12-27 22:30:28');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `name` varchar(255) default NULL COMMENT '主题',
  `fid` int(11) default NULL COMMENT '发送人',
  `jid` int(11) default NULL COMMENT '接受人',
  `note` varchar(255) default NULL COMMENT '发送内容',
  `pubtime` varchar(30) default NULL COMMENT '发送时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='预警';

/*Data for the table `message` */

insert  into `message`(`id`,`name`,`fid`,`jid`,`note`,`pubtime`) values (1,'合同【11】预警',12,16,'合同【11】于【2021-12-31T17:14】到期，请及时还款，以免影响信用！','2021-12-27 22:15:31'),(2,'合同【测试合同1】预警',12,20,'合同【测试合同1】于【2022-01-07T22:30】到期，请及时还款，以免影响信用！','2021-12-27 22:31:05');

/*Table structure for table `record` */

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `RId` int(11) NOT NULL auto_increment COMMENT 'id',
  `spid` int(11) default NULL COMMENT '业务员id',
  `clientid` int(11) default NULL COMMENT '客户id',
  `CtrctId` int(11) default NULL COMMENT '合同号',
  `RcrdT` varchar(50) default NULL COMMENT '回款时间',
  `RcrdQuant` double default NULL COMMENT '回款金额',
  `BillId` int(11) default NULL COMMENT '账单号',
  `status` varchar(20) default NULL COMMENT '状态',
  `pubtime` varchar(30) default NULL COMMENT '添加时间',
  `mark` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`RId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='回款记录表';

/*Data for the table `record` */

insert  into `record`(`RId`,`spid`,`clientid`,`CtrctId`,`RcrdT`,`RcrdQuant`,`BillId`,`status`,`pubtime`,`mark`) values (1,12,16,2,'2021-12-27T22:16',100,3,'通过审核','2021-12-27 22:16:25','说明如下'),(2,12,20,3,'2021-12-27T22:31',100,4,'通过审核','2021-12-27 22:31:50','eeee');

/*Table structure for table `salesperson` */

DROP TABLE IF EXISTS `salesperson`;

CREATE TABLE `salesperson` (
  `SPId` int(11) NOT NULL auto_increment COMMENT 'id',
  `SpName` varchar(50) default NULL COMMENT '姓名',
  `SpSex` varchar(20) default NULL COMMENT '性别',
  `SpAge` varchar(20) default NULL COMMENT '年龄',
  `SpPosition` varchar(100) default NULL COMMENT '职务',
  `uname` varchar(50) default NULL COMMENT '用户名',
  `pwd` varchar(50) default NULL COMMENT '密码',
  `pubtime` varchar(50) default NULL COMMENT '添加时间',
  PRIMARY KEY  (`SPId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='业务员表';

/*Data for the table `salesperson` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `uname` varchar(20) default NULL COMMENT '用户名',
  `sex` varchar(10) default NULL COMMENT '性别',
  `address` varchar(100) default NULL COMMENT '地址',
  `pwd` varchar(20) default NULL COMMENT '密码',
  `utype` varchar(30) default '会员' COMMENT '角色',
  `tel` varchar(20) default NULL COMMENT '电话',
  `age` varchar(10) default NULL COMMENT '年龄',
  `email` varchar(30) default NULL COMMENT '邮箱',
  `pubtime` varchar(30) default NULL COMMENT '添加时间',
  `tname` varchar(50) default NULL COMMENT '姓名',
  `note` text COMMENT '说明',
  `status` varchar(10) default NULL COMMENT '目前状态',
  `cid` int(11) default NULL COMMENT '销售员id',
  `img` varchar(255) default NULL COMMENT '图片',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户';

/*Data for the table `users` */

insert  into `users`(`id`,`uname`,`sex`,`address`,`pwd`,`utype`,`tel`,`age`,`email`,`pubtime`,`tname`,`note`,`status`,`cid`,`img`) values (1,'admin','男','地址23','123','管理员','14584845222',NULL,'15646@qq.com','2021-12-27 16:49:58','管理员',NULL,'正常',NULL,'head.jpg'),(12,'test','女','地址89','123456','业务员','14584845215',NULL,'115431678@qq.com','2021-12-27 16:49:58','测试用户',NULL,'正常',NULL,'20180314100339255.jpg'),(15,'yw01','男','街道121212','123456','业务员','15632189321',NULL,'646968805@qq.com','2021-12-27 16:49:58','业务员01','说明如下1212','正常',12,'20170910095708668.jpg'),(16,'kh01','男','街道12121222','123456','客户','15632189321',NULL,'646968805@qq.com','2021-12-27 16:53:23','张三','121212','正常',12,'20170915112724145.jpg'),(17,'kh02','女','街道121212','123456','客户','15632189321',NULL,'646968805@qq.com','2021-12-27 16:57:15','客户02','2323232','正常',12,'20170915113845579.jpg'),(18,'kh03','男','街道121212','123456','客户','15632189321',NULL,'646968805@qq.com','2021-12-27 17:03:49','客户03','2323','正常',12,'avatar.png'),(19,'yw02','男','街道7894','123456','业务员','13526879874',NULL,'646968805@qq.com','2021-12-27 22:28:15','业务02','222','正常',NULL,'20170915112724145.jpg'),(20,'kh04','女','1222','123456','客户','13526879874',NULL,'646968805@qq.com','2021-12-27 22:29:45','王五','333','正常',12,'20170915113845579.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
