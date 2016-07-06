import java.sql.*;

public class SQL{
    private Connection connection = null;
    public SQL(String file){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ResultSet query(String query){
        try{
            return connection.prepareStatement(query).executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void update(String update){
        try{
            connection.createStatement().executeUpdate(update);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void close(){
        try{
            connection.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
