package main_pck;

public class white_rook extends piece {

	private boolean moved;
	private boolean alive;
	private int[] hold = { getCurrent_x(), getCurrent_y() };

	// constructors
	white_rook(String name, String colour, int current_y, int current_x, boolean alive) {
		super(name, colour, current_x, current_y);
		this.alive = alive;
	}

	// METHODS:
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

	public int[] move(int x, int y, piece[][] temp) {
		if ((getCurrent_y() > y || getCurrent_y() < y) && getCurrent_x() == x) {
			hold[1] = move_vert(x, y, temp);
			hold[0] = getCurrent_x();
			return hold;
		} else if ((getCurrent_x() > x || getCurrent_x() < x) && getCurrent_y() == y) {
			hold[0] = move_hor(x, y, temp);
			hold[1] = getCurrent_y();
			return hold;
		} else {
			System.out.println();
			System.out.println("Invalid!");
			return hold;
		}
	}

	public int move_vert(int x, int y, piece[][] temp) {// y
		if (getCurrent_y() < y) {
			return move_vertdown(x, y, temp);
		} else if (getCurrent_y() > y) {
			return move_vertup(x, y, temp);
		} else {
			System.out.println();
			System.out.println("Invalid! Can't move in place!");
		}
		return getCurrent_y();

	}

	public int move_hor(int x, int y, piece[][] temp) {// x
		if (getCurrent_x() > x) {
			return move_holeft(x, y, temp);
		} else if (getCurrent_x() < x) {
			return move_horight(x, y, temp);
		} else {
			System.out.println();
			System.out.println("Invalid! Can't move in place!");
		}
		return getCurrent_x();
	}

	public int move_vertup(int x, int y, piece[][] temp) {// moves towards sky
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

	public int move_vertdown(int x, int y, piece[][] temp) {// moves toward ground
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
			System.out.println();
			System.out.println("Invalid!");
			return hold;
		}
	}

	public int[] take_right(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_y() == y && getCurrent_x() != 0 && getCurrent_x() >= 0 && getCurrent_x() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_x() + 1; i < x - 1; i++) {
						if (temp[y][i] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return hold;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("black")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + "Taken!");
							hold[0] = x;
							hold[1] = y;
							setCurrent_x(x);
							setCurrent_y(y);
							return hold;
						} else {
							System.out.println();
							System.out.println("FRIENDLY FIRE!");
							return hold;
						}

					} else {
						System.out.println();
						System.out.println("Invalid!");
						return hold;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return hold;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return hold;
			}
		} else {
			System.out.println();
			System.out.println("Not on board!");
			return hold;
		}
	}

	public int[] take_left(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_y() == y && getCurrent_x() != 0 && getCurrent_x() >= 0 && getCurrent_x() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_x() - 1; i < x + 1; i++) {
						if (temp[y][i] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return hold;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("black")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + "Taken!");
							hold[0] = x;
							hold[1] = y;
							setCurrent_x(x);
							setCurrent_y(y);
							return hold;
						} else {
							System.out.println();
							System.out.println("FRIENDLY FIRE!");
							return hold;
						}

					} else {
						System.out.println();
						System.out.println("Invalid!");
						return hold;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return hold;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return hold;
			}
		} else {
			System.out.println();
			System.out.println("Not on board!");
			return hold;
		}
	}

	public int[] take_up(int x, int y, piece[][] temp) {// sky
		if (isAlive() == true) {
			if (getCurrent_x() == x && getCurrent_y() >= 0 && getCurrent_y() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_y() - 1; i < y + 1; i++) {
						if (temp[i][x] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return hold;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("black")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + "Taken!");
							hold[0] = x;
							hold[1] = y;
							setCurrent_x(x);
							setCurrent_y(y);
							return hold;
						} else {
							System.out.println();
							System.out.println("FRIENDLY FIRE!");
							return hold;
						}

					} else {
						System.out.println();
						System.out.println("Invalid!");
						return hold;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return hold;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return hold;
			}
		} else {
			System.out.println();
			System.out.println("Not on board!");
			return hold;
		}
	}

	public int[] take_down(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_x() == x && getCurrent_y() >= 0 && getCurrent_y() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_y() + 1; i < y - 1; i++) {
						if (temp[i][x] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return hold;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("black")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + "Taken!");
							hold[0] = x;
							hold[1] = y;
							setCurrent_x(x);
							setCurrent_y(y);
							return hold;
						} else {
							System.out.println();
							System.out.println("FRIENDLY FIRE!");
							return hold;
						}

					} else {
						System.out.println();
						System.out.println("Invalid!");
						return hold;
					}
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return hold;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return hold;
			}
		} else {
			System.out.println();
			System.out.println("Not on board!");
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
