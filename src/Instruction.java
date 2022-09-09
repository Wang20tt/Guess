import javax.swing.*;
import java.awt.*;

public class Instruction {
    JFrame frame;
    JPanel contentPanel;
    JLabel bglabel;
    public Instruction(){
        this.initialize();
    }
    public void initialize() {
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setTitle("游戏");
        contentPanel = new JPanel();
        frame.setContentPane(contentPanel);
        contentPanel.setOpaque(false);
        ImageIcon background = new ImageIcon("res/说明.jpg");
        bglabel = new JLabel(background);
        bglabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        frame.getLayeredPane().add(bglabel, new Integer(Integer.MIN_VALUE));
        int w, h, W, H;//定位
        w = Toolkit.getDefaultToolkit().getScreenSize().width;
        h = Toolkit.getDefaultToolkit().getScreenSize().height;
        W = (w - background.getIconWidth()) / 2;
        H = (h - background.getIconHeight()) / 2;
        frame.setBounds(W+500, H, background.getIconWidth(), background.getIconHeight());
        frame.setResizable(false);
        contentPanel.setLayout(null);
        frame.setVisible(true);
    }

}
