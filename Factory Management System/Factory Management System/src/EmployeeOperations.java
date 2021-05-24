
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmployeeOperations implements Operations{
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
     public EmployeeOperations(){
        String url = "jdbc:mysql://" + DataAccess.host + ":" + DataAccess.port + "/" + DataAccess.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver cannot found....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, DataAccess.name, DataAccess.password);
            System.out.println("Access successfully...");
            
            
        } catch (SQLException ex) {
            System.out.println("Access not successfully...");
            //ex.printStackTrace();
        }
    }
     
    public ArrayList<Employee> showEmployees(){
        ArrayList<Employee> output = new ArrayList<Employee>();
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM employees";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int emp_id = rs.getInt("emp_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String birth_date = rs.getString("birth_date");
                String nationality = rs.getString("nationality");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int dpt_id = rs.getInt("dpt_id");
                String email = rs.getString("email");
                String job = rs.getString("job");
                float salary = rs.getFloat("salary");
                
                output.add(new Employee(emp_id, name,surname,birth_date,nationality,address,phone,dpt_id,email,job,salary));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    }
    
    public void updateEmployee(int new_id,String name,String surname,String birth_date,String nationality,String address,String phone,int dpt_id,String email,String job,float salary){
        
        String query = "UPDATE employees set name = ? , surname = ? , birth_date = ? ,nationality = ?, address = ?,phone = ?,dpt_id = ? ,email = ?,job = ?,salary = ? WHERE emp_id = ?";
        
        try {
            
            
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birth_date);
            preparedStatement.setString(4, nationality);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phone);
            preparedStatement.setInt(7, dpt_id);
            preparedStatement.setString(8, email);
            preparedStatement.setString(9, job);
            preparedStatement.setFloat(10, salary);
            preparedStatement.setInt(11, new_id);
            
            preparedStatement.executeUpdate();
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void addEmployee(String name,String surname,String birth_date,String nationality,String address,String phone,int dpt_id,String email,String job,float salary){
        
        String query = "INSERT INTO employees (name,surname,birth_date,nationality,address,phone,dpt_id,email,job,salary) VALUES(?,?,?,?,?,?,?,?,?,?) ";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birth_date);
            preparedStatement.setString(4, nationality);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phone);
            preparedStatement.setInt(7, dpt_id);
            preparedStatement.setString(8, email);
            preparedStatement.setString(9, job);
            preparedStatement.setFloat(10, salary);
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    

    @Override
    public void delete(int id) {
        String query = "DELETE  FROM employees WHERE emp_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
