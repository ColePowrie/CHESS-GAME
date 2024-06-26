package main_pck;

import java.util.Scanner;

public class main_chess {

	public static void main(String[] args) {

		// SET UP FOR GAME:
		piece[][] temp = new piece[8][8]; // intializes the chess board
		board hold = new board(); // makes new board
		boolean white_turn = true;

		// white pieces(8 pawns, 2 rooks, 2 knights, 2 bishops, 1 king, 1 queen):
		white_pawn wp1 = new white_pawn("*wp1", "white", 0, 6, true);// name, colour, x, y
		white_pawn wp2 = new white_pawn("*wp2", "white", 1, 6, true);
		white_pawn wp3 = new white_pawn("*wp3", "white", 2, 6, true);
		white_pawn wp4 = new white_pawn("*wp4", "white", 3, 6, true);
		white_pawn wp5 = new white_pawn("*wp5", "white", 4, 6, true);
		white_pawn wp6 = new white_pawn("*wp6", "white", 5, 6, true);
		white_pawn wp7 = new white_pawn("*wp7", "white", 6, 6, true);
		white_pawn wp8 = new white_pawn("*wp8", "white", 7, 6, true);
		white_rook wr1 = new white_rook("*wr1", "white", 0, 7, true);
		white_rook wr2 = new white_rook("*wr2", "white", 7, 7, true);
		white_knight wk1 = new white_knight("*wk1", "white", 1, 7, true);
		white_knight wk2 = new white_knight("*wk2", "white", 6, 7, true);
		white_bishop wb1 = new white_bishop("*wb1", "white", 2, 7, true);
		white_bishop wb2 = new white_bishop("*wb2", "white", 5, 7, true);
		white_queen wqueen = new white_queen("*wq*", "white", 3, 7, true);
		white_king wking = new white_king("*wk*", "white", 4, 7, true);

		// black pieces(8 pawns, 2 rooks, 2 knights, 2 bishops, 1 king, 1 queen):
		black_pawn bp1 = new black_pawn("*bp1", "black", 0, 1, true);// name, colour, x, y
		black_pawn bp2 = new black_pawn("*bp2", "black", 1, 1, true);
		black_pawn bp3 = new black_pawn("*bp3", "black", 2, 1, true);
		black_pawn bp4 = new black_pawn("*bp4", "black", 3, 1, true);
		black_pawn bp5 = new black_pawn("*bp5", "black", 4, 1, true);
		black_pawn bp6 = new black_pawn("*bp6", "black", 5, 1, true);
		black_pawn bp7 = new black_pawn("*bp7", "black", 6, 1, true);
		black_pawn bp8 = new black_pawn("*bp8", "black", 7, 1, true);
		black_rook br1 = new black_rook("*br1", "black", 0, 0, true);
		black_rook br2 = new black_rook("*br2", "black", 7, 0, true);
		black_knight bk1 = new black_knight("*bk1", "black", 1, 0, true);
		black_knight bk2 = new black_knight("*bk2", "black", 6, 0, true);
		black_bishop bb1 = new black_bishop("*bb1", "black", 2, 0, true);
		black_bishop bb2 = new black_bishop("*bb2", "black", 5, 0, true);
		black_queen bqueen = new black_queen("*bq*", "black", 3, 0, true);
		black_king bking = new black_king("*bk*", "black", 4, 0, true);

		white_pawn[] w_pawn = { wp1, wp2, wp3, wp4, wp5, wp6, wp7, wp8 };
		white_rook[] w_rook = { wr1, wr2 };
		white_knight[] w_knight = { wk1, wk2 };
		white_bishop[] w_bishop = { wb1, wb2 };
		white_king[] w_king = { wking };
		white_queen[] w_queen = { wqueen };

		black_pawn[] b_pawn = { bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8 };
		black_rook[] b_rook = { br1, br2 };
		black_knight[] b_knight = { bk1, bk2 };
		black_bishop[] b_bishop = { bb1, bb2 };
		black_king[] b_king = { bking };
		black_queen[] b_queen = { bqueen };

		// EXTRA QUEENS:
		white_queen wqueen_pawn1 = new white_queen("wpq1", "white", w_pawn[0].getCurrent_x(), 0, true);
		white_queen wqueen_pawn2 = new white_queen("wpq2", "white", w_pawn[1].getCurrent_x(), 0, true);
		white_queen wqueen_pawn3 = new white_queen("wpq3", "white", w_pawn[2].getCurrent_x(), 0, true);
		white_queen wqueen_pawn4 = new white_queen("wpq4", "white", w_pawn[3].getCurrent_x(), 0, true);
		white_queen wqueen_pawn5 = new white_queen("wpq5", "white", w_pawn[4].getCurrent_x(), 0, true);
		white_queen wqueen_pawn6 = new white_queen("wpq6", "white", w_pawn[5].getCurrent_x(), 0, true);
		white_queen wqueen_pawn7 = new white_queen("wpq7", "white", w_pawn[6].getCurrent_x(), 0, true);
		white_queen wqueen_pawn8 = new white_queen("wpq8", "white", w_pawn[7].getCurrent_x(), 0, true);

		white_queen[] w_queen_pawn = { wqueen_pawn1, wqueen_pawn2, wqueen_pawn3, wqueen_pawn4, wqueen_pawn5,
				wqueen_pawn6, wqueen_pawn7, wqueen_pawn8 };

		// put on piece on the board
		temp[wp1.getCurrent_y()][wp1.getCurrent_x()] = wp1;
		temp[wp2.getCurrent_y()][wp2.getCurrent_x()] = wp2;
		temp[wp3.getCurrent_y()][wp3.getCurrent_x()] = wp3;
		temp[wp4.getCurrent_y()][wp4.getCurrent_x()] = wp4;
		temp[wp5.getCurrent_y()][wp5.getCurrent_x()] = wp5;
		temp[wp6.getCurrent_y()][wp6.getCurrent_x()] = wp6;
		temp[wp7.getCurrent_y()][wp7.getCurrent_x()] = wp7;
		temp[wp8.getCurrent_y()][wp8.getCurrent_x()] = wp8;

		temp[wr1.getCurrent_y()][wr1.getCurrent_x()] = wr1;
		temp[wr2.getCurrent_y()][wr2.getCurrent_x()] = wr2;

		temp[wk1.getCurrent_y()][wk1.getCurrent_x()] = wk1;
		temp[wk2.getCurrent_y()][wk2.getCurrent_x()] = wk2;

		temp[wb1.getCurrent_y()][wb1.getCurrent_x()] = wb1;
		temp[wb2.getCurrent_y()][wb2.getCurrent_x()] = wb2;

		temp[wqueen.getCurrent_y()][wqueen.getCurrent_x()] = wqueen;
		temp[wking.getCurrent_y()][wking.getCurrent_x()] = wking;

		temp[bp1.getCurrent_y()][bp1.getCurrent_x()] = bp1;
		temp[bp2.getCurrent_y()][bp2.getCurrent_x()] = bp2;
		temp[bp3.getCurrent_y()][bp3.getCurrent_x()] = bp3;
		temp[bp4.getCurrent_y()][bp4.getCurrent_x()] = bp4;
		temp[bp5.getCurrent_y()][bp5.getCurrent_x()] = bp5;
		temp[bp6.getCurrent_y()][bp6.getCurrent_x()] = bp6;
		temp[bp7.getCurrent_y()][bp7.getCurrent_x()] = bp7;
		temp[bp8.getCurrent_y()][bp8.getCurrent_x()] = bp8;

		temp[br1.getCurrent_y()][br1.getCurrent_x()] = br1;
		temp[br2.getCurrent_y()][br2.getCurrent_x()] = br2;

		temp[bk1.getCurrent_y()][bk1.getCurrent_x()] = bk1;
		temp[bk2.getCurrent_y()][bk2.getCurrent_x()] = bk2;

		temp[bb1.getCurrent_y()][bb1.getCurrent_x()] = bb1;
		temp[bb2.getCurrent_y()][bb2.getCurrent_x()] = bb2;

		temp[bqueen.getCurrent_y()][bqueen.getCurrent_x()] = bqueen;
		temp[bking.getCurrent_y()][bking.getCurrent_x()] = bking;

		// display
		String input = null;

		// while loop
		Scanner in = new Scanner(System.in);
		System.out.println("--------------------");
		System.out.println("WELCOME TO CHESS!");
		System.out.println("--------------------");

		while (input != "exit") {
//			try {
			if (w_king[0].isAlive() == true && b_king[0].isAlive() == true) {
				String turn = check_turn(white_turn);
				hold.showboard(temp);
				System.out.println("\n\nEnter Command(type 'help' for list):\n");
				input = in.next();
				if (input.equals("help")) {
					help();
				} else if (input.equals("move")) {
					String piece_name = null;
					int piece_num = 0;
					int cood_hold[] = null;
					// checks turn-------------------------------------------
					if (turn.equals("white")) {
						System.out.println("\nEnter piece name(white): ");
						piece_name = in.next();

						if (piece_name.equals("pawn")) {// if pawn is called
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (w_pawn[piece_num - 1].isAlive() == true) {
								// hold previous coordinates
								int prev_cordx = w_pawn[piece_num - 1].getCurrent_x();
								int prev_cordy = w_pawn[piece_num - 1].getCurrent_y();

								cood_hold = move_wpawn(piece_num, temp, w_pawn, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {// if returning
																								// element
																								// same
									temp[cood_hold[1]][cood_hold[0]] = w_pawn[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									// IF PAWN REACHES END CHANGE TO
									// QUEEN-----------------------------------------------------
									if (w_pawn[piece_num - 1].getCurrent_y() == 0) {
										// MAKE PAWN QUEEN:
										// get pawn coord
										int pawn_coordx = w_pawn[piece_num - 1].getCurrent_x();
										int pawn_coordy = w_pawn[piece_num - 1].getCurrent_y();
										// set pawn/queen with old pawn cord
										w_queen_pawn[piece_num - 1].setCurrent_x(pawn_coordx);
										w_queen_pawn[piece_num - 1].setCurrent_y(pawn_coordy);
										// add queen to board
										temp[pawn_coordy][pawn_coordx] = w_queen_pawn[piece_num - 1];
										System.out.println("\nPawn has turned into a queen!");
									}
									// call move method
									white_turn = false;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("rook")) {
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (b_rook[piece_num - 1].isAlive() == true) {
								// hold previous coordinates
								int prev_cordx = w_rook[piece_num - 1].getCurrent_x();
								int prev_cordy = w_rook[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_wrook(piece_num, temp, w_rook, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = w_rook[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = false;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("knight")) {
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (b_knight[piece_num - 1].isAlive() == true) {
								// hold previous coordinates
								int prev_cordx = w_knight[piece_num - 1].getCurrent_x();
								int prev_cordy = w_knight[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_wknight(piece_num, temp, w_knight, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = w_knight[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = false;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("bishop")) {
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (b_bishop[piece_num - 1].isAlive() == true) {

								// hold previous coordinates
								int prev_cordx = w_bishop[piece_num - 1].getCurrent_x();
								int prev_cordy = w_bishop[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_wbishop(piece_num, temp, w_bishop, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = w_bishop[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = false;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("queen")) {
							// read piece number
							piece_num = 1;
							if (b_queen[piece_num - 1].isAlive() == true) {

								// hold previous coordinates
								int prev_cordx = w_queen[piece_num - 1].getCurrent_x();
								int prev_cordy = w_queen[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_wqueen(piece_num, temp, w_queen, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = w_queen[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = false;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("king")) {
							// read piece number
							piece_num = 1;
							if (b_king[piece_num - 1].isAlive() == true) {
								// hold previous coordinates
								int prev_cordx = w_king[piece_num - 1].getCurrent_x();
								int prev_cordy = w_king[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_wking(piece_num, temp, w_king, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = w_king[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = false;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("pqueen")) {
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (w_queen_pawn[piece_num - 1].isAlive() == true) {

								// hold previous coordinates
								int prev_cordx = w_queen_pawn[piece_num - 1].getCurrent_x();
								int prev_cordy = w_queen_pawn[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_wqueen(piece_num, temp, w_queen_pawn, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = w_queen_pawn[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = false;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("castle")) {
							// read direction
							System.out.println("\nEnter direction:");
							String direc = in.next();
							temp = white_king.castle_white(direc, temp, w_rook, w_king);

						} else {
							System.out.println("\nInvalid!");
						}
					} else {// BLACK PIECE MAIN MOVEMENT-----------------------------
						System.out.println("\nEnter piece name(black): ");
						piece_name = in.next();
						if (piece_name.equals("pawn")) {// if pawn is called
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (b_pawn[piece_num - 1].isAlive() == true) {
								// hold previous coordinates
								int prev_cordx = b_pawn[piece_num - 1].getCurrent_x();
								int prev_cordy = b_pawn[piece_num - 1].getCurrent_y();
								// call move method
								cood_hold = move_bpawn(piece_num, temp, b_pawn, in);

								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {// if returning
																								// element
																								// same
									temp[cood_hold[1]][cood_hold[0]] = b_pawn[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = true;
								}
							} else {
								System.out.println("\nPiece not on board!");
							}
						} else if (piece_name.equals("rook")) {
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (b_rook[piece_num - 1].isAlive() == true) {
								// hold previous coordinates
								int prev_cordx = b_rook[piece_num - 1].getCurrent_x();
								int prev_cordy = b_rook[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_brook(piece_num, temp, b_rook, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {// if returning
																								// element
																								// same
									temp[cood_hold[1]][cood_hold[0]] = b_rook[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = true;
								}
							} else {
								System.out.println("\nPiece is not on board");
							}
						} else if (piece_name.equals("knight")) {
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (b_knight[piece_num - 1].isAlive() == true) {
								// hold previous coordinates
								int prev_cordx = b_knight[piece_num - 1].getCurrent_x();
								int prev_cordy = b_knight[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_bknight(piece_num, temp, b_knight, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = b_knight[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = true;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("bishop")) {
							// read piece number
							System.out.println("\nEnter piece number: ");
							piece_num = in.nextInt();
							if (b_bishop[piece_num - 1].isAlive() == true) {

								// hold previous coordinates
								int prev_cordx = b_bishop[piece_num - 1].getCurrent_x();
								int prev_cordy = b_bishop[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_bbishop(piece_num, temp, b_bishop, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = b_bishop[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = true;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("queen")) {
							// read piece number
							piece_num = 1;
							if (b_queen[piece_num - 1].isAlive() == true) {

								// hold previous coordinates
								int prev_cordx = b_queen[piece_num - 1].getCurrent_x();
								int prev_cordy = b_queen[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_bqueen(piece_num, temp, b_queen, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = b_queen[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = true;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("king")) {
							// read piece number
							piece_num = 1;
							if (b_king[piece_num - 1].isAlive() == true) {

								// hold previous coordinates
								int prev_cordx = b_king[piece_num - 1].getCurrent_x();
								int prev_cordy = b_king[piece_num - 1].getCurrent_y();
								// call method
								cood_hold = move_bking(piece_num, temp, b_king, in);
								if (cood_hold[0] != prev_cordx || cood_hold[1] != prev_cordy) {
									temp[cood_hold[1]][cood_hold[0]] = b_king[piece_num - 1];
									temp[prev_cordy][prev_cordx] = null;
									white_turn = true;
								}
							} else {
								System.out.println("\nPiece is not on board!");
							}
						} else if (piece_name.equals("castle")) {
							// read direction
							System.out.println("\nEnter direction:");
							String direc = in.next();

							temp = black_king.castle_black(direc, temp, b_rook, b_king);

						}
					}
					// end of this
				} else if (input.equals("exit")) {
					System.out.println("\n--------------------");
					System.out.println("THANKS FOR PLAYING!");
					System.out.println("EXITING!");
					System.out.println("--------------------");
					break;
				} else if (input.equals("forfeit")) {
					if (white_turn == true) {
						System.out.println("\n--------------------");
						System.out.println("WHITE HAS FORFEITED!");
						System.out.println("BLACK WINS!");
						System.out.println("THANKS FOR PLAYING!");
						System.out.println("--------------------");
						break;
					} else {
						System.out.println("\n--------------------");
						System.out.println("BLACK HAS FORFEITED!");
						System.out.println("WHITE WINS!");
						System.out.println("THANKS FOR PLAYING!");
						System.out.println("--------------------");
						break;
					}
				} else {
					System.out.println("\nInvalid!");
				}
				// CALL FOR THE ENDING GAME METHOD
			} else {
				end_game(w_king, b_king);
				break;
			}
//			} catch (Exception e) {
//				System.out.println("\nInvalid!");
//				System.out.println(e);
//			}
		}
		in.close();

	}

	private static int[] move_bpawn(int piece_num, piece[][] temp, black_pawn[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_brook(int piece_num, piece[][] temp, black_rook[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println();
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_bknight(int piece_num, piece[][] temp, black_knight[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_bbishop(int piece_num, piece[][] temp, black_bishop[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_bqueen(int piece_num, piece[][] temp, black_queen[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_bking(int piece_num, piece[][] temp, black_king[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				System.out.println("\nHERE FOR SOME REASON");
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_wking(int piece_num, piece[][] temp, white_king[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_wqueen(int piece_num, piece[][] temp, white_queen[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_wbishop(int piece_num, piece[][] temp, white_bishop[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static int[] move_wknight(int piece_num, piece[][] temp, white_knight[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	public static int[] move_wpawn(int piece_num, piece[][] temp, white_pawn[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };

		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	public static int[] move_wrook(int piece_num, piece[][] temp, white_rook[] piece_list, Scanner in) {
		int x = 0;
		int y = 0;
		int[] cord = { 0, 0 };
		try {
			System.out.println("\nEnter x:");
			x = in.nextInt();
			System.out.println("\nEnter y:");
			y = in.nextInt();
			cord = piece_list[piece_num - 1].gen(x, y, temp);
			if (cord[0] == x && cord[1] == y && temp[y][x] != null) {
				temp[y][x].setAlive(false);
			}
			return cord;
		} catch (Exception e) {
			System.out.println("\nInvalid!");
			System.out.println(e);
			cord[0] = piece_list[piece_num - 1].getCurrent_x();
			cord[1] = piece_list[piece_num - 1].getCurrent_y();
			return cord;
		}
	}

	private static String check_turn(boolean white_turn) {
		if (white_turn == true) {
			return "white";
		} else {
			return "black";// change back to black when done with black pieces
		}
	}

	public static void end_game(white_king[] w_king, black_king[] b_king) {
		if (w_king[0].isAlive() == false && b_king[0].isAlive() == true) {
			System.out.println("\n--------------------");
			System.out.println("\nGAME OVER!");
			System.out.println("\nBLACK PIECES WIN!");
			System.out.println("\n--------------------");
		} else if (w_king[0].isAlive() == true && b_king[0].isAlive() == false) {
			System.out.println("\n--------------------");
			System.out.println("\nGAME OVER!");
			System.out.println("\nWHITE PIECES WIN!");
			System.out.println("\n--------------------");
		} else {
			System.out.println("\nError somehow?");
		}
	}

	public static void help() {
		System.out.println("\n------------------------------------------------");
		System.out.println("move - allows you to move piece");
		System.out
				.println("     - EX: rook, knight, bishop, queen, king,\n     pawn, pqueen(for pawn changed to queen)");
		System.out.println("\nCastle - castles on whoevers turn");
		System.out.println("\nexit - leave game(duh)");
		System.out.println("\nforfeit - whoever declares on there turn loses");
		System.out.println("------------------------------------------------\n");
	}

}
