-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2016 at 04:50 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `crime_man_sys`
--

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE IF NOT EXISTS `info` (
  `id` varchar(5) NOT NULL,
  `fname` varchar(10) NOT NULL,
  `lname` varchar(10) NOT NULL,
  `crime` varchar(35) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `state` varchar(20) NOT NULL,
  `city` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`id`, `fname`, `lname`, `crime`, `dob`, `state`, `city`) VALUES
('101', 'Raj', 'Kapoor', 'Murder', '27/10/1981', 'Punjab', 'Amritsar'),
('205', 'Anthony', 'Gonsalves', 'Robbery', '06/02/1987', 'Maharashtra', 'Goa'),
('117', 'Mahesh', 'Kumar', 'Too Much Eating', 'Unknown', 'U P', 'Lucknow');

-- --------------------------------------------------------

--
-- Table structure for table `reg`
--

CREATE TABLE IF NOT EXISTS `reg` (
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `mob` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reg`
--

INSERT INTO `reg` (`username`, `password`, `email`, `mob`) VALUES
('waqar', '123', 'waqar@email.com', '91919191'),
('temp', '333', 'temp@email.com', '123456'),
('testing', '111', 'test', '12345'),
('User1', '222', 'user1@aghs.cn', '546888');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
