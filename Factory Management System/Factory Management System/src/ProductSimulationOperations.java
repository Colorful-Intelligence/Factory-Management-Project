
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductSimulationOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ProductSimulationOperations(){
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
    
    public ArrayList<ProductSimulation> showSimulations(){
        
        ArrayList<ProductSimulation> output = new ArrayList<ProductSimulation>();
        
        try {
            statement =  con.createStatement();
            String query = "SELECT * FROM production_simulations";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("simulation_id");
                String explanation = rs.getString("explanation");
          
                
                output.add(new ProductSimulation(id, explanation));
            
        } 
            
            
            
            return output;
        } catch (Exception e) {
            Logger.getLogger(ProductSimulationOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    }
    
    public void addSimulation(String explanation){
        
        String query = "INSERT INTO production_simulations(explanation)  VALUES(?)";
        
         try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, explanation);
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductSimulationOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void updateSimulation(int new_id,String explanation){
        
        String query = "UPDATE production_simulations set explanation = ?  WHERE simulation_id = ? ";
        
         try {
            
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1,explanation);
            
            
            preparedStatement.setInt(2,new_id);
            
            
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductSimulationOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    

    @Override
    public void delete(int id) {
        
        String query = "DELETE FROM production_simulations WHERE simulation_id = ?  ";
        
         try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductSimulationOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
