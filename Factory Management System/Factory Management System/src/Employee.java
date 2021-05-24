
public class Employee extends Person {
    
    private int dpt_id;
    private String email;
    private String Job;
    private float salary;
    
    public Employee(int id, String name, String surname, String birth_date, String nationality, String address, String phone,int dpt_id,String email,String job,float salary) {
        super(id, name, surname, birth_date, nationality, address, phone);
        this.dpt_id = dpt_id;
        this.email = email;
        this.Job = job;
        this.salary = salary;
        
    }

    public int getDpt_id() {
        return dpt_id;
    }

    public void setDpt_id(int dpt_id) {
        this.dpt_id = dpt_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    
    
    
    
}
