import java.util.Scanner;

public class ATM {

    // Simulated account data
    private static String USER_ID = "user123";
    private static String PIN = "1234";
    private static double balance = 10000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login process
        System.out.println("===== Welcome to the ATM System =====");

        System.out.print("Enter User ID: ");
        String inputUser = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        if (authenticateUser(inputUser, inputPin)) {
            System.out.println("\nLogin successful.\n");
            showMenu(scanner);
        } else {
            System.out.println("\nInvalid credentials. Access denied.");
        }

        scanner.close();
    }

    private static boolean authenticateUser(String user, String pin) {
        return user.equals(USER_ID) && pin.equals(PIN);
    }

    private static void showMenu(Scanner scanner) {
        int option;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }

        } while (option != 4);
    }

    private static void checkBalance() {
        System.out.printf("Current Balance: ₹%.2f\n", balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully. New Balance: ₹%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully. Remaining Balance: ₹%.2f\n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount.");
        }
    }
}
