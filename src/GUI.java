import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
        VBox vbox = new VBox();
        StackPane gridBg = new StackPane();
        StackPane textBg = new StackPane();
        Text title = new Text(V.TITLE);
        GridPane grid = initializeGrid();

        title.setFont(new Font(50));
        textBg.getChildren().add(title);
        textBg.setStyle("-fx-background-color: white");

        gridBg.setMinWidth(500);
        gridBg.setMinHeight(500);
        gridBg.setStyle("-fx-background-color: white");
        gridBg.getChildren().add(grid);

        vbox.getChildren().add(textBg);
        vbox.getChildren().add(gridBg);

        Scene s = new Scene(vbox, 500, 500);

        this.primaryStage.setTitle(V.TITLE);
        this.primaryStage.setScene(s);
        this.primaryStage.setMinHeight(500);
        this.primaryStage.setMinWidth(500);

        primaryStage.show();
    }

    public GridPane initializeGrid() {
        this.tris.resetGame();

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: black");
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setMaxHeight(320);
        grid.setMaxWidth(320);


        for (int i = 0; i < this.buttonsGrid.length; ++i) {
            for (int j = 0; j < this.buttonsGrid[i].length; ++j) {
                Button b = new Button();
                b.setPrefSize(100, 100);
                b.setFont(new Font(40));
                b.setStyle("-fx-background-color: white; -fx-background-radius: 0");

                int finalI = i;
                int finalJ = j;
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        click(finalI, finalJ);
                    }
                });

                grid.add(b, j, i);
                this.buttonsGrid[i][j] = b;
            }
        }

        return grid;
    }

    private void click(int x, int y) {
        if(tris.place(x, y)) {
            if(tris.getCurrentPlayer() == Player.PLAYER1) {
                buttonsGrid[x][y].setText("O");
            }
            else {
                buttonsGrid[x][y].setText("X");
            }
        }
        else {
            if(tris.isDraw()) {

                VBox vbox = new VBox();
                HBox buttonsContainer = new HBox();

                vbox.setAlignment(Pos.CENTER);

                /*Scene s = new Scene();
                this.primaryStage.setScene();*/
            }
        }
    }


}
