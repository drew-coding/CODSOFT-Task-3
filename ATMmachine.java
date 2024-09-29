import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        } else {
			return false;
		}
    }
}

// Class to represent the ATM machine
public class ATMmachine {

    private BankAccount account;  //object of BankAccount class
	Scanner scanobj = new Scanner(System.in);

	public static void main(String[] args) {

        BankAccount account = new BankAccount(2000);   // Hardcoded initial Balance
        ATMmachine atmobj = new ATMmachine(account);
        atmobj.work();
    }

    public ATMmachine(BankAccount account) {
        this.account = account;
    }

    public void work() {
        while (true) {
			try{
				System.out.println("----- Welcome User -----");
				System.out.println();
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Exit");
				System.out.print("Choose an option: ");
				int option = Integer.parseInt(scanobj.nextLine());

				switch (option) {
					case 1:
						checkBalance();
						break;
					case 2:
						deposit();
						break;
					case 3:
						withdraw();
						break;
					case 4:
						System.out.println("Exiting...");
						System.out.println();
						return;
					default:
						System.out.println("Invalid option. Please try again.");
						System.out.println();
				}

			} catch(Exception ex){
				System.out.println("Only Numerical values are allowed !");
			}
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanobj.nextLine());
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
			System.out.println();
        } else {
            System.out.println("Insufficient balance.");
			System.out.println();
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanobj.nextLine());
        account.deposit(amount);
        System.out.println("Deposit successful.");
		System.out.println();
    }

    private void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
		System.out.println();
    }
}
