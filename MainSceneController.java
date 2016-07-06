import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSceneController{
    private Stage stage;
    
    @FXML private TreeView<DBItem> tree;
    @FXML private Label name;
    @FXML private Label description;
    @FXML private ChoiceBox newChoice;
    
    public MainSceneController(){
    }
    
    public void prepareStageEvents(Stage stage){
        this.stage = stage;
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    Application.close();
                }
        });
    }
    
    @FXML void initialize(){
        newChoice.getItems().addAll("Manufacturer","Model","Variant");
        newChoice.setValue("Manufacturer");
        TreeItem<DBItem> root = new TreeItem<DBItem>(Application.guns);
        root.setExpanded(true);
        for(Manufacturer ma: Application.guns.manufacturers){
            TreeItem<DBItem> manufacturerBranch = new TreeItem<DBItem>(ma);
            for(Model mo: ma.models){
                TreeItem<DBItem> modelBranch = new TreeItem<DBItem>(mo);
                for(Variant v: mo.variants){
                    modelBranch.getChildren().add(new TreeItem<DBItem>(v));
                }
                manufacturerBranch.getChildren().add(modelBranch);
            }
            root.getChildren().add(manufacturerBranch);
        }
        tree.setRoot(root);
    }
    
    @FXML void treeSelect(){
        if(tree.getSelectionModel().getSelectedItem() != null){
            DBItem selected = tree.getSelectionModel().getSelectedItem().getValue();
            name.setText(selected.name);
            if(selected.getClass().getCanonicalName() == "Variant"){
                description.setText(((Variant)selected).description);
            }
        }
    }
    
    @FXML void newItem(){
        ItemType type = null;
        switch(newChoice.getSelectionModel().getSelectedItem().toString()){
            case "Manufacturer":type=ItemType.MANUFACTURER; break;
            case "Model":type=ItemType.MODEL;break;
            case "Variant":type=ItemType.VARIANT;
        }
        try{
            Stage add = new Stage();
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("newItem.fxml"));
            add.setTitle("New " + newChoice.getSelectionModel().getSelectedItem());
            add.setScene(new Scene(loader.load()));
            add.show();
            AddSceneController controller = loader.getController();
            controller.prepareStageEvents(stage,type);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}














