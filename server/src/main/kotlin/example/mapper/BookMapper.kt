package example.mapper

import example.model.Book
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BookMapper {
    fun findAll(): List<Book>
    fun findById(id: Int): Book
}