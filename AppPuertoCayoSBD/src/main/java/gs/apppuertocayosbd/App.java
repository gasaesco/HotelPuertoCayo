package gs.apppuertocayosbd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static final Image icono = new Image("@../../images/logos/logoPC.png");
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PrincipalitoFXML"), 1080, 720);
        stage.setScene(scene);
        configuracionVentana(stage);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void configuracionVentana(Stage stage) throws IOException{
        stage.setResizable(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Hotel Puerto Cayo | Inicio");
        stage.getIcons().add(icono);
    }
    

    public static void main(String[] args) {
        launch();
    }

}