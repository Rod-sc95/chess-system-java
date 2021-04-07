package chess;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private int row;
	public ChessPosition(char column, int row) {
		if (column <'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	
	// Convers�o da posi��o do xadrez para posi��o da matriz
	protected Position toPosition() {
		return new Position (8-row, column - 'a');
	}
	
	// Convers�o da posi��o da matriz para uma posi��o de xadrez
	protected static ChessPosition fromPosition (Position position) {
		return new ChessPosition ((char)('a' - position.getColumn()), 8 - position.getRow()); //Feito o casting para char para retornar a posi��o;
	} // Posi��o no xadrez: Coluna x Linha ( char x int )
	
	@Override
	public String toString() {
		return " " + column + row; // String vazio serve para for�ar o compilador a enteder a concatena��o de string
	}

}
