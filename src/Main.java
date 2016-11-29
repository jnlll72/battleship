public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();

        Boat b1 = new Boat(2, 1, 1, 0);
        Boat b2 = new Boat(4, 2, 2, 1);
        Boat b3 = new Boat(3, 1, 1, 1);



        boolean r1 = grid.addBoat(b1);
        boolean r2 = grid.addBoat(b2);
        boolean r3 = grid.addBoat(b3);

        System.out.println(grid);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}