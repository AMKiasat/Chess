public class Knight extends Man {

    public Knight(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean movement(int y, int x, Ground ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if ((this.x + 2 == x && this.y + 1 == y) || (this.x + 1 == x && this.y + 2 == y) || (this.x - 2 == x && this.y + 1 == y) || (this.x - 1 == x && this.y + 2 == y) || (this.x - 2 == x && this.y - 1 == y) || (this.x - 1 == x && this.y - 2 == y) || (this.x + 2 == x && this.y - 1 == y) || (this.x + 1 == x && this.y - 2 == y)) {
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++) {
                        if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                            if (ground.getGround()[i][j].getName().equals("   ")) {
                                ground.getGround()[i][j].setX(this.x);
                                ground.getGround()[i][j].setY(this.y);
                                this.x = x;
                                this.y = y;
                                return true;
                            } else if (ground.getGround()[i][j].getName().toCharArray()[0] == this.name.toCharArray()[0])
                                return false;
                            else {
                                ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                                this.x = x;
                                this.y = y;
                                return true;
                            }
                        }
                    }
            }
        }
        return false;
    }

    public boolean check(int y, int x) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y))
            return (this.x + 2 == x && this.y + 1 == y) || (this.x + 1 == x && this.y + 2 == y) || (this.x - 2 == x && this.y + 1 == y) || (this.x - 1 == x && this.y + 2 == y) || (this.x - 2 == x && this.y - 1 == y) || (this.x - 1 == x && this.y - 2 == y) || (this.x + 2 == x && this.y - 1 == y) || (this.x + 1 == x && this.y - 2 == y);
        return false;
    }
}
