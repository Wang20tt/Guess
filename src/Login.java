
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login {
    private JFrame frame;
    private JPanel contentPanel;
    private JLabel bglabel;
    private JLabel uname;
    private JLabel upasswords;
    private JTextField tuname;
    private JPasswordField tupasswords;
    private JButton login;
    private JButton firstin;
    private JButton ending;

    public Login() {
        this.initialize();
    }
    public static void main(String args[]) {
        Login login=new Login();
    }
    public void initialize() {
        frame=new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("登录");
        contentPanel=new JPanel();
        frame.setContentPane(contentPanel);
        contentPanel.setOpaque(false);
        ImageIcon background =new ImageIcon("res/主页面.jpg");
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
        //设置输入
        contentPanel.setLayout(null);
        uname=new JLabel("ID：");
        upasswords=new JLabel("密码：");
        uname.setBounds(90,280,50,50);
        uname.setFont(new Font("黑体",Font.BOLD,20));
        upasswords.setBounds(90,350,100,50);
        upasswords.setFont(new Font("黑体",Font.BOLD,20));
        contentPanel.add(upasswords);
        contentPanel.add(uname);
        //文本框
        tuname=new JTextField();
        tuname.setBounds(150,280,150,50);
        tuname.setColumns(10);
        tuname.setBackground(new Color(255,215,0));
        tuname.setBorder(new LineBorder(Color.BLACK));
        contentPanel.add(tuname);
        tupasswords=new JPasswordField();
        tupasswords.setBounds(150,350,150,50);
        tupasswords.setBackground(new Color(255,215,0));
        tupasswords.setBorder(new LineBorder(Color.BLACK));
        contentPanel.add(tupasswords);
        login=new JButton("登录");
        firstin=new JButton("注册");
        ending=new JButton("退出");
        login.setBounds(85,420,75,50);
        login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String N = tuname.getText();
                String P = String.valueOf(tupasswords.getPassword());
                if (N.length() == 10  && N.matches("^[0-9]+(.[0-9]+)?$")&&P.length() > 0 && P.length() <= 15) {
                    Client cnew = new Client(N, P);
                    try {
                        if (new LoginDao(cnew).islogin()) {
                            JOptionPane.showMessageDialog(null, "登录成功！");
                            new MainFrame(cnew);
                           frame.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "id或密码错误！");
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }else{

                    JOptionPane.showMessageDialog(null, "格式错误！");

                }
            }
        });
        firstin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               new Firstin();
               frame.setVisible(false);
            }
        });
        firstin.setBounds(165,420,75,50);
        firstin.setBackground(new Color(255,215,0));
        ending.setBounds(245,420,75,50);
        ending.setBackground(new Color(255,215,0));
        ending.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        contentPanel.add(login);
        contentPanel.add(firstin);
        contentPanel.add(ending);
        frame.setVisible(true);

    }


}
