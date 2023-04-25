import java.sql.*;
public class DataBase {
    private static DataBase database;
    private static final String URL =
            "jdbc:postgresql://localhost:5432/Lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "stefan1212";
    private static Connection connection = null;

    private DataBase() {
        createConnection();
    }

    public static DataBase getInstance() {
        if (database == null) {
            database = new DataBase();
        }
        return database;
    }
    public static Connection getConnection() {
        return connection;
    }

    private static void createConnection() {
        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
