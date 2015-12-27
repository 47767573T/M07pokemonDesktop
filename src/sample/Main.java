package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("POKEMONS");
        primaryStage.setScene(new Scene(root, 398, 341));

        //marcamos el valor maximo de la ventana del programa
        primaryStage.setMaxHeight(370);
        primaryStage.setMaxWidth(398);

        primaryStage.show();

        //Controller c = (Controller)loader.getController();
        // controller.btCopy.setGraphic(new ImageView("copy.png"));
    }


    public static void main(String[] args) {launch(args);
    }
}
