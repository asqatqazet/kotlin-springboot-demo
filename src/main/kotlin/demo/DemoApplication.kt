package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.relational.core.mapping.Table
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@Table("MESSAGES")
data class Message(@Id val id:String?, val text: String)
data class Book(val id: String?,val name:String, val author : String, val writeAt:LocalDate)

interface MessageRepository : CrudRepository<Message,String>{

	@Query("select * from messages")
	fun findMessages():List<Message>
}
@Service
class MessageService(val db: MessageRepository){

	fun findMessages():List<Message> = db.findMessages()

	fun post(message: Message){
		db.save(message)
	}
}


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
		Book("1","Kotlin in practice","Asqat",LocalDate.now()),
		Book("2","Kotlin in practice","Asqat",LocalDate.parse("2019-10-01")),
	)
}
