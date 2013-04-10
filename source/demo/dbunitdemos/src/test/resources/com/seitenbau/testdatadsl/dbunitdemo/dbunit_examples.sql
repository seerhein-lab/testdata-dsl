-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2013 at 04:06 PM
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
-- Table structure for table `BEAUFSICHTIGT`
--

CREATE TABLE IF NOT EXISTS `BEAUFSICHTIGT` (
  `professor_id` int(11) NOT NULL,
  `pruefung_id` int(11) NOT NULL,
  PRIMARY KEY (`professor_id`,`pruefung_id`),
  KEY `pruefung_id` (`pruefung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `BEAUFSICHTIGT`
--

INSERT INTO `BEAUFSICHTIGT` (`professor_id`, `pruefung_id`) VALUES
(1, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `BESUCHT`
--

CREATE TABLE IF NOT EXISTS `BESUCHT` (
  `student_id` int(11) NOT NULL,
  `lehrveranstaltung_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`lehrveranstaltung_id`),
  KEY `lehrveranstaltung_id` (`lehrveranstaltung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `BESUCHT`
--

INSERT INTO `BESUCHT` (`student_id`, `lehrveranstaltung_id`) VALUES
(287336, 1),
(123456, 2);

-- --------------------------------------------------------

--
-- Table structure for table `ISTTUTOR`
--

CREATE TABLE IF NOT EXISTS `ISTTUTOR` (
  `student_id` int(11) NOT NULL,
  `lehrveranstaltung_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`lehrveranstaltung_id`),
  KEY `lehrveranstaltung_id` (`lehrveranstaltung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ISTTUTOR`
--

INSERT INTO `ISTTUTOR` (`student_id`, `lehrveranstaltung_id`) VALUES
(287336, 1);

-- --------------------------------------------------------

--
-- Table structure for table `LEHRVERANSTALTUNG`
--

CREATE TABLE IF NOT EXISTS `LEHRVERANSTALTUNG` (
  `id` int(11) NOT NULL,
  `professor_id` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `professor_id` (`professor_id`),
  KEY `professor_id_2` (`professor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LEHRVERANSTALTUNG`
--

INSERT INTO `LEHRVERANSTALTUNG` (`id`, `professor_id`, `name`) VALUES
(1, 2, 'Verteilte Systeme'),
(2, 2, 'Design Patterns');

-- --------------------------------------------------------

--
-- Table structure for table `PROFESSOR`
--

CREATE TABLE IF NOT EXISTS `PROFESSOR` (
  `id` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PROFESSOR`
--

INSERT INTO `PROFESSOR` (`id`, `name`) VALUES
(1, 'Jürgen Wäsch'),
(2, 'Oliver Haase');

-- --------------------------------------------------------

--
-- Table structure for table `PRUEFUNG`
--

CREATE TABLE IF NOT EXISTS `PRUEFUNG` (
  `id` int(11) NOT NULL,
  `lehrveranstaltung_id` int(11) NOT NULL,
  `typ` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lehrveranstaltung_id` (`lehrveranstaltung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PRUEFUNG`
--

INSERT INTO `PRUEFUNG` (`id`, `lehrveranstaltung_id`, `typ`) VALUES
(1, 1, 'K90'),
(2, 2, 'M30');

-- --------------------------------------------------------

--
-- Table structure for table `SCHREIBT`
--

CREATE TABLE IF NOT EXISTS `SCHREIBT` (
  `student_id` int(11) NOT NULL,
  `pruefung_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`pruefung_id`),
  KEY `pruefung_id` (`pruefung_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SCHREIBT`
--

INSERT INTO `SCHREIBT` (`student_id`, `pruefung_id`) VALUES
(287336, 1);

-- --------------------------------------------------------

--
-- Table structure for table `STUDENT`
--

CREATE TABLE IF NOT EXISTS `STUDENT` (
  `matrikelnummer` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`matrikelnummer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `STUDENT`
--

INSERT INTO `STUDENT` (`matrikelnummer`, `name`) VALUES
(123456, 'Max Mustermann'),
(287336, 'Nikolaus Moll');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `BEAUFSICHTIGT`
--
ALTER TABLE `BEAUFSICHTIGT`
  ADD CONSTRAINT `beaufsichtigt_ibfk_1` FOREIGN KEY (`professor_id`) REFERENCES `PROFESSOR` (`id`),
  ADD CONSTRAINT `beaufsichtigt_ibfk_2` FOREIGN KEY (`pruefung_id`) REFERENCES `PRUEFUNG` (`id`);

--
-- Constraints for table `BESUCHT`
--
ALTER TABLE `BESUCHT`
  ADD CONSTRAINT `besucht_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `STUDENT` (`matrikelnummer`),
  ADD CONSTRAINT `besucht_ibfk_2` FOREIGN KEY (`lehrveranstaltung_id`) REFERENCES `lehrveranstaltung` (`id`);

--
-- Constraints for table `ISTTUTOR`
--
ALTER TABLE `ISTTUTOR`
  ADD CONSTRAINT `isttutor_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `STUDENT` (`matrikelnummer`),
  ADD CONSTRAINT `isttutor_ibfk_2` FOREIGN KEY (`lehrveranstaltung_id`) REFERENCES `lehrveranstaltung` (`id`);

--
-- Constraints for table `LEHRVERANSTALTUNG`
--
ALTER TABLE `LEHRVERANSTALTUNG`
  ADD CONSTRAINT `lehrveranstaltung_ibfk_1` FOREIGN KEY (`professor_id`) REFERENCES `PROFESSOR` (`id`);

--
-- Constraints for table `SCHREIBT`
--
ALTER TABLE `SCHREIBT`
  ADD CONSTRAINT `SCHREIBT_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `STUDENT` (`matrikelnummer`),
  ADD CONSTRAINT `SCHREIBT_ibfk_2` FOREIGN KEY (`pruefung_id`) REFERENCES `PRUEFUNG` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
