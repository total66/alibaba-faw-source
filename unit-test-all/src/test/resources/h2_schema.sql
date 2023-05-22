DROP TABLE IF EXISTS `user`;
create table `user`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户标识',
    `gmt_create` DATETIME NOT NULL COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
    `name` VARCHAR(50) NOT NULL COMMENT '用户名称',
    `description` TEXT NULL COMMENT '用户描述'
);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_no VARCHAR(50) not null,
    member_id BIGINT(8),
    supplier_id BIGINT(8),
    product_id BIGINT(8),
    product_count BIGINT(8),
    product_amount_total DECIMAL(8, 2),
    order_amount_total DECIMAL(8, 2),
    address VARCHAR(256),
    create_time DATETIME
);