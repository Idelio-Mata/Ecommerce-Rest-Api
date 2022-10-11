INSERT INTO restaurant (id, name, cep, complement)
VALUES (1L, 'Restaurant 1', '000001', 'Complement Address Restaurant 1'),
       (2L, 'Restaurant 2', '000002', 'Complement Address Restaurant 2');

INSERT INTO client (id, name, cep, complement)
VALUES (1L, 'Idelio 1', '000001', 'Complement Address Client 1');

INSERT INTO product(id, available, name, unitary_value, restaurant_id)
VALUES (1L, true, 'Tomatoes', 6.0, 1L),
       (2L, true, 'Potatoes', 8.0, 1L),
       (3L, true, 'Chicken', 10.0, 2L);

INSERT INTO cart(id, payment_form, closed, total_value, client_id)
VALUES (1L, 0, false, 0.0, 1L);