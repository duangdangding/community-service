-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: community-service
-- ------------------------------------------------------
-- Server version	5.7.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `communityseniorgroup`
--

DROP TABLE IF EXISTS `communityseniorgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `communityseniorgroup` (
  `olderlD` int(11) NOT NULL AUTO_INCREMENT COMMENT '老年信息ID',
  `createtime` datetime DEFAULT NULL COMMENT '添加时间',
  `title` varchar(100) DEFAULT NULL COMMENT '题目',
  `contact` varchar(100) DEFAULT NULL COMMENT '内容',
  `building` varchar(100) DEFAULT NULL COMMENT '居住楼',
  `houseNo` varchar(100) DEFAULT NULL COMMENT '门牌号',
  `emergency` varchar(100) DEFAULT NULL COMMENT '紧急联系人电话',
  `username` varchar(100) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `lieBed` varchar(100) DEFAULT NULL COMMENT '是否卧床',
  PRIMARY KEY (`olderlD`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='社区老年团表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `communityseniorgroup`
--

LOCK TABLES `communityseniorgroup` WRITE;
/*!40000 ALTER TABLE `communityseniorgroup` DISABLE KEYS */;
INSERT INTO `communityseniorgroup` VALUES (1,NULL,NULL,NULL,'#3','301','q123','啊额','女',11,'未卧床'),(2,NULL,NULL,NULL,'#1','301','q123','俺是个','女',11,'已卧床');
/*!40000 ALTER TABLE `communityseniorgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convenienceinformation`
--

DROP TABLE IF EXISTS `convenienceinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenienceinformation` (
  `convenientID` int(11) NOT NULL AUTO_INCREMENT COMMENT '便民信息ID',
  `notice` varchar(100) DEFAULT NULL COMMENT '社区公告',
  `activity` varchar(100) DEFAULT NULL COMMENT '社区活动',
  `news` varchar(100) DEFAULT NULL COMMENT '系统信息',
  `title` varchar(100) DEFAULT NULL,
  `major` varchar(100) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`convenientID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='便民信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenienceinformation`
--

LOCK TABLES `convenienceinformation` WRITE;
/*!40000 ALTER TABLE `convenienceinformation` DISABLE KEYS */;
INSERT INTO `convenienceinformation` VALUES (2,NULL,NULL,NULL,' 1234','社区公告','已审核'),(3,NULL,NULL,NULL,' 1231','社区公告','已审核');
/*!40000 ALTER TABLE `convenienceinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventprocessing`
--

DROP TABLE IF EXISTS `eventprocessing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventprocessing` (
  `eventID` int(11) NOT NULL AUTO_INCREMENT COMMENT '事件ID',
  `createtime` datetime DEFAULT NULL COMMENT '添加时间',
  `contact` varchar(100) DEFAULT NULL COMMENT '内容',
  `progress` varchar(100) DEFAULT NULL COMMENT '处理进度',
  `eventType` varchar(100) DEFAULT NULL COMMENT '事件类型',
  PRIMARY KEY (`eventID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='事件处理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventprocessing`
--

LOCK TABLES `eventprocessing` WRITE;
/*!40000 ALTER TABLE `eventprocessing` DISABLE KEYS */;
INSERT INTO `eventprocessing` VALUES (1,'2023-06-10 22:38:36',' 123','处理中','非紧急事件'),(2,'2023-06-10 22:40:43',' 36264','新发布',NULL),(3,'2023-06-10 22:45:29',' 123','新发布','紧急事件');
/*!40000 ALTER TABLE `eventprocessing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceplace`
--

DROP TABLE IF EXISTS `serviceplace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceplace` (
  `serviceplaceID` int(11) NOT NULL AUTO_INCREMENT COMMENT '场所ID',
  `serviceplaceName` varchar(30) DEFAULT NULL COMMENT '场所名称',
  `erviceplacetype` varchar(10) DEFAULT NULL COMMENT '场所类别',
  `placeadder` varchar(30) DEFAULT NULL COMMENT '场所地址',
  `number` int(11) DEFAULT NULL COMMENT '从业人员数量',
  `bossname` varchar(100) DEFAULT NULL COMMENT '经营者',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`serviceplaceID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='服务场所表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceplace`
--

LOCK TABLES `serviceplace` WRITE;
/*!40000 ALTER TABLE `serviceplace` DISABLE KEYS */;
INSERT INTO `serviceplace` VALUES (1,'啊手动阀士大夫',NULL,'案说法111',11,' 阿斯顿','11111111111'),(2,'123',NULL,'1231',11,'十大是','11111111111'),(3,'123123',NULL,'123123',12,'撒发射','21241616136');
/*!40000 ALTER TABLE `serviceplace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenement`
--

DROP TABLE IF EXISTS `tenement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenement` (
  `residentID` int(11) NOT NULL COMMENT '住户ID',
  `residentName` varchar(8) NOT NULL COMMENT '住户姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `addr` varchar(45) DEFAULT NULL COMMENT '家庭地址',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `number` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `workunit` varchar(20) DEFAULT NULL COMMENT '工作单位',
  PRIMARY KEY (`residentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='住户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenement`
--

LOCK TABLES `tenement` WRITE;
/*!40000 ALTER TABLE `tenement` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `usertype` int(11) DEFAULT NULL COMMENT '用户类型1管理员2网格长',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','123',1),(2,'wgz','123',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'community-service'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-11  1:41:06
