package ecobikerental.capstone_project.business_layer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BikeBLTest {


    @ParameterizedTest
    @CsvSource({
        "1234567890123,true",
        "123456,false",
        "1234567890abc,false",
        "123abc,false",
        ",false"
    })
    @Test
    void validateBarcode(String barcode, boolean expected) {
        boolean isValid = BikeBL.validateBarcode(barcode);
        assertEquals(expected,isValid);
    }

    @ParameterizedTest
    @CsvSource({
        "1013798044108,10137980441081234561013798044108",
        "1389540509283,13895405092831234561389540509283",
        "1450428915111,14504289151111234561450428915111",
    })
    @Test
    void convertBarcodeToBikeCode(String barcode, String expected) {
        String bikeCode = BikeBL.convertBarcodeToBikeCode(barcode);
        assertEquals(bikeCode,expected);
    }
}