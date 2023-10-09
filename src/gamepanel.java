import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;

public class gamepanel extends JPanel {

    private Color allcolor[][] = new Color[20][10], owncolor,nextshapeColor;
    // private Color sblock[][] = { { null, Color.red, Color.red, null },
    // { Color.red, Color.red, null, null },
    // { null, null, null, null } };

    Random r = new Random();

    // private int[] differencex = new int[4], difference = new int[4];
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

    private int sblockx[] = new int[4], sblocky[] = new int[4];
    // private int sblockx[] = { 4, 5, 3, 4 }, sblocky[] = { 0, 0, 1, 1 };
    private boolean move = true, lose,remove=true;
    private int nowshape, nextshape, difofx = 0;
    public int rotation = 0, beforeroatation, maxy,score,speed=500;

    // ArrayList<Integer> sblocky = new ArrayList<Integer>(2);
    // ArrayList<Integer> sblockx = new ArrayList<Integer>(4);

    public gamepanel() {
        nowshape = r.nextInt(0, 7);
        nextshape= r.nextInt(0, 7);
        
        owncolor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        nextshapeColor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
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
        int topdiffscreen = sblocky[0] - allshapesy[nowshape][beforeroatation][0];

        int previous[] = new int[4];
        boolean flag = false;

        System.out.println(rotation);
        clearpreviousshape();

        for (int i = 0; i < 4; i++) {
            if (allcolor[allshapesy[nowshape][rotation][i] + topdiffscreen][allshapesx[nowshape][rotation][i]
                    + difofx] == Color.BLACK) {
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
                if(allcolor[i][j]!=Color.black){
                    g.setColor(Color.WHITE);
                    g.drawRect(j * 40, i * 40, 40, 40);
                }
            }
        }

    }

    public void gameloop() {
        while (true) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("running");
            if (move) {
                moveshape();
            }

            System.out.println("running");

            if (move == false) {
                remove=true;
                createblock();
            }

            setcolorsarray();



            repaint();

        }
    }

    private void checkScore() {
        boolean flag = false;
        Vector<Integer> listofcomplet = new Vector<Integer>();

        // for(int i = 14; i >0; i++){
        //     for
        // }

        for(int i=14;i>=0;i--){
            for(int j = 0; j<10; j++){
                if(allcolor[i][j]!=Color.black){
                    flag=true;
                }else{
                    flag= false;
                    break;
                }
            }
            if(flag){
                shiftblocks(i);
                i=14;
            }
            flag=false;
        }
        // for (Integer object : listofcomplet) {
        //     shiftblocks(object);
        // }
    }
    

    private void shiftblocks(int start) {
        for(int i = start; i>0; i--){
            for(int j = 0; j<10; j++){
                allcolor[i][j]=allcolor[i-1][j];
            }
        }
        
        score+=10;
    }

    private void createblock() {

        nowshape=nextshape;
        owncolor=nextshapeColor;

        checkScore();
        for (int i = 0; i < 4; i++) {
            if (sblocky[i] == allshapesy[nowshape][rotation][i] && allcolor[sblocky[i]][sblockx[i]] != Color.black ) {
                lose = true;
            } else {
                lose = false;
            }
        }
        if (lose) {
            System.exit(0);
        }

        nextshapeColor = new Color(r.nextInt(0, 255), r.nextInt(0, 255), r.nextInt(0, 255));
        nextshape = r.nextInt(0, 7);
        for (int i = 0; i < 4; i++) {
            sblockx[i] = allshapesx[nowshape][rotation][i];
            sblocky[i] = allshapesy[nowshape][rotation][i];

        }
        difofx = 0;
        move = true;
        repaint();
    }

    private void moveshape() {

        clearpreviousshape();

        for (int i = 0; i < 4; i++) {
            sblocky[i] += 1;
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
        if(remove){
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
                remove=false;
                speed=500;
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
        clearpreviousshape();
        // if (biggestone(sblockx) < 9) {
        //     for (int i = 0; i < 4; i++) {
        //         sblockx[i] += 1;
        //     }
        // }
        if (biggestone(sblockx) < 9 && checkthenextposition(1)) {
            for (int i = 0; i < 4; i++) {
                sblockx[i] += 1;
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
        clearpreviousshape();
        if (smallestone(sblockx) > 0 && checkthenextposition(-1)) {
            for (int i = 0; i < 4; i++) {
                sblockx[i] -= 1;
            }
        }

    }

    private boolean checkthenextposition(int op) {
        boolean flag = true;
            for(int i = 0; i < 4; i++){
                if(allcolor[sblocky[i]][sblockx[i]+op]!=Color.black && allcolor[sblocky[i]][sblockx[i]-1]!=owncolor){
                    flag=false;
                    System.out.println("broke");
                }
            }
        return flag;
    }

    private boolean checkbounds(int[] x, int[] y) {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (allcolor[x[i]][y[i]] == Color.BLACK) {
                flag = true;
            } else {
                flag = false;
            }
        }

        return flag;
    }

}
