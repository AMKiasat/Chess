public class Man {

    int x;
    int y;
    private String name;
    private Boolean inGame;

    public Man(int y, int x, String name) {
        this.y = x;
        this.x = y;
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
}
