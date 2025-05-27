import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    private static final String DB_URL = "jdbc:sqlite:bank.db";
    
    // Create accounts table
    public void createAccountsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "account_number TEXT NOT NULL UNIQUE," +
                    "balance REAL NOT NULL)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.executeUpdate();
            System.out.println("Accounts table created successfully!");
        }
    }
    
    // Insert initial accounts
    public void insertInitialAccounts() throws SQLException {
        String sql = "INSERT INTO accounts (account_number, balance) VALUES (?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Insert two initial accounts
            pstmt.setString(1, "1234567890");
            pstmt.setDouble(2, 1000.0);
            pstmt.executeUpdate();
            
            pstmt.setString(1, "0987654321");
            pstmt.setDouble(2, 500.0);
            pstmt.executeUpdate();
            
            System.out.println("Initial accounts created successfully!");
        }
    }
    
    // Transfer money between accounts
    public boolean transferMoney(String fromAccount, String toAccount, double amount) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // Disable auto-commit
            conn.setAutoCommit(false);
            
            try {
                // 1. Debit from source account
                String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
                try (PreparedStatement debitStmt = conn.prepareStatement(debitSql)) {
                    debitStmt.setDouble(1, amount);
                    debitStmt.setString(2, fromAccount);
                    
                    int rowsAffected = debitStmt.executeUpdate();
                    if (rowsAffected == 0) {
                        throw new SQLException("Source account not found");
                    }
                }
                
                // 2. Credit to destination account
                String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
                try (PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {
                    creditStmt.setDouble(1, amount);
                    creditStmt.setString(2, toAccount);
                    
                    int rowsAffected = creditStmt.executeUpdate();
                    if (rowsAffected == 0) {
                        throw new SQLException("Destination account not found");
                    }
                }
                
                // Commit transaction if both operations succeed
                conn.commit();
                return true;
                
            } catch (SQLException e) {
                // Rollback transaction if any operation fails
                conn.rollback();
                throw e;
            } finally {
                // Re-enable auto-commit
                conn.setAutoCommit(true);
            }
        }
    }
    
    // Get account balance
    public Account getAccount(String accountNumber) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE account_number = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, accountNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setAccountNumber(rs.getString("account_number"));
                    account.setBalance(rs.getDouble("balance"));
                    return account;
                }
            }
        }
        
        return null;
    }
    
    // Get all accounts
    public void displayAllAccounts() throws SQLException {
        String sql = "SELECT * FROM accounts";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            System.out.println("\nAccounts List:");
            System.out.println("==============");
            
            while (rs.next()) {
                System.out.println("Account Number: " + rs.getString("account_number") +
                                 ", Balance: " + rs.getDouble("balance"));
            }
        }
    }
}
