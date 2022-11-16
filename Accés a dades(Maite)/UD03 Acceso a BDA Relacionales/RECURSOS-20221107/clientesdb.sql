-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Temps de generació: 12-11-2020 a les 10:38:56
-- Versió del servidor: 10.4.11-MariaDB
-- Versió de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `clientesdb`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `cliente`
--

CREATE TABLE `cliente` (
  `dni` int(8) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `apellido1` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `apellido2` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `nick` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `saldo` float(8,2) NOT NULL,
  `moroso` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Bolcament de dades per a la taula `cliente`
--

INSERT INTO `cliente` (`dni`, `nombre`, `apellido1`, `apellido2`, `nick`, `password`, `saldo`, `moroso`) VALUES
(20444666, 'Pepe', 'Garcia', 'Lopez', 'pepito', '1234', 1000.00, 1),
(20888999, 'Antonio', 'Gil', 'Lopez', 'toni', '1234', 1000.00, 1);

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
