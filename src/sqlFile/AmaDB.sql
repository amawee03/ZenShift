-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: staffmanagement
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Dumping data for table `request_leave`
--

LOCK TABLES `request_leave` WRITE;
/*!40000 ALTER TABLE `request_leave` DISABLE KEYS */;
INSERT INTO `request_leave` VALUES (3,'123','sick','2025-05-13','2025-05-27','thgfewertyuiolkjhgfd'),(4,'1233','casual','2025-05-14','2025-05-27','hjjj'),(5,'1233','casual','2025-05-14','2025-05-27','hjjj'),(6,'9474','maternity','2025-05-13','2025-05-27','uttn'),(7,'123','casual','2025-06-06','2025-06-04','uuuu'),(8,'123','sick','2025-05-30','2025-06-07','qqqq'),(10,'456','casual','2025-05-31','2025-07-06','Lectures'),(13,'1928','maternity','2025-05-18','2025-05-22','Child is sick');
/*!40000 ALTER TABLE `request_leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `requestsalery`
--

LOCK TABLES `requestsalery` WRITE;
/*!40000 ALTER TABLE `requestsalery` DISABLE KEYS */;
INSERT INTO `requestsalery` VALUES (3,'Madhawa','8838','shhhshs','2025-05-21'),(12,'Thiloni','5000','Course Fee','2025-05-30'),(13,'Thisali','11000','Medical emergency','2025-05-18');
/*!40000 ALTER TABLE `requestsalery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (136,'2929','Shawn Mendes','Test Website','A WAR file can be created with the jar command, included in the Java runtime environment, or a ZIP utility program such as WinZip','2025-05-11 06:08:02','2025-05-17','medium'),(135,'3787','Senuja Thisas','Lorem Ipsum','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc cursus nec arcu sed congue','2025-05-11 04:10:47','2025-05-15','medium'),(121,'ER3738','Amasha Weerasuriya','Test 1','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc auctor lobortis odio ut mollis. ','2025-05-06 08:15:39','2025-06-07','low'),(122,'ER7392','Thavisha','Test2','Suspendisse potenti. Maecenas pretium tincidunt enim id accumsan. Morbi rutrum eu sapien vitae suscipit','2025-05-06 08:17:54','2025-05-15','medium'),(123,'ER9364','Amitha','test 3','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ante tellus, malesuada varius scelerisque dignissim, iaculis id nunc.','2025-05-06 17:21:33','2025-05-15','medium'),(126,'ER4648','Thiloni','Test','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus placerat massa at sapien cursus faucibus. Etiam odio felis, accumsan ac suscipit eu, feugiat nec nulla.','2025-05-07 06:51:16','2025-05-17','high'),(127,'ER5032','Upul Weerasuriya','Test','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus placerat massa at sapien cursus faucibus. Etiam odio felis, accumsan ac suscipit eu, feugiat nec nulla.','2025-05-07 08:21:46','2025-07-03','medium');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'Isuru ','isuru1@gmail.com','admin1234','0123456789','admin'),(5,'admin','admin@1.com','admin123','0769111498','admin'),(8,'Amitha','ami1@gmail.com','12345','0777330519','user'),(13,'Navoda','navoda1@gmail.com','12345','0777330519','user'),(14,'Madhawa','madhawa1@gmail.com','12345','0777330519','user'),(15,'Amasha','amasha1@gmail.com','12345','0777330519','user'),(16,'test','t1@gmail.com','12345','0777330519','user'),(17,'Isuru','john@example.com','admin123','0777330465','admin');
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

-- Dump completed on 2025-05-11 13:28:06
