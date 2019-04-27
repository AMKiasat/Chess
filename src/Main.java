public class Main {

    public static void main(String[] args) {
        ground chess = new ground();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.print("|" + chess.getGround()[j][i] + "|");
            System.out.println();
        }
    }
}
