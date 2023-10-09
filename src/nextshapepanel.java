import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;

public class nextshapepanel extends JPanel{

    private Color allcolor[][] = new Color[4][4];

    public nextshapepanel(){        
        setBounds(20, 20, 160, 160);
        setBackground(Color.red);  
        // setcolor();
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
                g.fillRect(i*40, i*40, j*40, j*40);
            }
        }

    }

    public void setcolorandshape(int shapex[],int shapey[],Color c) {
        
        for(int i = 0; i < 4; i++){
            allcolor[shapey[i]+1][shapex[i]-3]=c;
        }
        repaint();
    }
}
