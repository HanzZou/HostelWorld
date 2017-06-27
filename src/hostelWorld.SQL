use hostelworld;

# 顾客表
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` char(7) PRIMARY KEY ,
  `password` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `telephone` CHAR(11) NOT NULL ,
  `address` VARCHAR(255) NOT NULL ,
  `card_id` char(19) NOT NULL ,
  `is_blocked` BOOLEAN ,
  `blocked_day` DATE ,
  `credits` INT NOT NULL ,
  `vip_grade` INT NOT NULL
);
INSERT INTO customer VALUES ("0000001","123","张三","18795850197","南京市南京大学","1234567890123456789",FALSE,NULL,1,1);

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

# 住宿计划表
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` CHAR(10) PRIMARY KEY ,
  `hotel_id` CHAR(7) NOT NULL ,
  `room` CHAR(4) NOT NULL ,
  `start_day` DATE NOT NULL ,
  `end_day` DATE NOT NULL ,
  `price` INT NOT NULL ,
  `is_reserved` BOOLEAN NOT NULL DEFAULT FALSE
);
INSERT INTO plan VALUES ("0000000001","0000001","815","2017-3-15","2017-3-16","100",FALSE );

# 预订表
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` CHAR(10) PRIMARY KEY ,
  `time` DATE NOT NULL ,
  `member_id` CHAR(7) NOT NULL ,
  `plan_id` CHAR(10) NOT NULL ,
  `is_canceled` BOOLEAN NOT NULL ,
  `is_finished` BOOLEAN NOT NULL
);
INSERT INTO reservation VALUES ("0000000001","2017-04-01", "0000001", "0000000001", 0, 0);

# 入住表
DROP TABLE IF EXISTS `checkin`;
CREATE TABLE `checkin` (
  `id` CHAR(15) PRIMARY KEY ,
  `hotel_id` CHAR(7) NOT NULL ,
  `member` CHAR(7) NOT NULL ,
  `room` CHAR(4) NOT NULL ,
  `date` DATE NOT NULL ,
  `p_num` INT NOT NULL ,
  `names` VARCHAR(255) ,
  `leave_date` DATE ,
  `pay_card` BOOLEAN NOT NULL ,
  `checkout` BOOLEAN NOT NULL
);

# 银行卡表
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` CHAR(19) PRIMARY KEY ,
  `balance` INT
);

# 用户信息修改表
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `id` CHAR(15) PRIMARY KEY ,
  `member_id` CHAR(7) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `telephone` CHAR(11) ,
  `address` VARCHAR(255) ,
  `card_id` CHAR(19) NOT NULL ,
  `is_accepted` BOOLEAN
);

# 客栈信息修改表
DROP TABLE IF EXISTS `hotel_info`;
CREATE TABLE `hotel_info` (
  `id` char(15) PRIMARY KEY ,
  `hotel_id` CHAR(7) NOT NULL ,
  `address` VARCHAR(255) NOT NULL ,
  `telephone` CHAR(13) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `card_id` CHAR(19) NOT NULL ,
  `is_accepted` BOOLEAN
);

# 财务表
DROP TABLE IF EXISTS `finance_record`;
CREATE TABLE `finance_record` (
  `id` char(15) PRIMARY KEY ,
  `hotel_id` CHAR(7) NOT NULL ,
  `member_id` CHAR(7) NOT NULL ,
  `price` INT NOT NULL ,
  `time` DATE NOT NULL ,
  `is_settled` BOOLEAN ,
  `rate` INT 
);