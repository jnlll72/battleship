import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private Box[][] grid = new Box[10][10];
    private List<Boat> listBoat;

    public Grid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.grid[i][j] = new Box(i, j);
            }
        }
        this.listBoat = new ArrayList<>();
    }

    public Box getBox(int x, int y) {
        return this.grid[x][y];
    }

    public boolean addBoat(Boat b) {
        if (isPossible(b)) {
            if (b.getOrientation() == 0) {
                int x = b.getX();
                int y = b.getY();

                while (y < b.getX() + b.getLongueur()) {
                    this.grid[x][y].setState(1);
                    y++;
                }
            } else {
                int x = b.getX();
                int y = b.getY();

                while (x < b.getX() + b.getLongueur()) {
                    this.grid[x][y].setState(1);
                    x++;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isPossible(Boat b) {

        if (b.getOrientation() == 0) {
            if (b.getX() + b.getLongueur() < 10) {

                int x = b.getX();
                int y = b.getY();

                while (y < b.getX() + b.getLongueur()) {
                    if (this.grid[x][y].getState() == 1) {
                        return false;
                    }
                    y++;
                }
            }
        } else {
            if (b.getY() + b.getLongueur() < 10) {

                int x = b.getX();
                int y = b.getY();

                while (x < b.getY() + b.getLongueur()) {
                    if (this.grid[x][y].getState() == 1) {
                        return false;
                    }
                    x++;
                }
            }
        }

        return true;
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
}