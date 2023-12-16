import java.util.Scanner;

//Bankinterface
interface BankInterface{
    double getBalance();
    double getInterestRate();
}

//bank A
class BankA implements BankInterface{
    private double balance;

    //constructor
    public BankA(double depositAmount){
        this.balance = depositAmount;
    }

    @Override
    public double getBalance(){
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 0.07;
    }
}

//bank B
class BankB implements BankInterface{
    private double balance;

    //constuctor
    public BankB(double depositAmount){
        this.balance = depositAmount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate(){
        return 0.074;
    }
}

//bank C
class BankC implements BankInterface{
    private double balance;

    //constuctor
    public BankC(double depositAmount){
        this.balance = depositAmount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate(){
        return 0.079;
    }
}

public class lab5a{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get deposit amount
        System.out.print("Enter deposit amount for Bank A: ");
        double depositA = scanner.nextDouble();
        BankA bankA = new BankA(depositA);

        System.out.print("Enter deposit amount for Bank B: ");
        double depositB = scanner.nextDouble();
        BankB bankB = new BankB(depositB);

        System.out.print("Enter deposit amount for Bank C: ");
        double depositC = scanner.nextDouble();
        BankC bankC = new BankC(depositC);

        //display the balance and interest rates for each bank
        System.out.println("\nBank A - Balance: Rs. " +bankA.getBalance()+", Interest Rate: "+bankA.getInterestRate() * 100 + "%");
        System.out.println("\nBank B - Balance: Rs. " +bankB.getBalance()+", Interest Rate: "+bankB.getInterestRate() * 100 + "%");
        System.out.println("\nBank C - Balance: Rs. " +bankC.getBalance()+", Interest Rate: "+bankC.getInterestRate() * 100 + "%");

        scanner.close();
    }
}