package org.example.tomcattest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tomcattest.model.Message;
import org.example.tomcattest.util.JsonUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiControllerTest {

    private final JsonUtil jsonUtil = new JsonUtil(new ObjectMapper());
    private ApiController classToTest;

    @BeforeAll
    void setup() {
        this.classToTest = new ApiController(jsonUtil);
    }

    @Test
    void constructor_throws_IAE_on_null_jsonUtil() {
        assertThrows(IllegalArgumentException.class, () -> new ApiController(null));
    }

    @Test
    void getMessage_returns_hello_world() {
        var response = this.classToTest.getMessage();
        var expectedMessage = Message.builder().message("hello world!").build();
        var actualMessage = jsonUtil.convertJsonToObject(response.getEntity().toString(), Message.class);

        assertEquals(200, response.getStatus());
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void getMessage_returns_hello_name_on_valid_input() {
        var response = this.classToTest.getMessage("name");
        var expectedMessage = Message.builder().message("hello name!").build();
        var actualMessage = jsonUtil.convertJsonToObject(response.getEntity().toString(), Message.class);

        assertEquals(200, response.getStatus());
        assertEquals(actualMessage, expectedMessage);
    }

}
