/* Добавляем данные в таблицы */
INSERT INTO
    CUSTOMERS
("name", surname, age, phone_number)
VALUES
('Alexey', 'Zlatouhov', 25, '+79651031076'),
('Dmitry', 'Porshnev', 35, '+79651331876'),
('Mariya', 'Pak', 28, '+79652331876');

/* id пользовате получим ссылаясь на номер телефона как уникальный параметр пользователя */
INSERT INTO
    ORDERS
(customer_id, product_name, amount)
VALUES
(
    (SELECT id FROM CUSTOMERS WHERE "phone_number" = '+79651031076'),
    'Капуста',
    1
),
(
    (SELECT id FROM CUSTOMERS WHERE "phone_number" = '+79651031076'),
    'Морковка',
    2
),
(
    (SELECT id FROM CUSTOMERS WHERE "phone_number" = '+79651331876'),
    'Капуста',
    3
);