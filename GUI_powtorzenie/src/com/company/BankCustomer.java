package com.company;

public class BankCustomer {
    private Account account;
    private Person person;

    BankCustomer(Person person){
        this.person = person;
        this.account = new Account();
    }

    public Account getAccount() {
        return account;
    }

   public String toString(){
        return "Klient: " + this.person + " stan konta " + account;
   }
}
