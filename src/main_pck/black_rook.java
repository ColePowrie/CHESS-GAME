package main_pck;

public class black_rook extends piece {

	// attributes
	private boolean alive;
	private boolean moved;
	private int[] ret = { getCurrent_x(), getCurrent_y() };

	// constructors
	black_rook(String name, String colour, int current_y, int current_x, boolean alive) {
		super(name, colour, current_x, current_y);
		this.alive = alive;
	}

	// methods
	// move methods
	public int[] gen(int x, int y, piece[][] temp) {
		try {
			if (temp[y][x] != null) {
				return take(x, y, temp);
			} else {
				return move(x, y, temp);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid!");
			return ret;
		}
	}

	public int[] move(int x, int y, piece[][] temp) {
		int[] hold = { getCurrent_x(), getCurrent_y() };

		if (getCurrent_x() != x && getCurrent_y() == y) {// if x changes
			if (getCurrent_x() > x) {
				hold[0] = move_holeft(x, y, temp);
				return hold;
			} else if (getCurrent_x() < x) {
				hold[0] = move_horight(x, y, temp);
				return hold;
			} else {
				System.out.println("\nInvalid! Can't move in place!");
				return hold;
			}
		} else if (getCurrent_x() == x && getCurrent_y() != y) {// if y changes
			if (getCurrent_y() < y) {
				hold[1] = move_vertdown(x, y, temp);
				return hold;
			} else if (getCurrent_y() > y) {
				hold[1] = move_vertup(x, y, temp);
				return hold;
			} else {
				System.out.println("\nInvalid! Can't move in place!");
				return hold;
			}
		} else {
			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int move_vertdown(int x, int y, piece[][] temp) {// moves towards sky
		if (isAlive() == true) {
			for (int i = getCurrent_y() - 1; i > y; i--) {
				if (temp[i][getCurrent_x()] != null) {
					System.out.println("\nInvalid!");
					return getCurrent_y();
				}
			} // for loop
			System.out.println("\nMoved!");
			setCurrent_x(x);
			setCurrent_y(y);
			return y;
		} else {
			System.out.println("\nPiece not on board");
			return getCurrent_y();
		}

	}// method vert up

	public int move_vertup(int x, int y, piece[][] temp) {// moves toward ground
		if (isAlive() == true) {
			for (int i = getCurrent_y() + 1; i < y; i++) {
				if (temp[i][getCurrent_x()] != null) {
					System.out.println("\nInvalid!");
					return getCurrent_y();
				}
			} // for loop
			System.out.println("\nMoved!");
			setCurrent_x(x);
			setCurrent_y(y);
			return y;
		} else {
			System.out.println("\nPiece not on board");
			return getCurrent_y();
		}
	}// method vert down

	public int move_horight(int x, int y, piece[][] temp) {// moves to the right
		if (isAlive() == true) {
			for (int i = getCurrent_x() + 1; i < x; i++) {
				if (temp[getCurrent_y()][i] != null) {
					System.out.println("\nInvalid!");
					return getCurrent_x();
				}
			} // for loop
			System.out.println("\nMoved!");
			setCurrent_x(x);
			setCurrent_y(y);
			return x;
		} else {
			System.out.println("\nPiece not on board");
			return getCurrent_x();
		}
	}

	public int move_holeft(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			for (int i = getCurrent_x() - 1; i > x; i--) {
				if (temp[getCurrent_y()][i] != null) {
					System.out.println("\nInvalid!");
					return getCurrent_x();
				}
			} // for loop
			System.out.println("\nMoved!");
			setCurrent_x(x);
			setCurrent_y(y);
			return x;
		} else {
			System.out.println("\nPiece not on board");
			return getCurrent_x();
		}
	}

	// taking methods
	public int[] take(int x, int y, piece[][] temp) {
		if (x > getCurrent_x() && y == getCurrent_y()) {// right
			return take_right(x, y, temp);
		} else if (x < getCurrent_x() && y == getCurrent_y()) {// left
			return take_left(x, y, temp);
		} else if (x == getCurrent_x() && y > getCurrent_y()) {// sky
			return take_up(x, y, temp);
		} else if (x == getCurrent_x() && y < getCurrent_y()) {// ground
			return take_down(x, y, temp);
		} else {
			System.out.println("\nInvalid!");
			return ret;
		}
	}

	public int[] take_right(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (temp[y][x] != null) {
				for (int i = getCurrent_x() + 1; i < x - 1; i++) {
					if (temp[y][i] != null) {
						System.out.println("\nInvalid!");
						return ret;
					}
				} // for loop
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("white")) {
						System.out.println("\n" + temp[y][x].getName() + " Taken!");
						ret[0] = x;
						ret[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return ret;
					} else {
						System.out.println("\nFRIENDLY FIRE!");
						return ret;
					}

				} else {
					System.out.println("\nInvalid!");
					return ret;
				}
			} else {
				System.out.println("\nInvalid!");
				return ret;
			}
		} else {
			System.out.println("\nNot on board!");
			return ret;
		}
	}

	public int[] take_left(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_y() == y && getCurrent_x() != 0 && getCurrent_x() >= 0 && getCurrent_x() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_x() - 1; i < x + 1; i++) {
						if (temp[y][i] != null) {
							System.out.println("\nInvalid!");
							return ret;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("white")) {
							System.out.println("\n" + temp[y][x].getName() + "Taken!");
							ret[0] = x;
							ret[1] = y;
							setCurrent_x(x);
							setCurrent_y(y);
							return ret;
						} else {
							System.out.println("\nFRIENDLY FIRE!");
							return ret;
						}

					} else {
						System.out.println("\nInvalid!");
						return ret;
					}
				} else {
					System.out.println("\nInvalid!");
					return ret;
				}
			} else {
				System.out.println("\nInvalid!");
				return ret;
			}
		} else {
			System.out.println("\nNot on board!");
			return ret;
		}
	}

	public int[] take_up(int x, int y, piece[][] temp) {// sky
		if (isAlive() == true) {
			if (getCurrent_x() == x && getCurrent_y() >= 0 && getCurrent_y() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_y() + 1; i < y - 1; i++) {// cuz of this statement
						if (temp[i][x] != null) {// ERROR HERE
							System.out.println("\nInvalid!");
							return ret;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("white")) {
							System.out.println("\n" + temp[y][x].getName() + " Taken!");
							ret[0] = x;
							ret[1] = y;
							setCurrent_x(x);
							setCurrent_y(y);
							return ret;
						} else {
							System.out.println("\nFRIENDLY FIRE!");
							return ret;
						}

					} else {
						System.out.println("\nInvalid!");
						return ret;
					}
				} else {
					System.out.println("\nInvalid!");
					return ret;
				}
			} else {
				System.out.println("\nInvalid!");
				return ret;
			}
		} else {
			System.out.println("\nNot on board!");
			return ret;
		}
	}

	public int[] take_down(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_x() == x && getCurrent_y() >= 0 && getCurrent_y() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_y() - 1; i < y + 1; i++) {
						if (temp[i][x] != null) {
							System.out.println("\nInvalid!");
							return ret;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("white")) {
							System.out.println();
							System.out.println("\n" + temp[y][x].getName() + "Taken!");
							ret[0] = x;
							ret[1] = y;
							setCurrent_x(x);
							setCurrent_y(y);
							return ret;
						} else {
							System.out.println("\nFRIENDLY FIRE!");
							return ret;
						}

					} else {
						System.out.println("\nInvalid!");
						return ret;
					}
				} else {
					System.out.println("\nInvalid!");
					return ret;
				}
			} else {
				System.out.println("\nInvalid!");
				return ret;
			}
		} else {
			System.out.println("\nNot on board!");
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

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

}
