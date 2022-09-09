import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
    private  static String jdbcName="com.mysql.cj.jdbc.Driver";
    private  static String url="jdbc:mysql://localhost:3306/Guess";
    private  static String name="root";
    private  static String pwd="wangsql123";
    private  static Connection conn;

    public  static  Connection getCon() {
        try {
            Class.forName(jdbcName);
            conn = DriverManager.getConnection(url, name, pwd);
        }catch(Exception e){
            System.out.println("Error loading Mysql Driver!");
            e.printStackTrace();
        }
        return conn;
    }
    public static  void closeCon() {
        try {
            if (conn != null) {
                conn.close();
            }
        }catch(Exception e){
            System.out.println("Error closing Mysql!");
        }
    }

}
