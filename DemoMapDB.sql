-- 1. Tạo Database DemoMap
CREATE DATABASE DemoMap;
GO

USE DemoMap;
GO

-- 2. Tạo bảng (dựa trên cấu trúc ảnh 2)
CREATE TABLE UserLocations (
    UserID NVARCHAR(50) NOT NULL PRIMARY KEY, -- UserID không cho phép NULL và là khóa chính
    UserType NVARCHAR(20) NULL,
    Latitude DECIMAL(10, 8) NULL,
    Longitude DECIMAL(11, 8) NULL,
    LastUpdate DATETIME NULL
);
GO

-- 3. Thêm dữ liệu mẫu (dựa trên dữ liệu ảnh 1)
INSERT INTO UserLocations (UserID, UserType, Latitude, Longitude, LastUpdate)
VALUES 
('TEAM_01', 'Rescue', 21.02851100, 105.85444400, '2026-01-17 00:34:04.837'),
('TEAM_02', 'Rescue', 21.03333300, 105.83333300, '2026-01-17 00:34:04.837'),
('USER_100', 'Citizen', 21.02000000, 105.86000000, '2026-01-17 00:34:04.840'),
('USER_99', 'Citizen', 21.04000000, 105.85000000, '2026-01-17 00:34:04.840');
GO

-- Kiểm tra lại dữ liệu đã nhập
SELECT * FROM UserLocations;