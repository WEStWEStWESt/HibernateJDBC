package dao.entity;

public class Users extends Entity{

    public Users() {
    }

    public Users(String name) {
        super(name);
    }

    public Users(int id, String name) {
        super(id, name);
    }

    public String getName() {
        return getContent();
    }

    public void setName(String name) {
        setContent(name);
    }

    @Override
    public String toString() {
        return getContent();
    }
}
