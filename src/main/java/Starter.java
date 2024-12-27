import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/items_Management.fxml")));
        scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Item Management");
        stage.setResizable(false);

    }
}
