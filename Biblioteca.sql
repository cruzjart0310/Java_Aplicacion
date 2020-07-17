--
-- Base de datos: `bibliotecanew`
--
CREATE DATABASE IF NOT EXISTS `bibliotecanew` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bibliotecanew`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `clave` int(4) NOT NULL DEFAULT '0',
  `usuario` varchar(50) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `status` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`clave`, `usuario`, `password`, `status`) VALUES
(9, 'ADMINISTRADOR', 'ADMINISTRADOR', 1),
(91111029, 'ARTURO', 'CRUZ', 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `datos`
--
CREATE TABLE `datos` (
`IdPrestamo` int(11)
,`FechaPrestamo` date
,`Nombre` varchar(50)
,`Apellidos` varchar(50)
,`Carrera` varchar(50)
,`Grado` varchar(50)
,`Grupo` varchar(50)
,`count(pr.IdPrestamo)` bigint(21)
,`totalPrestamo` int(11)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalledevolucion`
--

CREATE TABLE `detalledevolucion` (
  `IdPrestamo` int(11) DEFAULT NULL,
  `IdDevolucion` int(11) DEFAULT NULL,
  `ISBN` varchar(50) DEFAULT NULL,
  `CantidadDevuelta` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalledevolucion`
--

INSERT INTO `detalledevolucion` (`IdPrestamo`, `IdDevolucion`, `ISBN`, `CantidadDevuelta`) VALUES
(1, 1, '968-786-02', 2),
(1, 1, '970-790-4', 2),
(1, 1, '978-607-46', 2),
(1, 1, '978-968-5', 2),
(1, 2, '978-968-5', 1),
(2, 3, '968-786-02', 1);

--
-- Disparadores `detalledevolucion`
--
DELIMITER $$
CREATE TRIGGER `EliminarRegistroConCantidadCero` AFTER INSERT ON `detalledevolucion` FOR EACH ROW begin
		delete from detallePrestamo where isbn=new.isbn and CantidadPrestada=0;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleprestamo`
--

CREATE TABLE `detalleprestamo` (
  `IdPrestamo` int(11) DEFAULT NULL,
  `ISBN` varchar(50) DEFAULT NULL,
  `CantidadPrestada` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalleprestamo`
--

INSERT INTO `detalleprestamo` (`IdPrestamo`, `ISBN`, `CantidadPrestada`) VALUES
(1, '970-790-4', 0),
(1, '978-607-46', 0),
(1, '978-968-5', 0),
(2, '968-786-02', 3);

--
-- Disparadores `detalleprestamo`
--
DELIMITER $$
CREATE TRIGGER `estadistica` AFTER INSERT ON `detalleprestamo` FOR EACH ROW begin
		update ejemplar set estadistica=estadistica+1 where ISBN=new.ISBN;

		/*if(estadistica=100) then 
		update ejemplar set estadistica=0 where ISBN=new.ISBN;
		end if*/
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion`
--

CREATE TABLE `devolucion` (
  `IdDevolucion` int(11) NOT NULL DEFAULT '0',
  `Fecha` date DEFAULT NULL,
  `IdUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `devolucion`
--

INSERT INTO `devolucion` (`IdDevolucion`, `Fecha`, `IdUsuario`) VALUES
(1, '2015-07-13', 4778),
(2, '2015-07-13', 4778),
(3, '2015-07-16', 91111029);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `ISBN` varchar(50) NOT NULL DEFAULT '',
  `Clasificacion` varchar(50) DEFAULT NULL,
  `Titulo` varchar(50) DEFAULT NULL,
  `Autor` varchar(50) DEFAULT NULL,
  `Editorial` varchar(50) DEFAULT NULL,
  `CantidadInventario` int(11) DEFAULT NULL,
  `CantidadExistente` int(11) DEFAULT NULL,
  `Estadistica` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`ISBN`, `Clasificacion`, `Titulo`, `Autor`, `Editorial`, `CantidadInventario`, `CantidadExistente`, `Estadistica`) VALUES
('968-786-02', 'C6', 'Enciclopedia', 'Chris Woordford', 'Animacion Geografica', 10, 7, 2),
('970-790-4', 'D-6', 'Más que humano', 'Theodore Sturgeon', 'Planeta mexicana 2007', 10, 10, 1),
('978-607-46', 'C-6', 'Desafio ecológico', 'Hernan Cañales', 'Cronos 2007', 10, 10, 1),
('978-968-5', 'C-4', 'Enciclopedia: Nuevas Tecnológias', 'Chris Woodford', 'Coordillera de los andes 2007', 10, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `IdPrestamo` int(11) NOT NULL DEFAULT '0',
  `FechaPrestamo` date DEFAULT NULL,
  `IdUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`IdPrestamo`, `FechaPrestamo`, `IdUsuario`) VALUES
(1, '2015-07-13', 4778),
(2, '2015-07-16', 91111029);

--
-- Disparadores `prestamo`
--
DELIMITER $$
CREATE TRIGGER `NumPrestamos` AFTER INSERT ON `prestamo` FOR EACH ROW begin

		update usuario set NumPrestamo=NumPrestamo+1 where idusuario=new.idusuario;

		/*if(estadistica=100) then 
		update ejemplar set estadistica=0 where ISBN=new.ISBN;
		end if*/
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL DEFAULT '0',
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL,
  `Grado` varchar(50) DEFAULT NULL,
  `Grupo` varchar(50) DEFAULT NULL,
  `TipoUsuario` varchar(50) DEFAULT NULL,
  `NumPrestamo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Nombre`, `Apellidos`, `Carrera`, `Grado`, `Grupo`, `TipoUsuario`, `NumPrestamo`) VALUES
(4778, 'Maria Luisa', 'Gomez Prats', 'Lic en Desarrollo Turistico', '3', 'B', 'Alummno', '1'),
(585456, 'Dennys', 'Olvera Sanz', NULL, NULL, NULL, 'Catedratico', '0'),
(678454, 'Roberto Oliver', 'Acuña Salgado', NULL, NULL, NULL, 'Catedratico', '0'),
(895644, 'Luisa', 'Dominguez', '', NULL, NULL, 'Catedratico', '0'),
(900001, 'Roidely', 'Dominguez', '', NULL, NULL, 'Catedratico', '0'),
(978562, 'Mariana', 'Ruiz Cruz', 'TSU en Turismo', '1', 'A', 'Alummno', '0'),
(9124556, 'Carolina ', 'Mendez Sanchez', 'TSU en Agronomia', '3', 'A', 'Alummno', '0'),
(9458762, 'David', 'Tavarez Luna', 'Ing en Biotecnologia', '3', 'C', 'Alummno', '0'),
(75512365, 'Alejandro', 'Bolom Palé', NULL, NULL, NULL, 'Catedratico', '0'),
(91111025, 'Juan Manuel', 'Acuña', 'TSU en TIC', '2', 'B', 'Alummno', '0'),
(91111029, 'José Arturo', 'De La Cruz Sanchez', 'Ing en TI', '10', 'A', 'Alummno', '1'),
(91111064, 'JUAN PABLO', 'GONZALEZ ARIAS', 'Ing en TI', '11', 'Único', 'Alummno', '0'),
(91111364, 'Ximena', 'Salas Riu', 'TSU en Agronomia', '3', 'B', 'Alummno', '0'),
(91111369, 'Mariana de la Luz', 'Salinas Cruz', 'TSU en TIC', '2', 'A', 'Alummno', '0'),
(91111456, 'Monica ', 'Del Solar Luna', 'Ing en Biotecnologia', '3', 'A', 'Alummno', '0'),
(91111568, 'Marlene de Jesús', 'Cantoral Santivañez', 'TSU en Turismo', '10', 'A', 'Alummno', '0'),
(708090100, 'Ruben', 'Perez Winkler', NULL, NULL, NULL, 'Catedratico', '0');

-- --------------------------------------------------------

--
-- Estructura para la vista `datos`
--
DROP TABLE IF EXISTS `datos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `datos`  AS  select `pr`.`IdPrestamo` AS `IdPrestamo`,`pr`.`FechaPrestamo` AS `FechaPrestamo`,`us`.`Nombre` AS `Nombre`,`us`.`Apellidos` AS `Apellidos`,`us`.`Carrera` AS `Carrera`,`us`.`Grado` AS `Grado`,`us`.`Grupo` AS `Grupo`,count(`pr`.`IdPrestamo`) AS `count(pr.IdPrestamo)`,`dp`.`CantidadPrestada` AS `totalPrestamo` from ((`prestamo` `pr` join `detalleprestamo` `dp` on((`dp`.`IdPrestamo` = `pr`.`IdPrestamo`))) join `usuario` `us` on((`us`.`idUsuario` = `pr`.`IdUsuario`))) where ((`dp`.`CantidadPrestada` > 0) and (`us`.`Nombre` = 'Jose Arturo')) group by `us`.`idUsuario` order by `pr`.`IdPrestamo` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`clave`);

--
-- Indices de la tabla `detalledevolucion`
--
ALTER TABLE `detalledevolucion`
  ADD KEY `fk_DetalleDevolucion_Prestamo` (`IdPrestamo`),
  ADD KEY `fk_DetalleDevolucion_Devolucion` (`IdDevolucion`),
  ADD KEY `fk_DetalleDevolucion_Ejemplar` (`ISBN`);

--
-- Indices de la tabla `detalleprestamo`
--
ALTER TABLE `detalleprestamo`
  ADD KEY `fk_DetallePrestamo_Prestamo` (`IdPrestamo`),
  ADD KEY `fk_DetallePrestamo_Ejemplar` (`ISBN`);

--
-- Indices de la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD PRIMARY KEY (`IdDevolucion`),
  ADD KEY `fk_Devolucion_Usuario1` (`IdUsuario`);

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`IdPrestamo`),
  ADD KEY `fk_Prestamo_Usuario` (`IdUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalledevolucion`
--
ALTER TABLE `detalledevolucion`
  ADD CONSTRAINT `fk_DetalleDevolucion_Devolucion` FOREIGN KEY (`IdDevolucion`) REFERENCES `devolucion` (`IdDevolucion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetalleDevolucion_Ejemplar` FOREIGN KEY (`ISBN`) REFERENCES `ejemplar` (`ISBN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetalleDevolucion_Prestamo` FOREIGN KEY (`IdPrestamo`) REFERENCES `prestamo` (`IdPrestamo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalleprestamo`
--
ALTER TABLE `detalleprestamo`
  ADD CONSTRAINT `fk_DetallePrestamo_Ejemplar` FOREIGN KEY (`ISBN`) REFERENCES `ejemplar` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_DetallePrestamo_Prestamo` FOREIGN KEY (`IdPrestamo`) REFERENCES `prestamo` (`IdPrestamo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD CONSTRAINT `fk_Devolucion_Usuario1` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `fk_Prestamo_Usuario` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
--


from django.db import models
from datetime import datetime

'''Model Usuario'''
class Usuario(models.Model):
    clave = models.CharField(max_length=10)
    usuario = models.CharField(max_length=100)
    nombre = models.CharField(max_length=100)
    apellido_paaterno = models.CharField(max_length=100)
    apellido_materno = models.CharField(max_length=100)
    password = models.CharField(max_length=255)
    email = models.CharField(max_length=100)
    status = models.BooleanField(default=False)
    rol = models.CharField(max_length=3)

class Profile(models.Model):
    domicilio = models.CharField(200)
    carrera = models.CharField(max_length=200)
    grado = models.CharField(max_length=1)
    grupo = models.CharField(max_length=1)
    avatar = models.CharField(max_length=200)
    usuario = models.OneToOneField(
        Usuario,
        on_delete=models.CASCADE,
        related_name='Usuario'
    )


'''Model ejemplar'''
class Ejemplar(models.Model):
    isbn = models.CharField(max_length=50)
    clasificacion = models.CharField(max_length=2)
    titulo = models.CharField(max_length=200)
    autor = models.CharField(max_length=100)
    editorial = models.CharField(max_length=100)
    cantidad_inventario = models.IntegerField()
    cantidad_existente = models.IntegerField()
    estadistica = models.IntegerField()

'''Model Prestamo'''
class Prestamo(models.Model):
    prestamo_id = models.CharField(max_length=10)
    ejemplar_id = models.CharField(max_length=50)
    usuario_id = models.IntegerField()
    cantidad_prestamo = models.IntegerField()
    fecha_prestamo = models.DateField(default=datetime.now)
    ejemplar = models.ManyToManyField(
        Ejemplar,
        related_name="Prestamo"
    )
    usuario = models.ManyToManyField(
        Usuario,
        related_name= 'Prestamo'
    )

class Devolucion(models.Model):
    devolucion_id = models.CharField(max_length=10)
    prestamo_id = models.IntegerField()
    ejemplar_id = models.IntegerField()
    usuario_id = models.IntegerField()
    cantidad_devuelta = models.IntegerField()
    fecha_devolucion = models.DateField(default=datetime.now)
    prestamo = models.ManyToManyField(
        Ejemplar,
        related_name="Devolucion"
    )
    ejemplar = models.ManyToManyField(
        Ejemplar,
        related_name="Devolucion"
    )
    usuario = models.ManyToManyField(
        Usuario,
        related_name= 'Devolucion'
    )



