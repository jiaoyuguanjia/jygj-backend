CREATE DATABASE DB_JINLI DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;;


USE DB_JINLI;

--用户表
create table t_user (
	id int(10) not null auto_increment comment '用户主键id',
	role_id int(10) not null comment '关联的角色id',
	username varchar(20) comment '用户账号名',
	password varchar(50) comment '用户登录后台密码',
	nickName varchar(30) comment '用户昵称',
	fullname varchar(30) comment '用户全称姓名',
	email varchar(30) comment '用户邮箱',
	phone varchar(30) comment '用户联系电话',
	create_time date comment '用户创建时间',
	PRIMARY KEY (ID)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--角色表
create table t_role (
	id int(10) not null auto_increment comment '角色主键id',
	name varchar(60) not null comment '角色名称',
	create_time date comment '角色创建时间',
	PRIMARY KEY (ID)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--功能表
create table t_function(
	id int(10) not null auto_increment comment '功能主键id',
	title varchar(30) comment '功能title',
	name varchar(30) comment '功能名称',
	url varchar(100) comment '功能url地址',
	parent_id int(10) comment '所属父功能的id',
	create_time date comment '功能创建时间',
	PRIMARY KEY (ID)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


create table t_customer (
	id,
	name,
	phone,
	email
)

create table t_mianshi(
	id,
	customer_id,
	times,
	result,
	remark,
	is_offer,
	create_time,
	update_time
)

CREATE TABLE T_RESUME (
	ID INT(10) NOT NULL AUTO_INCREMENT COMMENT '简历表主建id',
	NAME VARCHAR(50) NOT NULL COMMENT '姓名',
	SEX VARCHAR(10) NOT NULL COMMENT '性别',
	YEAR VARCHAR(11) NOT NULL COMMENT '年',
	MONTH VARCHAR(10) NOT NULL COMMENT '月',
	JOBYEAR INT(3) NOT NULL COMMENT '工作年限',
	EDUCATION VARCHAR(100) NOT NULL COMMENT '学历',
	JOBEXPERIENCE TEXT NOT NULL COMMENT '工作经历',
	PROJECTEXPERIENCE TEXT NOT NULL COMMENT '项目经历',
	TECHNOLOGY VARCHAR (200) NOT NULL COMMENT '技能',
	PROVINCECODE VARCHAR(20) NOT NULL COMMENT '省份CODE',
	CITYCODE VARCHAR(20) NOT NULL COMMENT '城市CODE',
	AREACODE VARCHAR(20) NOT NULL COMMENT '城镇CODE',
	customer_id
	PRIMARY KEY (ID)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;








create table t_role_function(
	id,
	role_id,
	function_id
)


create table t_lietou(
	id,
	code,
	name,
	email,
	phone,
	customer_id,
	create_time,
	update_time
)

create table t_price_item(
	id,
	title,
	content,
	price,
	company_id,
	lietou_id,
	remark,
	create_time,
	is_full_amount,
	yukuan
)

create table t_company(
	id,
	companyType,
	category,
	name,
	description,
	total_person,
	total_zhaopin_person,
	send_zhaopin_person,
	offer_count,
	create_time
)




