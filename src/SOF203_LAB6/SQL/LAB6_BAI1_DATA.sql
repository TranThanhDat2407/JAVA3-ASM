CREATE DATABASE SOF203_LAB6_BAI1
GO
USE SOF203_LAB6_BAI1

GO
CREATE TABLE Books (
ID INT IDENTITY PRIMARY KEY
,title NVARCHAR(50)
,price FLOAT 
)
GO
INSERT INTO Books (title, price) VALUES (N'Lập trình C',100)
INSERT INTO Books (title, price) VALUES (N'Lập trình Java',200)
INSERT INTO Books (title, price) VALUES (N'Lập trình C#',150)
GO