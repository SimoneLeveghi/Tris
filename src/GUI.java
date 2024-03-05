import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;

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
