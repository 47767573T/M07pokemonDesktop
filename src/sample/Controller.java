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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.DataBaseManagement.DBMmanager;

import java.util.ArrayList;

public class Controller {

    //Objeto de control de Base de Datos
    DBMmanager dbm = new DBMmanager();

    //ITEMS in GUI
    @FXML
    AnchorPane apScreen;
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
    @FXML
    Button btRefrescar;

    //Resto de variables internas
    static ArrayList<Integer> IDs = new ArrayList<>();      //Array que recoje los pokemos vistos
    static int posicionActual = 1;                                       //posicion actual dentro del array de ids vistos

    public static ObservableList<String> items = FXCollections.observableArrayList();
    public static String[] pokemonActual = DBMmanager.getPokemon(posicionActual);


    public void initialize(){
        DBMmanager.createDB();

        lvPokemons.setItems(items);
        apOverview.setVisible(false);
        pintar();

        lvPokemons.setOnMouseClicked(new EventHandler<MouseEvent>() {   //Metodo que define el click en el listview
            @Override
            public void handle(MouseEvent event) {

                String filaSeleccionada = lvPokemons.getSelectionModel().getSelectedItem().toString();
                String idStr = filaSeleccionada.substring (0,(filaSeleccionada.indexOf("-")-1));
                int idSeleccionado = Integer.parseInt(idStr);

                //Guardamos el id seleccionado
                IDs.add(idSeleccionado);
                posicionActual = IDs.size()-1;
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

    /**
     * Funcion que define el evento de salir del programa
     * @param actionEvent
     */
    public void onSalir(ActionEvent actionEvent){
        Platform.exit();
    }

    /**
     * Funcion que descarga nuevamente la base de datos y actualiza el listView del programa
     * @param actionEvent
     */
    public void onRefrescar(ActionEvent actionEvent) {
        items.clear();
        DBMmanager.createDB();
    }

    /**
     * Funcion que muestra en OverView el pokemon siguiente mostrado
     * @param actionEvent
     */
    public void onSeleccionarSiguiente(ActionEvent actionEvent) {

        if (posicionActual != (IDs.size()-1)) posicionActual +=1;

        int idSiguiente = IDs.get(posicionActual);
        pokemonActual = DBMmanager.getPokemon(idSiguiente);

        //rellenamos datos de Overview
        ivOverview.setImage(new Image(pokemonActual[3]));
        lbName.setText(pokemonActual[0]);
        lbLife.setText(pokemonActual[1]);
        lbID.setText(Integer.toString(idSiguiente));
    }

    /**
     * Funcion que muestra en OverView el pokemon anteriormente mostrado
     * @param actionEvent
     */
    public void onSeleccionarAnterior(ActionEvent actionEvent) {

        if (posicionActual != 0) posicionActual -=1;

        int idSiguiente = IDs.get(posicionActual);
        pokemonActual = DBMmanager.getPokemon(idSiguiente);

        //rellenamos datos de Overview
        ivOverview.setImage(new Image(pokemonActual[3]));
        lbName.setText(pokemonActual[0]);
        lbLife.setText(pokemonActual[1]);
        lbID.setText(Integer.toString(idSiguiente));
    }

    /**
     * Funcion que define el color del fondo y los bordes de los items
     */
    public void pintar (){
        apOverview.setBackground(new Background(new BackgroundFill(Color.CORAL, null, null)));
        apScreen.setBackground(new Background(new BackgroundFill(Color.CORAL, null, null)));
        lbID.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        lbID.setStyle("-fx-border-color: black;");
        lbLife.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        lbLife.setStyle("-fx-border-color: black;");
        lbName.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        lbName.setStyle("-fx-border-color: black;");
    }
}
