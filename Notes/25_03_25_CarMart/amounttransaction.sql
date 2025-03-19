CREATE TABLE transactions (
    tid SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(cid) ON DELETE CASCADE,
    toid INT NOT NULL,
    amount INT NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(cid) ON DELETE CASCADE
);
select * from transactions