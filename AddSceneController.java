import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class AddSceneController{
    private Stage stage;
    private ItemType type;
    
    public void prepareStageEvents(Stage stage, ItemType type){
        this.stage = stage;
        this.type=type;
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    Application.close();
                }
        });
    }
    
}
