import axios, {AxiosInstance} from "axios";
import { BookData } from "types/BookData";
import { ResponseGetBook } from "types/ResponseGetBook";

export default class ApiConnector {
  ax: AxiosInstance;
  baseUrl = "http://localhost:8080";

  constructor(){
    this.ax = axios.create({
      baseURL: this.baseUrl,
    });
  }

  async getBook(): Promise<BookData[]> {
    let books: Array<BookData> = [];
    await this.ax.get<ResponseGetBook>("/book")
      .then((res) => {
        books = res.data.books;
      })
    return books;
  }
}
