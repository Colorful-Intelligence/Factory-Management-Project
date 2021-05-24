
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RawMaterialOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
    public RawMaterialOperations(){
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
    
    public  ArrayList<RawMaterial> showRawMaterials(){
        
        ArrayList<RawMaterial> output = new ArrayList<RawMaterial>();
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM rawmaterial";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int supp_id = rs.getInt("supplier_id");
                String explanation = rs.getString("explanation");
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                
                output.add(new RawMaterial(id,name,supp_id,explanation,amount,price));
                
                
               
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    
    }
    
    
    public void addRawMaterial(String name,int supp_id,String explanation,int amount,float price){
        
        String query = "INSERT INTO rawmaterial(name,supplier_id,explanation,amount,price) VALUES(?,?,?,?,?)";
        
        
         try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, supp_id);
            preparedStatement.setString(3, explanation);
            preparedStatement.setInt(4, amount);
            preparedStatement.setFloat(5, price);
         
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    
    }
    
    
    public void updateRawMaterial(int new_id,String name,int supp_id,String explanation,int amount,float price){
        
        String query = "UPDATE rawmaterial set name = ? , supplier_id = ? , explanation = ? ,amount = ? ,price = ? WHERE id = ? ";
        
        try {
            
            
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, supp_id);
            preparedStatement.setString(3, explanation);
            preparedStatement.setInt(4, amount);
            preparedStatement.setFloat(5, price);
            preparedStatement.setInt(6, new_id);
            
           
            
            
            
            preparedStatement.executeUpdate();
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(RawMaterialOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
    
    

    @Override
    public void delete(int id) {
        String query = "DELETE FROM rawmaterial WHERE id = ? ";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
}
