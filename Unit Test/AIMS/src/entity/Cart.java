package entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.media.Media;

public class Cart {
    
    private List<CartMedia> lstCartMedia;
    private static Cart cartInstance;

    
    /** 
     * @return Cart
     */
    public static Cart getCart(){
        if(cartInstance == null) cartInstance = new Cart();
        return cartInstance;
    }

    public Cart(){
        lstCartMedia = new ArrayList<>();
    }

    
    /** 
     * @param cm
     */
    public void addCartMedia(CartMedia cm){
        lstCartMedia.add(cm);
    }

    
    /** 
     * @param cm
     */
    public void removeCartMedia(CartMedia cm){
        lstCartMedia.remove(cm);
    }

    
    /** 
     * @return List
     */
    public List<CartMedia> getListMedia(){
        return lstCartMedia;
    }

    public void emptyCart(){
        lstCartMedia.clear();
    }

    
    /** 
     * @return int
     */
    public int getTotalMedia(){
        int total = 0;
        for (Object obj : lstCartMedia) {
            CartMedia cm = (CartMedia) obj;
            total += cm.getQuantity();
        }
        return total;
    }

    
    /** 
     * @return int
     */
    public int calSubtotal(){
        int total = 0;
        for (Object obj : lstCartMedia) {
            CartMedia cm = (CartMedia) obj;
            total += cm.getPrice()*cm.getQuantity();
        }
        return total;
    }

    
    /** 
     * @throws SQLException
     */
    public boolean validateAvailabilityOfProduct() throws SQLException{
        boolean allAvai = true;
        for (Object object : lstCartMedia) {
            CartMedia cartMedia = (CartMedia) object;
            int requiredQuantity = cartMedia.getQuantity();
            int availQuantity = cartMedia.getMedia().getQuantity();
            if(requiredQuantity > availQuantity || requiredQuantity <= 0 || availQuantity <= 0) allAvai = false;
            System.out.println(requiredQuantity +"-"+ availQuantity);
        }
        return allAvai;
    }

    
    /** 
     * @param media
     * @return CartMedia
     */
    public CartMedia checkMediaInCart(Media media){
        for (CartMedia cartMedia : lstCartMedia) {
            if (cartMedia.getMedia().getId() == media.getId()) return cartMedia;
        }
        return null;
    }

}
