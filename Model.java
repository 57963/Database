import java.util.ArrayList;

public class Model extends DBItem{
    public int ID;
    public ArrayList<Variant> variants;
    public Model(int ID, String name){
        this.ID = ID;
        this.name = name;
        variants = new ArrayList<>();
    }
}