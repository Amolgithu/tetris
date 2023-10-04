import java.awt.Color;
import java.awt.Graphics;
// import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class gamepanel extends JPanel {

    private Color allcolor[][] = new Color[15][10], owncolor;
    // private Color sblock[][] = { { null, Color.red, Color.red, null },
    // { Color.red, Color.red, null, null },
    // { null, null, null, null } };

    Random r = new Random();
    private int[] differencex = new int[4], difference = new int[4];
    private int[][][] allshapesx = {
            { { 4, 5, 4, 5 }, { 4, 5, 4, 5 }, { 4, 5, 4, 5 }, { 4, 5, 4, 5 } },
            { { 3, 4, 5, 6 }, { 4, 4, 4, 4 }, { 3, 4, 5, 6 }, { 4, 4, 4, 4 } },
            { { 4, 5, 3, 4 }, { 4, 4, 5, 5 }, { 4, 5, 3, 4 }, { 4, 4, 5, 5 } },
            { { 3, 4, 4, 5 }, { 4, 3, 4, 3 }, { 3, 4, 4, 5 }, { 4, 3, 4, 3 } },
            { { 5, 3, 4, 5 }, { 4, 4, 4, 5 }, { 3, 4, 5, 3 }, { 4, 5, 5, 5 } },
            { { 3, 3, 4, 5 }, { 4, 5, 4, 4 }, { 3, 4, 5, 5 }, { 5, 5, 4, 5 } },
            { { 4, 3, 4, 5 }, { 4, 4, 5, 4 }, { 3, 4, 5, 4 }, { 5, 4, 5, 5 } }
    },
            allshapesy = {
                    { { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } },
                    { { 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0 }, { 0, 1, 2, 3 } },
                    { { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 } },
                    { { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 } },
                    { { 0, 1, 1, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, 1 }, { 0, 0, 1, 2 } },
                    { { 0, 1, 1, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, 1 }, { 0, 1, 2, 2 } },
                    { { 0, 1, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 0, 1 }, { 0, 1, 1, 2 } }
            };

    private int sblockx[] = new int[4], sblocky[] = new int[4];
    // private int sblockx[] = { 4, 5, 3, 4 }, sblocky[] = { 0, 0, 1, 1 };
    private boolean move = true, lose;
    private int nowshape, nextshape;
    public int rotation = 0;

    // ArrayList<Integer> sblocky = new ArrayList<Integer>(2);
    // ArrayList<Integer> sblockx = new ArrayList<Integer>(4);

    public gamepanel() {
        nowshape = r.nextInt(0, 7);
        owncolor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        initialpanelcolor();
        setshape();
        setcolorsarray();
        setBounds(0, 0, 400, 600);
        setBackground(Color.black);
    }

    private void setshape() {
        for (int i = 0; i < 4; i++) {
            sblocky[i] = allshapesy[nowshape][rotation][i];
            sblockx[i] = allshapesx[nowshape][rotation][i];
        }
    }

    public void rotateshape() {
        System.out.println(rotation);
        clearpreviousshape();
        for (int i = 0; i < 4; i++) {

            sblockx[i] = allshapesx[nowshape][rotation][i];
            sblocky[i] = allshapesy[nowshape][rotation][i];

        }
    }

    private void initialpanelcolor() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                allcolor[i][j] = Color.black;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(allcolor[i][j]);
                g.fillRect(j * 40, i * 40, 40, 40);
            }
        }

    }

    public void gameloop() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("running");
            if (move) {
                moveshape();
            }

            if (move == false) {
                createblock();
            }

            setcolorsarray();

            repaint();

        }
    }

    private void createblock() {
        for (int i = 0; i < 4; i++) {
            if (sblocky[i] == allshapesy[nowshape][rotation][i] && allcolor[sblocky[i]][sblockx[i]] != Color.black) {
                lose = true;
            } else {
                lose = false;
            }
        }
        if (lose) {
            System.exit(0);
        }

        owncolor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        nowshape = r.nextInt(0, 7);
        for (int i = 0; i < 4; i++) {
            sblockx[i] = allshapesx[nowshape][rotation][i];
            sblocky[i] = allshapesy[nowshape][rotation][i];
        }
        move = true;
        repaint();
    }

    private void moveshape() {

        clearpreviousshape();

        for (int i = 0; i < 4; i++) {
            sblocky[i] += 1;
        }
    }

    private void clearpreviousshape() {

        for (int i = 0; i < 4; i++) {
            allcolor[sblocky[i]][sblockx[i]] = Color.black;
        }
    }

    private void setcolorsarray() {

        for (int i = 0; i < 4; i++) {

            allcolor[sblocky[i]][sblockx[i]] = owncolor;

        }

        for (int i = 0; i < 4; i++) {
            if (sblocky[i] == 14 || allcolor[sblocky[i] + 1][sblockx[i]] != (Color.black)
                    && allcolor[sblocky[i] + 1][sblockx[i]] != owncolor) {
                move = false;
                lose = false;
            }
            // else{
            // move=true;
            // }
        }

        // for(int i=0;i<=2;i++){
        // for(int j=3,k=0;j<=6 && k<4;j++,k++){
        // if(sblock[i][k]!=null){
        // allcolor[i][j]=sblock[i][k];
        // }
        // }
        // }
    }

}
