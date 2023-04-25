import junit.jupiter.api.*;
import java.sql.*;



class TestDB {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/Lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "stefan1212";

    private DataBase database;

    @BeforeEach
    void setUp() {
        database = DataBase.getInstance();
    }

    @AfterEach
    void tearDown() throws SQLException {
        DataBase.closeConnection();
    }

    @Test
    void testGetInstance() {
        assertNotNull(database);
        assertSame(database, DataBase.getInstance());
    }

    @Test
    void testGetConnection() {
        Connection connection = DataBase.getConnection();
        assertNotNull(connection);
        assertSame(connection, DataBase.getConnection());
    }

    @Test
    void testCloseConnection() throws SQLException {
        Connection connection = DataBase.getConnection();
        assertFalse(connection.isClosed());
        DataBase.closeConnection();
        assertTrue(connection.isClosed());
    }

}