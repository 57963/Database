public class Variant extends DBItem{
    public int ID;
    public String description;
    public Variant(int ID, String name, String description){
        this.ID = ID;
        this.name = name;
        this.description = description;
        type = ItemType.VARIANT;
    }
}
