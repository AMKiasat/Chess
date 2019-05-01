public class Man {

    int x;
    int y;
    private String name;
    private Boolean inGame;

    public Man(int x, int y, String name) {
        this.x = x;
        this.y = y;
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
