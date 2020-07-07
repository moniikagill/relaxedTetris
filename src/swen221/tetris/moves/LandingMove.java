package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a "landing" move. That is, when the tetromino is placed on the
 * board properly.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class LandingMove implements Move {
	private int lines;

	public LandingMove() {
		this.lines = -1;
	}

	public LandingMove(int lines) {
		this.lines = lines;
	}

	@Override
	public boolean isValid(Board board) {
		
		int width = board.getWidth();
		int height = board.getHeight();
		
		int i = 0;
		
		boolean full = true;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (board.getTetrominoAt(x, y) == null) {
					full = false;
				}
			}
			
			if (!full) break;
			
			i++;
		}
		
		if (i != this.lines) return false;

		return true;
	}

	@Override
	public Board apply(Board board) {
		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		// Place tetromino on board
		board.put(board.getTetromino());
		// Reset active tetromino
		board.updateTetromino(null);
		// Remove any full rows
		removeFullRows(board);
		// DOne!
		return board;
	}

	/**
	 * Remove any rows on the board which are now full.
	 *
	 * @param board
	 * @return
	 */
	private void removeFullRows(Board board) {
		board.removeFullRows();
		
		
	}


	@Override
	public String toString() {
		return "landing " + lines;
	}
}
