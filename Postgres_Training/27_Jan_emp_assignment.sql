create type DESIGNATIONS as enum('MANAGER', 'PROGRAMMER', 'TESTER', 'CLERK');
create type GENDERS as enum('MALE', 'FEMALE');
create table EMP(
EID serial primary key,
NAME varchar(20) not null,
AGE smallint check (AGE >= 18 and AGE <= 60),
GENDER GENDERS,
SALARY decimal(8,2) check (SALARY > 0.0),
DESIGNATION DESIGNATIONS,
MRG_ID smallint references EMP(EID),
EMAIL_ID varchar(100) UNIQUE NOT NULL CHECK (EMAIL_ID ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'),
MARRIED boolean,
JOINING_DATE date default current_date
);
insert into EMP (NAME, AGE, GENDER, SALARY, DESIGNATION, MRG_ID, EMAIL_ID, MARRIED)
values
('Alice', 35, 'MALE', 80000, 'PROGRAMMER', NULL, 'alice1@xyz.com', TRUE);
insert into EMP (NAME, AGE, GENDER, SALARY, DESIGNATION, MRG_ID, EMAIL_ID, MARRIED)
values
('Bob', 28, 'MALE', 60000, 'TESTER', 21, 'bob1@xyz.com', FALSE),
('Charly', 45, 'MALE', 90000, 'MANAGER', NULL, 'charly1@xyz.com', TRUE),
('Dayana', 32, 'FEMALE', 70000, 'CLERK', 21, 'dayana1@xyz.com', FALSE),
('Manju', 40, 'FEMALE', 80000, 'PROGRAMMER', 21, 'manju1@xyz.com', TRUE);
 
select * from EMP;