package main_pck;

public class white_bishop extends piece {

	private boolean alive;
	private int[] ret = { getCurrent_x(), getCurrent_y() };

	// constructors
	white_bishop(String name, String colour, int current_y, int current_x, boolean alive) {
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
				return ret;
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Invalid");
			return ret;
		}
	}

	public int[] take(int x, int y, piece[][] temp) {
		if (x > getCurrent_x() && y < getCurrent_y()) {
			return take_topright(x, y, temp);
		} else if (x > getCurrent_x() && y > getCurrent_y()) {
			return take_botright(x, y, temp);
		} else if (x < getCurrent_x() && y > getCurrent_y()) {
			return take_botleft(x, y, temp);
		} else if (x < getCurrent_x() && y < getCurrent_y()) {
			return take_topleft(x, y, temp);
		} else {
			System.out.println();
			System.out.println("Invalid!");
			return ret;
		}
	}

	public int[] move(int x, int y, piece[][] temp) {
		if (x > getCurrent_x() && y < getCurrent_y()) {
			return move_upright(x, y, temp);
		} else if (x > getCurrent_x() && y > getCurrent_y()) {
			return move_botright(x, y, temp);
		} else if (x < getCurrent_x() && y > getCurrent_y()) {
			return move_botleft(x, y, temp);
		} else if (x < getCurrent_x() && y < getCurrent_y()) {
			return move_upleft(x, y, temp);
		} else {
			System.out.println("\nInvalid!");
			return ret;
		}
	}

	// MOVING METHODS
	public int[] move_upright(int x, int y, piece[][] temp) {
		int counter = 0;
		if (isAlive() == true) {
			if (x - getCurrent_x() == getCurrent_y() - y) {// checks to make sure even coordinates
				int hold = x - getCurrent_x();
				for (int i = 0; i < hold; i++) {
					if (temp[getCurrent_y() - i - 1][getCurrent_x() + i + 1] != null) {
						System.out.println();
						System.out.println("Invalid!");
						return ret;
					} else {
						counter++;
					}
				} // for loop
				if (counter == x - getCurrent_x() && counter == getCurrent_y() - y) {
					System.out.println();
					System.out.println("Moved!");
					ret[0] = x;
					ret[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return ret;
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else {// if the distance moved isnt the same
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		}
		return ret;
	}

	public int[] move_upleft(int x, int y, piece[][] temp) {
		int counter = 0;
		if (isAlive() == true) {
			if (getCurrent_x() - x == getCurrent_y() - y) {
				int hold = getCurrent_x() - x;
				if (x == getCurrent_x() && y == getCurrent_y()) {
					System.out.println();
					System.out.println("Invalid");
					return ret;
				}
				for (int i = 0; i < hold; i++) {
					if (temp[getCurrent_y() - i - 1][getCurrent_x() - i - 1] != null) {
						System.out.println();
						System.out.println("Invalid!");
						return ret;
					} else {
						counter++;
					}
				} // for
				if (counter == getCurrent_x() - x && counter == getCurrent_y() - y) {
					System.out.println();
					System.out.println("Moved!");
					ret[0] = x;
					ret[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return ret;
				} else {
					System.out.println();
					System.out.println("Invalid");
					return ret;
				}

			} else {
				System.out.println();
				System.out.println("Invalid!");
			}
		} else {// isalive
			System.out.println();
			System.out.println("Piece is not on the board!");
		}

		return ret;
	}

	public int[] move_botright(int x, int y, piece[][] temp) {
		int counter = 0;
		if (isAlive() == true) {
			if (x - getCurrent_x() == y - getCurrent_y()) {
				int hold = x - getCurrent_x();
				if (x == getCurrent_x() && y == getCurrent_y()) {
					System.out.println();
					System.out.println("Invalid");
					return ret;
				}
				for (int i = 0; i < hold; i++) {
					if (temp[getCurrent_y() + i + 1][getCurrent_x() + i + 1] != null) {
						System.out.println();
						System.out.println("Invalid!");
						return ret;
					} else {
						counter++;
					}
				} // for
				if (counter == x - getCurrent_x() && counter == y - getCurrent_y()) {
					System.out.println();
					System.out.println("Moved!");
					ret[0] = x;
					ret[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return ret;
				} else {
					System.out.println();
					System.out.println("Invalid");
					return ret;
				}

			} else {
				System.out.println();
				System.out.println("Invalid!");
			}
		} else {// isalive
			System.out.println();
			System.out.println("Piece is not on the board!");
		}

		return ret;
	}

	public int[] move_botleft(int x, int y, piece[][] temp) {
		int counter = 0;
		if (isAlive() == true) {
			if (getCurrent_x() - x == y - getCurrent_y()) {
				int hold = getCurrent_x() - x;
				if (x == getCurrent_x() && y == getCurrent_y()) {
					System.out.println();
					System.out.println("Invalid");
					return ret;
				}
				for (int i = 0; i < hold; i++) {
					if (temp[getCurrent_y() + i + 1][getCurrent_x() - i - 1] != null) {
						System.out.println();
						System.out.println("Invalid!");
						return ret;
					} else {
						counter++;
					}
				} // for
				if (counter == getCurrent_x() - x && counter == y - getCurrent_y()) {
					System.out.println();
					System.out.println("Moved!");
					ret[0] = x;
					ret[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return ret;
				} else {
					System.out.println();
					System.out.println("Invalid");
					return ret;
				}

			} else {
				System.out.println();
				System.out.println("Invalid!");
			}
		} else {// isalive
			System.out.println();
			System.out.println("Piece is not on the board!");
		}

		return ret;
	}

	// TAKING METHODS

	public int[] take_topright(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x - 1 == getCurrent_x() && y + 1 == getCurrent_y()) {// just moves one
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("black")) {
						System.out.println();
						System.out.println("Moved!");
						ret[0] = x;
						ret[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return ret;
					} else {
						System.out.println();
						System.out.println("FRIENDLY FIRE!");
						return ret;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else if ((x - getCurrent_x() == getCurrent_y() - y) && (x - getCurrent_x()) > 0
					&& (getCurrent_y() - y) > 0) {
				for (int i = 1; i < x; i++) {
					if (temp[getCurrent_y() - i][getCurrent_x() + i] != null) {// something in way
						System.out.println();
						System.out.println("Invalid!");// THIS IS THE ISSUE
						return ret;
					}
				} // end of for loop
				System.out.println();
				System.out.println("Moved!");
				ret[0] = x;
				ret[1] = y;
				setCurrent_x(x);
				setCurrent_y(y);
				return ret;
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {// not alive
			System.out.println();
			System.out.println("Not on board!");
			return ret;
		}
	}

	public int[] take_topleft(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x + 1 == getCurrent_x() && y + 1 == getCurrent_y()) {// just moves one
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("black")) {
						System.out.println();
						System.out.println("Moved!");
						ret[0] = x;
						ret[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return ret;
					} else {
						System.out.println();
						System.out.println("FRIENDLY FIRE!");
						return ret;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else if ((getCurrent_x() - x == getCurrent_y() - y) && (getCurrent_x() - x) > 0
					&& (getCurrent_y() - y) > 0) {
				for (int i = 1; i < x; i++) {
					if (temp[getCurrent_y() - i][getCurrent_x() - i] != null) {// something in way
						System.out.println();
						System.out.println("Invalid!");// THIS IS THE ISSUE
						return ret;
					}
				} // end of for loop
				System.out.println();
				System.out.println("Moved!");
				ret[0] = x;
				ret[1] = y;
				setCurrent_x(x);
				setCurrent_y(y);
				return ret;
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {// not alive
			System.out.println();
			System.out.println("Not on board!");
			return ret;
		}
	}

	public int[] take_botright(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x - 1 == getCurrent_x() && y - 1 == getCurrent_y()) {// just moves one
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("black")) {
						System.out.println();
						System.out.println("Moved!");
						ret[0] = x;
						ret[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return ret;
					} else {
						System.out.println();
						System.out.println("FRIENDLY FIRE!");
						return ret;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else if ((x - getCurrent_x() == y - getCurrent_y()) && (x - getCurrent_x() > 0)
					&& (y - getCurrent_y()) > 0) {
				for (int i = 1; i < x; i++) {
					if (temp[getCurrent_y() + i][getCurrent_x() + i] != null) {// something in way
						System.out.println();
						System.out.println("Invalid!");// THIS IS THE ISSUE
						return ret;
					}
				} // end of for loop
				System.out.println();
				System.out.println("Moved!");
				ret[0] = x;
				ret[1] = y;
				setCurrent_x(x);
				setCurrent_y(y);
				return ret;
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {// not alive
			System.out.println();
			System.out.println("Not on board!");
			return ret;
		}
	}

	public int[] take_botleft(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x + 1 == getCurrent_x() && y - 1 == getCurrent_y()) {// just moves one
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("black")) {
						System.out.println();
						System.out.println("Moved!");
						ret[0] = x;
						ret[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return ret;
					} else {
						System.out.println();
						System.out.println("FRIENDLY FIRE!");
						return ret;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else if ((getCurrent_x() - x == y - getCurrent_y()) && (getCurrent_x() - x > 0)
					&& (y - getCurrent_y()) > 0) {
				for (int i = 1; i < x; i++) {
					if (temp[getCurrent_y() + i][getCurrent_x() - i] != null) {// something in way
						System.out.println();
						System.out.println("Invalid!");// THIS IS THE ISSUE
						return ret;
					}
				} // end of for loop
				System.out.println();
				System.out.println("Moved!");
				ret[0] = x;
				ret[1] = y;
				setCurrent_x(x);
				setCurrent_y(y);
				return ret;
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {// not alive
			System.out.println();
			System.out.println("Not on board!");
			return ret;
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
