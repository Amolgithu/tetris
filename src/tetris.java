
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;

public class tetris implements KeyListener {
    private JFrame f;
    private gamepanel game;
    private controlpanel controls;

    public tetris() {
        System.out.println("yess 1");
        f = new JFrame("Tetris");

        f.setLayout(null);
        f.setSize(617, 639);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("yess 2");
        f.addKeyListener(this);
        System.out.println("yess 3");
        setpanels();
        System.out.println("yess 4");
        f.setVisible(true);
        game.gameloop();
    }

    private void setpanels() {
        
        game = new gamepanel();
        controls = new controlpanel();
        System.out.println("setpanels 1");

        f.add(controls);
        f.add(game);
        // f.getContentPane().add(controls);
        // f.getContentPane().add(game);
    }

    public static void main(String[] args) {
        tetris t =new tetris();
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

                if(game.maxy == 12){
                    break;
                }

                game.beforeroatation=game.rotation;
                System.out.println("key pressed");
                if (game.rotation == 3) {
                    game.rotation = 0;
                } else {
                    game.rotation += 1;
                }
                game.rotateshape();
                break;
            case KeyEvent.VK_D:
                game.moveright();
                break;
            case KeyEvent.VK_A:
                game.moveleft();
                break;
            case KeyEvent.VK_SPACE:
                game.speed=100;
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
