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

-- 確認用の初期データ
INSERT INTO book (id, name, publisher, publication_date, created_at, updated_at) VALUES (1, 'テスト書籍1', 'テスト出版社A', null, current_timestamp, current_timestamp);
INSERT INTO book (id, name, publisher, publication_date, created_at, updated_at) VALUES (2, 'テスト書籍2', 'テスト出版社A', null, current_timestamp, current_timestamp);
