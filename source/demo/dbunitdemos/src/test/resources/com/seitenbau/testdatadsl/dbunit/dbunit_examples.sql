-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2013 at 02:38 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbunit_examples`
--

-- --------------------------------------------------------

--
-- Table structure for table `beaufsichtigt`
--

CREATE TABLE IF NOT EXISTS `beaufsichtigt` (
  `professor_id` int(11) NOT NULL,
  `pruefung_id` int(11) NOT NULL,
  PRIMARY KEY (`professor_id`,`pruefung_id`),
  KEY `pruefung_id` (`pruefung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `besucht`
--

CREATE TABLE IF NOT EXISTS `besucht` (
  `student_id` int(11) NOT NULL,
  `lehrveranstaltung_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`lehrveranstaltung_id`),
  KEY `lehrveranstaltung_id` (`lehrveranstaltung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `isttutor`
--

CREATE TABLE IF NOT EXISTS `isttutor` (
  `student_id` int(11) NOT NULL,
  `lehrveranstaltung_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`lehrveranstaltung_id`),
  KEY `lehrveranstaltung_id` (`lehrveranstaltung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `lehrveranstaltung`
--

CREATE TABLE IF NOT EXISTS `lehrveranstaltung` (
  `id` int(11) NOT NULL,
  `professor_id` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  `sws` int(11) NOT NULL,
  `ects` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `professor_id` (`professor_id`),
  KEY `professor_id_2` (`professor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE IF NOT EXISTS `professor` (
  `id` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  `vorname` varchar(80) NOT NULL,
  `titel` varchar(80) NOT NULL,
  `fakultaet` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `pruefung`
--

CREATE TABLE IF NOT EXISTS `pruefung` (
  `id` int(11) NOT NULL,
  `lehrveranstaltung_id` int(11) NOT NULL,
  `typ` varchar(20) NOT NULL,
  `zeitpunkt` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lehrveranstaltung_id` (`lehrveranstaltung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `schreibt`
--

CREATE TABLE IF NOT EXISTS `schreibt` (
  `student_id` int(11) NOT NULL,
  `pruefung_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`pruefung_id`),
  KEY `pruefung_id` (`pruefung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `matrikelnummer` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  `vorname` varchar(80) NOT NULL,
  `studiengang` varchar(80) NOT NULL,
  `semester` int(80) NOT NULL,
  `immatrikuliert_seit` date NOT NULL,
  PRIMARY KEY (`matrikelnummer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `beaufsichtigt`
--
ALTER TABLE `beaufsichtigt`
  ADD CONSTRAINT `beaufsichtigt_ibfk_1` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`),
  ADD CONSTRAINT `beaufsichtigt_ibfk_2` FOREIGN KEY (`pruefung_id`) REFERENCES `pruefung` (`id`);

--
-- Constraints for table `besucht`
--
ALTER TABLE `besucht`
  ADD CONSTRAINT `besucht_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`matrikelnummer`),
  ADD CONSTRAINT `besucht_ibfk_2` FOREIGN KEY (`lehrveranstaltung_id`) REFERENCES `lehrveranstaltung` (`id`);

--
-- Constraints for table `isttutor`
--
ALTER TABLE `isttutor`
  ADD CONSTRAINT `isttutor_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`matrikelnummer`),
  ADD CONSTRAINT `isttutor_ibfk_2` FOREIGN KEY (`lehrveranstaltung_id`) REFERENCES `lehrveranstaltung` (`id`);

--
-- Constraints for table `lehrveranstaltung`
--
ALTER TABLE `lehrveranstaltung`
  ADD CONSTRAINT `lehrveranstaltung_ibfk_1` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`);

--
-- Constraints for table `schreibt`
--
ALTER TABLE `schreibt`
  ADD CONSTRAINT `SCHREIBT_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`matrikelnummer`),
  ADD CONSTRAINT `SCHREIBT_ibfk_2` FOREIGN KEY (`pruefung_id`) REFERENCES `pruefung` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
