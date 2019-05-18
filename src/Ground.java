import java.util.ArrayList;

/**
 * This is a class for the board of the game
 *
 * @author Amir Mojtaba Kiasat
 * @version 1.0
 * @since 5-1-2019
 */

public class Ground {

    private Man[][] ground;
    private ArrayList<String> knockedChessMan;

    public Man[][] getGround() {
        return ground;
    }

    public Ground() {
        knockedChessMan = new ArrayList<>();
        ground = new Man[8][8];
        ground[0][7] = new Rook(0, 7, "WR1");
        ground[1][7] = new Knight(1, 7, "WN1");
        ground[2][7] = new Bishop(2, 7, "WB1");
        ground[3][7] = new Queen(3, 7, "WQ ");
        ground[4][7] = new King(4, 7, "WK ");
        ground[5][7] = new Bishop(5, 7, "WB2");
        ground[6][7] = new Knight(6, 7, "WN2");
        ground[7][7] = new Rook(7, 7, "WR2");
        ground[0][6] = new Pawn(0, 6, "WP1");
        ground[1][6] = new Pawn(1, 6, "WP2");
        ground[2][6] = new Pawn(2, 6, "WP3");
        ground[3][6] = new Pawn(3, 6, "WP4");
        ground[4][6] = new Pawn(4, 6, "WP5");
        ground[5][6] = new Pawn(5, 6, "WP6");
        ground[6][6] = new Pawn(6, 6, "WP7");
        ground[7][6] = new Pawn(7, 6, "WP8");
        for (int i = 2; i < 6; i++)
            for (int j = 0; j < 8; j++)
                ground[j][i] = new Empty(j, i, "   ");
        ground[0][0] = new Rook(0, 0, "BR1");
        ground[1][0] = new Knight(1, 0, "BN1");
        ground[2][0] = new Bishop(2, 0, "BB1");
        ground[3][0] = new Queen(3, 0, "BQ ");
        ground[4][0] = new King(4, 0, "BK ");
        ground[5][0] = new Bishop(5, 0, "BB2");
        ground[6][0] = new Knight(6, 0, "BN2");
        ground[7][0] = new Rook(7, 0, "BR2");
        ground[0][1] = new Pawn(0, 1, "BP1");
        ground[1][1] = new Pawn(1, 1, "BP2");
        ground[2][1] = new Pawn(2, 1, "BP3");
        ground[3][1] = new Pawn(3, 1, "BP4");
        ground[4][1] = new Pawn(4, 1, "BP5");
        ground[5][1] = new Pawn(5, 1, "BP6");
        ground[6][1] = new Pawn(6, 1, "BP7");
        ground[7][1] = new Pawn(7, 1, "BP8");

    }

    /**
     * Prints the ground
     */

    public void printGround() {
        System.out.println("      A   B   C   D   E   F   G   H\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + "   ");
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++)
                    for (int g = 0; g < 8; g++) {
                        if (ground[g][k].getX() == j && ground[g][k].getY() == i) {
                            System.out.print("|" + ground[g][k].getName());
                        }
                    }

            }
            System.out.println("|   " + (8 - i));

        }
        System.out.println("\n      A   B   C   D   E   F   G   H");
    }

    /**
     * checks that the x1,y1 position is empty or not
     *
     * @param x1 the x of the position
     * @param y1 the y of the position
     * @return if it's empty return true otherwise return false
     */

    public boolean checkEmpty(int x1, int y1) {
        for (int k = 0; k < 8; k++)
            for (int z = 0; z < 8; z++)
                if (ground[k][z].getX() == x1 && ground[k][z].getY() == y1 && ground[k][z].getName().equals("   "))
                    return true;
        return false;
    }

    /**
     * checks that if the white king was in x,y position, it's checked or not
     *
     * @param x the x of the position
     * @param y the y of the position
     * @return
     */
    public boolean whiteKingCheck(int x, int y) {
        ArrayList<Boolean> check = new ArrayList<Boolean>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (ground[i][j].getName().toCharArray()[0] == 'B') {
                    if (ground[i][j].check(x, y, ground))
                        return true;
                }
            }
        return false;
    }

    /**
     * checks that if the black king was in x,y position, it's checked or not
     * @param x the x of the position
     * @param y the y of the position
     * @return
     */
    public boolean blackKingCheck(int x, int y) {
        ArrayList<Boolean> check = new ArrayList<Boolean>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (ground[i][j].getName().toCharArray()[0] == 'W') {
                    if (ground[i][j].check(x, y, ground))
                        return true;
                }
            }
        return false;
    }

    /**
     * adds the name of the knocked man to the list
     * @param knockedMan the name of the knocked man
     */
    public void addKnockedChessMan(String knockedMan) {
        knockedChessMan.add(knockedMan);
    }

    public ArrayList<String> getKnockedChessMan() {
        return knockedChessMan;
    }
}