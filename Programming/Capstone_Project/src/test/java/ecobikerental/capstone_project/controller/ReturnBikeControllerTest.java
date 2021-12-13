package ecobikerental.capstone_project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReturnBikeControllerTest {

    ReturnBikeController returnBikeController;
    @BeforeEach
    void setUp() {
        returnBikeController = new ReturnBikeController();
    }


    @ParameterizedTest
    @CsvSource({
        "back Khoa, true",
        "back&Khoa123, false",
        ",false"
    })
    void validateDockName(String dockName, boolean expected) {
        boolean isValid = returnBikeController.validateDockName(dockName);
        assertEquals(expected,isValid);
    }
}