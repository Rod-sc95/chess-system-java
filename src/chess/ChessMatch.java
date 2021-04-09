package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch () {
		board = new Board (8, 8); //Definindo o tamanho do tabuleiro
		initialSetup(); // Chamando dentro do construtor o method de inicio da partida
	}
	
	public ChessPiece[][] getPieces(){ // Retorna a matriz de pe�as de xadrez
		ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumns()]; // Atribuindo valor a matriz atrves da quantidade de coluna e linha do tabuleiro
		for (int i=0; i<board.getRow(); i++) { // Para cada pe�a do meu tabuleiro, ser� feito o downcasting de Piece para ChessPiece
			for (int j=0; j<board.getColumns(); j++) {
				mat [i][j] = (ChessPiece) board.piece(i,j); //Downcast para ChessPiece
			}
		}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source,target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition (Position position) {
		if (!board.thereIsAPiace(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException ("There is no pobbile moves for the chosen pice");
		}
	}
	// Metodo que inclui as pe�as, passando as coordenadas do Xadrez (e n�o da matriz)
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
