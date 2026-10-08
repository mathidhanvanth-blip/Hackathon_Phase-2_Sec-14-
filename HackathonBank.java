import java.util.Scanner;

class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    // Parameterized constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: " + amount);
        } else {
            System.out.println("⚠️ Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: " + amount);
        } else {
            System.out.println("⚠️ Insufficient balance or invalid amount!");
        }
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    // Display account details
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

public class HackathonBank {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Input account details
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter Account Holder Name: ");
            String accName = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double initBalance = sc.nextDouble();

            // Create account object
            BankAccount account = new BankAccount(accNo, accName, initBalance);

            // Perform operations
            System.out.print("\nEnter deposit amount: ");
            double depositAmt = sc.nextDouble();
            account.deposit(depositAmt);

            System.out.print("Enter withdrawal amount: ");
            double withdrawAmt = sc.nextDouble();
            account.withdraw(withdrawAmt);

            // Final account details
            account.displayAccount();
        }
    }
}
