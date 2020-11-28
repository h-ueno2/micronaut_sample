set client_encoding = 'UTF8';

CREATE TABLE book (
  id SERIAL,
  name VARCHAR(200) NOT NULL,
  publisher VARCHAR(200),
  publication_date DATE,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  CONSTRAINT pk_book PRIMARY KEY (id)
);

COMMENT ON TABLE book IS '書籍';

COMMENT ON COLUMN book.id IS 'ID';
COMMENT ON COLUMN book.name IS '書籍名';
COMMENT ON COLUMN book.publisher IS '出版社';
COMMENT ON COLUMN book.publication_date IS '出版日';
COMMENT ON COLUMN book.created_at IS '登録日時';
COMMENT ON COLUMN book.updated_at IS '更新日時';

