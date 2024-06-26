package main_pck;

public class piece {

//attributes
	private String name;
	private String colour;
	private int current_x;
	private int current_y;
	private boolean alive;

//constructors
	piece(String name, String colour, int current_y, int current_x) {
		this.colour = colour;
		this.name = name;
		this.current_x = current_x;
		this.current_y = current_y;
	}

//methods
	public static piece[][] castle_white(String direc, piece[][] temp, white_rook[] wr_list, white_king[] wk_list) {
		wr_list[0].setAlive(true);
		wr_list[1].setAlive(true);
		wk_list[0].setAlive(true);
		if (direc.equals("right")) {// movement right
			if (wr_list[1].isMoved() != true && wk_list[0].isMoved() != true && wr_list[1].isAlive() == true
					&& wk_list[0].isAlive() == true) {

				for (int i = wr_list[1].getCurrent_x() - 1; i > wk_list[0].getCurrent_x(); i--) {
					System.out.println(i);
					if (temp[7][i] != null) {
						System.out.println("\nInvalid!");
						return temp;
					}
				} // end of for loop
				System.out.println("\nCastled!");
				// save position
				int kingx = wk_list[0].getCurrent_x();
				int kingy = wk_list[0].getCurrent_y();
				int rookx = wr_list[1].getCurrent_x();
				int rooky = wr_list[1].getCurrent_y();

				// save piece
				white_king kinghold = (white_king) temp[kingy][kingx];
				white_rook rookhold = (white_rook) temp[rooky][rookx];

				// make previous position null
				temp[kingy][kingx] = null;
				temp[rooky][rookx] = null;

				// make moved true
				kinghold.setMoved(true);
				rookhold.setMoved(true);

				// move position
				temp[7][6] = kinghold;
				temp[7][5] = rookhold;

				// change nmew current positions
				kinghold.setCurrent_x(6);
				kinghold.setCurrent_y(7);

				rookhold.setCurrent_x(5);
				rookhold.setCurrent_y(7);

//				return new board
				return temp;

			} else {
				System.out.println("\nInvalid! Piece has moved/not on board!");
				return temp;
			}
		} else if (direc.equals("left")) {// movement left
			if (wr_list[0].isMoved() != true && wk_list[0].isMoved() != true && wr_list[0].isAlive() == true
					&& wk_list[0].isAlive() == true) {

				for (int i = wr_list[0].getCurrent_x() + 1; i < wk_list[0].getCurrent_x(); i++) {
					if (temp[7][i] != null) {
						System.out.println("\nInvalid!");
						return temp;
					}
				} // end of for loop
				System.out.println("\nCastled!");
				// save position
				int kingx = wk_list[0].getCurrent_x();
				int kingy = wk_list[0].getCurrent_y();
				int rookx = wr_list[0].getCurrent_x();
				int rooky = wr_list[0].getCurrent_y();

				// save piece
				white_king kinghold = (white_king) temp[kingy][kingx];
				white_rook rookhold = (white_rook) temp[rooky][rookx];

				// make previous position null
				temp[kingy][kingx] = null;
				temp[rooky][rookx] = null;

				// make moved true
				kinghold.setMoved(true);
				rookhold.setMoved(true);

				// move position
				temp[7][2] = kinghold;
				temp[7][3] = rookhold;

				// change new current positions
				kinghold.setCurrent_x(2);
				kinghold.setCurrent_y(7);

				rookhold.setCurrent_x(3);
				rookhold.setCurrent_y(7);
//				return new board
				return temp;

			} else {
				System.out.println("\nInvalid! Piece has moved/not on board!");
				return temp;
			}
		} else {
			System.out.println("\nInvalid!");
			return temp;
		}
	}

	public static piece[][] castle_black(String direc, piece[][] temp, black_rook[] br_list, black_king[] bk_list) {
		br_list[0].setAlive(true);
		br_list[1].setAlive(true);
		bk_list[0].setAlive(true);
		if (direc.equals("left")) {// movement left increase in x
			if (br_list[1].isMoved() != true && bk_list[0].isMoved() != true && br_list[1].isAlive() == true
					&& bk_list[0].isAlive() == true) {
				for (int i = br_list[1].getCurrent_x() - 1; i > bk_list[0].getCurrent_x(); i--) {
					if (temp[0][i] != null) {
						System.out.println("\nInvalid!");
						return temp;
					}
				} // end of for loop
				System.out.println("\nCastled!");
				// save position
				int kingx = bk_list[0].getCurrent_x();
				int kingy = bk_list[0].getCurrent_y();
				int rookx = br_list[1].getCurrent_x();
				int rooky = br_list[1].getCurrent_y();

				// save piece
				black_king kinghold = (black_king) temp[kingy][kingx];
				black_rook rookhold = (black_rook) temp[rooky][rookx];

				// make previous position null
				temp[kingy][kingx] = null;
				temp[rooky][rookx] = null;

				// make moved true
				kinghold.setMoved(true);
				rookhold.setMoved(true);

				// move position
				temp[0][6] = kinghold;
				temp[0][5] = rookhold;

				// change nmew current positions
				kinghold.setCurrent_x(2);
				kinghold.setCurrent_y(0);

				rookhold.setCurrent_x(3);
				rookhold.setCurrent_y(0);

//				return new board
				return temp;

			} else {
				System.out.println("\nInvalid! Piece has moved/not on board!");
				return temp;
			}
		} else if (direc.equals("right")) {// movement right decrease in x
			if (br_list[0].isMoved() != true && bk_list[0].isMoved() != true && br_list[0].isAlive() == true
					&& bk_list[0].isAlive() == true) {
				for (int i = br_list[0].getCurrent_x() + 1; i < bk_list[0].getCurrent_x(); i++) {
					if (temp[0][i] != null) {
						System.out.println("\nInvalid!");
						return temp;
					}
				} // end of for loop
				System.out.println("\nCastled!");
				// save position
				int kingx = bk_list[0].getCurrent_x();
				int kingy = bk_list[0].getCurrent_y();
				int rookx = br_list[0].getCurrent_x();
				int rooky = br_list[0].getCurrent_y();

				// save piece
				black_king kinghold = (black_king) temp[kingy][kingx];
				black_rook rookhold = (black_rook) temp[rooky][rookx];

				// make previous position null
				temp[kingy][kingx] = null;
				temp[rooky][rookx] = null;

				// make moved true
				kinghold.setMoved(true);
				rookhold.setMoved(true);

				// move position
				temp[0][6] = kinghold;
				temp[0][5] = rookhold;

				// change new current positions
				kinghold.setCurrent_x(6);
				kinghold.setCurrent_y(0);

				rookhold.setCurrent_x(5);
				rookhold.setCurrent_y(0);
//				return new board
				return temp;

			} else {
				System.out.println("\nInvalid! Piece has moved/not on board!");
				return temp;
			}
		} else {
			System.out.println("\nInvalid!");
			return temp;
		}
	}

//setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrent_x() {
		return current_x;
	}

	public void setCurrent_x(int current_x) {
		this.current_x = current_x;
	}

	public int getCurrent_y() {
		return current_y;
	}

	public void setCurrent_y(int current_y) {
		this.current_y = current_y;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
