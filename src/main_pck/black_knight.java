package main_pck;

public class black_knight extends piece {

	// attributes
	private boolean alive;
	private int[] hold = { getCurrent_x(), getCurrent_y() };

	// constructor
	black_knight(String name, String colour, int current_y, int current_x, boolean alive) {
		super(name, colour, current_x, current_y);
		this.alive = alive;
	}

	// methods
	public int[] gen(int x, int y, piece[][] temp) {
		try {
			if (temp[y][x] == null) {
				return move(x, y, temp);
			} else if (temp[y][x] != null) {
				return take(x, y, temp);
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return hold;
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Invalid!");
			return hold;
		}
	}

	// moving methods
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
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return hold;
			}

		} catch (

		Exception e) {
			System.out.println();
			System.out.println("Invalid");
		}
		return hold;
	}

	// taking methods
	public int[] take(int x, int y, piece[][] temp) {
		if (temp[y][x] != null) {
			if (temp[y][x].getColour().equals("white")) {
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
					System.out.println();
					System.out.println("Invalid!");
					return hold;
				}
			} else {
				System.out.println();
				System.out.println("FRIENDLY FIRE!");
				return hold;
			}
		} else {// moving is empty
			System.out.println();
			System.out.println("Invalid!");
			return hold;
		}
	}

	public int[] repeated(int x, int y, piece[][] temp) {
		System.out.println();
		System.out.println(temp[y][x].getName() + "Taken!");
		hold[0] = x;
		hold[1] = y;
		setCurrent_x(x);
		setCurrent_y(y);
		return hold;
	}

	// if statement thing
	public int[] easy(int x, int y, piece[][] temp) {
		if (temp[y][x] == null) {
			System.out.println();
			System.out.println("Moved!");
			hold[0] = x;
			hold[1] = y;
			setCurrent_x(x);
			setCurrent_y(y);
			return hold;
		} else {
			System.out.println();
			System.out.println("Invalid!");
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
