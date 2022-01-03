package ecobikerental.capstone_project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ecobikerental.capstone_project.business_layer.BikeBL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RentBikeControllerTest {

    private RentBikeController rentBikeController;
    @BeforeEach
    void setUp() {
        rentBikeController = new RentBikeController();
    }

    @ParameterizedTest
    @CsvSource({
        "1234567890123,true",
        "123456,false",
        "1234567890abc,false",
        "123abc,false",
        ",false"
    })
    void validateBarcode(String barcode,boolean expected) {
        boolean isValid = BikeBL.validateBarcode(barcode);
        assertEquals(expected,isValid);
    }
}