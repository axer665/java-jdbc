/* Удалим таблицы из БД, если они уже есть (порядок удаления важен, ибо внешние ключи) */
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS CUSTOMERS;

/* Создаем таблицы */
CREATE TABLE CUSTOMERS
(
    id SERIAL PRIMARY KEY,
    "name" VARCHAR(50),
    surname VARCHAR(50),
    age INTEGER,
    phone_number VARCHAR(12) NOT NULL,
    UNIQUE(phone_number)
);

CREATE TABLE ORDERS
(
    id SERIAL PRIMARY KEY,
    "date" DATE DEFAULT CURRENT_DATE,
    customer_id INTEGER,
    product_name VARCHAR(50),
    amount INTEGER,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);