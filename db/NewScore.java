import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewScore {
        String name;
        public NewScore(Client cli){
            name=cli.getName();
        }
    public int newscore() throws SQLException {
        Connection conn=DButil.getCon();
        Statement stmt=conn.createStatement();
        String sql="select score from userinfo where id='"+name+"'";
        int i=0;
        ResultSet res=stmt.executeQuery(sql);
        while(res.next()){
            i=res.getInt(1);
        }
        return i;

    }
}
