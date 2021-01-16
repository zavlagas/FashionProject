-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: fashion
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brands` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `descr` text,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `image_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `brands_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (14,1,'Versace','Founded in 1978 in Milan, Gianni Versace S.r.l. is one of the leading international fashion design houses and a symbol of Italian luxury world-wide. It designs, manufactures, distributes and retails fashion and lifestyle products including haute couture, prèt-à-porter, accessories, jewellery, watches, eyewear, fragrances, and home furnishings all bearing the distinctive Medusa logo.','2021-01-16 14:06:25','https://res.cloudinary.com/zavlagas/image/upload/v1610798782/fashion/Versace-Logo_yrewuq.png'),(15,7,'Nike','It was founded in 1964 as Blue Ribbon Sports by Bill Bowerman, a track-and-field coach at the University of Oregon, and his former student Phil Knight. They opened their first retail outlet in 1966 and launched the Nike brand shoe in 1972. The company was renamed Nike, Inc., in 1978 and went public two years later.','2021-01-16 15:34:01','https://res.cloudinary.com/zavlagas/image/upload/v1610804037/fashion/nike-logo_lu0tcu.png');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plans`
--

DROP TABLE IF EXISTS `plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plans` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plans`
--

LOCK TABLES `plans` WRITE;
/*!40000 ALTER TABLE `plans` DISABLE KEYS */;
INSERT INTO `plans` VALUES (1,'FASHION_LOVER',0.00),(2,'FASHION_MAKER',20.00);
/*!40000 ALTER TABLE `plans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `image_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `image_path` (`image_path`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_images_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
INSERT INTO `product_images` VALUES (1,NULL,'https://res.cloudinary.com/zavlagas/image/upload/v1610728031/fashion/mute_ghpkkq.png'),(2,NULL,'https://res.cloudinary.com/zavlagas/image/upload/v1610728033/fashion/seo-image_qooomn.jpg'),(5,4,'https://res.cloudinary.com/zavlagas/image/upload/v1610799109/fashion/satin-tsirt_ptvqxb.jpg'),(6,5,'https://res.cloudinary.com/zavlagas/image/upload/v1610799224/fashion/mixed-fousta_pmoyqa.jpg'),(7,6,'https://res.cloudinary.com/zavlagas/image/upload/v1610799720/fashion/black-woman_vk3hl4.jpg'),(8,8,'https://res.cloudinary.com/zavlagas/image/upload/v1610800765/fashion/blonde-woman_clucfn.jpg'),(9,9,'https://res.cloudinary.com/zavlagas/image/upload/v1610804365/fashion/nike-hoodie_akjbdg.jpg'),(10,10,'https://res.cloudinary.com/zavlagas/image/upload/v1610804508/fashion/fashion-clothes_ok1mxq.jpg'),(12,12,'https://res.cloudinary.com/zavlagas/image/upload/v1610805073/fashion/nike-yoga_ufpl3g.jpg'),(13,13,'https://res.cloudinary.com/zavlagas/image/upload/v1610805167/fashion/Sportswear_euverg.jpg');
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand_id` int DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `descr` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (4,14,'Mixed Print Satin Dress','Light and feminine, this satin dress in mixed prints transitions seamlessly from workwear to evening chic. The loose style features a pussy-bow, while the waistline is accentuated by a fabric belt with loop fastening. Style with pumps and a tote for the office and switch to statement sandals and glossy shoulder bag for a dinner date'),(5,14,'Mixed Print Silk Midi Shirt Dress','Crafted from pure silk twill, this relaxed shirt dress boasts a colorful mix of seasonal prints. The midi design features a pussy-bow neckline and is adorned with gold-tone Medusa buttons. Style with pastel accessories for an eclectic take on a classic design.'),(6,14,'Python Print Midi Dress','Crafted from viscose georgette in the Python print, this sleek midi dress transitions seamlessly from day to evening. The form-fitting style is lightly draped along the bust and gathered with jewelry ring-shaped hardware, revealing a subtle hint of skin underneath'),(8,14,'Barocco Patchwork Print Dress','Versatile cady dress in the colorful Barocco Patchwork design - a fusion of heritage prints and bold animalier patterns. For a seamless transition from the office to happy hour, style yours with heeled sandals and a pastel Virtus ba'),(9,15,'Nike Sportswear Icon Clash','The Nike Sportswear Hoodie updates a wardrobe staple with bold color blocking and an oversized fit. A soft, semi-brushed fleece fabric offers a comfortable feel perfect for layering.'),(10,15,'Nike Sportswear Repel','Cozy and carefree, the Nike Sportswear Repel Jacket offers throwback style ready for cool-weather layering. Made with at least 75% recycled fibers, the woven fabric has a lightweight yet durable feel. Sweat-wicking mesh lining offers a breathable layer to keep you feeling dry throughout the day.'),(12,15,'Nike Yoga','The Nike Yoga Fleece Cover Up is made with soft thermal fabric for warm comfort. A relaxed, stretchy design lets you wear it as a V-neck or off the shoulder.'),(13,15,'Nike Sportswear Tech Fleece','Designed for warmth, the Nike Sportswear Tech Fleece Hoodie is made with a soft double-knit jacquard fabric. This engineered construction pulls color from the lining to the surface, creating an allover grid pattern that compliments the contrast zip and Swoosh detail. This product is made with at least 50% recycled polyester fibers.');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'ADMIN'),(1,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `plan_id` tinyint NOT NULL,
  `start_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `plan_id` (`plan_id`),
  CONSTRAINT `subscriptions_ibfk_2` FOREIGN KEY (`plan_id`) REFERENCES `plans` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (1,2,'2021-01-05 12:51:03'),(2,1,NULL),(3,1,'2021-01-14 17:18:38'),(4,1,'2021-01-14 17:38:13'),(5,1,'2021-01-14 17:39:31'),(6,1,'2021-01-14 17:45:24'),(7,2,'2021-01-16 14:43:41');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` int NOT NULL,
  `role_id` tinyint NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_roles_ibfk_3` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(1,2),(2,1),(3,1),(4,1),(5,1),(6,1),(7,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `username` varchar(68) NOT NULL,
  `password` varchar(68) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `subscription_id` int NOT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `users_ibfk_2` (`subscription_id`),
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`subscription_id`) REFERENCES `subscriptions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ADMIN','ADMIN','admin@hotmail.com','2020-11-17','admin','$2a$10$S0Hmqd0KiP7.vYCZQQbIq.kRGlh0RTXL1NhTmxVWoaAp7s8os1mK2',NULL,1,'2020-11-17 20:28:40'),(2,'Nick','Zavlagas','zavlagas@hotmail.com','1995-04-29','zavlagas','$2a$10$Wsisn/rx9kK8.Nep/4h1I.shomqAcN3U/aPB4t5ql3lxKIj89anCu',NULL,2,'2021-01-14 17:16:35'),(3,'Peter','Parker','peter@gmail.com','2021-01-12','peter','$2a$10$S2vpo7nt5VjyospGF3qLjOzJRrwrDbTv/H1OOuX.6EuElLNHZDs9G',NULL,3,'2021-01-14 17:18:38'),(4,'nick','adawd','zavla@gotmail.com','2021-01-08','admin1','$2a$10$XSIWSgIaLGIz2OBIHIid9O0lDXU60AFvSXQ0dAGAWebTLQMJlwcda',NULL,4,'2021-01-14 17:38:13'),(5,'Nick','Parker','zavlagas@hotmail.com','2020-12-31','test','$2a$10$z5llj.mgDhSu8/WLRBPe.O1..SLI13BQOEqypqybje8sy4hJygxdi',NULL,5,'2021-01-14 17:39:31'),(6,'dawd','awdawd','zavla@gotmail.com','2021-01-06','adadwd','$2a$10$36qqcpv7SHhdeeQqYjedAOtKwSNeuH19A7/MGz0epxMvVN0H0vx5y',NULL,6,'2021-01-14 17:45:24'),(7,'Nike','Nike','nike@gmail.com','2021-01-14','nike','$2a$10$DoC8WGX5zTm.fHJ9voeEOeTjb6BnDNoMZlK5uu8VlnROWVWbeoTk.',NULL,7,'2021-01-16 14:43:41');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'fashion'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-16 19:15:37
