select * from emp;

insert into emp(name, age, salary, designation)
values 
('Sonal', 21, 20000, 'Tester'),
('Monal', 22, 100000, 'Manager'),
('Gonal', 25, 21000, 'Clerk'),
('Bonal', 29, 29000, 'Programmer');

-- ORDER BY DESC: Descending order of salary
select * from emp
order by salary desc;

-- if using GROUP BY then aggregate functions are must
-- IN, NOT IN: Inclusion and not inclusion
select sum(salary), designation 
from emp
group by designation
having designation not in ('Programmer', 'Admin');

-- BETWEEN includes both ends
select sum(salary), designation
from emp
group by designation
having 
select *
from emp
where age between 22 and 25;

-- LIMIT and OFFSET can be in any order
select * 
from emp 
offset 2 
limit 3;

-- REVERSE: PALINDROME
select reverse('madam') = 'madam';

CREATE TABLE roles(designation VARCHAR(20) primary key,
max_count int not null,
min_salary int not null);

drop table roles;

INSERT INTO roles
VALUES
('Tester', 100, 20000),
('Programmer', 200, 35000),
('Manager', 15, 120000),
('Clerk', 50, 25000);

-- all employees whose salary is less than the minimum salary for their designation
SELECT emp.name, emp.salary, emp.designation
FROM emp
JOIN roles ON emp.designation = roles.designation
WHERE emp.salary < roles.min_salary;

-- Create a procedure
create or replace procedure insert_emp_record()
language plpgsql
as $$
begin
	insert into emp(name, age, salary, designation)
	values('Pijjo', 23, 40000, 'PROGRAMMER');
end;
$$
drop procedure insert_emp_record();
--- call a procedure
call insert_emp_record();


create or replace procedure appraisal(
	id int,
	amount int
)
language plpgsql
as $$
begin
	update emp set salary= salary + amount where eid = id;
end;
$$
select * from emp;
call appraisal(3, 10000);

-- Create a function
create or replace function max_salary(desig varchar)
returns table(eid int, name varchar, salary decimal)
language plpgsql
as $$ 
begin 
	return query
	select e.eid, e.name, e.salary from emp e
	where e.designation = desig
	and e.salary = (select max(e2.salary) from emp e2
	where e2.designation = desig);
end;
$$
drop function max_salary;
-- This works
select * from max_salary('Programmer');
-- This should work but it is not
call max_salary('Programmer'::varchar);

-- giri prasath working code
create or replace procedure insert_emp_record(
	e_name varchar(20),
	e_age int,
	e_gender varchar(10),
	e_salary int,
	e_designation varchar(10),
	e_mrg_id int,
	e_email_id varchar(20),
	e_married boolean
)
language plpgsql
as $$
begin
	insert into employee
	(NAME, AGE, GENDER, SALARY, DESIGNATION, MRG_ID, EMAIL_ID, MARRIED)
values
(e_name, e_age, e_gender, e_salary, e_designation, e_mrg_id, e_email_id, e_married);
end;
$$

call insert_emp_record('Prasath',25,'MALE',100000,'PROGRAMMER',3,'prasath@xyz.com',FALSE); 
---------------------------------------------------
select name, salary, sum(salary) over(order by salary) from emp;

select row_number() over(order by name), name, designation, salary from emp
select name, salary, dense_rank() over(order by salary desc) from emp;

-- lag() and lead()
select name, salary, lag(salary) over() from emp;
select name, salary, lag(salary) over() from emp;

-- Subquery for employees with salary more than average
SELECT * FROM EMPLOYEE e1
WHERE e1.salary > (
  SELECT AVG(e2.salary) 
  FROM EMPLOYEE e2  
  WHERE e2.DESIGNATION = e1.DESIGNATION 
  GROUP BY e2.DESIGNATION 
);

-- inner join for the above
select e1.name, e1.designation, e1.salary, e2.average
from employees e1
inner join 
(select designation, ROUND(avg(salary), 3) as average from employees group by designation) as e2
on e1.designation = e2.designation and e1.salary > e2.average
order by designation, (e1.salary - e2.average) desc;


-- Using the with keyword
-- called as CTE(Compressed Table Expression)
-- other alternative of view offered by postgresql
-- view would've created a separate table and the below method doesn't create a separate table
-- it is temporarily created and deleted once it's job is done
with avg_sal as(
select designation, avg(salary) as avg_salary
from emp
group by designation
)
select e.eid, e.name, e.designation, e.salary, a.avg_salary
from emp e
join avg_sal a on e.designation = a.designation
where e.salary > a.avg_salary;


-- function returning a trigger
create or replace function validate_salary()
returns trigger as $$
begin 
	if new.salary < 12000 then
		new.salary = 12000;
	end if;
	return new;
end;
$$ language plpgsql;

-- trigger
-- provide insert/update/delete
create or replace trigger before_updating_salar
before insert, update on emp
for each row
execute function validate_salary();

select * from emp;

update emp set salary = 5000 where eid = 2;