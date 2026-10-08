import java.util.Scanner;

class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: " + amount);
        } else {
            System.out.println("⚠️ Invalid deposit amount!");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: " + amount);
        } else {
            System.out.println("⚠️ Insufficient balance or invalid amount!");
        }
    }

    
    public double checkBalance() {
        return balance;
    }

    
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
            
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter Account Holder Name: ");
            String accName = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double initBalance = sc.nextDouble();

            BankAccount account = new BankAccount(accNo, accName, initBalance);

            
            System.out.print("\nEnter deposit amount: ");
            double depositAmt = sc.nextDouble();
            account.deposit(depositAmt);

            System.out.print("Enter withdrawal amount: ");
            double withdrawAmt = sc.nextDouble();
            account.withdraw(withdrawAmt);

             account.displayAccount();
        }
    }
}
