
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SupplierOperations implements Operations{
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public SupplierOperations(){
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
    
    public ArrayList<Supplier> ShowSuppliers(){
        ArrayList<Supplier> output = new ArrayList<Supplier>();
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM suppliers";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("supplier_id");
                String name = rs.getString("supplier_name");
                String country = rs.getString("country");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                
                output.add(new Supplier(id, name, country, phone, address, email));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(SupplierOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    
    public void updateSupplier(int new_id,String name,String country,String phone,String address,String email){
        
        String query = "UPDATE suppliers set supplier_name = ? ,country = ? ,phone = ? ,address = ?,email = ? WHERE supplier_id = ? ";
        
         try {
            
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, new_id);
            
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SupplierOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void addSupplier(String name,String country,String phone,String address,String email ){
        
        String query = "INSERT INTO suppliers (supplier_name,country,phone,address,email) VALUES(?,?,?,?,?)";
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SupplierOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    
    }

    @Override
    public void delete(int id) {
        
        String query = "DELETE from suppliers WHERE supplier_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
