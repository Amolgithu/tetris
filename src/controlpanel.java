import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class controlpanel {

    public gamepanel gp;
    private int buttony=300;

    public controlpanel(gamepanel gp,tetris t){
        this.gp=gp;

        Icon newgameicon = new ImageIcon(t.getClass().getResource("/res/newgamebutton.png"));
        gp.newgame = new JButton(newgameicon);
        gp.newgame.setBounds(417, buttony  , 167, 40);

        Icon Pauseicon = new ImageIcon(t.getClass().getResource("/res/pausebutton.png"));
        gp.pause = new JButton(Pauseicon);
        gp.pause.setBounds(417, buttony+60  , 167, 40);
        
        Icon resumeicon = new ImageIcon(t.getClass().getResource("/res/resumebutton.png"));
        gp.resume = new JButton(resumeicon);
        gp.resume.setBounds(417, buttony+60  , 167, 40);
        gp.resume.setVisible(false);

        Icon exiticon = new ImageIcon(t.getClass().getResource("/res/exitbutton.png"));
        gp.exitbutton = new JButton(exiticon);
        gp.exitbutton.setBounds(417, buttony +120 , 167, 40);

        gp.scoreview= new JLabel("Score : "+gp.score);
        gp.scoreview.setBounds(420, 200, 160, 100);
        // gp.scoreview.setFont(new Font("Arcadia", , buttony));buttony
        // gp.scoreview.setBackground(Color.black);
        gp.scoreview.setFont(new Font("Monospaced", Font.PLAIN, 20));
        // gp.scoreview.setVerticalAlignment(SwingConstants.CENTER);
        // gp.scoreview.setHorizontalAlignment(SwingConstants.CENTER);
        // gp.scoreview.setFont(new );
        gp.scoreview.setForeground(Color.white);
        
        gp.youlose.setFont(new Font("Monospaced", Font.BOLD, 50));
        gp.youlose.setHorizontalAlignment(SwingConstants.CENTER);
        gp.youlose.setBounds(0, 275, 400, 50);
        gp.youlose.setForeground(Color.gray);
        gp.youlose.setVisible(false);


        gp.add(gp.youlose);
        gp.add(gp.scoreview);
        gp.add(gp.newgame);
        gp.add(gp.pause);
        gp.add(gp.exitbutton);
        gp.add(gp.resume);
        

    } 

}
