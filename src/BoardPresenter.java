

import javafx.scene.paint.Color;

public class BoardPresenter {
	
	private BoardGui view;
	private BoardModel boardModel;
	private AbstractPlayer player1;
	private AbstractPlayer player2;
	private Integer turn = 1;
	private Integer size; 
	private Integer player1Win;
	private Integer player2Win; 

/**
 * creates boardModel with the size;
 * creates 2 AbstractPlayers with their indivd. number representation and chip color
 * initialize number of wins each player has
 * @param the size of the grid given by argument 
 * @param the length of winning sequence
 */
	public BoardPresenter(Integer size, Integer winningMove) {

		this.size = size; 
		
		setBoardModel(new BoardModel(size, winningMove));

		player1 = new Players(1, new Chip(1, Color.GREEN));
		player2 = new Players(2, new Chip(2, Color.RED));
		
		player1Win =0;
		player2Win = 0;

	}

	/**
	 * sets the current BoardGui to presenter
	 * @param BoardGui view
	 */
	public void setView(BoardGui view) {
		this.view = view;
	}
	
	/**
	 * returns size of the grid given by the user through argument 
	 * @return integer size of the grid
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * returns the current BoardGUI associated with this presenter
	 * @return BoardGui view
	 */

	public BoardGui getView() {
		return this.view;
	}

	/**
	 * sets the current BoardModel object associated with this presenter
	 * @param BoardModel boardModel
	 */
	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
	}
	
	/**
	 * returns the current BoardModel object associated with this presenter
	 * @return BoardModel boardModel
	 */

	public BoardModel getBoardModel() {
		return this.boardModel;
	}
	
	/**
	 * returns player1 object 
	 * @return AbstractPlayer player1
	 */
	public AbstractPlayer getPlayer1() {
		return this.player1;
	}
	
	/**
	 * returns player2 object 
	 * @return AbstractPlayer player2
	 */

	public AbstractPlayer getPlayer2() {
		return this.player2;
	}
	
	/**
	 * sets each turn of player;
	 * 1 corresponds to player1's turn
	 * 2 corresponds to player2's turn 
	 * @param integer value turn
	 */

	private void setTurn(Integer turn) {
		this.turn = turn;
	}

	/**
	 * returns the current turn 
	 * @return Integer turn
	 */
	public Integer getTurn() {
		return this.turn;
	}
	
	/**
	 * returns the current number of player1's win
	 * @return integer player1Win
	 */
	
	public Integer getPlayer1Win(){
		return player1Win;
	}
	
	/**
	 *returns the current number of player2's win
	 * @return integer player2Win
	 */
	
	public Integer getPlayer2Win(){
		return player2Win;
	}

	/**
	 * calls boardModel to place chip into internal representation of grid 
	 * if boardModel.putChip returns -1, presenter will notify view to prompt invalid move
	 * if boardModel.putCHip returns positive value, presenter will pass the row value to view to display the chip 
	 * 	in corresponding cell 
	 * @param column that user chooses 
	 */
	public void putChip(int column) {
		int row;

		if (getTurn() == 1) {
			row = boardModel.putChip(player1.getChip(), column);
			
			if (row>-1) {
				setTurn(2);	
			}
		} else {
			row = boardModel.putChip(player2.getChip(), column);
			if (row>-1) {
				setTurn(1);
			}
			
		}
		view.putChip(row, column);

		
		if (row<=-1)
			view.promptInvalidMove();
	}
	
	/**
	 * calls boardModel to checkWinner;
	 * if boardModel.checkWinner returns -1, presenter will notify view to diplay a tie
	 * if boardModel.checkWinner returns 1, presenter will notify view to display player1 wins
	 * if boardModel.checkWinner returns 2, presenter will notify view to display player2 wins
	 */
	
	public void checkWinner()
	{
		int winner = boardModel.checkWinner();

		if (winner == 1){
			view.promptWinner("" + player1.getPlayerId());
			view.updatePlayer1Win(++player1Win);
		}
		else if (winner == 2){
			view.promptWinner("" + player2.getPlayerId());
			view.updatePlayer2Win(++player2Win);
		}
		else if (winner == -1)
			view.promptTie(); // when the board is filled	
	}
	
	/**
	 * resets the number of wins of all players to 0
	 */
	
	public void resetWins()
	{
		player1Win = 0;
		player2Win = 0; 
	}
	
	/**
	 * calls boardModel to reset internal representation of grid;
	 * reset turn to player1
	 */
	public void clear()
	{
		setTurn(1);
		boardModel.clear();
	}
	

}
