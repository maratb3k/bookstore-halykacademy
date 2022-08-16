--create table authors (
--   id  bigserial not null,
--    dateofbirth date,
--    middlename varchar(255),
--    name varchar(255),
--    surname varchar(255),
--    primary key (id)
--);

--create table genres (
--   id  bigserial not null,
--    name varchar(255),
--    primary key (id)
--);
--
--
--
--create table authors_genres (
--   author_id int8 not null,
--    genre_id int8 not null
--);
--
--
--create table books (
--   id  bigserial not null,
--    name varchar(255),
--    numofpages int4,
--    price float8,
--    productionyear int4,
--    publisher_id int8,
--    primary key (id)
--);
--
--create table books_authors (
--   book_id int8 not null,
--    author_id int8 not null
--)
--
--
--create table books_genres (
--   book_id int8 not null,
--    genre_id int8 not null
--);
--
--create table orders (
--   id  bigserial not null,
--    order_time timestamp,
--    status varchar(255),
--    user_id int8,
--    primary key (id)
--);
--create table publishers (
--   id  bigserial not null,
--    name varchar(255),
--    primary key (id)
--);
--
--
--create table order_books (
--   order_id int8 not null,
--    book_id int8 not null
--);
--
--create table users (
--   id  bigserial not null,
--    is_bloked boolean,
--    login varchar(255),
--    password varchar(255),
--    user_role varchar(255),
--    primary key (id)
--);
--
--alter table authors_genres
--   add constraint FK5466q1xs8d3bwp5jx8c85wvlp
--   foreign key (genre_id)
--   references genres;
--
--alter table authors_genres
--   add constraint FKi425ysu80j6x0ve490w4ldggp
--   foreign key (author_id)
--   references authors;
--
--alter table books
--   add constraint FKayy5edfrqnegqj3882nce6qo8
--   foreign key (publisher_id)
--   references publishers;
--
--alter table books_authors
--   add constraint FK3qua08pjd1ca1fe2x5cgohuu5
--   foreign key (author_id)
--   references authors;
--
--alter table books_authors
--   add constraint FK1b933slgixbjdslgwu888m34v
--   foreign key (book_id)
--   references books;
--
--alter table books_genres
--   add constraint FKgkat05y2cec3tcpl6ur250sd0
--   foreign key (genre_id)
--   references genres;
--
--alter table books_genres
--   add constraint FKlv42b6uemg63q27om39jjbt9o
--   foreign key (book_id)
--   references books;
--
--alter table order_books
--   add constraint FK7jqqp3k5449j9c6sllmyp263l
--   foreign key (book_id)
--   references books;
--
--alter table order_books
--   add constraint FK9ai8wib7jbokb4njnkwb8cy5i
--   foreign key (order_id)
--   references orders;
--
--alter table orders
--   add constraint FK32ql8ubntj5uh44ph9659tiih
--   foreign key (user_id)
--   references users;



CREATE TABLE IF NOT EXISTS genres (
   id SERIAL,
   name VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS authors (
   id SERIAL NOT NULL PRIMARY KEY,
   surname VARCHAR(255),
   name VARCHAR(255) NOT NULL,
   middlename VARCHAR(255),
   dateOfBirth DATE
);

CREATE TABLE IF NOT EXISTS publishers (
   id SERIAL NOT NULL PRIMARY KEY,
   name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
   id SERIAL NOT NULL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   price REAL NOT NULL,
   numOfPages INT,
   productionYear INT,
   publisher_id INT,
   FOREIGN KEY (publisher_id) REFERENCES publishers(id) ON DELETE CASCADE
);

CREATE TYPE orders_status AS ENUM ('CREATED', 'INPROGRESS', 'COMPLETED', 'CANCELED');
CREATE TYPE users_role AS ENUM ('USER', 'ADMIN');

CREATE TABLE IF NOT EXISTS users (
   id SERIAL NOT NULL PRIMARY KEY,
   login VARCHAR(255) NOT NULL,
   password REAL NOT NULL,
   user_role users_role,
   is_blocked bool
);

CREATE TABLE IF NOT EXISTS orders (
   id SERIAL NOT NULL PRIMARY KEY,
   user_id INT,
   status orders_status NOT NULL,
   order_time timestamp with time zone,
   FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- *************************    Many To Many  ************************************
CREATE TABLE IF NOT EXISTS books_authors (
   book_id BIGINT NOT NULL,
   author_id BIGINT NOT NULL,
   FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
   FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS authors_genres (
   author_id BIGINT NOT NULL,
   genre_id BIGINT NOT NULL,
   FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE,
   FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS books_genres (
   book_id BIGINT NOT NULL,
   genre_id BIGINT NOT NULL,
   FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
   FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_books (
   book_id BIGINT NOT NULL,
   order_id BIGINT NOT NULL,
   FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
   FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

