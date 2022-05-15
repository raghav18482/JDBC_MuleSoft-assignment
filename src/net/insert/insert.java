import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class insert {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/C:\\SQLite\\sqlite-tools-win32-x86-3380500\\sqlite-tools-win32-x86-3380500\\movieDB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String movie_name, String actor_name, String actress_name,Integer yr_of_release, String director_name) {
        String sql = "INSERT INTO favmovies(movie_name,actor_name, actress_name,yr_of_release,director_name) VALUES(?,?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movie_name);
            pstmt.setString(2, actor_name);
            pstmt.setString(3, actress_name);
            pstmt.setInt(4, yr_of_release);
            pstmt.setString(5, director_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter fav movie name- ");
        String a= sc.nextLine();
        System.out.print("Enter name of actor- ");
        String b= sc.nextLine();
        System.out.print("Enter name of actress- ");
        String c= sc.nextLine();
        System.out.print("Enter relaease year of movie - ");
        int d= sc.nextInt();
        System.out.print("Enter name of director- ");
        String e= sc.nextLine();
        insert app = new insert();
        // insert three new rows
        app.insert(a,b,c,d,e);
//        app.insert("Aryan", 30000);
//        app.insert("Robert", 40000);
//        app.insert("Jerry", 50000);
    }

}
