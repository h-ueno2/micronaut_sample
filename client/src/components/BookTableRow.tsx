import React from "react";
import { BookData } from "types/BookData";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";

type BookTableRowProps = {
  book: BookData;
};

const BookTableRow = (props: BookTableRowProps) => {
  return (
    <TableRow>
      <TableCell>{props.book.name}</TableCell>
      <TableCell>{props.book.publisher}</TableCell>
      <TableCell>{props.book.publication_date}</TableCell>
    </TableRow>
  );
};

export default BookTableRow;
