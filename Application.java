import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application{
    public static Guns guns;
    public static SQL sql;
    public static void main(String args[]){
        new Application();
    }
    
    public Application(){
        JFXPanel panel = new JFXPanel();
        Platform.runLater(() -> start());
    }
    
    private static void start(){
        try{
            guns = new Guns();
            sql = new SQL("Guns.db");
            guns.manufacturersRS(sql.query("SELECT * FROM manufacturers"));
            guns.modelsRS(sql.query("SELECT * FROM models"));
            guns.variantsRS(sql.query("SELECT * FROM variants"));
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("Database.fxml"));
            Stage stage= new Stage();
            stage.setTitle("Database");
            stage.setScene(new Scene(loader.load()));
            stage.show();
            MainSceneController controller = loader.getController();
            controller.prepareStageEvents(stage);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void close(){
        sql.close();
        System.exit(0);
    }
}
