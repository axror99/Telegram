package model;

public class Base {
   private int Id;
    private String name;
   private String userName;
    private boolean isInActive;

    public Base() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isInActive() {
        return isInActive;
    }

    public void setInActive(boolean inActive) {
        isInActive = inActive;
    }
}
