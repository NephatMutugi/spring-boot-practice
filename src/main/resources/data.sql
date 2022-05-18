CREATE TABLE USER (
                        id INT NOT NULL ,
                        birth_date TIMESTAMP,
                        name VARCHAR (255),
                        PRIMARY KEY (id)
) ;
/*

INSERT INTO USER (id, birth_date, name)
VALUES ( 1, sysdate , 'Nephat Mutugi'),
       ( 2, sysdate , 'Mercy Chero'),
       ( 3, sysdate , 'Leon Vitonya'),
       ( 4, sysdate , 'Jayden'),
       ( 5, sysdate , 'Maureen');


INSERT INTO POST(id, description, title, user_id)
VALUES  (100, 'My movie', 'title', 1),
        (101, 'Hello there young King', 'King', 1),
        (102, 'Hello there young King', 'Neph', 3),
        (103, 'Hello there young King', 'Leonel', 4);


*/

SELECT * FROM USER;



