package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

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
        boolean isValid = rentBikeController.validateBarcode(barcode);
        assertEquals(expected,isValid);
    }
}