package main_pck;

public class white_pawn extends piece {

	private boolean moved;
	private boolean alive;
	private int[] hold = { getCurrent_x(), getCurrent_y() };

	// constructors
	white_pawn(String name, String colour, int current_y, int current_x, boolean alive) {
		super(name, colour, current_x, current_y);
		this.alive = alive;
	}

	// methods
	public int[] gen(int x, int y, piece[][] temp) {
		if (x == getCurrent_x() && y + 1 == getCurrent_y()) {
			return move_forward(temp, x, y);
		} else if (x == getCurrent_x() && y + 2 == getCurrent_y()) {
			return move_forward2(temp, x, y);
		} else if (x != getCurrent_x() && y + 1 == getCurrent_y()) {
			return take(x, y, temp);
		} else {
			System.out.println("\nInvalid!");
			return hold;
		}

	}

	// returns the int of the new y position
	public int[] move_forward(piece[][] temp, int x, int y) {
		int hold = getCurrent_y();
		if (isAlive() == true) {
			if (getCurrent_y() > 0 && temp[getCurrent_y() - 1][getCurrent_x()] == null) {// check if there is piece //
				int tempy = getCurrent_y();
				tempy = tempy - 1;
				setCurrent_y(tempy);
				hold = tempy;

				System.out.println("\nMoved!");
				setMoved(true);
				this.hold[0] = getCurrent_x();
				this.hold[1] = hold;
				setCurrent_x(x);
				setCurrent_y(y);
				return this.hold;
			} else {

				System.out.println("\nInvalid Move!");
				return this.hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return this.hold;
		}
	}

	// if hasnt moved yet can move two spaces instead of one
	public int[] move_forward2(piece[][] temp, int x, int y) {
		int hold = getCurrent_y();
		if (isMoved() == false) {
			if (isAlive() == true) {
				if (getCurrent_y() > 0 && temp[getCurrent_y() - 1][getCurrent_x()] == null
						&& temp[getCurrent_y() - 2][getCurrent_x()] == null) {
					int tempy = getCurrent_y();
					tempy = tempy - 2;
					setCurrent_y(tempy);
					hold = tempy;
					this.hold[0] = getCurrent_x();
					this.hold[1] = hold;
					setCurrent_x(x);
					setCurrent_y(y);
					setMoved(true);
					return this.hold;
				} else {

					System.out.println("\nInvalid Move!");
					return this.hold;
				}
			} else {

				System.out.println("\nPiece is not on board!");
				return this.hold;
			}
		} else {// else for ismoved

			System.out.println("\nCannot move twice");
			return this.hold;
		}
	}

	public int[] take(int x, int y, piece[][] temp) { // return a array with 2 spaces for both coordinates
		if (isAlive() == true) {
			if (temp[getCurrent_y() - 1][getCurrent_x() + 1] != null
					&& temp[getCurrent_y() - 1][getCurrent_x() + 1] == temp[y][x]) {// right
				if (temp[y][x].getColour().equals("\nblack")) {
					System.out.println("\nPiece Taken!");
					temp[y][x].setAlive(false);
					setMoved(true);
					hold[0] = x;
					hold[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return hold;
				} else {

					System.out.println("\nFRIENDLY FIRE!");
					return hold;
				} // check colour
			} else if (temp[getCurrent_y()][getCurrent_x()] != null
					&& temp[getCurrent_y() - 1][getCurrent_x() - 1] == temp[y][x]) {// left
				if (temp[y][x].getName() == "black") {
					System.out.println("\nPiece Taken!");
					temp[y][x].setAlive(false);
					setMoved(true);
					hold[0] = x;
					hold[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return hold;
				} else {

					System.out.println("\nFRIENDLY FIRE!");
					return hold;
				} // check colour
			} else {// if there isnt a piece there

				System.out.println("\nInvalid!");
				return hold;
			}

		} else {// is not on the board

			System.out.println("\nPiece is not on board!");
			return hold;
		}
	}

	// setters and getters
	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
