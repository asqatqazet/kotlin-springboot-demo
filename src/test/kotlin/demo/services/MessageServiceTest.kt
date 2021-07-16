package demo.services


import demo.data.Message
import demo.repository.MessageRepository
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertEquals


@SpringBootTest
@AutoConfigureMockMvc
internal class MessageServiceTest{


    @Test
    fun shouldReturnAllDefaultMessages(){
       val mockRepo = Mockito.mock(MessageRepository::class.java)
        Mockito.`when`(mockRepo.findMessages()).thenReturn(listOf(Message("1","Hello!"), Message("2","Bonjour!")))
        val service = MessageService(mockRepo)
        val result = service.findMessages()
        assertEquals("Message Length should be equal.",2,result.size)
        assertEquals("",Message("1","Hello!"), result[0])
        assertEquals("",Message("2","Bonjour!"), result[1])
    }

    @Test
    fun shouldSaveMessage(){
        val mockRepo = Mockito.mock(MessageRepository::class.java)
        Mockito.`when`(mockRepo.save(Message("id","Lorem ipsum"))).thenReturn(null)
        val service = MessageService(mockRepo)
       service.post(Message("id","shdfisdhf"))
       Mockito.verify(mockRepo).save(Message("id","shdfisdhf"))
    }

}