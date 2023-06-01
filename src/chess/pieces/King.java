 package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		
		//Below and Right
		for(int i = 0 ; i < 2; i++) {
			for(int j = 0;j < 2; j++) {
				p.setValues(position.getRow() + i, position.getColumn() + j);
				if(getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;
				
			}
		}
		
		//Above and Right
		for(int i = 0 ; i < 2; i++) {
			for(int j = 0;j<2; j++) {
				p.setValues(position.getRow() - i, position.getColumn() + j);
				if(getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//Below and Left
		for(int i = 0 ; i < 2; i++) {
			for(int j = 0;j<2; j++) {
				p.setValues(position.getRow() + i, position.getColumn() - j);
				if(getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//Above and Left
		for(int i = 0 ; i < 2; i++) {
			for(int j = 0;j<2; j++) {
				p.setValues(position.getRow() - i, position.getColumn() - j);
				if(getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;
			}
		}
		return mat;
	}

}
