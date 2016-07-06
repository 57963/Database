import java.util.ArrayList;
import java.sql.ResultSet;

public class Guns extends DBItem{
   public ArrayList<Manufacturer> manufacturers;
   public Guns(){
       name = "Guns";
       manufacturers = new ArrayList<>();
   }
   
   public void manufacturersRS(ResultSet rs){
       try{
           while(rs.next()){
               manufacturers.add(new Manufacturer(rs.getInt(1),rs.getString(2)));
           }
        } catch (Exception e){
           e.printStackTrace();
        }
   }
   
   public void modelsRS(ResultSet rs){
       try{
           while(rs.next()){
               manufacturers.get(rs.getInt(3)).models.add(new Model(rs.getInt(1),rs.getString(2)));
            }
        } catch (Exception e){
           e.printStackTrace();
        }  
    }
    
    public void variantsRS(ResultSet rs){
        try{
           while(rs.next()){
               for(Manufacturer ma: manufacturers){
                   for(Model mo: ma.models){
                       if(mo.ID == rs.getInt(3)){
                           mo.variants.add(new Variant(rs.getInt(1), rs.getString(2), rs.getString(4)));
                        }
                    }
                }
            }
        } catch (Exception e){
           e.printStackTrace();
        }
    }
   
   public void printAll(){
       for(Manufacturer ma:manufacturers){
           System.out.println(ma.ID + ", " + ma.name + ":");
           for(Model mo:ma.models){
               System.out.println("    "+mo.ID + ", " + mo.name + ":");
               for(Variant v: mo.variants){
                   System.out.println("        "+v.ID + ", " + v.name + "," + v.description);
                }
           }
       }
   }
}
