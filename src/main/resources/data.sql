use bankmanager;

insert into address(street, des, district, city, country) values('quang tien','123','nam tu liem', 'ha noi','viet nam');

insert into fullname(first_name, mid_name, last_name) values('Bui','Van', 'Dong');

insert into employee(id_card, dob, level, year, position, full_name_id, address_id, created_at, updated_at) values(1,'20120618',1, 1,'manager', 1 , 1,'20120618','20120618');

insert into customer(id_card, dob, full_name_id, address_id, created_at, updated_at) values(1,'20120618', 1 , 1,'20120618','20120618');

insert into Debit_Account(balance, rate, min_balance, type, created_at, updated_at,customer_id,employee_id) values(1,1, 1 , 'debit','20120618','20120618',1,1);

insert into Credit_Account(balance, debt, type, created_at, updated_at,customer_id,employee_id) values(1, 1 , 'debit','20120618','20120618',1,1);