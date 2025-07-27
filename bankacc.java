
// Base class
class Account {
    protected double balance;
    protected double interestRate;

    public Account(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
        System.out.println(this.getClass().getName() + " created with balance: " + balance);
    }

    public void calculateAndAddInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println(this.getClass().getName() + " Interest added with interest rate(" + interestRate + "): " + interest);
    }

    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

// Derived class for SavingsAccount
class SavingsAccount extends Account {
    public SavingsAccount(double balance, double interestRate) {
        super(balance, interestRate);
    }

    @Override
    public void calculateAndAddInterest() {
        interestRate = this.interestRate + 1; // Slightly higher interest rate for savings
        double interest = balance * interestRate / 100; // Slightly higher for savings
        balance += interest;
        System.out.println(this.getClass().getName() + " Interest added with interest rate(" + interestRate + "): " + interest);
    }
}

// Derived class for CurrentAccount
class CurrentAccount extends Account {
    public CurrentAccount(double balance, double interestRate) {
        super(balance, interestRate);
    }

    @Override
    public void calculateAndAddInterest() {
        interestRate = this.interestRate - 1;
        double interest = balance * interestRate / 100; // Slightly lower for current
        balance += interest;
        System.out.println(this.getClass().getName() + " Interest added with interest rate(" + interestRate + "): " + interest);
    }
}

// Test class with main method
public class bankacc {
    public static void main(String[] args) {
        final double INTEREST_RATE = 6.0; // Default interest rate
        Account acc = new Account(1000, INTEREST_RATE);
        acc.calculateAndAddInterest();
        acc.displayBalance();

        SavingsAccount savAcc = new SavingsAccount(2000, INTEREST_RATE);
        savAcc.calculateAndAddInterest();
        savAcc.displayBalance();

        CurrentAccount curAcc = new CurrentAccount(3000, INTEREST_RATE);
        curAcc.calculateAndAddInterest();
        curAcc.displayBalance();
    }
}
