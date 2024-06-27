package main_pck;

public class white_king extends piece {

	// attributes
	private boolean alive;
	private boolean moved;
	private int[] hold = { getCurrent_x(), getCurrent_y() };

	// constructors
	white_king(String name, String colour, int current_y, int current_x, boolean alive) {
		super(name, colour, current_x, current_y);
		this.alive = alive;
	}

	// methods:
	public int[] gen(int x, int y, piece[][] temp) {
		try {
			if (temp[y][x] != null) {
				return take(x, y, temp);
			} else {
				return move(x, y, temp);
			}
		} catch (Exception e) {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] move(int x, int y, piece[][] temp) {
		if (getCurrent_x() > x && y == getCurrent_y()) {
			hold[0] = move_holeft(x, y, temp);
			return hold;
		} else if (getCurrent_x() < x && y == getCurrent_y()) {
			hold[0] = move_horight(x, y, temp);
			return hold;
		} else if (getCurrent_x() == x && y > getCurrent_y()) {
			hold[1] = move_vertup(x, y, temp);
			return hold;
		} else if (getCurrent_x() == x && y < getCurrent_y()) {
			hold[1] = move_vertdown(x, y, temp);
			return hold;
		} else if (getCurrent_x() < x && getCurrent_y() < y) { // diag part
			return down_right(x, y, temp);
		} else if (getCurrent_x() > x && getCurrent_y() < y) {
			return down_left(x, y, temp);
		} else if (getCurrent_x() < x && getCurrent_y() > y) {
			return up_right(x, y, temp);
		} else if (getCurrent_x() > x && getCurrent_y() > y) {
			return up_left(x, y, temp);
		} else {

			System.out.println("\nInvalid!(no move)");
		}
		return hold;
	}

	// vert and horiz movement:----------------
	public int move_vertup(int x, int y, piece[][] temp) {// moves towards sky(y)
		if (isAlive() == true) {
			if (y == getCurrent_y() + 1) {
				if (temp[y][getCurrent_x()] == temp[y][x]) {
					if (temp[y][x] == null) {

						System.out.println("\nMoved!");
						setMoved(true);
						setCurrent_x(x);
						setCurrent_y(y);
						return y;
					} else {

						System.out.println("\nInvalid!");
						return getCurrent_y();
					}
				} else {

					System.out.println("\nInvalid!");
					return getCurrent_y();
				}
			} else {

				System.out.println("\nInvalid!");
				return getCurrent_y();
			}
		} else {

			System.out.println("\nPiece is not on the board!");
			return getCurrent_y();
		}
	}

	public int move_vertdown(int x, int y, piece[][] temp) {// moves toward ground
		if (isAlive() == true) {
			if (y == getCurrent_y() - 1) {
				if (temp[y][getCurrent_x()] == temp[y][x]) {
					if (temp[y][x] == null) {

						System.out.println("\nMoved!");
						setMoved(true);
						setCurrent_x(x);
						setCurrent_y(y);
						return y;
					} else {

						System.out.println("\nInvalid!");
						return getCurrent_y();
					}
				} else {

					System.out.println("\nInvalid!");
					return getCurrent_y();
				}
			} else {

				System.out.println("\nInvalid!");
				return getCurrent_y();
			}
		} else {// is alive

			System.out.println("\nPiece is not on the board!");
			return getCurrent_y();
		}
	}

	public int move_horight(int x, int y, piece[][] temp) {// moves to the right
		if (isAlive() == true) {
			if (x == getCurrent_x() + 1) {
				if (temp[getCurrent_y()][x] == temp[y][x]) {
					if (temp[y][x] == null) {

						System.out.println("\nMoved!");
						setMoved(true);
						setCurrent_x(x);
						setCurrent_y(y);
						return x;
					} else {

						System.out.println("\nInvalid!");
						return getCurrent_x();
					}
				} else {

					System.out.println("\nInvalid!");
					return getCurrent_x();
				}
			} else {

				System.out.println("\nInvalid!");
				return getCurrent_x();
			}
		} else {// is alive

			System.out.println("\nPiece is not on board!");
			return getCurrent_y();
		}
	}

	public int move_holeft(int x, int y, piece[][] temp) {// moves to the left
		if (isAlive() == true) {
			if (x == getCurrent_x() - 1) {
				if (temp[getCurrent_y()][x] == temp[y][x]) {
					if (temp[y][x] == null) {

						System.out.println("\nMoved!");
						setMoved(true);
						setCurrent_x(x);
						setCurrent_y(y);
						return x;
					} else {

						System.out.println("\nInvalid!");
						return getCurrent_x();
					}
				} else {

					System.out.println("\nInvalid!");
					return getCurrent_x();
				}
			} else {

				System.out.println("\nInvalid!");
				return getCurrent_x();
			}
		} else {

			System.out.println("\nPiece is not on board!");
			return getCurrent_y();
		}
	}

	// diag movement://///////////////////////
	public int[] up_right(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x == getCurrent_x() + 1 && y == getCurrent_y() - 1) {
				if (temp[y][x] == null) {

					System.out.println("\nMoved!");
					setMoved(true);
					hold[0] = x;
					hold[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return hold;
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] up_left(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x == getCurrent_x() - 1 && y == getCurrent_y() - 1) {
				if (temp[y][x] == null) {

					System.out.println("\nMoved!");
					setMoved(true);
					hold[0] = x;
					hold[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return hold;
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] down_right(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x == getCurrent_x() + 1 && y == getCurrent_y() + 1) {
				if (temp[y][x] == null) {

					System.out.println("\nMoved!");
					setMoved(true);
					hold[0] = x;
					hold[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return hold;
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] down_left(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x == getCurrent_x() - 1 && y == getCurrent_y() + 1) {
				if (temp[y][x] == null) {
					System.out.println("\nMoved!");
					setMoved(true);
					hold[0] = x;
					hold[1] = y;
					setCurrent_x(x);
					setCurrent_y(y);
					return hold;
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public void castle(int x, int y, piece[][] temp) {

	}

	// TAKING METHODS
	public int[] take(int x, int y, piece[][] temp) {
		if (x > getCurrent_x() && y < getCurrent_y()) {// top right
			return take_topright(x, y, temp);
		} else if (x < getCurrent_x() && y < getCurrent_y()) {// top left
			return take_topleft(x, y, temp);
		} else if (x > getCurrent_x() && y > getCurrent_y()) {// bot right
			return take_botright(x, y, temp);
		} else if (x < getCurrent_x() && y > getCurrent_y()) {// bot left
			return take_botleft(x, y, temp);
		} else if (x > getCurrent_x() && y == getCurrent_y()) {// right
			return take_right(x, y, temp);
		} else if (x < getCurrent_x() && y == getCurrent_y()) {// left
			return take_left(x, y, temp);
		} else if (x == getCurrent_x() && y > getCurrent_y()) {// sky
			return take_up(x, y, temp);
		} else if (x == getCurrent_x() && y < getCurrent_y()) {// ground
			return take_down(x, y, temp);
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	// diag
	public int[] take_topright(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x - 1 == getCurrent_x() && y + 1 == getCurrent_y()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {
						System.out.println("\n" + temp[y][x].getName() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nNot on board!");
			return hold;
		}
	}

	public int[] take_topleft(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x + 1 == getCurrent_x() && y + 1 == getCurrent_y()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {
						System.out.println("\n" + temp[y][x].getName() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nNot on board!");
			return hold;
		}
	}

	public int[] take_botright(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x - 1 == getCurrent_x() && y - 1 == getCurrent_y()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {
						System.out.println("\n" + temp[y][x].getName() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nNot on board!");
			return hold;
		}
	}

	public int[] take_botleft(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x + 1 == getCurrent_x() && y - 1 == getCurrent_y()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {
						System.out.println("\n" + temp[y][x].getName() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nNot on board!");
			return hold;
		}
	}

	// hori
	public int[] take_right(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_y() == y && x - 1 == getCurrent_x()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {

						System.out.println("\n" + temp[y][x].getColour() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] take_left(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_y() == y && x + 1 == getCurrent_x()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {

						System.out.println("\n" + temp[y][x].getColour() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] take_up(int x, int y, piece[][] temp) {// sky
		if (isAlive() == true) {
			if (getCurrent_x() == x && y + 1 == getCurrent_y()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {

						System.out.println("\n" + temp[y][x].getColour() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	public int[] take_down(int x, int y, piece[][] temp) {// ground
		if (isAlive() == true) {
			if (getCurrent_x() == x && y - 1 == getCurrent_y()) {
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("\nblack")) {
						System.out.println("\n" + temp[y][x].getColour() + " Taken!");
						hold[0] = x;
						hold[1] = y;
						setCurrent_x(x);
						setCurrent_y(y);
						return hold;
					} else {

						System.out.println("\nFRIENDLY FIRE!");
						return hold;
					}
				} else {

					System.out.println("\nInvalid!");
					return hold;
				}
			} else {

				System.out.println("\nInvalid!");
				return hold;
			}
		} else {

			System.out.println("\nInvalid!");
			return hold;
		}
	}

	// SETTERS AND GETTERS
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

	public int[] getHold() {
		return hold;
	}

	public void setHold(int[] hold) {
		this.hold = hold;
	}

}
