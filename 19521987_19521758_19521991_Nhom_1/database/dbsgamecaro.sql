-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2021 at 02:14 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbsgamecaro`
--

-- --------------------------------------------------------

--
-- Table structure for table `loaixephang`
--

CREATE TABLE `loaixephang` (
  `idxephang` int(15) NOT NULL,
  `tenxephang` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `diemtu` int(15) NOT NULL,
  `diemcongthang` int(15) DEFAULT NULL,
  `diemtruthua` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `loaixephang`
--

INSERT INTO `loaixephang` (`idxephang`, `tenxephang`, `diemtu`, `diemcongthang`, `diemtruthua`) VALUES
(1, 'Cao Thủ', 1000, 1, 60),
(2, 'Kim Cương', 800, 2, 50),
(3, 'Bạch Kim', 500, 5, 20),
(4, 'Vàng', 300, 10, 10),
(5, 'Bạc', 100, 10, 5),
(6, 'Đồng', 50, 15, 1),
(7, 'Chưa Có', 0, 20, 0);

-- --------------------------------------------------------

--
-- Table structure for table `nguoichoi`
--

CREATE TABLE `nguoichoi` (
  `tendangnhap` varchar(15) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `matkhau` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenhienthi` varchar(30) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idxephang` int(15) NOT NULL,
  `diemxephang` int(15) DEFAULT NULL,
  `solanthang` int(15) DEFAULT NULL,
  `solanthua` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `nguoichoi`
--

INSERT INTO `nguoichoi` (`tendangnhap`, `matkhau`, `tenhienthi`, `idxephang`, `diemxephang`, `solanthang`, `solanthua`) VALUES
('123123', '123456789aA@', '123123aa', 5, 125, 12, 1),
('1234toilatoi', '123456aA@', 'Toi', 7, 45, 19, 35),
('123caicangcua', '123456789aA@', 'Vjpro123', 5, 70, 14, 7),
('ailatoi', '123456789aA@', 'Lê Hoa', 6, 59, 12, 23),
('chaovao', '123456789aA@', 'Thu Minh', 2, 809, 126, 166),
('chayhetdcko', '123456789aA@', 'Thúy Kiều', 2, 890, 469, 134),
('chipchip', '123456789aA@', 'Hùng', 2, 804, 100, 6),
('conbaovang', '123456789aA@', 'Nguyễn Ánh', 3, 456, 1523, 456),
('conbeovang', '123456789aA@', 'Kim Hoàng Ngân', 6, 10, 1, 0),
('conbongvang', '123456789aA@', 'Trương Hòa Thu', 7, 12, 125, 89),
('conbovang', '123456789aA@', 'Long', 7, 124, 51, 135),
('conmeohoangvang', '123456789aA@', 'Kim Long', 7, 0, 186, 300),
('conongvang', '123456789aA@', 'Hy', 7, 0, 1728, 3986),
('conruanho', '123456789aA@', 'Qhuy', 3, 764, 432, 122),
('conruato', '123456789aaA@', 'Quy', 7, 0, 0, 0),
('contrauvang', '123456789aA@', 'Huỳnh Thiên My', 7, 0, 1262, 12626),
('convang', '123456789aA@', 'Hoàng Khánh', 5, 44, 125, 54),
('convitvang', '123456789aA@', 'Nguyễn Diệp Anh', 6, 10, 1, 0),
('cryingoveru', '123456789aA@', 'Hảo Nguyễn', 5, 50, 30, 12),
('davidphan', '123456789aA@', 'Trong', 2, 890, 99, 10),
('dechungtudo', '123456789aA@', 'Kim Trọng', 6, 25, 251, 189),
('dehoatantro', '123456789aA@', 'Hoàng Liên', 4, 125, 621, 421),
('giauhetdcko', '123456789aA@', 'Nguyệt Nga', 4, 345, 45, 0),
('hoang001', 'Phap100%hc3', 'Hoàng Đế', 5, 60, 97, 20),
('hoang2001', 'Phap100%hc2', 'Hoàng', 2, 852, 410, 142),
('hoangmy', '123456789aA@', 'Thắng Minh', 5, 36, 36, 10),
('hoangvana', '123456789aA@', 'Hoang A', 6, 34, 5, 10),
('khongbiet26', 'Phap100%hc1', 'Vô Địch', 1, 1005, 774, 132),
('khoquakho55', 'TuanPhat2001@', 'Đần Văn Độn', 6, 60, 3, 0),
('kimminh', '123456789aA@', 'Minh', 4, 499, 95, 59),
('kimmy', '123456789aA@', 'Thùy Dương', 5, 40, 15, 5),
('kimthien', '123456789aA@', 'Dương Tấn Hòa', 2, 975, 440, 102),
('lethienmy', '123456789aA@', 'Thiện Mỹ', 2, 988, 752, 300),
('levanc', '123456789aA@', 'Van C', 7, 0, 0, 0),
('linh2001', 'Linh100%hc', 'Thùy Linh', 4, 353, 322, 122),
('meocon', '123456789aA@', 'Ảo Kinh', 7, 0, 0, 0),
('moonlight', '123456789aA@', 'Nguyễn Liêm', 7, 0, 0, 0),
('phenchua', '123456789aA@', 'Hoàng', 2, 978, 878, 450),
('phenchuangot', '123456789aA@', 'Duong', 6, 20, 19, 12),
('phienlo', '123456789aA@', 'Tâm', 7, 0, 10, 100),
('ruabaohuy', '123456789aA@', 'Phat1', 6, 89, 5, 1),
('ruabaohuy1', '123456789aA@', 'Phat2', 7, 20, 1, 4),
('thienkim', '123456789aA@', 'Hà Thủy Dương', 7, 0, 0, 0),
('thotho', '123456789aA@', 'Kim Cương', 7, 0, 0, 0),
('toilaai', '123456789aA@', 'Lê Tuấn', 6, 16, 16, 15),
('toilaai2', '123456789aA@', 'Trương Hoàng Hoa', 4, 253, 15, 0),
('toilatoi', '123456789aA@', 'Công Chánh', 3, 562, 1523, 1320),
('troimay', '123456789aA@', 'Tâm Như', 7, 0, 0, 0),
('tungvannui', '123456789aA@', 'Tùng', 2, 825, 79, 42),
('vanvu', '123456789aA@', 'Vu', 3, 50, 30, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `loaixephang`
--
ALTER TABLE `loaixephang`
  ADD PRIMARY KEY (`idxephang`);

--
-- Indexes for table `nguoichoi`
--
ALTER TABLE `nguoichoi`
  ADD PRIMARY KEY (`tendangnhap`),
  ADD KEY `fk_htk_idxephang` (`idxephang`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `nguoichoi`
--
ALTER TABLE `nguoichoi`
  ADD CONSTRAINT `fk_htk_idxephang` FOREIGN KEY (`idxephang`) REFERENCES `loaixephang` (`idxephang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
