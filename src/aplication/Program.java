package aplication;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		List <ChessPiece> captured = new ArrayList<ChessPiece>();
	
		
		while (!chessMatch.getCheckMate()) {
			try {
				
					UI.clearScreen();
					UI.printMatch(chessMatch, captured);
					System.out.println();
					System.out.println("Source: ");
					ChessPosition source = UI.readChessPosition(sc);
					
					boolean[][] possibleMoves = chessMatch.possibleMoves(source);
					UI.clearScreen();
					UI.printBoard(chessMatch.getPieces(), possibleMoves);
					
					System.out.println();
					System.out.println("Target: ");
					ChessPosition target = UI.readChessPosition(sc);
					
					ChessPiece capturedPiece = chessMatch.performChessMove(source,target);
					if(capturedPiece != null) captured.add(capturedPiece);
				
					if(chessMatch.getPromoted() != null) {
						String[] types = {"B","N","Q","R"};
						List<String> typesList = Arrays.asList(types);
						
						
						
						System.out.print("Enter piece for promotion (B/N/R/Q):");
						String type = sc.nextLine().toUpperCase();
						while (!typesList.contains(type)) {
							System.out.print("Invalid value! - Enter piece for promotion (B/N/R/Q):");
							type = sc.nextLine().toUpperCase();
						};
						chessMatch.replacePromotedPiece(type);
					}
					
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		
		
	}

}
