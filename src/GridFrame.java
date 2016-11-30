import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julien on 30/11/2016.
 */
public class GridFrame extends JFrame implements ActionListener {
    private JButton[][] aryButton;
    private Grid grid = new Grid();

    public GridFrame() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new MetalLookAndFeel());

        aryButton = new JButton[this.grid.getW()][this.grid.getH()];

        this.setTitle("BattleShip");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setResizable(false);

        // PANEL MAIN

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel pMain1 = new JPanel();
        JPanel pMain2 = new JPanel();

        pMain1.setLayout(new BorderLayout());

        pMain2.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.DARK_GRAY));
        pMain2.setPreferredSize(new Dimension(1000, 100));

        // SOUS PANEL MAIN

        JPanel sPan1 = new JPanel();
        JPanel sPan2 = new JPanel();

        sPan1.setLayout(new BorderLayout());

        sPan1.setPreferredSize(new Dimension(700, 700));
        sPan2.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.DARK_GRAY));

        // PANEL GRID

        JPanel panN = new JPanel();
        JPanel panE = new JPanel();
        JPanel panS = new JPanel();
        JPanel panW = new JPanel();

        JPanel panC = new JPanel();

        panN.setPreferredSize(new Dimension(700, 50));
        panE.setPreferredSize(new Dimension(50, 700));
        panW.setPreferredSize(new Dimension(50, 700));
        panS.setPreferredSize(new Dimension(700, 50));

        panC.setPreferredSize(new Dimension(400, 400));

        GridLayout GL = new GridLayout(this.grid.getW(), this.grid.getH());
        GL.setHgap(0);
        GL.setVgap(0);
        panC.setLayout(GL);

        for (int i = 0; i < this.grid.getW(); i++) {
            for (int j = 0; j < this.grid.getH(); j++) {
                JButton btn = new JButton();

                Border grayBorder;

                if (i == 0 && j == 0) {
                    grayBorder = BorderFactory.createMatteBorder(2, 2, 1, 1, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else if (j == 9 && i == 0) {
                    grayBorder = BorderFactory.createMatteBorder(2, 1, 1, 2, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else if (j == 0 && i == 9) {
                    grayBorder = BorderFactory.createMatteBorder(1, 2, 2, 1, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else if (i == 9 && j == 9) {
                    grayBorder = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else if (i == 0 && (j > 0 && j < 9)) {
                    grayBorder = BorderFactory.createMatteBorder(2, 1, 1, 1, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else if (i == 9 && (j > 0 && j < 9)) {
                    grayBorder = BorderFactory.createMatteBorder(1, 1, 2, 1, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else if (j == 0 && (i > 0 && i < 9)) {
                    grayBorder = BorderFactory.createMatteBorder(1, 2, 1, 1, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else if (j == 9 && (i > 0 && i < 9)) {
                    grayBorder = BorderFactory.createMatteBorder(1, 1, 1, 2, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                } else {
                    grayBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
                    btn.setBorder(grayBorder);
                }

                //btn.setText("(" + i + "," + j + ")");
                btn.setBackground(Color.WHITE);
                btn.addActionListener(this);
                this.aryButton[i][j] = btn;
                panC.add(btn);
            }
        }

        sPan1.add(panN, BorderLayout.NORTH);
        sPan1.add(panE, BorderLayout.EAST);
        sPan1.add(panW, BorderLayout.WEST);
        sPan1.add(panS, BorderLayout.SOUTH);
        sPan1.add(panC, BorderLayout.CENTER);

        pMain1.add(sPan1, BorderLayout.WEST);
        pMain1.add(sPan2, BorderLayout.CENTER);

        main.add(pMain1, BorderLayout.CENTER);
        main.add(pMain2, BorderLayout.SOUTH);

        this.setContentPane(main);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.grid.getW(); i++) {
            for (int j = 0; j < this.grid.getH(); j++) {
                if (this.aryButton[i][j].equals(e.getSource())) {
                    int etat = this.grid.getBox(i, j).getState();
                    System.out.println(etat);
                }
            }
        }
    }
}
