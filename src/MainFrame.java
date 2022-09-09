import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

public class MainFrame {//游戏主页面
    JFrame frame;
    JPanel contentPanel;
    JLabel bglabel;
    Client user;

    public MainFrame(Client cli ) {
        user=cli;
        this.initialize();
    }

    public void initialize() {
        frame = new JFrame();


        frame.setTitle("主页面");
        contentPanel = new JPanel();
        frame.setContentPane(contentPanel);
        contentPanel.setOpaque(false);
        ImageIcon background = new ImageIcon("res/背景.jpg");
        bglabel = new JLabel(background);
        bglabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        frame.getLayeredPane().add(bglabel, new Integer(Integer.MIN_VALUE));
        int w, h, W, H;//定位
        w = Toolkit.getDefaultToolkit().getScreenSize().width;
        h = Toolkit.getDefaultToolkit().getScreenSize().height;
        W = (w - background.getIconWidth()) / 2;
        H = (h - background.getIconHeight()) / 2;
        frame.setBounds(W, H, background.getIconWidth(), background.getIconHeight());
        frame.setResizable(false);
        contentPanel.setLayout(null);
        myButton begingame=new myButton("开始游戏");
        begingame.setFont(new Font("黑体",Font.BOLD,20));
        begingame.setBounds(130,200,150,50);
        myButton check=new myButton("排行榜");
        check.setFont(new Font("黑体",Font.BOLD,20));
        check.setBounds(130,260,150,50);
        myButton instruction=new myButton("游戏说明");
        instruction.setFont(new Font("黑体",Font.BOLD,20));
        instruction.setBounds(130,320,150,50);
        myButton exgame=new myButton("退出游戏");
        exgame.setFont(new Font("黑体",Font.BOLD,20));
        exgame.setBounds(130,380,150,50);
        begingame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new Game(user);

            }
        });
        instruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Instruction();
            }
        });
        exgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setVisible(false);
                    new Rank(user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPanel.add(begingame);
        contentPanel.add(check);
        contentPanel.add(instruction);
        contentPanel.add(exgame);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}