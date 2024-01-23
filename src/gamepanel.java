import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gamepanel extends JPanel {

    public int score=0;
    private Color allcolor[][] = new Color[20][10], owncolor, nextshapeColor;
    public Color allcolornextshape[][] = new Color[4][4];
    public nextshapepanel nextshapeshow;
    public controlpanel cp;
    Random r = new Random();

    public JButton newgame, pause, exitbutton, resume;
    public JLabel scoreview,youlose= new JLabel("You Lose");

    public int[][][] allshapesx = {
            { { 4, 5, 4, 5, 4 }, { 4, 5, 4, 5, 4 }, { 4, 5, 4, 5, 4 }, { 4, 5, 4, 5, 4 } },
            { { 3, 4, 5, 6, 3 }, { 4, 4, 4, 4, 4 }, { 3, 4, 5, 6, 3 }, { 4, 4, 4, 4, 4 } },
            { { 4, 5, 3, 4, 3 }, { 4, 4, 5, 5, 4 }, { 4, 5, 3, 4, 3 }, { 4, 4, 5, 5, 4 } },
            { { 3, 4, 4, 5, 3 }, { 4, 3, 4, 3, 3 }, { 3, 4, 4, 5, 3 }, { 4, 3, 4, 3, 3 } },
            { { 5, 3, 4, 5, 3 }, { 4, 4, 4, 5, 4 }, { 3, 4, 5, 3, 3 }, { 4, 5, 5, 5, 4 } },
            { { 3, 3, 4, 5, 3 }, { 4, 5, 4, 4, 4 }, { 3, 4, 5, 5, 3 }, { 5, 5, 4, 5, 4 } },
            { { 4, 3, 4, 5, 3 }, { 4, 4, 5, 4, 4 }, { 3, 4, 5, 4, 3 }, { 5, 4, 5, 5, 4 } }
    },
            allshapesy = {
                    { { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } },
                    { { 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0 }, { 0, 1, 2, 3 } },
                    { { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 } },
                    { { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 } },
                    { { 0, 1, 1, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, 1 }, { 0, 0, 1, 2 } },
                    { { 0, 1, 1, 1 }, { 0, 0, 1, 2 }, { 0, 0, 0, 1 }, { 0, 1, 2, 2 } },
                    { { 0, 1, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 0, 1 }, { 0, 1, 1, 2 } }
            };

    public int sblockx[] = new int[4], sblocky[] = new int[4];
    private boolean move = true, remove = true;
    public boolean repaintnext = false, pausegame = false,running=true,lose;
    private int nowshape, nextshape, difofx = 0;
    public int rotation = 0, beforeroatation, maxy, speed = 500;
    public tetris t;

    public gamepanel(tetris t) {
        this.t = t;
        cp = new controlpanel(this, t);
        nextshapeshow = new nextshapepanel();
        nowshape = r.nextInt(0, 7);
        nextshape = r.nextInt(0, 7);

        owncolor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        nextshapeColor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));

        setnextshape();

        initialpanelcolor();
        createblock();
        setshape();
        setcolorsarray();
        setLayout(null);
        setBounds(0, 0, 600, 600);
        setBackground(Color.black);
    }

    private void setnextshape() {
        System.out.println(nextshapeColor);
        nextshapeshow.setcolorandshape(allshapesx[nextshape][0], allshapesy[nextshape][0], nextshapeColor,
                nextshape, this);
    }

    private void setshape() {
        for (int i = 0; i < 4; i++) {
            sblocky[i] = allshapesy[nowshape][rotation][i];
            sblockx[i] = allshapesx[nowshape][rotation][i];
        }
    }

    public void rotateshape() {
        int topdiffscreen = sblocky[0] - allshapesy[nowshape][beforeroatation][0];

        boolean flag = false;

        System.out.println(rotation);
        clearpreviousshape();

        for (int i = 0; i < 4; i++) {
            if (allcolor[allshapesy[nowshape][rotation][i] + topdiffscreen][allshapesx[nowshape][rotation][i]
                    + difofx] == Color.black) {
                flag = true;
            } else {
                flag = false;
            }
        }

        if (flag) {
            for (int i = 0; i < 4; i++) {

                // previous[i]=sblocky[i];

                sblockx[i] = allshapesx[nowshape][rotation][i] + difofx;
                sblocky[i] = allshapesy[nowshape][rotation][i] + topdiffscreen;

            }
        }
        maxy = biggestone(sblocky);

    }

    public void initialpanelcolor() {

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

        g.fillRect(401, 0, 199, 600);
        g.setColor(Color.white);
        g.drawRect(420, 20, 160, 160);

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {

                g.setColor(allcolor[i][j]);
                g.fillRect(j * 40, i * 40, 40, 40);
                g.setColor(Color.WHITE);
                g.drawRect(j * 40, i * 40, 40, 40);
                if (allcolor[i][j] != Color.black) {
                    g.setColor(Color.WHITE);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.setColor(allcolornextshape[i][j]);
                g.fillRect((j * 40) + 420, (i * 40) + 20, 40, 40); // g.setColor(Color.orange);
                // g.drawRect(i*40, j*40, 40, 40);
                if (allcolornextshape[i][j] != Color.black) {
                    g.setColor(Color.WHITE);
                    g.drawRect((j * 40) + 420, (i * 40) + 20, 40, 40); // g.setColor(Color.orange);
                }
            }
        }

        if (repaintnext) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    g.setColor(Color.black);
                    g.fillRect((j * 40) + 420, (i * 40) + 20, 40, 40);

                    // g.setColor(allcolornextshape[i][j]);
                    // g.fillRect((j * 40) + 420, (i * 40) + 20, 40, 40);
                    // g.setColor(Color.orange);
                    // g.drawRect(i*40, j*40, 40, 40);
                }
            }
            repaintnext = false;
        }

    }

    public void gameloop() {
        while (true) {
            if(running){
                System.out.println("running");
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // System.out.println("running");
                if (move) {
                    moveshape();
                }
    
                // System.out.println("running");
    
                if (move == false) {
                    remove = true;
                    createblock();
                }
    
                setcolorsarray();
    
                redraw();
            }

        }
    }

    private void redraw() {
        if (pausegame==false) {
            repaint();
        }

    }

    private void checkScore() {
        boolean flag = false;
        // Vector<Integer> listofcomplet = new Vector<Integer>();

        // for(int i = 14; i >0; i++){
        // for
        // }

        for (int i = 14; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (allcolor[i][j] != Color.black) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                shiftblocks(i);
                i += 1;
            }
            flag = false;
        }
        // for (Integer object : listofcomplet) {
        // shiftblocks(object);
        // }
        scoreview.setText("Score : "+score);
    }

    private void shiftblocks(int start) {
        for (int i = start; i > 0; i--) {
            for (int j = 0; j < 10; j++) {
                allcolor[i][j] = allcolor[i - 1][j];
            }
        }

        score += 10;
        
    }

    private void createblock() {

        nowshape = nextshape;
        owncolor = nextshapeColor;

        checkScore();
        for (int i = 0; i < 4; i++) {
            if (sblocky[i] == allshapesy[nowshape][rotation][i] && allcolor[sblocky[i]][sblockx[i]] != Color.red) {
                lose = true;
            } else {
                lose = false;
            }
        }
        if (lose) {
            youlose.setVisible(true);
            running=false;
        }

        nextshapeColor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        nextshape = r.nextInt(0, 7);
        setnextshape();
        rotation = 0;
        for (int i = 0; i < 4; i++) {
            sblockx[i] = allshapesx[nowshape][rotation][i];
            sblocky[i] = allshapesy[nowshape][rotation][i];

        }
        difofx = 0;
        move = true;
        redraw();
    }

    private void moveshape() {

        if (pausegame==false) {
            clearpreviousshape();
            for (int i = 0; i < 4; i++) {
                sblocky[i] += 1;
            }
        }

        maxy = biggestone(sblocky);
    }

    private int biggestone(int[] x) {
        int bigest = x[0];

        for (int i = 0; i < 4; i++) {
            if (x[i] > bigest) {
                bigest = x[i];
            }
        }

        return bigest;
    }

    private void clearpreviousshape() {
        if (remove) {
            for (int i = 0; i < 4; i++) {
                allcolor[sblocky[i]][sblockx[i]] = Color.black;
            }

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
                remove = false;
                speed = 500;
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

    public void moveright() {
        difofx = smallestone(sblockx) - allshapesx[nowshape][rotation][4];
        if (pausegame==false) {
            clearpreviousshape();
            if (biggestone(sblockx) < 9 && checkthenextposition(1)) {
                for (int i = 0; i < 4; i++) {
                    sblockx[i] += 1;
                }
            }
        }
    }

    private int smallestone(int[] x) {

        int smallst = x[0];

        for (int i = 0; i < 4; i++) {
            if (x[i] < smallst) {
                smallst = x[i];
            }
        }

        return smallst;
    }

    public void moveleft() {

        difofx = smallestone(sblockx) - allshapesx[nowshape][rotation][4];
        if (pausegame==false) {
            clearpreviousshape();
            if (smallestone(sblockx) > 0 && checkthenextposition(-1)) {
                for (int i = 0; i < 4; i++) {
                    sblockx[i] -= 1;
                }
            }
        }

    }

    private boolean checkthenextposition(int op) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (allcolor[sblocky[i]][sblockx[i] + op] != Color.black
                    && allcolor[sblocky[i]][sblockx[i] + op] != owncolor) {
                flag = false;
                System.out.println("broke");
            }
        }
        return flag;
    }

    // private boolean checkbounds(int[] x, int[] y) {
    //     boolean flag = false;
    //     for (int i = 0; i < 4; i++) {
    //         if (allcolor[x[i]][y[i]] == Color.black) {
    //             flag = true;
    //         } else {
    //             flag = false;
    //         }
    //     }

    //     return flag;
    // }

    public void startinggamefromfirst() {
         running=true;
         remove=true;
         move=true;
         repaintnext = false;
         pausegame = false;

        nowshape = r.nextInt(0, 7);
        nextshape = r.nextInt(0, 7);
        score=0;      

        owncolor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        nextshapeColor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        initialpanelcolor();

        setnextshape();

        createblock();
        setshape();
        setcolorsarray();
        
        resume.doClick(1);
    }

}
