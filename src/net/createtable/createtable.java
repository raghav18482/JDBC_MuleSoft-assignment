import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createtable {

    public static void createNewTable() {
        // SQLite connection string  
        String url = "jdbc:sqlite:/C:\\SQLite\\sqlite-tools-win32-x86-3380500\\sqlite-tools-win32-x86-3380500\\movieDB.db";

        // SQL statement for creating a new table  
        String sql = "create table favmovies (movie_name varchar(40),actor_name varchar(40), actress_name varchar(40),yr_of_release INT,director_name varchar(40))";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        createNewTable();
    }

}  