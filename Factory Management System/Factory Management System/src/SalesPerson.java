
public class SalesPerson {
    private int sp_id;
    private String sp_name;
    private String sp_surname;
    private int shop_id;
    private String sp_email;
    private String phone;
    private String address;
    private float salary;
    private String sp_password;

    public SalesPerson(int sp_id, String sp_name, String sp_surname, int shop_id, String sp_email, String phone, String address, float salary, String sp_password) {
        this.sp_id = sp_id;
        this.sp_name = sp_name;
        this.sp_surname = sp_surname;
        this.shop_id = shop_id;
        this.sp_email = sp_email;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.sp_password = sp_password;
    }

    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }

    public String getSp_name() {
        return sp_name;
    }

    public void setSp_name(String sp_name) {
        this.sp_name = sp_name;
    }

    public String getSp_surname() {
        return sp_surname;
    }

    public void setSp_surname(String sp_surname) {
        this.sp_surname = sp_surname;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getSp_email() {
        return sp_email;
    }

    public void setSp_email(String sp_email) {
        this.sp_email = sp_email;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getSp_password() {
        return sp_password;
    }

    public void setSp_password(String sp_password) {
        this.sp_password = sp_password;
    }
    
    
}
