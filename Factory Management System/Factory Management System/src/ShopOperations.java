
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ShopOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
    public ShopOperations(){
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
    
    
    public  ArrayList<Shop> showShops(){
        
        ArrayList<Shop> output = new ArrayList<Shop>();
        
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM shops";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int shop_id = rs.getInt("shop_id");
                String shop_name = rs.getString("shop_name");
                String shop_address = rs.getString("shop_address");
                String shop_mail = rs.getString("shop_mail");
                
                
                
                output.add(new Shop(shop_id, shop_name, shop_address, shop_mail));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(ShopOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    }
    
    
    public void addShop(String shop_name,String shop_address,String shop_mail){
        
        String query = "INSERT INTO shops (shop_name,shop_address,shop_mail) VALUES (?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, shop_name);
            preparedStatement.setString(2, shop_address);
            preparedStatement.setString(3, shop_mail);
            
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ShopOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    public void updateShop(int new_id,String shop_name,String shop_address,String shop_mail){
        
        String query = "UPDATE shops set shop_name = ? ,shop_address = ? ,shop_mail = ? WHERE shop_id = ? ";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, shop_name);
            preparedStatement.setString(2, shop_address);
            preparedStatement.setString(3, shop_mail);
            preparedStatement.setInt(4, new_id);
            
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ShopOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    

    @Override
    public void delete(int id) {
        
        String query = "DELETE FROM shops WHERE shop_id = ? ";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
