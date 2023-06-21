create database SapphireSands;
-- drop database SapphireSands;
use SapphireSands;

create table Account(
	accountID char(10) primary key,
    username char(50),
    password char(50),
    `role` int
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
    constraint fk_empId foreign key(empID) references Account(accountID)
);

create table `Order`(
	orderID char(10) primary key,
    empID char(10),
    cusID char(10),
    orDate date,
    orStatus int,
    constraint fk_empIdOrder foreign key(empID) references Employee(empID),
    constraint fk_cusIdOrder foreign key(cusID) references Customer(cusID)
);

create table Room(
	roomID char(10) primary key,
    roomName nvarchar(100),
    roomType int,
    maxPeople int,
    roomPrice decimal(10, 0),
    roomStatus int,
    roomDescipt nvarchar(1000),
    roomArea double,
    bedroom nvarchar(500),
    bathroom nvarchar(500),
    room_direction nvarchar(100)
);

create table HistoryPrice(	
	historyID char(10) primary key,
    roomID char(10),
    empID char(10),
	timeChange datetime,
	historyPriceRoom decimal(10,0),
    constraint fk_roomHistory foreign key(roomID) references Room(roomID)
);

create table Food(
	foodID char(10) primary key,
    foodName nvarchar(50),
    foodPrice decimal(10,0)
);

create table Service(
	serviceID char(10) primary key,
    serviceName nvarchar(50),
    servicePrice decimal(10,0)
);


ALTER TABLE Room ADD INDEX idx_room_id (roomID);

create table ContractDetail(
	contractID char(10) primary key,
	roomID char(10),
    orderID char(10),
    timeIn datetime,
    timOut datetime,
    people int,
    timeRegister datetime,
    constraint fk_order foreign key(orderID) references `Order`(orderID),
    constraint fk_room foreign key(roomID) references Room(roomID)
);


ALTER TABLE Food ADD INDEX idx_food_id (foodID);

create table OrderDetail(
	orderID char(10),
    foodID char(10),
    orTime datetime,
    Amount int,
    orStatus int,
    constraint fk_orderdt foreign key(orderID) references `Order`(orderID),
    constraint fk_fooddt foreign key(foodID) references Food(foodID)
);

ALTER TABLE Service ADD INDEX idx_service_id (serviceID);

create table ServiceDetail(
	orderID char(10),
    serviceID char(10),
    serviceTime datetime,
    Amount int,
    serviceStatus int,
    constraint fk_orderdtt foreign key(orderID) references `Order`(orderID),
    constraint fk_servicedt foreign key(serviceID) references Service(serviceID)
);



-- INSERT 
INSERT INTO Account (accountID, username, password, role)
VALUES 
('CUS000001', 'user1', '123', 0),
('CUS000002', 'user2', '123', 0),
('CUS000003', 'user3', '123', 0),
('CUS000004', 'user4', '123', 0),
('CUS000005', 'user5', '123', 0),
('CUS000006', 'user6', '123', 0),
('CUS000007', 'user7', '123', 0),
('CUS000008', 'user8', '123', 0),
('CUS000009', 'user9', '123', 0),
('CUS000010', 'user10', '123', 0),
('CUS000011', 'user11', '123', 0),
('CUS000012', 'user12', '123', 0),
('EMP000001', 'emp1', '234', 1),
('EMP000002', 'emp2', '234', 1),
('EMP000003', 'emp3', '234', 1),
('EMP000004', 'emp4', '234', 1),
('EMP000005', 'emp5', '234', 1),
('EMP000006', 'emp6', '234', 1),
('EMP000007', 'emp7', '234', 1),
('EMP000008', 'emp8', '234', 1),
('EMP000009', 'emp9', '234', 1),
('EMP000010', 'emp10', '234', 1),
('ADM000001', 'adm1', '345', 2),
('ADM000002', 'adm2', '345', 2),
('ADM000003', 'adm3', '345', 2),
('ADM000004', 'baoadmin', '123', 2),
('MAN000001', 'man1', '456', 3),
('MAN000002', 'man2', '456', 3),
('MAN000003', 'baomanager', '123', 3),
('System', 'systemauto', 'system', 1);

INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType)
VALUES
('CUS000001', 'Nguyễn Anh Thư', '2000-06-17', '0912017119', 'thunade170102@fpt.edu.vn', '49204004951', 1),
('CUS000002', 'Nguyễn Quang Đăng Khoa', '1999-02-18', '0867876188', 'khoanqdde160390@fpt.edu.vn', '49204005371', 2),
('CUS000003', 'Nguyễn Thị Bích Liên', '2002-08-02', '0356829925', 'lienntbde160471@fpt.edu.vn', '52204004284', 1),
('CUS000004', 'Nguyễn Thị Mỹ Duyên', '1998-08-25', '0358026576', 'duyenntmde160345@fpt.edu.vn', '49204000628', 2),
('CUS000005', 'Ngô Lê Thành', '1996-01-26', '0789453155', 'thanhnlds160044@fpt.edu.vn', '44204001198', 2),
('CUS000006', 'Ngô Xuân Duy', '1989-04-23', '0785130942', 'duynxda160051@fpt.edu.vn', '48203000268', 2),
('CUS000007', 'Hoàng Khánh Hoà', '1982-04-26', '0942528151', 'Hoahkde160202@fpt.edu.vn', '49204004430', 2),
('CUS000008', 'Hồ Phước Thuật', '2000-01-11', '0868350013', 'thuathpde160218@fpt.edu.vn', '49202008542', 1),
('CUS000009', 'Hồ Văn Lẹ', '1994-01-06', '0935011916', 'Lehvde160240@fpt.edu.vn', '48303001745', 2),
('CUS000010', 'Hoàng Thị Minh Hạnh', '1982-10-16', '0898350127', 'Hanhhtmde160147@fpt.edu.vn', '46304010259', 1),
('CUS000011', 'Hoàng Vũ Minh Anh', '2001-04-07', '0858089768', 'anhhvmde160399@fpt.edu.vn', '44204001279', 1),
('CUS000012', 'Khấu Trần Ngọc Thiệp', '2000-08-27', '0862210623', 'thiepktnde160439@fpt.edu.vn', '48303001765', 1);

INSERT INTO Employee (empID, empName, empGender, empDOB, empAdress, empPhone, empEmail) 
VALUES
('EMP000001', 'Nguyễn Tiến Thịnh ', 1, '1997-07-09', 'Hoà Hải, Ngũ Hành Sơn, Đà Nẵng', '0386751108', 'thinhntde160164@fpt.edu.vn'),
('EMP000002', 'Nguyễn Quốc Khánh', 1, '2000-08-25', 'Điện Ngọc, TX. Điện Bàn, Quảng Nam', '0858385631', 'khanhnqde160064@fpt.edu.vn'),
('EMP000003', 'Nguyễn Trần Nhật Huy', 1, '1998-10-07', 'Phường 4, TP Tuy Hòa, Phú Yên', '0794615827', 'huyntnde160554@fpt.edu.vn'),
('EMP000004', 'Nguyễn Văn Duy', 1, '2001-05-17', 'Tuyên Hóa, Quảng Bình', '0944202896', 'duynvde160530@fpt.edu.vn'),
('EMP000005', 'Tạ Quốc Thịnh', 1, '2003-10-27', 'Tam Quang, Núi Thành, Quảng Nam', '0943169134', 'thinhtqds160398@fpt.edu.vn'),
('EMP000006', 'Nguyễn Lương Trung', 1, '2002-12-12', 'Dương Thủy, Lệ Thủy, Quảng Bình', '0905870827', 'trungnlde170311@fpt.edu.vn'),
('EMP000007', 'Đặng Công Quang Duy', 1, '1999-02-08', 'Văn Xá, Kim Bảng, Hà Nam', '0903247260', 'duydcqde160583@fpt.edu.vn'),
('EMP000008', 'Bùi Văn Gia Phát', 1, '2000-02-19', 'Tịnh Sơn, Sơn Tịnh, Quảng Ngãi', '0848252524', 'phatbvgde160637@fpt.edu.vn'),
('EMP000009', 'Đinh Văn Toàn', 1, '2001-06-12', 'Quảng Điền, Thừa Thiên Huế', '0971312906', 'toandvde160603@fpt.edu.vn'),
('EMP000010', 'Đinh Nguyễn Bảo Hưng', 1, '2002-01-01', 'Mai Thủy, Lệ Thủy, Quảng Bình', '0763245667', 'hungdnbde160562@fpt.edu.vn'),
('ADM000001', 'Bùi Hoàng Ý', 0, '1996-07-05', 'Điện Nam Trung, Điện Bàn, Quảng Nam', '0981456014', 'ybhde160208@fpt.edu.vn'),
('ADM000002', 'Bùi Tuấn Dũng', 1, '1999-04-11', '680 Trần Hưng Đạo, TP Quy Nhơn, Bình Định', '0984043008', 'dungbtde160632@fpt.edu.vn'),
('ADM000003', 'Đinh Thị Cát Tường', 0, '2000-07-14', 'Bình Sa, Thăng Bình, Quảng Nam', '0903527646', 'tuongdtcde160533@fpt.edu.vn'),
('ADM000004', 'Nguyễn Quang Bảo', 1, '2002-10-30', 'Đà Nẵng, Việt Nam', '0702347748', 'baonqde160293@fpt.edu.vn'),
('MAN000001', 'Nguyễn Tuyết Nhi', 0, '1991-04-12', 'Hương Vinh, TX. Hương Trà, Thừa Thiên Huế', '096730307', 'nhintde160561@fpt.edu.vn'),
('MAN000002', 'Đinh Sỹ Quốc Việt', 1, '1992-06-17', 'Phổ Ninh, TX. Đức Phổ, Quảng Ngãi', '0961103209', 'vietdsqde160184@fpt.edu.vn'),
('MAN000003', 'Nguyễn Quang Bảo', 1, '2002-10-30', 'Đà Nẵng, Việt Nam', '0702347748', 'baonqde160293@fpt.edu.vn'),
('System', 'System', 1, '2002-10-30', 'Đà Nẵng, Việt Nam', '0702347745', 'employeesystem@system.vn');

INSERT INTO `Order` (orderID, empID, cusID, orDate, orStatus)
VALUES
('OD000001', 'EMP000001', 'CUS000001', '2023-05-21 10:30:44', 0),
('OD000002', 'EMP000001', 'CUS000002', '2023-05-30 08:00:44', 0),
('OD000003', 'EMP000003', 'CUS000003', '2023-06-03 06:00:26', 0),
('OD000004', 'EMP000002', 'CUS000004', '2023-05-31 17:12:36', 0),
('OD000005', 'System', 'CUS000006', '2023-05-31 17:12:36', 0);
    
INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) 
VALUES
('R000001', 'Phòng Resort Classic Hướng Biển', '1', '4', '300000000', '0', 'Nghỉ dưỡng trong căn phòng Classic đầy cảm hứng mang phong cách kết hợp tuyệt vời giữa nét văn hóa Việt Nam truyền thống và kiến trúc đương đại. Tận hưởng những làn gió biển trong không gian rộng rãi trong nhà – ngoài trời và những phút giây thư giãn tuyệt đối trong bồn tắm bằng đá cẩm thạch và giường cỡ lớn (King hoặc Queen) êm ái. Không gian rộng mở của ban công riêng là địa điểm hoàn hảo để cùng bạn bè thưởng thức những loại đồ uống ngon trong lúc hòa mình vào những tiếng sóng vỗ rì rào đầy thơ mộng của đại dương.', '120', 'Giường King hoặc 2 giường đơn', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Vườn và biển'),
('R000002', 'Phòng Resort Classic Toàn Cảnh Biển', '1', '4', '320000000', '0', 'Lấy cảm hứng thiết kế từ văn hóa truyền thống Việt Nam với không gian mở ra thiên nhiên khoáng đạt, phòng Resort Classic Toàn Cảnh Biển chào đón bạn đến với khung cảnh núi rừng, khoảng vườn xanh mát và đại dương mênh mông. Thả mình thư giãn trên chiếc giường King hay Queen êm ái, trải nghiệm những giây phút gắn kết với gia đình trong không gian rộng rãi trong nhà – ngoài trời.', '90', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Panoramic vistas of the mountains, gardens and sea'),
('R000003', 'Phòng Terrace Suite Hướng Biển', '2', '4', '400000000', '0', 'Trải nghiệm căn phòng suite rộng rãi được thiết kế khoáng đạt đón nắng gió vào trong không gian nghỉ dưỡng hoàn hảo. Cùng với ban công rộng rãi, Classic Terrace Suite là lựa chọn tuyệt vời để trò chuyện, đọc sách hay đơn giản là để thư giãn ngắm nhìn vịnh biển.', '80', 'Phòng ngủ giường King, được trang bị Tivi màn hình phẳng và lối đi ra khu vực ngoài trời.', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Vườn và biển'),
('R000004', 'Club Terrace Suite Toàn Cảnh Biển', '2', '4', '435000000', '0', 'Tận hưởng đặc quyền thượng lưu Club Sapphire Sands của hạng phòng sở hữu không gian trong nhà – ngoài trời rộng rãi. Thiết kế nội thất sống động, tầm nhìn toàn cảnh ra vịnh biển và núi rừng từ ban công riêng, và chỉ cách biển vài bước chân. Terrace Suite hứa hẹn mang đến cho bạn một kỳ nghỉ tràn đầy cảm hứng và những trải nghiệm tuyệt vời.', '150', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm lớn với bàn trang điểm đôi, vòi hoa sen và bồn tắm lát đá cẩm thạch tách biệt.', 'Tầm nhìn 180 độ ra vịnh biển và rừng nhiệt đới'),
('R000005', 'Penthouse Một Phòng Ngủ Hướng Biển', '3', '4', '620000000', '0', 'Nghỉ dưỡng đẳng cấp tại tầng cao nhất của khu nghỉ dưỡng với sân vườn trên ban công và hồ bơi riêng hướng tầm nhìn tuyệt vời ra rừng nhiệt đới và vịnh biển riêng. Đặc biệt thiết kế cửa kính ba mặt nối từ sàn đến trần nhà của căn phòng tạo sự kết nối đặc sắc giữa phong cách nội thất sống động của căn phòng với ánh nắng rực rỡ trên Bán đảo Sơn Trà. Những chiếc đèn chùm Hội An, giường ngủ có màn che và các bức tranh vẽ rực rỡ là điểm nhấn khiến cho kỳ nghỉ dưỡng tại Penthouse tràn đầy cảm hứng.', '170', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm phong cách với bàn trang điểm đôi, khu vực trang điểm và thay đồ cùng bồn tắm cỡ lớn', 'Tầm nhìn tuyệt vời ra vịnh biển riêng và rừng nhiệt đới.'),
('R000006', 'Biệt Thự Một Phòng Ngủ Cạnh Biển', '3', '4', '600000000', '0', 'Chỉ cách bãi biển vài bước chân, Biệt Thự Cạnh Biển mang đến cho bạn một kỳ nghỉ riêng tư tuyệt đối. Hãy cảm nhận tiếng sóng vỗ, làn gió biển xào xác trong tán lá dừa, tận hưởng những phút giây thư giãn trên sân hiên riêng, hồ bơi vô cực riêng, khu để thưởng thức ẩm thực ngoài trời và chiếc ghế xích đu phong cách. Phòng ngủ của biệt thự được thiết kế mang những nét tính cách riêng với chiếc giường sofa êm ái.', '145', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm riêng với bàn trang điểm đôi, khu vực thay quần áo, vòi sen và bồn tắm tách biệt', 'Biển và bãi biển'),
('R000007', 'Biệt Thự Một Phòng Ngủ trên Ghềnh Đá Cạnh Biển', '3', '4', '700000000', '0', 'Hãy thư giãn và lắng nghe tiếng sóng biển thì thầm bên tai, đọc sách bên sân hiên ngoài trời, trải nghiệm hồ bơi vô cực và thưởng thức bữa tối lãng mạn dưới những vì sao. Phòng ngủ của biệt thự được thiết kế với trần cao, góc thư giãn riêng với giường sofa lớn tại không gian nghỉ dưỡng thật thoải mái. Nếu bạn đang tìm kiếm chốn nghỉ dưỡng riêng tư, bỏ lại sau lưng những bận rộn của phố thị, biệt thự trên ghềnh đá của chúng tôi là sự lựa chọn hoàn hảo.', '220', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm riêng với bàn trang điểm đôi, khu vực thay quần áo, vòi sen và bồn tắm tách biệt', 'Tầm nhìn hướng biển'),
('R000008', 'Biệt Thự Một Phòng Ngủ Spa Lagoon', '3', '4', '730000000', '0', 'Đắm mình thư giãn trong thiên nhiên yên bình hoang sơ thuộc khu đầm phá Spa của chúng tôi. Với thiết kế đặc biệt khi đặt phòng trị liệu trong biệt thự với bồn sục Jacuzzi riêng cùng hai ban công trên mặt nước, biệt thự Spa Lagoon là lựa chọn không thể tuyệt vời hơn cho kỳ nghỉ dưỡng xua tan mọi căng thẳng ưu tư. Tận hưởng sự thanh bình tuyệt đối trong khuôn viên vườn với vòi tắm hoa sen ngoài trời hoặc trong bồn tắm hình kén được thiết kế riêng duy nhất dành cho biệt thự Spa Lagoon.', '260', 'Phòng ngủ trên mặt nước với giường King êm ái.', 'Phòng tắm kiểu spa bao gồm bàn trang điểm đôi, khu vực thay đồ, vòi sen và bồn tắm tách biệt', 'Núi rừng và đầm phá'),
('R000009', 'Biệt Thự Hai Phòng Ngủ trên Ghềnh Đá Cạnh Biển', '3', '6', '800000000', '0', 'Tầng 3 được thiết kế với sân hiên ngoài trời rộng rãi cùng khu vực giải trí âm thực, hồ bơi riêng tư và phòng ngủ giường King đầy phong cách. Ở tầng dưới, bạn sẽ khám phá phòng ngủ thứ hai của biệt thự với không gian ngoài trời riêng tư. Tầng cuối là sân hiên rộng rãi với ghế ngồi thoải mái để bạn có thể giao lưu, nghỉ ngơi hoặc đơn giản chỉ để ngắm nhìn từng đợt sóng tung bọt biển trắng xóa.', '450', 'Phòng ngủ chính giường King thuộc tầng trên, khu vực giải trí được trang bị Tivi và giường sofa lớn.', 'Hai phòng tắm riêng với bàn trang điểm đôi, khu vực thay đồ, vòi sen và bồn tắm tách biệt', 'Tầm nhìn bao trọn vịnh biển'),
('R000010', 'Biệt Thự Hai Phòng Ngủ Hoàng Gia Royal Residence Cạnh Biển', '3', '10', '900000000', '0', 'Một trải nghiệm tinh tế và đầy cảm hứng đang chờ đợi bạn tại không gian nghỉ dưỡng đẳng cấp trong biệt thự Hoàng gia của chúng tôi. Biệt Thự gồm 2 tầng, 2 phòng ngủ sẽ mang đến những đặc quyền và sự riêng tư tuyệt đối. Phòng khách được thiết kế với cây đàn piano, một quầy bar và phòng đa phương tiện riêng biệt với dàn karaoke cho hoạt động thư giãn và giải trí. Phòng ăn được thiết kế nổi trên mặt vịnh biển, được kết nối với phòng khách bằng lối đi nhỏ lát đá có mái che độc đáo.', '450', '2 giường King, một giường trẻ em được kê thêm trong phòng ngủ tầng dưới', 'Hai phòng tắm riêng đầy đủ tiện nghi', 'Tầm nhìn bao trọn cảnh biển'),
('R000011', 'Biệt Thự Hai Phòng Ngủ Sun Peninsula Residence Cạnh Biển', '3', '12', '1500000000', '0', 'Mỗi biệt thự sườn đồi ba phòng ngủ hướng biển có bể bơi của chúng tôi đều là nơi phô diễn kỹ nghệ tinh xảo của các nghệ nhân địa phương, với các phòng được thiết kế đẹp mắt thể hiện sự chăm chút đến từng chi tiết nhỏ của mĩ nghệ Việt Nam. Biệt thự rộng 260 mét vuông này có phòng khách rộng rãi, bể bơi lớn, bể sục, phòng ăn, phòng bếp và ba phòng ngủ sang trọng, mỗi phòng đều có phòng tắm riêng. Đây sẽ là tổ ấm thứ hai cho các gia đình và nhóm bạn bè.', '800', 'Gồm 1 phòng ngủ giường đơn và 1 phòng ngủ giường đôi giường King được kê thêm trong phòng ngủ tầng dưới', 'Hai phòng tắm riêng đầy đủ tiện nghi', 'HƯỚNG ĐẠI DƯƠNG'),
('R000012', 'Biệt Thự Ba Phòng Ngủ Sun Peninsula Residence Cạnh Biển', '3', '12', '1700000000', '0', 'Nghỉ dưỡng cao cấp tại biệt thự Sun Peninsula Residence được xây dựng bên sườn núi Sơn Trà, tựa lưng vào rừng nhiệt đới. Nếu muốn dạo bộ trên bãi biển riêng, bạn có thể đi bộ qua chiếc cầu thang gỗ dài được nối riêng trực tiếp với biệt thự. Sau một buổi chiều thỏa thích bơi lội trong hai hồ bơi vô cực, hãy cùng gia đình và bạn bè quây quần bên nhau, thưởng thức ẩm thực tinh tế với tầm nhìn 180 độ ra vịnh biển và thiên nhiên tươi xanh. Với thiết kế khoáng đạt và hiện đại, Biệt thự Ba Phòng Ngủ Sun Peninsula Residence Cạnh Biển mang đến không gian sống ngoài trời đầy mơ ước với khu vườn riêng xanh mát, khu vực tắm vòi hoa sen ngoài trời và sân hiên tắm nắng rộng lớn.', '1000', '3 phòng ngủ, mỗi phòng được thiết kế với phòng thay đồ và phòng tắm riêng', 'Ba phòng tắm đầy đủ tiện nghi với bồn tắm lớn bằng đá cẩm thạch và vòi sen', 'Tầm nhìn bao trọn vịnh biển và rừng nhiệt đới.'),
('R000013', 'Biệt Thự Ba Phòng Ngủ Vịnh Bãi Bắc Hướng Biển', '3', '10', '1200000000', '0', 'Nằm ẩn mình trên sườn núi hoang sơ của bán đảo Sơn Trà, biệt thự Vịnh Bãi Bắc mang đến một không gian nghỉ dưỡng cao cấp và riêng tư nhất trong các loại biệt thự của chúng tôi với tầm nhìn bao quát ra vịnh biển riêng và phong cách thiết kế độc đáo. Đặc biệt, căn biệt thự bao gồm 3 phòng ngủ, mỗi khu vực đều có mái hiên nằm tắm nắng với hồ bơi riêng. Được thiết kế bởi Kiến trúc sư lừng danh thế giới Bill Bensley, căn biệt thự là sự kết hợp hoàn hảo giữa phong cách kiến trúc kiểu thực dân với tông màu trắng đen chủ đạo pha trộn cùng những gam màu sống động, rực rỡ khơi gợi nét nghệ thuật hậu hiện đại, mang lại không gian sống tui tươi rực rỡ.', '500', '3 phòng ngủ (2 giường cỡ king, 1 giường đôi), mỗi phòng ngủ được thiết kế với phòng thay đồ và phòng tắm riêng.', 'Ba phòng tắm đầy đủ tiện nghi với bồn tắm lớn bằng đá cẩm thạch và vòi sen', 'Tầm nhìn bao trọn vịnh biển và rừng nhiệt đới.'),
('R000014', 'Biệt thự 4 phòng ngủ với hồ bơi riêng', '3', '12', '400000000', '0', 'Quý khách sẽ vô cùng thích thú và thỏa sức thăng hoa cảm xúc cùng gia đình và bạn bè trong một không gian mở hiện đại và đẳng cấp của một biệt thự hai tầng, bốn phòng ngủ đầy đủ tiện nghi ngay tại Tầng Mặt đất (Earth) của Khu nghỉ dưỡng. Với thiết kế ngắm trọn toàn cảnh bãi cát trắng mịn, đại dương xanh thẳm và núi rừng kỳ vĩ, không gian ban công thoáng đãng và mát mẻ chính là một chọn lựa lý tưởng để thả mình và cảm nhận trọn vẹn từng khoảnh khắc an yên, bên cạnh đó thư giãn cùng làn nước mát rượi tại một trong ba hồ bơi của khu biệt thự cũng là một lựa chọn khác không kém phần hấp dẫn.', '705', 'Bốn phòng ngủ, mỗi phòng đều có phòng khách thoáng đãng ngắm toàn cảnh đại dương xanh mát kết hợp cùng phòng tắm riêng với bồn tắm lớn', 'Phòng tắm mở nhưng riêng tư kết hợp cùng vòi hoa sen và bồn tắm lớn sang trọng, đón nhận toàn bộ ánh sáng thiên nhiên ấm áp', 'Ngắm trọn cảnh biển trong xanh, bãi cát trắng và núi rừng kỳ vĩ');

INSERT INTO Food (foodID, foodName, foodPrice)
VALUES
('F000001', 'Cá Phile Sốt Chanh Dây', 699000),
('F000002', 'Cơm Chiên Hải Sản', 120000),
('F000003', 'Gỏi Củ Hủ Dừa Tôm Thịt', 300000),
('F000004', 'Sườn Nấu Pate Pháp', 1500000),
('F000005', 'Tôm Càng Nướng Phô Mai', 2750000),
('F000006', 'Tôm Sú Nướng Muối Ớt', 1700000),
('F000007', 'Giò Heo Muối Chiên Giòn', 1500000),
('F000008', 'Cá Mú Hấp HongKong', 3600000),
('F000009', 'Rau Câu Trái Cây', 449000),
('F000010', 'Tôm Sú Cháy Tỏi', 2170000),
('F000011', 'Cá Tầm Nướng Muối Ớt', 2600000),
('F000012', 'Gỏi Bò Bóp Thấu', 1750000),
('F000013', 'Mực Chiên Giòn', 1960000),
('F000014', 'Tôm Sú Hoàng Kim', 2960000),
('F000015', 'Gà Mái Dầu Nướng Muối Ớt', 1200000),
('F000016', 'Mực Sữa Chiên Nước Mắm', 1600000),
('F000017', 'Lẩu Nấm Hải Sản – Mì Sợi', 17500000),
('F000018', 'Lòng Da Thịt Tái Chanh', 850000),
('F000019', 'Lẩu Hầm Sả', 1960000),
('F000020', 'Lẩu Gà Tiềm Ớt Hiểm', 2640000);
    
INSERT INTO OrderDetail (orderID, foodID, orTime, Amount, orStatus)
VALUES 
('OD000001', 'F000003', '2023-06-17 06:43:27.13', 2, 0),
('OD000001', 'F000005', '2023-06-17 06:43:27.14', 1, 0),
('OD000001', 'F000009', '2023-06-17 06:43:27.15', 3, 0),
('OD000002', 'F000005', '2023-06-17 22:43:27.16', 2, 0),
('OD000002', 'F000014', '2023-06-17 22:43:27.17', 3, 0),
('OD000002', 'F000016', '2023-06-17 22:43:27.18', 1, 0),
('OD000002', 'F000018', '2023-06-17 22:43:27.19', 4, 0),
('OD000003', 'F000001', '2023-06-17 22:43:27.20', 1, 0),
('OD000003', 'F000004', '2023-06-17 22:43:27.21', 3, 0),
('OD000003', 'F000011', '2023-06-17 22:43:27.22', 2, 0),
('OD000004', 'F000015', '2023-06-17 22:43:27.23', 1, 0),
('OD000004', 'F000006', '2023-06-17 22:43:27.24', 2, 0),
('OD000004', 'F000008', '2023-06-17 22:43:27.25', 1, 0),
('OD000004', 'F000012', '2023-06-17 22:43:27.26', 3, 0);
    
INSERT INTO Service (serviceID, serviceName, servicePrice)
VALUES 
('SV000001', 'Dịch vụ Karaoke', 100000),
('SV000002', 'Dịch vụ Massage', 150000),
('SV000003', 'Dịch vụ thể thao', 120000),
('SV000004', 'Dịch vụ Hồ Bơi', 180000),
('SV000005', 'Dịch vụ Xông hơi', 130000),
('SV000006', 'Dịch vụ suối nước nóng', 110000),
('SV000007', 'Dịch vụ Tổ chức tiệc', 140000),
('SV000008', 'Dịch vụ Tắm bùn', 160000);

INSERT INTO ServiceDetail (orderID, serviceID, serviceTime, Amount, serviceStatus)
VALUES 
('OD000001', 'SV000002', '2023-06-17 22:39:08.961', 4, 0),
('OD000001', 'SV000007', '2023-06-17 22:40:19.351', 1, 0),
('OD000001', 'SV000003', '2023-06-17 22:40:20.352', 5, 0),
('OD000002', 'SV000007', '2023-06-17 22:40:21.353', 4, 0),
('OD000002', 'SV000002', '2023-06-17 22:40:22.354', 4, 0),
('OD000003', 'SV000006', '2023-06-17 22:40:23.355', 3, 0),
('OD000004', 'SV000003', '2023-06-17 22:40:24.356', 2, 0),
('OD000004', 'SV000002', '2023-06-17 22:41:19.357', 2, 0),
('OD000005', 'SV000001', '2023-06-17 22:43:19.358', 3, 0),
('OD000005', 'SV000003', '2023-06-17 22:45:19.359', 1, 0),
('OD000005', 'SV000002', '2023-06-17 22:48:19.360', 4, 0),
('OD000005', 'SV000008', '2023-06-17 22:50:19.361', 5, 0),
('OD000003', 'SV000007', '2023-06-17 22:53:19.362', 3, 0),
('OD000002', 'SV000002', '2023-06-17 22:58:19.363', 2, 0),
('OD000004', 'SV000003', '2023-06-17 22:59:19.364', 2, 0),
('OD000004', 'SV000002', '2023-06-17 23:10:19.365', 3, 0),
('OD000002', 'SV000001', '2023-06-17 23:40:19.366', 1, 0),
('OD000003', 'SV000007', '2023-06-17 23:45:19.367', 1, 0),
('OD000004', 'SV000003', '2023-06-18 02:49:19.368', 4, 0),
('OD000005', 'SV000002', '2023-06-18 05:40:19.369', 5, 0),
('OD000001', 'SV000007', '2023-06-18 06:30:19.370', 4, 0);
    
-- Select * from Table
Select * from Account;
Select * from Employee;
Select * from Customer;
Select * from `Order`;
Select * from Room;
Select * from Food;
Select * from OrderDetail;
Select * from Service;
Select * from ServiceDetail;
    
    
    
    
    
    
    














    
    
    
    
    
    
    
    
    
-- SELECT accountID FROM account WHERE accountID LIKE 'CUS%' ORDER BY accountID DESC LIMIT 1;
-- select * from account;
-- select * from Customer;
-- SELECT * FROM Account JOIN Customer ON accountID = cusID where accountID='CUS000013' ; 
-- SELECT * FROM Account JOIN Customer ON Account.accountID = Customer.cusID WHERE username = 'user1' AND password = '123';

    
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000001', 'user1', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000002', 'user2', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000003', 'user3', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000004', 'user4', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000005', 'user5', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000006', 'user6', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000007', 'user7', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000008', 'user8', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000009', 'user9', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000010', 'user10', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000011', 'user11', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('CUS000012', 'user12', '123', 0);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000001', 'emp1', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000002', 'emp2', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000003', 'emp3', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000004', 'emp4', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000005', 'emp5', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000006', 'emp6', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000007', 'emp7', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000008', 'emp8', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000009', 'emp9', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('EMP000010', 'emp10', '234', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('ADM000001', 'adm1', '345', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('ADM000002', 'adm2', '345', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('ADM000003', 'adm3', '345', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('MAN000001', 'man1', '456', 1);
-- INSERT INTO Account (accountID, username, password, role) VALUES ('MAN000002', 'man2', '456', 1);

-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000001', 'Nguyễn Anh Thư ', '2000-06-17', '0912017119', 'thunade170102@fpt.edu.vn', '49204004951', '1');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000002', 'Nguyễn Quang Đăng Khoa ', '1999-02-18', '0867876188', 'khoanqdde160390@fpt.edu.vn', '49204005371', '2');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000003', 'Nguyễn Thị Bích Liên ', '2002-08-02', '0356829925', 'lienntbde160471@fpt.edu.vn', '52204004284', '1');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000004', 'Nguyễn Thị Mỹ Duyên ', '1998-08-25', '0358026576', 'duyenntmde160345@fpt.edu.vn', '49204000628', '2');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000005', 'Ngô Lê Thành ', '1996-01-26', '0789453155', 'thanhnlds160044@fpt.edu.vn', '44204001198', '2');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000006', 'Ngô Xuân Duy', '1989-04-23', '0785130942', 'duynxda160051@fpt.edu.vn', '48203000268', '2');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000007', 'Hoàng Khánh Hoà', '1982-04-26', '0942528151', 'Hoahkde160202@fpt.edu.vn', '49204004430', '2');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000008', 'Hồ Phước Thuật', '2000-01-11', '0868350013', 'thuathpde160218@fpt.edu.vn', '49202008542', '1');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000009', 'Hồ Văn Lẹ', '1994-01-06', '0935011916', 'Lehvde160240@fpt.edu.vn', '48303001745', '2');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000010', 'Hoàng Thị Minh Hạnh', '1982-10-16', '0898350127', 'Hanhhtmde160147@fpt.edu.vn', '46304010259', '1');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000011', 'Hoàng Vũ Minh Anh', '2001-04-07', '0858089768', 'anhhvmde160399@fpt.edu.vn', '44204001279', '1');
-- INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) VALUES ('CUS000012', 'Khấu Trần Ngọc Thiệp', '2000-08-27', '0862210623', 'thiepktnde160439@fpt.edu.vn', '48303001765', '1');


-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000001', 'Phòng Resort Classic Hướng Biển', 1, '4', '300000000', 0, 'Nghỉ dưỡng trong căn phòng Classic đầy cảm hứng mang phong cách kết hợp tuyệt vời giữa nét văn hóa Việt Nam truyền thống và kiến trúc đương đại. Tận hưởng những làn gió biển trong không gian rộng rãi trong nhà – ngoài trời và những phút giây thư giãn tuyệt đối trong bồn tắm bằng đá cẩm thạch và giường cỡ lớn (King hoặc Queen) êm ái. Không gian rộng mở của ban công riêng là địa điểm hoàn hảo để cùng bạn bè thưởng thức những loại đồ uống ngon trong lúc hòa mình vào những tiếng sóng vỗ rì rào đầy thơ mộng của đại dương.', '120', 'Giường King hoặc 2 giường đơn', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Vườn và biển');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000002', 'Phòng Resort Classic Toàn Cảnh Biển', 1, '4', '320000000', 0, 'Lấy cảm hứng thiết kế từ văn hóa truyền thống Việt Nam với không gian mở ra thiên nhiên khoáng đạt, phòng Resort Classic Toàn Cảnh Biển chào đón bạn đến với khung cảnh núi rừng, khoảng vườn xanh mát và đại dương mênh mông. Thả mình thư giãn trên chiếc giường King hay Queen êm ái, trải nghiệm những giây phút gắn kết với gia đình trong không gian rộng rãi trong nhà – ngoài trời.', '90', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Panoramic vistas of the mountains, gardens and sea');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000003', 'Phòng Terrace Suite Hướng Biển', 2, '4', '400000000', 0, 'Trải nghiệm căn phòng suite rộng rãi được thiết kế khoáng đạt đón nắng gió vào trong không gian nghỉ dưỡng hoàn hảo. Cùng với ban công rộng rãi, Classic Terrace Suite là lựa chọn tuyệt vời để trò chuyện, đọc sách hay đơn giản là để thư giãn ngắm nhìn vịnh biển.', '80', 'Phòng ngủ giường King, được trang bị Tivi màn hình phẳng và lối đi ra khu vực ngoài trời.', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Vườn và biển');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000004', 'Club Terrace Suite Toàn Cảnh Biển', 2, '4', '435000000', 0, 'Tận hưởng đặc quyền thượng lưu Club Sapphire Sands của hạng phòng sở hữu không gian trong nhà – ngoài trời rộng rãi. Thiết kế nội thất sống động, tầm nhìn toàn cảnh ra vịnh biển và núi rừng từ ban công riêng, và chỉ cách biển vài bước chân. Terrace Suite hứa hẹn mang đến cho bạn một kỳ nghỉ tràn đầy cảm hứng và những trải nghiệm tuyệt vời.', '150', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm lớn với bàn trang điểm đôi, vòi hoa sen và bồn tắm lát đá cẩm thạch tách biệt.', 'Tầm nhìn 180 độ ra vịnh biển và rừng nhiệt đới');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000005', 'Penthouse Một Phòng Ngủ Hướng Biển', 3, '4', '620000000', 0, 'Nghỉ dưỡng đẳng cấp tại tầng cao nhất của khu nghỉ dưỡng với sân vườn trên ban công và hồ bơi riêng hướng tầm nhìn tuyệt vời ra rừng nhiệt đới và vịnh biển riêng. Đặc biệt thiết kế cửa kính ba mặt nối từ sàn đến trần nhà của căn phòng tạo sự kết nối đặc sắc giữa phong cách nội thất sống động của căn phòng với ánh nắng rực rỡ trên Bán đảo Sơn Trà. Những chiếc đèn chùm Hội An, giường ngủ có màn che và các bức tranh vẽ rực rỡ là điểm nhấn khiến cho kỳ nghỉ dưỡng tại Penthouse tràn đầy cảm hứng.', '170', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm phong cách với bàn trang điểm đôi, khu vực trang điểm và thay đồ cùng bồn tắm cỡ lớn', 'Tầm nhìn tuyệt vời ra vịnh biển riêng và rừng nhiệt đới.');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000006', 'Biệt Thự Một Phòng Ngủ Cạnh Biển', 3, '4', '600000000', 0, 'Chỉ cách bãi biển vài bước chân, Biệt Thự Cạnh Biển mang đến cho bạn một kỳ nghỉ riêng tư tuyệt đối. Hãy cảm nhận tiếng sóng vỗ, làn gió biển xào xác trong tán lá dừa, tận hưởng những phút giây thư giãn trên sân hiên riêng, hồ bơi vô cực riêng, khu để thưởng thức ẩm thực ngoài trời và chiếc ghế xích đu phong cách. Phòng ngủ của biệt thự được thiết kế mang những nét tính cách riêng với chiếc giường sofa êm ái.', '145', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm riêng với bàn trang điểm đôi, khu vực thay quần áo, vòi sen và bồn tắm tách biệt', 'Biển và bãi biển');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000007', 'Biệt Thự Một Phòng Ngủ trên Ghềnh Đá Cạnh Biển', 3, '4', '700000000', 0, 'Hãy thư giãn và lắng nghe tiếng sóng biển thì thầm bên tai, đọc sách bên sân hiên ngoài trời, trải nghiệm hồ bơi vô cực và thưởng thức bữa tối lãng mạn dưới những vì sao. Phòng ngủ của biệt thự được thiết kế với trần cao, góc thư giãn riêng với giường sofa lớn tại không gian nghỉ dưỡng thật thoải mái. Nếu bạn đang tìm kiếm chốn nghỉ dưỡng riêng tư, bỏ lại sau lưng những bận rộn của phố thị, biệt thự trên ghềnh đá của chúng tôi là sự lựa chọn hoàn hảo.', '220', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm riêng với bàn trang điểm đôi, khu vực thay quần áo, vòi sen và bồn tắm tách biệt', 'Tầm nhìn hướng biển');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000008', 'Biệt Thự Một Phòng Ngủ Spa Lagoon', 3, '4', '730000000', 0, 'Đắm mình thư giãn trong thiên nhiên yên bình hoang sơ thuộc khu đầm phá Spa của chúng tôi. Với thiết kế đặc biệt khi đặt phòng trị liệu trong biệt thự với bồn sục Jacuzzi riêng cùng hai ban công trên mặt nước, biệt thự Spa Lagoon là lựa chọn không thể tuyệt vời hơn cho kỳ nghỉ dưỡng xua tan mọi căng thẳng ưu tư. Tận hưởng sự thanh bình tuyệt đối trong khuôn viên vườn với vòi tắm hoa sen ngoài trời hoặc trong bồn tắm hình kén được thiết kế riêng duy nhất dành cho biệt thự Spa Lagoon.', '260', 'Phòng ngủ trên mặt nước với giường King êm ái.', 'Phòng tắm kiểu spa bao gồm bàn trang điểm đôi, khu vực thay đồ, vòi sen và bồn tắm tách biệt"', 'Núi rừng và đầm phá');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000009', 'Biệt Thự Hai Phòng Ngủ trên Ghềnh Đá Cạnh Biển', 3, '6', '800000000', 0, 'Tầng 3 được thiết kế với sân hiên ngoài trời rộng rãi cùng khu vực giải trí âm thực, hồ bơi riêng tư và phòng ngủ giường King đầy phong cách. Ở tầng dưới, bạn sẽ khám phá phòng ngủ thứ hai của biệt thự với không gian ngoài trời riêng tư. Tầng cuối là sân hiên rộng rãi với ghế ngồi thoải mái để bạn có thể giao lưu, nghỉ ngơi hoặc đơn giản chỉ để ngắm nhìn từng đợt sóng tung bọt biển trắng xóa.', '450', 'Phòng ngủ chính giường King thuộc tầng trên, khu vực giải trí được trang bị Tivi và giường sofa lớn.', 'Hai phòng tắm riêng với bàn trang điểm đôi, khu vực thay đồ, vòi sen và bồn tắm tách biệt"', 'Tầm nhìn bao trọn vịnh biển');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000010', 'Biệt Thự Hai Phòng Ngủ Hoàng Gia Royal Residence Cạnh Biển', 3, '10', '900000000', 0, 'Một trải nghiệm tinh tế và đầy cảm hứng đang chờ đợi bạn tại không gian nghỉ dưỡng đẳng cấp trong biệt thự Hoàng gia của chúng tôi. Biệt Thự gồm 2 tầng, 2 phòng ngủ sẽ mang đến những đặc quyền và sự riêng tư tuyệt đối. Phòng khách được thiết kế với cây đàn piano, một quầy bar và phòng đa phương tiện riêng biệt với dàn karaoke cho hoạt động thư giãn và giải trí. Phòng ăn được thiết kế nổi trên mặt vịnh biển, được kết nối với phòng khách bằng lối đi nhỏ lát đá có mái che độc đáo.', '450', '2 giường King, một giường trẻ em được kê thêm trong phòng ngủ tầng dưới', 'Hai phòng tắm riêng đầy đủ tiện nghi', 'Tầm nhìn bao trọn cảnh biển');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000011', 'Biệt Thự Hai Phòng Ngủ Sun Peninsula Residence Cạnh Biển', 3, '12', '1500000000', 0, 'Mỗi biệt thự sườn đồi ba phòng ngủ hướng biển có bể bơi của chúng tôi đều là nơi phô diễn kỹ nghệ tinh xảo của các nghệ nhân địa phương, với các phòng được thiết kế đẹp mắt thể hiện sự chăm chút đến từng chi tiết nhỏ của mĩ nghệ Việt Nam. Biệt thự rộng 260 mét vuông này có phòng khách rộng rãi, bể bơi lớn, bể sục, phòng ăn, phòng bếp và ba phòng ngủ sang trọng, mỗi phòng đều có phòng tắm riêng. Đây sẽ là tổ ấm thứ hai cho các gia đình và nhóm bạn bè.', '800', 'Gồm 1 phòng ngủ giường đơn và 1 phòng ngủ giường đôi giường King được kê thêm trong phòng ngủ tầng dưới', 'Hai phòng tắm riêng đầy đủ tiện nghi', 'HƯỚNG ĐẠI DƯƠNG');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000012', 'Biệt Thự Ba Phòng Ngủ Sun Peninsula Residence Cạnh Biển', 3, '12', '1700000000', 0, 'Nghỉ dưỡng cao cấp tại biệt thự Sun Peninsula Residence được xây dựng bên sườn núi Sơn Trà, tựa lưng vào rừng nhiệt đới. Nếu muốn dạo bộ trên bãi biển riêng, bạn có thể đi bộ qua chiếc cầu thang gỗ dài được nối riêng trực tiếp với biệt thự. Sau một buổi chiều thỏa thích bơi lội trong hai hồ bơi vô cực, hãy cùng gia đình và bạn bè quây quần bên nhau, thưởng thức ẩm thực tinh tế với tầm nhìn 180 độ ra vịnh biển và thiên nhiên tươi xanh. Với thiết kế khoáng đạt và hiện đại, Biệt thự Ba Phòng Ngủ Sun Peninsula Residence Cạnh Biển mang đến không gian sống ngoài trời đầy mơ ước với khu vườn riêng xanh mát, khu vực tắm vòi hoa sen ngoài trời và sân hiên tắm nắng rộng lớn.', '1000', '3 phòng ngủ, mỗi phòng được thiết kế với phòng thay đồ và phòng tắm riêng', 'Ba phòng tắm đầy đủ tiện nghi với bồn tắm lớn bằng đá cẩm thạch và vòi sen', 'Tầm nhìn bao trọn vịnh biển và rừng nhiệt đới.');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000013', 'Biệt Thự Ba Phòng Ngủ Vịnh Bãi Bắc Hướng Biển', 3, '10', '1200000000', 0, 'Nằm ẩn mình trên sườn núi hoang sơ của bán đảo Sơn Trà, biệt thự Vịnh Bãi Bắc mang đến một không gian nghỉ dưỡng cao cấp và riêng tư nhất trong các loại biệt thự của chúng tôi với tầm nhìn bao quát ra vịnh biển riêng và phong cách thiết kế độc đáo. Đặc biệt, căn biệt thự bao gồm 3 phòng ngủ, mỗi khu vực đều có mái hiên nằm tắm nắng với hồ bơi riêng. Được thiết kế bởi Kiến trúc sư lừng danh thế giới Bill Bensley, căn biệt thự là sự kết hợp hoàn hảo giữa phong cách kiến trúc kiểu thực dân với tông màu trắng đen chủ đạo pha trộn cùng những gam màu sống động, rực rỡ khơi gợi nét nghệ thuật hậu hiện đại, mang lại không gian sống tui tươi rực rỡ.', '500', '3 phòng ngủ (2 giường cỡ king, 1 giường đôi), mỗi phòng ngủ được thiết kế với phòng thay đồ và phòng tắm riêng.', 'Ba phòng tắm đầy đủ tiện nghi với bồn tắm lớn bằng đá cẩm thạch và vòi sen', 'Tầm nhìn bao trọn vịnh biển và rừng nhiệt đới.');
-- INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) VALUES ('R000014', 'Biệt thự 4 phòng ngủ với hồ bơi riêng', 3, '12', '1400000000', 0, 'Quý khách sẽ vô cùng thích thú và thỏa sức thăng hoa cảm xúc cùng gia đình và bạn bè trong một không gian mở hiện đại và đẳng cấp của một biệt thự hai tầng, bốn phòng ngủ đầy đủ tiện nghi ngay tại Tầng Mặt đất (Earth) của Khu nghỉ dưỡng. Với thiết kế ngắm trọn toàn cảnh bãi cát trắng mịn, đại dương xanh thẳm và núi rừng kỳ vĩ, không gian ban công thoáng đãng và mát mẻ chính là một chọn lựa lý tưởng để thả mình và cảm nhận trọn vẹn từng khoảnh khắc an yên, bên cạnh đó thư giãn cùng làn nước mát rượi tại một trong ba hồ bơi của khu biệt thự cũng là một lựa chọn khác không kém phần hấp dẫn.', '705', 'Bốn phòng ngủ, mỗi phòng đều có phòng khách thoáng đãng ngắm toàn cảnh đại dương xanh mát kết hợp cùng phòng tắm riêng với bồn tắm lớn', 'Phòng tắm mở nhưng riêng tư kết hợp cùng vòi hoa sen và bồn tắm lớn sang trọng, đón nhận toàn bộ ánh sáng thiên nhiên ấm áp', 'Ngắm trọn cảnh biển trong xanh, bãi cát trắng và núi rừng kỳ vĩ');



-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000001', 'Cá Phile Sốt Chanh Dây', '6993000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000002', 'Cơm Chiên Hải Sản', '404700');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000003', 'Gỏi Củ Hủ Dừa Tôm Thịt', '319500');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000004', 'Sườn Nấu Pate Pháp', '636000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000005', 'Tôm Càng Nướng Phô Mai', '1317000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000006', 'Tôm Sú Nướng Muối Ớt', '6753000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000007', 'Giò Heo Muối Chiên Giòn', '6504000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000008', 'Cá Mú Hấp HongKong', '7646000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000009', 'Rau Câu Trái Cây', '449000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000010', 'Tôm Sú Cháy Tỏi', '9178000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000011', 'Cá Tầm Nướng Muối Ớt', '4608000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000012', 'Gỏi Bò Bóp Thấu', '5753000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000013', 'Mực Chiên Giòn', '1960000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000014', 'Tôm Sú Hoàng Kim', '9909000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000015', 'Gà Mái Dầu Nướng Muối Ớt', '6239000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000016', 'Mực Sữa Chiên Nước Mắm', '9647000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000017', 'Lẩu Nấm Hải Sản – Mì Sợi', '7530000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000018', 'Lòng Da Thịt Tái Chanh', '5094000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000019', 'Lẩu Hầm Sả', '8568000');
-- INSERT INTO Food (foodID, foodName, foodPrice) VALUES ('F000020', 'Lẩu Gà Tiềm Ớt Hiểm', '4643000');

-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000001', 'F000003', '2');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000001', 'F000005', '1');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000001', 'F000009', '3');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000002', 'F000005', '2');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000002', 'F000014', '3');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000002', 'F000016', '1');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000002', 'F000018', '4');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000003', 'F000001', '1');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000003', 'F000004', '3');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000003', 'F000011', '2');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000004', 'F000015', '1');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000004', 'F000006', '2');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000004', 'F000008', '1');
-- INSERT INTO OrderDetail (OrderID, FoodID, Amount) VALUES ('OD000004', 'F000012', '3');



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
