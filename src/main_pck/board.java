package main_pck;

public class board {
// needs to take 32 pieces and have there oreintations

//ATTRIBUTES:
	private piece[][] dim;

//CONSTRUCTORS:
	board(piece[][] dim) {
		this.dim = new piece[8][8];
	}

	board() {
		this.dim = new piece[8][8];
	}

//SET&GET:
	public piece[][] getDim() {
		return dim;
	}

	public void setDim(piece[][] dim) {
		this.dim = dim;
	}

//METHODS:
	public void showboard(piece[][] dim) {
		System.out.println();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (dim[y][x] != null) {
					System.out.print(dim[y][x].getName() + " ");
				} else {
					System.out.print("----" + " ");
				}
			}
			System.out.println(" y" + (y));
		}

		for (int i = 0; i < 8; i++) {
			System.out.print(" x" + (i) + "  ");
		}
	}

}
