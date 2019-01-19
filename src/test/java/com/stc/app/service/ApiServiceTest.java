package com.stc.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.app.util.CryptoUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private CryptoUtil cryptoUtil;

    private ApiService apiService;
    private MockRestServiceServer mockServer;
    private ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
        apiService = new ApiService(cryptoUtil);
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGetFiles() throws Exception {
        when(cryptoUtil.decrypt(anyString())).thenReturn(anyString());
        mockServer
                .expect(once(), requestTo("http://localhost:8080/files"))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString("")));

        assertNotNull(apiService.getFile());
    }
}