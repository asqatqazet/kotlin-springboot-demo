package demo.repository

import demo.data.Message
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class MessageRepositoryTest(@Autowired val messageRepository: MessageRepository ){
    @Test
    fun shouldSaveEntity() {

        var savedEntity = messageRepository.save(Message(null,"Marhaba!"))
        val messages = messageRepository.findMessages()
        print(messages)
        assertNotNull(savedEntity)
        assertEquals(1,messages.size)

    }
}