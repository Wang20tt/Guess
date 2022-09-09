import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class updateScore {
    String name;

    public updateScore(Client cli){
        name=cli.getName();

    }
    public void updatescore() throws SQLException {
        Connection conn=DButil.getCon();
        Statement stmt=conn.createStatement();
        String sql="update userinfo set score=score+1 where id='"+name+"'";
        stmt.execute(sql);

    }

}


