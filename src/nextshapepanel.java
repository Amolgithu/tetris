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

    }

    public void setcolorandshape(int shapex[],int shapey[],Color c,int shape) {

        System.out.println("shape : "+shape);
        System.out.println("color: "+c);

        // setcolortodefault();
        
        for(int i = 0; i < 4; i++){

            System.out.print(shapex[i]);
            System.out.println(shapey[i]);

            allcolor[shapey[i]][shapex[i]-3]=c;



        }
        repaint();
        cpp.repaint();
    }
}
