import java.util.ArrayList;

public class Ground {

    private Man[][] ground;

    public Man[][] getGround() {
        return ground;
    }

    public Ground() {
        ground = new Man[8][8];
        ground[0][7] = new Rook(7, 0, "WR1");
        ground[1][7] = new Knight(7, 1, "WN1");
        ground[2][7] = new Bishop(7, 2, "WB1");
        ground[3][7] = new Queen(7, 3, "WQ ");
        ground[4][7] = new King(7, 4, "WK ");
        ground[5][7] = new Bishop(7, 5, "WB2");
        ground[6][7] = new Knight(7, 6, "WN2");
        ground[7][7] = new Rook(7, 7, "WR2");
        ground[0][6] = new Pawn(6, 0, "WP1");
        ground[1][6] = new Pawn(6, 1, "WP2");
        ground[2][6] = new Pawn(6, 2, "WP3");
        ground[3][6] = new Pawn(6, 3, "WP4");
        ground[4][6] = new Pawn(6, 4, "WP5");
        ground[5][6] = new Pawn(6, 5, "WP6");
        ground[6][6] = new Pawn(6, 6, "WP7");
        ground[7][6] = new Pawn(6, 7, "WP8");
        for (int i = 2; i < 6; i++)
            for (int j = 0; j < 8; j++)
                ground[j][i] = new Empty(i, j, "   ");
        ground[0][0] = new Rook(0, 0, "BR1");
        ground[1][0] = new Knight(0, 1, "BN1");
        ground[2][0] = new Bishop(0, 2, "BB1");
        ground[3][0] = new Queen(0, 3, "BQ ");
        ground[4][0] = new King(0, 4, "BK ");
        ground[5][0] = new Bishop(0, 5, "BB2");
        ground[6][0] = new Knight(0, 6, "BN2");
        ground[7][0] = new Rook(0, 7, "BR2");
        ground[0][1] = new Pawn(1, 0, "BP1");
        ground[1][1] = new Pawn(1, 1, "BP2");
        ground[2][1] = new Pawn(1, 2, "BP3");
        ground[3][1] = new Pawn(1, 3, "BP4");
        ground[4][1] = new Pawn(1, 4, "BP5");
        ground[5][1] = new Pawn(1, 5, "BP6");
        ground[6][1] = new Pawn(1, 6, "BP7");
        ground[7][1] = new Pawn(1, 7, "BP8");
        /*ground[4][4] = new King(4, 4, "BK ");
        ground[6][3] = new King(3, 6, "WK ");*/
    }

    public void printGround() {
        System.out.println("      A   B   C   D   E   F   G   H\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + "   ");
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++)
                    for (int g = 0; g < 8; g++) {
                        if (ground[g][k].getX() == i && ground[g][k].getY() == j) {
                            System.out.print("|" + ground[g][k].getName());
                        }
                    }

            }
            System.out.println("|   " + (8 - i));

        }
        System.out.println("\n      A   B   C   D   E   F   G   H");
    }

    public boolean checkEmpty(int x1, int y1) {
        for (int k = 0; k < 8; k++)
            for (int z = 0; z < 8; z++)
                if (ground[k][z].getX() == x1 && ground[k][z].getY() == y1 && ground[k][z].getName().equals("   "))
                    return true;
        return false;
    }

    public boolean whiteKingCheck(int x, int y) {
        ArrayList<Boolean> check = new ArrayList<Boolean>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (ground[i][j].getName().toCharArray()[0] == 'B') {
                    if (ground[i][j].getName().toCharArray()[1] == 'P' && ((Pawn) ground[i][j]).check(x, y))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'N' && ((Knight) ground[i][j]).check(x, y))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'K' && ((King) ground[i][j]).check(x, y))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'B' && ((Bishop) ground[i][j]).check(x, y, ground))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'Q' && ((Queen) ground[i][j]).check(x, y, ground))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'R' && ((Rook) ground[i][j]).check(x, y, ground))
                        return true;
                }
            }
        return false;
    }

    public boolean blackKingCheck(int x, int y) {
        ArrayList<Boolean> check = new ArrayList<Boolean>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (ground[i][j].getName().toCharArray()[0] == 'W') {
                    if (ground[i][j].getName().toCharArray()[1] == 'P' && ((Pawn) ground[i][j]).check(x, y))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'N' && ((Knight) ground[i][j]).check(x, y))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'K' && ((King) ground[i][j]).check(x, y))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'B' && ((Bishop) ground[i][j]).check(x, y, ground))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'Q' && ((Queen) ground[i][j]).check(x, y, ground))
                        return true;
                    else if (ground[i][j].getName().toCharArray()[1] == 'R' && ((Rook) ground[i][j]).check(x, y, ground))
                        return true;
                }
            }
        return false;
    }
}