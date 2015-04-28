CREATE DATABASE  IF NOT EXISTS `vitsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vitsdb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: vitsdb
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
-- Table structure for table `allowance`
--

DROP TABLE IF EXISTS `allowance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allowance` (
  `Country` varchar(20) NOT NULL,
  `Amount` int(11) NOT NULL,
  PRIMARY KEY (`Country`),
  UNIQUE KEY `Country_UNIQUE` (`Country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allowance`
--

LOCK TABLES `allowance` WRITE;
/*!40000 ALTER TABLE `allowance` DISABLE KEYS */;
INSERT INTO `allowance` VALUES ('Denmark',873),('Finland',678),('France',649),('Germany',571),('Japan',470),('Norway',961),('Poland',357),('Russia',599),('Sweden',220),('Uganda',325),('UK',680),('USA',552);
/*!40000 ALTER TABLE `allowance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignment` (
  `AssignmentID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`AssignmentID`),
  UNIQUE KEY `AssignmentID_UNIQUE` (`AssignmentID`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES (1,'Networking with Apple','Networking at the iPhone release event.'),(2,'Spy on Microsoft','Steal information about the new \"revolutionary\" Holo Lens.');
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receipt` (
  `ReceiptID` int(11) NOT NULL AUTO_INCREMENT,
  `TripID` int(11) NOT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Amount` int(11) NOT NULL,
  `ReportID` int(11) DEFAULT NULL,
  `Picture` blob,
  PRIMARY KEY (`ReceiptID`),
  UNIQUE KEY `ReceiptID_UNIQUE` (`ReceiptID`),
  KEY `ReportID_idx` (`ReportID`),
  KEY `TripID_idx` (`TripID`),
  CONSTRAINT `ReportID` FOREIGN KEY (`ReportID`) REFERENCES `report` (`ReportID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TripID` FOREIGN KEY (`TripID`) REFERENCES `trip` (`TripID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `ReportID` int(11) NOT NULL AUTO_INCREMENT,
  `SenderID` int(11) NOT NULL,
  `ReceiverID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Sent` int(11) NOT NULL,
  `Approved` int(11) NOT NULL,
  `AssignmentID` int(11) NOT NULL,
  PRIMARY KEY (`ReportID`),
  UNIQUE KEY `ReportID_UNIQUE` (`ReportID`),
  KEY `UserID_idx` (`SenderID`),
  KEY `ReceiverID_idx` (`ReceiverID`),
  KEY `AssignmentID_idx` (`AssignmentID`),
  CONSTRAINT `ReceiverID` FOREIGN KEY (`ReceiverID`) REFERENCES `users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ReportAssignmentID` FOREIGN KEY (`AssignmentID`) REFERENCES `assignment` (`AssignmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SenderID` FOREIGN KEY (`SenderID`) REFERENCES `users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,2,11,'0001-01-01',1,0,1),(2,3,11,'0002-02-02',1,0,2),(3,2,11,'0004-03-03',1,1,2),(4,4,11,'0002-10-21',1,2,1);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traveladvances`
--

DROP TABLE IF EXISTS `traveladvances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traveladvances` (
  `TrAdID` int(11) NOT NULL AUTO_INCREMENT,
  `Amount` int(11) NOT NULL,
  `Approved` int(11) NOT NULL,
  `AssignmentID` int(11) NOT NULL,
  `Reason` varchar(100) DEFAULT NULL,
  `SenderID` int(11) NOT NULL,
  `ReceiverID` int(11) NOT NULL,
  PRIMARY KEY (`TrAdID`),
  UNIQUE KEY `TrAdID_UNIQUE` (`TrAdID`),
  KEY `TravelAssignmentID_idx` (`AssignmentID`),
  KEY `TravelSenderID_idx` (`SenderID`),
  KEY `TravelReceiverID_idx` (`ReceiverID`),
  CONSTRAINT `TravelAssignmentID` FOREIGN KEY (`AssignmentID`) REFERENCES `assignment` (`AssignmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TravelReceiverID` FOREIGN KEY (`ReceiverID`) REFERENCES `users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TravelSenderID` FOREIGN KEY (`SenderID`) REFERENCES `users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traveladvances`
--

LOCK TABLES `traveladvances` WRITE;
/*!40000 ALTER TABLE `traveladvances` DISABLE KEYS */;
INSERT INTO `traveladvances` VALUES (1,123,0,1,'blablabla',2,1),(2,666,0,2,'hahaha',3,1),(3,1337,0,2,'lololol',2,1),(4,619,0,1,'omg',3,1);
/*!40000 ALTER TABLE `traveladvances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travelorder`
--

DROP TABLE IF EXISTS `travelorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travelorder` (
  `TravelOrderID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `FromDate` date DEFAULT NULL,
  `ToDate` date DEFAULT NULL,
  `Country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TravelOrderID`),
  UNIQUE KEY `TravelOrderID_UNIQUE` (`TravelOrderID`),
  KEY `TrOrUserID_idx` (`UserID`),
  KEY `TrOrCountry_idx` (`Country`),
  CONSTRAINT `TrOrUserID` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travelorder`
--

LOCK TABLES `travelorder` WRITE;
/*!40000 ALTER TABLE `travelorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `travelorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip` (
  `TripID` int(11) NOT NULL AUTO_INCREMENT,
  `FromCountry` varchar(50) NOT NULL,
  `ToCountry` varchar(50) NOT NULL,
  `Transport` varchar(20) NOT NULL,
  `DepartureDate` datetime NOT NULL,
  `ArrivalDate` datetime NOT NULL,
  `VacationDays` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `ReportID` int(11) DEFAULT NULL,
  `AssignmentID` int(11) NOT NULL,
  PRIMARY KEY (`TripID`),
  UNIQUE KEY `TripID_UNIQUE` (`TripID`),
  KEY `UserId_idx` (`UserID`),
  KEY `TripReportID_idx` (`ReportID`),
  KEY `Assignment_idx` (`AssignmentID`),
  CONSTRAINT `Assignment` FOREIGN KEY (`AssignmentID`) REFERENCES `assignment` (`AssignmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TripReportID` FOREIGN KEY (`ReportID`) REFERENCES `report` (`ReportID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Status` int(11) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserID_UNIQUE` (`UserID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Filip Gezelius','filgev131@studentmail.oru.se','filip','123',1),(2,'Niklas Sundberg','ivanhoesmith22@gmail.com','niklas','123',1),(3,'Adam Hotcocoa','adam_getachew@hotmail.com','adam','123',1),(4,'Henrik Ho','henrik.yuan.ho@hotmail.com','henrikho','123',1),(5,'Henrik Björklund','henrik.bjorklund@live.se','henrikbj','123',1),(6,'Josefin Ericson','josefin.ericson@outlook.com','josefin','123',1),(7,'Daahir Galbeyte','Musse.ahmed@hotmail.com','musse','123',1),(8,'Sakariye Jibril','sakariyejunni5@gmail.com','sakariye','123',1),(9,'Gaspar Perez','gaspariperez@gmail.com','gaspar','123',1),(10,'Philip Börlin','philip.borlin@gmail.com','philip','123',1),(11,'Boss','boss@boss.com','boss','123',1),(12,'Consultant','consultant@user.com','consultant','123',0),(13,'User','user@user.com','user','123',0);
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

-- Dump completed on 2015-04-28 15:44:15
