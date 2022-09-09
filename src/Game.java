import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;

public class Game {
    JFrame frame;
    JPanel contentPanel;
    JLabel bglabel;
    Client user;
    Guess one=new Guess();
    int []rnum=new int[4];


    public Game(Client cli){
        user=cli;
        this.initialize();
    }
    public void initialize(){
        frame=new JFrame();

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setTitle("游戏");
        contentPanel=new JPanel();
        frame.setContentPane(contentPanel);
        contentPanel.setOpaque(false);
        ImageIcon background =new ImageIcon("res/背景.jpg");
        bglabel=new JLabel(background);
        bglabel.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
        frame.getLayeredPane().add(bglabel,new Integer(Integer.MIN_VALUE));
        int w,h,W,H;//定位
        w=Toolkit.getDefaultToolkit().getScreenSize().width;
        h=Toolkit.getDefaultToolkit().getScreenSize().height;
        W=(w-background.getIconWidth())/2;
        H=(h-background.getIconHeight())/2;
        frame.setBounds(W,H,background.getIconWidth(),background.getIconHeight());
        frame.setResizable(false);
        contentPanel.setLayout(null);
        JLabel tip=new JLabel("请填写你所猜的四位数字");
        JLabel tip2=new JLabel("（提示：这四位数字不会重复！）");
        tip.setFont(new Font("黑体",Font.BOLD,15));
        tip2.setFont(new Font("黑体",Font.PLAIN,13));
        tip.setBounds(120,150,200,50);
        tip2.setBounds(110,170,200,50);
        contentPanel.add(tip);
        contentPanel.add(tip2);
        rnum=one.randNumber(rnum);
        JTextField input=new JTextField();
        input.setColumns(4);
        input.setBounds(80,210,200,50);
        contentPanel.add(input);
        JButton ensure=new JButton("提交");
        ensure.setBounds(278,210,50,50);
        contentPanel.add(ensure);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(78,270,250,200);
        contentPanel.add(textArea);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(78, 270, 250, 200);
        scrollPane.setViewportView(textArea);
        contentPanel.add(scrollPane);
        JButton ei=new JButton("退出");
        ei.setBounds(180,470,40,40);
        ei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainFrame(user);
            }
        });
        contentPanel.add(ei);
        ensure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str=input.getText();
                Result r=new Result();

                String s="";
                if(str.length()==4&&str.matches("^[0-9]+(.[0-9]+)?$")){

                        int []gnum=new int[4];
                        gnum=one.guess(str);
                        r=one.compare(rnum,gnum,user);
                        textArea.append(r.sr+"\n");
                        textArea.paintImmediately(textArea.getBounds());


                }
                if (r.ir) {
                    updateScore u=new updateScore(user);
                    try {
                        u.updatescore();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    int echo=JOptionPane.showConfirmDialog(null, "是否再来一局", "再来一局", JOptionPane.YES_NO_OPTION);
if(echo==0){
    frame.setVisible(false);
    new Game(user);
}else{
    frame.setVisible(false);
    new MainFrame(user);
}
                }

            }
        });

        frame.setVisible(true);
    }

}
