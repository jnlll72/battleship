public class Grid {
    private Box[][] grid = new Box[10][10];

    public Grid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.grid[i][j] = new Box(i, j);
            }
        }
    }

    public Box getBox(int x, int y) {
        return this.grid[x][y];
    }
}