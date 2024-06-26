package main_pck;

public class black_queen extends piece {

	// attributes
	private boolean alive;
	private int[] ret = { getCurrent_x(), getCurrent_y() };

	// constructors
	black_queen(String name, String colour, int current_y, int current_x, boolean alive) {
		super(name, colour, current_x, current_y);
		this.alive = alive;
	}

	// METHODS:
	public int[] gen(int x, int y, piece[][] temp) {
		try {
			if (temp[y][x] != null) {
				return take(x, y, temp);
			} else {
				return move(x, y, temp);
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Invalid!");
			return ret;
		}
	}

	// movement methods
	public int[] move(int x, int y, piece[][] temp) {
		if (x == getCurrent_x() && y != getCurrent_y()) {// only moves on y
			ret[1] = move_horvert(x, y, temp);
			return ret;
		} else if (x != getCurrent_x() && y != getCurrent_y()) {// moves both x and y
			return move_diag(x, y, temp);
		} else if (x != getCurrent_x() && y == getCurrent_y()) {// only moves x
			ret[0] = move_horvert(x, y, temp);
			return ret;
		}
		return ret;
	}

	public int move_horvert(int x, int y, piece[][] temp) {
		if (getCurrent_x() > x) {
			return move_holeft(x, y, temp);
		} else if (getCurrent_x() < x) {
			return move_horight(x, y, temp);
		} else if (getCurrent_y() > y) {
			return move_vertup(x, y, temp);
		} else if (getCurrent_y() < y) {
			return move_vertdown(x, y, temp);
		} else {
			System.out.println();
			System.out.println("Invalid!");
			return 0;
		}
	}

	public int move_vertup(int x, int y, piece[][] temp) {// moves towards sky
		int counter = 0;
		if (isAlive() == true) {
			for (int i = getCurrent_y() - 1; i > -1; i--) {
				if (temp[i][getCurrent_x()] != null) {
					System.out.println();
					System.out.println("Invalid Move!");
					return getCurrent_y();
				} else {
					counter++;
				}
			} // for loop
				// THIS IF STATEMENT IS NOT WOKRING
			if (counter == (temp.length - 2 - getCurrent_y())) {
				System.out.println();
				System.out.println("Moved!");
				return y;
			}
		} else {// is alive
			System.out.println();
			System.out.println("Piece is not on board!");
		}
		return getCurrent_y();// if something goes wrong return og
	}// method vert up

	public int move_vertdown(int x, int y, piece[][] temp) {// moves toward ground
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

//methods for diag movements://////////////////////////////////////////////////////
	public int[] move_diag(int x, int y, piece[][] temp) {
		if (x > getCurrent_x() && y < getCurrent_y()) {
			return move_upright(x, y, temp);
		} else if (x > getCurrent_x() && y > getCurrent_y()) {
			return move_botright(x, y, temp);
		} else if (x < getCurrent_x() && y > getCurrent_y()) {
			return move_botleft(x, y, temp);
		} else if (x < getCurrent_x() && y < getCurrent_y()) {
			return move_upleft(x, y, temp);
		} else {
			System.out.println();
			System.out.println("Invalid!");
			return ret;
		}
	}

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

	// taking methods
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
		} else if (x == getCurrent_x() && y > getCurrent_y()) {// ground
			return take_up(x, y, temp);
		} else if (x == getCurrent_x() && y < getCurrent_y()) {// sky
			return take_down(x, y, temp);
		} else {
			System.out.println("\nInvalida!");
			return ret;
		}
	}

	// TAKING DIAG
	public int[] take_topright(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (x - 1 == getCurrent_x() && y + 1 == getCurrent_y()) {// just moves one
				if (temp[y][x] != null) {
					if (temp[y][x].getColour().equals("white")) {
						System.out.println();
						System.out.println(temp[y][x].getName() + " Taken!");
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
				System.out.println(temp[y][x].getName() + "Taken!");
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
					if (temp[y][x].getColour().equals("white")) {
						System.out.println();
						System.out.println(temp[y][x].getName() + " Taken!");
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
				System.out.println(temp[y][x].getName() + " Taken!");
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
					if (temp[y][x].getColour().equals("white")) {
						System.out.println();
						System.out.println(temp[y][x].getName() + " Taken!");
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
				System.out.println(temp[y][x].getName() + "Taken!");
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
					if (temp[y][x].getColour().equals("white")) {
						System.out.println();
						System.out.println(temp[y][x].getName() + " Taken!");
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
				System.out.println(temp[y][x].getName() + "Taken!");
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

	// TAKING HORIZONTAL
	public int[] take_right(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_y() == y && getCurrent_x() >= 0 && getCurrent_x() >= 0 && getCurrent_x() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_x() + 1; i < x - 1; i++) {
						if (temp[y][i] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return ret;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("white")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + " Taken!");
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
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {
			System.out.println();
			System.out.println("Not on board!");
			return ret;
		}
	}

	public int[] take_left(int x, int y, piece[][] temp) {
		if (isAlive() == true) {
			if (getCurrent_y() == y && getCurrent_x() >= 0 && getCurrent_x() >= 0 && getCurrent_x() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_x() - 1; i < x + 1; i++) {
						if (temp[y][i] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return ret;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("white")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + " Taken!");
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
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {
			System.out.println();
			System.out.println("Not on board!");
			return ret;
		}
	}

	public int[] take_up(int x, int y, piece[][] temp) {// sky
		if (isAlive() == true) {
			if (getCurrent_x() == x && getCurrent_y() >= 0 && getCurrent_y() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_y() + 1; i < y - 1; i++) {
						if (temp[i][x] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return ret;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("white")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + " Taken!");
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
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {
			System.out.println();
			System.out.println("Not on board!");
			return ret;
		}
	}

	public int[] take_down(int x, int y, piece[][] temp) {// ground
		if (isAlive() == true) {
			if (getCurrent_x() == x && getCurrent_y() >= 0 && getCurrent_y() <= 7) {
				if (temp[y][x] != null) {
					for (int i = getCurrent_y() - 1; i < y + 1; i++) {
						if (temp[i][x] != null) {
							System.out.println();
							System.out.println("Invalid!");
							return ret;
						}
					} // for loop
					if (temp[y][x] != null) {
						if (temp[y][x].getColour().equals("white")) {
							System.out.println();
							System.out.println(temp[y][x].getName() + " Taken!");
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
				} else {
					System.out.println();
					System.out.println("Invalid!");
					return ret;
				}
			} else {
				System.out.println();
				System.out.println("Invalid!");
				return ret;
			}
		} else {
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

	public int[] getRet() {
		return ret;
	}

	public void setRet(int[] ret) {
		this.ret = ret;
	}
}
