package demo.services

import demo.data.Message
import demo.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(var db: MessageRepository){

    fun findMessages():List<Message> = db.findMessages()

    fun post(message: Message){
        db.save(message)
    }
}