public class Pawn extends Man {

    private boolean firstMove;

    public Pawn(int x, int y, String name) {
        super(x, y, name);
        firstMove = true;
    }

    public boolean movement(int y, int x, Ground ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if (name.toCharArray()[0] == 'W') {
                if (this.y == y) {
                    if (firstMove && this.x - 2 == x && ground.checkEmpty(this.x - 1, this.y) && ground.checkEmpty(this.x - 2, this.y)) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++) {
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    this.x = x;
                                    this.y = y;
                                    firstMove = false;
                                    return true;
                                }
                            }
                    } else if (this.x - 1 == x && ground.checkEmpty(this.x - 1, this.y)) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++)
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    this.x = x;
                                    this.y = y;
                                    firstMove = false;
                                    return true;
                                }
                    }
                } else if ((this.y == y + 1 || this.y == y - 1) && this.x - 1 == x) {
                    for (int i = 0; i < 8; i++)
                        for (int j = 0; j < 8; j++)
                            if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                if (!(ground.getGround()[i][j].getName().equals("   ")) && !(ground.getGround()[i][j].getName().toCharArray()[0] == this.name.toCharArray()[0])) {
                                    ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                                    this.x = x;
                                    this.y = y;
                                    firstMove = false;
                                    return true;
                                }
                            }
                }
            } else {
                if (this.y == y) {
                    if (firstMove && this.x + 2 == x && ground.checkEmpty(this.x + 1, this.y) && ground.checkEmpty(this.x + 2, this.y)) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++) {
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    this.x = x;
                                    this.y = y;
                                    firstMove = false;
                                    return true;
                                }
                            }
                    } else if (this.x + 1 == x) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++)
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    this.x = x;
                                    this.y = y;
                                    firstMove = false;
                                    return true;
                                }
                    }
                } else if ((this.y == y + 1 || this.y == y - 1) && this.x + 1 == x) {
                    for (int i = 0; i < 8; i++)
                        for (int j = 0; j < 8; j++)
                            if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                if (!(ground.getGround()[i][j].getName().equals("   ")) && !(ground.getGround()[i][j].getName().toCharArray()[0] == this.name.toCharArray()[0])) {
                                    ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                                    this.x = x;
                                    this.y = y;
                                    firstMove = false;
                                    return true;
                                }
                            }
                }
            }
        }
        return false;
    }

    public boolean check(int y, int x) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if (name.toCharArray()[0] == 'W') {
                return (this.y == y + 1 || this.y == y - 1) && this.x - 1 == x;
            } else
                return (this.y == y + 1 || this.y == y - 1) && this.x + 1 == x;
        }
        return false;
    }
}
