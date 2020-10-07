package com.produto.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControlerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void controler() throws URISyntaxException {
    URI uri = new URI("/auth");
    String json = "{\"email\":\"gustavomm9@hotmail.com\", \"senha\":\"1234\" }";
    try {
      mockMvc.perform(MockMvcRequestBuilders
          .post(uri)
          .content(json)
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(MockMvcResultMatchers.status().isBadRequest());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
