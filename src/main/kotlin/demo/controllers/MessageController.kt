package demo.controllers

import demo.data.Book
import demo.data.Message
import demo.services.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class MessageResource(val service: MessageService){
    @GetMapping
    fun index():List<Message> = service.findMessages()

    @PostMapping
    fun post(@RequestBody message: Message){
        service.post(message)
    }

    @GetMapping("/books")
    fun getBooks():List<Book> = listOf(
        Book("1","Kotlin in practice","Asqat", LocalDate.now()),
        Book("2","Kotlin in practice","Asqat", LocalDate.parse("2019-10-01")),
    )
}