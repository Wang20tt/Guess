import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Rank {
    JFrame frame;
    JPanel contentPanel;
    JLabel bglabel;
    Client user;
     public Rank(Client cli) throws SQLException {
       user=cli;
       this.initialize();
    }
    public void initialize() throws SQLException {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setTitle("排行榜");
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
        rankCli[] r=new rankCli[3];
        rankDao rd=new rankDao();
        r=rd.getRankArray();
        String[] columnNames = {"排名", "id","分数"}; //标题行;

       Object[][] info={
                {
                    new Integer(1),r[0].id,r[0].score
                },
                {
                        new Integer(2),r[1].id,r[1].score
                },
                {
                        new Integer(3),r[2].id,r[2].score
                },

        };
        JTable table = new JTable(info,columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(280, 150));
        JTableHeader tab_header = table.getTableHeader();
        tab_header.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        table.setRowHeight(40);
        table.setEnabled(false);
        table.setBounds(80, 250, 280, 150);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(80, 250, 280, 150);
        contentPanel.add(jsp);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        jsp.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false);
        JLabel m1=new JLabel("我的分数："+new NewScore(user).newscore());
        m1.setBounds(80,180,100,50);
        contentPanel.add(m1);
        JButton ex=new JButton("返回");
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainFrame(user);
            }
        });
        ex.setBounds(150,450,100,50);
        contentPanel.add(ex);
        contentPanel.setLayout(null);
        frame.setVisible(true);
     }

}
