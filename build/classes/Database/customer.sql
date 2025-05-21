-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 06:06 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nico`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(20) NOT NULL,
  `cs_fname` varchar(100) NOT NULL,
  `cs_lname` varchar(100) NOT NULL,
  `cs_email` varchar(100) NOT NULL,
  `cs_contact` varchar(50) NOT NULL,
  `cs_user` varchar(100) NOT NULL,
  `cs_pass` varchar(255) NOT NULL,
  `cs_address` varchar(100) NOT NULL,
  `cs_type` varchar(20) NOT NULL,
  `cs_status` varchar(50) NOT NULL,
  `profile_picture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `cs_fname`, `cs_lname`, `cs_email`, `cs_contact`, `cs_user`, `cs_pass`, `cs_address`, `cs_type`, `cs_status`, `profile_picture`) VALUES
(1, 'Nico', 'Deiparine', 'nicodeiparine14@gmail.com', '', 'nico', '42531e41e1d87d4187f55ba5e0144039012ec2daa8a99297140a56175eccd589', 'lawaan 1', 'Admin', 'Active', ''),
(2, 'Janley', 'Deiparine', 'janleydeiparine@gmail.com', '09665214786', 'janley', '42531e41e1d87d4187f55ba5e0144039012ec2daa8a99297140a56175eccd589', 'lawaan 1', 'Manager', 'Active', 'pfpimage/default.jpg'),
(3, 'James', 'Deiparine', 'jamesdeiparine@gmail.com', '09665214786', 'james', '42531e41e1d87d4187f55ba5e0144039012ec2daa8a99297140a56175eccd589', 'lawaan 1', 'Customer', 'Active', 'pfpimage/default.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
