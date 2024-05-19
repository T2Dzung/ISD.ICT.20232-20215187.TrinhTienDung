

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceRushOrderController;

class ValidateRushOrderProvince {

	private PlaceRushOrderController placeRushOrderController;

    @BeforeEach
    void setUp() throws Exception {
        placeRushOrderController = new PlaceRushOrderController();
    }

    @ParameterizedTest
    @CsvSource({
        "Ha Noi, true",
        "HCM city, false",
    })

    public void test(String province, boolean expected) {
        boolean isValid = placeRushOrderController.validateRushOrderProvince(province);
        assertEquals(expected, isValid);
    }

}
