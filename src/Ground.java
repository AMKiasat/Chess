import java.util.ArrayList;

public class Ground {

    private String[][] ground;

    //private

    public Ground() {
        ground = new String[8][8];
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
