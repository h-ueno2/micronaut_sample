package example

import io.micronaut.context.annotation.Factory
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.apache.ibatis.transaction.TransactionFactory
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory
import javax.inject.Singleton
import javax.sql.DataSource

@Factory
class MybatisFactory(private val dataSource: DataSource) {

    @Singleton
    fun sqlSessionFactory(): SqlSessionFactory {
        val transactionFactory: TransactionFactory = JdbcTransactionFactory()

        val environment = Environment("dev", transactionFactory, dataSource)
        val configuration = Configuration(environment)
        // mapperをスキャンするパッケージを指定。
        configuration.addMappers("example")

        return SqlSessionFactoryBuilder().build(configuration)
    }
}