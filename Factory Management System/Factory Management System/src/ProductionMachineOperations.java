
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductionMachineOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ProductionMachineOperations(){
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
    
    public ArrayList<ProductionMachine> showProductionMachines(){
        
        ArrayList<ProductionMachine> output = new ArrayList<ProductionMachine>();
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM productionmachines";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("machine_id");
                String machine_name = rs.getString("name");
                String production_date = rs.getString("production_date");
                int supplier_id = rs.getInt("supplier_id");
                String explanation = rs.getString("explanation");
                
                output.add(new ProductionMachine(supplier_id, machine_name, production_date, supplier_id, explanation));
                
                
                
                
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(ProductionMachineOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    }
    
    public void addProductionMachine(String name,String production_date,int supplier_id,String explanation){
        
        String query = "INSERT INTO productionmachines (name,production_date,supplier_id ,explanation) VALUES(?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, production_date);
            preparedStatement.setInt(3, supplier_id);
            preparedStatement.setString(4, explanation);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductionMachineOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    
    public void updateProductionMachine(int new_id,String name,String production_date,int supplier_id,String explanation){
        
        String query = "UPDATE productionmachines set name = ? ,production_date = ? , supplier_id = ? ,explanation = ? WHERE machine_id = ?";
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,production_date);
            
            preparedStatement.setInt(3,supplier_id);
            preparedStatement.setString(4,explanation);
            preparedStatement.setInt(5, new_id);
            
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductionMachineOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    

    @Override
    public void delete(int id) {
        String query = "DELETE FROM productionmachines WHERE machine_id = ?";
        
         try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductionMachineOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
