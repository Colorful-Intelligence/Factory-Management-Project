
public class ProductSimulation {
    private int prd_simulation_id;
    private String explanation;

    public ProductSimulation(int prd_simulation_id, String explanation) {
        this.prd_simulation_id = prd_simulation_id;
        this.explanation = explanation;
    }

    public int getPrd_simulation_id() {
        return prd_simulation_id;
    }

    public void setPrd_simulation_id(int prd_simulation_id) {
        this.prd_simulation_id = prd_simulation_id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
   

   
}
