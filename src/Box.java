public class Box {
    private int x;
    private int y;
    private int etat;

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
        this.etat = 0;
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
        return etat;
    }

    public void setState(int state) {
        this.etat = state;
    }

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                ", state=" + etat +
                '}';
    }
}
