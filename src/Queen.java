public class Queen extends Man {

    public Queen(int x, int y, String name) {
        super(x, y, name);
    }

    public boolean movement(int y, int x, Ground ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if ((this.x == x || this.y == y)) {
                for (int i = 1; this.x + i < x; i++) {
                    if (!ground.checkEmpty(this.x + i, y))
                        return false;
                }
                for (int i = 1; y + i < this.y; i++) {
                    if (!ground.checkEmpty(x, y + i)) {
                        return false;
                    }
                }
                for (int i = 1; this.y + i < y; i++) {
                    if (!ground.checkEmpty(x, this.y + i))
                        return false;
                }
                for (int i = 1; x + i < this.x; i++) {
                    if (!ground.checkEmpty(x + i, y)) {
                        return false;
                    }
                }
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++) {
                        if (ground.getGround()[i][j].getX() == x && ground.getGround()[i][j].getY() == y) {
                            if (ground.getGround()[i][j].getName().equals("   ")) {
                                ground.getGround()[i][j].setX(this.x);
                                ground.getGround()[i][j].setY(this.y);
                            } else if (ground.getGround()[i][j].getName().toCharArray()[0] == this.name.toCharArray()[0])
                                return false;
                            else
                                ground.getGround()[i][j] = new Empty(this.x, this.y, "   ");
                        }
                    }
                this.x = x;
                this.y = y;
                return true;

            } else {
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
        }
        return false;
    }

    public boolean check(int y, int x, Man[][] ground) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8 && !(this.x == x && this.y == y)) {
            if ((this.x == x || this.y == y)) {
                for (int i = 1; this.x + i < x; i++) {
                    for (int k = 0; k < 8; k++)
                        for (int z = 0; z < 8; z++)
                            if (ground[k][z].getX() == this.x + i && ground[k][z].getY() == y && !ground[k][z].getName().equals("   "))
                                return false;
                }
                for (int i = 1; y + i < this.y; i++) {
                    for (int k = 0; k < 8; k++)
                        for (int z = 0; z < 8; z++)
                            if (ground[k][z].getX() == x && ground[k][z].getY() == y + i && !ground[k][z].getName().equals("   "))
                                return false;
                }
                for (int i = 1; this.y + i < y; i++) {
                    for (int k = 0; k < 8; k++)
                        for (int z = 0; z < 8; z++)
                            if (ground[k][z].getX() == x && ground[k][z].getY() == this.y + i && !ground[k][z].getName().equals("   "))
                                return false;
                }
                for (int i = 1; x + i < this.x; i++) {
                    for (int k = 0; k < 8; k++)
                        for (int z = 0; z < 8; z++)
                            if (ground[k][z].getX() == x + i && ground[k][z].getY() == y && !ground[k][z].getName().equals("   "))
                                return false;
                }
                return true;
            } else {
                boolean inMoveLine = false;
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
                return inMoveLine;
            }

        }
        return false;
    }
}