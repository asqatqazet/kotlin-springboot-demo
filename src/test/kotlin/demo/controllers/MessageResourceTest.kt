package demo.controllers

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
internal class MessageResourceTest(@Autowired val mockMvc:MockMvc){

    //test get request
    @Test
    fun shouldReturnListOfGreetingMessagesWithCorrectContentType(){
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType("APPLICATION/JSON"))
    }

    //test post request
    @Test
    fun shouldSaveMessageSentByMockMvc(){
        mockMvc.perform(MockMvcRequestBuilders.post("/").contentType("APPLICATION/JSON")
            .content("{\"text\":\"Shalom!\"}"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Shalom!")))
    }

}