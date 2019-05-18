/**
 * This is an abstract peace for every chessmen
 * @author Amir Mojtaba Kiasat
 * @version 1.0
 * @since 5-1-2019
 */
public abstract class Man {

    int x;
    int y;
    String name;
    Boolean inGame;

    public Man(int x, int y, String name) {
        this.y = y;
        this.x = x;
        this.name = name;
        inGame = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public Boolean getInGame() {
        return inGame;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setInGame(Boolean inGame) {
        this.inGame = inGame;
    }
    /**
     *
     * @param x final x
     * @param y final y
     * @param ground the ground which the man moves on
     * @return true if the move is allowed and move it to x and y otherwise it's false
     */
    abstract boolean movement(int x, int y, Ground ground);
    /**
     *
     * @param x final x
     * @param y final y
     * @param ground the array if the all chess mans
     * @return true if the move is allowed otherwise it's false
     */
    abstract boolean check(int x, int y, Man[][] ground);

}
