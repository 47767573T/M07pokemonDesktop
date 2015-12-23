package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

public class Controller {

    //ITEMS in GUI
    @FXML
    ImageView ivOverview;
    @FXML
    AnchorPane apOverview;
    @FXML
    Label lbName;
    @FXML
    Label lbID;
    @FXML
    Label lbLife;
    @FXML
    ListView lvPokemons;
    @FXML
    Button btSalir;
    @FXML
    Button btBack;
    @FXML
    Button btNext;

    //Resto de variables internas
    int idBack;
    String imageBack;   //url de la ultima imagen vista
    String lpBack;
    String nameBack;

    int idNext;
    String imageNext;   //url de la la imagen desde la que se accede a la ultima imagen vista
    String lpNext;
    String nameNext;


    public ObservableList<String> items = FXCollections.observableArrayList();

    public void initialize(){

        apOverview.setVisible(false);       //inicialmente ocultamos el Overview
        lvPokemons.setItems(items);

        lvPokemons.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }

    public void onSalir(ActionEvent actionEvent){
        Platform.exit();
    }
}
