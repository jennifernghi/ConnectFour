

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BoardGui extends Application {
	private BoardPresenter presenter;

	private GridPane grid;
	private Button player1Button;
	private Button player2Button;
	private double chipRadius = 25;
	private BorderPane root;
	private Label player1Win;
	private Label player2Win;
	

	public BoardGui(BoardPresenter presenter) {
		this.presenter = presenter;
		presenter.setView(this);

	}
	
	/**
	 * set GridPane object to grid
	 * @param Gridpane object
	 */
	public void setGridPane(GridPane grid) {
		this.grid = grid;
	}

	/**
	 * returns the current grid object
	 * @return GridPane object 
	 */
	public GridPane getGridPane() {
		return this.grid;
	}
	
	/**
	 * set the current presenter
	 * @param BoardPresenter object
	 */
	public void setPresenter(BoardPresenter presenter) {
		this.presenter = presenter;
	}
	
	/**
	 * returns the current presenter
	 * @return BoardPresenter object
	 */
	public BoardPresenter getPresenter() {
		return this.presenter;
	}

	/**
	 * returns the radius of chip token
	 * @return double value of token's radius 
	 */
	public double getChipRadius() {
		return this.chipRadius;
	}

	/**
	 * Constructs a pane that contains label of game, player1Button, player2Button, 
	 * clearButton, player1win label and player2win label.
	 * @return a Vbox pane that will situate at the right of stage
	 */
	public VBox showRightBoxGUI() {
		VBox rightBox = new VBox(10);
		Label label = new Label("CONNECT FOUR");

		player1Button = new Button("Player " + presenter.getPlayer1().toString());
		player2Button = new Button("Player " + presenter.getPlayer2().toString());

		player1Button.setMinWidth(200);
		player2Button.setMinWidth(200);

		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.GREEN);
		player1Button.setEffect(shadow);
		player1Button.setTextFill(Color.GREEN);

		DropShadow shadow2 = new DropShadow();
		shadow2.setColor(Color.RED);
		player2Button.setEffect(shadow2);
		player2Button.setTextFill(Color.RED);

		player1Button.setDisable(false);
		player2Button.setDisable(true);

		//clears the win count displayed and clear all chips on Board
		Button clearButton = new Button("Clear");
		clearButton.setOnMouseClicked(e -> {
			player1Win.setText("0");
			player2Win.setText("0");
			presenter.resetWins();
			clear();
		});
		
		//creates hbox to contain all winning counts of players
		HBox hbox = new HBox(); 
		Label win = new Label(":");
		win.setFont(new Font(30));
		
		player1Win = new Label("0");
		player1Win.setFont(new Font(30));
		player1Win.setTextFill(Color.GREEN);
		
		player2Win = new Label("0");
		player2Win.setFont(new Font(30));
		player2Win.setTextFill(Color.RED);
		
		hbox.getChildren().addAll(player1Win,win, player2Win); 
		hbox.setAlignment(Pos.CENTER);
	

		rightBox.getChildren().addAll(label, player1Button, player2Button, hbox, clearButton);
		rightBox.setAlignment(Pos.TOP_CENTER);
		return rightBox;
	}

	/**
	 * create circle shape representation of chip token
	 * @param color of player's designed chip color; Green is player1, Red is player2
	 * @return Circle object
	 */
	public Circle circleChip(Paint color) {
		Circle cir = new Circle(getChipRadius());
		cir.setFill(color);

		return cir;
	}
	
	/**
	 * display message window that prompts a winning move by player
	 * @param the name of winning player
 	 */

	public void promptWinner(String playerId) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Game Over!");
		alert.setContentText("Player " + playerId + " won.");
		alert.showAndWait();
		clear();
	}
	
	/**
	 * display message window that prompts a tie between occurs 
	 * (ie: when the board is full and no winning move)
	 */

	public void promptTie() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Game Over!");
		alert.setContentText("It's a tie!");
		alert.showAndWait();
		clear();
	}

	/**
	 * display message window that prompts an invalid move by current player and ask to try again
	 * (ie when a column is full while other columns are not full)
	 */
	public void promptInvalidMove() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Invalid Move!");
		alert.setContentText("Try again!");
		alert.showAndWait();
	}

	/* create the board grid 
	 * @param integer size of the board
	 */
	public void createGrid(int size) {

		grid = new GridPane();

		grid.getStyleClass().add("game-grid");

		// add colums on the grid using numberOfColumns
		for (int i = 0; i < size; i++) {
			ColumnConstraints column = new ColumnConstraints(60);
			grid.getColumnConstraints().add(column);

		}
		// add rows on the grid using numberOfRow
		for (int i = 0; i < size; i++) {
			RowConstraints row = new RowConstraints(60);
			grid.getRowConstraints().add(row);
		}

		// add responsive cell onto the grid
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				StackPane pane = new StackPane();

				int column = i;

				// when the cell is clicked, add a rectangle with chosen color
				// onto the cell
				pane.setOnMouseReleased(e -> {
					presenter.putChip(column);
					presenter.checkWinner();
				});

				pane.getStyleClass().add("game-grid-cell"); // associate each
															// pane with css
															// .game-grid-cell
				if (i == 0) {
					pane.getStyleClass().add("first-column");
				}
				if (j == 0) {
					pane.getStyleClass().add("first-row");
				}

				Circle circle = new Circle();
				circle.setRadius(25.0);
				// circle.relocate(5, 5);
				circle.setFill(Color.WHITE);
				pane.getChildren().add(circle);
				pane.setAlignment(circle, Pos.CENTER);

				// add cell to the grid
				grid.add(pane, i, j);

			}
		}
	}

	/**
	 * place chip token into given row and column
	 * the values of row and column is given by BoardPresenter;
	 * player1Button is set disable when the following turn is proceed by player2 and vice versa
	 * @param integer value of row
	 * @param integer value of column 
	 */
	public void putChip(int row, int column) {
		
		//loops through all nodes in grid and finds the corresponding cell
		for (Node node : grid.getChildren()) {
			if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
				Pane pane = (Pane) node;
				if (presenter.getTurn() == 1) {
					player1Button.setDisable(false);
					player2Button.setDisable(true);
					pane.getChildren().add(circleChip(presenter.getPlayer2().getChip().getColor()));

				} else {
					player1Button.setDisable(true);
					player2Button.setDisable(false);
					pane.getChildren().add(circleChip(presenter.getPlayer1().getChip().getColor()));
				}
			}
		}
	}

	/**
	 * clears all current chip tokens in grid
	 * calls BoardPresenter to clear internal data
	 * set player2button to disable
	 */
	public void clear() {
		grid.getChildren().clear();
		createGrid(presenter.getSize());
		root.setCenter(grid);

		player1Button.setDisable(false);
		player2Button.setDisable(true);
	
		presenter.clear();
	}
	
	/**
	 * updates player1win label with current number of wins
	 * @param the number of player1's wins 
	 */
	public void updatePlayer1Win(int win)
	{
		player1Win.setText(""+win);
	}
	
	/**
	 * updates player2win label with current number of wins
	 * @param the number of player2's wins 
	 */
	public void updatePlayer2Win(int win)
	{
		player2Win.setText(""+win);
	}

	/**
	 *create borderPane as root and grid
	 *set Vbox to the right of borderPane
	 *set grid to the center of borderPane
	 */
	public void start(Stage primaryStage) throws Exception {

		createGrid(presenter.getSize());
		root = new BorderPane();

		root.setCenter(grid);

		root.setRight(showRightBoxGUI());

		Scene scene = new Scene(root, 850, 700);

		// link to the css file

		scene.getStylesheets().add(this.getClass().getResource("game.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Connect 4");

		primaryStage.show();
	}

}
