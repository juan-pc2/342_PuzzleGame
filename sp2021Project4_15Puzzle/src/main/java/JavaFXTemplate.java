import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Vector;

public class JavaFXTemplate extends Application {

	Vector<Vector<Button>> vector2D = new Vector<>(4);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public GridPane makeGrid(int[] array)
	{
		GridPane board = new GridPane();
		int counter = 0;

		for(int row = 0; row < 4; row++)
		{
			vector2D.add(row, new Vector<>(4));
			for(int col = 0; col < 4; col++)
			{
				Button button = new Button();
				button.setPrefSize(50,50);
				button.setShape(new Rectangle(50, 50));
				button.setText(Integer.toString(array[counter]));
				vector2D.get(row).add(col, button);
				vector2D.get(row).get(col).setStyle("-fx-background-color:Pink; -fx-border-color: Black");
				board.add(button, col, row);
				counter++;
			}
		}

		return board;
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("15 Puzzle");

		UserInterface user = new UserInterface();
		GridPane board = makeGrid(user.getPuzzle());
		Text welcome = new Text("Solve this 15 Puzzle");
		Button menu = new Button("Menu");
		Button AI1 = new Button("AI H1");
		Button AI2 = new Button("AI H2");
		Button newPuzzle = new Button("New Puzzle");
		Button solutionButton = new Button("See Solution");
		Button exit = new Button("Exit");
		Button tempButton;

		AI1.setVisible(false);
		AI2.setVisible(false);
		newPuzzle.setVisible(false);
		solutionButton.setVisible(false);
		exit.setVisible(false);

		// might need to reevaluate how we do the event handling
		for(int row = 0; row < 4; row++)
		{
			for(int col = 0; col < 4; col++)
			{
				vector2D.get(row).get(col).setOnAction(e ->
				{

				});
			}
		}

		menu.setOnAction(e -> {
			AI1.setVisible(!AI1.isVisible());
			AI2.setVisible(!AI2.isVisible());
			newPuzzle.setVisible(!newPuzzle.isVisible());
			solutionButton.setVisible(!solutionButton.isVisible());
			exit.setVisible(!exit.isVisible());
		});


		VBox buttonBox = new VBox(5, menu, newPuzzle, AI1, AI2, solutionButton, exit);
		HBox welcomeBox = new HBox(150, buttonBox, welcome);
		VBox mainBox = new VBox(50, welcomeBox, board);
		board.setAlignment(Pos.CENTER);
		Scene scene = new Scene(mainBox, 600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Thread t = new Thread(()-> {A_IDS_A_15solver ids = new A_IDS_A_15solver();});
		t.start();

	}

}
