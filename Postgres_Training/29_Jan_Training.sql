CREATE TABLE employee(name VARCHAR(20), age INT);

CREATE OR REPLACE PROCEDURE dummy_record()
LANGUAGE plpgsql
AS $$
BEGIN
INSERT INTO employee VALUES('Guest', 21);
END;
$$

DELETE FROM employee;

SELECT * FROM employee;