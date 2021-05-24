
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SalesPersonOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
    public SalesPersonOperations(){
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
    
    public boolean Login (int id , String password){
        String query =  "Select * From salespersons where sp_id = ? and sp_password = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,password);
            
            ResultSet rs =  preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesPersonOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    
    public  ArrayList<SalesPerson> showSalesPersons(){
        
        ArrayList<SalesPerson> output = new ArrayList<SalesPerson>();
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM salespersons";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int sp_id = rs.getInt("sp_id");
                String sp_name = rs.getString("sp_name");
                String sp_surname = rs.getString("sp_surname");
                int shop_id = rs.getInt("shop_id");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                String password = rs.getString("sp_password");
                
                
                
                output.add(new SalesPerson(sp_id, sp_name, sp_surname, shop_id, email, phone, address, salary, password));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(SalesPersonOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    
    
    
    }
    
    public void addSalesPerson(String name,String surname,int shop_id,String email,String phone,String address,float salary ,String password){
        
        String query = "INSERT INTO salespersons (sp_name,sp_surname,shop_id,email,phone,address,salary,sp_password) VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, shop_id);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, address);
            preparedStatement.setFloat(7, salary);
            preparedStatement.setString(8, password);
            
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SalesPersonOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    public void updateSalesPerson(int new_id,String name,String surname,int shop_id,String email,String phone,String address,float salary ,String password){
        String query = "UPDATE salespersons set sp_name =? ,sp_surname = ? ,shop_id= ?,email = ?,phone = ? ,address = ?,salary = ? , sp_password = ? WHERE sp_id = ?    ";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, shop_id);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, address);
            preparedStatement.setFloat(7, salary);
            preparedStatement.setString(8, password);
            preparedStatement.setInt(9, new_id);
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ShopOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    

    @Override
    public void delete(int id) {
        String query = "DELETE FROM salespersons WHERE sp_id = ? ";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
