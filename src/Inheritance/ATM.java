package Inheritance;

public class ATM {
    private String accountHoldername;

    private double balance;

    ATM(String accountHoldername, double balance) {
        this.accountHoldername = accountHoldername;
        this.balance = balance;
    }

    public static void main(String[] args) {
        ATM atm= new ATM("Raj", 10000);
        atm.showBalance();

    }
    void showBalance(){
        System.out.println("Balance is "+balance);
    }
}
