
CREATE DATABASE examen;
USE examen;


CREATE TABLE `almacen` (
  `id_almacen` int(11) NOT NULL,
  `nombre_almacen` varchar(50) NOT NULL,
  `direccion_almacen` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `categoria_nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `entrada` (
  `id_entrada` int(11) NOT NULL,
  `fecha_entrada` date DEFAULT NULL,
  `fk_producto` varchar(100) NOT NULL,
  `fk_almacen` int(11) NOT NULL,
  `stock_inicial` int(11) NOT NULL,
  `cantidad_entrada` int(11) NOT NULL,
  `stock_final` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL,
  `marca_nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `producto` (
  `codigo_producto` varchar(100) NOT NULL,
  `nombre_producto` varchar(100),
  `fk_categoria` int(11) NOT NULL,
  `fk_marca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `salida` (
  `id_salida` int(11) NOT NULL,
  `fecha_salida` date DEFAULT NULL,
  `fk_producto` varchar(100) NOT NULL,
  `fk_almacen` int(11) NOT NULL,
  `stock_inicial` int(11) NOT NULL,
  `cantidad_salida` int(11) NOT NULL,
  `stock_final` int(11) NOT NULL,
  `factura` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `stock` (
  `fk_almacen` int(11) NOT NULL,
  `fk_producto` varchar(100) NOT NULL,
  `stock_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tipo_usuario` (
  `id_tipo` int(11) NOT NULL,
  `nombre_t` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `tipo_usuario` (`id_tipo`, `nombre_t`) VALUES
(1, 'Administrador'),
(2, 'Inventarios'),
(3, 'Usuario');

CREATE TABLE `traslado` (
  `id_traslado` int(11) NOT NULL,
  `fecha_traslado` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `traslado_destino` (
  `id_trasladoD` int(11) NOT NULL,
  `fk_almacenDestino` int(11) NOT NULL,
  `fk_producto` varchar(100) NOT NULL,
  `fk_traslado` int(11) NOT NULL,
  `stock_inicial` int(11) NOT NULL,
  `cantidad_traslado` int(11) NOT NULL,
  `stock_final` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `traslado_origen` (
  `id_trasladoO` int(11) NOT NULL,
  `fk_almacenOrigen` int(11) NOT NULL,
  `fk_producto` varchar(100) NOT NULL,
  `fk_traslado` int(11) NOT NULL,
  `stock_inicial` int(11) NOT NULL,
  `cantidad_traslado` int(11) NOT NULL,
  `stock_final` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `usuario_u` varchar(60) NOT NULL,
  `clave_u` varchar(60) NOT NULL,
  `nombre_u` varchar(90) NOT NULL,
  `correo_u` varchar(45) NOT NULL,
  `last_sesion` datetime DEFAULT '0000-00-00 00:00:00',
  `id_tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id_almacen`);

ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

ALTER TABLE `entrada`
  ADD PRIMARY KEY (`id_entrada`),
  ADD KEY `fk_producto` (`fk_producto`),
  ADD KEY `fk_almacen` (`fk_almacen`);

ALTER TABLE `marca`
  ADD PRIMARY KEY (`id_marca`);

ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo_producto`),
  ADD KEY `fk_categoria` (`fk_categoria`),
  ADD KEY `fk_marca` (`fk_marca`);

ALTER TABLE `salida`
  ADD PRIMARY KEY (`id_salida`),
  ADD KEY `fk_producto` (`fk_producto`),
  ADD KEY `fk_almacen` (`fk_almacen`);

ALTER TABLE `stock`
  ADD KEY `fk_almacen` (`fk_almacen`),
  ADD KEY `fk_producto` (`fk_producto`);

ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipo`);

ALTER TABLE `traslado`
  ADD PRIMARY KEY (`id_traslado`);

ALTER TABLE `traslado_destino`
  ADD PRIMARY KEY (`id_trasladoD`),
  ADD KEY `fk_almacenDestino` (`fk_almacenDestino`),
  ADD KEY `fk_producto` (`fk_producto`),
  ADD KEY `fk_traslado` (`fk_traslado`);

ALTER TABLE `traslado_origen`
  ADD PRIMARY KEY (`id_trasladoO`),
  ADD KEY `fk_almacenOrigen` (`fk_almacenOrigen`),
  ADD KEY `fk_producto` (`fk_producto`),
  ADD KEY `fk_traslado` (`fk_traslado`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

ALTER TABLE `almacen`
  MODIFY `id_almacen` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `entrada`
  MODIFY `id_entrada` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `marca`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `salida`
  MODIFY `id_salida` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `tipo_usuario`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `traslado`
  MODIFY `id_traslado` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `traslado_destino`
  MODIFY `id_trasladoD` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `traslado_origen`
  MODIFY `id_trasladoO` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `entrada`
  ADD CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`codigo_producto`),
  ADD CONSTRAINT `entrada_ibfk_2` FOREIGN KEY (`fk_almacen`) REFERENCES `almacen` (`id_almacen`);

ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`fk_marca`) REFERENCES `marca` (`id_marca`);

ALTER TABLE `salida`
  ADD CONSTRAINT `salida_ibfk_1` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`codigo_producto`),
  ADD CONSTRAINT `salida_ibfk_2` FOREIGN KEY (`fk_almacen`) REFERENCES `almacen` (`id_almacen`);

ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`fk_almacen`) REFERENCES `almacen` (`id_almacen`),
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`codigo_producto`);

ALTER TABLE `traslado_destino`
  ADD CONSTRAINT `traslado_destino_ibfk_1` FOREIGN KEY (`fk_almacenDestino`) REFERENCES `almacen` (`id_almacen`),
  ADD CONSTRAINT `traslado_destino_ibfk_2` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`codigo_producto`),
  ADD CONSTRAINT `traslado_destino_ibfk_3` FOREIGN KEY (`fk_traslado`) REFERENCES `traslado` (`id_traslado`);

ALTER TABLE `traslado_origen`
  ADD CONSTRAINT `traslado_origen_ibfk_1` FOREIGN KEY (`fk_almacenOrigen`) REFERENCES `almacen` (`id_almacen`),
  ADD CONSTRAINT `traslado_origen_ibfk_2` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`codigo_producto`),
  ADD CONSTRAINT `traslado_origen_ibfk_3` FOREIGN KEY (`fk_traslado`) REFERENCES `traslado` (`id_traslado`);