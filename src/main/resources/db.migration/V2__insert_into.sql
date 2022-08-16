--INSERT INTO genres(id, name)
--VALUES (nextval('genres_id_seq'), 'Fiction'), (nextval('genres_id_seq'), 'Non-Fiction'), (nextval('genres_id_seq'), 'Drama'), (nextval('genres_id_seq'),'Science fiction'),
--(nextval('genres_id_seq'), 'Fantasy'), (nextval('genres_id_seq'), 'Fairy tale'), (nextval('genres_id_seq'), 'History'),(nextval('genres_id_seq'), 'Thriller'), (nextval('genres_id_seq'), 'Mystery');
--
--
--INSERT INTO authors(id, surname, name, middlename, dateOfBirth) VALUES
--(nextval('authors_id_seq'), 'Bradbury', 'Ray', Null, '1920-08-22'),
--(nextval('authors_id_seq'), 'Orwell', 'George,', Null, '1903-06-25');
--
--INSERT INTO publishers(id, name) VALUES
--(nextval('publishers_id_seq'), 'EKSMO'), (nextval('publishers_id_seq'), 'ROSMEN');
--
--INSERT INTO books(id, name, price, numOfPages, productionYear, publisher_id) VALUES
--(nextval('books_id_seq'), 'The Dandelion Wine', 2000, 352, 2017, 1),
--(nextval('books_id_seq'), 'Animal Farm', 1700, 256, 2017, 2);
--
--INSERT INTO books_authors(book_id, author_id) VALUES
--(1, 1), (2, 2);
--
--INSERT INTO books_genres(book_id, genre_id) VALUES
--(1, 5), (2,5);
--
--INSERT INTO authors_genres(author_id, genre_id) VALUES
--(1, 5), (2, 5);
--
INSERT INTO genres(id, name)
VALUES (nextval('genres_id_seq'), 'Fiction'), (nextval('genres_id_seq'), 'Non-Fiction'), (nextval('genres_id_seq'), 'Drama'), (nextval('genres_id_seq'),'Science fiction'),
(nextval('genres_id_seq'), 'Fantasy'), (nextval('genres_id_seq'), 'Fairy tale'), (nextval('genres_id_seq'), 'History'),(nextval('genres_id_seq'), 'Thriller'), (nextval('genres_id_seq'), 'Mystery');


INSERT INTO authors(id, surname, name, middlename, dateOfBirth) VALUES
(nextval('authors_id_seq'), 'Bradbury', 'Ray', Null, '1920-08-22'),
(nextval('authors_id_seq'), 'Orwell', 'George,', Null, '1903-06-25');

INSERT INTO publishers(id, name) VALUES
(nextval('publishers_id_seq'), 'EKSMO'), (nextval('publishers_id_seq'), 'ROSMEN');

INSERT INTO books(id, name, price, numOfPages, productionYear, publisher_id) VALUES
(nextval('books_id_seq'), 'The Dandelion Wine', 2000, 352, 2017, 1),
(nextval('books_id_seq'), 'Animal Farm', 1700, 256, 2017, 2);


INSERT INTO users(id, login, password, user_role, is_blocked) VALUES
(nextval('users_id_seq'), 'asem@mail.ru', '1233', 'ADMIN', false),
(nextval('users_id_seq'), 'aliya@mail.ru', '1222', 'USER', false);

INSERT INTO orders(id, user_id, status, order_time) VALUES
(nextval('orders_id_seq'), 1, 'INPROGRESS', '2010-10-19 10:23:54'),
(nextval('orders_id_seq'), 2, 'COMPLETED', '2004-01-20 10:23:54');

INSERT INTO books_authors(book_id, author_id) VALUES
(1, 1), (2, 2);

INSERT INTO books_genres(book_id, genre_id) VALUES
(1, 5), (2,5);

INSERT INTO authors_genres(author_id, genre_id) VALUES
(1, 5), (2, 5);

INSERT INTO order_books(book_id, order_id) VALUES
(1, 1), (2, 2);

