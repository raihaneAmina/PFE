-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 04 juil. 2019 à 10:19
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `admin`
--

-- --------------------------------------------------------

--
-- Structure de la table `compt`
--

DROP TABLE IF EXISTS `compt`;
CREATE TABLE IF NOT EXISTS `compt` (
  `ID` int(11) NOT NULL,
  `NomUtil` varchar(30) DEFAULT NULL,
  `MotDePasse` varchar(30) DEFAULT NULL,
  `Type` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `key` (`NomUtil`),
  KEY `ID` (`ID`),
  KEY `NomUtil` (`NomUtil`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compt`
--

INSERT INTO `compt` (`ID`, `NomUtil`, `MotDePasse`, `Type`) VALUES
(1, 'Administrateur', '1234', 'Admin'),
(2, 'Enseignat', '5678', 'Enseignant'),
(3, 'Enseignat1', '5678', 'Enseignant'),
(4, 'Enseignat2', '5678', 'Enseignant'),
(5, 'Enseignat3', '5678', 'Enseignant'),
(6, 'Enseignat4', '5678', 'Enseignant'),
(7, 'Enseignat5', '5678', 'Enseignant'),
(8, 'Enseignat6', '5678', 'Enseignant'),
(9, 'Déligué9', '159753', 'Déligué'),
(10, 'Déligué1', '159753', 'Déligué'),
(11, 'Déligué2', '159753', 'Déligué'),
(12, 'Déligué3', '159753', 'Déligué'),
(13, 'Déligué4', '159753', 'Déligué'),
(14, 'Enseignat7', '5678', 'Enseignant'),
(15, 'Enseignat8', '5678', 'Enseignant'),
(16, 'Enseignat9', '5678', 'Enseignant'),
(17, 'Enseignat10', '5678', 'Enseignant'),
(18, 'Enseignat11', '5678', 'Enseignant'),
(19, 'Enseignat20', '5678', 'Enseignant'),
(20, 'Enseignat21', '5678', 'Enseignant'),
(21, 'Déligué5', '159753', 'Déligué'),
(22, 'Déligué6', '159753', 'Déligué'),
(23, 'Déligué7', '159753', 'Déligué'),
(24, 'Déligué8', '159753', 'Déligué'),
(25, 'Déligué10', '159753', 'Déligué'),
(26, 'Déligué11', '159753', 'Déligué'),
(27, 'Déligué12', '159753', 'Déligué'),
(28, 'Déligué13', '159753', 'Déligué'),
(29, 'Déligué14', '159753', 'Déligué'),
(30, 'Déligué15', '159753', 'Déligué'),
(31, 'Déligué16', '159753', 'Déligué'),
(32, 'Déligué17', '159753', 'Déligué'),
(33, 'Déligué18', '159753', 'Déligué'),
(34, 'Déligué19', '159753', 'Déligué'),
(35, 'Déligué20', '159753', 'Déligué'),
(36, 'Déligué21', '159753', 'Déligué'),
(37, 'Déligué22', '159753', 'Déligué'),
(38, 'Déligué23', '159753', 'Déligué'),
(39, 'Déligué24', '159753', 'Déligué'),
(40, 'Déligué25', '159753', 'Déligué'),
(41, 'Déligué26', '159753', 'Déligué'),
(42, 'Déligué27', '159753', 'Déligué'),
(43, 'Déligué28', '159753', 'Déligué'),
(44, 'Déligué29', '159753', 'Déligué'),
(45, 'Déligué30', '159753', 'Déligué'),
(46, 'Déligué31', '159753', 'Déligué'),
(47, 'Déligué32', '159753', 'Déligué'),
(48, 'Déligué33', '159753', 'Déligué'),
(49, 'Déligué34', '159753', 'Déligué'),
(50, 'Déligué35', '159753', 'Déligué'),
(51, 'Déligué36', '159753', 'Déligué'),
(52, 'Déligué37', '159753', 'Déligué'),
(53, 'Déligué38', '159753', 'Déligué'),
(54, 'Déligué39', '159753', 'Déligué');

-- --------------------------------------------------------

--
-- Structure de la table `délégué`
--

DROP TABLE IF EXISTS `délégué`;
CREATE TABLE IF NOT EXISTS `délégué` (
  `Id` int(11) NOT NULL,
  `NomUti` varchar(30) NOT NULL,
  `NumF` int(11) DEFAULT NULL,
  `NomPren` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `NomUti` (`NomUti`),
  KEY `FK_niv` (`NumF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `délégué`
--

INSERT INTO `délégué` (`Id`, `NomUti`, `NumF`, `NomPren`) VALUES
(1, 'Déligué1', 1, 'Mohamed'),
(2, 'Déligué2', 2, 'Mostapha'),
(3, 'Déligué3', 3, 'Oussama'),
(4, 'Déligué4', 4, 'Amina'),
(5, 'Déligué5', 5, 'Salima'),
(6, 'Déligué6', 6, 'yasmine'),
(7, 'Déligué7', 7, 'Kamel'),
(8, 'Déligué8', 8, 'Djamel'),
(9, 'Déligué9', 9, 'Omar'),
(10, 'Déligué10', 10, 'Ali'),
(11, 'Déligué11', 11, 'Mourade'),
(12, 'Déligué12', 12, 'Siham'),
(13, 'Déligué13', 13, 'Karim'),
(14, 'Déligué14', 14, 'Madjide'),
(15, 'Déligué15', 15, 'Ahmed'),
(16, 'Déligué16', 16, 'Amine'),
(17, 'Déligué17', 17, 'Halima'),
(18, 'Déligué18', 18, 'Imene'),
(19, 'Déligué19', 19, 'Sawsen'),
(20, 'Déligué20', 20, 'Khadidja'),
(21, 'Déligué21', 21, 'Aicha'),
(22, 'Déligué22', 22, 'Nour'),
(23, 'Déligué23', 23, 'Abderrahmene'),
(24, 'Déligué24', 24, 'Habiba'),
(25, 'Déligué25', 25, 'Rokaya'),
(26, 'Déligué26', 26, 'Mohcine'),
(27, 'Déligué27', 27, 'Yacine'),
(28, 'Déligué28', 28, 'Amar'),
(29, 'Déligué29', 29, 'Ibrahime'),
(30, 'Déligué30', 30, 'Zine eddine'),
(31, 'Déligué31', 31, 'Batoul'),
(32, 'Déligué32', 32, 'Sirine'),
(33, 'Déligué33', 33, 'Fatima'),
(34, 'Déligué34', 34, 'Meriem'),
(35, 'Déligué35', 35, 'Asmaa'),
(36, 'Déligué36', 36, 'Maruoa'),
(37, 'Déligué37', 37, 'Raihane'),
(38, 'Déligué38', 38, 'Sameh'),
(39, 'Déligué39', 39, 'Ikram');

-- --------------------------------------------------------

--
-- Structure de la table `emploi`
--

DROP TABLE IF EXISTS `emploi`;
CREATE TABLE IF NOT EXISTS `emploi` (
  `JourHeur` varchar(30) NOT NULL,
  `samedi` varchar(30) DEFAULT NULL,
  `Dimanche` varchar(30) DEFAULT NULL,
  `Lundi` varchar(30) DEFAULT NULL,
  `Mardi` varchar(30) DEFAULT NULL,
  `Mercredi` varchar(30) DEFAULT NULL,
  `Jeudi` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`JourHeur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emploi`
--

INSERT INTO `emploi` (`JourHeur`, `samedi`, `Dimanche`, `Lundi`, `Mardi`, `Mercredi`, `Jeudi`) VALUES
('08.30h - 10.00h', NULL, NULL, NULL, NULL, NULL, NULL),
('10.30h - 12.00h', NULL, NULL, NULL, NULL, NULL, NULL),
('13.00h - 14.30h', NULL, NULL, NULL, NULL, NULL, NULL),
('15.00h - 16.30h', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `ensei`
--

DROP TABLE IF EXISTS `ensei`;
CREATE TABLE IF NOT EXISTS `ensei` (
  `ID` int(255) NOT NULL,
  `NomUtil` varchar(30) DEFAULT NULL,
  `NomPren` varchar(30) NOT NULL,
  `DISTANCE` varchar(30) DEFAULT NULL,
  `Age` int(255) DEFAULT NULL,
  `Ancien` varchar(30) DEFAULT NULL,
  `Maladie` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NomUtil` (`NomUtil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ensei`
--

INSERT INTO `ensei` (`ID`, `NomUtil`, `NomPren`, `DISTANCE`, `Age`, `Ancien`, `Maladie`) VALUES
(1, 'Enseignat', 'ABDEREZZAK Bilal', '20', 20, '3', 'acunne'),
(2, 'Enseignat2', 'ABTOUT Abdesslam', '39', 39, '15', 'acunne'),
(3, 'Enseignat3', 'ADDAD DJELLOUL', '39', 39, '2', 'acunne'),
(4, 'Enseignat4', 'AILAM EL-HADJ', '39', 39, '15', 'acunne'),
(5, 'Enseignat5', 'AIT ADJEDJOU DOURIA', '39', 39, '15', 'acunne'),
(6, 'Enseignat6', 'AITABDESSELEM Maya', '39', 39, '15', 'acunne'),
(7, 'Enseignat7', 'AIT-HAMADOUCHE Mohamed', '39', 39, '15', 'acunne'),
(8, 'Enseignat8', 'Ali Haimoud Chouaib -V', '105', 39, '15', NULL),
(9, 'Enseignat9', 'ALIBENYAHIA Khoudja', '105', 39, '15', NULL),
(10, 'Enseignat10', 'ALICHE Rédha', '105', 39, '15', NULL),
(11, 'Enseignat11', 'ALICHE Zahia', '105', 39, '15', NULL),
(12, 'Enseignat12', 'ANNANE NADIA', '105', 39, '15', NULL),
(13, 'Enseignat13', 'AOUARI', '105', 39, '15', NULL),
(14, 'Enseignat14', 'AOUIMER Ahmed Amine', '105', 39, '15', NULL),
(15, 'Enseignat1', 'ATBA Amina', '105', 39, '15', NULL),
(16, 'Enseignat16', 'AYACHE BELKACEM', '105', 39, '15', NULL),
(18, 'Enseignat18', 'AZZAZ Abdessamed', '105', 39, '15', NULL),
(19, 'Enseignat19', 'AZZOUZA Noureddine', '105', 39, '15', NULL),
(20, 'Enseignat20', 'BACHA Wahab', '105', 39, '15', NULL),
(21, 'Enseignat21', 'AYACHE BELKACEM', '105', 39, '15', NULL),
(22, 'Enseignat22', 'BACHENINE Hadjer', '105', 39, '15', NULL),
(24, 'Enseignat24', 'BAYOU Boualem', '105', 39, '15', NULL),
(26, 'Enseignat26', 'BELDJOUDI Hamoud', '105', 39, '15', NULL),
(27, 'Enseignat27', 'BELFERAI -V', '105', 39, '15', NULL),
(28, 'Enseignat28', 'BELLALI Mounir', '105', 39, '15', NULL),
(29, 'Enseignat29', 'BENALI AMEL', '105', 39, '15', NULL),
(30, 'Enseignat30', 'BENALI AMEL', '105', 39, '15', NULL),
(31, 'Enseignat31', 'BENALLAL MOHAMED Nadjib', '105', 39, '15', NULL),
(32, 'Enseignat32', 'BENBACHIR  Maamar', '105', 39, '15', NULL),
(33, 'Enseignat33', 'BENDALI Nadir', '105', 39, '15', NULL),
(34, 'Enseignat34', 'BENDOUHA Boualem', '105', 39, '15', NULL),
(35, 'Enseignat35', 'BENNAI Riadh', '105', 39, '15', NULL),
(36, 'Enseignat36', 'BENNICHE OMAR', '105', 39, '15', NULL),
(37, 'Enseignat37', 'BENREBAYA MOHAMED', '105', 39, '15', NULL),
(38, 'Enseignat38', 'BENSAUTRA AMEL -V', '105', 39, '15', NULL),
(39, 'Enseignat39', 'BENSDIRA Sid Ali', '105', 39, '15', NULL),
(40, 'Enseignat40', 'BENTCHIKOU Brahim', '105', 39, '15', NULL),
(41, 'Enseignat41', 'BENTRIDI SALAH EDDINE', '105', 39, '15', NULL),
(42, 'Enseignat42', 'BENYAHIA Toufik', '105', 39, '15', NULL),
(43, 'Enseignat43', 'BENYAROU Mourad', '105', 39, '15', NULL),
(44, 'Enseignat44', 'BENYEGHZER Mohammed', '105', 39, '15', NULL),
(45, 'Enseignat45', 'BENYOUCEF ABOU SOFIANE', '105', 39, '15', NULL),
(46, 'Enseignat46', 'BENZAID DJELLOUL', '105', 39, '15', NULL),
(47, 'Enseignat47', 'BERRAHOU Mohamed', '105', 39, '15', NULL),
(48, 'Enseignat48', 'Bessekri Youcef-v', '105', 39, '15', NULL),
(49, 'Enseignat49', 'BEZZIOU Mohamed', '105', 39, '15', NULL),
(50, 'Enseignat50', 'BITAM Tariq', '105', 39, '15', NULL),
(51, 'Enseignat51', 'BOT Youcef', '105', 39, '15', NULL),
(52, 'Enseignat52', 'BOUAZRI Fatima', '105', 39, '15', NULL),
(53, 'Enseignat53', 'BOUDALI FATIHA', '105', 39, '15', NULL),
(54, 'Enseignat54', 'BOUDECHICHE Noreddine', '105', 39, '15', NULL),
(55, 'Enseignat55', 'BOUDERBALA Mihoub', '105', 39, '15', NULL),
(56, 'Enseignat56', 'BOUDERGUA Samia', '105', 39, '15', NULL),
(57, 'Enseignat57', 'BOUDINA Abdallah', '105', 39, '15', NULL),
(58, 'Enseignat58', 'BOUDJEMAA FATIHA', '105', 39, '15', NULL),
(59, 'Enseignat59', 'BOUGARA Mohamed', '105', 39, '15', NULL),
(60, 'Enseignat60', 'BOUHOUIA Hayat', '105', 39, '15', NULL),
(61, 'Enseignat61', 'BOUKABCHA Hocine', '105', 39, '15', NULL),
(62, 'Enseignat62', 'BOUKADOUM OMAR', '105', 39, '15', NULL),
(63, 'Enseignat63', 'BOUKEDROUN Mohamed', '105', 39, '15', NULL),
(64, 'Enseignat64', 'Boukli hassan', '105', 39, '15', NULL),
(65, 'Enseignat65', 'BOUNIF AOUDA', '105', 39, '15', NULL),
(66, 'Enseignat66', 'BOUREGUIG Kada', '105', 39, '15', NULL),
(67, 'Enseignat67', 'BOURICHA Nahla', '105', 39, '15', NULL),
(68, 'Enseignat68', 'BOUSSAHA ABDELKADER', '105', 39, '15', NULL),
(69, 'Enseignat69', 'BOUSSAHA MEHDIA', '105', 39, '15', NULL),
(70, 'Enseignat70', 'BOUZEMLAL HAKIM', '105', 39, '15', NULL),
(71, 'Enseignat71', 'CHAOUCHI BELKACEM', '105', 39, '15', NULL),
(72, 'Enseignat72', 'CHAREF -V', '105', 39, '15', NULL),
(73, 'Enseignat73', 'CHEHAT Azeddine', '105', 39, '15', NULL),
(74, 'Enseignat74', 'CHEMMAMI AMAR', '105', 39, '15', NULL),
(75, 'Enseignat75', 'CHERIFI SOUAD', '105', 39, '15', NULL),
(76, 'Enseignat76', 'CHETTI BOUALEM', '105', 39, '15', NULL),
(77, 'Enseignat77', 'CHITA Fouzia', '105', 39, '15', NULL),
(78, 'Enseignat78', 'CHOUYA Ahmed', '105', 39, '15', NULL),
(79, 'Enseignat79', 'DAOUDI Souhila -V', '105', 39, '15', NULL),
(80, 'Enseignat80', 'DEBABI Mohammed', '105', 39, '15', NULL),
(81, 'Enseignat81', 'DIAF AHMED', '105', 39, '15', NULL),
(82, 'Enseignat82', 'Djellab Lamia -V-', '105', 39, '15', NULL),
(83, 'Enseignat83', 'DJOUAMAI Leila', '105', 39, '15', NULL),
(84, 'Enseignat84', 'DOUBA Houda', '105', 39, '15', NULL),
(85, 'Enseignat85', 'DOUICI Mohamed', '105', 39, '15', NULL),
(86, 'Enseignat86', 'ELBAA Mohamed', '105', 39, '15', NULL),
(87, 'Enseignat87', 'EZIANI AZEDDINE', '105', 39, '15', NULL),
(88, 'Enseignat88', 'FEGHOUL', '105', 39, '15', NULL),
(89, 'Enseignat89', 'FELLAH-V', '105', 39, '15', NULL),
(90, 'Enseignat90', 'FERAOUN Brahim', '105', 39, '15', NULL),
(91, 'Enseignat91', 'FERMOUS Rachid', '105', 39, '15', NULL),
(92, 'Enseignat92', 'FERNINI Brahim', '105', 39, '15', NULL),
(93, 'Enseignat93', 'FERRACHE Mustapha', '105', 39, '15', NULL),
(94, 'Enseignat94', 'FERSI Cherifa', '105', 39, '15', NULL),
(95, 'Enseignat95', 'FOUKA Mourad', '105', 39, '15', NULL),
(96, 'Enseignat96', 'HACHAMA KAMEL', '105', 39, '15', NULL),
(97, 'Enseignat97', 'HACHAMA MOHAMED', '105', 39, '15', NULL),
(98, 'Enseignat98', 'HACHICHI Hiba', '105', 39, '15', NULL),
(99, 'Enseignat99', 'HADJ BOURARGA MOUSSA -V', '105', 39, '15', NULL),
(100, 'Enseignat100', 'HADJ KHELIFA LEILA', '105', 39, '15', NULL),
(101, 'Enseignat101', 'HADJ SADOK SALAH EDDINE', '105', 39, '15', NULL),
(102, 'Enseignat102', 'HADJ SADOK SID AHMED', '105', 39, '15', NULL),
(103, 'Enseignat103', 'HAID SARAH -V', '105', 39, '15', NULL),
(104, 'Enseignat104', 'HALAIMI Fatma Zohra', '105', 39, '15', NULL),
(105, 'Enseignat105', 'HALIMI ALI', '105', 39, '15', NULL),
(106, 'Enseignat106', 'HAMAI Lamine', '105', 39, '15', NULL),
(107, 'Enseignat107', 'HAMEL -V', '105', 39, '15', NULL),
(108, 'Enseignat108', 'HAMIDI MOUSSA', '105', 39, '15', NULL),
(109, 'Enseignat109', 'HAMLIBENZAHAR HAMID', '105', 39, '15', NULL),
(110, 'Enseignat110', 'HAMMOUDI MOUNIR', '105', 39, '15', NULL),
(111, 'Enseignat111', 'HAMRAT Wahiba', '105', 39, '15', NULL),
(112, 'Enseignat112', 'HAMZAOUI Ihssen', '105', 39, '15', NULL),
(113, 'Enseignat113', 'HANICHE Faiçal', '105', 39, '15', NULL),
(114, 'Enseignat114', 'HARAOUI', '105', 39, '15', NULL),
(115, 'Enseignat115', 'HARBI Assia', '105', 39, '15', NULL),
(116, 'Enseignat116', 'HARBOUCHE Oussama', '105', 39, '15', NULL),
(117, 'Enseignat117', 'HARITZI', '105', 39, '15', NULL),
(118, 'Enseignat118', 'HARIZI Mohamed', '105', 39, '15', NULL),
(119, 'Enseignat119', 'Hassan Belkacem', '105', 39, '15', NULL),
(120, 'Enseignat120', 'HELLAL ABDELKADER', '105', 39, '15', NULL),
(121, 'Enseignat121', 'HEMIS Mohamed', '105', 39, '15', NULL),
(122, 'Enseignat122', 'HENNANE YAMINA', '105', 39, '15', NULL),
(123, 'Enseignat123', 'HIMOUR Yacine', '105', 39, '15', NULL),
(124, 'Enseignat124', 'HINDA', '105', 39, '15', NULL),
(125, 'Enseignat125', 'HOCINE ABDELFETTAH', '105', 39, '15', NULL),
(126, 'Enseignat126', 'HOUARI Keltoum', '105', 39, '15', NULL),
(127, 'Enseignat127', 'HOUAS MOHAMED', '105', 39, '15', NULL),
(128, 'Enseignat128', 'HOUASNI Mohamed', '105', 39, '15', NULL),
(129, 'Enseignat129', 'IKNI Samir', '105', 39, '15', NULL),
(130, 'Enseignat130', 'KADDECHE Mourad', '105', 39, '15', NULL),
(131, 'Enseignat131', 'KALI ABDESSELEM', '105', 39, '15', NULL),
(132, 'Enseignat132', 'KARRAS Meselem', '105', 39, '15', NULL),
(133, 'Enseignat133', 'KELLACI AHMED', '105', 39, '15', NULL),
(134, 'Enseignat134', 'KELLECHE Abdelkarim', '105', 39, '15', NULL),
(135, 'Enseignat135', 'KERFAH RABEH', '105', 39, '15', NULL),
(136, 'Enseignat136', 'KERRACI ABDELKADER', '105', 39, '15', NULL),
(137, 'Enseignat137', 'KESSAISSIA Karima', '105', 39, '15', NULL),
(138, 'Enseignat138', 'KHADRAOUI ABDELKADER', '105', 39, '15', NULL),
(139, 'Enseignat139', 'KHALFI Ali', '105', 49, '15', ''),
(140, 'Enseignat140', 'KHELIDJ BENYOUCEF', '105', 39, '15', NULL),
(141, 'Enseignat141', 'KOUIDER AKIL SOUAD', '105', 39, '15', NULL),
(142, 'Enseignat142', 'KOUIDER DJELLOUL Omar', '105', 39, '15', NULL),
(143, 'Enseignat143', 'KRELIFA ALI', '105', 39, '15', NULL),
(144, 'Enseignat144', 'LABABOU Aicha', '105', 39, '15', NULL),
(145, 'Enseignat145', 'Labbadlia Omar', '105', 39, '15', NULL),
(146, 'Enseignat146', 'LAMALI Atmane', '105', 39, '15', NULL),
(147, 'Enseignat147', 'LARBI BOUAMRANE Omar', '105', 39, '15', NULL),
(148, 'Enseignat148', 'LARIBI BOUALEM', '105', 39, '15', NULL),
(149, 'Enseignat149', 'LARIBI MOHAMED AMINE', '105', 39, '15', NULL),
(150, 'Enseignat150', 'LATROUS', '105', 39, '15', NULL),
(151, 'Enseignat151', 'LOUNIS MOURAD', '105', 39, '15', NULL),
(152, 'Enseignat152', 'MAHDAB Salim', '105', 39, '15', NULL),
(153, 'Enseignat153', 'MAHIEDDINE ALI', '105', 39, '15', NULL),
(154, 'Enseignat154', 'MAHROUG RABIAA', '105', 39, '15', NULL),
(155, 'Enseignat155', 'MALLEM', '105', 39, '15', NULL),
(156, 'Enseignat156', 'MAOUCHE Said', '105', 39, '15', NULL),
(157, 'Enseignat157', 'MATALLAH  AEK', '105', 39, '15', NULL),
(158, 'Enseignat158', 'MATALLAH  MOHAMED', '105', 39, '15', NULL),
(159, 'Enseignat15', 'MAZOUZ AMEL', '105', 39, '15', NULL),
(160, 'Enseignat160', 'MAZOUZI REDHA', '105', 39, '15', NULL),
(161, 'Enseignat161', 'MEGHATRIA Farida', '105', 39, '15', NULL),
(162, 'Enseignat162', 'MEGHATRIA RIADH', '105', 39, '15', NULL),
(163, 'Enseignat163', 'MEKHANEG Abdellah', '105', 39, '15', NULL),
(164, 'Enseignat164', 'MEKHANEG BENYOUCEF', '105', 39, '15', NULL),
(165, 'Enseignat165', 'MELAHI LEILA', '105', 39, '15', NULL),
(166, 'Enseignat166', 'MELLAL Houria', '105', 39, '15', NULL),
(167, 'Enseignat167', 'MERABTI SALEM', '105', 39, '15', NULL),
(168, 'Enseignat168', 'MERSELLEM Mohamed', '105', 39, '15', NULL),
(169, 'Enseignat169', 'MESLI Chahrazad', '105', 39, '15', NULL),
(170, 'Enseignat170', 'MEZIDI Amar', '105', 39, '15', NULL),
(171, 'Enseignat171', 'Mohamed Bouziane Ilyes', '105', 39, '15', NULL),
(172, 'Enseignat172', 'MOHAMMED BELKEBIR Saliha', '105', 39, '15', NULL),
(173, 'Enseignat173', 'MOUMEN Riadh', '105', 39, '15', NULL),
(174, 'Enseignat174', 'NEDJMAOUI -V', '105', 39, '15', NULL),
(175, 'Enseignat175', 'NOURA BELKHEIR', '105', 39, '15', NULL),
(176, 'Enseignat176', 'NOURA Hichem', '105', 39, '15', NULL),
(177, 'Enseignat177', 'NOURI N', '105', 39, '15', NULL),
(178, 'Enseignat178', 'OUADAH', '105', 39, '15', NULL),
(179, 'Enseignat179', 'OUADFEUL SID ALI', '105', 39, '15', NULL),
(180, 'Enseignat180', 'OUADHAH R', '105', 39, '15', NULL),
(181, 'Enseignat181', 'OUAMARA D', '105', 39, '15', NULL),
(182, 'Enseignat182', 'OUDADI SOUMIA -V', '105', 39, '15', NULL),
(183, 'Enseignat183', 'OUELD ARAB  HALIMA', '105', 39, '15', NULL),
(184, 'Enseignat184', 'OUERDANE ABDELLAH', '105', 39, '15', NULL),
(185, 'Enseignat185', 'RAHMANI FETHIA', '105', 39, '15', NULL),
(186, 'Enseignat186', 'REDAOUIA Keltoum', '105', 39, '15', NULL),
(187, 'Enseignat187', 'REZALA HOURIA', '105', 39, '15', NULL),
(188, 'Enseignat188', 'REZKALLAH Nadjia', '105', 39, '15', NULL),
(189, 'Enseignat189', 'SAADAOUI BOUALEM', '105', 39, '15', NULL),
(190, 'Enseignat190', 'SADOUKI BOUAMAMA Réda', '105', 39, '15', NULL),
(191, 'Enseignat191', 'SADOUKI MOUSTAPHA', '105', 39, '15', NULL),
(192, 'Enseignat192', 'SAID ABDERREZAK', '105', 39, '15', NULL),
(193, 'Enseignat193', 'SAKRI REDHA', '105', 39, '15', NULL),
(194, 'Enseignat194', 'SEBIAT LAMIA -V', '105', 39, '15', NULL),
(195, 'Enseignat195', 'SOLTANI EL MEHDI -V', '105', 39, '15', NULL),
(196, 'Enseignat196', 'TAHENNI TOUHAMI', '105', 39, '15', NULL),
(197, 'Enseignat197', 'TAHI Mohamed', '105', 39, '15', NULL),
(198, 'Enseignat198', 'TCHAMAKDJI Mounir', '105', 39, '15', NULL),
(199, 'Enseignat199', 'TEFFAHI CHRIFA', '105', 39, '15', NULL),
(200, 'Enseignat200', 'TOUAFRI LASNOUNI', '105', 39, '15', NULL),
(201, 'Enseignat201', 'TOUAIBI RABEH', '105', 39, '15', NULL),
(202, 'Enseignat202', 'YACHE Abdelkader Amine', '105', 39, '15', NULL),
(203, 'Enseignat203', 'YAGOUBI Karima', '105', 39, '15', NULL),
(204, 'Enseignat204', 'YEZLI MOHAMMED', '105', 39, '15', NULL),
(205, 'Enseignat205', 'YOUSFI Abdelkader', '105', 39, '15', NULL),
(206, 'Enseignat206', 'ZAARAOUI ABDELKADER', '105', 39, '15', NULL),
(207, 'Enseignat207', 'ZAHOUFI Noureddine', '105', 39, '15', NULL),
(208, 'Enseignat208', 'ZAOUI SANAA', '105', 39, '15', NULL),
(209, 'Enseignat209', 'ZERROUKI MOUSSA', '105', 39, '15', NULL),
(210, 'Enseignat210', 'ZIDANE IBRAHIM', '105', 39, '15', NULL),
(211, 'Enseignat211', 'ZOUANTI Mostapha', '105', 39, '15', NULL),
(212, 'Enseignat212', 'KHEBIZI WIAM', '105', 39, '15', NULL),
(213, 'Enseignat213', 'BAHLOUL Djamel', '105', 39, '15', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `filiè`
--

DROP TABLE IF EXISTS `filiè`;
CREATE TABLE IF NOT EXISTS `filiè` (
  `ID` int(11) NOT NULL,
  `Nomfil` varchar(30) DEFAULT NULL,
  `spécialité` varchar(30) DEFAULT NULL,
  `niveau` varchar(100) NOT NULL,
  `NbrEtd` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `filiè`
--

INSERT INTO `filiè` (`ID`, `Nomfil`, `spécialité`, `niveau`, `NbrEtd`) VALUES
(1, 'Science et Technologie ', 'ST', 'Licence 1', 250),
(2, 'Auto', 'ST', 'Licence 2', 250),
(3, 'GP', 'ST', 'Licence 2', 250),
(4, 'ELN', 'ST', 'Licence 2', 250),
(5, 'ELT', 'ST', 'Licence 2', 250),
(6, 'G.mec', 'ST', 'Licence 2', 250),
(7, 'G.civil', 'ST', 'Licence 2', 250),
(8, 'Auto', 'ST', 'Licence 3', 250),
(9, 'GP', 'ST', 'Licence 3', 250),
(10, 'ELN', 'ST', 'Licence 3', 250),
(11, 'ELT', 'ST', 'Licence 3', 250),
(12, 'GM/CM', 'ST', 'Licence 3', 250),
(13, 'Energétique', 'ST', 'Licence 3', 250),
(14, 'G.civil', 'ST', 'Licence 3', 250),
(15, 'AII', 'ST', 'Master 1', 250),
(16, 'Structure', 'ST', 'Master 1', 250),
(17, 'ELT industrielle', 'ST', 'Master 1', 250),
(18, 'GM/CM', 'ST', 'Master 1', 250),
(19, 'GM/Energétique', 'ST', 'Master 1', 250),
(20, 'Sys Télécom', 'ST', 'Master 1', 250),
(21, 'Génie Pharm', 'ST', 'Master 1', 250),
(22, 'GP Env', 'ST', 'Master 1', 250),
(23, 'Science de la Matière ', 'SM', 'Licence 1', 80),
(24, 'SM- C', 'SM', 'Licence 2', 80),
(25, 'Physique Générale', 'SM', 'Licence 2', 80),
(26, 'Chimie', 'SM', 'Licence 2', 80),
(27, 'Physique Fondamentale', 'SM', 'Licence 3', 80),
(28, 'Chimie', 'SM', 'Licence 3', 80),
(29, 'Chimie Pharmaceutique', 'SM', 'Master 1', 80),
(30, 'Physique Théorique', 'SM', 'Master 1', 80),
(31, 'Physique du Globe', 'SM', 'Master 1', 80),
(32, 'Physique Théorique', 'SM', 'Master 1', 80),
(33, 'Mathématique et Informatique', 'MI', 'Licence 1', 160),
(34, 'Mathématique', 'MI', 'Licence 2', 160),
(35, 'Informatique', 'MI', 'Licence 2', 160),
(36, 'Mathématique', 'MI', 'Licence 3', 160),
(37, 'Informatique', 'MI', 'Licence 3', 160),
(38, 'IL', 'MI', 'Master 1', 160),
(39, 'AMA', 'MI', 'Master 1', 160);

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `ID` int(11) NOT NULL,
  `NomModul` varchar(30) DEFAULT NULL,
  `NumEns` int(11) DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL,
  `NumF` int(11) DEFAULT NULL,
  `ordre` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ordre` (`ordre`),
  KEY `NumF` (`NumEns`),
  KEY `NumF_2` (`NumF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`ID`, `NomModul`, `NumEns`, `semestre`, `NumF`, `ordre`) VALUES
(1, 'Anglais', 52, 1, 37, 1),
(2, 'Probabilités et statistiques', 193, 1, 37, NULL),
(3, 'Systèmes 2', 19, 1, 37, NULL),
(4, 'Intelligence', 49, 1, 37, NULL),
(5, 'P. Logique', 154, 1, 37, NULL),
(6, 'Compilation', 53, 1, 37, NULL),
(7, 'IHM', 171, 1, 37, NULL),
(8, 'Progr linéaire', 63, 1, 37, NULL),
(9, 'Génie logiciel II', 62, 1, 37, NULL),
(10, 'sécurité informatique', 213, 2, 37, NULL),
(11, 'Admin BD', 171, 2, 37, NULL),
(12, 'Infographie', 154, 2, 37, NULL),
(13, 'Application Mobile', 162, 2, 37, NULL),
(14, 'Juridique', 163, 2, 37, NULL),
(15, 'Poo', 139, 1, 35, NULL),
(16, 'Théorie Langage', 116, 1, 35, NULL),
(17, 'Système information', 163, 1, 35, NULL),
(18, 'Anglais', 52, 1, 37, NULL),
(19, 'Architecture des ordinateurs ', 154, 1, 35, NULL),
(20, 'Logique Mathématique', 137, 1, 35, NULL),
(21, 'Réseau  de communication', 101, 1, 35, NULL),
(22, 'Génie Logiciel', 139, 2, 35, NULL),
(23, 'Système d\"exploitation ', 62, 2, 35, NULL),
(24, 'Base de données', 98, 2, 35, NULL),
(25, 'Anglais2', 52, 2, 35, NULL),
(26, 'Application web', 213, 2, 35, NULL),
(27, 'Juridique', 163, 2, 35, NULL),
(28, 'Algorithmique', 101, 1, 35, NULL),
(29, 'Phy2', 9, 2, 33, NULL),
(30, 'analyse2', 49, 2, 33, NULL),
(31, 'Algèbre2', 202, 2, 33, NULL),
(32, 'Probastat', 193, 2, 33, NULL),
(33, 'Tic', 207, 2, 33, NULL),
(34, 'Analys1', 49, 1, 33, NULL),
(35, 'Anglais', 52, 1, 33, NULL),
(36, 'Algèbre1', 202, 1, 33, NULL),
(37, 'Algorithme1', 113, 1, 33, NULL),
(38, 'Bureautique', 177, 1, 33, NULL),
(39, 'Terminologie', 203, 1, 33, NULL),
(40, 'Phy1', 9, 1, 33, NULL),
(41, 'str_machine', 137, 2, 33, NULL),
(42, 'algorithme2', 113, 2, 33, NULL),
(43, 'Outil', 154, 2, 33, NULL),
(44, 'economie', 207, 1, 33, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `ordre`
--

DROP TABLE IF EXISTS `ordre`;
CREATE TABLE IF NOT EXISTS `ordre` (
  `ID` int(11) NOT NULL,
  `NumF` int(11) DEFAULT NULL,
  `NumM` int(11) DEFAULT NULL,
  `ordre` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ordre` (`ordre`),
  KEY `NumF` (`NumF`),
  KEY `NumM` (`NumM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `planin`
--

DROP TABLE IF EXISTS `planin`;
CREATE TABLE IF NOT EXISTS `planin` (
  `Jour` varchar(30) DEFAULT NULL,
  `temps` varchar(30) DEFAULT NULL,
  `semaine` int(11) NOT NULL,
  `NumM` int(11) DEFAULT NULL,
  `NumSurv` int(11) DEFAULT NULL,
  `NumSurv1` int(11) DEFAULT NULL,
  `NumSurv2` int(11) DEFAULT NULL,
  `NumSurv3` int(11) DEFAULT NULL,
  KEY `NumM` (`NumM`),
  KEY `NumEns` (`NumSurv`,`NumSurv1`,`NumSurv2`,`NumSurv3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `planin`
--

INSERT INTO `planin` (`Jour`, `temps`, `semaine`, `NumM`, `NumSurv`, `NumSurv1`, `NumSurv2`, `NumSurv3`) VALUES
('Dimanche', '08.30 h -10.00h', 1, 2, 2, 2, 2, 2),
('Lundi', '11.30 h -12.00h', 1, 4, 5, 4, 34, 213),
('Samedi', '08.30 h -10.00h', 1, 1, 1, 2, 3, 5),
('Samedi', '08.30 h -10.00h', 1, 1, 1, 1, 1, 1),
('Mardi', '15.00 h -16.30h', 1, 6, 20, 6, 113, 1),
('Mardi', '11.30 h -12.00h', 1, 6, 2, 141, 6, 1),
('Mardi', '10.30 h -11.00h', 1, 6, 4, 8, 3, 7),
('Samedi', '10.30 h -12.00h', 1, 7, 4, 3, 5, 1),
('Mardi', '08.30 h -10.00h', 1, 4, 1, 6, 1, 1),
('Lundi', '13.00 h -14.30h', 1, 5, 1, 1, 1, 1),
('Lundi', '10.30 h -11.00h', 2, 3, 115, 4, NULL, NULL),
('Jeudi', '10.30 h -12.00h', 2, 16, 116, 4, NULL, NULL),
('Mercredi', '10.30 h -12.00h', 2, 3, 4, 1, NULL, NULL),
('Mercredi', '13.00 h -14.30h', 2, 3, 1, 1, NULL, NULL),
('Samedi', '08.30 h -10.00h', 2, 44, 207, 6, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL,
  `NomSalle` varchar(30) DEFAULT NULL,
  `Capacité` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `NomSalle`, `Capacité`) VALUES
(1, 'Amphi 1', 162),
(2, 'Amphi 2', 162),
(3, 'Amphi 3', 162),
(4, 'Amphi 4', 162),
(5, 'Salle 1', 162),
(6, 'Salle 1 bis', 30),
(7, 'Salle 2', 30),
(8, 'Salle 3', 30),
(9, 'Salle 4', 30),
(10, 'Salle 5', 30),
(11, 'Salle 6', 30),
(12, 'Salle 7', 105),
(13, 'Salle 9', 105),
(14, 'Salle 10', 105),
(15, 'Salle 11', 105),
(16, 'Salle 12', 105),
(17, 'Salle 13', 105),
(18, 'Salle 14', 105),
(19, 'Salle 15', 105),
(20, 'Salle 16', 105),
(21, 'Salle 17', 105),
(22, 'Salle 18', 105),
(23, 'Salle 19', 105),
(24, 'Salle 29', 105),
(25, 'Salle 30', 105),
(26, 'Salle 31', 105),
(27, 'Salle 32', 105);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `délégué`
--
ALTER TABLE `délégué`
  ADD CONSTRAINT `FK_niv` FOREIGN KEY (`NumF`) REFERENCES `filiè` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_util` FOREIGN KEY (`NomUti`) REFERENCES `compt` (`NomUtil`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `fk_ense` FOREIGN KEY (`NumEns`) REFERENCES `ensei` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_f` FOREIGN KEY (`NumF`) REFERENCES `filiè` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `ordre`
--
ALTER TABLE `ordre`
  ADD CONSTRAINT `FK_Spe` FOREIGN KEY (`NumF`) REFERENCES `filiè` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_modu` FOREIGN KEY (`NumM`) REFERENCES `module` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
