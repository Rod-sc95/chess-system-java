package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		// Instanciação da partida
		ChessMatch chessMatch = new ChessMatch();
		// Função que imprimi as peças da partida atraves da class UI pelo metodo printBoard dentro da class
		UI.printBoard(chessMatch.getPieces());

	}

}
