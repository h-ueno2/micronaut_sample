package example.service

import example.mapper.BookMapper
import example.model.Book
import org.apache.ibatis.session.SqlSessionFactory
import javax.inject.Singleton

@Singleton
class BookService(private val sqlSessionFactory: SqlSessionFactory) : BookMapper {

    override fun findById(id: Int): Book {
        sqlSessionFactory.openSession().use { session ->
            val bookMapper = session.getMapper(BookMapper::class.java)
            return bookMapper.findById(id)
        }
    }
}