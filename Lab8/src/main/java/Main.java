import java.io.IOException;
import java.nio.file.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {

        try {

            // creating singleton instance
            DataBase.getInstance();

            Statement stmt = DataBase.getConnection().createStatement();

            // reading and executing the sql script
            String script = new String(Files.readAllBytes(Paths.get("tables.sql")));
            stmt.execute(script);

            stmt.close();

            // adding entries in artists table
            ArtistDAO artists = new ArtistDAO();
            artists.create("Queen");
            artists.create("Slipknot");


            DataBase.closeConnection();
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}