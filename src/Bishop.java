/**
 * This is bishop peace class
 * @author Amir Mojtaba Kiasat
 * @version 1.0
 * @since 5-1-2019
 */
public class Bishop extends Man {

    public Bishop(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean movement(int x, int y, Ground ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            boolean inMoveLine = false;
            for (int i = 1; i < 8; i++) {
                if (this.x + i == x && this.y + i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        if (!ground.checkEmpty(this.x + j, this.y + j))
                            return false;
                } else if (this.x - i == x && this.y + i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        if (!ground.checkEmpty(this.x - j, this.y + j))
                            return false;
                } else if (this.x - i == x && this.y - i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        if (!ground.checkEmpty(this.x - j, this.y - j))
                            return false;
                } else if (this.x + i == x && this.y - i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        if (!ground.checkEmpty(this.x + j, this.y - j))
                            return false;
                }
            }
            if (inMoveLine) {
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++) {
                        if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                            if (ground.getGround()[i][j].getName().equals("   ")) {
                                ground.getGround()[i][j].setX(this.x);
                                ground.getGround()[i][j].setY(this.y);
                                int x1 = this.x;
                                int y1 = this.y;
                                this.x = x;
                                this.y = y;
                                for (int k = 0; k < 8; k++)
                                    for (int h = 0; h < 8; h++) {
                                        if (name.toCharArray()[0] == 'B' && ground.getGround()[k][h].getName().equals("BK ") && ground.blackKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                            ground.getGround()[i][j].setX(x);
                                            ground.getGround()[i][j].setY(y);
                                            this.x = x1;
                                            this.y = y1;
                                            return false;
                                        }else if (name.toCharArray()[0] == 'W' && ground.getGround()[k][h].getName().equals("WK ") && ground.whiteKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
                                            ground.getGround()[i][j].setX(x);
                                            ground.getGround()[i][j].setY(y);
                                            this.x = x1;
                                            this.y = y1;
                                            return false;
                                        }
                                    }
                            } else if (ground.getGround()[i][j].getName().toCharArray()[0] == this.name.toCharArray()[0])
                                return false;
                            else {
                                String knockedMan = ground.getGround()[i][j].getName();
                                ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                                int x1 = this.x;
                                int y1 = this.y;
                                this.x = x;
                                this.y = y;
                                for (int k = 0; k < 8; k++)
                                    for (int h = 0; h < 8; h++) {
                                        if (name.toCharArray()[0] == 'B' && ground.getGround()[k][h].getName().equals("BK ") && ground.blackKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
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
                                        else if (name.toCharArray()[0] == 'W' && ground.getGround()[k][h].getName().equals("WK ") && ground.whiteKingCheck(ground.getGround()[k][h].getX(), ground.getGround()[k][h].getY())) {
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
                            }
                            return true;
                        }
                    }
            }
        }
        return false;
    }

    public boolean check(int x, int y, Man[][] ground) {
        boolean inMoveLine = false;
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            for (int i = 1; i < 8; i++) {
                if (this.x + i == x && this.y + i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        for (int k = 0; k < 8; k++)
                            for (int z = 0; z < 8; z++)
                                if (ground[k][z].getX() == this.x + j && ground[k][z].getY() == this.y + j && !ground[k][z].getName().equals("   "))
                                    return false;
                } else if (this.x - i == x && this.y + i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        for (int k = 0; k < 8; k++)
                            for (int z = 0; z < 8; z++)
                                if (ground[k][z].getX() == this.x - j && ground[k][z].getY() == this.y + j && !ground[k][z].getName().equals("   "))
                                    return false;
                } else if (this.x - i == x && this.y - i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        for (int k = 0; k < 8; k++)
                            for (int z = 0; z < 8; z++)
                                if (ground[k][z].getX() == this.x - j && ground[k][z].getY() == this.y - j && !ground[k][z].getName().equals("   "))
                                    return false;
                } else if (this.x + i == x && this.y - i == y) {
                    inMoveLine = true;
                    for (int j = 1; j < i; j++)
                        for (int k = 0; k < 8; k++)
                            for (int z = 0; z < 8; z++)
                                if (ground[k][z].getX() == this.x + j && ground[k][z].getY() == this.y - j && !ground[k][z].getName().equals("   "))
                                    return false;
                }
            }
        }
        return inMoveLine;
    }
}
