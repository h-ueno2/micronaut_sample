package example.model

import io.micronaut.core.annotation.Introspected
import java.sql.Date


/**
 * 書籍データクラス
 */
@Introspected
data class Book(
        var id: Int?,
        var name: String,
        var publisher: String?,
        var publicationDate: Date?,
)