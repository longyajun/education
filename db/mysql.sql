set foreign_key_checks=0;
drop table if exists `u_user`;
create table `u_user` (
 id int(4) not null auto_increment comment '用户id',
 username varchar(30) not null comment '用户名',
 school_name varchar(100) not null comment '学校名称',
 subject varchar(30) comment '科目',
 grade_class varchar(100) comment '班级',
 password varchar(32) not null comment '密码',
 email varchar(100) not null comment '电子邮箱',
 mobile varchar(40) comment '手机号码',
 status int(4) not null comment '状态:0 禁用,1 教师,2 学生',
 last_login_ip varchar(100) COMMENT '最后登陆IP',
 last_login_date timestamp COMMENT '最后登陆时间',
 extend_s1 varchar(100) COMMENT '扩展 String 1',
 extend_s2 varchar(100) COMMENT '扩展 String 2',
 primary key (id)
)engine=innodb auto_increment=5 default charset=utf8 comment = '用户信息表';

-- 添加唯一索引
-- 查询索引show index from u_user; describe u_user;
alter table u_user add unique (email,mobile) 