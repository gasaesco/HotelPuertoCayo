package gs.apppuertocayosbd;

import Proyectito.AzureConexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        stage.setTitle("Hotel Puerto Cayo");
        stage.minHeightProperty().set(720);
        stage.minWidthProperty().set(1080);
        stage.getIcons().add(icono);
        stage.setResizable(false);
    }
    

    public static void main(String[] args) throws SQLException {
        consultaPrueba();
       
        launch();
    }
    
    private static void consultaPrueba() throws SQLException{
            Connection connection = AzureConexion.getConnection();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM huesped"; 
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombres"));
            }
   }

}