
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public OrderOperations(){
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
    
    
     public ArrayList<Order> ShowOrders(){
         
        ArrayList<Order> output = new ArrayList<Order>();
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM orders";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int order_id = rs.getInt("ord_id");
                int cst_id = rs.getInt("cst_id");
                String prd_name = rs.getString("prd_name");
                float amount_paid = rs.getFloat("amount_paid");
                int sales_person_id = rs.getInt("sp_id");
                int prd_id = rs.getInt("prd_id");
                String order_date = rs.getString("order_date");
                int transport_id = rs.getInt("transport_ID");
                
                output.add(new Order(order_id, cst_id, prd_name, amount_paid, sales_person_id, prd_id, order_date,transport_id));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(OrderOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
     
     
     
     }
     
     
     
     public void addOrder(int cst_id,String prd_name,float amount_paid,int sp_id,int prd_id,String order_date,int transport_id){
        String query = "insert into orders (cst_id,prd_name,amount_paid,sp_id,prd_id,order_date,transport_id) VALUES(?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setInt(1, cst_id);
            preparedStatement.setString(2, prd_name);
            preparedStatement.setFloat(3, amount_paid);
            preparedStatement.setInt(4, sp_id);
            preparedStatement.setInt(5, prd_id);
            preparedStatement.setString(6, order_date);
            preparedStatement.setInt(7, transport_id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
     
     
    public void updateOrder(int new_id,int cst_id,String prd_name,float amount_paid,int sp_id,int prd_id,String order_date,int transport_id){
        
        String query = "UPDATE orders set cst_id = ? ,prd_name = ? , amount_paid = ? , sp_id= ? ,prd_id = ? ,order_date =?,transport_id = ? WHERE ord_id = ?";
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            
            
            preparedStatement.setInt(1, cst_id);
            preparedStatement.setString(2, prd_name);
            preparedStatement.setFloat(3, amount_paid);
            preparedStatement.setInt(4, sp_id);
            preparedStatement.setInt(5, prd_id);
            preparedStatement.setString(6, order_date);
            preparedStatement.setInt(7,transport_id);
            preparedStatement.setInt(8, new_id);
            
            
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    

    @Override
    public void delete(int id) {
        String query = "DELETE FROM orders WHERE ord_id = ? ";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
