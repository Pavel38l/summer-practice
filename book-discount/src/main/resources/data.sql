DROP TABLE IF EXISTS discount;

CREATE TABLE discount
(
    group_code      VARCHAR (10) PRIMARY KEY,
    discount_value  DECIMAL NOT NULL
);

INSERT INTO discount (group_code, discount_value)
VALUES ('IT', 50),
       ('Math', 20),
       ('Doc', 10),
       ('Marvel', 1),
       ('Child', 10)
;