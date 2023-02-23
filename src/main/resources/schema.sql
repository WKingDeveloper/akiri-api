CREATE TABLE IF NOT EXISTS `Product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `version` bigint(20) DEFAULT NULL,
    `platform` varchar(32) NOT NULL,
    `url` varchar(2048) NOT NULL,
    `brand` varchar(32) NOT NULL,
    `title` varchar(128) NOT NULL,
    `imageUrl` varchar(2048) NOT NULL,
    `category` varchar(32) NOT NULL,
    `originCategory` varchar(32) NOT NULL,
    `currencyCode` varchar(8) NOT NULL,
    `retailPrice` decimal(19,2) NOT NULL,
    `salePrice` decimal(19,2) NOT NULL,
    `discountRate` int(4) NOT NULL,
    `status` varchar(16) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_Product_createdAt` (`createdAt`),
    KEY `idx_Product_category` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

