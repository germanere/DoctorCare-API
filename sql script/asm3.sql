-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: asm03
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `clinics`
--

DROP TABLE IF EXISTS `clinics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_At` varchar(255) NOT NULL,
  `descript` text,
  `image` varchar(255) DEFAULT NULL,
  `introduction` text NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinics`
--

LOCK TABLES `clinics` WRITE;
/*!40000 ALTER TABLE `clinics` DISABLE KEYS */;
INSERT INTO `clinics` VALUES (1,'Da nang','2023-09-29','Mô tả phòng khám răng',NULL,'Giới thiệu phòng khám răng','Phòng khám răng','0910696969',10000),(2,'TP HCM','2023-09-29','Mô tả phòng khám da liễu','hinh_anh_1.jpg','Giới thiệu phòng khám da liễu','Phòng khám da liễu','0123456789',15000),(3,'Ha noi','2023-09-20','Mô tả phòng khám tim mạch',NULL,'Giới thiệu phòng khám tim mạch','Phòng khám tim mạch','0696969696',50000);
/*!40000 ALTER TABLE `clinics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_users`
--

DROP TABLE IF EXISTS `doctor_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_At` varchar(255) DEFAULT NULL,
  `clinic_id` int NOT NULL,
  `user_Id` int NOT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `descript` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  KEY `clinic_id` (`clinic_id`),
  CONSTRAINT `doctor_users_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `users` (`id`),
  CONSTRAINT `doctor_users_ibfk_2` FOREIGN KEY (`clinic_id`) REFERENCES `clinics` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_users`
--

LOCK TABLES `doctor_users` WRITE;
/*!40000 ALTER TABLE `doctor_users` DISABLE KEYS */;
INSERT INTO `doctor_users` VALUES (1,'3/1/2023',2,3,NULL,'9/1/2023','Dan',1,NULL),(2,'4/1/2023',1,1,NULL,'8/1/2023','Bac',1,NULL),(3,'10/1/2023',3,7,NULL,'12/1/2023','An',1,NULL);
/*!40000 ALTER TABLE `doctor_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extrainfos`
--

DROP TABLE IF EXISTS `extrainfos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extrainfos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_At` varchar(255) DEFAULT NULL,
  `moreInfo` text,
  `old_forms` text,
  `patient_Id` int NOT NULL,
  `place_Id` int DEFAULT NULL,
  `sendForms` text,
  `deleted_at` varchar(255) DEFAULT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `send_forms` varchar(255) DEFAULT NULL,
  `status_patient` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_Id` (`patient_Id`),
  KEY `place_Id` (`place_Id`),
  CONSTRAINT `extrainfos_ibfk_1` FOREIGN KEY (`patient_Id`) REFERENCES `patients` (`id`),
  CONSTRAINT `extrainfos_ibfk_2` FOREIGN KEY (`place_Id`) REFERENCES `places` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extrainfos`
--

LOCK TABLES `extrainfos` WRITE;
/*!40000 ALTER TABLE `extrainfos` DISABLE KEYS */;
INSERT INTO `extrainfos` VALUES (1,'2023-10-02','This is some additional information about the patient.','These are some old forms that the patient has filled out.',1,2,'These are the forms that the patient has sent.',NULL,'This is some more information about the patient.','2023-10-02',NULL,'Fine'),(2,'2023-10-02 10:27:31','This is some additional information about the patient.','These are some old forms that the patient has filled out.',2,3,'These are the forms that the patient has sent.',NULL,'This is some more information about the patient.','2023-10-02',NULL,'Monitored 24/7');
/*!40000 ALTER TABLE `extrainfos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `status` int NOT NULL,
  `user_Id` int NOT NULL,
  `pathologydetail` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `pathology` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `descript` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  CONSTRAINT `patients_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'Duc',1,2,'mất 1 phần răng','mất răng do tai nạn',NULL),(2,'Chi',1,4,'suy tim','suy tim bẩm sinh',NULL),(3,'Quang',1,6,'Sốt rét','Sốt rét lâu ngày',NULL);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `places` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES (1,'2a abc',NULL,'1/1/2023',NULL),(2,'3d 4dw',NULL,'2/1/2023',NULL),(3,'4c 5wq',NULL,'3/1/2023',NULL);
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `clinic_Id` int DEFAULT NULL,
  `contentHTML` text,
  `created_At` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `specialization_Id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_Id` int DEFAULT NULL,
  `confirmed_by_doctor` bit(1) DEFAULT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `booking` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  KEY `clinic_Id` (`clinic_Id`),
  KEY `FKpd52ir08owlxmmj5n0n46hb3s` (`specialization_Id`),
  CONSTRAINT `FKpd52ir08owlxmmj5n0n46hb3s` FOREIGN KEY (`specialization_Id`) REFERENCES `specialiazations` (`id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `users` (`id`),
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`clinic_Id`) REFERENCES `clinics` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,2,'ahehe','8/3/2023',NULL,6,'sửa mũi',1,_binary '',NULL,'9/3/2023',10000),(2,1,'ahihi','11/3/2023',NULL,1,'cấy răng',3,_binary '',NULL,'12/3/2023',20000),(3,3,'ahuhu','4/4/2023',NULL,4,'ghép tim',5,_binary '',NULL,'4/5/2023',50000);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_At` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'1/1/2023','Doctor','1/1/2023',NULL,NULL),(2,'1/1/2023','Patient','1/1/2023',NULL,NULL),(3,'1/1/2023','Support','1/1/2023',NULL,NULL),(4,'2/1/2023','Admin','2/1/2023',NULL,NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedules` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `max_booking` varchar(255) DEFAULT NULL,
  `sum_booking` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `descript` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd4y4xekwahv9boo6lc8gfl3jv` (`user_id`),
  CONSTRAINT `FKd4y4xekwahv9boo6lc8gfl3jv` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,'1/3/2023','24/2/2023',NULL,'20000','20000','12h-14h','2/3/2023',1,2,NULL),(2,'3/3/2023','28/5/2023',NULL,'3000','3000','14h-16h','28/9/2023',3,2,NULL),(3,'5/6/2023','5/6/2023',NULL,'10000','40000','13h-21h','4/6/2023',5,2,NULL),(4,'3/1/2023','3/1/2023',NULL,'20000',NULL,'14h-21h',NULL,3,3,'Cancel'),(5,'3/1/2023','3/1/2023',NULL,'20000',NULL,'14h-21h',NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session` (
  `created_At` varchar(255) DEFAULT NULL,
  `data` text,
  `expires` varchar(255) DEFAULT NULL,
  `sid` int NOT NULL AUTO_INCREMENT,
  `update_At` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialiazations`
--

DROP TABLE IF EXISTS `specialiazations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialiazations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descript` text,
  `image` varchar(255) DEFAULT NULL,
  `namepk` varchar(255) NOT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialiazations`
--

LOCK TABLES `specialiazations` WRITE;
/*!40000 ALTER TABLE `specialiazations` DISABLE KEYS */;
INSERT INTO `specialiazations` VALUES (1,'ahe',NULL,'Răng hàm mặt',NULL,'2/1/2023','1/1/2023'),(2,'ahehe',NULL,'Thần kinh',NULL,'2/1/2023','1/1/2023'),(3,'ahihi',NULL,'Tiêu hóa',NULL,'3/1/2023','2/1/2023'),(4,'ahi',NULL,'Tim mạch',NULL,'3/1/2023','2/1/2023'),(5,'ahu',NULL,'Tai – Mũi – Họng',NULL,'4/1/2023','3/1/2023'),(6,'ahuhu',NULL,'Da liễu',NULL,'4/1/2023','3/1/2023');
/*!40000 ALTER TABLE `specialiazations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supporterlogs`
--

DROP TABLE IF EXISTS `supporterlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supporterlogs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_Id` int DEFAULT NULL,
  `user_Id` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_Id` (`user_Id`),
  KEY `patient_Id` (`patient_Id`),
  CONSTRAINT `supporterlogs_ibfk_1` FOREIGN KEY (`user_Id`) REFERENCES `users` (`id`),
  CONSTRAINT `supporterlogs_ibfk_2` FOREIGN KEY (`patient_Id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supporterlogs`
--

LOCK TABLES `supporterlogs` WRITE;
/*!40000 ALTER TABLE `supporterlogs` DISABLE KEYS */;
INSERT INTO `supporterlogs` VALUES (7,1,1,'Khám da',NULL,NULL,'10/3/2023'),(8,2,3,'Khám răng hàm mặt',NULL,NULL,'8/3/2023'),(9,3,5,'khám tổng quát',NULL,NULL,'11/3/2023');
/*!40000 ALTER TABLE `supporterlogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `avatar` text,
  `descript` text,
  `email` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` int DEFAULT NULL,
  `role_id` int NOT NULL,
  `status` int NOT NULL,
  `deleted_at` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Hà Nội, Việt Nam',NULL,'ahihi','example@gmail.com','Nam','Bac','password123',923148327,1,1,NULL,NULL,'1/1/2023'),(2,'Đà Nẵng,Việt Nam',NULL,'ahehe','duc@gmail.com','Nam','Duc','duc123123',381123451,2,1,NULL,NULL,'1/1/2023'),(3,'Đà Nẵng,Việt Nam',NULL,'avas','dan@gmail.com','Nam','Dan','dan123123',313215434,1,1,NULL,NULL,'2/1/2023'),(4,'TP HCM ,Việt Nam',NULL,'abcd','chi@gmail.com','nữ','Chi','chi123123',132354658,2,1,NULL,NULL,'3/1/2023'),(5,'TP HCM ,Việt Nam',NULL,'abebe','den@gmail.com','nam','Den','den123123',386012352,1,1,NULL,NULL,'5/1/2023'),(6,'Hà Nội, Việt Nam',NULL,'adede','quang@gmail.com','nam','Quang','quang123123',321515134,2,1,NULL,NULL,'8/1/2023'),(7,'123ABC',NULL,NULL,'an@gmail.com','nam','An','an123123',127455789,1,1,NULL,NULL,'10/1/2023'),(8,'Nha trang,Viet Nam',NULL,NULL,'giang@abc.com','nu','yen','abc123123',123456124,4,1,NULL,NULL,'10/2/2023');
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

-- Dump completed on 2023-10-11  7:14:01
