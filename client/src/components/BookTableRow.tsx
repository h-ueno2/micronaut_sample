import React from "react";
import { BookData } from "types/BookData";

type BookTableRowProps = {
  book: BookData;
};

const BookTableRow = (props: BookTableRowProps) => {
  return (
    <tr>
      <td>{props.book.name}</td>
      <td>{props.book.publisher}</td>
      <td>{props.book.publication_date}</td>
    </tr>
  );
};

export default BookTableRow;
