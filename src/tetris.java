import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class tetris{
    private JFrame f;
    private gamepanel game;
    public tetris(){
        f = new JFrame("Tetris");

        
        f.setLayout(null);
        f.setSize(600, 639);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        setpanels();
    }
    private void setpanels() {
        game= new gamepanel();

        f.add(game);
        game.gameloop();
    }
    public static void main(String[] args) {
        new tetris();
    }
}
