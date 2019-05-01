public class Queen extends Man {

    public Queen(int x, int y, String name) {
        super(x, y, name);
    }

    public Boolean movement(int x,int y, Ground ground) {
        Boolean canMove = false;
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
//            if () {

//            }
        }
        return canMove;
    }
}
