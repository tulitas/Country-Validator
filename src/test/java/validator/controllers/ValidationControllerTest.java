package validator.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationControllerTest {
    private String message = "oops! Where is it?";
    @Test
    void getCharNum() {
        assertEquals(message, new ValidationController().getMessage());
    }
}