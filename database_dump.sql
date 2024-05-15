-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: db_mordomo
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

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
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comanda`
--

DROP TABLE IF EXISTS `tb_comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_comanda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comanda_esta_aberta` bit(1) DEFAULT NULL,
  `nome_da_comanda` varchar(255) DEFAULT NULL,
  `valor_total_comanda` bigint DEFAULT NULL,
  `garcom_id` bigint DEFAULT NULL,
  `mesa_da_comanda_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3r1ilx4b0hjkxsuf3wv8y29vs` (`garcom_id`),
  UNIQUE KEY `UK_ohnm1ufl125v96ckq5qpf672h` (`mesa_da_comanda_id`),
  CONSTRAINT `FK9ee3v5nqogrno2o2mip11i4ug` FOREIGN KEY (`garcom_id`) REFERENCES `tb_garcom` (`id`),
  CONSTRAINT `FKbsx5nq0bmr29v0tkyo129hv18` FOREIGN KEY (`mesa_da_comanda_id`) REFERENCES `tb_mesa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comanda`
--

LOCK TABLES `tb_comanda` WRITE;
/*!40000 ALTER TABLE `tb_comanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comanda_item_comanda`
--

DROP TABLE IF EXISTS `tb_comanda_item_comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_comanda_item_comanda` (
  `comanda_id` bigint NOT NULL,
  `item_comanda_id` bigint NOT NULL,
  PRIMARY KEY (`comanda_id`,`item_comanda_id`),
  UNIQUE KEY `UK_laen5du3athu6pncpms61t423` (`item_comanda_id`),
  CONSTRAINT `FK1qqroodidm7visjv3h27hyaqs` FOREIGN KEY (`comanda_id`) REFERENCES `tb_comanda` (`id`),
  CONSTRAINT `FK6dridpdne8ahy44edb9wj0x26` FOREIGN KEY (`item_comanda_id`) REFERENCES `tb_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comanda_item_comanda`
--

LOCK TABLES `tb_comanda_item_comanda` WRITE;
/*!40000 ALTER TABLE `tb_comanda_item_comanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comanda_item_comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_garcom`
--

DROP TABLE IF EXISTS `tb_garcom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_garcom` (
  `salario_mensal` double DEFAULT NULL,
  `horas_trabalhadas_mes` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK91iyecirjyrr4pvkimnhkhhq7` FOREIGN KEY (`id`) REFERENCES `tb_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_garcom`
--

LOCK TABLES `tb_garcom` WRITE;
/*!40000 ALTER TABLE `tb_garcom` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_garcom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_gorjeta`
--

DROP TABLE IF EXISTS `tb_gorjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_gorjeta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comissao_garcom` double DEFAULT NULL,
  `foi_paga` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_gorjeta`
--

LOCK TABLES `tb_gorjeta` WRITE;
/*!40000 ALTER TABLE `tb_gorjeta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_gorjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_gorjeta_de_garçons`
--

DROP TABLE IF EXISTS `tb_gorjeta_de_garçons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_gorjeta_de_garçons` (
  `gorjeta_id` bigint NOT NULL,
  `garcom_id` bigint NOT NULL,
  KEY `FK66g688s3gwxmutsvyyubom4ge` (`garcom_id`),
  KEY `FKmsgttjq71t71mm36nc6ls9scx` (`gorjeta_id`),
  CONSTRAINT `FK66g688s3gwxmutsvyyubom4ge` FOREIGN KEY (`garcom_id`) REFERENCES `tb_gorjeta` (`id`),
  CONSTRAINT `FKmsgttjq71t71mm36nc6ls9scx` FOREIGN KEY (`gorjeta_id`) REFERENCES `tb_garcom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_gorjeta_de_garçons`
--

LOCK TABLES `tb_gorjeta_de_garçons` WRITE;
/*!40000 ALTER TABLE `tb_gorjeta_de_garçons` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_gorjeta_de_garçons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_item`
--

DROP TABLE IF EXISTS `tb_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `esta_disponivel` bit(1) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preço_item` double DEFAULT NULL,
  `quantidades` int DEFAULT NULL,
  `item_de_cardapio_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5fe1p3qi0cv4546tfdd1c4ghw` (`item_de_cardapio_id`),
  CONSTRAINT `FK5fe1p3qi0cv4546tfdd1c4ghw` FOREIGN KEY (`item_de_cardapio_id`) REFERENCES `tb_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_item`
--

LOCK TABLES `tb_item` WRITE;
/*!40000 ALTER TABLE `tb_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_menu` (
  `id` bigint NOT NULL,
  `nome_de_cardapio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu_seq`
--

DROP TABLE IF EXISTS `tb_menu_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_menu_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu_seq`
--

LOCK TABLES `tb_menu_seq` WRITE;
/*!40000 ALTER TABLE `tb_menu_seq` DISABLE KEYS */;
INSERT INTO `tb_menu_seq` VALUES (1);
/*!40000 ALTER TABLE `tb_menu_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mesa`
--

DROP TABLE IF EXISTS `tb_mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_mesa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `inicio_ocupacao` datetime(6) DEFAULT NULL,
  `numero_ocupantes` varbinary(255) DEFAULT NULL,
  `status_de_mesa` enum('LIVRE','OCUPADA','RESERVADA','OCUPAR','RESERVAR','MESA_LIVRE') DEFAULT NULL,
  `termino_ocupacao` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mesa`
--

LOCK TABLES `tb_mesa` WRITE;
/*!40000 ALTER TABLE `tb_mesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` decimal(38,2) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_plh3sd5xqp709wamcutkiq85m` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,16439248774.00,'Joao Carneiro Da Silva','admin123','SeuJoao'),(2,16439248774.00,'Rita Da Silva Pontes','09072004','Ritinha021'),(3,16439248774.00,'Pedro Henrique Pontes Santos','35828889','Pedro2000');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 23:32:53
