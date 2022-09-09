import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    String name;
    String pwd;
    public LoginDao(Client cli){
       name=cli.getName();
       pwd=cli.getPassword();
    }
    public boolean islogin() throws SQLException {
        Connection conn=DButil.getCon();
        Statement stmt=conn.createStatement();
        String sql="select * from userinfo where id = '"+name+"' and passwords = '"+pwd+"'";
        ResultSet res=stmt.executeQuery(sql);
        if(res.next()){
            return true;
        }else{
            return false;
        }
    }
}
