
public class Order {
    private int ord_id;
    private int cst_id;
    private String product_name;
    private float amount_paid;
    private int sales_person_id;
    private int product_id;
    private String ord_date;
    private int transport_vehicle_id;

    public Order(int ord_id, int cst_id, String product_name, float amount_paid, int sales_person_id, int product_id, String ord_date, int transport_vehicle_id) {
        this.ord_id = ord_id;
        this.cst_id = cst_id;
        this.product_name = product_name;
        this.amount_paid = amount_paid;
        this.sales_person_id = sales_person_id;
        this.product_id = product_id;
        this.ord_date = ord_date;
        this.transport_vehicle_id = transport_vehicle_id;
    }

    public int getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(int ord_id) {
        this.ord_id = ord_id;
    }

    public int getCst_id() {
        return cst_id;
    }

    public void setCst_id(int cst_id) {
        this.cst_id = cst_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(float amount_paid) {
        this.amount_paid = amount_paid;
    }

    public int getSales_person_id() {
        return sales_person_id;
    }

    public void setSales_person_id(int sales_person_id) {
        this.sales_person_id = sales_person_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(String ord_date) {
        this.ord_date = ord_date;
    }

    public int getTransport_vehicle_id() {
        return transport_vehicle_id;
    }

    public void setTransport_vehicle_id(int transport_vehicle_id) {
        this.transport_vehicle_id = transport_vehicle_id;
    }
    

    
    
    
}
