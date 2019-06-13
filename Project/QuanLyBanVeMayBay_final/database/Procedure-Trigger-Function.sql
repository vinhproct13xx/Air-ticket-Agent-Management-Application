create proc chartDoanhThu(@nam int, @thang int)
as
begin
	select sum(Gia) as DoanhThu
	from ChiTietChuyenBay,ChuyenBay
	where ChiTietChuyenBay.MaCB=ChuyenBay.MaCB and year(ChuyenBay.NgayKhoiHanh)=@nam and month(ChuyenBay.NgayKhoiHanh)=@thang
end
drop proc chartDoanhThu

exec chartDoanhThu 2019,4

create proc chartTongCB(@nam int, @thang int)
as
begin
	select count(MaCB) as TongCB
	from ChuyenBay
	where year(NgayKhoiHanh)=@nam and month(NgayKhoiHanh)=@thang
end

exec chartTongCB 2019,4

create proc chartTongHKTB(@nam int,@thang int)
as
begin
	declare @tb float
	declare @tong float
	declare @count float
	set @count=(select count(distinct(ChiTietChuyenBay.MaCB)) as TongCB
	from ChuyenBay,ChiTietChuyenBay
	where year(NgayKhoiHanh)=@nam and month(NgayKhoiHanh)=@thang and ChiTietChuyenBay.MaCB=ChuyenBay.MaCB)
	if(@count =0) set @count=1
	set @tong=(select count(MaVe) as TongHKTB
	from ChiTietChuyenBay,ChuyenBay
	where year(NgayKhoiHanh)=@nam and month(NgayKhoiHanh)=@thang and ChiTietChuyenBay.MaCB=ChuyenBay.MaCB)
	set @tb=@tong/@count
	select round(@tb,0) as TongHKTB
end
drop proc chartTongHKTB
exec chartTongHKTB 2019,2

create proc chartTongHK(@nam int,@thang int)
as
begin
	select count(MaVe) as TongHK
	from ChiTietChuyenBay,ChuyenBay
	where ChuyenBay.MaCB=ChiTietChuyenBay.MaCB and year(NgayKhoiHanh)=@nam and month(NgayKhoiHanh)=@thang
end
drop proc chartTongHK
exec chartTongHK 2019,1

create trigger countVe on Ve
for insert, update
as
begin
	declare @SoVeThuongTrong int
	declare @SoVeVipTrong int
	declare @MaCB varchar(10)
	set @MaCB=(select MaVe from Ve,ChuyenBay where Ve.MaCB=ChuyenBay.MaCB)
	set @SoVeThuongTrong= (select count(MaVe) from Ve where TinhTrang=0 and LoaiVe=0 and MaCB=@MaCB)
	set @SoVeVipTrong=(select count(MaVe) from Ve where TinhTrang=0 and LoaiVe=0 and MaCB=@MaCB)
end
drop trigger countVe

alter proc addChuyenBay(@maHMB varchar(10),@diemKH nvarchar(50),@diemDen nvarchar(50),@sbDi varchar(10),@sbDen varchar(10),@ngayKH date,@tgBay int,@gioKH time,@giaVe money)
as
begin
	declare @macb varchar(10)
	declare @id int
	declare @tempt varchar(5)
	if ((select count(MaCB) from ChuyenBay where LEFT(MaCB,2)=@maHMB)=0)
		set @tempt='001'
	else begin
			select @id=(select max(right(MaCB,3)) from ChuyenBay where left(MaCB,2)=@maHMB)
			if(@id>0 or @id<9)
			set @tempt=CONCAT('00',(@id+1))
			else if(@id>=9)
			set @tempt=CONCAT('0',(@id+1))
	end
	set @macb=CONCAT(@maHMB,@tempt)
	insert into ChuyenBay values(@macb,@maHMB,@diemKH,@diemDen,@sbDi,@sbDen,10,40,@ngayKH,@tgBay,@gioKH,@giaVe)
	insert into Ve values (CONCAT(@macb,'01'),@macb,1,0,'1A')
	insert into Ve values (CONCAT(@macb,'02'),@macb,1,0,'1B')
	insert into Ve values (CONCAT(@macb,'03'),@macb,1,0,'1C')
	insert into Ve values (CONCAT(@macb,'04'),@macb,1,0,'1D')
	insert into Ve values (CONCAT(@macb,'05'),@macb,1,0,'1E')
	insert into Ve values (CONCAT(@macb,'06'),@macb,1,0,'2A')
	insert into Ve values (CONCAT(@macb,'07'),@macb,1,0,'2B')
	insert into Ve values (CONCAT(@macb,'08'),@macb,1,0,'2C')
	insert into Ve values (CONCAT(@macb,'09'),@macb,1,0,'2D')
	insert into Ve values (CONCAT(@macb,'10'),@macb,1,0,'2E')
	insert into Ve values (CONCAT(@macb,'11'),@macb,0,0,'3A')
	insert into Ve values (CONCAT(@macb,'12'),@macb,0,0,'3B')
	insert into Ve values (CONCAT(@macb,'13'),@macb,0,0,'3C')
	insert into Ve values (CONCAT(@macb,'14'),@macb,0,0,'3D')
	insert into Ve values (CONCAT(@macb,'15'),@macb,0,0,'3E')
	insert into Ve values (CONCAT(@macb,'16'),@macb,0,0,'4A')
	insert into Ve values (CONCAT(@macb,'17'),@macb,0,0,'4B')
	insert into Ve values (CONCAT(@macb,'18'),@macb,0,0,'4C')
	insert into Ve values (CONCAT(@macb,'19'),@macb,0,0,'4D')
	insert into Ve values (CONCAT(@macb,'20'),@macb,0,0,'4E')
	insert into Ve values (CONCAT(@macb,'21'),@macb,0,0,'5A')
	insert into Ve values (CONCAT(@macb,'22'),@macb,0,0,'5B')
	insert into Ve values (CONCAT(@macb,'23'),@macb,0,0,'5C')
	insert into Ve values (CONCAT(@macb,'24'),@macb,0,0,'5D')
	insert into Ve values (CONCAT(@macb,'25'),@macb,0,0,'5E')
	insert into Ve values (CONCAT(@macb,'26'),@macb,0,0,'6A')
	insert into Ve values (CONCAT(@macb,'27'),@macb,0,0,'6B')
	insert into Ve values (CONCAT(@macb,'28'),@macb,0,0,'6C')
	insert into Ve values (CONCAT(@macb,'29'),@macb,0,0,'6D')
	insert into Ve values (CONCAT(@macb,'30'),@macb,0,0,'6E')
	insert into Ve values (CONCAT(@macb,'31'),@macb,0,0,'7A')
	insert into Ve values (CONCAT(@macb,'32'),@macb,0,0,'7B')
	insert into Ve values (CONCAT(@macb,'33'),@macb,0,0,'7C')
	insert into Ve values (CONCAT(@macb,'34'),@macb,0,0,'7D')
	insert into Ve values (CONCAT(@macb,'35'),@macb,0,0,'7E')
	insert into Ve values (CONCAT(@macb,'36'),@macb,0,0,'8A')
	insert into Ve values (CONCAT(@macb,'37'),@macb,0,0,'8B')
	insert into Ve values (CONCAT(@macb,'38'),@macb,0,0,'8C')
	insert into Ve values (CONCAT(@macb,'39'),@macb,0,0,'8D')
	insert into Ve values (CONCAT(@macb,'40'),@macb,0,0,'8E')
	insert into Ve values (CONCAT(@macb,'41'),@macb,0,0,'9A')
	insert into Ve values (CONCAT(@macb,'42'),@macb,0,0,'9B')
	insert into Ve values (CONCAT(@macb,'43'),@macb,0,0,'9C')
	insert into Ve values (CONCAT(@macb,'44'),@macb,0,0,'9D')
	insert into Ve values (CONCAT(@macb,'45'),@macb,0,0,'9E')
	insert into Ve values (CONCAT(@macb,'46'),@macb,0,0,'10A')
	insert into Ve values (CONCAT(@macb,'47'),@macb,0,0,'10B')
	insert into Ve values (CONCAT(@macb,'48'),@macb,0,0,'10C')
	insert into Ve values (CONCAT(@macb,'49'),@macb,0,0,'10D')
	insert into Ve values (CONCAT(@macb,'50'),@macb,0,0,'10E')
end
drop proc addChuyenBay
exec addChuyenBay 'VA03','VA',N'Hà Nội',N'TP Hồ Chí Minh','NB','TSN','01-01-2019',2,'20:00',2000000
select max(right(MaCB,3)) from ChuyenBay where left(MaCB,2)='VA'
select max(right(MaCB,3)) from ChuyenBay where left(MaCB,2)='VA'
delete from ChuyenBay
delete from ChiTietChuyenBay
delete from Ve
select CONCAT(MaCB,'01') from ChuyenBay where MaCB='VA002 '

create proc xoaCB (@maCB varchar(10))
as
begin
	delete from ChiTietChuyenBay where MaCB=@maCB
	delete from Ve where MaCB=@maCB
	delete from ChuyenBay where MaCB=@maCB
end
drop proc xoaCB
exec xoaCB 'BA02'
