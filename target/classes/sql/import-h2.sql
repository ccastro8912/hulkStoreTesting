-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user@mail.com', 'user', 'Name', 'Surname',
   1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'johndoe@gmail.com', 'johndoe', 'John', 'Doe', 1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'name@gmail.com', 'namesurname', 'Name',
        'Surname', 1);

INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2);


INSERT INTO CATEGORY (description, name, category_id)
VALUES ('Juguetes de superheroes','Juguetes', 1);
INSERT INTO CATEGORY (description, name, category_id)
VALUES ('Accesorios de superheroes','Accesorios', 2);
INSERT INTO CATEGORY (description, name, category_id)
VALUES ('Comics de superheroes','Comics', 3);
INSERT INTO CATEGORY (description, name, category_id)
VALUES ('Tazas de superheroes', 'Tazas',4);
INSERT INTO CATEGORY (description, name, category_id)
VALUES ('Moda de superheroes', 'Moda', 5);

INSERT INTO PRODUCT (category_id, description, image, name, price, quantity, product_id)
VALUES (2, 'CARTERA DEADPOOL', '../images/cartera_deadpool.jpg', 'CARTERA DEADPOOL', 30.00, 5, 5)
INSERT INTO PRODUCT (category_id, description, image, name, price, quantity, product_id)
VALUES (5, 'CHANCLAS CAPIT�N AM�RICA', './images/chanclas_capitanamerica.jpg', 'CHANCLAS CAPIT�N AM�RICA', 15, 14, 7)


