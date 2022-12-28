package model;

public class Group {
    private String name;
    private String link;
    private int id;
    private static int generateID=0;

    public Group(String name, String link) {
        id=generateID++;
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }
}
