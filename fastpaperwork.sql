-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-06-2022 a las 19:51:27
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fastpaperwork`
--
CREATE DATABASE IF NOT EXISTS `fastpaperwork` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `fastpaperwork`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `idadministrador` int(11) NOT NULL,
  `RUT` varchar(45) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `inventario_idinventario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idadministrador`, `RUT`, `usuario_id`, `inventario_idinventario`) VALUES
(1212, '2233', 2121, 20),
(1213, '3434', 2122, 21),
(1214, '55532', 2123, 22),
(1215, '56643', 2124, 23),
(1216, '54334', 2125, 24),
(1217, '45321', 2126, 25),
(1218, '43421', 2127, 26),
(1219, '65341', 2128, 27),
(1220, '23221', 2129, 28);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
CREATE TABLE `calificacion` (
  `idcalificacion` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `punuacion` int(11) NOT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  `venta_idventa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `calificacion`
--

INSERT INTO `calificacion` (`idcalificacion`, `fechaHora`, `punuacion`, `cliente_idcliente`, `venta_idventa`) VALUES
(6220, '2020-03-22 11:20:30', 5, 252526, 100),
(6221, '2020-04-10 13:33:12', 4, 252527, 101),
(6222, '2021-05-02 10:00:02', 3, 252528, 102),
(6223, '2021-10-03 15:22:04', 4, 252529, 103),
(6224, '2022-01-22 16:12:23', 4, 252530, 104),
(6225, '2022-01-24 18:26:50', 5, 252531, 105),
(6226, '2022-01-28 07:05:45', 5, 252532, 106),
(6227, '2022-02-04 08:00:00', 5, 252533, 107),
(6228, '2022-02-08 09:32:33', 5, 252534, 108);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `edad`, `usuario_id`) VALUES
(252526, '18', 2121),
(252527, '19', 2122),
(252528, '22', 2123),
(252529, '30', 2124),
(252530, '42', 2125),
(252531, '25', 2126),
(252532, '28', 2127),
(252533, '43', 2128),
(252534, '24', 2129);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cotizacion`
--

DROP TABLE IF EXISTS `cotizacion`;
CREATE TABLE `cotizacion` (
  `idcotizacion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `producto_idproducto` int(11) NOT NULL,
  `administrador_idadministrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cotizacion`
--

INSERT INTO `cotizacion` (`idcotizacion`, `fecha`, `total`, `producto_idproducto`, `administrador_idadministrador`) VALUES
(981, '2022-03-28', 5000, 123, 1212),
(982, '2022-04-18', 7500, 124, 1213),
(983, '2022-04-20', 9300, 125, 1214),
(984, '2022-05-23', 12300, 126, 1215),
(985, '2022-05-08', 23700, 127, 1216),
(986, '2022-05-17', 4500, 128, 1217),
(987, '2022-06-15', 6700, 129, 1218),
(988, '2022-07-08', 2400, 130, 1219),
(989, '2022-07-10', 8200, 131, 1220);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forma_de_pago`
--

DROP TABLE IF EXISTS `forma_de_pago`;
CREATE TABLE `forma_de_pago` (
  `idforma_de_pago` int(11) NOT NULL,
  `forma_de_pago` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `forma_de_pago`
--

INSERT INTO `forma_de_pago` (`idforma_de_pago`, `forma_de_pago`) VALUES
(909, 'EFECTIVO'),
(910, 'NEQUI'),
(911, 'NEQUI'),
(912, 'EFECTIVO'),
(913, 'DAVIPLATA'),
(914, 'DAVIPLATA'),
(915, 'NEQUI'),
(916, 'NEQUI'),
(917, 'EFECTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

DROP TABLE IF EXISTS `inventario`;
CREATE TABLE `inventario` (
  `idinventario` int(11) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `entradas` int(11) NOT NULL,
  `salidas` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `producto_idproducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`idinventario`, `categoria`, `entradas`, `salidas`, `descripcion`, `producto_idproducto`) VALUES
(20, 'PAPELERIA', 20, 10, 'CUADERNO', 123),
(21, 'PAPELERIA', 32, 34, 'LAPICES', 124),
(22, 'DULCERIA', 12, 32, 'GOMAS', 125),
(23, 'PAPELERIA', 22, 54, 'ESFEROS', 126),
(24, 'DULCERIA', 16, 42, 'DULCES', 127),
(25, 'BISUTERIA', 20, 45, 'ARETES', 128),
(26, 'PAPELERIA', 40, 21, 'AGENDAS', 129),
(27, 'BISUTERIA', 32, 15, 'LAPIZ E OJOS', 130),
(28, 'BISUTERIA', 33, 16, 'LABIAL', 131);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `idlogin` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL,
  `cantidadTotal` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `descuento` double NOT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  `seguimiento_envio_idseguimiento_envio` int(11) NOT NULL,
  `forma_de_pago_idforma_de_pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idpedido`, `cantidadTotal`, `fecha`, `direccion`, `descuento`, `cliente_idcliente`, `seguimiento_envio_idseguimiento_envio`, `forma_de_pago_idforma_de_pago`) VALUES
(4445, 10, '2020-02-25', 'CARRERA 12', 0, 252526, 3435, 909),
(4446, 23, '2020-03-05', 'AVENIDA 23', 0, 252527, 3436, 910),
(4447, 15, '2020-02-21', 'CARRERA 34', 0, 252528, 3437, 911),
(4448, 34, '2020-02-15', 'AVENIDA 65', 0, 252529, 3438, 912),
(4449, 24, '2020-05-25', 'CARRERA 65', 0, 252530, 3439, 913),
(4450, 25, '2020-06-12', 'TRANSVERSAL 18', 0, 252531, 3440, 914),
(4451, 14, '2020-06-26', 'TRANSVERSAL 34', 0, 252532, 3441, 915),
(4452, 16, '2020-06-30', 'CARRERA54', 0, 252533, 3442, 916),
(4453, 27, '2020-07-15', 'AVENIDA 43', 0, 252534, 3443, 917);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_has_producto`
--

DROP TABLE IF EXISTS `pedido_has_producto`;
CREATE TABLE `pedido_has_producto` (
  `pedido_idpedido` int(11) NOT NULL,
  `producto_idproducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

DROP TABLE IF EXISTS `permisos`;
CREATE TABLE `permisos` (
  `idpermisos` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pqrs`
--

DROP TABLE IF EXISTS `pqrs`;
CREATE TABLE `pqrs` (
  `idpqrs` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `respuesta_idrespuesta` int(11) NOT NULL,
  `cliente_idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pqrs`
--

INSERT INTO `pqrs` (`idpqrs`, `tipo`, `descripcion`, `fechaHora`, `respuesta_idrespuesta`, `cliente_idcliente`) VALUES
(777, 'RECLAMO', 'Pedido incompleto', '0000-00-00 00:00:00', 76, 252526),
(778, 'SUGERENCIA', 'mejora', '0000-00-00 00:00:00', 77, 252527),
(779, 'RECLAMO', 'Demora del pedido', '0000-00-00 00:00:00', 78, 252528),
(780, 'SUGERENCIA', 'variedad productos', '0000-00-00 00:00:00', 79, 252529),
(781, 'PETICION', 'variedad', '0000-00-00 00:00:00', 80, 252530),
(782, 'RECLAMO', 'llego en mal estado el pedido', '0000-00-00 00:00:00', 81, 252531),
(783, 'SUGERENCIA', 'variedad', '0000-00-00 00:00:00', 82, 252532),
(784, 'SUGERENCIA', 'mejora de precios', '0000-00-00 00:00:00', 83, 252533),
(785, 'RECLAMO', 'demora al llegar el pedido', '0000-00-00 00:00:00', 84, 252534);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `proveedor_idproveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombre`, `categoria`, `cantidad`, `estado`, `precio`, `proveedor_idproveedor`) VALUES
(123, 'CUADERNO', 'PAPELERIA', 35, 'HABILITADO', 2500, 1),
(124, 'LAPICES', 'PAPELERIA', 20, 'HABILITADO', 800, 2),
(125, 'ESFEROS', 'PAPELERIA', 30, 'HABILITADO', 1200, 3),
(126, 'LABIAL', 'BISUTERIA', 15, 'DESABILITADO', 4000, 4),
(127, 'LAPIZ DE OJOS', 'BISUTERIA', 20, 'HABILITADO', 10000, 5),
(128, 'GOMAS', 'DULCERIA', 30, 'HABILITADO', 2000, 6),
(129, 'DULCES', 'DULCERIA', 30, 'DESABILITADO', 300, 7),
(130, 'AGENDAS', 'PAPELERIA', 20, 'DESABILITADO', 7000, 8),
(131, 'ARETES', 'BISUTERIA', 17, 'HABILITADO', 4000, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL,
  `RUT` int(11) NOT NULL,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idproveedor`, `RUT`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `telefono`) VALUES
(1, 345354, 'JOSE', 'ALVERTO', 'MORA', 'DUARTE', 7656865),
(2, 345435, 'MARIA', 'LUCIA', 'HUERTAS', 'CARO', 7656866),
(3, 3423, 'MARTIN', 'FELIPE', 'BORQUEZ', 'SANCHEZ', 7656867),
(5, 7566, 'HOLLMAN', 'STIVEN', 'AGUIRRE', 'MAECHA', 7656868),
(6, 567657, 'GISELL', 'SOFIA', 'VERGARA', 'HERRERA', 7656869),
(7, 67655, 'ANDRES', 'FELIPE', 'HERNANDEZ', 'PEREZ', 7656870),
(8, 65768, 'JULIANA', '', 'ROJAS', 'VANEGAS', 7656871),
(9, 4564, 'CAMILA', 'ANDREA', 'RODRIGUEZ', 'VERA', 7656872);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
CREATE TABLE `respuesta` (
  `idrespuesta` int(11) NOT NULL,
  `respuesta` varchar(45) NOT NULL,
  `administrador_idadministrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`idrespuesta`, `respuesta`, `administrador_idadministrador`) VALUES
(76, 'LO SOLUCIONAREMOS', 1212),
(77, 'GRACIAS POR TU OPINION', 1213),
(78, '', 1215),
(79, '', 1214),
(80, '', 1216),
(81, '', 1217),
(82, '', 1218),
(83, '', 1219),
(84, '', 1220);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `ROL` varchar(45) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_has_permisos`
--

DROP TABLE IF EXISTS `rol_has_permisos`;
CREATE TABLE `rol_has_permisos` (
  `rol_idrol` int(11) NOT NULL,
  `permisos_idpermisos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento_envio`
--

DROP TABLE IF EXISTS `seguimiento_envio`;
CREATE TABLE `seguimiento_envio` (
  `idseguimiento_envio` int(11) NOT NULL,
  `referencia_envio` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `destino` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seguimiento_envio`
--

INSERT INTO `seguimiento_envio` (`idseguimiento_envio`, `referencia_envio`, `fechaInicio`, `fechaFin`, `destino`) VALUES
(3435, 9080745, '0000-00-00', '0000-00-00', 'CALLE 32'),
(3436, 9080234, '0000-00-00', '0000-00-00', 'CALLE 76'),
(3437, 9080543, '0000-00-00', '0000-00-00', 'CARRERA 65'),
(3438, 9080865, '0000-00-00', '0000-00-00', 'AVENIDA 23'),
(3439, 9080985, '0000-00-00', '0000-00-00', 'CARRERA 87'),
(3440, 9080098, '0000-00-00', '0000-00-00', 'CALLE 44'),
(3441, 9080234, '0000-00-00', '0000-00-00', 'CARRERA 90'),
(3442, 9080754, '0000-00-00', '0000-00-00', 'AVENIDA 78'),
(3443, 9080987, '0000-00-00', '0000-00-00', 'CARRERA 89');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `primer_nombre` varchar(45) NOT NULL,
  `segundo_nombre` varchar(45) NOT NULL,
  `primer_apellidos` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) NOT NULL,
  `tipoIdentificacion` varchar(45) NOT NULL,
  `Noidentificacion` int(11) NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `login_idlogin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `primer_nombre`, `segundo_nombre`, `primer_apellidos`, `segundo_apellido`, `tipoIdentificacion`, `Noidentificacion`, `telefono`, `direccion`, `rol`, `login_idlogin`) VALUES
(2121, 'JULIO', 'CESAR', 'GUTIERREZ', 'MORFIN', 'C.C', 1001356567, 7656861, 'CARRERA 58', '', 0),
(2122, 'JOSE', 'VICENTE', 'BELTRAN', 'VILVADO', 'C.C', 1001876342, 7656862, 'CARRERA 58', '', 0),
(2123, 'HECTOR', 'FEDERICO', 'ARDILA', 'GUAJARDO', 'C.C', 1001356634, 7656863, 'CARRERA 58', '', 0),
(2124, 'JOSE', 'DE JESUS', 'NUÑES', 'YANOME', 'C.C', 1001356980, 7656864, 'CARRERA 58', '', 0),
(2125, 'MARCELA', 'ELIZABEHT', 'MARTINEZ', 'BELTRAN', 'C.C', 1001356098, 7656865, 'CARRERA 58', '', 0),
(2126, 'JESUS', 'CARLOS', 'GONZALEZ', 'DIAZ', 'C.C', 1001356123, 7656866, 'CARRERA 58', '', 0),
(2127, 'JOSE', 'AMBROSIO', 'GARCIA', 'DUARTE', 'C.C', 1001356124, 7656867, 'CARRERA 58', '', 0),
(2128, 'ROSA', 'ELENA', 'MARQUEZ', 'VERDIAZ', 'C.C', 1001356125, 7656868, 'CARRERA 58', '', 0),
(2129, 'CLAUDIA', 'VALERIA', 'LOPEZ', 'MONTERO', 'C.C', 1001356126, 7656869, 'CARRERA 58', '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `detalle` varchar(45) NOT NULL,
  `total` double NOT NULL,
  `producto_idproducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idventa`, `fecha`, `cantidad`, `detalle`, `total`, `producto_idproducto`) VALUES
(100, '0000-00-00', 12, 'PAPELERIA', 54000, 123),
(101, '0000-00-00', 3, 'DULCERIA', 2000, 124),
(102, '0000-00-00', 8, 'LAPICES', 6400, 125),
(103, '0000-00-00', 13, 'PAPELERIA', 25000, 126),
(104, '0000-00-00', 19, 'ESFEROS', 22800, 127),
(105, '0000-00-00', 20, 'CUADERNOS', 50000, 128),
(106, '0000-00-00', 6, 'ARETES', 24000, 129),
(107, '0000-00-00', 7, 'LABIAL', 28000, 130),
(108, '0000-00-00', 3, 'AGENDAS', 21000, 131);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idadministrador`),
  ADD KEY `fk_administrador_usuario1_idx` (`usuario_id`),
  ADD KEY `fk_administrador_inventario1_idx` (`inventario_idinventario`);

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`idcalificacion`),
  ADD KEY `fk_calificacion_cliente1_idx` (`cliente_idcliente`),
  ADD KEY `fk_calificacion_venta1_idx` (`venta_idventa`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD KEY `fk_cliente_usuario1_idx` (`usuario_id`);

--
-- Indices de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD PRIMARY KEY (`idcotizacion`),
  ADD KEY `fk_cotizacion_producto1_idx` (`producto_idproducto`),
  ADD KEY `fk_cotizacion_administrador1_idx` (`administrador_idadministrador`);

--
-- Indices de la tabla `forma_de_pago`
--
ALTER TABLE `forma_de_pago`
  ADD PRIMARY KEY (`idforma_de_pago`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`idinventario`),
  ADD KEY `fk_inventario_producto1_idx` (`producto_idproducto`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idlogin`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idpedido`),
  ADD KEY `fk_pedido_cliente1_idx` (`cliente_idcliente`),
  ADD KEY `fk_pedido_seguimiento_envio1_idx` (`seguimiento_envio_idseguimiento_envio`),
  ADD KEY `fk_pedido_forma_de_pago1_idx` (`forma_de_pago_idforma_de_pago`);

--
-- Indices de la tabla `pedido_has_producto`
--
ALTER TABLE `pedido_has_producto`
  ADD PRIMARY KEY (`pedido_idpedido`,`producto_idproducto`),
  ADD KEY `fk_pedido_has_producto_producto1_idx` (`producto_idproducto`),
  ADD KEY `fk_pedido_has_producto_pedido1_idx` (`pedido_idpedido`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`idpermisos`);

--
-- Indices de la tabla `pqrs`
--
ALTER TABLE `pqrs`
  ADD PRIMARY KEY (`idpqrs`),
  ADD KEY `fk_pqrs_respuesta1_idx` (`respuesta_idrespuesta`),
  ADD KEY `fk_pqrs_cliente1_idx` (`cliente_idcliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`),
  ADD KEY `fk_producto_proveedor1_idx` (`proveedor_idproveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idproveedor`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`idrespuesta`),
  ADD KEY `fk_respuesta_administrador1_idx` (`administrador_idadministrador`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`),
  ADD KEY `fk_rol_usuario1_idx` (`usuario_id`);

--
-- Indices de la tabla `rol_has_permisos`
--
ALTER TABLE `rol_has_permisos`
  ADD PRIMARY KEY (`rol_idrol`,`permisos_idpermisos`),
  ADD KEY `fk_rol_has_permisos_permisos1_idx` (`permisos_idpermisos`),
  ADD KEY `fk_rol_has_permisos_rol_idx` (`rol_idrol`);

--
-- Indices de la tabla `seguimiento_envio`
--
ALTER TABLE `seguimiento_envio`
  ADD PRIMARY KEY (`idseguimiento_envio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario_login1_idx` (`login_idlogin`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idventa`),
  ADD KEY `fk_venta_producto1_idx` (`producto_idproducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `idadministrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1221;

--
-- AUTO_INCREMENT de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  MODIFY `idcalificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6229;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=252535;

--
-- AUTO_INCREMENT de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  MODIFY `idcotizacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=990;

--
-- AUTO_INCREMENT de la tabla `forma_de_pago`
--
ALTER TABLE `forma_de_pago`
  MODIFY `idforma_de_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=918;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `idinventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `idlogin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idpedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4454;

--
-- AUTO_INCREMENT de la tabla `permisos`
--
ALTER TABLE `permisos`
  MODIFY `idpermisos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pqrs`
--
ALTER TABLE `pqrs`
  MODIFY `idpqrs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=786;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idproveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `idrespuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idrol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seguimiento_envio`
--
ALTER TABLE `seguimiento_envio`
  MODIFY `idseguimiento_envio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3444;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2130;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `fk_administrador_inventario1` FOREIGN KEY (`inventario_idinventario`) REFERENCES `inventario` (`idinventario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_administrador_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD CONSTRAINT `fk_calificacion_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_calificacion_venta1` FOREIGN KEY (`venta_idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD CONSTRAINT `fk_cotizacion_administrador1` FOREIGN KEY (`administrador_idadministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cotizacion_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_inventario_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_forma_de_pago1` FOREIGN KEY (`forma_de_pago_idforma_de_pago`) REFERENCES `forma_de_pago` (`idforma_de_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_seguimiento_envio1` FOREIGN KEY (`seguimiento_envio_idseguimiento_envio`) REFERENCES `seguimiento_envio` (`idseguimiento_envio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedido_has_producto`
--
ALTER TABLE `pedido_has_producto`
  ADD CONSTRAINT `fk_pedido_has_producto_pedido1` FOREIGN KEY (`pedido_idpedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_has_producto_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pqrs`
--
ALTER TABLE `pqrs`
  ADD CONSTRAINT `fk_pqrs_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pqrs_respuesta1` FOREIGN KEY (`respuesta_idrespuesta`) REFERENCES `respuesta` (`idrespuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_proveedor1` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `fk_respuesta_administrador1` FOREIGN KEY (`administrador_idadministrador`) REFERENCES `administrador` (`idadministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `fk_rol_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rol_has_permisos`
--
ALTER TABLE `rol_has_permisos`
  ADD CONSTRAINT `fk_rol_has_permisos_permisos1` FOREIGN KEY (`permisos_idpermisos`) REFERENCES `permisos` (`idpermisos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rol_has_permisos_rol` FOREIGN KEY (`rol_idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_login1` FOREIGN KEY (`login_idlogin`) REFERENCES `login` (`idlogin`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_venta_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
