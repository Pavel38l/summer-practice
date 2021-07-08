DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    author          VARCHAR(250) NOT NULL,
    title           VARCHAR(250) NOT NULL,
    price           DECIMAL NOT NULL,
    group_code      VARCHAR (10)
);

INSERT INTO book (id, author, title, price, group_code)
VALUES (1, 'Author 1', 'Book 1', 100, 'IT'),
       (2, 'Author 2', 'Book 2', 500, 'Math'),
       (3, 'Author 3', 'Book 3', 400, 'Doc'),
       (4, 'Author 4', 'Book 4', 300, 'IT'),
       (5, 'Author 5', 'Book 5', 200, 'Other');
