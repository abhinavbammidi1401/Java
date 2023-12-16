interface BankInterface{
    double getBalance();
    double getInterestRate();
}

class BankA implements BankInterface{
    private double balance = 10000;
    private double interestRate = 0.07;

    //overriding the methods
    public double getBalance(){
        return balance;
    }

    public double getInterestRate(){
        return interestRate;
    }
}
class BankB implements BankInterface{
    private double balance = 150000;
    private double interestRate = 0.074;
    //overriding the methods
    public double getBalance(){
        return balance;
    }

    public double getInterestRate(){
        return interestRate;
    }
}
class BankC implements BankInterface{
    private double balance = 200000;
    private double interestRate = 0.079;
    //overriding them methods
    public double getBalance(){
        return balance;
    }
    public double getInterestRate(){
        return interestRate;
    }
}

public class lab5a{
    public static void main(String args[]){
        BankA bankA = new BankA();
        BankB bankB = new BankB();
        BankC bankC = new BankC();

        System.out.println("Bank A - Balance: Rs. " + bankA.getBalance() + ", Interest Rate: " + bankA.getInterestRate()*100 + "%");
        System.out.println("Bank B - Balance: Rs. " + bankB.getBalance() + ", Interest Rate: " + bankB.getInterestRate()*100 + "%");
        System.out.println("Bank C - Balance: Rs. " + bankC.getBalance() + ", Interest Rate: " + bankC.getInterestRate()*100 + "%");
    }
}