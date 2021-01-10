package sample.model;

import javafx.collections.ObservableList;
import sample.utils.*;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String isAdmin;

    //constructor
    public User() { }

    public User(int id, String name) {
        setId(id);
        setName(name);
    }

    public User(String username, String password) {
        setUsername(username);
        setPassword(password)
    }

    public User(int id, String name, String isAdmin) {
        setId(id);
        setName(name);
        setIsAdmin(isAdmin);
    }

    public User(int id, String name, String username, String password, String isAdmin) {
        setId(id);
        setName(name);
        setUsername(username);
        setPassword(password);
        setIsAdmin(isAdmin);
    }

    //setter
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setIsAdmin(String isAdmin) { this.isAdmin = isAdmin; }

    //getter
    public int getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getIsAdmin() { return isAdmin; }

    public Login() {
        DBConnector dbOperator = new DBConnector();

    }
}

