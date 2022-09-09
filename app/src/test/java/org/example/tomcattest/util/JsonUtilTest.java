package org.example.tomcattest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tomcattest.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

public class JsonUtilTest {
    private JsonUtil classToTest;

    @BeforeEach
    void setup() {
        this.classToTest = new JsonUtil(new ObjectMapper());
    }

    @Test
    void constructor_throws_IAE_on_null_objectMapper() {
        assertThrows(IllegalArgumentException.class, () -> new JsonUtil(null));
    }

    @Test
    void convertJsonToObject_returns_valid_output_on_valid_input() {
        var input = "{ \"message\": \"hello!\" }";
        var expectedMessage = Message.builder().message("hello!").build();
        var actualMessage = this.classToTest.convertJsonToObject(input, Message.class);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void convertJsonToObject_throws_exception_on_invalid_input() {
        var input = "{ \"message\": \"hello!\" ";
        var exception = assertThrows(RuntimeException.class, () -> this.classToTest.convertJsonToObject(input, Message.class));

        assertEquals("Error converting from json", exception.getMessage());
    }

    @Test
    void convertObjectToJson_returns_valid_output_on_valid_input() {
        var expectedJson = "{\"message\":\"hello!\"}";
        var message = Message.builder().message("hello!").build();
        var actualJson = this.classToTest.convertObjectToJson(message);

        assertEquals(expectedJson, actualJson);
    }

    @Test
    void convertObjectToJson_throws_exception_on_invalid_input() throws Exception {
        var objectMapper = Mockito.mock(ObjectMapper.class);
        Mockito.when(objectMapper.writeValueAsString(any())).thenThrow(JsonProcessingException.class);

        this.classToTest = new JsonUtil(objectMapper);
        var exception = assertThrows(RuntimeException.class, () -> this.classToTest.convertObjectToJson(null));

        assertFalse(exception instanceof NullPointerException);
    }

}
