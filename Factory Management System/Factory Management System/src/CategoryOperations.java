
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoryOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public CategoryOperations(){
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
    
    
    public ArrayList<Category> showCategories(){
        
        ArrayList<Category> output = new ArrayList<Category>();
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM categories";
            ResultSet rs =  statement.executeQuery(query);
            
            while(rs.next()){
                
                int category_id = rs.getInt("categori_id");
                String category_name = rs.getString("categori_name");
                
                output.add(new Category(category_id, category_name));
            
            
            
            }
            
            
            
            
            
            return output;
        } 
        catch (Exception e) {
             Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        
        
    
    }
    
    public void addCategory(String name){
        
        String query = "INSERT INTO categories (categori_name) VALUES(?)";
        
        try {
             preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            
             
            
            
        } catch (Exception e) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
        
    
    }
    
    public void updateCategory(int new_id,String name){
        
        String query = "UPDATE categories set categori_name = ? WHERE categori_id = ?   ";
        
        try {
            
            
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,name);
            
            preparedStatement.setInt(2, new_id);
            
            preparedStatement.executeUpdate();
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    
    
    
    
    
    

    @Override
    public void delete(int id) {
        
        String query = "DELETE FROM categories WHERE categori_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
