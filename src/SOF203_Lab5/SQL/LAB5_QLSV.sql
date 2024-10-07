create database SOF203_LAB5
GO
use SOF203_LAB5
go

create table STUDENTS(
	MaSV nvarchar(50) primary key,	
	Hoten nvarchar(50) null,
	Email nvarchar(50) null,
	SoDT nvarchar(12) null,
	Gioitinh bit null,
	Diachi nvarchar(100) null
)

insert into STUDENTS
	VALUES (N'SV001', N'Nguyen Quan Lam', N'quanglam@gmail.com', N'039285738', 1, N'Ha Noi'),
	(N'SV002', N'Tran Hai Phong', N'haiphong@gmail.com', N'029573384', 1, N'Hai Phong'),
	(N'SV003', N'Le Thi Linh Chi', N'linhchi@gmail.com', N'011283773', 0, N'Ninh Binh'),
	(N'SV004', N'Tran Tuan Khi', N'tuankhi@gmail.com', N'099684983', 1, N'Dong Thap')
go


