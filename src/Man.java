public class Man {

    int x;
    int y;
    String name;
    private Boolean inGame;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
