-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2021 at 10:39 AM
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
-- Database: `db_absensi_ma_beta4_0`
--

-- --------------------------------------------------------

--
-- Table structure for table `absensi`
--

CREATE TABLE `absensi` (
  `id_absen` bigint(20) NOT NULL,
  `tgl` date NOT NULL,
  `waktu` time DEFAULT NULL,
  `keterangan` enum('Masuk','Pulang') DEFAULT NULL,
  `id` int(20) NOT NULL,
  `longlat` varchar(1024) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absensi`
--

INSERT INTO `absensi` (`id_absen`, `tgl`, `waktu`, `keterangan`, `id`, `longlat`, `created_at`, `updated_at`) VALUES
(241, '2021-07-13', '23:04:18', 'Masuk', 1, NULL, '2021-07-13 09:04:31', '2021-07-13 09:04:31'),
(242, '2021-07-15', '14:51:16', 'Masuk', 1, NULL, '2021-07-15 00:51:26', '2021-07-15 00:51:26'),
(243, '2021-07-15', '15:07:19', 'Masuk', 1, NULL, '2021-07-15 01:07:22', '2021-07-15 01:07:22'),
(244, '2021-07-15', '16:15:22', 'Masuk', 1, NULL, '2021-07-15 02:15:24', '2021-07-15 02:15:24'),
(245, '2021-07-15', '16:16:45', 'Masuk', 1, '-8.189193, 113.6740257', '2021-07-15 02:16:46', '2021-07-15 02:16:46'),
(246, '2021-07-15', '22:13:28', 'Masuk', 1, NULL, '2021-07-15 08:13:30', '2021-07-15 08:13:30'),
(247, '2021-07-15', '22:14:12', 'Masuk', 1, NULL, '2021-07-15 08:14:14', '2021-07-15 08:14:14'),
(248, '2021-07-15', '22:14:43', 'Masuk', 1, NULL, '2021-07-15 08:14:46', '2021-07-15 08:14:46'),
(249, '2021-07-16', '00:39:28', 'Masuk', 1, NULL, '2021-07-15 10:39:36', '2021-07-15 10:39:36'),
(250, '2021-07-16', '00:59:29', 'Masuk', 1, NULL, '2021-07-15 10:59:31', '2021-07-15 10:59:31'),
(252, '2021-07-16', '08:32:53', 'Masuk', 6, NULL, '2021-07-15 18:32:54', '2021-07-15 18:32:54'),
(253, '2021-07-16', '08:33:56', 'Masuk', 6, 'lokasi', '2021-07-15 18:33:58', '2021-07-15 18:33:58'),
(254, '2021-07-16', '08:35:56', 'Masuk', 6, 'lokasi', '2021-07-15 18:35:58', '2021-07-15 18:35:58'),
(255, '2021-07-16', '08:40:36', 'Masuk', 6, NULL, '2021-07-15 18:40:37', '2021-07-15 18:40:37');

-- --------------------------------------------------------

--
-- Table structure for table `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `informasi_lainnya`
--

CREATE TABLE `informasi_lainnya` (
  `id_info_lainnya` int(11) NOT NULL,
  `logo_aplikasi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jabatans`
--

CREATE TABLE `jabatans` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `jabatan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `jabatans`
--

INSERT INTO `jabatans` (`id`, `jabatan`, `created_at`, `updated_at`) VALUES
(2, 'Karyawan', NULL, NULL),
(3, 'Admin', NULL, NULL),
(5, 'Hakim2', NULL, '2021-06-10 01:14:38'),
(7, 'Hakim3', NULL, NULL),
(8, 'Hakim4', NULL, NULL),
(9, 'Hakim5', NULL, NULL),
(10, 'Hakim6', NULL, NULL),
(11, 'administrator', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jamkerja`
--

CREATE TABLE `jamkerja` (
  `id` tinyint(4) NOT NULL,
  `start` time NOT NULL,
  `finish` time NOT NULL,
  `keterangan` enum('Masuk','Pulang') NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jamkerja`
--

INSERT INTO `jamkerja` (`id`, `start`, `finish`, `keterangan`, `updated_at`) VALUES
(1, '01:00:00', '20:39:00', 'Masuk', '2021-07-15 18:07:52');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2014_10_12_200000_add_two_factor_columns_to_users_table', 1),
(4, '2019_08_19_000000_create_failed_jobs_table', 1),
(5, '2019_12_14_000001_create_personal_access_tokens_table', 1),
(6, '2021_05_24_153208_create_sessions_table', 1),
(7, '2021_05_24_153659_create_members_table', 2),
(8, '2021_05_24_171626_create_jabatans_table', 3);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `password_resets`
--

INSERT INTO `password_resets` (`email`, `token`, `created_at`) VALUES
('febriarc@gmail.com', '$2y$10$RvW0hlpaefYsDKF.MX2/FOZDnSlYxvBRYXZRJ/.IQ0xTNQT72.T/u', '2021-07-12 08:27:49');

-- --------------------------------------------------------

--
-- Table structure for table `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tokenable_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `abilities` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE `sessions` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL,
  `ip_address` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_agent` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `payload` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_activity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sessions`
--

INSERT INTO `sessions` (`id`, `user_id`, `ip_address`, `user_agent`, `payload`, `last_activity`) VALUES
('OhJdPsDJAB4TYO7dhwRtQfOirK81d2IAwzFHGT7h', 6, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36', 'YTo2OntzOjY6Il90b2tlbiI7czo0MDoid05wdW5Ea3VGek12b2RRcVBXWVg0RGY1S2doTlczeHdGeXI5b3JSViI7czo2OiJfZmxhc2giO2E6Mjp7czozOiJvbGQiO2E6MDp7fXM6MzoibmV3IjthOjA6e319czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MzM6Imh0dHA6Ly8xMjcuMC4wLjE6ODAwMC9kYXNoYm9hcmRrdSI7fXM6NTA6ImxvZ2luX3dlYl81OWJhMzZhZGRjMmIyZjk0MDE1ODBmMDE0YzdmNThlYTRlMzA5ODlkIjtpOjY7czoxNzoicGFzc3dvcmRfaGFzaF93ZWIiO3M6NjA6IiQyeSQxMCRkbnBGU0JZdHBsZVdEYmJ4eWJ2ZXZ1T2g1SUt0ZDZWa0c2UjlSbHkybVhZSWdWYzBYTWh4LiI7czoyMToicGFzc3dvcmRfaGFzaF9zYW5jdHVtIjtzOjYwOiIkMnkkMTAkZG5wRlNCWXRwbGVXRGJieHlidmV2dU9oNUlLdGQ2VmtHNlI5Umx5Mm1YWUlnVmMwWE1oeC4iO30=', 1626423903);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ttd` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jabatan` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hak_akses` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `no_telepon` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `profile_photo_path` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `ttd`, `jabatan`, `hak_akses`, `no_telepon`, `email`, `password`, `alamat`, `profile_photo_path`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'FebriPutra', 'Tanggul', 'Admin', 'Admin', '0821', 'febript@gmail.com', '$2y$10$93yZcbn5ynvT55uvpwKjgeJDgKsX6t0IbCINnkdHuOmUJ0zs/iD9i', 'Jember', 'profile-photos/U3LJZLHcbDWsXA56Pwk5ZsuSS7UPQEA3s2xQ1SQ3.jpg', '4L1OCzsfsMwHSXSsgPE36nmTQxJr8dmg1F6KJgnE0BEOCq7BOja6ce7xszgt', '2021-05-24 08:54:05', '2021-06-23 16:48:06'),
(6, 'afrizal', 'jember', 'Karyawan', 'Karyawan', '213123', 'febriarc@gmail.com', '$2y$10$dnpFSBYtpleWDbbxybvevuOh5IKtd6VkG6R9Rly2mXYIgVc0XMhx.', 'Jember', NULL, '1vX3Q7K9RC0GdkkGfPpbW3u57T8Nx3N9RcPXNV51m17DNm7jlZFMnAU6nJOg', '2021-06-09 21:30:13', '2021-06-13 02:38:38'),
(14, 'Fahrel', 'Jember', 'Karyawan', 'Karyawan', '123123213', 'naomi@gmail.com', '$2y$10$8Mhp2A.H23sQaDQbmmDKqe8XtELtIPXbHfpQiAhU9Nzy/LzjAkaVS', 'Jember', NULL, NULL, '2021-06-21 05:02:31', '2021-06-21 05:02:31');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absensi`
--
ALTER TABLE `absensi`
  ADD PRIMARY KEY (`id_absen`);

--
-- Indexes for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Indexes for table `informasi_lainnya`
--
ALTER TABLE `informasi_lainnya`
  ADD PRIMARY KEY (`id_info_lainnya`);

--
-- Indexes for table `jabatans`
--
ALTER TABLE `jabatans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jamkerja`
--
ALTER TABLE `jamkerja`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`);

--
-- Indexes for table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sessions_user_id_index` (`user_id`),
  ADD KEY `sessions_last_activity_index` (`last_activity`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absensi`
--
ALTER TABLE `absensi`
  MODIFY `id_absen` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=256;

--
-- AUTO_INCREMENT for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `informasi_lainnya`
--
ALTER TABLE `informasi_lainnya`
  MODIFY `id_info_lainnya` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jabatans`
--
ALTER TABLE `jabatans`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `jamkerja`
--
ALTER TABLE `jamkerja`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
