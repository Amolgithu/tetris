import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class controlpanel extends JPanel{
    nextshapepanel shape = new nextshapepanel();
    public controlpanel(){
        setBounds(401,0,200,600);
        setBackground(Color.gray);
        add(shape);
    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 199, 599);
    }
      

}
