CREATE TABLE employee_database(
emp_id SERIAL PRIMARY KEY,
emp_name VARCHAR(20) NOT NULL,
emp_age SMALLINT CHECK (emp_age >= 18 AND emp_age <= 60),
emp_salary DECIMAL(8,2) CHECK (emp_salary > 0.0),
emp_designation VARCHAR(20),
emp_department VARCHAR(20)
);
select * from employee_database;
select * from employee_database order by emp_name;

select * from employee;

CREATE TABLE student(
roll_no INT PRIMARY KEY,
name VARCHAR(15) NOT NULL,
standard INT,
school_name VARCHAR(20)
);

INSERT INTO student VALUES
(1, 'Naman', 3, 'KV'),
(2, 'Suman', 2, 'DPS'),
(3, 'Raman', 4, 'KV'),
(4, 'Baman', 1, 'DPS'),
(5, 'Charan', 3, 'KV'),
(6, 'Aman', 1, 'KV'),
(7, 'Roman', 2, 'SMS');
