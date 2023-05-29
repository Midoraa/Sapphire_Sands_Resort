create database SapphireSands;
-- drop database SapphireSands;
use SapphireSands;

create table Account(
	accountID char(10) primary key,
    username char(50),
    password char(50),
    `role` bit
);


create table Customer(
	cusID char(10) PRIMARY KEY,
    cusName nvarchar(50), 
    cusDOB date,
    cusPhone char(11),
    cusEmail char(50),
    cusCCCD char(12),
    cusType int,
    constraint fk_cusId foreign key(cusID) references Account(accountID)
);

create table Employee(
	empID char(10) primary key,
    empName nvarchar(50),
    empGender bit,
    empDOB date,
    empAdress nvarchar(100),
    empPhone char(11),
    empEmail char(50),
    empRole char(10),
    constraint fk_empId foreign key(empID) references Account(accountID)
);



create table `Order`(
	orderID char(10) primary key,
    empID char(10),
    cusID char(10),
    orDate date,
    orStatus bit default 0,
    constraint fk_empIdOrder foreign key(empID) references Employee(empID),
    constraint fk_cusIdOrder foreign key(cusID) references Customer(cusID)
);

create table Room(
	roomID char(10) primary key,
    roomName nvarchar(50),
    roomType char(10),
    roomPrice decimal(10, 0),
    roomStatus bit,
	bed int,
    bathroom int
);
create table RoomPriceChange(
	roomID char(10) primary key,
    dayApply date,
    empID char(10),
    percentSale decimal(2,2),
    constraint fk_roomPrice foreign key(roomID) references Room(roomID),
    constraint fk_empRoomPrice foreign key(empID) references Employee(empID)
);


create table Food(
	foodID char(10),
    foodName nvarchar(50),
    foodPrice decimal(10,0)
);

create table Service(
	serviceID char(10),
    serviceName nvarchar(50),
    servicePrice decimal(10,0)
);


ALTER TABLE Room ADD INDEX idx_room_id (roomID);

create table ContractDetail(
	roomID char(10),
    orderID char(10),
    timeIn datetime,
    timOut datetime,
    constraint fk_order foreign key(orderID) references `Order`(orderID),
    constraint fk_room foreign key(roomID) references Room(roomID),
    constraint pk_contract primary key (roomID, orderID)
);



ALTER TABLE Food ADD INDEX idx_food_id (foodID);

create table OrderDetail(
	orderID char(10),
    foodID char(10),
    Amount int,
    constraint pk_orderDetail primary key (orderID, foodID),
    constraint fk_orderdt foreign key(orderID) references `Order`(orderID),
    constraint fk_fooddt foreign key(foodID) references Food(foodID)
);

ALTER TABLE Service ADD INDEX idx_service_id (serviceID);

create table ServiceDetail(
	orderID char(10),
    serviceID char(10),
    Amount int,
    constraint pk_orderDetail primary key (orderID, serviceID),
    constraint fk_orderdtt foreign key(orderID) references `Order`(orderID),
    constraint fk_servicedt foreign key(serviceID) references Service(serviceID)
);

-- INSERT 

-- insert into Customer
-- values 
-- ('CUS0000001',  N'Thạch Bí Hí', '2000-05-12', '0472585666', 'thachbihi@gmail.com', '046200012345', 1),
-- ('CUS0000002',  N'Vũ Văn Hoàng', '1999-07-22', '0989350596', 'vuvanhoang@gmail.com', '001099253748', 0),
-- ('CUS0000003',  N'Trần Quốc Tuấn', '2001-12-02', '0363148375', 'tranquoctuan@gmail.com', '045201879021', 0),
-- ('CUS0000004',  N'Thủy Huyền Vũ', '1998-05-12', '0988816483', 'thuyhuyenvu@gmail.com', '027198919855', 1),
-- ('CUS0000005',  N'Phong Bạch Hổ', '1998-01-18', '0378462148', 'phongbachho@gmail.com', '031198168002', 1),
-- ('CUS0000006',  N'Lôi Thanh Long', '2000-02-06', '0363278678', 'loibachho@gmail.com', '001200290520', 1),
-- ('CUS0000007',  N'Hỏa Chu Tước', '1987-03-12', '0776498513', 'hoachutuoc@gmail.com', '040187917782', 1),
-- ('CUS0000008',  N'Kim Toan Nghê', '1992-12-22', '0124889765', 'kimtoannghe@gmail.com', '068092469285', 0),
-- ('CUS0000009',  N'Nhạc Tù Ngưu', '1987-08-18', '0656742885', 'nhactunguu@gmail.com', '027087751759', 1),
-- ('CUS0000010',  N'Thô Phủ Tiêu Đồ', '2005-10-21', '0343627232', 'thophutieudo@gmail.com', '001205694153', 0),
-- ('CUS0000011',  N'Đỗ Bạch Trạch', '2002-01-14', '0964432958', 'dobachtrach@gmail.com', '052202248808', 0),
-- ('CUS0000012',  N'Công Tôn Tố Nữ', '1996-11-11', '0312425678', 'congtontonu@gmail.com', '046196181078', 0);

-- insert into Employee
-- values
-- ('EMP000001', N'Nguyễn Hữu Thọ', 1, '1992-09-23', N'Đà Nẵng', '0342637732', 'nguyenhuutho@gmail.com', '4'),
-- ('EMP000002', N'Trần Đại Nghĩa', 1, '1982-06-12', N'Đà Nẵng', '0164432954', 'trandainghia@gmail.com', '4'),
-- ('EMP000003', N'Võ Qui Huân', 1, '1989-12-27', N'Thừa Thiên Huế', '0776242784', 'voquihuan@gmail.com', '4'),
-- ('EMP000004', N'Đinh Công Tráng', 1, '1989-02-02', N'Quảng Nam', '0964456823', 'dinhcongtrang@gmail.com', '4'),
-- ('EMP000005', N'Võ Chí Công', 1, '1986-07-14', N'Quảng Nam', '0136892927', 'vochicong@gmail.com', '4'),
-- ('EMP000006', N'Trưng Nữ Vương', 0, '1999-07-23', N'Đà Nẵng', '0988234582', 'trungnuvuong@gmail.com', '4'),
-- ('EMP000007', N'Huyền Tôn Sinh Liên', 0, '1996-08-25', N'Thừa Thiên Huế', '0363012953', 'huyentonsinhlien@gmail.com', '4'),
-- ('EMP000008', N'Hoàng Thị Loan', 0, '2000-05-26', N'Đà Nẵng', '0136321946', 'hoangthiloan@gmail.com', '4'),
-- ('EMP000009', N'Tôn Đức Thắng', 1, '1984-11-12', N'Đà Nẵng', '0963241436', 'tonducthang@gmail.com', '4'),
-- ('ADM000001', N'Nguyễn Bảo Trung', 1, '2000-05-26', N'Quảng Ngãi', '0913562870', 'trungnbde160410@fpt.edu.vn', '1'),
-- ('ADM000002', N'Trần Đình Hiệu', 1, '2002-01-10', N'Thừa Thiên Huế', '0702662251', 'hieutdde160594@fpt.edu.vn', '1'),
-- ('ADM000003', N'Trần Đình Quân', 1, '2002-10-26', N'Buôn Mê Thuột - Đắk Lắk', '0136321946', 'quantdde160067@fpt.edu.vn', '1'),
-- ('MAN000001', N'Nguyễn Quang Bảo', 1, '2002-10-30', N'Đà Nẵng', '0702347748', 'baonqde160293@fpt.edu.vn', '2'),
-- ('MAN000002', N'Nguyễn Công Thành', 1, '2001-08-15', N'Hà Tĩnh', '0363012495', 'thanhncde160490@fpt.edu.vn', '2');

-- Insert into Account(accountID, username, password, role)
-- values
-- ('CUS0000001','user1','123', 1),
-- ('CUS0000002','user2','123', 1),
-- ('CUS0000003','user3','123', 1),
-- ('CUS0000004','user4','123', 1),
-- ('CUS0000005','user5','123', 1),
-- ('CUS0000006','user6','123', 1),
-- ('CUS0000007','user7','123', 1),
-- ('CUS0000008','user8','123', 1),
-- ('CUS0000009','user9','123', 1),
-- ('CUS0000010','user10', '123', 1),
-- ('CUS0000011','user11','123', 1),
-- ('CUS0000012','user12', '123', 1),
-- ('EMP0000001','emp1','234', 0),
-- ('EMP0000002','emp2','234', 0),
-- ('EMP0000003','emp3','234', 0),
-- ('EMP0000004','emp4','234', 0),
-- ('EMP0000005','emp5','234', 0),
-- ('EMP0000006','emp6','234', 0),
-- ('EMP0000007','emp7','234', 0),
-- ('EMP0000008','emp8','234', 0),
-- ('EMP0000009','emp9','234', 0),
-- ('ADM0000001','admin1','345', 0),
-- ('ADM0000002','admin2','345', 0),
-- ('ADM0000003','admin3','345', 0),
-- ('MAN0000001','manager1','456', 0),
-- ('MAN0000002','manager2','456', 0);


-- insert into Service(serviceID, serviceName, servicePrice)
-- values
-- 	('SV00001', N'Dịch vụ Karaoke', 100000),
--     ('SV00002', N'Dịch vụ Massage', 150000),
--     ('SV00003', N'Dịch vụ Thức ăn nhanh', 200000),
--     ('SV00004', N'Dịch vụ Tenis', 120000),
--     ('SV00005', N'Dịch vụ Hồ Bơi', 180000),
--     ('SV00006', N'Dịch vụ BBQ', 90000),
--     ('SV00007', N'Dịch vụ Xông hơi', 130000),
--     ('SV00008', N'Dịch vụ Xuôi nước nóng', 110000),
--     ('SV00009', N'Dịch vụ Tiệc sinh nhật', 140000),
--     ('SV00010', N'Dịch vụ Tắm bùn', 160000);
--     -- drop table Service 
--     
-- insert into Food(foodID, foodName, foodPrice)
-- values
-- 	('F00001', N'Mì Ý Carbonara', 150000),
--     ('F00002', N'Sushi Nhật Bản', 200000),
--     ('F00003', N'Taco Mexico', 120000),
--     ('F00004', N'Bánh Mì Pháp', 80000),
--     ('F00005', N'Pad Thai Thái Lan', 100000),
--     ('F00006', N'Hamburger Mỹ', 90000),
--     ('F00007', N'Phở Việt Nam', 70000),
--     ('F00008', N'Pizza Ý', 180000),
--     ('F00009', N'Gyudon Nhật Bản', 130000),
--     ('F00010', N'Paella Tây Ban Nha', 220000);

--     
-- insert into Room(roomID, roomName, roomType, roomPrice, roomStatus)
-- values
-- 	('P0000001', N'Phòng Deluxe', 'Vip', 3000000, 1),
--     ('P0000002', N'Phòng Premier', 'Vip', 3500000, 1),
--     ('P0000003', N'Phòng Executive', 'Vip', 4000000, 1),
--     ('P0000004', N'Phòng Suite', 'Vip', 4500000, 1),
--     ('P0000005', N'Phòng Ocean View', 'Vip', 5000000, 1),
--     ('P0000006', N'Phòng Panorama', 'Vip', 5500000, 1),
--     ('P0000007', N'Phòng Grand Deluxe', 'Vip', 4000000, 1),
--     ('P0000008', N'Phòng Royal Suite', 'Vip', 6000000, 1),
--     ('P0000009', N'Phòng Penthouse', 'Vip', 7000000, 1),
--     ('P0000010', N'Phòng Villa', 'Vip', 8000000, 1),
--     ('P0000011', N'Phòng Presidential Suite', 'Vip', 9000000, 1),
--     ('P0000012', N'Phòng Skyline', 'Normal', 3500000, 1),
--     ('P0000013', N'Phòng Garden View', 'Normal', 4000000, 1),
--     ('P0000014', N'Phòng Lake View', 'Normal', 4500000, 1),
--     ('P0000015', N'Phòng Terrace', 'Normal', 5000000, 1),
--     ('P0000016', N'Phòng Infinity Pool', 'Normal', 5500000, 1),
--     ('P0000017', N'Phòng Club Level', 'Normal', 4000000, 1),
--     ('P0000018', N'Phòng Beachfront', 'Normal', 6000000, 1),
--     ('P0000019', N'Phòng Jacuzzi', 'Villa', 7000000, 1),
--     ('P0000020', N'Phòng Terrace Suite', 'Villa', 8000000, 1);


-- Insert into `Order`()
-- values
-- ('O00000001', 'EMP000001', 'CUS0000001', '2023-02-02', 1),
-- ('O00000002', 'EMP000001', 'CUS0000002', '2023-02-12', 1),
-- ('O00000003', 'EMP000002', 'CUS0000003', '2023-02-25', 1),
-- ('O00000004', 'EMP000002', 'CUS0000004', '2023-03-04', 1),
-- ('O00000005', 'EMP000002', 'CUS0000005', '2023-03-10', 1),
-- ('O00000006', 'EMP000003', 'CUS0000006', '2023-03-27', 1),
-- ('O00000007', 'EMP000004', 'CUS0000007', '2023-04-01', 1),
-- ('O00000008', 'EMP000004', 'CUS0000008', '2023-04-05', 1),
-- ('O00000009', 'EMP000001', 'CUS0000009', '2023-04-22', 1),
-- ('O00000010', 'EMP000006', 'CUS0000010', '2023-05-06', 0);
-- ;

-- insert into ContractDetail
-- values
-- ('P0000001', 'O00000001', '2023-02-02','2023-02-04'),
-- ('P0000002', 'O00000001', '2023-02-12','2023-02-16'),
-- ('P0000003', 'O00000002', '2023-03-13','2023-03-14'),
-- ('P0000004', 'O00000002', '2023-03-21','2023-03-22'),
-- ('P0000005', 'O00000002', '2023-03-07','2023-03-14'),
-- ('P0000006', 'O00000003', '2023-04-08','2023-04-10'),
-- ('P0000007', 'O00000004', '2023-04-12','2023-04-14'),
-- ('P0000008', 'O00000004', '2023-04-26','2023-04-29'),
-- ('P0000009', 'O00000001', '2023-05-17','2023-05-21'),
-- ('P0000010', 'O00000006', '2023-05-18','2023-05-22');
-- ;

-- insert into OrderDetail
-- values
-- ('O00000001', 'F00001', 2),
-- ('O00000001', 'F00003', 3),
-- ('O00000001', 'F00002', 1),
-- ('O00000002', 'F00003', 2),
-- ('O00000002', 'F00002', 3),
-- ('O00000004', 'F00003', 1),
-- ('O00000005', 'F00006', 2),
-- ('O00000005', 'F00002', 4),
-- ('O00000006', 'F00001', 1),
-- ('O00000007', 'F00008', 2),
-- ('O00000007', 'F00006', 2)
-- ;

-- insert into ServiceDetail
-- values
-- ('O00000001', 'SV00001', 2),
-- ('O00000001', 'SV00003', 3),
-- ('O00000001', 'SV00004', 1),
-- ('O00000002', 'SV00002', 1),
-- ('O00000002', 'SV00003', 4),
-- ('O00000002', 'SV00006', 3),
-- ('O00000002', 'SV00008', 2),
-- ('O00000004', 'SV00001', 5),
-- ('O00000005', 'SV00004', 1),
-- ('O00000006', 'SV00006', 3),
-- ('O00000006', 'SV00009', 2),
-- ('O00000007', 'SV00010', 4),
-- ('O00000008', 'SV00005', 2)
-- ;
