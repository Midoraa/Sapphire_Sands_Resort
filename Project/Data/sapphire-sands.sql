create database SapphireSands;
-- drop database SapphireSands;
use SapphireSands;
-- drop table Customer;

create table Customer(
	cusID char(10) PRIMARY KEY,
    cusName nvarchar(50), 
    cusDOB date,
    cusPhone char(11),
    cusEmail char(50),
    cusCCCD char(12),
    cusType int
);

-- drop table Customer;
create table Employee(
	empID char(10) primary key,
    empName nvarchar(50),
    empGender bit,
    empDOB date,
    empAdress nvarchar(100),
    empPhone char(11),
    empEmail char(50),
    empRole char(10)
);

create table Account(
	accountID char(10) primary key,
    username char(50),
    password char(50),
    constraint fk_cus foreign key(accountID) references Customer(cusID),
	constraint fk_emp foreign key(accountID) references Employee(empID)
);

create table `Order`(
	orderID char(10) primary key,
    empID char(10),
    cusID char(10),
    orDate date,
    orStatus bit,
    constraint fk_empId foreign key(empID) references Employee(empID),
    constraint fk_customerId foreign key(cusID) references Customer(cusID)
);

create table Room(
	roomID char(10),
    roomName nvarchar(50),
    roomType char(10),
    roomPrice decimal(10, 0),
    roomStatus bit
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
ALTER TABLE Service ADD INDEX idx_service_id (serviceID);

create table OrderDetail(
	orderID char(10),
    productID char(10),
    productAmount int,
    constraint pk_orderDetail primary key (orderID, productID),
    constraint fk_orderdt foreign key(orderID) references `Order`(orderID),
    constraint fk_fooddt foreign key(productID) references Food(foodID),
    constraint fk_servicedt foreign key(productID) references Service(serviceID)
);


Insert into Account
Values
('CUS0000001','user1','123'),
('CUS0000002','user2','123'),
('CUS0000003','user3','123'),
('CUS0000004','user4','123'),
('CUS0000005','user5','123'),
('CUS0000006','user6','123'),
('CUS0000007','user7','123'),
('CUS0000008','user8','123'),
('CUS0000009','user9','123'),
('CUS0000010','user10', '123'),
('CUS0000011','user11','123'),
('CUS0000012','user12', '123'),
('EMP0000001','emp1','234'),
('EMP0000002','emp2','234'),
('EMP0000003','emp3','234'),
('EMP0000004','emp4','234'),
('EMP0000005','emp5','234'),
('EMP0000006','emp6','234'),
('EMP0000007','emp7','234'),
('EMP0000008','emp8','234'),
('EMP0000009','emp9','234'),
('ADM0000001','admin1','345'),
('ADM0000002','admin2','345'),
('ADM0000003','admin3','345'),
('MAN0000001','manager1','456'),
('MAN0000002','manager2','456');

insert into Customer
values 
('CUS0000001',  N'Thạch Bí Hí', '2000-05-12', '0472585666', 'thachbihi@gmail.com', '046200012345', 1),
('CUS0000002',  N'Vũ Văn Hoàng', '1999-07-22', '0989350596', 'vuvanhoang@gmail.com', '001099253748', 0),
('CUS0000003',  N'Trần Quốc Tuấn', '2001-12-02', '0363148375', 'tranquoctuan@gmail.com', '045201879021', 0),
('CUS0000004',  N'Thủy Huyền Vũ', '1998-05-12', '0988816483', 'thuyhuyenvu@gmail.com', '027198919855', 1),
('CUS0000005',  N'Phong Bạch Hổ', '1998-01-18', '0378462148', 'phongbachho@gmail.com', '031198168002', 1),
('CUS0000006',  N'Lôi Thanh Long', '2000-02-06', '0363278678', 'loibachho@gmail.com', '001200290520', 1),
('CUS0000007',  N'Hỏa Chu Tước', '1987-03-12', '0776498513', 'hoachutuoc@gmail.com', '040187917782', 1),
('CUS0000008',  N'Kim Toan Nghê', '1992-12-22', '0124889765', 'kimtoannghe@gmail.com', '068092469285', 0),
('CUS0000009',  N'Nhạc Tù Ngưu', '1987-08-18', '0656742885', 'nhactunguu@gmail.com', '027087751759', 1),
('CUS0000010',  N'Thô Phủ Tiêu Đồ', '2005-10-21', '0343627232', 'thophutieudo@gmail.com', '001205694153', 0),
('CUS0000011',  N'Đỗ Bạch Trạch', '2002-01-14', '0964432958', 'dobachtrach@gmail.com', '052202248808', 0),
('CUS0000012',  N'Công Tôn Tố Nữ', '1996-11-11', '0312425678', 'congtontonu@gmail.com', '046196181078', 0);

insert into Employee
values
('EMP000001', N'Nguyễn Hữu Thọ', 1, '1992-09-23', N'Đà Nẵng', '0342637732', 'nguyenhuutho@gmail.com', '4'),
('EMP000002', N'Trần Đại Nghĩa', 1, '1982-06-12', N'Đà Nẵng', '0164432954', 'trandainghia@gmail.com', '4'),
('EMP000003', N'Võ Qui Huân', 1, '1989-12-27', N'Thừa Thiên Huế', '0776242784', 'voquihuan@gmail.com', '4'),
('EMP000004', N'Đinh Công Tráng', 1, '1989-02-02', N'Quảng Nam', '0964456823', 'dinhcongtrang@gmail.com', '4'),
('EMP000005', N'Võ Chí Công', 1, '1986-07-14', N'Quảng Nam', '0136892927', 'vochicong@gmail.com', '4'),
('EMP000006', N'Trưng Nữ Vương', 0, '1999-07-23', N'Đà Nẵng', '0988234582', 'trungnuvuong@gmail.com', '4'),
('EMP000007', N'Huyền Tôn Sinh Liên', 0, '1996-08-25', N'Thừa Thiên Huế', '0363012953', 'huyentonsinhlien@gmail.com', '4'),
('EMP000008', N'Hoàng Thị Loan', 0, '2000-05-26', N'Đà Nẵng', '0136321946', 'hoangthiloan@gmail.com', '4'),
('EMP000009', N'Tôn Đức Thắng', 1, '1984-11-12', N'Đà Nẵng', '0963241436', 'tonducthang@gmail.com', '4'),
('ADM000001', N'Nguyễn Bảo Trung', 1, '2000-05-26', N'Quảng Ngãi', '0913562870', 'trungnbde160410@fpt.edu.vn', '1'),
('ADM000002', N'Trần Đình Hiệu', 1, '2002-01-10', N'Thừa Thiên Huế', '0702662251', 'hieutdde160594@fpt.edu.vn', '1'),
('ADM000003', N'Trần Đình Quân', 1, '2002-0-26', N'Buôn Mê Thuột - Đắk Lắk', '0136321946', 'quantdde160067@fpt.edu.vn', '1'),
('MAN000001', N'Nguyễn Quang Bảo', 1, '2002-10-30', N'Đà Nẵng', '0702347748', 'baonqde160293@fpt.edu.vn', '2'),
('MAN000002', N'Nguyễn Công Thành', 1, '2001-08-15', N'Hà Tĩnh', '0363012495', 'thanhncde160490@fpt.edu.vn', '2');



