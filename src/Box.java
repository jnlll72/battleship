public class Box {
    private int x;
    private int y;
    private int state;

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
        this.state = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                ", state=" + state +
                '}';
    }
}