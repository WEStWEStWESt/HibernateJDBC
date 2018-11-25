package dao.entity;

public class Users {

    private int id;
    private String name;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public Users(int id, String name) {
        this(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
