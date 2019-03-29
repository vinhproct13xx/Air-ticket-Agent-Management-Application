create database QuanLyBanVeMayBay
use QuanlyBanVeMayBay
set dateformat dmy

create table SanBay
(
	MaSB varchar(10) primary key not null,
	TenSB nvarchar(20),
	DiaDiem nvarchar(40)
)

create table ChuyenBay
(
	MaCB varchar(10) primary key not null,
	SanBayDi	varchar(10),
	SanBayDen	varchar(10),
	SoGheVipTrong int,				-- Số ghế Vip còn trống
	SoGheThuongTrong int,			-- Số ghế thường còn trống
	NgayKhoiHanh smalldatetime,		-- Ngày khởi hành
	ThoiGianBay int,				-- Thời gian bay khoảng bao lâu
	ThoiGianKhoiHanh smalldatetime  -- Thời gian khởi hành gồm giờ-ngày-tháng-năm	 
	constraint FK_Di foreign key(SanBayDi)  references SanBay(MaSB),
	constraint FK_Den foreign key(SanBayDen)  references SanBay(MaSB),
)

create table HangMayBay
(
	MaHMB varchar(10) primary key not null,
	TenHMB nvarchar(20)
)

create table HanhKhach
(
	MaHK varchar(10) primary key not null,
	HoTen nvarchar(50),
	CMND char(12),
	SDT varchar(11),
	Email varchar(30),
	LoaiKH bit
)

create table Ve
(
	MaVe varchar(10) primary key not null,
	MaChuyenBay varchar(10) foreign key references ChuyenBay(MaCB),
	TinhTrang bit,
	GiaVe money
)

create table LichSuGiaoDich
(
	MaVe varchar(10) foreign key references Ve(MaVe),
	MaChuyenBay varchar(10) foreign key references ChuyenBay(MaCB),
	MaHK varchar(10) foreign key references HanhKhach(MaHK),
	GiaVe money
)