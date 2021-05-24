
public class TransportVehicle {
    private int vehicle_id;
    private String vehicle_name;
    private String model;
    private String plaque;

    public TransportVehicle(int vehicle_id, String vehicle_name, String model, String plaque) {
        this.vehicle_id = vehicle_id;
        this.vehicle_name = vehicle_name;
        this.model = model;
        this.plaque = plaque;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }
    

    
    
}
