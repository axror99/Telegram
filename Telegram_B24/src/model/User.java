package model;

public class User {
    private boolean isGroupAdmin;
    private boolean isCanalAdmin;
     private int id;
    private boolean isInActive;
    private String name;
    private String username;


    private static int generationId=1;

    public User() {
        this.id=generationId++;
    }

    public User(boolean isGroupAdmin, boolean isCanalAdmin,  boolean isInActive, String name, String username) {
        this();
        this.isGroupAdmin = isGroupAdmin;
        this.isCanalAdmin = isCanalAdmin;
        this.isInActive = isInActive;
        this.name = name;
        this.username = username;
    }

    public boolean isInActive() {
        return isInActive;
    }

    public void setInActive(boolean inActive) {
        isInActive = inActive;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public boolean isGroupAdmin() {
        return isGroupAdmin;
    }

    public void setGroupAdmin(boolean groupAdmin) {
        isGroupAdmin = groupAdmin;
    }

    public boolean isCanalAdmin() {
        return isCanalAdmin;
    }

    public void setCanalAdmin(boolean canalAdmin) {
        isCanalAdmin = canalAdmin;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "User{" +
                "isGroupAdmin=" + isGroupAdmin +
                ", isCanalAdmin=" + isCanalAdmin +
                ", id=" + id +
                ", isInActive=" + isInActive +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}'+'\n';
    }
}
