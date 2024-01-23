
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;

public class tetris implements KeyListener, ActionListener{
    private JFrame f;
    private gamepanel game;


    public tetris() {
        System.out.println("yess 1");
        f = new JFrame("Tetris");

        f.setLayout(null);
        f.setSize(617, 639);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("yess 2");
        System.out.println("yess 3");
        setpanels();
        f.setContentPane(game);
        f.setFocusable(true);
        game.newgame.addActionListener(this);
        game.pause.addActionListener(this);
        game.resume.addActionListener(this);
        game.exitbutton.addActionListener(this);
        f.addKeyListener(this);


        System.out.println("yess 4");
        f.setVisible(true);
        game.gameloop();
    }

    private void setpanels() {
        
        game = new gamepanel(this);
        System.out.println("setpanels 1");
        game.setFocusable(true);
        game.requestFocus();


        f.add(game);

    }

    public static void main(String[] args) {
        System.out.println("yesss");
        tetris t =new tetris();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        // System.out.println("keypressed");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:

                if(game.maxy == 12){
                    break;
                }

                game.beforeroatation=game.rotation;
                // System.out.println("key pressed");
                if (game.rotation == 3) {
                    game.rotation = 0;
                } else {
                    game.rotation += 1;
                }
                game.rotateshape();
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                game.moveright();
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                game.moveleft();
                break;
            case KeyEvent.VK_SPACE:
            case KeyEvent.VK_DOWN:
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==game.newgame){
            // game.sblockx= new int[4];
            // game.sblocky= new int[4];

            // game = new gamepanel(this);
            game.lose=false;
            game.startinggamefromfirst();
            game.youlose.setVisible(false);

        }
        else if(e.getSource()==game.pause){
            game.pausegame=true;
            game.pause.setVisible(false);
            game.resume.setVisible(true);
        }
        else if(e.getSource()==game.resume){
            game.pausegame=false;
            game.resume.setVisible(false);
            game.pause.setVisible(true);
        }
        else if(e.getSource()==game.exitbutton){
            System.exit(0);
        }
        else{
        }


        f.requestFocus();
    }
}
