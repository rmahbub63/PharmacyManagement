-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2017 at 10:20 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy_one`
--

-- --------------------------------------------------------

--
-- Table structure for table `commondata`
--

CREATE TABLE `commondata` (
  `transactionNo` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commondata`
--

INSERT INTO `commondata` (`transactionNo`) VALUES
('1012');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `genericName` varchar(100) NOT NULL,
  `companyName` varchar(100) NOT NULL,
  `catagory` varchar(20) NOT NULL,
  `packTotal` decimal(10,0) NOT NULL,
  `priceTotal` decimal(10,2) NOT NULL,
  `individualPrice` decimal(10,2) NOT NULL,
  `info` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`id`, `name`, `genericName`, `companyName`, `catagory`, `packTotal`, `priceTotal`, `individualPrice`, `info`) VALUES
(111, 'Somolax 60mg', 'Alverine Citrate', 'Incepta Pharmaceuticals Ltd.', 'Tablet', '30', '121.00', '4.00', 'Cure Abdominal Pain'),
(112, 'Suspension 125 mg', 'Cefixime', 'Edruc Ltd.', 'Syrup', '1', '160.00', '160.00', 'Cure Acne'),
(113, 'Trialon S 40 mg', 'Triamcinolone Acetonide', 'Drug International Ltd.', 'Injection', '3', '180.00', '60.00', 'Cure Allergey & Immune System'),
(114, 'Locid 250 mg', 'Aluminium Hydroxide', 'ACI Ltd.', 'Tablet', '100', '200.00', '2.00', 'Cure Peptic ulcer');

-- --------------------------------------------------------

--
-- Table structure for table `pharmacycustomer`
--

CREATE TABLE `pharmacycustomer` (
  `ID` varchar(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Gender` varchar(100) NOT NULL,
  `NID` varchar(100) NOT NULL,
  `Contact` varchar(100) NOT NULL,
  `DateOfBirth` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `RegistrationDate` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmacycustomer`
--

INSERT INTO `pharmacycustomer` (`ID`, `Name`, `Gender`, `NID`, `Contact`, `DateOfBirth`, `Address`, `Email`, `RegistrationDate`) VALUES
('1001', 'Retu', 'Female', '19951001', '01773377655', '23-09-1995', 'Dhanmondi', 'retu@gmail.com', '20-01-2010'),
('1002', 'Mousumi', 'Female', '19961002', '01797938993', '20-08-1996', 'Mohammadpur', 'mou@gmail.com', '20-02-2012'),
('1003', 'Shampa', 'Female', '19944000', '0123456788', '29-06-1996', 'Uttara', 'sham@gmail.com', '23-05-2008'),
('1004', 'Mugdho', 'Male', '3456789', '01987365432', '4-9-2000', 'Shammoli', 'mugdho@gmail.com', '20-03-2009'),
('1005', 'Mahbub', 'Male', '12345678', '01678954322', '4-05-1990', 'Sankar', 'mahbub@gmail.com', '28-03-2005');

-- --------------------------------------------------------

--
-- Table structure for table `pharmacyemployee`
--

CREATE TABLE `pharmacyemployee` (
  `ID` varchar(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `DateOfBirth` varchar(100) NOT NULL,
  `FatherName` varchar(100) NOT NULL,
  `MotherName` varchar(100) NOT NULL,
  `Department` varchar(100) NOT NULL,
  `PresentAddress` varchar(100) NOT NULL,
  `PermanentAddress` varchar(100) NOT NULL,
  `Contact` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `JoiningDate` varchar(100) NOT NULL,
  `Reference` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmacyemployee`
--

INSERT INTO `pharmacyemployee` (`ID`, `Name`, `DateOfBirth`, `FatherName`, `MotherName`, `Department`, `PresentAddress`, `PermanentAddress`, `Contact`, `Email`, `JoiningDate`, `Reference`) VALUES
('10', 'Amin', '12-3-1998', 'Md.Arif', 'Monowara', 'Salesman', 'Dhaka', 'Khulna', '01772346987', 'a@gmail.com', '12-09-2010', 'Mahbubur Rahman'),
('11', 'Arif', '4-9-1990', 'Md.Anam', 'Amena Akter', 'Account', 'Dhaka', 'Barishal', '0176543219', 'ab@gmail.com', '3-9-2015', 'Akib Khan'),
('12', 'Moni', '2-7-1993', 'Md.Abdul Hamid', 'Nasrin', 'Admin', 'Dhaka', 'Kumilla', '01567893425', 'moni@gmail.com', '1-4-2003', 'Abul Kalam'),
('13', 'Nisa', '4-08-1998', 'Md. Karim', 'Jahanara', 'Salesman', 'Dhaka', 'Noakhali', '01987345672', 'nisa@gmail.com', '3-9-2008', 'Alif'),
('14', 'Moon', '20-04-1996', 'Md.Kalam', 'Maria', 'Admin', 'Dhaka', 'Rajshahi', '01678954321', 'moon@gmail.com', '2-9-2007', 'Mimi');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionNo` varchar(15) NOT NULL,
  `date` varchar(100) NOT NULL,
  `customerName` varchar(100) NOT NULL,
  `mobileNo` varchar(15) NOT NULL,
  `serviceProvider` varchar(100) NOT NULL,
  `payableAmount` decimal(10,2) NOT NULL,
  `receiveAmount` decimal(10,2) NOT NULL,
  `returnAmount` decimal(10,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transactionNo`, `date`, `customerName`, `mobileNo`, `serviceProvider`, `payableAmount`, `receiveAmount`, `returnAmount`) VALUES
('1010', 'Sat Apr 15 09:34:02 BDT 2017', 'Shuvo', 'Dhaka', 'Moni', '40.00', '50.00', '10.00'),
('1011', 'Sat Apr 15 09:34:38 BDT 2017', 'Salman', 'Dhaka', 'Amin', '640.00', '1000.00', '360.00'),
('1012', 'Sat Apr 15 11:45:16 BDT 2017', 'Retu', '01773377655', 'Amin', '180.00', '200.00', '20.00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `status` varchar(10) NOT NULL,
  `role_no` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `status`, `role_no`) VALUES
('shajjad', '1', 'Active', 1),
('retu', '2', 'Active', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionNo`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
