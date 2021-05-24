
public class Supplier {
    private int supp_id;
    private String supp_name;
    private String country;
    private String phone;
    private String address;
    private String email;

    public Supplier(int supp_id, String supp_name, String country, String phone, String address, String email) {
        this.supp_id = supp_id;
        this.supp_name = supp_name;
        this.country = country;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public int getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(int supp_id) {
        this.supp_id = supp_id;
    }

    public String getSupp_name() {
        return supp_name;
    }

    public void setSupp_name(String supp_name) {
        this.supp_name = supp_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
