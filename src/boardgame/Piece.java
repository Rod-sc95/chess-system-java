package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; // valor da pe�a come�ar� como null
	}

	protected Board getBoard() {
		return board;
	}

	
}
