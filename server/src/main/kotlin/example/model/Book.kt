package example.model

import com.fasterxml.jackson.annotation.JsonFormat
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

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @JsonProperty("publication_date")
        var publicationDate: Date?,
)