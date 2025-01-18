import java.util.Scanner;
class BankAccount {
    private double Balance;
    public BankAccount(double initialBalance) {
        this.Balance = initialBalance;
    }
    public double getBalance() {
            return Balance;
        }
        public void deposit(double amount) {
            if( amount > 0) {
                Balance+= amount;
            System.out.printf("Deposited Successful! New Balance: $%.2f%n",Balance);
        }
            else {
                System.out.println("Invalid Deposit amount!");
            }
        }
        public boolean withdraw(double amount) {
            if(amount>0 && amount<=Balance){
                Balance-= amount;
                System.out.printf("Withdrawal Succesful! New Balance: $%.2f%n",Balance);
                return true;
            }
            else if(amount > Balance) {
                System.out.println("Insufficient Withdrawal amount!");
                return false;
            }
            else {
                System.out.println("Invalid Withdrawal amount!");
                return false;
            }
        } 
    }

class ATM {
    private BankAccount acc1;
    public ATM(BankAccount acc1) {
        this.acc1 = acc1;
    }
    public void Menu() {
        Scanner scan = new Scanner(System.in);
        int choice;
        do { 
            System.out.println("\n----ATM Interface----\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit ");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("\n---------------------\n");
            System.out.println("Enter Choice: ");
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Current Balance: $"+acc1.getBalance());
                    break;
                case 2:
                    System.out.println("Enter Deposit amount: ");
                    double depositAmount = scan.nextDouble();
                    acc1.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter Withdrawal amount: ");
                    double withdrawAmount = scan.nextDouble();
                    acc1.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting!....Thank you for using our ATM!");
                    break;
                    default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
         while (choice!= 4);
        scan.close();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);
        ATM atm = new ATM(myAccount);
        atm.Menu();
    }
}
