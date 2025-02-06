CREATE TABLE sales(
	product_id SERIAL PRIMARY KEY,
	product VARCHAR(20),
	country VARCHAR(20),
	selling_year SMALLINT,
	revenue DECIMAL(12,2)
);

INSERT INTO sales(product, country, selling_year, revenue)
VALUES ('TV', 'India', 2023, 1234900.00),
	('TV', 'Italy', 2023, 1434900.00),
	('TV', 'Japan', 2023, 1634900.00),
	('TV', 'India', 2023, 1734900.00),
	('AC', 'Kenya', 2023, 123490.00),
	('AC', 'India', 2023, 1274900.00),
	('Fan', 'Nepal', 2023, 523790.00),
	('AC', 'Kenya', 2023, 1236600.00),
	('AC', 'USA', 2023, 8234900.00),
	('TV', 'Nepal', 2024, 7234900.00),
	('Fan', 'Italy', 2024, 6235900.00),
	('Fan', 'India', 2024, 1235900.00),
	('Fan', 'USA', 2024, 1234300.00),
	('TV', 'India', 2024, 1238900.00),
	('TV', 'Italy', 2024, 1438900.00),
	('TV', 'Japan', 2024, 1639900.00),
	('TV', 'India', 2024, 1738900.00),
	('AC', 'Kenya', 2024, 123990.00),
	('AC', 'India', 2024, 1279900.00),
	('Fan', 'Nepal', 2024, 592390.00),
	('AC', 'Kenya', 2024, 976600.00),
	('AC', 'USA', 2024, 8276900.00),
	('TV', 'Nepal', 2024, 8434900.00),
	('Fan', 'Italy', 2024, 8234900.00),
	('Fan', 'India', 2024, 5239900.00),
	('Fan', 'USA', 2024, 8234100.00);

INSERT INTO sales(product, country, selling_year, revenue)
VALUES ('TV', 'India', 2024, 3244900.00),
		('TV', 'India', 2024, 8234900.00),
		('AC', 'Kenya', 2024, 99991.00),
		('Fan', 'Nepal', 2024, 125900.00),
		('TV', 'India', 2023, 1234900.00);

CREATE EXTENSION IF NOT EXISTS tablefunc;

SELECT * FROM sales;

-- ORDER BY 1, 2
SELECT *
FROM crosstab(
	'SELECT product, selling_year, revenue
	FROM sales
	ORDER BY 1, 2',
	'SELECT DISTINCT selling_year
	FROM sales
	ORDER BY 1'
 )AS pivot_table 
 (product VARCHAR, revenue_2023 DECIMAL, revenue_2024 DECIMAL);

 
SELECT *
FROM crosstab(
	'SELECT country, selling_year, revenue
	FROM sales
	ORDER BY 1, 2',
	'SELECT DISTINCT selling_year
	FROM sales
	ORDER BY 1'
 )AS pivot_table 
 (country VARCHAR, revenue_2023 DECIMAL, revenue_2024 DECIMAL);

SELECT *
FROM crosstab(
	'SELECT product, selling_year, revenue
	FROM sales
	ORDER BY 1, 2',
	'SELECT DISTINCT selling_year
	FROM sales
	ORDER BY 1'
 )AS pivot_table 
 (product VARCHAR, revenue_2023 DECIMAL, revenue_2024 DECIMAL);

SELECT *
FROM crosstab(
	'SELECT product, country, selling_year, SUM(revenue)
	FROM sales
	GROUP BY selling_year, product, country
	ORDER BY selling_year, product, country',
	'SELECT DISTINCT selling_year
	FROM sales
	ORDER BY 1'
 )AS pivot_table 
 (product VARCHAR, country VARCHAR, revenue_2023 DECIMAL, revenue_2024 DECIMAL);
 