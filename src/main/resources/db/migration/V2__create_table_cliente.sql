CREATE TABLE cliente(
                    id serial UNIQUE PRIMARY KEY,
                    nome  varchar(255) NOT NULL,
                    email varchar(255) NOT NULL UNIQUE,
                    telefone varchar(255) NOT NULL
);
