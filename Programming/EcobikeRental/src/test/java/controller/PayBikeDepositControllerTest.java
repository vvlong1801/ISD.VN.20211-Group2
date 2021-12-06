package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PayBikeDepositControllerTest {

    PayBikeDepositController payBikeDepositController;
    @BeforeEach
    void setUp() {
        payBikeDepositController = new PayBikeDepositController();
    }

    @ParameterizedTest
    @CsvSource({
            "10/25,true",
            "10//25,false",
            ",false"
    })
    void validateExpirationDate(String expDate, boolean expected) {
        boolean isValid = payBikeDepositController.validateExpirationDate(expDate);
        assertEquals(expected,isValid);
    }

    @ParameterizedTest
    @CsvSource({
            "123,true",
            "123456,false",
            "1ab, false",
            "123abc, false",
            ",false"
    })
    void validateCvvCode(String cvvCode,boolean expected) {
        boolean isValid = payBikeDepositController.validateCvvCode(cvvCode);
        assertEquals(expected,isValid);
    }
}