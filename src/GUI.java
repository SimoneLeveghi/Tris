import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
    private Stage primaryStage;
    private final Button[][] buttonsGrid = new Button[3][3];
    private final Tris tris = new Tris(Player.PLAYER1);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initializeGrid();
        primaryStage.setTitle("Tris");

        primaryStage.show();
    }

    public void initializeGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        for (int i = 0; i < this.buttonsGrid.length; ++i) {
            for (int j = 0; j < this.buttonsGrid[i].length; ++j) {
                Button b = new Button();
                b.setPrefSize(100, 100);
                int finalI = i;
                int finalJ = j;
                b.setOnAction(event -> click(finalI, finalJ));

                grid.add(b, j, i);
                this.buttonsGrid[i][j] = b;
            }
        }

        Scene s = new Scene(grid, 320, 320);
        this.primaryStage.setScene(s);
    }

    private void click(int x, int y) {
        if(this.tris.place(x, y)) {
            if(this.tris.getCurrentPlayer() == Player.PLAYER1) {
                buttonsGrid[x][y].setText("O");
            }
            else {
                buttonsGrid[x][y].setText("X");
            }
        }
    }
}
