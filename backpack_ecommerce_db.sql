-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-01-2025 a las 04:38:29
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `backpack_ecommerce_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
  `id` varchar(36) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`id`, `description`, `name`) VALUES
('171503f8-d472-412c-ba79-e545fc019b02', 'Mochillas para la escuela', 'SCHOOL'),
('4563eb53-8a93-4c2d-9415-27c6a010fda1', 'Mochillas para viajar', 'TRAVEL'),
('6e8d7398-bb18-458d-9ded-86bd6d4ad587', 'Mochillas para el trabajo', 'WORK'),
('918bafdf-8cb4-4812-b195-3af53c835aff', 'Mochillas deportivas', 'SPORT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `confirmation_tokens`
--

CREATE TABLE `confirmation_tokens` (
  `id` varchar(36) NOT NULL,
  `confirmed_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `expires_at` datetime NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `confirmation_tokens`
--

INSERT INTO `confirmation_tokens` (`id`, `confirmed_at`, `created_at`, `expires_at`, `token`, `user_id`) VALUES
('0638757d-7852-417f-8bc6-c89baefd3a45', NULL, '2023-05-29 20:05:51', '2023-05-29 20:20:51', 'f19258f2-b01f-4a0c-b3e8-179c6ee253b5', '9be7bc46-9e59-47e9-99a3-525c16f34ab5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `id` varchar(36) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order_items`
--

CREATE TABLE `order_items` (
  `id` varchar(36) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `order_id` varchar(36) DEFAULT NULL,
  `product_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` varchar(36) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(70) NOT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `category_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `active`, `description`, `image_url`, `name`, `price`, `stock`, `category_id`) VALUES
('03ed7748-f65e-496c-972f-7977c59868cf', b'1', 'Mochila totto 2 en uno grande - victoria design', 'https://www.victoriadesignsbolivia.com/wp-content/uploads/2020/02/PRINCIPAL-11.jpg', 'Victoria Design', 210.5, 10, '171503f8-d472-412c-ba79-e545fc019b02'),
('1aab9d7c-1780-4db4-9451-da4c64f2ffbd', b'1', 'Mochilla para trabajo color rojo para hombre', 'https://image.png', 'Mochilla Husky', 306.85, 39, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('239f57da-a4af-4c98-9d85-e0555a8de0f5', b'1', 'Mochila totto 2 en uno grande - victoria design', 'https://www.victoriadesignsbolivia.com/wp-content/uploads/2020/02/PRINCIPAL-11.jpg', 'Victoria Design', -210.5, -10, '171503f8-d472-412c-ba79-e545fc019b02'),
('27fbb0df-f013-4225-8554-ddb78dd993c3', b'1', ' descripciÃ³n of product x', 'https://image.png', 'product x', 31, 10, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('299639fe-7be8-42a9-8092-0a69012c792c', b'1', 'Description del producto C', 'https://image.png', 'Product C', 59.99, 130, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('332fe756-d85b-49ea-ba17-84eae38fe8f5', b'1', 'Description del producto B', 'https://image.png', 'Product B', 59.99, 130, '918bafdf-8cb4-4812-b195-3af53c835aff'),
('337623cc-8f8b-4f06-b26c-d23858d8b893', b'1', 'Description del producto M', 'https://image10.gif', 'Product M', 30.5, 200, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('3e828c11-b889-461c-8667-6a823e34c7d6', b'1', 'Description de la mochila roja', 'https://imageAO.png', 'Mochila Roja', 629.54, 50, '4563eb53-8a93-4c2d-9415-27c6a010fda1'),
('3ff3d8ee-b6fa-11ed-afa1-0242ac120002', b'1', 'el mejor producto a la venta', 'https://image.png', 'Producto estrella1', 30, 10, '171503f8-d472-412c-ba79-e545fc019b02'),
('40d472ae-b6fb-11ed-afa1-0242ac120002', b'1', 'Para documentos ', 'https://image.png', 'Mochila de Viaje PequeÃ±a', 50, 130, '4563eb53-8a93-4c2d-9415-27c6a010fda1'),
('457c4976-b6fb-11ed-afa1-0242ac120002', b'1', 'Camping excurcion', 'https://image.png', 'Mochila de Viaje Mediana', 120, 130, '4563eb53-8a93-4c2d-9415-27c6a010fda1'),
('4624b2b6-7dea-4bc0-b925-f420c37fac66', b'1', 'Mochillas para el trabajo Pabbardh', 'https://image.png', 'Pabbardh', 200, 10, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('54166753-02fe-4634-ad38-f6259dc95a6b', b'1', 'Description del producto HM', 'https://image_hm.png', 'Product HM', 108.1, 50, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('66227292-7293-41c9-b352-af865ef63c5e', b'1', 'Lleva tus cosas con multiples compartimientos', 'https://image.png', 'Mochila Estampado Acuarela', 309, 80, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('77014923-97b0-45e9-9e22-1e3baf9ac07d', b'1', 'MOCHILA ESCOLAR MEDIANA', 'https://image.png', 'MOCHILA ESCOLAR', 108, 100, '171503f8-d472-412c-ba79-e545fc019b02'),
('856ecaf1-f904-4c18-8958-068ee5f16465', b'1', ' descripciÃ³n of product z', 'https://image.png', 'product z', 350.2, 30, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('880123bc-b6fa-11ed-afa1-0242ac120002', b'1', 'producto de no mucha afluencia', 'https://image.png', 'Producto perro', 10, 200, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('989d4f07-c4c2-4006-ab9d-7f83ecc948d3', b'1', 'Mochillas deportiva Ruokowad', 'https://image.png', 'Ruokowad', 150, 20, '918bafdf-8cb4-4812-b195-3af53c835aff'),
('99c6628b-1225-4756-94cf-ab3c385ef275', b'1', 'Mochila en color plomo', 'https://media.gq.com.mx/photos/5ee930538f739bf973bc80f0/master/w_1600%2Cc_limit/Adidas%2520Prime%2520V%2520Backpack.jpg', 'Product D001', 160, 25, '918bafdf-8cb4-4812-b195-3af53c835aff'),
('9fba0948-b6f9-11ed-afa1-0242ac120002', b'1', 'Mochila tipo morral para niÃ±os', 'https://bo.totto.com/mochila-mediano-estampado-acuarela-n17/p?idsku=12140', 'Decker', 120.99, 54, '171503f8-d472-412c-ba79-e545fc019b02'),
('a0448696-54ac-4d15-b954-ba73c6d86755', b'1', 'Description del producto A', 'https://image.png', 'Product A', 59.99, 130, '4563eb53-8a93-4c2d-9415-27c6a010fda1'),
('afb3aacf-7693-43ff-bf00-95b0c3995cf6', b'0', 'Description del producto A', 'https://image11.png', 'Product P', 70, 50, '918bafdf-8cb4-4812-b195-3af53c835aff'),
('b29206cd-1725-4e1d-bcc9-b280edc2dfe3', b'1', 'Mochila totto 2 en uno grande - victoria design', 'https://www.victoriadesignsbolivia.com/wp-content/uploads/2020/02/PRINCIPAL-11.jpg', 'Victoria Design', -210.5, -10, '171503f8-d472-412c-ba79-e545fc019b02'),
('b4a08973-ee58-445e-9fb1-b0aa342b0bb6', b'1', 'MOCHILA DE VIAJE', 'https://image.png', 'MOCHILA VIAJERA', 135.5, 25, '4563eb53-8a93-4c2d-9415-27c6a010fda1'),
('be8fbd85-2393-43a5-ab8a-03d4340c4006', b'1', 'Description de la mochila azul', 'https://imageA_O_2.png', 'Mochila Azul', 456.21, 65, '6e8d7398-bb18-458d-9ded-86bd6d4ad587'),
('d31d1222-b46d-4bad-aa7e-3d70ed0ee708', b'0', 'Description del producto HN', 'https://image_hn.png', 'Product HN', 40.95, 5, '918bafdf-8cb4-4812-b195-3af53c835aff'),
('d8c68ae6-eb85-4e00-a808-599748b58d1f', b'1', 'Mochila que lleva tus personajes favoritos', 'https://image.png', 'Mochila Michey S', 389, 50, '171503f8-d472-412c-ba79-e545fc019b02'),
('dda3dceb-bf5b-416b-abfe-fa7fb2ac5195', b'1', 'Mochila de mano', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDHuUj-vbkMUsGNS-m-5J9gDAIz9RQ5QgrUcI8B1yRF0enK2VxRZINIdBLoUqaCVA1l14&usqp=CAU', 'Product Mano D101', 125, 50, '918bafdf-8cb4-4812-b195-3af53c835aff'),
('f2b2f44a-b361-48b1-b86e-65fddf792e30', b'1', 'Mochilla para niÃ±o totto', 'https://image.png', 'Mochilla Totto', 236.99, 20, '171503f8-d472-412c-ba79-e545fc019b02'),
('f5a1eb7e-00d0-4273-bad8-26428c573d83', b'1', 'Descripción de producto', 'https://www.victoriadesignsbolivia.com/wp-content/uploads/2020/02/PRINCIPAL-11.jpg', 'Nombre Modificado', 560, 5, '171503f8-d472-412c-ba79-e545fc019b02'),
('f919345d-e686-416a-94a3-42954675bba2', b'1', 'Mochila totto 2 en uno grande - victoria design', 'https://www.victoriadesignsbolivia.com/wp-content/uploads/2020/02/PRINCIPAL-11.jpg', 'Victoria Design', -210.5, -10, '171503f8-d472-412c-ba79-e545fc019b02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` varchar(36) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `description`, `name`) VALUES
('94dcfd3f-2367-4ab4-bd81-4b6764513dc5', 'Role admin', 'ADMIN'),
('a1b6d042-1be4-4907-9814-daf110a473f9', 'Role user', 'USER'),
('f434e242-2f84-406d-a224-eaa62b08e340', 'Role seller', 'SELLER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` varchar(36) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `address`, `email`, `enable`, `first_name`, `last_name`, `password`, `role_id`) VALUES
('019f1459-2ba9-4e50-8790-b77f2dbe3edb', 'La Paz', 'admin@gmail.com', b'1', 'Juan', 'Perez', '$2a$10$Wbf68broDf6d3vukl46b5.bjPuoppqsOpWPdgdNxRurwGI/0Jac5K', '94dcfd3f-2367-4ab4-bd81-4b6764513dc5'),
('7af849f2-efb4-4424-aaca-5547ac9181b6', 'La Paz', 'admin@gmail.com', NULL, 'Juan', 'Perez', '12345678', '94dcfd3f-2367-4ab4-bd81-4b6764513dc5'),
('7c083cd5-3919-4c23-a136-fac659b23c96', 'El Alto', 'user@gmail.com', b'1', 'Ana', 'Perez', '$2a$10$QTm97JVJjRcW0cOwSHHJnOIaMPV3KzGvgZE8KIh4YvN82mSNcWgOO', 'a1b6d042-1be4-4907-9814-daf110a473f9'),
('9be7bc46-9e59-47e9-99a3-525c16f34ab5', 'La Paz', 'prueba@gmail.com', b'0', 'Juan', 'Perez', '$2a$10$vJyQuUvzYPLHzBtMS8SgxO9GDFrYESXV8wWd3C6NKvII10yKk1Oba', 'a1b6d042-1be4-4907-9814-daf110a473f9'),
('a3f4dc10-e3df-4715-84aa-16bfaad7926f', 'El Alto', 'user@gmail.com', NULL, 'Ana', 'Perez', '12345678', 'a1b6d042-1be4-4907-9814-daf110a473f9');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `confirmation_tokens`
--
ALTER TABLE `confirmation_tokens`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhpuw37a1pqxfb6ya1nv5lm4ga` (`user_id`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`);

--
-- Indices de la tabla `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbioxgbv59vetrxe0ejfubep1w` (`order_id`),
  ADD KEY `FKocimc7dtr037rh4ls4l95nlfi` (`product_id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `confirmation_tokens`
--
ALTER TABLE `confirmation_tokens`
  ADD CONSTRAINT `FKhpuw37a1pqxfb6ya1nv5lm4ga` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `FKocimc7dtr037rh4ls4l95nlfi` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Filtros para la tabla `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
