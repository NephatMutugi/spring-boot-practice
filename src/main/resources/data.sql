CREATE TABLE "user" (
                        id INT NOT NULL ,
                        birth_date TIMESTAMP,
                        name VARCHAR (255),
                        PRIMARY KEY (id)
) ;

INSERT INTO "user" (id, birth_date, name)
VALUES ( 1, sysdate , 'Nephat Mutugi'),
       ( 2, sysdate , 'Mercy Chero'),
       ( 3, sysdate , 'Leon Vitonya'),
       ( 4, sysdate , 'Jayden'),
       ( 5, sysdate , 'Maureen');

SELECT * FROM "user";



