-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2021 at 06:09 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users`
--

-- --------------------------------------------------------

--
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`id`, `name`, `email`, `password`) VALUES
(1, 'baba', 'baba@gmail.com', '$2y$10$Wr6BIBqTuVnHXbMzVZsdrO5Lnad3PcoC84JWO2UQ8q8853U7TAh0K'),
(2, 'bagus', 'bagus@gmail.com', '$2y$10$PHFZ4lRs7P2TbFRTlEIJw.m3WlBsxEvWRgZlw3hhFUZSZ9t/BRj8W'),
(3, 'bagus', 'gugu@gmail.com', '$2y$10$nbw/NbUcyJyFXxx0d0AbveISTXzw9VkkFgZvpAGgJLllaqhCnGBD.'),
(4, 'aldi', 'laldi@gmail.com', '$2y$10$mLyvRO1KKjqI4.506cFfZeJr2Ffky0thLFZSDBhcSkUrEIOFnarhe'),
(5, 'cok', 'cok@gmail.com', '$2y$10$JsE/D1PDbAK7XBDkWKBSF.P6hC3h2xxRsHt5phklH4Chj5.iZAUQC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
