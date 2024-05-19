package controller;


public class PlaceOrderController {

	public boolean validatePhoneNumber(String phoneNumber) {
    	if(phoneNumber.length() != 10) return false;
    	if(!phoneNumber.startsWith("0")) return false;
    	if (phoneNumber.matches("^[0-9]*$") == false)
            return false;
    	return true;
    }
    
    public boolean validateName(String name) {
        if (name == null)
            return false;
        if (name.trim().length() == 0)
            return false;
        if (name.matches("^[a-zA-Z ]*$") == false)
            return false;
        return true;
    }
    
    public boolean validateAddress(String address) {
        if (address == null)
            return false;
        if (address.trim().length() == 0)
            return false;
        if (address.matches("^[a-zA-Z0-9 ]*$") == false)
            return false;
        return true;
    }

}
