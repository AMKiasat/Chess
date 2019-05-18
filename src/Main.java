import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ground chess = new Ground();
        chess.printGround();
        Scanner scanner = new Scanner(System.in);
        char turn = 'W';
        while (true) {
            String man = scanner.nextLine();
            if (man.toCharArray()[0] != turn) {
                System.out.println("It's not your turn! -_-");
                continue;
            }
            String Move = scanner.nextLine();
            char[] move = Move.toCharArray();
            int moveX = 0;
            int moveY = 0;

            if (move[0] == 'B')
                moveX = 1;
            else if (move[0] == 'C')
                moveX = 2;
            else if (move[0] == 'D')
                moveX = 3;
            else if (move[0] == 'E')
                moveX = 4;
            else if (move[0] == 'F')
                moveX = 5;
            else if (move[0] == 'G')
                moveX = 6;
            else if (move[0] == 'H')
                moveX = 7;
            else System.out.println("Wrong move");

            if (move[1] == '7')
                moveY = 1;
            else if (move[1] == '6')
                moveY = 2;
            else if (move[1] == '5')
                moveY = 3;
            else if (move[1] == '4')
                moveY = 4;
            else if (move[1] == '3')
                moveY = 5;
            else if (move[1] == '2')
                moveY = 6;
            else if (move[1] == '1')
                moveY = 7;
            else System.out.println("Wrong move.");

            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++) {
                    if (chess.getGround()[i][j].getName().equals(man)) {
                        if (!chess.getGround()[i][j].movement(moveX, moveY, chess))
                            System.out.println("That move is not allowed!");
                        else {
                            if (turn == 'W')
                                turn = 'B';
                            else turn = 'W';
                        }
                    }
                }

            chess.printGround();

            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++) {
                    if (chess.getGround()[i][j].getName().equals("WK ") && chess.whiteKingCheck(chess.getGround()[i][j].getX(), chess.getGround()[i][j].getY())) {
                        System.out.println("White king check.");
                    } else if (chess.getGround()[i][j].getName().equals("BK ") && chess.blackKingCheck(chess.getGround()[i][j].getX(), chess.getGround()[i][j].getY())) {
                        System.out.println("Black king check.");
                    }
                }

            for (int i = 0 ;i<chess.getKnockedChessMan().size();i++)
                if (chess.getKnockedChessMan().get(i).toCharArray()[0] == 'W')
                    System.out.print(chess.getKnockedChessMan().get(i) + "  ");
            System.out.println("\n");
            for (int i = 0 ;i<chess.getKnockedChessMan().size();i++)
                if (chess.getKnockedChessMan().get(i).toCharArray()[0] == 'B')
                    System.out.print(chess.getKnockedChessMan().get(i) + "  ");
            System.out.println();
        }
    }
}

