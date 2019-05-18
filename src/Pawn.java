/**
 * This is pawn peace class
 * @author Amir Mojtaba Kiasat
 * @version 1.0
 * @since 5-1-2019
 */
public class Pawn extends Man {

    private boolean firstMove;

    public Pawn(int x, int y, String name) {
        super(x, y, name);
        if (name.toCharArray()[0] == 'W' && y == 6)
            firstMove = true;
        else if (name.toCharArray()[0] == 'B' && y == 1)
            firstMove = true;
        else
            firstMove = false;
    }

    @Override
    public boolean movement(int x, int y, Ground ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if (name.toCharArray()[0] == 'W') {
                if (this.x == x) {
                    if (firstMove && this.y - 2 == y && ground.checkEmpty(this.x, this.y - 1) && ground.checkEmpty(this.x, this.y - 2)) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++) {
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    int x1 = this.x;
                                    int y1 = this.y;
                                    this.x = x;
                                    this.y = y;
                                    for (int k = 0; k < 8; k++)
                                        for (int h = 0; h < 8; h++) {
                                            if (ground.getGround()[k][h].getName().equals("WK ") && ground.whiteKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                                ground.getGround()[i][j].setX(x);
                                                ground.getGround()[i][j].setY(y);
                                                this.x = x1;
                                                this.y = y1;
                                                return false;
                                            }
                                        }
                                    firstMove = false;
                                    return true;
                                }
                            }
                    } else if (this.y - 1 == y && ground.checkEmpty(this.x, this.y - 1)) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++)
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    int x1 = this.x;
                                    int y1 = this.y;
                                    this.x = x;
                                    this.y = y;
                                    for (int k = 0; k < 8; k++)
                                        for (int h = 0; h < 8; h++) {
                                            if (ground.getGround()[k][h].getName().equals("WK ") && ground.whiteKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                                ground.getGround()[i][j].setX(x);
                                                ground.getGround()[i][j].setY(y);
                                                this.x = x1;
                                                this.y = y1;
                                                return false;
                                            }
                                        }
                                    firstMove = false;
                                    return true;
                                }
                    }
                } else if ((this.x == x + 1 || this.x == x - 1) && this.y - 1 == y) {
                    for (int i = 0; i < 8; i++)
                        for (int j = 0; j < 8; j++)
                            if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                if (!(ground.getGround()[i][j].getName().equals("   ")) && !(ground.getGround()[i][j].getName().toCharArray()[0] == this.name.toCharArray()[0])) {
                                    String knockedMan = ground.getGround()[i][j].getName();
                                    ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                                    int x1 = this.x;
                                    int y1 = this.y;
                                    this.x = x;
                                    this.y = y;
                                    for (int k = 0; k < 8; k++)
                                        for (int h = 0; h < 8; h++) {
                                            if (ground.getGround()[k][h].getName().equals("WK ") && ground.whiteKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                                if (knockedMan.toCharArray()[1] == 'Q') {
                                                    ground.getGround()[i][j] = new Queen(x, y, knockedMan);
                                                } else if (knockedMan.toCharArray()[1] == 'B') {
                                                    ground.getGround()[i][j] = new Bishop(x, y, knockedMan);
                                                } else if (knockedMan.toCharArray()[1] == 'N') {
                                                    ground.getGround()[i][j] = new Knight(x, y, knockedMan);
                                                } else if (knockedMan.toCharArray()[1] == 'K') {
                                                    ground.getGround()[i][j] = new King(x, y, knockedMan);
                                                } else if (knockedMan.toCharArray()[1] == 'P') {
                                                    ground.getGround()[i][j] = new Pawn(x, y, knockedMan);
                                                } else if (knockedMan.toCharArray()[1] == 'R') {
                                                    ground.getGround()[i][j] = new Rook(x, y, knockedMan);
                                                }
                                                this.x = x1;
                                                this.y = y1;
                                                return false;
                                            }
                                        }
                                    ground.addKnockedChessMan(knockedMan);
                                    firstMove = false;
                                    return true;
                                }
                            }
                }
            } else {
                if (this.x == x) {
                    if (firstMove && this.y + 2 == y && ground.checkEmpty(this.x, this.y + 1) && ground.checkEmpty(this.x, this.y + 2)) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++) {
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    int x1 = this.x;
                                    int y1 = this.y;
                                    this.x = x;
                                    this.y = y;
                                    for (int k = 0; k < 8; k++)
                                        for (int h = 0; h < 8; h++) {
                                            if (ground.getGround()[k][h].getName().equals("BK ") && ground.blackKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                                ground.getGround()[i][j].setX(x);
                                                ground.getGround()[i][j].setY(y);
                                                this.x = x1;
                                                this.y = y1;
                                                return false;
                                            }
                                        }
                                    firstMove = false;
                                    return true;
                                }
                            }
                    } else if (this.y + 1 == y) {
                        for (int i = 0; i < 8; i++)
                            for (int j = 0; j < 8; j++)
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    ground.getGround()[i][j].setX(this.x);
                                    ground.getGround()[i][j].setY(this.y);
                                    int x1 = this.x;
                                    int y1 = this.y;
                                    this.x = x;
                                    this.y = y;
                                    for (int k = 0; k < 8; k++)
                                        for (int h = 0; h < 8; h++) {
                                            if (ground.getGround()[k][h].getName().equals("BK ") && ground.blackKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                                ground.getGround()[i][j].setX(x);
                                                ground.getGround()[i][j].setY(y);
                                                this.x = x1;
                                                this.y = y1;
                                                return false;
                                            }
                                        }
                                    firstMove = false;
                                    return true;
                                }
                    }
                } else if ((this.x == x + 1 || this.x == x - 1) && this.y + 1 == y) {
                    for (int i = 0; i < 8; i++)
                        for (int j = 0; j < 8; j++)
                            if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                                    if (!(ground.getGround()[i][j].getName().equals("   ")) && !(ground.getGround()[i][j].getName().toCharArray()[0] == this.name.toCharArray()[0])) {
                                        String knockedMan = ground.getGround()[i][j].getName();
                                        ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                                        int x1 = this.x;
                                        int y1 = this.y;
                                        this.x = x;
                                        this.y = y;
                                        for (int k = 0; k < 8; k++)
                                            for (int h = 0; h < 8; h++) {
                                                if (ground.getGround()[k][h].getName().equals("BK ") && ground.blackKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                                    if (knockedMan.toCharArray()[1] == 'Q') {
                                                        ground.getGround()[i][j] = new Queen(x, y, knockedMan);
                                                    } else if (knockedMan.toCharArray()[1] == 'B') {
                                                        ground.getGround()[i][j] = new Bishop(x, y, knockedMan);
                                                    } else if (knockedMan.toCharArray()[1] == 'N') {
                                                        ground.getGround()[i][j] = new Knight(x, y, knockedMan);
                                                    } else if (knockedMan.toCharArray()[1] == 'K') {
                                                        ground.getGround()[i][j] = new King(x, y, knockedMan);
                                                    } else if (knockedMan.toCharArray()[1] == 'P') {
                                                        ground.getGround()[i][j] = new Pawn(x, y, knockedMan);
                                                    } else if (knockedMan.toCharArray()[1] == 'R') {
                                                        ground.getGround()[i][j] = new Rook(x, y, knockedMan);
                                                    }
                                                    this.x = x1;
                                                    this.y = y1;
                                                    return false;
                                                }
                                            }
                                        ground.addKnockedChessMan(knockedMan);
                                        firstMove = false;
                                        return true;
                                    }
                                }
                            }
                }
            }
        }
        return false;
    }
    @Override
    public boolean check(int x, int y, Man[][] ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if (name.toCharArray()[0] == 'W') {
                return (this.x == x + 1 || this.x == x - 1) && this.y - 1 == y;
            } else
                return (this.x == x + 1 || this.x == x - 1) && this.y + 1 == y;
        }
        return false;
    }
}
