import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class controlpanel {

    public gamepanel gp;

    public controlpanel(gamepanel gp,tetris t){
        this.gp=gp;

        Icon newgameicon = new ImageIcon(t.getClass().getResource("/res/newgamebutton.png"));
        gp.newgame = new JButton(newgameicon);
        gp.newgame.setBounds(417, 200  , 167, 40);

        Icon Pauseicon = new ImageIcon(t.getClass().getResource("/res/pausebutton.png"));
        gp.pause = new JButton(Pauseicon);
        gp.pause.setBounds(417, 260  , 167, 40);
        
        Icon resumeicon = new ImageIcon(t.getClass().getResource("/res/resumebutton.png"));
        gp.resume = new JButton(resumeicon);
        gp.resume.setBounds(417, 260  , 167, 40);
        gp.resume.setVisible(false);

        Icon exiticon = new ImageIcon(t.getClass().getResource("/res/exitbutton.png"));
        gp.exitbutton = new JButton(exiticon);
        gp.exitbutton.setBounds(417, 320  , 167, 40);

        gp.newgame.addActionListener(t);
        gp.pause.addActionListener(t);
        gp.resume.addActionListener(t);
        gp.exitbutton.addActionListener(t);

        gp.add(gp.newgame);
        gp.add(gp.pause);
        gp.add(gp.exitbutton);
        gp.add(gp.resume);

    } 

}
