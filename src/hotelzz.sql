-----在线预订酒店系统---1302班王保帅--
-------<<以下是数据库的执行顺序>>------
----------1.解除外键关联-------
alter table room drop constraint FK_ROOM_REFERENCE_TYPE;
alter table room drop constraint FK_ROOM_REFERENCE_HOTEL;
alter table hmenu drop constraint FK_HMENU_REFERENCE_MENUTYPE;
alter table roomDetail drop constraint FK_ROOMDETAIL_REFERENCE_ROOM;
alter table hotel drop constraint FK_HOTEL_REFERENCE_HCITY;
alter table hmessage drop constraint FK_HMESSGAE_REFERENCE_LUSER;
alter table hcomment drop constraint FK_HCOMMENT_REFERENCE_LUSER;
alter table hcomment drop constraint FK_HCOMMENT_REFERENCE_HOTEL;
alter table horder drop constraint FK_HORDER_REFERENCE_ROOM;
alter table horder drop constraint FK_HORDER_REFERENCE_LUSER;
commit;
--------2.删除表语句-----
drop table luser;
drop table room;
drop table roomDetail;
drop table rtype;
drop table hotel;
drop table hcity;
drop table hmenu;
drop table menutype;
drop table hmessage;
drop table hnew;
drop table hcomment;
drop table horder;
commit;
-------3.删除序列------
drop sequence luser_seq;
drop sequence hcity_seq;
drop sequence hotel_seq;
drop sequence rtype_seq;
drop sequence roomDetail_seq;
drop sequence hmenu_seq;
drop sequence menutype_seq;
drop sequence hnew_seq;
drop sequence hcomment_seq;
drop sequence hmessage_seq;
drop sequence horder_seq;
commit;

-----------4.创建表----------------

---------(1)用户表=========
create table luser(
u_id number(6),----用户Id
u_loginname varchar2(20),--用户名
u_loginpass varchar2(20),--密码
u_sex char(10),--性别
u_telephone varchar2(16),---电话
u_address varchar2(100),--地址
u_type varchar2(100),--shenfen
u_idcard varchar2(50),---身份证号
u_email varchar2(50),---Email地址
u_image varchar2(500),--头像
u_status varchar2(10),--表示用户的状态（0 正常   1 冻结）
u_isadmin number(6),---是否是管理员
u_score number(6),---用户积分
constraint PK_LUSER primary key (u_id)
);
-------(2)酒店城市表========
create table hcity(
 city_id number(6),--城市ID
 city_name varchar(100),---城市名称
 constraint PK_HCITY primary key (city_id)
);
--------(3)酒店表=========
create table hotel(
h_id number(6),--酒店ID
h_name varchar2(100),--酒店名称
h_zip number(6),--酒店编码
h_content varchar2(1000),--酒店介绍
h_telephone varchar2(16),--酒店电话
h_address varchar2(100),--酒店地址
h_image varchar2(500),--酒店图片
h_city number(6),
constraint PK_HOTEL primary key (h_id)
);

---------(4)客房表===========
create table room(
  r_id number(6),---房间号
  r_title varchar2(200),---主题
  r_floor varchar2(10),--楼层
  r_bednumber number(6),---床位数
  r_img varchar2(100),---房间图片
  r_state varchar2(20),---表示状态（空闲 ,入住）
  rd_total number(6), --预付押金
  r_type number(6), ---房间类型
  r_hotel number(6),---jiudian
  constraint PK_ROOM primary key (r_id)
);

---------(5)客房类型表=======
create table rtype(
rt_id number(6),--类型ID
tr_name varchar2(100),--类型名
 constraint PK_RTYPE primary key (rt_id)
);

---------(6)客房详细表=========
create table roomDetail(
 rd_id number(6),--明细ID
 room_id number(6),
 rd_title varchar2(200),---主题
 rd_content varchar2(200),---内容
 rd_telephone varchar2(30),---房间电话
 rd_price number(8,2),--实际价格
 rd_discount number(8,2),---折扣价格
 rd_perhourprice number(8,2),---计时每小时价
 constraint PK_ROOMDEATIL primary key (rd_id)
);

---------(7)菜单表============
create table hmenu(
 m_id number(6),--菜单ID
 m_title varchar2(50),--菜系名称
 m_price number(6),--菜系价格
 m_img varchar2(100),--菜系图片
 m_type number(6), ---类型
 constraint PK_HMENU primary key (m_id)
);
----------(8)菜单类型=======
create  table menutype
(
 mt_id number(6),--类型ID
 mt_name varchar2(50),--类型名称
   constraint PK_MENUTYPE primary key (mt_id)
);

---------(9)新闻表========
create table hnew(
n_id number(6),--新闻ID
n_title varchar2(100),--新闻主题
n_image varchar2(100),--tupian
n_content varchar2(250),--新闻内容
constraint PK_HNEW primary key (n_id)
);
----------(10)留言表=========
create table hmessage
(
m_id number(6),--留言ID
m_title varchar2(100),--留言主题
m_content varchar2(200), --留言内容
u_id number(6),  
m_date date,--留言日期
m_reply varchar2(200),--表示回复
  constraint PK_HMESSAGE primary key (m_id)
);

---------(11)评论表========
create table hcomment
(
c_id number(6),--评论ID
c_content varchar2(200), --评论内容
u_id number(6), 
h_id number(6), 
c_score number(6) , --评分
c_date date,--日期
 constraint PK_HCOMMENT primary key (c_id)
);

---------(12)订单表========
create table horder
(
   o_id number(6),--订单ID
   u_id number(6),
   r_id number(6),
   o_date date,--入住日期
   b_date date,--预订时间
   y_date date,--退房日期
   o_name varchar2(20),--姓名
   o_telphone varchar2(16),--电话
   o_status varchar2(10),--表示状态（0待审核   1 通过）   
   constraint PK_HORDER primary key (o_id)
); 
-------------5.创建序列---------------
create sequence luser_seq start with 0 increment by 1 minvalue 0;
create sequence hcomment_seq start with 0 increment by 1 minvalue 0;
create sequence hmenu_seq start with 0 increment by 1 minvalue 0;
create sequence roomDetail_seq start with 0 increment by 1 minvalue 0;
create sequence rtype_seq start with 0 increment by 1 minvalue 0;
create sequence menutype_seq start with 0 increment by 1 minvalue 0;
create sequence hotel_seq start with 0 increment by 1 minvalue 0;
create sequence hcity_seq start with 0 increment by 1 minvalue 0;
create sequence hmessage_seq start with 0 increment by 1 minvalue 0;
create sequence hnew_seq start with 0 increment by 1 minvalue 0;
create sequence horder_seq  start with 0 increment by 1 minvalue 0;
commit;

------------6.创建外键关联-------
alter table room add constraint FK_ROOM_REFERENCE_TYPE foreign key (r_type) references rtype(rt_id);
alter table room add constraint FK_ROOM_REFERENCE_HOTEL foreign key (r_hotel) references hotel(h_id);
alter table hmenu add constraint FK_HMENU_REFERENCE_MENUTYPE foreign key (m_type) references menutype(mt_id);
alter table roomDetail add constraint FK_ROOMDETAIL_REFERENCE_ROOM foreign key (room_id) references room(r_id);
alter table hotel add constraint FK_HOTEL_REFERENCE_HCITY foreign key (h_city) references hcity(city_id);
alter table hmessage add constraint FK_HMESSGAE_REFERENCE_LUSER foreign key (u_id) references luser(u_id);
alter table hcomment add constraint FK_HCOMMENT_REFERENCE_LUSER foreign key (u_id) references luser(u_id);
alter table hcomment add constraint FK_HCOMMENT_REFERENCE_HOTEL foreign key (h_id) references hotel(h_id);
alter table horder add constraint FK_HORDER_REFERENCE_ROOM foreign key (r_id) references room(r_id);
alter table horder add constraint FK_HORDER_REFERENCE_LUSER foreign key (u_id) references luser(u_id);
commit;
------------7.插入数据----------------
------(1)插入用户数据------
insert into luser values(luser_seq.nextval,'admin','123456','男','18898748995','北京市海淀区','白领','1421163632562365','23444@qq.com','u1.gif','正常',1,100);
insert into luser values(luser_seq.nextval,'zhangsan','123456','女','18898748665','北京市朝阳区','金领','1421163632562365','23564@qq.com','u2.gif','正常',0,100);
insert into luser values(luser_seq.nextval,'lisi','123456','男','18898748225','北京市丰台区','蓝领','1421163632562365','23423@qq.com','u3.gif','正常',0,100);
insert into luser values(luser_seq.nextval,'wangwu','123456','女','18898748335','北京市昌平区','白领','1421163632562365','23898@qq.com','u4.gif','冻结',0,100);
insert into luser values(luser_seq.nextval,'zhaoliu','123456','男','18898748425','太原市小店区','金领','142116364682465','46898@qq.com','u5.gif','冻结',0,100);
insert into luser values(luser_seq.nextval,'guosan','123456','男','18898748665','天津市昌平区','学生','14211636988564465','28998@qq.com','u6.gif','冻结',0,100);
commit;
select * from luser;
------(2)插入城市数据-----
insert into hcity values(hcity_seq.nextval,'北京');
insert into hcity values(hcity_seq.nextval,'上海');
insert into hcity values(hcity_seq.nextval,'广州');
insert into hcity values(hcity_seq.nextval,'天津');
insert into hcity values(hcity_seq.nextval,'深圳');
insert into hcity values(hcity_seq.nextval,'太原');
insert into hcity values(hcity_seq.nextval,'郑州');
insert into hcity values(hcity_seq.nextval,'西安');
insert into hcity values(hcity_seq.nextval,'成都');
insert into hcity values(hcity_seq.nextval,'兰州');
insert into hcity values(hcity_seq.nextval,'杭州');
commit;
select * from hcity;
------(3)插入酒店数据----
insert into hotel values (hotel_seq.nextval,'北京腾龙店',032300,'全国最大的8星级大酒店','0000-7888888','北京市海淀区建设路88号','h1.jpg',1 );
insert into hotel values (hotel_seq.nextval,'上海腾龙店',043000,'上海最大的8星级大酒店','0100-7888888','上海市浦东区国民路99号','h10.jpg',2 );
insert into hotel values (hotel_seq.nextval,'广州腾龙店',060210,'广东最大的8星级大酒店','0200-7888888','广州市开发区新街口88号','h2.jpg',3 );
insert into hotel values (hotel_seq.nextval,'天津腾龙店',012402,'天津最大的8星级大酒店','0400-7888888','天津市海淀区建设路88号','h3.jpg',4 );
insert into hotel values (hotel_seq.nextval,'深圳腾龙店',032101,'深圳最大的8星级大酒店','0500-7888888','深圳市海淀区建设路88号','h4.jpg',5 );
insert into hotel values (hotel_seq.nextval,'郑州腾龙店',045165,'河南最大的8星级大酒店','0700-7888888','郑州市海淀区建设路88号','h5.jpg',7 );
insert into hotel values (hotel_seq.nextval,'太原腾龙店',023544,'山西最大的7星级大酒店','0400-7888888','太原市海淀区建设路88号','h6.jpg',6 );
insert into hotel values (hotel_seq.nextval,'西安腾龙店',021352,'陕西最大的8星级大酒店','0300-7888888','西安市海淀区建设路88号','h7.jpg',8);
insert into hotel values (hotel_seq.nextval,'成都腾龙店',098122,'四川最大的6星级大酒店','0500-7888888','成都市海淀区建设路88号','h8.jpg',9 );
insert into hotel values (hotel_seq.nextval,'兰州腾龙店',036541,'甘肃最大的8星级大酒店','0300-7888888','兰州市海淀区建设路88号','h9.jpg',10 );
insert into hotel values (hotel_seq.nextval,'杭州腾龙店',032425,'浙江最大的8星级大酒店','0300-7888888','杭州市海淀区建设路88号','h10.jpg',11);
commit;
------(4)插入客房类型数据----
insert into rtype  values(rtype_seq.nextval,'总统套房');
insert into rtype  values(rtype_seq.nextval,'至尊套房');
insert into rtype  values(rtype_seq.nextval,'豪华套房');
insert into rtype  values(rtype_seq.nextval,'VIP套房');
insert into rtype  values(rtype_seq.nextval,'高级套房');
insert into rtype  values(rtype_seq.nextval,'商务套房');
insert into rtype  values(rtype_seq.nextval,'标准套房');
insert into rtype values(rtype_seq.nextval,'行政套房');
insert into rtype values(rtype_seq.nextval,'双人套房');
insert into rtype  values(rtype_seq.nextval,'情侣套房');
insert into rtype  values(rtype_seq.nextval,'单人套房');
commit;
------(5)插入客房数据------
insert into room values (1001,'海洋的世界','1Floor',2,'ra.jpg','空闲',100,5,1);
insert into room values (2001,'温诺的家','2Floor',2,'rb.jpg','空闲',50,7,1);
insert into room values (3001,'豪华的蜗居','3Floor',2,'rc.jpg','空闲',50,7,1);
insert into room values (4001,'舒适的天堂','4Floor',2,'rd.jpg','空闲',100,8,1);
insert into room values (5001,'综合度假性酒店','5Floor',2,'rf.jpg','空闲',100,7,3);
insert into room values (6001,'奇幻之门','6Floor',2,'rg.jpg','空闲',100,6,1);
insert into room values (1100,'庄园城堡','1Floor',2,'rh.jpg','空闲',100,6,4);
insert into room values (2003,'体验式度假','2Floor',2,'rj.jpg','空闲',100,7,4);
insert into room values (3000,'原生态','3Floor',2,'rl.jpg','空闲',100,4,6);
insert into room values (1011,'黑客帝国','1Floor',1,'rq.jpg','入住',100,4,3);
insert into room values (3010,'童话世界','3Floor',2,'rw.jpg','空闲',100,3,2);
insert into room values (4000,'宫殿','4Floor',2,'re.jpg','空闲',200,1,1);
insert into room values (5000,'所罗门','5Floor',2,'rr.jpg','入住',200,1,1);
insert into room values (5010,'王的世界','5Floor',2,'rt.jpg','空闲',200,2,1);
insert into room values (5002,'北冰洋','5Floor',2,'ry.jpg','入住',100,5,2);
insert into room values (4008,'迷宫','4Floor',2,'ru.jpg','空闲',100,5,3);
insert into room values (3002,'海港','3Floor',2,'ri.jpg','入住',100,9,4);
insert into room values (1008,'朱提式','1Floor',2,'ro.jpg','空闲',100,4,2);
insert into room values (1009,'爱的世界','1Floor',1,'rp.jpg','入住',100,10,6);
insert into room values (7001,'单身世界','7Floor',1,'rm.jpg','空闲',100,11,6);
insert into room values (8000,'豪华包房','8Floor',1,'rn.jpg','入住',120,3,6);
commit;
select * from room;
------(6)插入客房详情数据-----
insert into roomDetail values (roomDetail_seq.nextval,1001,'海洋的世界','走进房间就好比进入海的世界，清欢愉快','78032514',108,99,33);
insert into roomDetail values (roomDetail_seq.nextval,2001,'温诺的家','走进房间就好比进入海的世界，清欢愉快','78032556',208,169,63);
insert into roomDetail values (roomDetail_seq.nextval,3001,'豪华的蜗居','走进房间就好比进入海的世界，清欢愉快','78032555',138,109,43);
insert into roomDetail values (roomDetail_seq.nextval,4001,'舒适的天堂','走进房间就好比进入海的世界，清欢愉快','78032544',108,99,33);
commit;
------(7)插入菜系类型数据----
insert into menutype values(menutype_seq.nextval,'川菜');
insert into menutype values(menutype_seq.nextval,'鲁菜');
insert into menutype values(menutype_seq.nextval,'粤菜');
insert into menutype values(menutype_seq.nextval,'苏菜');
insert into menutype values(menutype_seq.nextval,'湘菜');
insert into menutype values(menutype_seq.nextval,'徽菜菜');
insert into menutype values(menutype_seq.nextval,'浙菜');
insert into menutype values(menutype_seq.nextval,'闽菜');
insert into menutype values(menutype_seq.nextval,'山西面');
insert into menutype values(menutype_seq.nextval,'重庆火锅');
commit;
------(8)插入菜系数据-------
insert into hmenu values (hmenu_seq.nextval,'一品熊掌',988,'1.jpg',1);
insert into hmenu values (hmenu_seq.nextval,'干烧鱼翅',688,'2.jpg',1);
insert into hmenu values (hmenu_seq.nextval,'麻婆豆腐',88,'3.jpg',1);
insert into hmenu values (hmenu_seq.nextval,'回锅肉',38,'4.jpg',1);
insert into hmenu values (hmenu_seq.nextval,'糖醋黄河鲤鱼',128,'5.jpg',2);
insert into hmenu values (hmenu_seq.nextval,'九转大肠',88,'6.jpg',2);
insert into hmenu values (hmenu_seq.nextval,'清汤燕窝',266,'7.jpg',2);
insert into hmenu values (hmenu_seq.nextval,'德州扒鸡',108,'8.jpg',2);
insert into hmenu values (hmenu_seq.nextval,'红烧海螺',68,'9.jpg',2);
insert into hmenu values (hmenu_seq.nextval,'三蛇龙凤大会',98,'10.jpg',3);
insert into hmenu values (hmenu_seq.nextval,'烤乳猪',498,'11.jpg',3);
insert into hmenu values (hmenu_seq.nextval,'盐焗鸡',158,'12.jpg',3);
insert into hmenu values (hmenu_seq.nextval,'五蛇羹',428,'13.jpg',3);
insert into hmenu values (hmenu_seq.nextval,'冬瓜盅',118,'1.jpg',3);
insert into hmenu values (hmenu_seq.nextval,'干煎大虾',168,'2.jpg',3);
insert into hmenu values (hmenu_seq.nextval,'鸡汤煮干丝',58,'3.jpg',4);
insert into hmenu values (hmenu_seq.nextval,'狮子头',208,'4.jpg',4);
insert into hmenu values (hmenu_seq.nextval,'水晶肴蹄',88,'5.jpg',4);
insert into hmenu values (hmenu_seq.nextval,'鸭鲍鱼',78,'6.jpg',4);
insert into hmenu values (hmenu_seq.nextval,'红盾鱼翅',68,'7.jpg',5);
insert into hmenu values (hmenu_seq.nextval,'冰糖相连',28,'8.jpg',5);
insert into hmenu values (hmenu_seq.nextval,'桔汁加吉鱼',58,'9.jpg',5);
insert into hmenu values (hmenu_seq.nextval,'葫芦鸭子',78,'5.jpg',6);
insert into hmenu values (hmenu_seq.nextval,'符离集烧鸡',99,'2.jpg',6);
insert into hmenu values (hmenu_seq.nextval,'金福寿',655,'6.jpg',6);
insert into hmenu values (hmenu_seq.nextval,'西湖鲤鱼',368,'l.jpg',7);
insert into hmenu values (hmenu_seq.nextval,'龙井虾仁',148,'8.jpg',7);
insert into hmenu values (hmenu_seq.nextval,'叫花鸡',18,'5.jpg',7);
insert into hmenu values (hmenu_seq.nextval,'干炸响铃',88,'9.jpg',7);
insert into hmenu values (hmenu_seq.nextval,'东坡肉',60,'2.jpg',7);
insert into hmenu values (hmenu_seq.nextval,'太极明虾',38,'3.jpg',8);
insert into hmenu values (hmenu_seq.nextval,'雪花鸡',118,'1.jpg',8);
insert into hmenu values (hmenu_seq.nextval,'佛跳墙',888,'2.jpg',8);
insert into hmenu values (hmenu_seq.nextval,'荔枝肉',788,'3.jpg',8);
insert into hmenu values (hmenu_seq.nextval,'烧片糟鸡',88,'5.jpg',8);
insert into hmenu values (hmenu_seq.nextval,'大同倒勾面',8,'6.jpg',9);
insert into hmenu values (hmenu_seq.nextval,'剔尖',28,'9.jpg',9);
insert into hmenu values (hmenu_seq.nextval,'油泼面',18,'10.jpg',9);
insert into hmenu values (hmenu_seq.nextval,'长寿面',68,'12.jpg',9);
insert into hmenu values (hmenu_seq.nextval,'辣火锅',338,'13.jpg',10);
commit;
------(9)插入新闻信息-------
insert into hnew values(hnew_seq.nextval,'腾龙酒店特色菜系','n1.jpg','腾龙大酒店推出全新的特色菜系,欢迎各位朋友前来品尝！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特价优惠','n2.jpg','腾龙大酒店近期推广活动,各标准套房8折优惠,！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店总体套房','n3.jpg','天上皇宫，地上腾龙，腾龙大酒店让你住的舒心,吃的放心,睡得安心！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特色菜系','n4.jpg','腾龙大酒店推出全新的特色菜系,欢迎各位朋友前来品尝！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特价优惠','n5.jpg','腾龙大酒店近期推广活动,各标准套房8折优惠,！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店总体套房','n6.jpg','天上皇宫，地上腾龙，腾龙大酒店让你住的舒心,吃的放心,睡得安心！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特色菜系','n7.jpg','腾龙大酒店推出全新的特色菜系,欢迎各位朋友前来品尝！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特价优惠','n8.jpg','腾龙大酒店近期推广活动,各标准套房8折优惠,！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店总体套房','n9.jpg','天上皇宫，地上腾龙，腾龙大酒店让你住的舒心,吃的放心,睡得安心！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特色菜系','n10.jpg','腾龙大酒店推出全新的特色菜系,欢迎各位朋友前来品尝！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特价优惠','n2.jpg','腾龙大酒店近期推广活动,各标准套房8折优惠,！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店总体套房','n4.jpg','天上皇宫，地上腾龙，腾龙大酒店让你住的舒心,吃的放心,睡得安心！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特色菜系','n5.jpg','腾龙大酒店推出全新的特色菜系,欢迎各位朋友前来品尝！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店特价优惠','n9.jpg','腾龙大酒店近期推广活动,各标准套房8折优惠,！');
insert into hnew values(hnew_seq.nextval,'腾龙酒店总体套房','n11.jpg','天上皇宫，地上腾龙，腾龙大酒店让你住的舒心,吃的放心,睡得安心！');
commit;

--------(10)插入评论数据------
insert into hcomment values(hcomment_seq.nextval,'服务的态度真的是太好了！',2,1,9,to_date('2016-11-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'相当的高大上的酒店，服务态度相当的周到',2,1,9,to_date('2016-12-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'真的是名不虚传，八星级的酒店就是一流',3,1,7,to_date('2016-12-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'住的舒服，吃的放心，这就是大酒店的独特之处啊',4,1,9,to_date('2016-10-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'住的舒服，吃的放心，这就是大酒店的独特之处啊',2,1,9,to_date('2016-10-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',2,1,9,to_date('2016-10-25','yyyy-mm-dd'));

insert into hcomment values(hcomment_seq.nextval,'住的舒服，吃的放心，这就是大酒店的独特之处啊',2,2,8,to_date('2016-12-20','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'真的是名不虚传，八星级的酒店就是一流',2,2,9,to_date('2016-11-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'服务的态度真的是太好了！',3,2,10,to_date('2016-12-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',3,2,9,to_date('2016-11-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',4,2,8,to_date('2016-10-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',4,2,9,to_date('2016-09-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'住的舒服，吃的放心，这就是大酒店的独特之处啊',2,3,6,to_date('2016-07-25','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'真的是名不虚传，八星级的酒店就是一流',2,3,8,to_date('2016-11-15','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'服务的态度真的是太好了！',3,3,9,to_date('2016-11-05','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'相当的高大上的酒店，服务态度相当的周到',3,3,9,to_date('2016-11-15','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',3,3,8,to_date('2016-11-20','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',2,3,6,to_date('2016-11-10','yyyy-mm-dd'));

insert into hcomment values(hcomment_seq.nextval,'住的舒服，吃的放心，这就是大酒店的独特之处啊',4,4,8,to_date('2016-11-20','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'真的是名不虚传，八星级的酒店就是一流',5,4,6,to_date('2016-11-10','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'服务的态度真的是太好了！',3,4,8,to_date('2016-11-20','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'相当的高大上的酒店，服务态度相当的周到',3,4,6,to_date('2016-11-10','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',2,4,8,to_date('2016-11-20','yyyy-mm-dd'));
insert into hcomment values(hcomment_seq.nextval,'果真是好酒店，各种设施应有尽有，好喜欢',4,4,6,to_date('2016-11-10','yyyy-mm-dd'));
commit;

--------8.查询语句---------
select * from luser 
select * from room;
select * from roomDetail;
select * from rtype;
select * from hotel;
select * from hcity;
select * from hmessage;
select * from hnew ;
select * from hcomment;
select * from horder;
select * from hmenu;
select * from menutype;
commit;
--------------------------
