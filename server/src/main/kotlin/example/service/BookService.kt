package example.service

import example.mapper.BookMapper
import example.model.Book
import org.apache.ibatis.session.SqlSessionFactory
import javax.inject.Singleton

@Singleton
class BookService(private val sqlSessionFactory: SqlSessionFactory) : BookMapper {

    override fun findAll(): List<Book> {
        sqlSessionFactory.openSession().use { session ->
            val bookMapper = session.getMapper(BookMapper::class.java)
            return bookMapper.findAll()
        }
    }

    override fun findById(id: Int): Book {
        sqlSessionFactory.openSession().use { session ->
            val bookMapper = session.getMapper(BookMapper::class.java)
            return bookMapper.findById(id)
        }
    }

    override fun insert(book: Book) {
        sqlSessionFactory.openSession().use { session ->
            val bookMapper = session.getMapper(BookMapper::class.java)
            bookMapper.insert(book)
            session.commit()
        }
    }

    override fun update(book: Book) {
        sqlSessionFactory.openSession().use { session ->
            val bookMapper = session.getMapper(BookMapper::class.java)
            bookMapper.update(book)
            session.commit()
        }
    }

}