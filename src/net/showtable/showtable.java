package net.createdb;
import java.sql.*;


public class showtable {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:/C:\\SQLite\\sqlite-tools-win32-x86-3380500\\sqlite-tools-win32-x86-3380500\\movieDB.db";
        try{
            Connection connection = DriverManager.getConnection(jdbcUrl);
            String sql = "SELECT * FROM favmovies";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                String movie_name = result.getString("movie_name");
                String actor_name = result.getString("actor_name");
                String actress_name = result.getString("actress_name");
                Integer yr_of_release = result.getInt("yr_of_release");
                String director_name = result.getString("director_name");

                System.out.println(movie_name + " | " + actor_name + " | " + actress_name + " | " + yr_of_release + " | " + director_name);
            }
        } catch (SQLException e) {
            System.out.println("error connecting to sqlite database");
            e.printStackTrace();
        }

    }
}

