CREATE TABLE Products(
                         Id SERIAL,
                         ProductName VARCHAR(100) NOT NULL,
                         Type varchar(100) not null,
                         expirationDate DATE,
                         Photo bytea

);