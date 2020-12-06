package example.controller

import example.mapper.BookMapper
import example.model.Book
import example.model.BookResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put


@Controller()
class BookController(private val bookMapper: BookMapper) {

    /**
     * 書籍情報の全取得。
     *
     * @return HttpResponse
     */
    @Get("/book")
    fun read(): HttpResponse<BookResponse> {
        return HttpResponse.ok(BookResponse(bookMapper.findAll()))
    }

    /**
     * 書籍情報の取得。
     * ID指定
     *
     * @param id 書籍ID
     *
     * @return HttpResponse
     */
    @Get("/book/{id}")
    fun readById(id: Int): HttpResponse<Book> {
        return HttpResponse.ok(bookMapper.findById(id))
    }

    /**
     * 書籍情報の登録。
     */
    @Post("/book")
    fun create(book: Book): HttpResponse<String> {
        bookMapper.insert(book)
        return HttpResponse.ok()
    }

    /**
     * 書籍情報の更新。
     */
    @Put("/book")
    fun update(book: Book): HttpResponse<String> {
        bookMapper.update(book)
        return HttpResponse.ok()
    }
}