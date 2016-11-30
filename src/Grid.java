import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Box[][] grid;
    private List<Boat> aryBoat = new ArrayList<>();

    private final int W = 10;
    private final int H = 10;

    public Grid() {
        this.grid = new Box[W][H];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.grid[i][j] = new Box(i, j);
            }
        }

        aryBoat.add(new Boat(2, -1, -1, 0));
        aryBoat.add(new Boat(3, -1, -1, 0));
        aryBoat.add(new Boat(4, -1, -1, 0));
        aryBoat.add(new Boat(5, -1, -1, 0));
    }

    public int getW() {
        return W;
    }

    public int getH() {
        return H;
    }

    public Box getBox(int x, int y) {
        return this.grid[x][y];
    }

    public List<Boat> getAryBoat() {
        return aryBoat;
    }

    public void setAryBoat(List<Boat> aryBoat) {
        this.aryBoat = aryBoat;
    }

    public boolean addBoat(int i, Boat b) {
        if (isPossible(b)) {
            this.aryBoat.get(i).setOrientation(b.getOrientation());
            this.aryBoat.get(i).setX(b.getX());
            this.aryBoat.get(i).setY(b.getY());
            int x = b.getX();
            int y = b.getY();
            int size = b.getLongueur();
            if (b.getOrientation() == 0) {
                for (int j = y; j < y + size; j++) {
                    this.grid[x][j].setState(1);
                }
            } else {
                for (int j = x; j < x + size; j++) {
                    this.grid[j][y].setState(1);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isPossible(Boat b) {
        int x = b.getX();
        int y = b.getY();
        int size = b.getLongueur();

        if (b.getOrientation() == 0) {
            for (int i = y; i < y + size; i++) {
                if (this.grid[x][i].getState() == 1) {
                    return false;
                }
            }
            return true;
        } else if (b.getOrientation() == 1) {
            for (int i = x; i < x + size; i++) {
                if (this.grid[i][y].getState() == 1) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                s += this.grid[i][j].getState() + " ";
                //s += "(" + i + "," + j + ")";
            }
            s += "\n";
        }

        return s;
    }

    public String afficheListBoat() {
        String s = "";
        for (int i = 0; i < aryBoat.size(); i++) {
            Boat boat = aryBoat.get(i);
            s += i + " => " + boat.toString() + "\n";
        }
        return s;
    }
}
