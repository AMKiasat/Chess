public class Pawn extends Man {

    private boolean firstMove;

    public Pawn(int x, int y, String name) {
        super(x, y, name);
        firstMove = true;
    }

    public boolean movement(int x, int y, Ground ground) {
        Boolean canMove = false;
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if (this.x == x) {
                if (firstMove && this.y + 2 == y && ground.checkEmpty(this.x, this.y + 1) && ground.checkEmpty(this.x, this.y + 2)) {

                } else if (this.y + 1 == y && ground.checkEmpty(this.x, this.y + 1)) {

                }
            }
        }
        return canMove;
    }
}
