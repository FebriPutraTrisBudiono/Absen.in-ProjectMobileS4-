-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2021 at 11:03 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `absensi`
--

CREATE TABLE `absensi` (
  `id_absen` int(11) NOT NULL,
  `tgl` date DEFAULT NULL,
  `waktu` time DEFAULT NULL,
  `keterangan` varchar(100) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `longlat` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absensi`
--

INSERT INTO `absensi` (`id_absen`, `tgl`, `waktu`, `keterangan`, `id_user`, `longlat`) VALUES
(27, '2021-07-10', '22:24:15', '', 0, '37.421998333333335, -122.08400000000002'),
(28, '2021-07-10', '22:24:25', '', 0, ''),
(29, '2021-07-10', '22:24:42', '', 0, '37.421998333333335, -122.08400000000002'),
(30, '2021-07-10', '22:27:28', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(31, '2021-07-11', '11:26:57', 'Masuk', 0, ''),
(32, '2021-07-11', '11:27:33', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(33, '2021-07-11', '12:26:51', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(34, '2021-07-11', '16:02:06', 'Masuk', 0, ''),
(35, '2021-07-11', '16:02:31', 'Masuk', 0, ''),
(36, '2021-07-11', '16:03:31', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(37, '2021-07-11', '16:03:56', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(38, '2021-07-11', '16:04:20', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(39, '2021-07-11', '19:54:07', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(40, '2021-07-11', '20:00:25', 'Masuk', 0, ''),
(41, '2021-07-11', '20:00:41', 'Masuk', 0, '37.421998333333335, -122.08400000000002'),
(42, '2021-07-12', '11:14:01', 'Masuk', 0, '37.421998333333335, -122.08400000000002');

-- --------------------------------------------------------

--
-- Table structure for table `data_siswa`
--

CREATE TABLE `data_siswa` (
  `id_mahasiswa` int(11) NOT NULL,
  `nama_mahasiswa` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(30) NOT NULL,
  `kelas` varchar(1) NOT NULL,
  `no_handphone` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_siswa`
--

INSERT INTO `data_siswa` (`id_mahasiswa`, `nama_mahasiswa`, `jenis_kelamin`, `kelas`, `no_handphone`) VALUES
(6, 'sada', 'sadsa', 'w', '2131'),
(7, 'sdaa', 'sdad', 's', '54353'),
(9, 'sada', 'sadasd', 'a', '8888'),
(10, 'gfhgfh', 'dsfs', 'f', '54646');

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
(1, 'baba2', 'baba@gmail.com', '$2y$10$Wr6BIBqTuVnHXbMzVZsdrO5Lnad3PcoC84JWO2UQ8q8853U7TAh0K'),
(2, 'bagus', 'bagus@gmail.com', '$2y$10$PHFZ4lRs7P2TbFRTlEIJw.m3WlBsxEvWRgZlw3hhFUZSZ9t/BRj8W'),
(3, 'bagus', 'gugu@gmail.com', '$2y$10$nbw/NbUcyJyFXxx0d0AbveISTXzw9VkkFgZvpAGgJLllaqhCnGBD.'),
(4, 'aldi', 'laldi@gmail.com', '$2y$10$mLyvRO1KKjqI4.506cFfZeJr2Ffky0thLFZSDBhcSkUrEIOFnarhe'),
(5, 'cok', 'cok@gmail.com', '$2y$10$JsE/D1PDbAK7XBDkWKBSF.P6hC3h2xxRsHt5phklH4Chj5.iZAUQC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absensi`
--
ALTER TABLE `absensi`
  ADD PRIMARY KEY (`id_absen`);

--
-- Indexes for table `data_siswa`
--
ALTER TABLE `data_siswa`
  ADD PRIMARY KEY (`id_mahasiswa`);

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absensi`
--
ALTER TABLE `absensi`
  MODIFY `id_absen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `data_siswa`
--
ALTER TABLE `data_siswa`
  MODIFY `id_mahasiswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
