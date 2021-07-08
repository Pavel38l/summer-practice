DROP TABLE IF EXISTS review;

CREATE TABLE review
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    user_id         INT NOT NULL,
    book_id         INT NOT NULL,
    mark            INT NOT NULL,
    text            VARCHAR(500) NOT NULL
);

INSERT INTO review (id, user_id, book_id, mark, text)
VALUES (1, 1, 1, 1, 'review1'),
       (2, 2, 1, 2, 'review2'),
       (3, 3, 3, 3, 'review3'),
       (4, 4, 4, 4, 'review4'),
       (5, 5, 5, 5, 'review5')
;