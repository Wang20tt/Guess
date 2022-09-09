


public class Client {
    private String name;
    private String password;
    private int score;

    public Client(String name, String password) {
        this.name = name;
        this.password = password;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
