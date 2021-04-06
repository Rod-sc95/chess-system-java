package boardgame;

public class Board {

	private int row; // linhas do tabuleiro
	private int columns; // Colunas do tabuleiro
	private Piece [][] pieces; // Matriz de peças
	
	public Board(int row, int columns) {
		this.row = row;
		this.columns = columns;
		pieces = new Piece[row][columns];
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece (int row, int column) {
		return pieces [row][column];
	}
	//Sobrecarga no method
	public Piece piece (Position position) {
		return pieces [position.getRow()][position.getColumn()];
	}
}
