package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.*

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}


data class Message(val id:String?, val text: String)
data class Book(val id: String?,val name:String, val author : String, val writeAt:LocalDate)

@RestController
class MessageResource{
	@GetMapping
	fun index():List<Message> = listOf(
		Message("1","Hello!"),
		Message("2","Bonjour"),
		Message("3","privet"),
		Message(null,"Salem"),
	)
	@GetMapping("/books")
	fun getBooks():List<Book> = listOf(
		Book("1","Kotlin in practice","Asqat",LocalDate.now()),
		Book("2","Kotlin in practice","Asqat",LocalDate.parse("2019-10-01")),
	)
}
