-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: wateless
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Username` varchar(80) NOT NULL,
  `Password` varchar(80) NOT NULL,
  `Email` varchar(80) NOT NULL,
  `Phone` varchar(13) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `EmailAddress_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES (1,'JonathanJoe','AlpacaLama2431','jojoe@yahoo.com','264456787'),(3,'Boros15','Jura@87jh','boris.kresnik@hotmail.com','786987546'),(6,'Andrei','Comatose7@98','andrei.col@gmail.com','789012390'),(7,'JohnDoe','7ghasHGS912','johndoe@gmail.com','264576897'),(8,'Tudor12','Cia99@00','tudor.cia@yahoo.com','789654324'),(9,'Andrew','Enavel9&86@3','Andrew.John@gmail.com','987065432'),(10,'Regis','123123123','Regi.Fill@hotmail.com','987023431'),(12,'Bogdan56','987987987','bogdan.vox@gmail.com','264456789'),(13,'qeweqw','123123123','eqweqw@hoy.com','1231231233'),(14,'Krishna','1231231231','krshina.ak@cmai.co.uk','9786463745'),(15,'YuriH','123123123','yurihoa@hotmail.com','0876574876'),(16,'Dragon','123123123','dragon@yahoo.com','0978567432'),(17,'Catav','123123123','Cata@gmail.com','0967857645'),(18,'Abububu','123123123','abubub@hotmail.com','9999999999'),(19,'Johnny','asdfmovie','asdf@asdf.com','0988764695'),(29,'Bogdand','111111111','bogdan@hotmail.com','9876678876'),(30,'Johnnny','123123123','Johnnny@hotmail.com','0789765456'),(32,'AbraCad','123123123','abracad@hush.co.uk','0267847657');
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-23 16:12:20
