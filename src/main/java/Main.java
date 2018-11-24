import dao.driver.JdbcManager;

public class Main {
    public static void main(String[] args) {
        JdbcManager.connection();
        System.out.println("true");
    }
}
