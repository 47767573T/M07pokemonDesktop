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
import sample.DataBaseManagement.DBMmanager;

import javax.swing.text.html.ImageView;

public class Controller {

    //Objeto de control de Base de Datos
    DBMmanager dbm = new DBMmanager();

    //ITEMS in GUI
    @FXML
    ImageView ivOverview;       //Url de Imagen del pokemon mostrada
    @FXML
    AnchorPane apOverview;      //Panel donde estan todos los items de detalle del pokemon
    @FXML
    Label lbName;               //label del nombre del pokemon
    @FXML
    Label lbID;                 //label del id del pokemon
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

    public static ObservableList<String> items = FXCollections.observableArrayList();

    public void initialize(){

        lvPokemons.setItems(items);

        lvPokemons.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        apOverview.setVisible(true);



    }

    public void onSalir(ActionEvent actionEvent){
        Platform.exit();
    }

    public void onRefrescar(ActionEvent actionEvent) {
        items.clear();
        DBMmanager.createDB();
    }
}
