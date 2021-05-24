
public class Shop {
    private int shop_id;
    private String shop_name;
    private String shop_address;
    private String shop_email;

    public Shop(int shop_id, String shop_name, String shop_address, String shop_email) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.shop_address = shop_address;
        this.shop_email = shop_email;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_email() {
        return shop_email;
    }

    public void setShop_email(String shop_email) {
        this.shop_email = shop_email;
    }
    
    
}
