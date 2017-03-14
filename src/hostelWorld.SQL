use hostelworld;

# 顾客表
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` char(7) PRIMARY KEY ,
  `password` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) ,
  `telephone` CHAR(11) ,
  `address` VARCHAR(255) ,
  `avatar` BLOB ,
  `card_id` char(19) NOT NULL ,
  `is_blocked` BOOLEAN ,
  `blocked_day` DATE ,
  `credits` INT NOT NULL ,
  `vip_grade` INT NOT NULL
);
INSERT INTO customer VALUES ("0000001","123","张三","18795850197","南京市南京大学",NULL,"1234567890123456789",FALSE,NULL,1,1);

# 经理表
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` CHAR(7) PRIMARY KEY ,
  `password` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL
);
INSERT INTO manager VALUES ("0000001", "123", "老李");

# 客栈表
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` CHAR(7) PRIMARY KEY ,
  `password` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `is_approved` BOOLEAN NOT NULL ,
  `address` VARCHAR(255) NOT NULL ,
  `telephone` VARCHAR(13) ,
  `card_id` CHAR(19)
);
INSERT INTO hotel VALUES ("0000001","123","如家酒店南大店",FALSE ,"南京大学内","025-86852980","1234567890123456789");