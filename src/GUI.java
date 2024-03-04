import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
    private Stage primaryStage;
    private final Button[][] grid = new Button[3][3];
    private final Tris tris = new Tris(Player.PLAYER1);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        creaGriglia();
        primaryStage.setTitle("Tris");

        primaryStage.show();
    }

    public void creaGriglia() {
        GridPane griglia = new GridPane();
        griglia.setAlignment(Pos.CENTER);
        griglia.setVgap(10);
        griglia.setHgap(10);

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                Button b = new Button();
                b.setPrefSize(100, 100);

                griglia.add(b, j, i);
                this.grid[i][j] = b;
            }
        }

        Scene s = new Scene(griglia, 320, 320);
        this.primaryStage.setScene(s);
    }


}
