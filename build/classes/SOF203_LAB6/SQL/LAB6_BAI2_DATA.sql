CREATE DATABASE SOF203_LAB6_BAI2
GO
USE SOF203_LAB6_BAI2
GO
CREATE TABLE standards(
	standard nvarchar(50),
	fees float null
	primary key(standard)
);

CREATE TABLE Students(
	RegID int IDENTITY(1,1) not null,
	Name nvarchar(50) null,
	Address nvarchar(50) null,
	ParentName nvarchar(50) null,
	Phone nvarchar(50) null,
	standard nvarchar(50) null,
	RegDate datetime null,
	primary key(RegID)
);

ALTER TABLE Students
ADD CONSTRAINT FK_standards_Students
FOREIGN KEY (standard)
REFERENCES standards (standard);

INSERT INTO standards (standard, fees)
VALUES ('Standard 1', 1000),
('Standard 2', 1500),
('Standard 3', 2000);

INSERT INTO Students ( Name, Address, ParentName, Phone, standard, RegDate)
VALUES ( 'John Doe', '123 Main Street', 'Jane Doe', '123-456-7890', 'Standard 1', '2022-01-01'),
( 'Jane Smith', '456 Elm Street', 'John Smith', '987-654-3210', 'Standard 2', '2022-01-03'),
( 'Michael Johnson', '789 Oak Street', 'Sarah Johnson', '555-123-4567', 'Standard 1', '2022-01-05');

SELECT * FROM Students;