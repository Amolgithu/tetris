import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

public class nextshapepanel extends JPanel{

    private Color allcolor[][] = new Color[4][4];
    private controlpanel cpp;

    public nextshapepanel(controlpanel cp){ 
        cpp=cp;       
        setBounds(20, 20, 160, 160);
        // setBackground(Color.red);  
        // setcolor();

        // setcolortodefault();

    }
    
    private void setcolortodefault(){
        for(int i = 0; i<4;i++){
            for(int j=0; j<4;j++){
                allcolor[i][j]=Color.BLACK;
            }
        }
    }
    // private void setcolor() {
    //     System.out.println("nextshape");
        
    // }

    

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                g.setColor(allcolor[i][j]);
                g.fillRect(j*40, i*40, 40,40);
                // g.setColor(Color.orange);
                // g.drawRect(i*40, j*40, 40, 40);
            }
        }
        System.out.println("painted in next shape");

    }

    public void setcolorandshape(int shapex[],int shapey[],Color c,int shape,gamepanel gp) {

        System.out.println("shape : "+shape);
        System.out.println("color: "+c);

        // setcolortodefault();
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
               gp.allcolornextshape[i][j]=Color.black;
            }
        }

        for(int i = 0; i < 4; i++){

            System.out.print(shapex[i]);
            System.out.println(shapey[i]);

            gp.allcolornextshape[shapey[i]][shapex[i]-3]=c;

        }
        gp.repaintnext=true;
        // cpp.repaint();
        // gp.repaint();
    }
}
