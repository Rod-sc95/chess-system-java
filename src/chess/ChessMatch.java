package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
		board.placePiece(new King(board, Color.BLACK), new Position(0,4));
		board.placePiece(new King(board, Color.WHITE), new Position(7,4));
	}
}
