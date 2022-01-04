package ecobikerental.capstone_project.business_layer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CreditCardBLTest {

    @ParameterizedTest
    @CsvSource({
        "11/25, 774, true",
        "13/25, 774, false",
        "11/25, 7747, false",
        "13/25, 7747, false"
    })
    @Test
    void validateCreditCardInfo(String expDate, String cvvCode, boolean expected) {
        boolean isValid = CreditCardBL.validateCreditCardInfo(expDate,cvvCode);
        assertEquals(isValid, expected);
    }

    @ParameterizedTest
    @CsvSource({
        "11/25, 1125",
        "13/25, "
    })
    @
    @Test
    void getExpirationDate(String expDate, Object expected) {
        String expDateConvert = CreditCardBL.getExpirationDate(expDate);
        assertEquals(expDateConvert,expected);
    }
}