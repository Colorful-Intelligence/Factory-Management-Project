
public class RawMaterial {
    private int Rmaterial_id;
    private String Rmaterial_name;
    private int supp_id;
    private String explanation;
    private int amount;
    private float price;

    public RawMaterial(int Rmaterial_id, String Rmaterial_name, int supp_id, String explanation, int amount, float price) {
        this.Rmaterial_id = Rmaterial_id;
        this.Rmaterial_name = Rmaterial_name;
        this.supp_id = supp_id;
        this.explanation = explanation;
        this.amount = amount;
        this.price = price;
    }

    public int getRmaterial_id() {
        return Rmaterial_id;
    }

    public void setRmaterial_id(int Rmaterial_id) {
        this.Rmaterial_id = Rmaterial_id;
    }

    public String getRmaterial_name() {
        return Rmaterial_name;
    }

    public void setRmaterial_name(String Rmaterial_name) {
        this.Rmaterial_name = Rmaterial_name;
    }

    public int getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(int supp_id) {
        this.supp_id = supp_id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
