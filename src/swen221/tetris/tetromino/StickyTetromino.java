package swen221.tetris.tetromino;

import swen221.tetris.logic.Rectangle;

/**
 * Represents a tetromino which can only perform one rotation operation.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class StickyTetromino implements Tetromino {

	private int count;
	private Tetromino tetromino;

	public StickyTetromino(int count, Tetromino tetromino) {
		this.count = count;
		this.tetromino = tetromino;
	}

	@Override
	public Color getColor() {
		if (count <= 0) {
			return Tetromino.Color.DARK_GRAY; 
		}
		else {
			return tetromino.getColor();
		}
		

	}

	@Override
	public Orientation getOrientation() {

		return tetromino.getOrientation();
	}

	@Override
	public boolean isWithin(int x, int y) {
		return tetromino.isWithin(x, y);
	}

	@Override
	public Rectangle getBoundingBox() {
		return tetromino.getBoundingBox();
	}

	@Override
	// updates the counts and returns the current active tetromino
	public Tetromino rotate(int steps) {

		int rotate = 0;

		if (steps > count) {
			rotate = count;
			count = 0;
		} else {
			rotate = steps;
			count = count - steps;
		}
		

		if (tetromino instanceof I_Tetromino) {
			return new StickyTetromino(count, new I_Tetromino(getOrientation().rotate(rotate), getColor()));
		} else if (tetromino instanceof J_Tetromino) {
			return new StickyTetromino(count, new J_Tetromino(getOrientation().rotate(rotate), getColor()));
		} else if (tetromino instanceof L_Tetromino) {
			return new StickyTetromino(count, new L_Tetromino(getOrientation().rotate(rotate), getColor()));
		} else if (tetromino instanceof O_Tetromino) {
			return new StickyTetromino(count, new O_Tetromino(getColor()));
		} else if (tetromino instanceof S_Tetromino) {
			return new StickyTetromino(count, new S_Tetromino(getOrientation().rotate(rotate), getColor()));

		} else if (tetromino instanceof T_Tetromino) {
			return new StickyTetromino(count, new T_Tetromino(getOrientation().rotate(rotate), getColor()));
		} else {
			return new StickyTetromino(count, new Z_Tetromino(getOrientation().rotate(rotate), getColor()));
		}
	}
}
