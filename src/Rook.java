public class Rook extends Man {

    public Rook(int x, int y, String name) {
        super(x, y, name);
    }

    public Boolean movement(int x, int y, Ground ground) {
        Boolean canMove = false;
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if ((this.x == x || this.y == y)) {
                for (int i = 1; this.x + i < x; i++) {
                    if (!ground.checkEmpty(this.x + i, y))
                        return false;
                }
                for (int i = 1; y + i < this.y; y++) {
                    if (!ground.checkEmpty(x, y + i)) {
                        return false;
                    }
                }
                for (int i = 1; this.y + i < y; i++) {
                    if (!ground.checkEmpty(x, this.y + i))
                        return false;
                }
                for (int i = 1; x + i < this.y; y++) {
                    if (!ground.checkEmpty(x + i, y)) {
                        return false;
                    }
                }
                this.x = x;
                this.y = y;
            }
        }
        return canMove;
    }
}
