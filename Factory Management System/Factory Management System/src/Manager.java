
public class Manager {
    private int mngr_id;
    private String mngr_name;
    private String mngr_surname;
    private String mngr_email;
    private int dpt_id;
    private String address;
    private float salary;
    private String mngr_password;

    public Manager(int mngr_id, String mngr_name, String mngr_surname, String mngr_email, int dpt_id, String address, float salary, String mngr_password) {
        this.mngr_id = mngr_id;
        this.mngr_name = mngr_name;
        this.mngr_surname = mngr_surname;
        this.mngr_email = mngr_email;
        this.dpt_id = dpt_id;
        this.address = address;
        this.salary = salary;
        this.mngr_password = mngr_password;
    }

    public int getMngr_id() {
        return mngr_id;
    }

    public void setMngr_id(int mngr_id) {
        this.mngr_id = mngr_id;
    }

    public String getMngr_name() {
        return mngr_name;
    }

    public void setMngr_name(String mngr_name) {
        this.mngr_name = mngr_name;
    }

    public String getMngr_surname() {
        return mngr_surname;
    }

    public void setMngr_surname(String mngr_surname) {
        this.mngr_surname = mngr_surname;
    }

    public String getMngr_email() {
        return mngr_email;
    }

    public void setMngr_email(String mngr_email) {
        this.mngr_email = mngr_email;
    }

    public int getDpt_id() {
        return dpt_id;
    }

    public void setDpt_id(int dpt_id) {
        this.dpt_id = dpt_id;
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

    public String getMngr_password() {
        return mngr_password;
    }

    public void setMngr_password(String mngr_password) {
        this.mngr_password = mngr_password;
    }
    
    
}
