import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.FXML;

public class AddSceneController{
    private Stage stage;
    private ItemType type;
    
    @FXML private TextField nameText;
    @FXML private TextArea descriptionArea;
    @FXML private Label descriptionLabel;
    @FXML private Label ofLabel;
    @FXML private ChoiceBox ofChoice;
    
    public void prepareStageEvents(Stage stage, ItemType type){
        this.stage = stage;
        this.type=type;
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    stage.close();
                }
        });
        if(type == ItemType.MANUFACTURER){
            ofLabel.setVisible(false);
            ofChoice.setVisible(false);
            stage.setHeight(76);
        }
        if(type != ItemType.VARIANT){
            descriptionArea.setVisible(false);
            descriptionLabel.setVisible(false);
            stage.setHeight(106);
        }
    }
    
    
    @FXML void addItem(){
        SQL sql = new SQL("Guns.db");
        switch(type){
            case MANUFACTURER:
                sql.update("INSERT INTO 'Manufacturers'('ManufacturerID','Name')  VALUES(5, 'hi')");
        }
        sql.close();
    }
}
