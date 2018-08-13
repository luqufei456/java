package cn.yiran.web.domain;

public class GameUser {
    private int id;
    private String username;
    private String password;
    private int max_goal;
    private String email;
    private boolean activate;
    private int userLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMax_goal() {
        return max_goal;
    }

    public void setMax_goal(int max_goal) {
        this.max_goal = max_goal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "GameUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", max_goal=" + max_goal +
                ", email='" + email + '\'' +
                ", activate=" + activate +
                ", userLevel=" + userLevel +
                '}';
    }
}
