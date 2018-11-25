package dao.entity;

public class Entity {
    private int id;
    private String content;

    public Entity() {
    }

    public Entity(String content) {
        this.content = content;
    }

    public Entity(int id, String name) {
        this(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
