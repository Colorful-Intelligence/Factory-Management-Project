
public class Account {
    private int report_id;
    private float total_sold_car_amount;
    private float total_income_from_car;
    private float total_paid_salary;
    private float total_bills;
    private float net_profit;

    public Account(int report_id, float total_sold_car_amount, float total_income_from_car, float total_paid_salary, float total_bills, float net_profit) {
        this.report_id = report_id;
        this.total_sold_car_amount = total_sold_car_amount;
        this.total_income_from_car = total_income_from_car;
        this.total_paid_salary = total_paid_salary;
        this.total_bills = total_bills;
        this.net_profit = net_profit;
    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public float getTotal_sold_car_amount() {
        return total_sold_car_amount;
    }

    public void setTotal_sold_car_amount(float total_sold_car_amount) {
        this.total_sold_car_amount = total_sold_car_amount;
    }

    public float getTotal_income_from_car() {
        return total_income_from_car;
    }

    public void setTotal_income_from_car(float total_income_from_car) {
        this.total_income_from_car = total_income_from_car;
    }

    public float getTotal_paid_salary() {
        return total_paid_salary;
    }

    public void setTotal_paid_salary(float total_paid_salary) {
        this.total_paid_salary = total_paid_salary;
    }

    public float getTotal_bills() {
        return total_bills;
    }

    public void setTotal_bills(float total_bills) {
        this.total_bills = total_bills;
    }

    public float getNet_profit() {
        return net_profit;
    }

    public void setNet_profit(float net_profit) {
        this.net_profit = net_profit;
    }
    
    
}
