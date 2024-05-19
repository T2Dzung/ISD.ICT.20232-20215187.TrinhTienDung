
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

class ValidateDeliveryInfo {

	private PlaceOrderController placeOrderController;
	
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"0123456789, true",
		"01234, false",
		"abc123, false",
		"1234567890, false"
	})
	public void testValidatePhoneNumber(String phone, boolean expected) {
		boolean isValided = placeOrderController.validatePhoneNumber(phone);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"dung trinh, true",
		"dungTrinh, true",
		"!dungtrinh, false",
		",false"
	})
	public void testValidateName(String name, boolean expected) {
		boolean isValided = placeOrderController.validateName(name);
		assertEquals(expected, isValided);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1 dai co viet, true",
		"hanoi, true",
		"abc123@, false",
		", false"
	})
	public void testValidateAddress(String address, boolean expected) {
		boolean isValided = placeOrderController.validateAddress(address);
		assertEquals(expected, isValided);
	}	

}
