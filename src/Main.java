import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();

//        Boat b1 = new Boat(2, 1, 1, 0);
//        Boat b2 = new Boat(4, 2, 2, 1);
//
//        grid.addBoat(b1);
//        grid.addBoat(b2);


        Scanner sc = new Scanner(System.in);


        int choix;
        String c;

        do {
            System.out.println("Selectionnez un bateau :");
            System.out.println(grid.afficheListBoat());
            choix = sc.nextInt();

            Boat b = grid.getAryBoat().get(choix);

            Boat newB = new Boat(b.getLongueur(), b.getX(), b.getY(), b.getOrientation());

            System.out.println("Rentrez coordonnées :");
            System.out.println("x :");
            int x = sc.nextInt();

            System.out.println("y :");
            int y = sc.nextInt();

            newB.setX(x);
            newB.setY(y);

            System.out.println("Selectionnez orientation :");
            System.out.println("0 => horizontale");
            System.out.println("1 => verticale");
            int ori = sc.nextInt();

            newB.setOrientation(ori);

            boolean ok = grid.addBoat(choix, newB);
            System.out.println(ok);

            System.out.println(grid);

            System.out.println("NEXT? (Y/N)");
            c = sc.next();

        } while (!Objects.equals(c, "N"));

    }
}
