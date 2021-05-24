
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CustomerOperations implements Operations{
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public CustomerOperations(){
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
    
    public void updateCustomer(int new_id,String name,String surname,String birth_date,String nationality,String address,String phone){
        
        String query = "Update customers set cst_name = ? , cst_surname = ? ,cst_birthdate = ?,cst_nationality = ? ,address = ? , phone = ? WHERE cst_id = ? ";
        
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birth_date);
            preparedStatement.setString(4, nationality);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phone);
            preparedStatement.setInt(7, new_id);
            
            preparedStatement.executeUpdate();
            
        } catch (Exception ex) {
             Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    }
    
    public void addCustomer(String name,String surname,String birth_date,String nationality,String address,String phone){
        
        String query = "INSERT INTO customers (cst_name,cst_surname,cst_birthdate,cst_nationality,address,phone) VALUES(?,?,?,?,?,?)";
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, birth_date);
            preparedStatement.setString(4, nationality);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phone);
            
            preparedStatement.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public ArrayList<Customer> ShowCustomers(){
        ArrayList<Customer> output = new ArrayList<Customer>();
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM customers";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("cst_id");
                String name = rs.getString("cst_name");
                String surname = rs.getString("cst_surname");
                String birth_date = rs.getString("cst_birthdate");
                String nationality = rs.getString("cst_nationality");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                
                
                output.add(new Customer(id, name, surname, birth_date, nationality, address, phone));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM customers WHERE cst_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
