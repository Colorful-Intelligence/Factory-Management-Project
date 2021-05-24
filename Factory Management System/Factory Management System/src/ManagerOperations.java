
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManagerOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
     public ManagerOperations(){
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
     
     
     public boolean Login(int id , String password){
        String query =  "Select * From managers where manager_id = ? and mng_password = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,password);
            
            ResultSet rs =  preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
     
     }
     
     
     
     public ArrayList<Manager> showManagers(){
         
         ArrayList<Manager> output = new ArrayList<Manager>();
         
         try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM managers";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("manager_id");
                String name = rs.getString("manager_name");
                String surname = rs.getString("manager_surname");
                String email = rs.getString("manager_email");
                int dpt_id = rs.getInt("dpt_id");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                String password = rs.getString("mng_password");
                
                output.add(new Manager(id, name, surname, email, dpt_id, address, salary, password));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
     
     
     
     }
     
     
     
     public void addManager(String name,String surname,String email,int dpt_id,String address,float salary,String password){
         
         String query = "INSERT INTO managers (manager_name,manager_surname,manager_email,dpt_id,address,salary,mng_password) VALUES (?,?,?,?,?,?,?)";
         
         try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, dpt_id);
            preparedStatement.setString(5, address);
            preparedStatement.setFloat(6, salary);
            preparedStatement.setString(7, password);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
     }
     
     
     public void updateManager(int new_id,String name,String surname,String email,int dpt_id,String address,float salary,String password){
         
         String query = "UPDATE managers set manager_name = ? ,manager_surname = ? ,manager_email = ? ,dpt_id = ? ,address = ? ,salary = ? ,mng_password = ? WHERE manager_id = ?";
         try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, dpt_id);
            preparedStatement.setString(5, address);
            preparedStatement.setFloat(6, salary);
            preparedStatement.setString(7, password);
            preparedStatement.setInt(8, new_id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     
     
     
     }
     
     
     

    @Override
    public void delete(int id) {
        String query = "DELETE FROM managers WHERE manager_id = ? ";
        
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
