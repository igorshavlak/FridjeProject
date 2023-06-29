CREATE TABLE Products(
                         Id SERIAL,
                         ProductName VARCHAR(100) NOT NULL,
                         Type varchar(100) not null,
                         expirationDate timestamp,
                         reminderPeriod integer,
                         Photo bytea,
                         expiredStatus boolean,
                         getWarn boolean



);