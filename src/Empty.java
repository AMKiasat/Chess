/**
 * This is Bishop peace class
 * @author Amir Mojtaba Kiasat
 * @version 1.0
 * @since 5-1-2019
 */
public class Empty extends Man {

    public Empty(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    boolean movement(int x, int y, Ground ground) {
        return false;
    }

    @Override
    boolean check(int x, int y, Man[][] ground) {
        return false;
    }
}
