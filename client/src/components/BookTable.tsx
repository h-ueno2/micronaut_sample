import React from "react";
import { BookData } from "types/BookData";
import Paper from "@material-ui/core/Paper";
import BookTableRow from "./BookTableRow";
import TableContainer from "@material-ui/core/TableContainer";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableBody from "@material-ui/core/TableBody";

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
    return <BookTableRow key={b.id} book={b} />;
  });

  const columns: BookData = {
    id: 0,
    name: "書籍名",
    publisher: "出版社名",
    publication_date: "出版日",
  };
  const columnsRow = <BookTableRow book={columns} />;

  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>{columnsRow}</TableHead>
        <TableBody>{bookDataRows}</TableBody>
      </Table>
    </TableContainer>
  );
};

export default BookTable;
