import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class rankDao  {
    rankCli[] r=new rankCli[3];


    public  rankCli[] getRankArray() throws SQLException {
        for(int i=0;i<3;i++){
            r[i]=new rankCli();
        }
        Connection conn = DButil.getCon();
        Statement stmt = conn.createStatement();
        String sql = "select id,score from userinfo order by score desc,id asc limit 3";
        ResultSet res = stmt.executeQuery(sql);
        int i=0;
        while (res.next()) {
            String forid=res.getString(1);
            r[i].id=forid;
            r[i].score=res.getInt(2);

            i++;
        }
        return r;
    }
    public static void main(String[]args) throws SQLException {
        rankDao t=new rankDao();
        t.getRankArray();
    }

}