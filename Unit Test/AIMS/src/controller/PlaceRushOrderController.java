package controller;

public class PlaceRushOrderController {
	
	
	public boolean validateRushOrderProvince(String province) {
        if(!province.equals("Ha Noi"))
            return false;
        return true;
    }
}
