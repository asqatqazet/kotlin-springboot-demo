package demo.services

import demo.data.Book
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class BookService{
    fun getAllBooks():List<Book> = listOf(
        Book("1","Kotlin in practice","Asqat", LocalDate.now()),
        Book("2","Kotlin in practice","Asqat", LocalDate.parse("2019-10-01")),
    )
}