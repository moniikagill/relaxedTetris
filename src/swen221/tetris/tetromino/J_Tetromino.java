package swen221.tetris.tetromino;

import swen221.tetris.logic.Rectangle;

/**
 * The "J" tetromino.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class J_Tetromino extends AbstractTetromino {

	public J_Tetromino(Orientation orientation, Color color) {
		super(orientation, color);
	}

	@Override
	/**
	 * 
	 * @param x 
	 * 			
	 */
	public boolean isWithin(int x, int y) {
		return (x >= -1 && x <=1 && y == 0) || (x == -1 && y == 1);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(-1, 1, 1, 0);
	}

	@Override
	public Tetromino rotate(int steps) {
		return new J_Tetromino(orientation.rotate(steps), color);
	}
}