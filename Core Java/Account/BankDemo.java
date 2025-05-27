public class BankDemo {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        
        try {
            // Create accounts table and insert initial data
            accountDAO.createAccountsTable();
            accountDAO.insertInitialAccounts();
            
            // Display initial balances
            System.out.println("Initial Account Balances:");
            accountDAO.displayAllAccounts();
            
            // Perform a successful transfer
            double transferAmount = 200.0;
            String fromAccount = "1234567890";
            String toAccount = "0987654321";
            
            try {
                boolean success = accountDAO.transferMoney(fromAccount, toAccount, transferAmount);
                if (success) {
                    System.out.println("\nTransfer successful!");
                    System.out.println("Transferred " + transferAmount + " from " + fromAccount + " to " + toAccount);
                    
                    // Display updated balances
                    System.out.println("\nUpdated Account Balances:");
                    accountDAO.displayAllAccounts();
                }
            } catch (SQLException e) {
                System.out.println("\nTransfer failed: " + e.getMessage());
                System.out.println("Transaction rolled back. No changes made.");
            }
            
            // Demonstrate rollback with invalid transfer
            try {
                // Attempt to transfer more than available balance
                double invalidAmount = 1500.0;
                System.out.println("\nAttempting invalid transfer...");
                accountDAO.transferMoney(fromAccount, toAccount, invalidAmount);
            } catch (SQLException e) {
                System.out.println("\nInvalid transfer failed: " + e.getMessage());
                System.out.println("Transaction rolled back. No changes made.");
                
                // Display balances to show no changes
                System.out.println("\nAccount Balances after invalid transfer attempt:");
                accountDAO.displayAllAccounts();
            }
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
