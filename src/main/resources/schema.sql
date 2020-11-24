use bankmanager;

CREATE TABLE if not exists FullName  (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
first_name NVARCHAR(20) NOT NULL,
mid_name NVARCHAR(20) ,
last_name NVARCHAR(20) NOT NULL
);

CREATE TABLE if not exists Address (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
des NVARCHAR(50),
street NVARCHAR(20) ,
district NVARCHAR(20) NOT NULL,
city NVARCHAR(20) NOT NULL,
country NVARCHAR(20) NOT NULL
);

CREATE TABLE if not exists Employee (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
id_card VARCHAR(30) NOT NULL,
dob date NOT NULL,
full_name_id INT(6) UNSIGNED NOT NULL,
address_id INT(6) UNSIGNED NOT NULL,
level INT,
year INT,
position NVARCHAR(30),
FOREIGN KEY (full_name_id) REFERENCES FullName(id),
FOREIGN KEY (address_id) REFERENCES Address(id),
created_at timestamp,
updated_at timestamp
);

