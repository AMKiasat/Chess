import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ground chess = new Ground();
        chess.printGround();
        Scanner scanner = new Scanner(System.in);
        char turn = 'W';
        while (true) {
            String man = scanner.nextLine();
            char[] manColor = man.toCharArray();
            if (manColor[0] != turn) {
                System.out.println("It's not your turn ! -_-");
                continue;
            }
            String Move = scanner.nextLine();
            char[] move = Move.toCharArray();
            int moveX;
            int moveY;
            if (move[0] == 'A')
                moveX = 0;
            if (move[0] == 'B')
                moveX = 1;
            if (move[0] == 'C')
                moveX = 2;
            if (move[0] == 'D')
                moveX = 3;
            if (move[0] == 'E')
                moveX = 4;
            if (move[0] == 'F')
                moveX = 5;
            if (move[0] == 'G')
                moveX = 6;
            if (move[0] == 'H')
                moveX = 7;

            if (move[1] == '8')
                moveY = 0;
            if (move[1] == '7')
                moveY = 1;
            if (move[1] == '6')
                moveY = 2;
            if (move[1] == '5')
                moveY = 3;
            if (move[1] == '4')
                moveY = 4;
            if (move[1] == '3')
                moveY = 5;
            if (move[1] == '2')
                moveY = 6;
            if (move[1] == '1')
                moveY = 7;

            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++) {
                    if (chess.getGround()[i][j].getName().equals(man)) {
                        chess.getGround()[i][j].mon
                    }
                }








            if (turn == 'W')
                turn = 'B';
            else turn = 'W';
        }
    }
}

