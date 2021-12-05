/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100418
 Source Host           : localhost:3306
 Source Schema         : inventario_electronico

 Target Server Type    : MySQL
 Target Server Version : 100418
 File Encoding         : 65001

 Date: 22/11/2021 21:03:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for almacen
-- ----------------------------
DROP TABLE IF EXISTS `almacen`;
CREATE TABLE `almacen`  (
  `id` int(11) NOT NULL,
  `descripcion` varchar(30) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `coordenanda` varchar(30) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `id_productos` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_prodc`(`id_productos`) USING BTREE,
  CONSTRAINT `fk_prodc` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = cp1250 COLLATE = cp1250_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of almacen
-- ----------------------------

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `CI` varchar(10) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `correo` varchar(30) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `telefono` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = cp1250 COLLATE = cp1250_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cliente
-- ----------------------------

-- ----------------------------
-- Table structure for entrada
-- ----------------------------
DROP TABLE IF EXISTS `entrada`;
CREATE TABLE `entrada`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(20) NOT NULL,
  `precio` float(20, 0) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_productos` int(11) NOT NULL,
  `fecha` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `proveedor` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `producto` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Fk_compo`(`id_proveedor`) USING BTREE,
  INDEX `Fk_producto`(`id_productos`) USING BTREE,
  CONSTRAINT `Fk_prodd` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = cp1250 COLLATE = cp1250_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entrada
-- ----------------------------

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(50) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `entrada_incial` int(15) NOT NULL,
  `stock` int(30) NOT NULL,
  `precio` float(30, 0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = cp1250 COLLATE = cp1250_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of productos
-- ----------------------------
INSERT INTO `productos` VALUES (4, 'resistencias', 'resistencias de 100 ohm', 10, 10, 50);
INSERT INTO `productos` VALUES (5, 'resistencias', 'resistencias de 100 ohm', 10, 10, 50);
INSERT INTO `productos` VALUES (6, 'integrados', 'integrados 779 ', 10, 10, 50);

-- ----------------------------
-- Table structure for proveedor
-- ----------------------------
DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `CI` varchar(10) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `correo` varchar(30) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `telefono` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = cp1250 COLLATE = cp1250_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of proveedor
-- ----------------------------

-- ----------------------------
-- Table structure for salida
-- ----------------------------
DROP TABLE IF EXISTS `salida`;
CREATE TABLE `salida`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(15) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `fecha` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `cliente` varchar(50) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `producto` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Fk_cliente`(`id_cliente`) USING BTREE,
  INDEX `fk_producto`(`id_producto`) USING BTREE,
  CONSTRAINT `Fk_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = cp1250 COLLATE = cp1250_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salida
-- ----------------------------

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `Usuario` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  `correo` varchar(30) CHARACTER SET cp1250 COLLATE cp1250_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = cp1250 COLLATE = cp1250_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuarios
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
