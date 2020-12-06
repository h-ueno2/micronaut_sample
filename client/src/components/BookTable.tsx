import React, { useEffect, useState } from "react";
import { BookData } from "types/BookData";
import Paper from "@material-ui/core/Paper";
import BookTableRow from "./BookTableRow";
import TableContainer from "@material-ui/core/TableContainer";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableBody from "@material-ui/core/TableBody";
import axios, { AxiosError } from "axios";
import { ResponseGetBook } from "types/ResponseGetBook";
import { ResponseError } from "types/ResponseError";

const BookTable = () => {
  const [bookDatas, setBookDatas] = useState([] as Array<BookData>);
  useEffect(() => {
    axios
      .create({
        baseURL: "http://localhost:8080",
      })
      .get<ResponseGetBook>("/book")
      .then((res) => {
        setBookDatas(res.data.books);
      })
      .catch((e: AxiosError<ResponseError>) => {
        if (e.response !== undefined) {
          console.error(e.response.data.error);
        }
      });
  });

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
