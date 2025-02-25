CREATE TABLE car (
	car_id SERIAL PRIMARY KEY,
	company VARCHAR(20) NOT NULL,
	model SMALLINT NOT NULL,
	seater SMALLINT NOT NULL,
	fuel_type VARCHAR(10) NOT NULL,
	car_type VARCHAR(20) NOT NULL,
	price INT NOT NULL,
	sold BOOLEAN DEFAULT FALSE
);



INSERT INTO car (company, model, seater, fuel_type, car_type, price, sold) VALUES
('Tata', 2023, 5, 'Petrol', 'SUV', 1200000, FALSE),
('Mahindra', 2022, 7, 'Diesel', 'SUV', 1500000, TRUE),
('Maruti Suzuki', 2021, 5, 'CNG', 'Hatchback', 550000, FALSE),
('Hyundai', 2023, 5, 'Petrol', 'Sedan', 900000, TRUE),
('Honda', 2022, 5, 'Petrol', 'Sedan', 800000, FALSE),
('Toyota', 2022, 7, 'Petrol', 'MPV', 2000000, TRUE),
('Ford', 2021, 5, 'Diesel', 'Hatchback', 750000, FALSE),
('Renault', 2023, 5, 'Petrol', 'SUV', 1100000, TRUE),
('Nissan', 2021, 5, 'Diesel', 'Sedan', 850000, FALSE),
('Volkswagen', 2023, 5, 'Diesel', 'Hatchback', 950000, TRUE),
('Skoda', 2022, 5, 'Petrol', 'Sedan', 1200000, FALSE),
('Fiat', 2021, 5, 'Diesel', 'Hatchback', 700000, TRUE),
('Mahindra', 2023, 5, 'Diesel', 'SUV', 1400000, FALSE),
('Tata', 2022, 7, 'CNG', 'MPV', 1300000, TRUE),
('Maruti Suzuki', 2021, 5, 'Petrol', 'Hatchback', 600000, FALSE),
('Hyundai', 2022, 5, 'Diesel', 'Hatchback', 800000, TRUE),
('Honda', 2023, 5, 'CNG', 'SUV', 1100000, FALSE),
('Kia', 2022, 5, 'Diesel', 'Sedan', 1400000, TRUE),
('MG', 2023, 5, 'Petrol', 'SUV', 1800000, FALSE),
('Mahindra', 2022, 5, 'Petrol', 'SUV', 1300000, TRUE),
('Tata', 2021, 5, 'Diesel', 'Sedan', 900000, FALSE),
('Maruti Suzuki', 2023, 5, 'Diesel', 'Hatchback', 700000, TRUE),
('Hyundai', 2021, 5, 'Petrol', 'SUV', 1100000, FALSE),
('Toyota', 2022, 5, 'Diesel', 'Sedan', 950000, TRUE),
('Nissan', 2021, 7, 'Petrol', 'MPV', 1600000, FALSE),
('Renault', 2022, 5, 'Diesel', 'SUV', 1000000, TRUE),
('Kia', 2023, 5, 'Petrol', 'Hatchback', 750000, FALSE),
('Skoda', 2021, 5, 'Diesel', 'SUV', 1400000, TRUE),
('Ford', 2022, 5, 'Petrol', 'Sedan', 850000, FALSE),
('Fiat', 2023, 5, 'Petrol', 'Hatchback', 650000, TRUE);

SELECT * FROM car;
