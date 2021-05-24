
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ProductOperations(){
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
    
    public  ArrayList<Product> showProducts(){
        
        ArrayList<Product> output = new ArrayList<Product>();
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM products";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int prd_id = rs.getInt("prd_id");
                String prd_name = rs.getString("prd_name");
                int category_id = rs.getInt("categori_id");
                String prd_color = rs.getString("prd_color");
                float cost_price = rs.getFloat("cost_price");
                float sell_price = rs.getFloat("sell_price");
                float net_profit = rs.getFloat("net_profit");
                int quantity = rs.getInt("quantity");
                int simulation_id = rs.getInt("simulation_id");
                String explanation = rs.getString("explanation");
                
                
                output.add(new Product(prd_id, prd_name, category_id, prd_color, cost_price, sell_price, net_profit, quantity, simulation_id, explanation));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    
    }
    
    
    
    
    public void updateProduct(int new_id,String prd_name,int category_id,String prd_color,float cost_price,float sell_price,float net_profit,int quantity,int simulation_id,String expalantion){
        
        String query = "UPDATE products set prd_name = ? , categori_id = ? , prd_color = ? ,cost_price = ? ,sell_price = ? ,net_profit= ?, quantity = ? ,simulation_id = ? ,explanation= ?  WHERE prd_id = ?";
        
         try {
            
            
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,prd_name);
            preparedStatement.setInt(2, category_id);
            preparedStatement.setString(3, prd_color);
            preparedStatement.setFloat(4, cost_price);
            preparedStatement.setFloat(5, sell_price);
            preparedStatement.setFloat(6, net_profit);
            preparedStatement.setInt(7, quantity);
            preparedStatement.setInt(8, simulation_id);
            preparedStatement.setString(9, expalantion);
            preparedStatement.setInt(10, new_id);
            
            
            preparedStatement.executeUpdate();
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    
    public void addProduct(String prd_name,int category_id,String prd_color,float cost_price,float sell_price,float net_profit,int quantity,int simulation_id,String expalantion){
        
        String query = "INSERT INTO products (prd_name,categori_id,prd_color,cost_price,sell_price,net_profit,quantity,simulation_id,explanation) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, prd_name);
            preparedStatement.setInt(2, category_id);
            preparedStatement.setString(3, prd_color);
            preparedStatement.setFloat(4, cost_price);
            preparedStatement.setFloat(5, sell_price);
            preparedStatement.setFloat(6, net_profit);
            preparedStatement.setInt(7, quantity);
            preparedStatement.setInt(8, simulation_id);
            preparedStatement.setString(9, expalantion);
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    
    }
    
    public float calculateNetProfit(float cost_price,float sell_price){
        
        float net_profit = sell_price - cost_price;
        return net_profit;
    
    
    }
    
    
    

    @Override
    public void delete(int id) {
       String query = "DELETE FROM products WHERE prd_id = ? ";
       
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
