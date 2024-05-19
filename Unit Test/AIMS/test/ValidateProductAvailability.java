import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import entity.Cart;
import entity.CartMedia;
import entity.media.Media;

class ValidateProductAvailability {

	private Cart cart;

	@BeforeEach
	void setUp() throws Exception {
		cart = Cart.getCart();
	}

	@ParameterizedTest
	@CsvSource({
		"10, 11, true",
		"11, 11, true",
		"12, 11, false",
		"0, 11, false",
		"12, 0, false",
		"0, 0, false",
		"-1, 10, false",
		"10, -1, false",
		"12, 11, false",
	})
    public void testValidateProductAvailability(int selectedQty, int availableQty, boolean desiredOutput) throws SQLException {
        cart.emptyCart();
		Media media = new Media("test product", availableQty);
        CartMedia cartMedia = new CartMedia(media, selectedQty, 1);
        cart.addCartMedia(cartMedia);
        boolean result = cart.validateAvailabilityOfProduct();
        assertEquals(desiredOutput, result);
    }


}
