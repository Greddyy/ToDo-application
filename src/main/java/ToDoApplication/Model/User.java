package ToDoApplication.Model;


import java.time.LocalDateTime;

public class User {
    private short id;
    private String name;
    private String pasword;
    private String email;
    private boolean isAdmin;

    public User(short id, String name, String pasword, String email, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.pasword = pasword;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public User(String name, String pasword, String email, boolean isAdmin) {
        this.name = name;
        this.pasword = pasword;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    //    private boolean isAdmin;


}
