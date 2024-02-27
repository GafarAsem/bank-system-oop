package banksystem;

import java.util.LinkedList;

public abstract class Account {
    private final int accNo;
    private Double balance;
    private final Bank.Currency currency;
    private final Bank.AccountType accountType;
    private final LinkedList<Transaction> transactions;
    private final String nameAccount;
    public Account(Bank.Currency currency,Double balanceOpening,Bank.AccountType accountType,String nameAccount) {
        this.accNo =1001+Bank.accounts.size();
        this.balance = balanceOpening;
        this.currency=currency;
        this.transactions = new LinkedList<>();
        this.accountType=accountType;
        this.nameAccount=nameAccount;

        Bank.accounts.add(this);
    }
    public Account(Bank.AccountType accountType,String nameAccount) {
        this.accNo =1001+Bank.accounts.size();
        this.balance = 0.0;
        this.currency=Bank.Currency.YR;
        this.transactions = new LinkedList<>();
        this.accountType=accountType;
        this.nameAccount=nameAccount;

        Bank.accounts.add(this);
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public Bank.AccountType getAccountType() {
        return accountType;
    }

    public Bank.Currency getCurrency() {
        return currency;
    }

    public int getAccNo() {
        return accNo;
    }

    public void increaseBalance(double amount){

        this.balance+=amount;

    }
    public void decreaseBalance(double amount){

        if(this.balance>=amount)
        this.balance-=amount;
        else System.out.println("no money in account!..");

    }
    public Double getBalance() {
        return this.balance;
    }

    public LinkedList<Transaction> getTransactions() {
        return this.transactions;
    }
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
    public boolean isEnoughBalance(double amount){
        return this.balance>=amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNo=" + accNo +
                ", nameAccount='" + nameAccount + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}
