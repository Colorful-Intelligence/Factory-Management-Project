
public class ProductionMachine {
    private int machine_id;
    private String machine_name;
    private String production_date;
    private int supp_id;
    private String explanation;

    public ProductionMachine(int machine_id, String machine_name, String production_date, int supp_id, String explanation) {
        this.machine_id = machine_id;
        this.machine_name = machine_name;
        this.production_date = production_date;
        this.supp_id = supp_id;
        this.explanation = explanation;
    }

    public int getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(int machine_id) {
        this.machine_id = machine_id;
    }

    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date;
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
    
    
}
