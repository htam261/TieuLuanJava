-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 17, 2014 at 10:12 PM
-- Server version: 5.5.40-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `ChiTietHoaDon`
--

CREATE TABLE IF NOT EXISTS `ChiTietHoaDon` (
  `MaChiTietHoaDon` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `MaHoaDon` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `MaMonAn` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `NgayDat` date DEFAULT NULL,
  `SoLuong` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `DatMonAn`
--

CREATE TABLE IF NOT EXISTS `DatMonAn` (
  `MaHoaDon` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `MaMonAn` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `MaDatMonAn` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `NgayDat` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DatMonAn`
--

INSERT INTO `DatMonAn` (`MaHoaDon`, `MaMonAn`, `MaDatMonAn`, `SoLuong`, `NgayDat`) VALUES
('HD01', 'MO01', 'DA01', 5, '2014-11-24 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `HoaDon`
--

CREATE TABLE IF NOT EXISTS `HoaDon` (
  `MaHoaDon` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `TenHoaDon` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `KhachHang` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `NgayTao` datetime DEFAULT NULL,
  `DaThanhToan` bit(1) DEFAULT NULL,
  `TongGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `HoaDon`
--

INSERT INTO `HoaDon` (`MaHoaDon`, `TenHoaDon`, `KhachHang`, `NgayTao`, `DaThanhToan`, `TongGia`) VALUES
('HD01', 'Hoa don 01', 'Tam Huynh', '2014-11-24 00:00:00', b'1', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `KhachHang`
--

CREATE TABLE IF NOT EXISTS `KhachHang` (
  `MaKhachHang` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `TenKhachHang` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `DiaChi` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `SoDienThoai` varchar(12) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `LoaiMonAn`
--

CREATE TABLE IF NOT EXISTS `LoaiMonAn` (
  `MaLoai` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `TenLoai` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `VungMien` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `MoTa` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LoaiMonAn`
--

INSERT INTO `LoaiMonAn` (`MaLoai`, `TenLoai`, `VungMien`, `MoTa`) VALUES
('LO01', 'Com', 'ca nuoc', 'rat pho bien');

-- --------------------------------------------------------

--
-- Table structure for table `MonAn`
--

CREATE TABLE IF NOT EXISTS `MonAn` (
  `MaMonAn` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `TenMonAn` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `HinhAnh` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `Loai` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `MoTa` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Gia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MonAn`
--

INSERT INTO `MonAn` (`MaMonAn`, `TenMonAn`, `HinhAnh`, `Loai`, `MoTa`, `Gia`) VALUES
('MA01', 'COM', 'com.png', 'LO01', 'De an', 500000);

-- --------------------------------------------------------

--
-- Table structure for table `NhanVien`
--

CREATE TABLE IF NOT EXISTS `NhanVien` (
  `MaNhanVien` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `TenNhanVien` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `DiaChi` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `MatKhau` varchar(30) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;