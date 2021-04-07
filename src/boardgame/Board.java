package boardgame;

public class Board {

	private int rows; // linhas do tabuleiro
	private int columns; // Colunas do tabuleiro
	private Piece [][] pieces; // Matriz de pe�as
	
	public Board(int rows, int columns) {
		if (rows <1 || columns <1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column"); // Criando uma exce��o personalizada
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRow() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece (int row, int column) {
		if (!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces [row][column];
	}
	//Sobrecarga no method
	public Piece piece (Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces [position.getRow()][position.getColumn()];
	}
	
	public void placePiece (Piece piece, Position position) {
		if (thereIsAPiace(position)) {
			throw new BoardException ("There is already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists (int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiace(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
