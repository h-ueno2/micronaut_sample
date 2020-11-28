package example.service

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.apache.ibatis.session.SqlSessionFactory
import org.dbunit.IDatabaseTester
import org.dbunit.JdbcDatabaseTester
import org.dbunit.database.DatabaseConfig
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.xml.FlatXmlDataSet
import org.dbunit.operation.DatabaseOperation
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

@MicronautTest
class BookServiceTest(private val sqlSessionFactory: SqlSessionFactory) {
    lateinit var dataBaseTester: IDatabaseTester

    @BeforeEach
    fun setUp() {
        dataBaseTester = JdbcDatabaseTester(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/test",
                "postgres",
                "postgres",
                "public"
        )
        println("Setup")

        val dataSet: IDataSet = FlatXmlDataSet(TestFileUtils.getResourceFile("before.xml").toFile())

        dataBaseTester.dataSet = dataSet
        dataBaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT)
        dataBaseTester.onSetup()
    }

    @AfterEach
    fun tearDown() {
        dataBaseTester.setTearDownOperation(DatabaseOperation.NONE)
        dataBaseTester.onTearDown()
    }

    @Test
    fun findAllTest() {
        val service: BookService = BookService(sqlSessionFactory)
        val actual = service.findAll()
        println("list:$actual")
    }

    object TestFileUtils {
        fun getResourceFile(fileName: String, dir: String = "data"): Path =
                Paths.get(this.javaClass.classLoader.getResource("$dir/$fileName").toURI())
    }

}