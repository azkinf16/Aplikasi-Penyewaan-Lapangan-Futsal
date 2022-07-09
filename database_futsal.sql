-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Nov 2020 pada 07.53
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_futsal`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_sewa`
--

CREATE TABLE `data_sewa` (
  `tbl_id` int(4) NOT NULL,
  `tbl_kode_lapangan` varchar(6) NOT NULL,
  `tbl_tanggal` varchar(20) NOT NULL,
  `tbl_jam` varchar(15) NOT NULL,
  `tbl_durasi` varchar(10) NOT NULL,
  `tbl_nama` varchar(50) NOT NULL,
  `tbl_telepon` varchar(13) NOT NULL,
  `tbl_uang_muka` varchar(10) NOT NULL,
  `tbl_sisa_pembayaran` varchar(10) NOT NULL,
  `tbl_status_pembayaran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data_sewa`
--
ALTER TABLE `data_sewa`
  ADD PRIMARY KEY (`tbl_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `data_sewa`
--
ALTER TABLE `data_sewa`
  MODIFY `tbl_id` int(4) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
