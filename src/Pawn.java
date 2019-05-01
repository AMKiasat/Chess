public class Pawn extends Man {

    private boolean firstMove;

    public Pawn(int x, int y, String name) {
        super(x, y, name);
        firstMove = true;
    }

    public Boolean movement(int x, int y, Ground ground) {
        Boolean canMove = false;
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if (firstMove && this.y + 2 == y) {
                canMove = true;
            } else if (this.y + 1 == y) {

            }
        }
        return canMove;
    }
}
