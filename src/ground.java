public class ground {

    private String[][] ground;

    public ground() {
        ground = new String[8][8];
        ground[0][0] = "WR1";
        ground[1][0] = "WN1";
        ground[2][0] = "WB1";
        ground[3][0] = "WQ ";
        ground[4][0] = "WK ";
        ground[5][0] = "WB2";
        ground[6][0] = "WN2";
        ground[7][0] = "WR2";
        ground[0][1] = "WP1";
        ground[1][1] = "WP2";
        ground[2][1] = "WP3";
        ground[3][1] = "WP4";
        ground[4][1] = "WP5";
        ground[5][1] = "WP6";
        ground[6][1] = "WP7";
        ground[7][1] = "WP8";
        for (int i = 2; i < 6; i++)
            for (int j = 0; j < 8; j++)
                ground[j][i] = "   ";
        ground[0][7] = "BR1";
        ground[1][7] = "BN1";
        ground[2][7] = "BB1";
        ground[3][7] = "BQ ";
        ground[4][7] = "BK ";
        ground[5][7] = "BB2";
        ground[6][7] = "BN2";
        ground[7][7] = "BR2";
        ground[0][6] = "BP1";
        ground[1][6] = "BP2";
        ground[2][6] = "BP3";
        ground[3][6] = "BP4";
        ground[4][6] = "BP5";
        ground[5][6] = "BP6";
        ground[6][6] = "BP7";
        ground[7][6] = "BP8";
    }

    public String[][] getGround() {
        return ground;
    }
}
