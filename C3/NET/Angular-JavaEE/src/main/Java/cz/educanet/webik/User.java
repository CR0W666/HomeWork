package cz.educanet.webik;

public class User {
    private String username, password, accessLevel;
    private int id;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
         this.id = id;
    }

    public String getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", id=" + id +
                '}';
    }
}

