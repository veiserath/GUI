package com.company;

public class Account {
    double balance;
    static double interestRate;

    Account(){

        this.balance = 0;
    }

    public void deposit(double depositAmount){
        if (depositAmount > 0){
            this.balance += depositAmount;
        }
        else {
            System.out.println("Błędna wartość depozytu!");
        }

    }
    public void withdraw(double withdrawAmount){
        if (withdrawAmount > 0 && withdrawAmount < this.balance){
            this.balance -= withdrawAmount;
        }
        else {
            System.out.println("Błędna wartość wypłaty! Sprawdź czy masz środki na koncie i czy wypłacasz prawidłową wartość.");
        }

    }
    public void transfer(Account account, double transferAmount){
        if (transferAmount < this.balance && transferAmount > 0){
            this.balance -= transferAmount;
            account.balance += transferAmount;
        }
        else {
            System.out.println("Błędna wartość przelewu! Sprawdź czy masz środki na koncie i czy przelewasz prawidłową wartość.");
        }

    }
    public void addInterest(){
        this.balance += this.balance*Account.interestRate/100;
    }


    public static void setInterestRate(double interestRate){
        Account.interestRate = interestRate;
    }

    public String toString(){
        return "" + this.balance;
    }
}
