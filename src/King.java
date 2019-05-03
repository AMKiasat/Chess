public class King extends Man {

    public King(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean movement(int y, int x, Ground ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if (((this.x + 1 == x && this.y + 1 == y) || (this.x + 1 == x && this.y == y) || (this.x + 1 == x && this.y - 1 == y) || (this.x == x && this.y + 1 == y) || (this.x == x && this.y - 1 == y) || (this.x - 1 == x && this.y + 1 == y) || (this.x - 1 == x && this.y == y) || (this.x - 1 == x && this.y - 1 == y)) && !((this.name.toCharArray()[0] == 'B' && ground.blackKingCheck(y, x)) || (this.name.toCharArray()[0] == 'W' && ground.whiteKingCheck(y, x)))) {
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
                                        if (name.toCharArray()[0] == 'B' && ground.getGround()[k][h].getName().equals("BK ") && ground.blackKingCheck(ground.getGround()[k][h].getY(), ground.getGround()[k][h].getX())) {
                                            ground.getGround()[i][j].setX(x);
                                            ground.getGround()[i][j].setY(y);
                                            this.x = x1;
                                            this.y = y1;
                                            return false;
                                        }else if (name.toCharArray()[0] == 'W' && ground.getGround()[k][h].getName().equals("WK ") && ground.whiteKingCheck(ground.getGround()[k][h].getY(), ground.getGround()[k][h].getX())) {
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
                                String nockedMan = ground.getGround()[i][j].getName();
                                ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                                int x1 = this.x;
                                int y1 = this.y;
                                this.x = x;
                                this.y = y;
                                for (int k = 0; k < 8; k++)
                                    for (int h = 0; h < 8; h++) {
                                        if (name.toCharArray()[0] == 'B' && ground.getGround()[k][h].getName().equals("BK ") && ground.blackKingCheck(ground.getGround()[k][h].getY(), ground.getGround()[k][h].getX())) {
                                            if (nockedMan.toCharArray()[1] == 'Q') {
                                                ground.getGround()[i][j] = new Queen(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'B') {
                                                ground.getGround()[i][j] = new Bishop(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'N') {
                                                ground.getGround()[i][j] = new Knight(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'K') {
                                                ground.getGround()[i][j] = new King(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'P') {
                                                ground.getGround()[i][j] = new Pawn(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'R') {
                                                ground.getGround()[i][j] = new Rook(x, y, nockedMan);
                                            }
                                            this.x = x1;
                                            this.y = y1;
                                            return false;
                                        }
                                        else if (name.toCharArray()[0] == 'W' && ground.getGround()[k][h].getName().equals("WK ") && ground.whiteKingCheck(ground.getGround()[k][h].getY(), ground.getGround()[k][h].getX())) {
                                            if (nockedMan.toCharArray()[1] == 'Q') {
                                                ground.getGround()[i][j] = new Queen(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'B') {
                                                ground.getGround()[i][j] = new Bishop(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'N') {
                                                ground.getGround()[i][j] = new Knight(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'K') {
                                                ground.getGround()[i][j] = new King(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'P') {
                                                ground.getGround()[i][j] = new Pawn(x, y, nockedMan);
                                            } else if (nockedMan.toCharArray()[1] == 'R') {
                                                ground.getGround()[i][j] = new Rook(x, y, nockedMan);
                                            }
                                            this.x = x1;
                                            this.y = y1;
                                            return false;
                                        }
                                    }
                            }
                            return true;
                        }
                    }
            }
        }
        return false;
    }

    public boolean check(int y, int x) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y))
            return (this.x + 1 == x && this.y + 1 == y) || (this.x + 1 == x && this.y == y) || (this.x + 1 == x && this.y - 1 == y) || (this.x == x && this.y + 1 == y) || (this.x == x && this.y - 1 == y) || (this.x - 1 == x && this.y + 1 == y) || (this.x - 1 == x && this.y == y) || (this.x - 1 == x && this.y - 1 == y);
        return false;
    }
}
