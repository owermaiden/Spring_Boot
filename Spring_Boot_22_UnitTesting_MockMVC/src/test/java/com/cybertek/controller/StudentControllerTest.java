package com.cybertek.controller;

import com.cybertek.entity.Student;
import com.cybertek.service.StudentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class) // this annotation doesnt inject dependencies automaticly, so we need to inject them
// @SpringBootTest -> if we add this annotation, we dont need to inject dependencies, this annotation does it for us
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean  // because we use @WebMvcTest annotation, we need to inject Student Controller's dependencies like here...
    StudentService studentService;

    @Test  // this is integration testing...we used database also...
    void getStudent_service() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 0,\"firstName\": \"Mike\",\"lastName\": \"Smith\",\"age\": 20}"))
                .andReturn();
    }

    @Test // this is unit testing...we used mock userservice to retrieve mock data...
    void getStudent_data() throws Exception {

        when(studentService.getStudent_data()).thenReturn(Arrays.asList(
                new Student("ozzy","can",20),
                new Student("tom","hanks",50)
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":0,\"firstName\":\"ozzy\",\"lastName\":\"can\",\"age\":20},{\"id\":0,\"firstName\":\"tom\",\"lastName\":\"hanks\",\"age\":50}]"))
                .andReturn();
    }

    @Test
    void jsonAssert() throws JSONException {

        String actual = "{\"id\": 0,\"firstName\": \"Mike\",\"lastName\": \"Smith\",\"age\": 20}";
        String expected = "{\"id\": 0,\"firstName\": \"Mike\",\"lastName\": \"Smith\"}";

        JSONAssert.assertEquals(expected,actual,false);
    }

    @Test
    void jsonAssert_withoutEscapeCharacters() throws JSONException {

        String actual = "{id: 0,firstName:Mike,lastName:Smith,age:20}";
        String expected = "{id:0,firstName:Mike,lastName:Smith}";

        JSONAssert.assertEquals(expected,actual,false);
        // if strict is false -> then if expected is somehow missing, test will pass...
    }

}