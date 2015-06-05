-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: transport
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `disabled` bit(1) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `ready` bit(1) NOT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `carId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FK_d00307p17ph4u1trag9rk671p` (`carId`),
  CONSTRAINT `FK_d00307p17ph4u1trag9rk671p` FOREIGN KEY (`carId`) REFERENCES `car` (`carId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'\0','Иван','Петров','40c5acc6c50a1b760a62662fedeb8cddb336f4c8','523423444233','\0','ADMIN','root',NULL),(2,'\0','Иван','Петров','e099604cb286fd2dbef3452e37fe0385bf1af95a','0672380835','\0','DISPATCHER','dis1',NULL),(3,'','Иван','Петров','0947985901b34a00da5976f862335fb7a5f7fecf','3463773445','\0','DRIVER','dis2',NULL),(4,'\0','Иван','Петров','370e47598b7721333a0f8b12aa8a618595c2645b','123345778899','','DRIVER','driver1',8),(5,'\0','Иван','Иванов','81eff1dc3219a44633cfce2e576dae1194088c02','3434637744','\0','DRIVER','driver2',3),(6,'\0','Иван','Сидоров','4b7d4dc46a73b87c5a263fec0b6a0d3171cc60f1','34543543267','','DRIVER','driver3',2),(7,'\0','Иван','Козлов','71c85312aabad8b91ba5f908a1cdf2599684d420','84364678539','','DRIVER','driver4',4),(8,'\0','Иван','Петров','1d133414a54a2a7c683bedbc3934b960ac4346b8','3437289999','','DRIVER','driver5',5),(9,'','Алексей','Иванов','7c3188f562d66eb4a5f0a9d81dc8d5821cba9ba7','0672380835','\0','DRIVER','driver6',NULL),(10,'\0','Степан','Бандера','0c28577a09a49d73d16e636b1bc1fd6decbca9cb','123345778899','','DRIVER','毛澤東',7),(11,'\0','qwerty','qwerty','364173d80cccb83e474b3831a5492c829cdf0b86','2783789918','\0','ADMIN','admin1',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-28 13:03:43
