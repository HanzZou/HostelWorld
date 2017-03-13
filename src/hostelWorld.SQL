use hostelworld;
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