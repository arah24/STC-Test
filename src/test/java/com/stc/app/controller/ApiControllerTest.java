package com.stc.app.controller;

import com.stc.app.service.ApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Simple unit test for Controller
 */
@WebMvcTest(ApiController.class)
@RunWith(SpringRunner.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @Test
    public void testForController() throws Exception {
        String expected = "{\"test\":\"testVal\"}";
        when(apiService.getFile()).thenReturn(expected);
        mockMvc.perform(
                get("/files"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));

        verify(apiService, atLeastOnce()).getFile();

    }
}
