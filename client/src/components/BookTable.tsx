import React from "react";
import { BookData } from "types/BookData";
import BookTableRow from "./BookTableRow";

const dammyData: BookData[] = [
  {
    id: 1,
    name: "test book",
    publisher: "テスト出版社",
    publication_date: "2020-11-20",
  },
  {
    id: 2,
    name: "テスト書籍",
    publisher: "テスト出版社",
    publication_date: "2020-11-21",
  },
  {
    id: 3,
    name: "あああ",
    publisher: "テスト出版社",
    publication_date: "2020-11-22",
  },
];

const BookTable = () => {
  const bookDatas = dammyData;
  const bookDataRows = bookDatas.map((b) => {
    return <BookTableRow book={b} />;
  });
  return (
    <div>
      <table>{bookDataRows}</table>
    </div>
  );
};

export default BookTable;
