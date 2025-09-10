IF OBJECT_ID('dbo.Categories', 'U') IS NOT NULL DROP TABLE dbo.Categories;
IF OBJECT_ID('dbo.Users', 'U') IS NOT NULL DROP TABLE dbo.Users;
GO

CREATE TABLE Users (
    id INT PRIMARY KEY IDENTITY,
    username NVARCHAR(50) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    fullname NVARCHAR(100),
    email NVARCHAR(100) UNIQUE,
    phone NVARCHAR(20),
    avatar NVARCHAR(255),
    roleid INT NOT NULL, -- 1=user, 2=manager, 3=admin
    createdDate DATE DEFAULT GETDATE()
);
GO

CREATE TABLE Categories (
    id INT PRIMARY KEY IDENTITY,
    categoryname NVARCHAR(255) NOT NULL,
    userid INT,
    FOREIGN KEY (userid) REFERENCES Users(id)
);
GO

INSERT INTO Users (username, password, fullname, email, phone, roleid)
VALUES 
('user1', '123', N'Nguyễn Văn User1', 'user1@example.com', '0901111111', 1),
('user2', '123', N'Nguyễn Văn User2', 'user2@example.com', '0901111112', 1),
('user3', '123', N'Nguyễn Văn User3', 'user3@example.com', '0901111113', 1);

INSERT INTO Users (username, password, fullname, email, phone, roleid)
VALUES 
('manager1', '123', N'Trần Văn Manager1', 'manager1@example.com', '0902222221', 2),
('manager2', '123', N'Trần Văn Manager2', 'manager2@example.com', '0902222222', 2),
('manager3', '123', N'Trần Văn Manager3', 'manager3@example.com', '0902222223', 2);

INSERT INTO Users (username, password, fullname, email, phone, roleid)
VALUES 
('admin1', '123', N'Lê Văn Admin1', 'admin1@example.com', '0903333331', 3),
('admin2', '123', N'Lê Văn Admin2', 'admin2@example.com', '0903333332', 3),
('admin3', '123', N'Lê Văn Admin3', 'admin3@example.com', '0903333333', 3);

INSERT INTO Categories (categoryname, userid)
VALUES
(N'Category A - của user1', 1),
(N'Category B - của user2', 2),
(N'Category C - của manager1', 4),
(N'Category D - của manager2', 5),
(N'Category E - của admin1', 7),
(N'Category F - của admin2', 8);
