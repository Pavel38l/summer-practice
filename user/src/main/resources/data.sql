DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(250) NOT NULL,
    full_name       VARCHAR(250) NOT NULL
);

INSERT INTO user (id, email, full_name)
VALUES (1, 'user1@gmail.com', 'User1'),
       (2, 'user2@gmail.com', 'User2'),
       (3, 'user3@gmail.com', 'User3'),
       (4, 'user4@gmail.com', 'User4'),
       (5, 'user5@gmail.com', 'User5')
;