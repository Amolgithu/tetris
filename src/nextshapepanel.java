import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class nextshapepanel extends JPanel{

    private Color allcolor[][] = new Color[4][4];

    public nextshapepanel(){
        setcolor();
        setBounds(20, 20, 160, 160);
        setBackground(Color.red);  
    }

    private void setcolor() {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; i++){
            //to do
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

    }
}
