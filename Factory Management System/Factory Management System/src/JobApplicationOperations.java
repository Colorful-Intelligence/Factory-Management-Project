
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class JobApplicationOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public JobApplicationOperations(){
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
    
    public ArrayList<JobApplication> showJobApplications(){
        
        ArrayList<JobApplication> output = new ArrayList<JobApplication>();
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM jobapplications";
            ResultSet rs =  statement.executeQuery(query);
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int dpt_id = rs.getInt("dpt_id");
                String work_type = rs.getString("work_type");
                
                output.add(new JobApplication(id, name, surname, address, phone, email, dpt_id, work_type));
            
            
            
            }
            
            
            
            
            
            return output;
        } 
        catch (Exception e) {
             Logger.getLogger(JobApplicationOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    
    }
    
    public void addJobApplication(String name,String surname,String address,String phone,String email,int dpt_id,String work_type){
        
        String query = "INSERT INTO jobapplications (name,surname,address,phone,email,dpt_id,work_type) VALUES(?,?,?,?,?,?,?)";
        
        try {
             preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, name);
             preparedStatement.setString(2, surname);
             preparedStatement.setString(3, address);
             preparedStatement.setString(4, phone);
             preparedStatement.setString(5, email);
             preparedStatement.setInt(6, dpt_id);
             preparedStatement.setString(7, work_type);
             preparedStatement.executeUpdate();
            
             
            
            
        } catch (Exception e) {
            Logger.getLogger(JobApplicationOperations.class.getName()).log(Level.SEVERE, null, e);
            
        }
    
    
    
    }
    
    public void updateJobApplication(int new_id,String name,String surname,String address,String phone,String email,int dpt_id,String work_type){
        
        String query = "UPDATE jobapplications set name = ? ,surname = ?, address = ?,phone = ? ,email = ? ,dpt_id = ? ,work_type = ? WHERE id = ? ";
        
        
        try {
             preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, name);
             preparedStatement.setString(2, surname);
             preparedStatement.setString(3, address);
             preparedStatement.setString(4, phone);
             preparedStatement.setString(5, email);
             preparedStatement.setInt(6, dpt_id);
             preparedStatement.setString(7, work_type);
             preparedStatement.setInt(8, new_id);
             preparedStatement.executeUpdate();
            
             
            
            
        } catch (Exception e) {
            Logger.getLogger(JobApplicationOperations.class.getName()).log(Level.SEVERE, null, e);
            
        }
    
    
    
    
    }
    

    @Override
    public void delete(int id) {
        String query = "DELETE FROM jobapplications WHERE id = ? ";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(JobApplicationOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
