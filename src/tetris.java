import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class tetris implements KeyListener{
    private JFrame f;
    private gamepanel game;
    public tetris(){
        f = new JFrame("Tetris");

        
        f.setLayout(null);
        f.setSize(600, 639);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.addKeyListener(this);
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
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            System.out.println("key pressed");
            if(game.rotation==3){
                game.rotation=0;
            }else{
                game.rotation+=1;
            }
                game.rotateshape();
                break;
        
            default:
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}
