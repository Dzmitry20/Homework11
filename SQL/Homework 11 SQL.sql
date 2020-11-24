DROP DATABASE db_10;
CREATE DATABASE db_10;
USE db_10;
CREATE TABLE addresses (
id INT ,
town VARCHAR(100) ,
street VARCHAR(100) ,
number_house INT ,
number_corpus INT,
number_flat INT 
);

INSERT INTO addresses (id,town,street,number_house,number_corpus,number_flat) VALUES
(1, 'Minsk','Lenina',10,2,7),
(2, 'Vitebsk', 'Centralnaya', 34,1,3),
(3, 'Grodno', 'Pobedy', 54,3,89),
(4, 'Brest' , 'Solnechnaya',4,null,100),
(5, 'Gomel', 'Vokzalnaya', 4,6,4);
SELECT * FROM addresses;



