-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2025 at 03:18 AM
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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
