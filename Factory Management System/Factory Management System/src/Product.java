
public class Product {
    private int prd_id;
    private String prd_name;
    private int categorie_id;
    private String prd_color;
    private float cost_price;
    private float sell_price;
    private float net_profit;
    private int quantity;
    private int simulation_id;
    private String explanation;

    public Product(int prd_id, String prd_name, int categorie_id, String prd_color, float cost_price, float sell_price, float net_profit, int quantity, int simulation_id, String explanation) {
        this.prd_id = prd_id;
        this.prd_name = prd_name;
        this.categorie_id = categorie_id;
        this.prd_color = prd_color;
        this.cost_price = cost_price;
        this.sell_price = sell_price;
        this.net_profit = net_profit;
        this.quantity = quantity;
        this.simulation_id = simulation_id;
        this.explanation = explanation;
    }

    public int getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(int prd_id) {
        this.prd_id = prd_id;
    }

    public String getPrd_name() {
        return prd_name;
    }

    public void setPrd_name(String prd_name) {
        this.prd_name = prd_name;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getPrd_color() {
        return prd_color;
    }

    public void setPrd_color(String prd_color) {
        this.prd_color = prd_color;
    }

    public float getCost_price() {
        return cost_price;
    }

    public void setCost_price(float cost_price) {
        this.cost_price = cost_price;
    }

    public float getSell_price() {
        return sell_price;
    }

    public void setSell_price(float sell_price) {
        this.sell_price = sell_price;
    }

    public float getNet_profit() {
        return net_profit;
    }

    public void setNet_profit(float net_profit) {
        this.net_profit = net_profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSimulation_id() {
        return simulation_id;
    }

    public void setSimulation_id(int simulation_id) {
        this.simulation_id = simulation_id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    
    
}
