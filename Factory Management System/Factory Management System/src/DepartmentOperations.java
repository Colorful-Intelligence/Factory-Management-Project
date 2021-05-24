
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DepartmentOperations implements  Operations{
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
     public DepartmentOperations(){
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
    
    public void addDepartment(String name, String phone,String address){
        String query = "insert into departments (dpt_name,dpt_phone,dpt_address) VALUES(?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, address);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void updateDepartment(int new_id,String name,String phone,String address){
        
        String query = "UPDATE departments set dpt_name = ? , dpt_phone = ? ,dpt_address = ?  WHERE dpt_id = ?";
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,phone);
            
            preparedStatement.setString(3,address);
            preparedStatement.setInt(4,new_id);
            
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DepartmentOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
     public ArrayList<Department> ShowDepartments(){
        ArrayList<Department> output = new ArrayList<Department>();
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM departments";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("dpt_id");
                String name = rs.getString("dpt_name");
                String phone = rs.getString("dpt_phone");
                String address = rs.getString("dpt_address");
                
                output.add(new Department(id, name, phone, address));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(DepartmentOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public void delete(int id) {
        String query = "Delete from departments where dpt_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
