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

    public boolean checkEmpty(int x, int y) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (ground[i][j].getX() == x && ground[i][j].getY() == y && ground[i][j].getName().equals("   "))
                    return true;
        return false;
    }
}
/*import java.util.ArrayList;

public class Ground {

    private String[][] ground;
    private ArrayList<Man> chessMansW;
    private ArrayList<Man> chessMansB;

    public Ground() {
        ground = new String[8][8];
        chessMansB = new ArrayList<>();
        chessMansW = new ArrayList<>();
        ground[0][7] = "WR1";
        ground[1][7] = "WN1";
        ground[2][7] = "WB1";
        ground[3][7] = "WQ ";
        ground[4][7] = "WK ";
        ground[5][7] = "WB2";
        ground[6][7] = "WN2";
        ground[7][7] = "WR2";
        ground[0][6] = "WP1";
        ground[1][6] = "WP2";
        ground[2][6] = "WP3";
        ground[3][6] = "WP4";
        ground[4][6] = "WP5";
        ground[5][6] = "WP6";
        ground[6][6] = "WP7";
        ground[7][6] = "WP8";
        chessMansW.add(new Rook(0,7,"WR1"));
        chessMansW.add(new Knight(1,7,"WN1"));
        chessMansW.add(new Bishop(2,7,"WB1"));
        chessMansW.add(new Queen(3,7,"WQ "));
        chessMansW.add(new King(4,7,"WK "));
        chessMansW.add(new Bishop(5,7,"WB2"));
        chessMansW.add(new Knight(6,7,"WN2"));
        chessMansW.add(new Rook(7,7,"WR2"));
        chessMansW.add(new Pawn(0,6,"WP1"));
        chessMansW.add(new Pawn(1,6,"WP2"));
        chessMansW.add(new Pawn(2,6,"WP3"));
        chessMansW.add(new Pawn(3,6,"WP4"));
        chessMansW.add(new Pawn(4,6,"WP5"));
        chessMansW.add(new Pawn(5,6,"WP6"));
        chessMansW.add(new Pawn(6,6,"WP7"));
        chessMansW.add(new Pawn(7,6,"WP8"));
        for (int i = 2; i < 6; i++)
            for (int j = 0; j < 8; j++)
                ground[j][i] = "   ";
        ground[0][0] = "BR1";
        ground[1][0] = "BN1";
        ground[2][0] = "BB1";
        ground[3][0] = "BQ ";
        ground[4][0] = "BK ";
        ground[5][0] = "BB2";
        ground[6][0] = "BN2";
        ground[7][0] = "BR2";
        ground[0][1] = "BP1";
        ground[1][1] = "BP2";
        ground[2][1] = "BP3";
        ground[3][1] = "BP4";
        ground[4][1] = "BP5";
        ground[5][1] = "BP6";
        ground[6][1] = "BP7";
        ground[7][1] = "BP8";
        chessMansB.add(new Rook(0,7,"BR1"));
        chessMansB.add(new Knight(1,7,"BN1"));
        chessMansB.add(new Bishop(2,7,"BB1"));
        chessMansB.add(new Queen(3,7,"BQ "));
        chessMansB.add(new King(4,7,"BK "));
        chessMansB.add(new Bishop(5,7,"BB2"));
        chessMansB.add(new Knight(6,7,"BN2"));
        chessMansB.add(new Rook(7,7,"BR2"));
        chessMansB.add(new Pawn(0,6,"BP1"));
        chessMansB.add(new Pawn(1,6,"BP2"));
        chessMansB.add(new Pawn(2,6,"BP3"));
        chessMansB.add(new Pawn(3,6,"BP4"));
        chessMansB.add(new Pawn(4,6,"BP5"));
        chessMansB.add(new Pawn(5,6,"BP6"));
        chessMansB.add(new Pawn(6,6,"BP7"));
        chessMansB.add(new Pawn(7,6,"BP8"));
    }

    public String[][] getGround() {
        return ground;
    }

    public void printGround() {
        System.out.println("     A   B   C   D   E   F   G   H\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + "  ");
            for (int j = 0; j < 8; j++)
                System.out.print("|" + ground[j][i]);
            System.out.println("|  " + (8 - i));

        }
        System.out.println("\n     A   B   C   D   E   F   G   H");
    }
}
*/