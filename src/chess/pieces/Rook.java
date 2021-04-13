package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}
	
	// Method para verificar se a posi��o da pe�a � possivel;
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean [getBoard().getRow()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//Marca��o das casas poss�veis ACIMA da pe�a como verdadeiro
		p.setValues(position.getRow() -1 , position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiace(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Marca��o das casas poss�veis ESQUERDA da pe�a como verdadeiro
		p.setValues(position.getRow() , position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiace(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Marca��o das casas poss�veis DIREITA da pe�a como verdadeiro
		p.setValues(position.getRow() , position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiace(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Marca��o das casas poss�veis BAIXO da pe�a como verdadeiro
		p.setValues(position.getRow() +1 , position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiace(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return null;
	}
}
