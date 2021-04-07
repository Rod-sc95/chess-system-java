package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch () {
		board = new Board (8, 8); //Definindo o tamanho do tabuleiro
		initialSetup(); // Chamando dentro do construtor o method de inicio da partida
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumns()];
		for (int i=0; i<board.getRow(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat [i][j] = (ChessPiece) board.piece(i,j); //Downcast através do ChessPiece
			}
		}
		return mat;
	}
	
	// Metodo que inclui as peças, passando as coordenadas do Xadrez (e não da matriz)
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King (board, Color.BLACK));
		placeNewPiece('e',1, new King(board, Color.WHITE));
	}
}
