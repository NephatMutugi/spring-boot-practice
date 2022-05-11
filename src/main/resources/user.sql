CREATE TABLE "user" (
                        id INT NOT NULL ,
                        birth_date TIMESTAMP,
                        name VARCHAR (255),
                        PRIMARY KEY (id)
) ;

INSERT INTO "user" (id, birth_date, name)
VALUES ( 1, '30/09/1998' , 'Nephat Mutugi'),
       ( 2, '12/05/1998' , 'Mercy Chero'),
       ( 3, '19/05/2018' , 'Leon Vitonya'),
       ( 3, '19/05/2012' , 'Jayden'),
       ( 3, '19/05/2001' , 'Maureen')

