CREATE TABLE users(
  id serial UNIQUE PRIMARY KEY,
  nome  varchar(255) NOT NULL,
  email varchar(255) NOT NULL UNIQUE,
  senha varchar(255) NOT NULL,
  role  varchar(50)  NOT NULL
);
