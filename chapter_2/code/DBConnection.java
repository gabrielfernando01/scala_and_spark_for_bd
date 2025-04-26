
public class DBConnection {
    private static DBConnection dbInstance;
    private DBConnection() {
    }
    public static DBConnection getInstance() {
        if (dbInstance == null) {
            dbInstance = new DBConnection();
        }
        return dbInstance;
    }
}

