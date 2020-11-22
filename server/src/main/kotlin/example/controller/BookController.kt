package example.controller

import example.mapper.BookMapper
import example.model.Book
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller()
class BookController(private val bookMapper: BookMapper) {

    /**
     * 書籍情報の全取得。
     *
     * @return HttpResponse
     */
    @Get("/book")
    fun read(): HttpResponse<List<Book>> {
        return HttpResponse.ok(bookMapper.findAll())
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
}