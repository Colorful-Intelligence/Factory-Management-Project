
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TransportVehicleOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public TransportVehicleOperations(){
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
    
    
    public  ArrayList<TransportVehicle> showTransportVehicles(){
        
        ArrayList<TransportVehicle> output = new ArrayList<TransportVehicle>();
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM transportvehicles";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int vehicle_id = rs.getInt("vehicle_id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                String plaque = rs.getString("plaque");
                
                
                
                
                
                output.add(new TransportVehicle(vehicle_id, name, model, plaque));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(TransportVehicleOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    }
    
    
    public void addTransportVehicle(String name,String model,String plaque){
        
        String query = "INSERT INTO transportvehicles (name,model,plaque) VALUES(?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, plaque);
            
            
            
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TransportVehicleOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void updateTransportVehicle(int new_id,String name,String model,String plaque){
        
        String query = "UPDATE transportvehicles set name = ?,model = ? ,plaque = ?  WHERE vehicle_id = ?";
        
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, plaque);
            preparedStatement.setInt(4, new_id);
            
            
            
            
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TransportVehicleOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM transportvehicles WHERE vehicle_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
