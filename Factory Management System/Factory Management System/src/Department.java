


public class Department {

    private int dpt_id ;
    private String name;
    private String phone;
    private String address;

    public Department(int dpt_id, String name, String phone, String address) {
        this.dpt_id = dpt_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    
    public int getDpt_id() {
        return dpt_id;
    }

    public void setDpt_id(int dpt_id) {
        this.dpt_id = dpt_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

   
    
    
    
}
