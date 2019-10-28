CREATE DATABASE  IF NOT EXISTS `hero` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hero`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hero
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `building` (
  `ID` bigint(20) NOT NULL,
  `BUILDINGTIME` bigint(20) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `Empire_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_building_Empire_ID` (`Empire_ID`),
  CONSTRAINT `FK_building_Empire_ID` FOREIGN KEY (`Empire_ID`) REFERENCES `empire` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (251,2,'Trains soldiers','Barrack',156),(415,2,'chop-chop','Lumberyard',406),(418,2,'chop-chop','Lumberyard',406),(421,2,'too deep','Mine',406),(425,2,'produces food','Farm',406),(428,2,'ocsmanyiroda','Townhall',406),(432,2,'too deep','Mine',156),(436,2,'produces food','Farm',156);
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building_stock`
--

DROP TABLE IF EXISTS `building_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `building_stock` (
  `Building_ID` bigint(20) NOT NULL,
  `produce_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Building_ID`,`produce_ID`),
  KEY `FK_building_stock_produce_ID` (`produce_ID`),
  CONSTRAINT `FK_building_stock_Building_ID` FOREIGN KEY (`Building_ID`) REFERENCES `building` (`ID`),
  CONSTRAINT `FK_building_stock_produce_ID` FOREIGN KEY (`produce_ID`) REFERENCES `stock` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building_stock`
--

LOCK TABLES `building_stock` WRITE;
/*!40000 ALTER TABLE `building_stock` DISABLE KEYS */;
INSERT INTO `building_stock` VALUES (251,252),(251,253),(251,254),(415,416),(415,417),(418,419),(418,420),(421,422),(421,423),(421,424),(425,426),(425,427),(428,429),(428,430),(428,431),(432,433),(432,434),(432,435),(436,437),(436,438);
/*!40000 ALTER TABLE `building_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empire`
--

DROP TABLE IF EXISTS `empire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empire` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ENVIRONMENTTYPE` int(11) DEFAULT NULL,
  `LEVEL` bigint(20) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_empire_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_empire_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empire`
--

LOCK TABLES `empire` WRITE;
/*!40000 ALTER TABLE `empire` DISABLE KEYS */;
INSERT INTO `empire` VALUES (2,'firefighter',0,1,'Tom',1),(156,'green',2,1,'Middle Earth',52),(406,'sqlinjection',4,1,'105 OR 1=1',52);
/*!40000 ALTER TABLE `empire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empire_produce`
--

DROP TABLE IF EXISTS `empire_produce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empire_produce` (
  `Empire_ID` bigint(20) NOT NULL,
  `produce_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Empire_ID`,`produce_ID`),
  KEY `FK_empire_produce_produce_ID` (`produce_ID`),
  CONSTRAINT `FK_empire_produce_Empire_ID` FOREIGN KEY (`Empire_ID`) REFERENCES `empire` (`ID`),
  CONSTRAINT `FK_empire_produce_produce_ID` FOREIGN KEY (`produce_ID`) REFERENCES `stock` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empire_produce`
--

LOCK TABLES `empire_produce` WRITE;
/*!40000 ALTER TABLE `empire_produce` DISABLE KEYS */;
INSERT INTO `empire_produce` VALUES (156,157),(156,158),(156,159),(156,160),(406,407),(406,408),(406,409),(406,410);
/*!40000 ALTER TABLE `empire_produce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empire_warehouse`
--

DROP TABLE IF EXISTS `empire_warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empire_warehouse` (
  `Empire_ID` bigint(20) NOT NULL,
  `warehouse_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Empire_ID`,`warehouse_ID`),
  KEY `FK_empire_warehouse_warehouse_ID` (`warehouse_ID`),
  CONSTRAINT `FK_empire_warehouse_Empire_ID` FOREIGN KEY (`Empire_ID`) REFERENCES `empire` (`ID`),
  CONSTRAINT `FK_empire_warehouse_warehouse_ID` FOREIGN KEY (`warehouse_ID`) REFERENCES `stock` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empire_warehouse`
--

LOCK TABLES `empire_warehouse` WRITE;
/*!40000 ALTER TABLE `empire_warehouse` DISABLE KEYS */;
INSERT INTO `empire_warehouse` VALUES (156,161),(156,162),(156,163),(156,164),(406,411),(406,412),(406,413),(406,414);
/*!40000 ALTER TABLE `empire_warehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero`
--

DROP TABLE IF EXISTS `hero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hero` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `QUALITIES` longblob,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hero_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_hero_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero`
--

LOCK TABLES `hero` WRITE;
/*!40000 ALTER TABLE `hero` DISABLE KEYS */;
INSERT INTO `hero` VALUES (355,'11','Eleven',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x',52),(360,'Wolf house witcher','Geralt',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x',52),(371,'Wolf house witcher','Ciri',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x',52);
/*!40000 ALTER TABLE `hero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero_hybrid`
--

DROP TABLE IF EXISTS `hero_hybrid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hero_hybrid` (
  `Hero_ID` bigint(20) NOT NULL,
  `hybrids_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Hero_ID`,`hybrids_ID`),
  KEY `FK_hero_hybrid_hybrids_ID` (`hybrids_ID`),
  CONSTRAINT `FK_hero_hybrid_Hero_ID` FOREIGN KEY (`Hero_ID`) REFERENCES `hero` (`ID`),
  CONSTRAINT `FK_hero_hybrid_hybrids_ID` FOREIGN KEY (`hybrids_ID`) REFERENCES `hybrid` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero_hybrid`
--

LOCK TABLES `hero_hybrid` WRITE;
/*!40000 ALTER TABLE `hero_hybrid` DISABLE KEYS */;
INSERT INTO `hero_hybrid` VALUES (360,363),(360,364),(355,440),(371,443),(371,444);
/*!40000 ALTER TABLE `hero_hybrid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hybrid`
--

DROP TABLE IF EXISTS `hybrid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hybrid` (
  `ID` bigint(20) NOT NULL,
  `PERCENT` tinyint(4) DEFAULT NULL,
  `HERO_ID` bigint(20) DEFAULT NULL,
  `SPECIES_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hybrid_SPECIES_ID` (`SPECIES_ID`),
  KEY `FK_hybrid_HERO_ID` (`HERO_ID`),
  CONSTRAINT `FK_hybrid_HERO_ID` FOREIGN KEY (`HERO_ID`) REFERENCES `hero` (`ID`),
  CONSTRAINT `FK_hybrid_SPECIES_ID` FOREIGN KEY (`SPECIES_ID`) REFERENCES `species` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hybrid`
--

LOCK TABLES `hybrid` WRITE;
/*!40000 ALTER TABLE `hybrid` DISABLE KEYS */;
INSERT INTO `hybrid` VALUES (351,100,NULL,53),(352,0,NULL,54),(353,0,NULL,55),(354,0,NULL,56),(356,70,NULL,53),(357,0,NULL,54),(358,0,NULL,55),(359,30,NULL,56),(363,30,NULL,56),(364,70,NULL,53),(369,50,NULL,53),(370,50,NULL,55),(440,100,NULL,53),(443,50,NULL,55),(444,50,NULL,53);
/*!40000 ALTER TABLE `hybrid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `naturalasset`
--

DROP TABLE IF EXISTS `naturalasset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `naturalasset` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `naturalasset`
--

LOCK TABLES `naturalasset` WRITE;
/*!40000 ALTER TABLE `naturalasset` DISABLE KEYS */;
INSERT INTO `naturalasset` VALUES (101,'Mostly used for build buildings','Stone'),(102,'Mostly used for train the soldiers','Gold'),(103,'Mostly used for build buildings','Wood'),(104,'nyam','Food');
/*!40000 ALTER TABLE `naturalasset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (105,'people who likes minecraft','Miner'),(106,'they produces your food','Farmer'),(107,'normal figther guys','Soldier'),(108,'they can kill you in a brutal way','Badass soldier'),(109,'man for constructions','Worker');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `population`
--

DROP TABLE IF EXISTS `population`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `population` (
  `ID` bigint(20) NOT NULL,
  `QUANTITY` bigint(20) DEFAULT NULL,
  `PEOPLE_ID` bigint(20) DEFAULT NULL,
  `Empire_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_population_Empire_ID` (`Empire_ID`),
  KEY `FK_population_PEOPLE_ID` (`PEOPLE_ID`),
  CONSTRAINT `FK_population_Empire_ID` FOREIGN KEY (`Empire_ID`) REFERENCES `empire` (`ID`),
  CONSTRAINT `FK_population_PEOPLE_ID` FOREIGN KEY (`PEOPLE_ID`) REFERENCES `people` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `population`
--

LOCK TABLES `population` WRITE;
/*!40000 ALTER TABLE `population` DISABLE KEYS */;
INSERT INTO `population` VALUES (151,10,105,156),(152,30,106,156),(153,10,107,156),(154,10,108,156),(155,10,109,156),(401,10,105,406),(402,10,106,406),(403,10,107,406),(404,10,108,406),(405,20,109,406);
/*!40000 ALTER TABLE `population` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',450);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `species` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `QUALITIES` longblob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species`
--

LOCK TABLES `species` WRITE;
/*!40000 ALTER TABLE `species` DISABLE KEYS */;
INSERT INTO `species` VALUES (53,'Bold','Human',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x'),(54,'Strong','Dwarf',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x'),(55,'Chosen ones','Elder Blood',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x'),(56,'Wolf School Witcher','Mutant',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x');
/*!40000 ALTER TABLE `species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `ID` bigint(20) NOT NULL,
  `QUANTITY` bigint(20) DEFAULT NULL,
  `ASSET_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_stock_ASSET_ID` (`ASSET_ID`),
  CONSTRAINT `FK_stock_ASSET_ID` FOREIGN KEY (`ASSET_ID`) REFERENCES `naturalasset` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (157,80,101),(158,0,102),(159,0,103),(160,10,104),(161,5,101),(162,5,102),(163,5,103),(164,10,104),(202,40,101),(203,20,102),(204,30,103),(252,40,101),(253,20,102),(254,30,103),(407,0,101),(408,0,102),(409,80,103),(410,100,104),(411,5,101),(412,10,102),(413,5,103),(414,5,104),(416,30,101),(417,10,103),(419,30,101),(420,10,103),(422,20,101),(423,10,102),(424,30,103),(426,10,101),(427,30,103),(429,50,101),(430,50,102),(431,50,103),(433,20,101),(434,10,102),(435,30,103),(437,10,101),(438,30,103);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL,
  `ADMIN` tinyint(1) DEFAULT '0',
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,'aaa','a'),(51,0,'a','a'),(52,0,'el','11'),(301,0,'username','password');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-28 23:12:13
