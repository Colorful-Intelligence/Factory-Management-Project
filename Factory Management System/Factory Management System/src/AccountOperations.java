
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccountOperations implements Operations{
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public AccountOperations(){
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
    
    
    public ArrayList<Account> ShowReports(){
        
        ArrayList<Account> output = new ArrayList<Account>();
        
        try {
            
            statement =  con.createStatement();
            String query =  "SELECT * FROM account";
            ResultSet rs =  statement.executeQuery(query);
            while(rs.next()) {
                
                int id = rs.getInt("report_id");
                float total_sold_car_amount = rs.getFloat("total_sold_car_amount");
                float total_income_from_car = rs.getFloat("total_income_from_car");
                float total_paid_salary = rs.getFloat("total_paid_salary");
                float total_bills = rs.getFloat("total_bills");
                float net_profit = rs.getFloat("net_profit");
                
                output.add(new Account(id, total_sold_car_amount, total_income_from_car, total_paid_salary, total_bills, net_profit));
            
        } 
            return output;
    }
        catch (Exception e) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    
    
    }
    
    
    public int CalculateNumberOfProductsSold(){
        int quantity = 0;
        try {
            statement =  con.createStatement();
            String query =  "SELECT COUNT(*) FROM products";
            ResultSet rs =  statement.executeQuery(query);
            
            while(rs.next()) {
               quantity = rs.getInt("COUNT(*)");
              
              
            }
            
            return quantity ;
            
            
            
        } catch (SQLException e) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return  quantity;
    }
    
    
    public float CalculateTotalRevenueFromSale(){
        
        float income = 0;
        
        try {
            statement =  con.createStatement();
            String query =  "SELECT sum(amount_paid) AS INCOME FROM orders";
            ResultSet rs =  statement.executeQuery(query);
            
            while(rs.next()) {
               income = rs.getFloat("INCOME");
              
              
            }
            
            return income ;
            
            
            
        } catch (SQLException e) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return  income;
    
    
    
    
    }
    
    public float CalculateTotalPaidSalary(){
        
        float total_paid_for_salary = 0;
        
        try {
            statement =  con.createStatement();
            String query =  "SELECT sum(salary) AS PAID_SALARY FROM employees";
            ResultSet rs =  statement.executeQuery(query);
            
            while(rs.next()) {
               total_paid_for_salary = rs.getFloat("PAID_SALARY");
              
              
            }
            
            return total_paid_for_salary ;
            
            
            
        } catch (SQLException e) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return  total_paid_for_salary;
    
    
    }
    
    
    public void addReport(float number_od_products_sold,float total_revenue_from_sale,float total_paid_salary,float other_expense,float net_profit){
        
        String query = "INSERT INTO account (total_sold_car_amount,total_income_from_car,total_paid_salary,total_bills,net_profit) VALUES(?,?,?,?,?) ";
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setFloat(1, number_od_products_sold);
            preparedStatement.setFloat(2, total_revenue_from_sale);
            preparedStatement.setFloat(3, total_paid_salary);
            preparedStatement.setFloat(4, other_expense);
            preparedStatement.setFloat(5, net_profit);
            
            preparedStatement.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void updateReport(int new_id,float number_od_products_sold,float total_revenue_from_sale,float total_paid_salary,float other_expense,float net_profit){
        
        String query = "UPDATE account set total_sold_car_amount = ?,total_income_from_car = ?, total_paid_salary = ? ,total_bills = ? ,net_profit = ? WHERE report_id = ? ";
        
        try {
            
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setFloat(1, number_od_products_sold);
            preparedStatement.setFloat(2, total_revenue_from_sale);
            preparedStatement.setFloat(3, total_paid_salary);
            preparedStatement.setFloat(4, other_expense);
            preparedStatement.setFloat(5, net_profit);
            preparedStatement.setInt(6, new_id);
            
            preparedStatement.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    
    

    @Override
    public void delete(int id) {
        String query = "DELETE FROM account WHERE report_id = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
