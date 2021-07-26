-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-07-2021 a las 22:39:50
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_quetzaltec`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `ID_inventario` int(11) NOT NULL,
  `Nombre_Producto` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cantidad_Producto` int(50) NOT NULL,
  `Precio_Unitario` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`ID_inventario`, `Nombre_Producto`, `Cantidad_Producto`, `Precio_Unitario`) VALUES
(1, 'Mouse Bluetooth Genius', 235, 230),
(3, 'Tarjeta Gráfica GTX 1030', 35, 4500),
(4, 'Monitor Samsung QHD30', 420, 15000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_usuario` int(50) NOT NULL,
  `NombreUsuario` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_nivel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `registrado_por` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_usuario`, `NombreUsuario`, `usuario`, `password`, `tipo_nivel`, `registrado_por`, `estado`) VALUES
(1, 'Jesus Eduardo Santoyo', 'edbanshee', 'edbanshee', 'Administrador', 'edbanshee', 'Activo'),
(2, 'Daniel Franco Díaz', 'daniel', 'daniel', 'Administrador', 'edbanshee', 'Activo'),
(3, 'Miguel Romero Santiago', 'miguel', 'miguel', 'Empleado', 'edbanshee', 'Activo'),
(4, 'Diana Gonzalez Antonio', 'diana', 'diana', 'Empleado', 'edbanshee', 'Activo'),
(5, 'Ivonne Cervantes Hernández', 'ivonne', 'ivonne', 'Empleado', 'edbanshee', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`ID_inventario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `ID_inventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID_usuario` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
