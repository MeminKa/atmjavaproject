package atmpackage;


import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int pinNumber;

    private double checkingBalance;
    private double savingBalance;

    Scanner scan= new Scanner(System.in);
    DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00");


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

//    calculate checking balance after withdraw
    private double calculateCheckingBalanceAfterWithdraw(double amount){
            //1000                         200
        checkingBalance = checkingBalance-amount;//When user wants to withdraw money, their balance will be updated
                 //800
        return checkingBalance;
    }
//    calculate checking balance after deposit
    private double calculateCheckingBalanceAfterDeposit( double amount){
            //800                         500
        checkingBalance= checkingBalance+amount;
                    //1300
        return checkingBalance;
    }
    //    calculate saving balance after withdraw
    private double calculateSavingBalanceAfterWithdraw(double amount){
            //500                       100
        savingBalance = savingBalance-amount;
                //400
        return savingBalance;
    }
    //    calculate saving balance after deposit
    private double calculateSavingBalanceAfterDeposit( double amount){
            //400                     400
        savingBalance= savingBalance+amount;
                //800
        return savingBalance;
    }

//    Interact with user to withdraw money from checking account
    public void getCheckingWithdraw(){
        System.out.println("Your checking balance : "+ moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you would like to withdraw : ");
        double amount= scan.nextDouble();

        if(amount <=0){
            System.out.println("Negative or Zero amount is not acceptable!");
            getCheckingWithdraw();
        }else if(checkingBalance >= amount){
            calculateCheckingBalanceAfterWithdraw(amount);
            System.out.println("Your checking balance : "+ moneyFormat.format(checkingBalance));
        }else {
            System.out.println("You do not have enough money on your checking account");
        }
   }
//        Interact with customer to deposit money to their checking account
    public void getCheckingDeposit(){
        System.out.println("Your checking balance : "+ moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you would like to deposit : ");
    double amount= scan.nextDouble();

        if(amount <=0){
            System.out.println("Negative or Zero amount is not acceptable!");
            getCheckingDeposit();
        }else {
            calculateCheckingBalanceAfterDeposit(amount);
            System.out.println("Your checking balance : "+ moneyFormat.format(checkingBalance));
        }

    }

    //    Interact with user to withdraw money from saving account
    public void getSavingWithdraw(){
        System.out.println("Your saving balance : "+ moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you would like to withdraw : ");
        double amount= scan.nextDouble();

        if(amount <=0){
            System.out.println("Negative or Zero amount is not acceptable!");
            getSavingWithdraw();
        }else if(savingBalance >= amount){
            calculateSavingBalanceAfterWithdraw(amount);
            System.out.println("Your saving balance : "+ moneyFormat.format(savingBalance));
        }else {
            System.out.println("You do not have enough money on your saving account");
        }
    }
    //        Interact with customer to deposit money to their saving account
    public void getSavingDeposit(){
        System.out.println("Your saving balance : "+ moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you would like to deposit : ");
        double amount= scan.nextDouble();

        if(amount <=0){
            System.out.println("Negative or Zero amount is not acceptable!");
            getSavingDeposit();
        }else {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println("Your saving balance : "+ moneyFormat.format(savingBalance));
        }
    }
}
