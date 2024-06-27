package main_pck;

public class white_knight extends piece {

	// attributes
	private boolean alive;
	private int[] hold = { getCurrent_x(), getCurrent_y() };

	// constructors
	white_knight(String name, String colour, int current_y, int current_x, boolean alive) {
		super(name, colour, current_x, current_y);
		this.alive = alive;
	}

	// methods
	// up one then diag, down one then diag
	// side right then up/down, side left then up/down
	public int[] gen(int x, int y, piece[][] temp) {
		try {
			if (temp[y][x] == null) {
				return move(x, y, temp);
			} else if (temp[y][x] != null) {
				return take(x, y, temp);
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} catch (Exception e) {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] move(int x, int y, piece[][] temp) {
		try {
			if (x == getCurrent_x() - 1 && y == getCurrent_y() - 2) {
				return easy(x, y, temp);
			} else if (x == getCurrent_x() + 1 && y == getCurrent_y() - 2) {
				return easy(x, y, temp);
			} else if (x == getCurrent_x() - 1 && y == getCurrent_y() + 2) {
				return easy(x, y, temp);
			} else if (x == getCurrent_x() + 1 && y == getCurrent_y() + 2) {
				return easy(x, y, temp);
			} else if (x == getCurrent_x() + 2 && y == getCurrent_y() - 1) {
				return easy(x, y, temp);
			} else if (x == getCurrent_x() + 2 && y == getCurrent_y() + 1) {
				return easy(x, y, temp);
			} else if (x == getCurrent_x() - 2 && y == getCurrent_y() - 1) {
				return easy(x, y, temp);
			} else if (x == getCurrent_x() - 2 && y == getCurrent_y() + 1) {
				return easy(x, y, temp);
			} else {// not a valid move

				System.out.println("\nInvaliad!");// error here
				return hold;
			}
		} catch (Exception e) {

			System.out.println("\nInvalid");
		}
		return hold;
	}

	public int[] take(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (temp[y][x] != null) {
				if (temp[y][x].getColour().equals("\nblack")) {
					if (x == getCurrent_x() - 1 && y == getCurrent_y() - 2) {
						return repeated(x, y, temp);
					} else if (x == getCurrent_x() + 1 && y == getCurrent_y() - 2) {
						return repeated(x, y, temp);
					} else if (x == getCurrent_x() - 1 && y == getCurrent_y() + 2) {
						return repeated(x, y, temp);
					} else if (x == getCurrent_x() + 1 && y == getCurrent_y() + 2) {
						return repeated(x, y, temp);
					} else if (x == getCurrent_x() + 2 && y == getCurrent_y() - 1) {
						return repeated(x, y, temp);
					} else if (x == getCurrent_x() + 2 && y == getCurrent_y() + 1) {
						return repeated(x, y, temp);
					} else if (x == getCurrent_x() - 2 && y == getCurrent_y() - 1) {
						return repeated(x, y, temp);
					} else if (x == getCurrent_x() - 2 && y == getCurrent_y() + 1) {
						return repeated(x, y, temp);
					} else {// not a valid move

						System.out.println("\nInvalid!");
						return hold;
					}
				} else {

					System.out.println("\nFRIENDLY FIRE!");
					return hold;
				}
			} else {// moving is empty

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {// if not on board

			System.out.println("\nNot on board!");
			return hold;
		}
	}

	public int[] repeated(int x, int y, piece[][] temp) {

		System.out.println("\nTaken!");
		hold[0] = x;
		hold[1] = y;
		setCurrent_x(x);
		setCurrent_y(y);
		return hold;
	}

	// if statement thing
	public int[] easy(int x, int y, piece[][] temp) {
		if (temp[y][x] == null) {

			System.out.println("\nMoved!");
			hold[0] = x;
			hold[1] = y;
			setCurrent_x(x);
			setCurrent_y(y);
			return hold;
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	// setters and getters
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
