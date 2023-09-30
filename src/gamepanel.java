import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class gamepanel extends JPanel {

    private Color allcolor[][] = new Color[15][10];
    private Color sblock[][] = {{null,Color.red,Color.red,null},
                                {Color.red,Color.red,null,null},
                                {null,null,null,null}};
    // private int sblockx[] ={3,4,2,3};

    ArrayList<Integer> sblocky = new ArrayList<Integer>(2); 
    ArrayList<Integer> sblockx = new ArrayList<Integer>(4); 
     

    public gamepanel() {
        setcolorsarray();
        setarraylist();
        setBounds(0, 0, 400, 600);
        setBackground(Color.black);
    }

    private void setarraylist() {
        sblockx.add(3);
        sblockx.add(2);
        sblockx.add(4);
        sblockx.add(3);
        sblocky.add(0);
        sblocky.add(1);
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
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("running");
            
            moveshape();
            
            setcolorsarray();
            
            repaint();
            

        }
    }

    private void moveshape() {
        
    }
    
    private void setcolorsarray() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                allcolor[i][j]=Color.black;
            }
        }
        for (int i = 0; i < 15; i++) {
            if(sblocky.contains(i))
            for (int j = 0; j < 10; j++) {
                if(sblockx.contains(j)){
                    allcolor[i][j]=Color.red;
                }
            }
        }

        // for(int i=0;i<=2;i++){
        //     for(int j=3,k=0;j<=6 && k<4;j++,k++){
        //         if(sblock[i][k]!=null){
        //             allcolor[i][j]=sblock[i][k];
        //         }
        //     }
        // }
    }


}
