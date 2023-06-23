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
    empAddress nvarchar(100),
    empPhone char(11),
    empEmail char(50),
    constraint fk_empId foreign key(empID) references Account(accountID)
);

create table `Order`(
	orderID char(10) primary key,
    cusID char(10),
    orDate date,
    orStatus bit default 0,
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
	roomID char(10),
    orderID char(10),
    timeIn date,
    timeOut date,
    people int,
    timeRegister datetime,
    status int,
    constraint fk_order foreign key(orderID) references `Order`(orderID),
    constraint fk_room foreign key(roomID) references Room(roomID),
    CONSTRAINT chk_time CHECK(timeIn <= timeOut)
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

-- accountID char(10) primary key,
-- username char(50),
-- password char(50),
-- `role` int

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
('CUS000013', 'admin', '123', 0);


-- cusID char(10) PRIMARY KEY,
-- cusName nvarchar(50), 
-- cusDOB date,
-- cusPhone char(11),
-- cusEmail char(50),
-- cusCCCD char(12),
-- cusType int,
-- constraint fk_cusId foreign key(cusID) references Account(accountID)

INSERT INTO Customer (cusID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType) 
VALUES 
('CUS000001', 'Nguyễn Anh Thư ', '2000-06-17', '0912017119', 'thunade170102@fpt.edu.vn', '49204004951', '1'),
('CUS000002', 'Nguyễn Quang Đăng Khoa ', '1999-02-18', '0867876188', 'khoanqdde160390@fpt.edu.vn', '49204005371', '2'),
('CUS000003', 'Nguyễn Thị Bích Liên ', '2002-08-02', '0356829925', 'lienntbde160471@fpt.edu.vn', '52204004284', '1'),
('CUS000004', 'Nguyễn Thị Mỹ Duyên ', '1998-08-25', '0358026576', 'duyenntmde160345@fpt.edu.vn', '49204000628', '2'),
('CUS000005', 'Ngô Lê Thành ', '1996-01-26', '0789453155', 'thanhnlds160044@fpt.edu.vn', '44204001198', '2'),
('CUS000006', 'Ngô Xuân Duy', '1989-04-23', '0785130942', 'duynxda160051@fpt.edu.vn', '48203000268', '2'),
('CUS000007', 'Hoàng Khánh Hoà', '1982-04-26', '0942528151', 'Hoahkde160202@fpt.edu.vn', '49204004430', '2'),
('CUS000008', 'Hồ Phước Thuật', '2000-01-11', '0868350013', 'thuathpde160218@fpt.edu.vn', '49202008542', '1'),
('CUS000009', 'Hồ Văn Lẹ', '1994-01-06', '0935011916', 'Lehvde160240@fpt.edu.vn', '48303001745', '2'),
('CUS000010', 'Hoàng Thị Minh Hạnh', '1982-10-16', '0898350127', 'Hanhhtmde160147@fpt.edu.vn', '46304010259', '1'),
('CUS000011', 'Hoàng Vũ Minh Anh', '2001-04-07', '0858089768', 'anhhvmde160399@fpt.edu.vn', '44204001279', '1'),
('CUS000012', 'Khấu Trần Ngọc Thiệp', '2000-08-27', '0862210623', 'thiepktnde160439@fpt.edu.vn', '48303001765', '1'),
('CUS000013', 'Watson Marco', '2001-08-15', '0776210623', 'watsonmarco@gmail.com', '48303001652', '1');


-- empID char(10) primary key,
-- empName nvarchar(50),
-- empGender bit,
-- empDOB date,
-- empAddress nvarchar(100),
-- empPhone char(11),
-- empEmail char(50),
-- constraint fk_empId foreign key(empID) references Account(accountID)

INSERT INTO Employee (empID, empName, empGender, empDOB, empAddress, empPhone, empEmail) 
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
('MAN000003', 'Nguyễn Quang Bảo', 1, '2002-10-30', 'Đà Nẵng, Việt Nam', '0702347748', 'baonqde160293@fpt.edu.vn');


-- roomID char(10) primary key,
-- roomName nvarchar(100),
-- roomType int,
-- maxPeople int,
-- roomPrice decimal(10, 0),
-- roomStatus int,
-- roomDescipt nvarchar(1000),
-- roomArea double,
-- bedroom nvarchar(500),
-- bathroom nvarchar(500),
-- room_direction nvarchar(100)

INSERT INTO Room (roomID, roomName, roomType, maxPeople, roomPrice, roomStatus, roomDescipt, roomArea, bedroom, bathroom, room_direction) 
VALUES 
('R000001', 'Phòng Resort Classic Hướng Biển', 1, '4', '300000000', 0, 'Nghỉ dưỡng trong căn phòng Classic đầy cảm hứng mang phong cách kết hợp tuyệt vời giữa nét văn hóa Việt Nam truyền thống và kiến trúc đương đại. Tận hưởng những làn gió biển trong không gian rộng rãi trong nhà – ngoài trời và những phút giây thư giãn tuyệt đối trong bồn tắm bằng đá cẩm thạch và giường cỡ lớn (King hoặc Queen) êm ái. Không gian rộng mở của ban công riêng là địa điểm hoàn hảo để cùng bạn bè thưởng thức những loại đồ uống ngon trong lúc hòa mình vào những tiếng sóng vỗ rì rào đầy thơ mộng của đại dương.', '120', 'Giường King hoặc 2 giường đơn', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Vườn và biển'),
('R000002', 'Phòng Resort Classic Toàn Cảnh Biển', 1, '4', '320000000', 0, 'Lấy cảm hứng thiết kế từ văn hóa truyền thống Việt Nam với không gian mở ra thiên nhiên khoáng đạt, phòng Resort Classic Toàn Cảnh Biển chào đón bạn đến với khung cảnh núi rừng, khoảng vườn xanh mát và đại dương mênh mông. Thả mình thư giãn trên chiếc giường King hay Queen êm ái, trải nghiệm những giây phút gắn kết với gia đình trong không gian rộng rãi trong nhà – ngoài trời.', '90', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Panoramic vistas of the mountains, gardens and sea'),
('R000003', 'Phòng Terrace Suite Hướng Biển', 2, '4', '400000000', 0, 'Trải nghiệm căn phòng suite rộng rãi được thiết kế khoáng đạt đón nắng gió vào trong không gian nghỉ dưỡng hoàn hảo. Cùng với ban công rộng rãi, Classic Terrace Suite là lựa chọn tuyệt vời để trò chuyện, đọc sách hay đơn giản là để thư giãn ngắm nhìn vịnh biển.', '80', 'Phòng ngủ giường King, được trang bị Tivi màn hình phẳng và lối đi ra khu vực ngoài trời.', 'Bàn trang điểm đôi, vòi hoa sen, bồn tắm đá cẩm thạch tách biệt', 'Vườn và biển'),
('R000004', 'Club Terrace Suite Toàn Cảnh Biển', 2, '4', '435000000', 0, 'Tận hưởng đặc quyền thượng lưu Club Sapphire Sands của hạng phòng sở hữu không gian trong nhà – ngoài trời rộng rãi. Thiết kế nội thất sống động, tầm nhìn toàn cảnh ra vịnh biển và núi rừng từ ban công riêng, và chỉ cách biển vài bước chân. Terrace Suite hứa hẹn mang đến cho bạn một kỳ nghỉ tràn đầy cảm hứng và những trải nghiệm tuyệt vời.', '150', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm lớn với bàn trang điểm đôi, vòi hoa sen và bồn tắm lát đá cẩm thạch tách biệt.', 'Tầm nhìn 180 độ ra vịnh biển và rừng nhiệt đới'),
('R000005', 'Penthouse Một Phòng Ngủ Hướng Biển', 3, '4', '620000000', 0, 'Nghỉ dưỡng đẳng cấp tại tầng cao nhất của khu nghỉ dưỡng với sân vườn trên ban công và hồ bơi riêng hướng tầm nhìn tuyệt vời ra rừng nhiệt đới và vịnh biển riêng. Đặc biệt thiết kế cửa kính ba mặt nối từ sàn đến trần nhà của căn phòng tạo sự kết nối đặc sắc giữa phong cách nội thất sống động của căn phòng với ánh nắng rực rỡ trên Bán đảo Sơn Trà. Những chiếc đèn chùm Hội An, giường ngủ có màn che và các bức tranh vẽ rực rỡ là điểm nhấn khiến cho kỳ nghỉ dưỡng tại Penthouse tràn đầy cảm hứng.', '170', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm phong cách với bàn trang điểm đôi, khu vực trang điểm và thay đồ cùng bồn tắm cỡ lớn', 'Tầm nhìn tuyệt vời ra vịnh biển riêng và rừng nhiệt đới.'),
('R000006', 'Biệt Thự Một Phòng Ngủ Cạnh Biển', 3, '4', '600000000', 0, 'Chỉ cách bãi biển vài bước chân, Biệt Thự Cạnh Biển mang đến cho bạn một kỳ nghỉ riêng tư tuyệt đối. Hãy cảm nhận tiếng sóng vỗ, làn gió biển xào xác trong tán lá dừa, tận hưởng những phút giây thư giãn trên sân hiên riêng, hồ bơi vô cực riêng, khu để thưởng thức ẩm thực ngoài trời và chiếc ghế xích đu phong cách. Phòng ngủ của biệt thự được thiết kế mang những nét tính cách riêng với chiếc giường sofa êm ái.', '145', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm riêng với bàn trang điểm đôi, khu vực thay quần áo, vòi sen và bồn tắm tách biệt', 'Biển và bãi biển'),
('R000007', 'Biệt Thự Một Phòng Ngủ trên Ghềnh Đá Cạnh Biển', 3, '4', '700000000', 0, 'Hãy thư giãn và lắng nghe tiếng sóng biển thì thầm bên tai, đọc sách bên sân hiên ngoài trời, trải nghiệm hồ bơi vô cực và thưởng thức bữa tối lãng mạn dưới những vì sao. Phòng ngủ của biệt thự được thiết kế với trần cao, góc thư giãn riêng với giường sofa lớn tại không gian nghỉ dưỡng thật thoải mái. Nếu bạn đang tìm kiếm chốn nghỉ dưỡng riêng tư, bỏ lại sau lưng những bận rộn của phố thị, biệt thự trên ghềnh đá của chúng tôi là sự lựa chọn hoàn hảo.', '220', 'Phòng ngủ giường King, được trang bị Tivi và bàn làm việc', 'Phòng tắm riêng với bàn trang điểm đôi, khu vực thay quần áo, vòi sen và bồn tắm tách biệt', 'Tầm nhìn hướng biển'),
('R000008', 'Biệt Thự Một Phòng Ngủ Spa Lagoon', 3, '4', '730000000', 0, 'Đắm mình thư giãn trong thiên nhiên yên bình hoang sơ thuộc khu đầm phá Spa của chúng tôi. Với thiết kế đặc biệt khi đặt phòng trị liệu trong biệt thự với bồn sục Jacuzzi riêng cùng hai ban công trên mặt nước, biệt thự Spa Lagoon là lựa chọn không thể tuyệt vời hơn cho kỳ nghỉ dưỡng xua tan mọi căng thẳng ưu tư. Tận hưởng sự thanh bình tuyệt đối trong khuôn viên vườn với vòi tắm hoa sen ngoài trời hoặc trong bồn tắm hình kén được thiết kế riêng duy nhất dành cho biệt thự Spa Lagoon.', '260', 'Phòng ngủ trên mặt nước với giường King êm ái.', 'Phòng tắm kiểu spa bao gồm bàn trang điểm đôi, khu vực thay đồ, vòi sen và bồn tắm tách biệt"', 'Núi rừng và đầm phá'),
('R000009', 'Biệt Thự Hai Phòng Ngủ trên Ghềnh Đá Cạnh Biển', 3, '6', '800000000', 0, 'Tầng 3 được thiết kế với sân hiên ngoài trời rộng rãi cùng khu vực giải trí âm thực, hồ bơi riêng tư và phòng ngủ giường King đầy phong cách. Ở tầng dưới, bạn sẽ khám phá phòng ngủ thứ hai của biệt thự với không gian ngoài trời riêng tư. Tầng cuối là sân hiên rộng rãi với ghế ngồi thoải mái để bạn có thể giao lưu, nghỉ ngơi hoặc đơn giản chỉ để ngắm nhìn từng đợt sóng tung bọt biển trắng xóa.', '450', 'Phòng ngủ chính giường King thuộc tầng trên, khu vực giải trí được trang bị Tivi và giường sofa lớn.', 'Hai phòng tắm riêng với bàn trang điểm đôi, khu vực thay đồ, vòi sen và bồn tắm tách biệt"', 'Tầm nhìn bao trọn vịnh biển'),
('R000010', 'Biệt Thự Hai Phòng Ngủ Hoàng Gia Royal Residence Cạnh Biển', 3, '10', '900000000', 0, 'Một trải nghiệm tinh tế và đầy cảm hứng đang chờ đợi bạn tại không gian nghỉ dưỡng đẳng cấp trong biệt thự Hoàng gia của chúng tôi. Biệt Thự gồm 2 tầng, 2 phòng ngủ sẽ mang đến những đặc quyền và sự riêng tư tuyệt đối. Phòng khách được thiết kế với cây đàn piano, một quầy bar và phòng đa phương tiện riêng biệt với dàn karaoke cho hoạt động thư giãn và giải trí. Phòng ăn được thiết kế nổi trên mặt vịnh biển, được kết nối với phòng khách bằng lối đi nhỏ lát đá có mái che độc đáo.', '450', '2 giường King, một giường trẻ em được kê thêm trong phòng ngủ tầng dưới', 'Hai phòng tắm riêng đầy đủ tiện nghi', 'Tầm nhìn bao trọn cảnh biển'),
('R000011', 'Biệt Thự Hai Phòng Ngủ Sun Peninsula Residence Cạnh Biển', 3, '12', '1500000000', 0, 'Mỗi biệt thự sườn đồi ba phòng ngủ hướng biển có bể bơi của chúng tôi đều là nơi phô diễn kỹ nghệ tinh xảo của các nghệ nhân địa phương, với các phòng được thiết kế đẹp mắt thể hiện sự chăm chút đến từng chi tiết nhỏ của mĩ nghệ Việt Nam. Biệt thự rộng 260 mét vuông này có phòng khách rộng rãi, bể bơi lớn, bể sục, phòng ăn, phòng bếp và ba phòng ngủ sang trọng, mỗi phòng đều có phòng tắm riêng. Đây sẽ là tổ ấm thứ hai cho các gia đình và nhóm bạn bè.', '800', 'Gồm 1 phòng ngủ giường đơn và 1 phòng ngủ giường đôi giường King được kê thêm trong phòng ngủ tầng dưới', 'Hai phòng tắm riêng đầy đủ tiện nghi', 'HƯỚNG ĐẠI DƯƠNG'),
('R000012', 'Biệt Thự Ba Phòng Ngủ Sun Peninsula Residence Cạnh Biển', 3, '12', '1700000000', 0, 'Nghỉ dưỡng cao cấp tại biệt thự Sun Peninsula Residence được xây dựng bên sườn núi Sơn Trà, tựa lưng vào rừng nhiệt đới. Nếu muốn dạo bộ trên bãi biển riêng, bạn có thể đi bộ qua chiếc cầu thang gỗ dài được nối riêng trực tiếp với biệt thự. Sau một buổi chiều thỏa thích bơi lội trong hai hồ bơi vô cực, hãy cùng gia đình và bạn bè quây quần bên nhau, thưởng thức ẩm thực tinh tế với tầm nhìn 180 độ ra vịnh biển và thiên nhiên tươi xanh. Với thiết kế khoáng đạt và hiện đại, Biệt thự Ba Phòng Ngủ Sun Peninsula Residence Cạnh Biển mang đến không gian sống ngoài trời đầy mơ ước với khu vườn riêng xanh mát, khu vực tắm vòi hoa sen ngoài trời và sân hiên tắm nắng rộng lớn.', '1000', '3 phòng ngủ, mỗi phòng được thiết kế với phòng thay đồ và phòng tắm riêng', 'Ba phòng tắm đầy đủ tiện nghi với bồn tắm lớn bằng đá cẩm thạch và vòi sen', 'Tầm nhìn bao trọn vịnh biển và rừng nhiệt đới.'),
('R000013', 'Biệt Thự Ba Phòng Ngủ Vịnh Bãi Bắc Hướng Biển', 3, '10', '1200000000', 0, 'Nằm ẩn mình trên sườn núi hoang sơ của bán đảo Sơn Trà, biệt thự Vịnh Bãi Bắc mang đến một không gian nghỉ dưỡng cao cấp và riêng tư nhất trong các loại biệt thự của chúng tôi với tầm nhìn bao quát ra vịnh biển riêng và phong cách thiết kế độc đáo. Đặc biệt, căn biệt thự bao gồm 3 phòng ngủ, mỗi khu vực đều có mái hiên nằm tắm nắng với hồ bơi riêng. Được thiết kế bởi Kiến trúc sư lừng danh thế giới Bill Bensley, căn biệt thự là sự kết hợp hoàn hảo giữa phong cách kiến trúc kiểu thực dân với tông màu trắng đen chủ đạo pha trộn cùng những gam màu sống động, rực rỡ khơi gợi nét nghệ thuật hậu hiện đại, mang lại không gian sống tui tươi rực rỡ.', '500', '3 phòng ngủ (2 giường cỡ king, 1 giường đôi), mỗi phòng ngủ được thiết kế với phòng thay đồ và phòng tắm riêng.', 'Ba phòng tắm đầy đủ tiện nghi với bồn tắm lớn bằng đá cẩm thạch và vòi sen', 'Tầm nhìn bao trọn vịnh biển và rừng nhiệt đới.'),
('R000014', 'Biệt thự 4 phòng ngủ với hồ bơi riêng', 3, '12', '1400000000', 0, 'Quý khách sẽ vô cùng thích thú và thỏa sức thăng hoa cảm xúc cùng gia đình và bạn bè trong một không gian mở hiện đại và đẳng cấp của một biệt thự hai tầng, bốn phòng ngủ đầy đủ tiện nghi ngay tại Tầng Mặt đất (Earth) của Khu nghỉ dưỡng. Với thiết kế ngắm trọn toàn cảnh bãi cát trắng mịn, đại dương xanh thẳm và núi rừng kỳ vĩ, không gian ban công thoáng đãng và mát mẻ chính là một chọn lựa lý tưởng để thả mình và cảm nhận trọn vẹn từng khoảnh khắc an yên, bên cạnh đó thư giãn cùng làn nước mát rượi tại một trong ba hồ bơi của khu biệt thự cũng là một lựa chọn khác không kém phần hấp dẫn.', '705', 'Bốn phòng ngủ, mỗi phòng đều có phòng khách thoáng đãng ngắm toàn cảnh đại dương xanh mát kết hợp cùng phòng tắm riêng với bồn tắm lớn', 'Phòng tắm mở nhưng riêng tư kết hợp cùng vòi hoa sen và bồn tắm lớn sang trọng, đón nhận toàn bộ ánh sáng thiên nhiên ấm áp', 'Ngắm trọn cảnh biển trong xanh, bãi cát trắng và núi rừng kỳ vĩ');

-- orderID char(10) primary key,
-- cusID char(10),
-- orDate date,
-- orStatus bit default 0,
-- constraint fk_cusIdOrder foreign key(cusID) references Customer(cusID)

INSERT INTO `Order` (orderID, cusID, orDate, orStatus) 
VALUES 
('OD000001', 'CUS000001', '2023-04-21', 1),
('OD000002', 'CUS000002', '2023-04-30', 1),
('OD000003', 'CUS000003', '2023-05-03', 1),
('OD000004', 'CUS000004', '2023-05-05', 0),
('OD000005', 'CUS000013', '2023-05-12', 0),
('OD000006', 'CUS000013', '2023-05-12', 1),
('OD000007', 'CUS000013', '2023-05-12', 1),
('OD000008', 'CUS000013', '2023-05-13', 0),
('OD000009', 'CUS000013', '2023-05-13', 1),
('OD000010', 'CUS000013', '2023-05-13', 0),
('OD000011', 'CUS000008', '2023-06-06', 0),
('OD000012', 'CUS000008', '2023-06-06', 0),
('OD000013', 'CUS000006', '2023-06-07', 0),
('OD000014', 'CUS000005', '2023-06-09', 0);


-- roomID char(10),
-- orderID char(10),
-- timeIn date,
-- timeOut date,
-- people int,
-- timeRegister datetime,
-- status int,
-- constraint fk_order foreign key(orderID) references `Order`(orderID),
-- constraint fk_room foreign key(roomID) references Room(roomID),
-- CONSTRAINT chk_time CHECK(timeIn <= timeOut)

INSERT INTO ContractDetail (roomID, orderID, timeIn, timeOut, people, timeRegister, status) 
VALUES
('R000001', 'OD000001', '2023-04-21', '2023-04-23', 2, '2023-04-19', 1),
('R000002', 'OD000002', '2023-04-30', '2023-05-02', 3, '2023-04-20', 1),
('R000003', 'OD000003', '2023-05-03', '2023-05-05', 1, '2023-04-30', 1),
('R000004', 'OD000004', '2023-05-05', '2023-05-07', 2, '2023-05-01', 0),
('R000005', 'OD000005', '2023-05-12', '2023-05-15', 3, '2023-05-02', 0),
('R000006', 'OD000006', '2023-05-12', '2023-05-15', 4, '2023-05-02', 1),
('R000002', 'OD000007', '2023-05-12', '2023-05-15', 2, '2023-05-02', 1),
('R000001', 'OD000008', '2023-05-13', '2023-05-16', 2, '2023-05-01', 0),
('R000003', 'OD000009', '2023-05-13', '2023-05-16', 3, '2023-05-01', 1),
('R000007', 'OD000010', '2023-05-13', '2023-05-15', 2, '2023-05-03', 0),
('R000006', 'OD000011', '2023-06-06', '2023-06-12', 4, '2023-06-01', 0),
('R000002', 'OD000012', '2023-06-06', '2023-06-08', 2, '2023-06-01', 0),
('R000003', 'OD000013', '2023-06-07', '2023-06-08', 4, '2023-06-01', 0);

-- foodID char(10) primary key,
-- foodName nvarchar(50),
-- foodPrice decimal(10,0)

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


-- orderID char(10),
-- foodID char(10),
-- orTime datetime,
-- Amount int,
-- orStatus int,
-- constraint fk_orderdt foreign key(orderID) references `Order`(orderID),
-- constraint fk_fooddt foreign key(foodID) references Food(foodID)

Insert into OrderDetail(orderID, foodID, orTime, Amount, orStatus)
Values
('OD000001', 'F000003', '2023-04-21 06:43:27.13', 2, 0),
('OD000001', 'F000005', '2023-04-21 06:43:27.14', 1, 0),
('OD000001', 'F000009', '2023-04-21 06:43:27.15', 3, 0),
('OD000002', 'F000005', '2023-04-30 22:43:27.16', 2, 0),
('OD000002', 'F000014', '2023-04-30 22:43:27.17', 3, 0),
('OD000002', 'F000016', '2023-04-30 22:43:27.18', 1, 0),
('OD000002', 'F000018', '2023-04-30 22:43:27.19', 4, 0),
('OD000003', 'F000001', '2023-05-03 22:43:27.20', 1, 0),
('OD000003', 'F000004', '2023-05-03 22:43:27.21', 3, 0),
('OD000003', 'F000011', '2023-05-03 22:43:27.22', 2, 0),
('OD000004', 'F000015', '2023-05-05 22:43:27.23', 1, 0),
('OD000004', 'F000006', '2023-05-05 22:43:27.24', 2, 0),
('OD000004', 'F000008', '2023-05-05 22:43:27.25', 1, 0),
('OD000004', 'F000012', '2023-05-05 22:43:27.26', 3, 0);


-- serviceID char(10) primary key,
-- serviceName nvarchar(50),
-- servicePrice decimal(10,0)

INSERT INTO Service (serviceID, serviceName, servicePrice) 
VALUES
('SV000001', 'Dịch vụ Karaoke', 1000000),
('SV000002', 'Dịch vụ Massage', 500000),
('SV000003', 'Dịch vụ thể thao', 700000),
('SV000004', 'Dịch vụ Hồ Bơi', 180000),
('SV000005', 'Dịch vụ Xông hơi', 300000),
('SV000006', 'Dịch vụ suối nước nóng', 150000),
('SV000007', 'Dịch vụ Tổ chức tiệc', 140000),
('SV000008', 'Dịch vụ Tắm bùn', 160000);
    

-- DELETE FROM OrderDetail; 

-- orderID char(10),
-- serviceID char(10),
-- serviceTime datetime,
-- Amount int,
-- serviceStatus int,
-- constraint fk_orderdtt foreign key(orderID) references `Order`(orderID),
-- constraint fk_servicedt foreign key(serviceID) references Service(serviceID)

INSERT INTO ServiceDetail (orderID, serviceID, serviceTime, Amount, serviceStatus) 
VALUES
('OD000001', 'SV000002', '2023-04-21 22:39:08.961', 4, 0),
('OD000001', 'SV000007', '2023-04-21 22:40:19.351', 1, 0),
('OD000001', 'SV000003', '2023-04-21 22:40:20.352', 5, 0),
('OD000002', 'SV000007', '2023-04-30 22:40:21.353', 4, 0),
('OD000002', 'SV000002', '2023-04-30 22:40:22.354', 4, 0),
('OD000003', 'SV000004', '2023-05-03 22:40:23.355', 3, 0),
('OD000004', 'SV000003', '2023-05-05 22:40:24.356', 2, 0),
('OD000004', 'SV000002', '2023-05-05 22:41:19.357', 2, 0),
('OD000005', 'SV000001', '2023-05-12 22:43:19.358', 3, 0),
('OD000005', 'SV000003', '2023-05-12 22:45:19.359', 1, 0),
('OD000005', 'SV000002', '2023-05-12 22:48:19.360', 4, 0),
('OD000005', 'SV000003', '2023-05-12 22:50:19.361', 5, 0),
('OD000006', 'SV000007', '2023-05-12 22:53:19.362', 3, 0),
('OD000006', 'SV000002', '2023-05-12 22:58:19.363', 2, 0),
('OD000007', 'SV000003', '2023-05-12 22:59:19.364', 2, 0),
('OD000007', 'SV000002', '2023-05-12 23:10:19.365', 3, 0),
('OD000007', 'SV000001', '2023-05-12 23:40:19.366', 1, 0),
('OD000008', 'SV000008', '2023-05-13 23:45:19.367', 1, 0);
    
    
-- DELETE FROM ServiceDetail;
DELETE FROM ServiceDetail WHERE orderID = "OD000005";
DELETE FROM ServiceDetail WHERE orderID = "OD000006";
DELETE FROM ServiceDetail WHERE orderID = "OD000007";
DELETE FROM ServiceDetail WHERE orderID = "OD000010";

-- Truy Vấn Dữ Liệu Từ Java
-- Select * From Account;
-- Select * From Employee;
-- Select * From Customer;
-- Select * From Room;
-- Select * From ContactDetail;
-- Select * From `Order`;
-- Select * From Food;
-- Select * From OrderDetail;
-- Select * From Service;
-- Select * From ServiceDetail;

-- Select * from Room Where roomID = "R000001";

-- Select * fROM Room Where roomStatus = 0 AND roomType = 1 AND maxPeople >= 2;

-- Select foodID, foodName, foodPrice from Food Where foodID = "F000003";

-- Select * from Service Where serviceID = "SV000001";

-- Select cusID, orderID, orStatus from `Order` where cusID = "CUS000013";

-- Select b.orderID, a.foodID, a.foodName, a.foodPrice, b.orTime, b.Amount, b.orStatus
-- from Food a join OrderDetail b 
-- on a.foodID = b.foodID
-- where b.orderID = "OD000008";

-- Select b.orderID, a.serviceID, a.serviceName, a.servicePrice, b.serviceTime, b.Amount, b.serviceStatus 
-- from Service a join ServiceDetail b 
-- on a.serviceID = b.serviceID
-- where b.orderID = "OD000008";

-- Select b.orderID, a.roomID, a.roomName, a.roomType, b.timeRegister, b.timeIn, b.timOut, b.people, a.roomPrice 
-- from Room a join ContractDetail b
-- on a.roomID = b.roomID
-- where b.orderID = "OD000008";
