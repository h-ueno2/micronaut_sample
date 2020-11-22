package example.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import java.sql.Date


/**
 * 書籍データクラス
 */
@Introspected
data class Book(
        @JsonProperty("id")
        var id: Int?,

        @JsonProperty("name")
        var name: String,

        @JsonProperty("publisher")
        var publisher: String?,

        @JsonProperty("publication_date")
        var publicationDate: Date?,
)