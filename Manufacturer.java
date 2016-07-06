import java.util.ArrayList;

public class Manufacturer extends DBItem{
    public int ID;
    public ArrayList<Model> models;
    public Manufacturer(int ID, String name){
        this.ID = ID;
        this.name = name;
        models = new ArrayList<>();
        type = ItemType.MANUFACTURER;
    }
}
