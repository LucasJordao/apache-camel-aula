CREATE TABLE category (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category_id UUID,
    CONSTRAINT fk_book_category
        FOREIGN KEY (category_id)
        REFERENCES category(id)
);

INSERT INTO category (id, name)
VALUES ('8f3c9b6b-2d8c-4e6f-9c54-847bb2b1c1f2', 'Romance');