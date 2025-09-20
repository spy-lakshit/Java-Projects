import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Account class
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited ₹" + amount);
        } else {
            System.out.println("⚠️ Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("✅ Withdrawn ₹" + amount);
        } else {
            System.out.println("⚠️ Insufficient balance or invalid amount!");
        }
    }

    public void displayInfo() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

// Banking system without database
public class BankingSystem {
    private static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Banking Menu ====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // flush
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.nextLine();
                    if (accounts.containsKey(accNum)) {
                        System.out.println("⚠️ Account already exists!");
                        break;
                    }
                    System.out.print("Enter Account Holder Name: ");
                    String holder = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    Account newAcc = new Account(accNum, holder, bal);
                    accounts.put(accNum, newAcc);
                    System.out.println("✅ Account created successfully!");
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    Account depAcc = accounts.get(accNum);
                    if (depAcc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double dep = sc.nextDouble();
                        depAcc.deposit(dep);
                    } else {
                        System.out.println("⚠️ Account not found!");
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    Account wdAcc = accounts.get(accNum);
                    if (wdAcc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double wd = sc.nextDouble();
                        wdAcc.withdraw(wd);
                    } else {
                        System.out.println("⚠️ Account not found!");
                    }
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    Account balAcc = accounts.get(accNum);
                    if (balAcc != null) {
                        System.out.println("💰 Current Balance: ₹" + balAcc.getBalance());
                    } else {
                        System.out.println("⚠️ Account not found!");
                    }
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    Account infoAcc = accounts.get(accNum);
                    if (infoAcc != null) {
                        infoAcc.displayInfo();
                    } else {
                        System.out.println("⚠️ Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("👋 Thank you for banking with us!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}
