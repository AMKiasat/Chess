public class Knight extends Man {

    public Knight(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean movement(int x, int y, Ground ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            //            if ((this.x + 2 == x && this.y + 1 == y) || (this.x + 1 == x && this.y + 2 == y) || (this.x - 2 == x && this.y + 1 == y) || (this.x - 1 == x && this.y + 2 == y) || (this.x - 2 == x && this.y - 1 == y) || (this.x - 1 == x && this.y - 2 == y) || (this.x + 2 == x && this.y - 1 == y) || (this.x + 1 == x && this.y - 2 == y)) {
//
//            }

        }
        return false;
    }
}
