import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstinDao {
    String name;
    String pwd;
    public FirstinDao(Client cli){
        name=cli.getName();
        pwd=cli.getPassword();
    }
    public boolean userinsql() throws Exception{//传入数据库
        Connection conn=DButil.getCon();
        Statement stmt= conn.createStatement();

        String sql1="select * from userinfo where id='"+name+"'";
        ResultSet rs1=stmt.executeQuery(sql1);
        if(rs1.next()){
            return false;

        }else{
            String sql2="insert into userinfo values('"+name+"','"+pwd+"',0)";
            stmt.executeUpdate(sql2);


            return true;

        }


    }
}
