package ecobikerental.capstone_project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PayBikeDepositControllerTest {

    PayBikeDepositController paymentController;
    @BeforeEach
    void setUp() {
        paymentController = new PayBikeDepositController();
    }
//
//    @ParameterizedTest
//    @CsvSource({
//        "10/25,true",
//        "10//25,false",
//        ",false"
//    })
////    void validateExpirationDate(String expDate, boolean expected) {
////        boolean isValid = paymentController.validateExpirationDate(expDate);
////        assertEquals(expected,isValid);
////    }
////
////    @ParameterizedTest
////    @CsvSource({
////        "123,true",
////        "123456,false",
////        "1ab, false",
////        "123abc, false",
////        ",false"
////    })
////    void validateCvvCode(String cvvCode,boolean expected) {
////        boolean isValid = paymentController.validateCvvCode(cvvCode);
////        assertEquals(expected,isValid);
////    }
}