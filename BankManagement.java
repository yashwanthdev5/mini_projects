import java.util.Scanner;

class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank_Managing bm = new Bank_Managing(sc);
        int accessing_while;
        int value;
        System.out.println("-------BANK MANGEMENT SYSTEM-----");
        do {
            System.out.println("<----------OPERATIONS---------->");
            System.out.println("1--> ACCOUNT CREATION ");
            System.out.println("2--> DEPOSIT AMOUNT");
            System.out.println("3--> WITHDRAWAL AMOUNT");
            System.out.println("4--> CHECK BALANCE ");
            System.out.println("5--> DISPLAY ACCOUNTS ");

            value = sc.nextInt();
            sc.nextLine();
            switch (value) {
                case 1:
                    // create Account
                    bm.createAccount();
                    break;
                case 2:
                    // deposit
                    bm.deposit();
                    break;
                case 3:
                    // withdrawal
                    bm.withdrawAmount();
                    break;
                case 4:
                    // check balance
                    bm.checkBalance();
                    break;
                case 5:
                    // display all accounts
                    bm.displayAllAccounts();
                    break;

                default:
                    System.out.println(" choose the operations above !!");
                    break;
            }
            System.out.println("Enter 1 to continue to use operations || enter 0 to terminate ");
            accessing_while = sc.nextInt();
        } while (accessing_while == 1);

    }

}

// bank class for all customer details
class Bank {
    private double balance;
    private int account_number;
    private String name;

    public void setAccountNumber(int account_number) {
        this.account_number = account_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return account_number;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    void display() {
        System.out.println("Name of Customer :" + name);
        System.out.println("Account Number :" + account_number);
    }

    void Account() {
        System.out.println("Name of Customer :" + name);
        System.out.println("Account Number :" + account_number);
        System.out.println("Balance :" + balance);
    }
}

// bank_managing class for managing customers
class Bank_Managing {
    Scanner sc;

    // using one scanner for the whole class
    Bank_Managing(Scanner sc) {
        this.sc = sc;
    }

    // Array of objects of bank accounts
    Bank[] banks = new Bank[100];

    String name;
    int account_number1;
    int count = 0;
    double balance = 0.0;
    double deposit_amount = 0;
    double withdraw_amount;

    // method for creating account....
    public void createAccount() {
        // created bank object b for adding new objects into the Array of objects
        Bank b = new Bank();
        while (true) {
            System.out.println("Enter the name : ");
            name = sc.nextLine();
            if (name.matches("[a-zA-Z ]+")) {
                break;
            }
            System.out.println("Other than Alphabets None are Allowed !!!");
        }
        // setting name
        b.setName(name);
        // setting intial balance
        b.setBalance(balance);

        while (true) {
            boolean id_exists = false;
            System.out.println("Enter the AcountNumber :");
            account_number1 = sc.nextInt();

            for (int i = 0; i < count; i++) {
                if (banks[i].getAccountNumber() == account_number1) {
                    id_exists = true;
                    break;
                }
            }
            if (id_exists) {
                System.out.println("Account Number Exists ..!");
                System.out.println("Enter a valid Account Number :");
                continue;
            } else {
                // setting account number
                b.setAccountNumber(account_number1);
                // adding object into the array
                banks[count] = b;
                banks[count].Account();
                // incrementing count to add objects at different indexes
                count++;
                break;
            }
        }

    }

    public void deposit() {
        System.out.println("Enter the Account Number :");
        account_number1 = sc.nextInt();
        boolean account_exist = false;
        for (int i = 0; i < count; i++) {
            if (banks[i].getAccountNumber() == account_number1) {
                while (true) {
                    System.out.println("Enter the Amount you want to deposit :");
                    deposit_amount = sc.nextDouble();
                    // deposit deposit_amount should be greater than 0
                    if (deposit_amount > 0) {
                        // get the intial balance of that account
                        balance = banks[i].getBalance();
                        // update the balance with deposit
                        balance = balance + deposit_amount;
                        // set the balance
                        banks[i].setBalance(balance);
                        System.out.println("Amount Deposited");
                        break;
                    }
                    System.out.println("Amount should be greater than 0");
                }
                // if account exist
                account_exist = true;
                break;
            }
        }

        if (!account_exist) {

            System.out.println("Account doestn't exist..!!!");
            System.out.println("DEPOSIT FAILED!!!!!!");
        }

    }

    public void checkBalance() {
        System.out.println("Enter the Account Number to check balance :");
        account_number1 = sc.nextInt();
        boolean account_exist = false;
        for (int i = 0; i < count; i++) {
            if (banks[i].getAccountNumber() == account_number1) {
                banks[i].Account();
                account_exist = true;
                break;
            }
        }
        if (!account_exist) {
            System.out.println("No account found!! with account number : " + account_number1);
        }
    }

    public void displayAllAccounts() {
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                banks[i].display();
            }
        } else {
            System.out.println("Account not created yet!");

        }
    }

    public void withdrawAmount() {
        System.out.println("Enter the Account Number to Withdraw :");
        account_number1 = sc.nextInt();
        boolean account_exist = false;
        for (int i = 0; i < count; i++) {
            if (banks[i].getAccountNumber() == account_number1) {
                balance = banks[i].getBalance();
                while (true) {
                    System.out.println("Enter the amount to withdraw :");
                    withdraw_amount = sc.nextDouble();
                    if (withdraw_amount > 0) {
                        break;
                    }
                    System.out.println("withdraw amount should be greater than 0");
                }

                if (withdraw_amount <= balance) {
                    balance = balance - withdraw_amount;
                    banks[i].setBalance(balance);
                } else {
                    System.out.println("Insufficient Balance !!! GET A JOB(JUST FOR FUN)");
                    System.out.println("OR");
                    System.out.println("CHECK THE BALANCE!!!!!!");
                }
                account_exist = true;
                break;
            }
        }
        if (!account_exist) {
            System.out.println("No account found!! with account number : " + account_number1);
        }
    }
}
