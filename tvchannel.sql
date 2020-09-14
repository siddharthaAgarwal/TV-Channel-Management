-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2020 at 03:48 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tvchannel`
--

-- --------------------------------------------------------

--
-- Table structure for table `channel_ad`
--

CREATE TABLE `channel_ad` (
  `id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `valid_year` varchar(100) NOT NULL,
  `duration` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `channel_ad`
--

INSERT INTO `channel_ad` (`id`, `name`, `valid_year`, `duration`) VALUES
(9, 'adv1', '2020', '90'),
(11, 'adv2', '2021', '90');

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

CREATE TABLE `program` (
  `id` int(100) NOT NULL,
  `program_name` varchar(100) NOT NULL,
  `start_time` varchar(100) NOT NULL,
  `apm` varchar(100) NOT NULL,
  `duration` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `day` varchar(100) NOT NULL,
  `hour` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `program`
--

INSERT INTO `program` (`id`, `program_name`, `start_time`, `apm`, `duration`, `category`, `day`, `hour`) VALUES
(21, 'A', '1:00', 'AM', '60', 'Show', '1', '1.0'),
(22, 'B', '2:00', 'AM', '60', 'News ', '1', '2.0'),
(25, 'D', '4:30', 'AM', '60', 'News ', '2', '4.5'),
(26, 'E', '5:00', 'AM', '60', 'News ', '2', '5.0'),
(30, 'C', '1:00', 'AM', '210', 'Movie', '2', '1.0'),
(31, 'z', '5:00', 'AM', '60', 'Show', '1', '5.0');

-- --------------------------------------------------------

--
-- Table structure for table `program_ad`
--

CREATE TABLE `program_ad` (
  `id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `program_name` varchar(100) NOT NULL,
  `duration` varchar(100) NOT NULL,
  `priority` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `program_ad`
--

INSERT INTO `program_ad` (`id`, `name`, `program_name`, `duration`, `priority`) VALUES
(9, 'adv4', 'C', '90', '1'),
(10, 'adv5', 'A', '90', '2'),
(11, 'adv5', 'C', '90', '2');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Category` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `Password`, `Category`) VALUES
(1, 'sid', '123', 'AdvtManager'),
(2, 'agarwal', '123', 'ProgramManager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `channel_ad`
--
ALTER TABLE `channel_ad`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `program`
--
ALTER TABLE `program`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `program_ad`
--
ALTER TABLE `program_ad`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `channel_ad`
--
ALTER TABLE `channel_ad`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `program`
--
ALTER TABLE `program`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `program_ad`
--
ALTER TABLE `program_ad`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
