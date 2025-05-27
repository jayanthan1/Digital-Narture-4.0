import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Basic JDBC Connection Example
 * This program demonstrates how to connect to a SQLite database,
 * create a table, insert data, and retrieve data using JDBC.
 */
public class JDBCConnection {
    
    // Database URL
    private static final String DB_URL = "jdbc:sqlite:students.db";
    
    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load JDBC driver: " + e.getMessage());
            return;
        }
        
        // Create connection, table and insert sample data
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            System.out.println("Connected to the database successfully!");
            
            // Create students table if it doesn't exist
            createStudentsTable(conn);
            
            // Insert sample data
            insertSampleData(conn);
            
            // Execute a SELECT query and print results
            retrieveAndPrintStudents(conn);
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
    
    /**
     * Creates the students table if it doesn't exist
     */
    private static void createStudentsTable(Connection conn) throws SQLException {
        String createTableSQL = 
            "CREATE TABLE IF NOT EXISTS students (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL, " +
            "age INTEGER, " +
            "gpa REAL)";
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Students table created or already exists.");
        }
    }
    
    /**
     * Inserts sample data into the students table
     */
    private static void insertSampleData(Connection conn) throws SQLException {
        // First check if data already exists
        String countSQL = "SELECT COUNT(*) FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(countSQL)) {
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Sample data already exists. Skipping insertion.");
                return;
            }
        }
        
        // Insert sample data
        String insertSQL = "INSERT INTO students (name, age, gpa) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // Student 1
            pstmt.setString(1, "John Smith");
            pstmt.setInt(2, 20);
            pstmt.setDouble(3, 3.8);
            pstmt.executeUpdate();
            
            // Student 2
            pstmt.setString(1, "Mary Johnson");
            pstmt.setInt(2, 22);
            pstmt.setDouble(3, 3.9);
            pstmt.executeUpdate();
            
            // Student 3
            pstmt.setString(1, "James Brown");
            pstmt.setInt(2, 19);
            pstmt.setDouble(3, 3.5);
            pstmt.executeUpdate();
            
            // Student 4
            pstmt.setString(1, "Patricia Davis");
            pstmt.setInt(2, 21);
            pstmt.setDouble(3, 4.0);
            pstmt.executeUpdate();
            
            System.out.println("Sample data inserted successfully.");
        }
    }
    
    /**
     * Retrieves and prints all students from the database
     */
    private static void retrieveAndPrintStudents(Connection conn) throws SQLException {
        String selectSQL = "SELECT id, name, age, gpa FROM students";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            
            System.out.println("\n----- STUDENT RECORDS -----");
            System.out.println("ID\tNAME\t\t\tAGE\tGPA");
            System.out.println("------------------------------------------");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double gpa = rs.getDouble("gpa");
                
                System.out.printf("%d\t%-20s\t%d\t%.2f%n", id, name, age, gpa);
            }
            
            System.out.println("------------------------------------------");
        }
    }
}
