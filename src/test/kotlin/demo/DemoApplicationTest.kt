package demo

import demo.controllers.BookController
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
internal class DemoApplicationTest  (@Autowired val bookController: BookController,
                                     @Autowired val mockMvc: MockMvc
                                     ){
    @Test
    fun contextLoads(){
        assertThat(bookController).isNotNull
    }

    @Test
    fun shouldReturnDefaultBookList(){
        mockMvc.perform(get("/")).andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Salem!")))
    }
}
