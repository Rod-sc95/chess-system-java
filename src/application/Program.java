package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		// Instancia��o da partida
		ChessMatch chessMatch = new ChessMatch();
		// Fun��o que imprimi as pe�as da partida atraves da class UI pelo metodo printBoard dentro da class
		UI.printBoard(chessMatch.getPieces());

	}

}
