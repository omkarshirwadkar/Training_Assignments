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