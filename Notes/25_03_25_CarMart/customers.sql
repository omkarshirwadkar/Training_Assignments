CREATE TABLE customer (
    cid SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    cpass VARCHAR(255) NOT NULL,
    balance INT DEFAULT 0
);
select * from customer