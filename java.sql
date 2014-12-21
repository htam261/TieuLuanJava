-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 21, 2014 at 09:57 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `monan`
--

CREATE TABLE IF NOT EXISTS `monan` (
  `MaMonAn` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `TenMonAn` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `HinhAnh` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `Loai` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `MoTa` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Gia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monan`
--

INSERT INTO `monan` (`MaMonAn`, `TenMonAn`, `HinhAnh`, `Loai`, `MoTa`, `Gia`) VALUES
('MA01', 'Cơm chiên dương châu', '', 'LO01', 'Cơm chiên cực ngon', 40000),
('MA02', 'Cơm chiên hải sản', NULL, 'LO01', 'Cơm chiên với các loại hải sản', 50000),
('MA03', 'Cánh gà chiên', NULL, 'LO02', 'Cánh gà chiên nước mắm', 60000),
('MA04', 'Thịt heo rừng chiên giòn', NULL, 'LO02', 'Thịt heo chiên', 70000),
('MA05', 'Bạch tuột nướng', NULL, 'LO03', 'Bạch tuột nướng sa tế', 70000),
('MA06', 'Dê nướng', NULL, 'LO03', 'Vú dê nướng than', 50000),
('MA07', 'Lấu thái', NULL, 'LO04', 'Lẩu thái hải sản', 110000),
('MA08', 'Lẩu cá', NULL, 'LO04', 'Lẩu cá hồi', 100000),
('MA09', 'Sting', NULL, 'LO05', 'Nước ngọt', 10000),
('MA10', 'Tiger', NULL, 'LO05', 'Bia', 12000),
('MA11', 'Coca Cola', NULL, 'LO05', 'Nước ngọt', 8000);
