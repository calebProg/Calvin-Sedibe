package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BibleVerse {
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Update with your DB details
    private static final String USERNAME = "system"; // Replace with your DB username
    private static final String PASSWORD = "hack3r";
     // Replace with your DB password
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void insertVerse(String topic, String reference, String message, String date) throws SQLException {
        String sql = "INSERT INTO BIBLEVERSES(topic, reference, message, date_of_input) VALUES(?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, topic);
            statement.setString(2, reference);
            statement.setString(3, message);
            statement.setString(4, date);
            statement.executeUpdate();
        }
    }

    public static void deleteVerse(String topic) throws SQLException {

        String sqlDelete = "DELETE FROM BIBLEVERSES WHERE LOWER(topic) = LOWER(?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlDelete)) {
            statement.setString(1, topic);
            statement.executeUpdate();
        }
    }

}
