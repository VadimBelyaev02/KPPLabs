package com.vadim.unit;

import com.vadim.config.ApplicationConfig;
import com.vadim.config.WebInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class, WebInitializer.class})
@WebAppConfiguration("src/main/java/com/vadim")
public class ParallelogramControllerUnitTest {

    private final String ENDPOINT = "/api/parallelogram";

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }

    @Test
    public void givenServletContext_whenInitialize_thenContextExists() {
        ServletContext servletContext = applicationContext.getServletContext();

        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(applicationContext.getBean("parallelogramController"));
    }

    @Test
    public void shouldReturnParallelogramDto() throws Exception {
        String params = "?width=4&height=5";
        this.mockMvc.perform(get(ENDPOINT + params))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.square").value(20))
                .andExpect(jsonPath("$.perimeter").value(18));
    }

    @Test
    public void shouldThrowsMethodArgumentTypeMismatchException() throws Exception {
        String params = "?width=4&height=wrong5";
        this.mockMvc.perform(get(ENDPOINT + params))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Failed to convert value of type 'java.lang.String' " +
                        "to required type 'java.lang.Double'; nested exception is " +
                        "java.lang.NumberFormatException: For input string: \"wrong5\""));
   }

    @Test
    public void shouldThrowsMissingServletRequestParameterException() throws Exception {
        String params = "?height=5";
        this.mockMvc.perform(get(ENDPOINT + params))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Required request parameter " +
                        "'width' for method parameter type Double is not present"));
    }
}
