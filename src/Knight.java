public class Knight extends Man {

    public Knight(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean movement(int x, int y, Ground ground) {
        Boolean canMove = false;
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if ((this.x == x || this.y == y) ) {

            }
        }
        return canMove;
    }
}
