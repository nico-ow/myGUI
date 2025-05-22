-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2025 at 03:16 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

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
-- Table structure for table `area_tbl`
--

CREATE TABLE `area_tbl` (
  `a_id` int(11) NOT NULL,
  `a_name` varchar(250) NOT NULL,
  `a_rate` float NOT NULL,
  `a_location` varchar(250) NOT NULL,
  `a_status` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `area_tbl`
--

INSERT INTO `area_tbl` (`a_id`, `a_name`, `a_rate`, `a_location`, `a_status`) VALUES
(1, 'A1', 100, 'Under Ground', 'Available'),
(2, 'A2', 100, 'Under Ground', 'Available');

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
(3, 'James', 'Deiparine', 'jamesdeiparine@gmail.com', '09665214786', 'james', '42531e41e1d87d4187f55ba5e0144039012ec2daa8a99297140a56175eccd589', 'lawaan 1', 'Customer', 'Active', 'pfpimage/default.jpg'),
(4, 'Angel', 'Deiparine', 'angel@gmail.com', '09665214786', 'angel', '09665214786', 'lawaan 1', 'Customer', 'Pending', 'pfpimage/default.jpg'),
(5, 'Mike', 'Bustamante', 'mike@gmail.com', '09665214786', 'mike', '09665214786', 'minglanilla', 'Customer', 'Active', 'pfpimage/default.jpg'),
(7, 'Jose', 'Rizal', 'jose@gmail.com', '09665214786', 'jose', '09665214786', 'lawaan 1', 'Customer', 'Pending', 'pfpimage/default.jpg'),
(8, 'Juan', 'Dela Cruz', 'juan@gmail.com', '09665214786', 'juan', '09665214786', 'lawaan 1', 'Manager', 'Pending', 'pfpimage/default.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `actions` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `id`, `actions`, `date`) VALUES
(1, 1, 'Log in!', '2025-05-21'),
(2, 2, 'Log in!', '2025-05-21'),
(3, 2, 'Log in!', '2025-05-21'),
(4, 2, 'Log in!', '2025-05-21'),
(5, 2, 'Log in!', '2025-05-21'),
(6, 2, 'Log in!', '2025-05-21'),
(7, 1, 'Log in!', '2025-05-21'),
(8, 3, 'Log in!', '2025-05-21'),
(9, 3, 'Log in!', '2025-05-21'),
(10, 1, 'Log in!', '2025-05-21'),
(11, 3, 'Log in!', '2025-05-21'),
(12, 3, 'Log in!', '2025-05-21'),
(13, 3, 'Log in!', '2025-05-21'),
(14, 1, 'Log in!', '2025-05-21'),
(15, 2, 'Log in!', '2025-05-21'),
(16, 3, 'Log in!', '2025-05-21'),
(17, 3, 'Log in!', '2025-05-21'),
(18, 3, 'Log in!', '2025-05-21'),
(19, 2, 'Log in!', '2025-05-21'),
(20, 1, 'Log in!', '2025-05-21'),
(21, 1, 'Created New User Account! ID: 4', '2025-05-21'),
(22, 1, 'Updated account Information!', '2025-05-21'),
(23, 1, 'Created New User Account! ID: 5', '2025-05-21'),
(24, 1, 'Created New User Account! ID: 6', '2025-05-21'),
(25, 1, 'Updated account Information!', '2025-05-21'),
(26, 2, 'Log in!', '2025-05-21'),
(27, 2, 'Log in!', '2025-05-21'),
(28, 2, 'Log in!', '2025-05-21'),
(29, 1, 'Log in!', '2025-05-21'),
(30, 1, 'Created New User Account! ID: 7', '2025-05-21'),
(31, 1, 'Created New User Account! ID: 8', '2025-05-21'),
(32, 1, 'Log in!', '2025-05-21'),
(33, 2, 'Log in!', '2025-05-21'),
(34, 3, 'Log in!', '2025-05-21'),
(35, 2, 'Log in!', '2025-05-21'),
(36, 2, 'Log in!', '2025-05-21'),
(37, 2, 'Log in!', '2025-05-21'),
(38, 2, 'Log in!', '2025-05-21'),
(39, 2, 'Added New Area! ID: 1', '2025-05-21'),
(40, 3, 'Log in!', '2025-05-21'),
(41, 2, 'Log in!', '2025-05-21'),
(42, 2, 'Log in!', '2025-05-21'),
(43, 2, 'Log in!', '2025-05-21'),
(44, 2, 'Added New Area! ID: 2', '2025-05-21'),
(45, 1, 'Log in!', '2025-05-22'),
(46, 2, 'Log in!', '2025-05-22'),
(47, 3, 'Log in!', '2025-05-22');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_tbl`
--

CREATE TABLE `transaction_tbl` (
  `t_id` int(11) NOT NULL,
  `a_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `t_hour` int(11) NOT NULL,
  `t_due` int(11) NOT NULL,
  `t_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area_tbl`
--
ALTER TABLE `area_tbl`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `transaction_tbl`
--
ALTER TABLE `transaction_tbl`
  ADD PRIMARY KEY (`t_id`),
  ADD KEY `a_id` (`a_id`),
  ADD KEY `c_id` (`c_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area_tbl`
--
ALTER TABLE `area_tbl`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `transaction_tbl`
--
ALTER TABLE `transaction_tbl`
  ADD CONSTRAINT `transaction_tbl_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `area_tbl` (`a_id`),
  ADD CONSTRAINT `transaction_tbl_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
