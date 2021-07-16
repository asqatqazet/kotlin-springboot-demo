package demo.controllers

import demo.data.Book
import demo.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class BookController (val bookService: BookService){
    @GetMapping("/books")
    fun getBooks():List<Book> = bookService.getAllBooks();
}