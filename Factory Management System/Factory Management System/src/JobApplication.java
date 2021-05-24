
public class JobApplication {
    private int application_id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
    private int dpt_id;
    private String work_type;

    public JobApplication(int application_id, String name, String surname, String address, String phone, String email, int dpt_id, String work_type) {
        this.application_id = application_id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dpt_id = dpt_id;
        this.work_type = work_type;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDpt_id() {
        return dpt_id;
    }

    public void setDpt_id(int dpt_id) {
        this.dpt_id = dpt_id;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }
    
    
}
