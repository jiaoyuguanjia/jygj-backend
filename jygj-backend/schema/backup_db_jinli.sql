CREATE DATABASE DB_JINLI DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;;


USE DB_JINLI;

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


create table t_user (
	id,
	role_id
	name,
	password,
	nickName,
	fullname,
	email,
	phone,
	create_time,
)


create table t_role (
	id,
	name
	create_time,
)

create table t_function(
	id,
	title,
	name,
	url,
	parent_id,
	create_time,
) 

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
	hangye,
	xingzhi,
	name,
	description,
	total_person,
	total_zhaopin_person,
	send_zhaopin_person,
	offer_count,
	create_time
)




