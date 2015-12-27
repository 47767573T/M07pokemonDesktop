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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    public static String[] pokemonActual = DBMmanager.getPokemon(1);

    public void initialize(){

        DBMmanager.createDB();

        lvPokemons.setItems(items);
        apOverview.setVisible(false);

        lvPokemons.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String filaSeleccionada = lvPokemons.getSelectionModel().getSelectedItem().toString();
                String idStr = filaSeleccionada.substring (0,(filaSeleccionada.indexOf("-")-1));
                int idSeleccionado = Integer.parseInt(idStr);
                //System.out.println(idSeleccionado); //Borrar tras testeo

                pokemonActual = DBMmanager.getPokemon(idSeleccionado);

                //rellenamos datos de Overview
                ivOverview.setImage(new Image(pokemonActual[3]));
                lbName.setText(pokemonActual[0]);
                lbLife.setText(pokemonActual[1]);
                lbID.setText(idStr);

                //mostramos el overView rellenado
                apOverview.setVisible(true);
            }
        });
    }

    //public void info

    public void onSalir(ActionEvent actionEvent){
        Platform.exit();
    }

    public void onRefrescar(ActionEvent actionEvent) {
        items.clear();
        DBMmanager.createDB();
    }

    public void onSeleccionarSiguiente(ActionEvent actionEvent) {
    }

    public void onSeleccionarAnterior(ActionEvent actionEvent) {

    }
}
