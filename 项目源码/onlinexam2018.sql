-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinexam2018
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'如何撩妹'),(2,'如何成为女装大佬'),(3,'ACG'),(4,'动漫赏析'),(5,'如何与大佬相处'),(6,'单片机'),(7,'计算机科学与技术'),(8,'开发测试');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper`
--

DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `time` varchar(11) NOT NULL,
  `score` double NOT NULL,
  `wrongQueId` varchar(1000) DEFAULT NULL,
  `wrongAns` varchar(1000) DEFAULT NULL,
  `studentId` int(11) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper`
--

LOCK TABLES `paper` WRITE;
/*!40000 ALTER TABLE `paper` DISABLE KEYS */;
INSERT INTO `paper` VALUES (10,17,3,'0分10秒',80,'3','C',7,'2018-01-16 20:26:25'),(11,15,4,'0分8秒',75,'18','D',7,'2018-01-16 20:26:52'),(12,17,3,'0分6秒',20,'3,13,14,15','C,C,C,B',1,'2018-01-17 09:02:31'),(13,15,4,'0分5秒',0,'4,18,19,20','B,C,D,B',1,'2018-01-17 17:04:10'),(14,17,3,'0分6秒',40,'3,13,15','B,B,B',6,'2018-01-17 18:54:46'),(15,13,3,'0分6秒',0,'3,5,13,14,15','B,C,B,C,D',7,'2018-01-17 20:42:00');
/*!40000 ALTER TABLE `paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `queType` int(11) NOT NULL,
  `queTitle` varchar(1000) NOT NULL,
  `choiceA` varchar(1000) NOT NULL,
  `choiceB` varchar(1000) NOT NULL,
  `choiceC` varchar(1000) NOT NULL,
  `choiceD` varchar(1000) NOT NULL,
  `ans` varchar(50) NOT NULL,
  `queExist` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,1,1,'送妹子什么好呢?','神仙水','布娃娃','口红，嗯','money，嗯','D',1),(2,2,1,'女装大佬的身份?','程序员','程序猿','程序媛','程序元','D',1),(3,3,3,'7月新番的黑马番是哪个?','关我碧事','血界战线','犬屋敷','食戟之灵第三季','D',1),(4,4,4,'你怎么看待《你的名字》?','好','棒','很棒','前无古人','D',1),(5,3,1,'海贼王的猪脚叫什么','路费','路飞','路西','海贼王','B',1),(7,1,1,'请回答','1','2','3','4','A',1),(8,5,1,'大黄是怎么来的','石头里蹦出来的','UMR的孩子','侯哥的孩子','本浩的儿子','B',1),(9,1,1,'1','1','2','3','4','A',1),(10,1,1,'2','1','2','3','4','B',1),(11,1,1,'3','1','2','3','4','C',1),(12,1,1,'4','1','2','3','4','D',1),(13,3,1,'1','1','2','3','4','A',1),(14,3,1,'2','1','2','3','4','B',1),(15,3,1,'3','1','2','3','4','C',1),(16,5,1,'1','1','2','3','4','A',1),(17,5,1,'3','1','2','3','4','C',1),(18,4,1,'1','1','2','3','4','A',1),(19,4,1,'2','1','2','3','4','B',1),(20,4,1,'3','1','2','3','4','C',1),(21,5,1,'大黄的爸爸有几个','1','2','3','X','D',1);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stuclass`
--

DROP TABLE IF EXISTS `stuclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stuclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  `deptName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stuclass`
--

LOCK TABLES `stuclass` WRITE;
/*!40000 ALTER TABLE `stuclass` DISABLE KEYS */;
INSERT INTO `stuclass` VALUES (1,'动漫1班','动漫'),(2,'动漫二班','测试'),(3,'中二病7班','中二病'),(4,'家里蹲火箭班','家里蹲'),(5,'单片机X班','单片机'),(6,'3年E班','中二病'),(7,'魔法1班','魔法');
/*!40000 ALTER TABLE `stuclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `school` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `born` varchar(255) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'张三','123','家里蹲大学','男','1996-10-21',1),(2,'雷姆','123','异世界大学','女','1997-10-30',2),(3,'豪子','123','山理工','男','1996-10-21',2),(4,'大黄','123','山理','男','1996-10-21',2),(6,'奈绪','1234','某学园','男','1996-10-21',6),(7,'UMR','123','山理工','男','1996-10-21',6);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `deptName` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'张','123','家里蹲'),(2,'李四','123','中二病'),(3,'2','123','测试'),(4,'豪子','123','测试'),(5,'苏苏','465','逗比美学'),(6,'李四','123','开发'),(7,'王五','123','逗比美学'),(8,'傻蛋','123','中二病'),(9,'UMR小豪','123','家里蹲'),(10,'UMR','123','中二病');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachercourse`
--

DROP TABLE IF EXISTS `teachercourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachercourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `teaId` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachercourse`
--

LOCK TABLES `teachercourse` WRITE;
/*!40000 ALTER TABLE `teachercourse` DISABLE KEYS */;
INSERT INTO `teachercourse` VALUES (1,1,1,1),(2,2,2,2),(3,5,4,2),(5,10,5,1),(6,3,4,1),(7,5,2,5),(8,8,8,3),(9,2,9,4),(10,3,10,6),(11,1,10,1),(12,7,10,5),(13,4,10,4);
/*!40000 ALTER TABLE `teachercourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `courseId` int(11) NOT NULL,
  `endDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `testTime` int(11) NOT NULL,
  `questions` varchar(2000) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `classIds` varchar(2000) NOT NULL,
  `scores` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (12,'ACG测试',3,'2018-01-31 16:33:05',45,'5,13,3,15,14',10,'6,1,5,4','100'),(13,'ACG测试',3,'2018-01-30 16:55:53',45,'15,5,13,14,3',10,'6,1','100'),(15,'动漫测试',4,'2018-01-17 10:21:54',45,'18,4,20,19',10,'6,1','100'),(16,'程序员测试',2,'2018-01-24 15:10:44',45,'2',9,'4','100'),(17,'123',3,'2018-01-17 19:44:07',45,'13,15,5,14,3',10,'6,1','100'),(18,'123',3,'2018-01-20 19:44:38',45,'15,13,3,5,14',10,'5,4','100'),(19,'撩妹知识',1,'2018-01-24 00:41:15',45,'12,10,1,9,7,11',10,'5,4','100');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-19 14:18:04
