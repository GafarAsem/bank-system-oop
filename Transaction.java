package banksystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Transaction  {

    private final String transId;
    private final LocalDate transDate;
    private final LocalTime transTime;

    private final Account fromAccount;
    private final Account toAccount;

    private boolean perform;

    private final double transAmount;

    public Transaction( Account fromAccount, Account toAccount, double transAmount)
    {
        //initial variebles
        this.transId = UUID.randomUUID().toString();
        this.transDate = LocalDate.now();
        this.transTime = LocalTime.now();
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transAmount = transAmount;
        //add trans to list
        Bank.transactions.add(this);
        this.perform =false;
        //change on accounts



    }
    public Transaction( Account fromAccount,  double transAmount)
    {
        //initial variebles
        this.transId = UUID.randomUUID().toString();
        this.transDate = LocalDate.now();
        this.transTime = LocalTime.now();
        this.fromAccount = fromAccount;
        this.toAccount = null;
        this.transAmount = transAmount;
        //add trans to list
        Bank.transactions.add(this);
        this.perform =false;
        //change on accounts



    }

    public boolean performTrans() {


        if(!this.isPerform()&&this.fromAccount.getBalance()>=this.transAmount)
        {

            this.fromAccount.addTransaction(this);
            this.toAccount.addTransaction(this);
            this.fromAccount.decreaseBalance(transAmount);
            this.toAccount.increaseBalance(transAmount);
            this.setPerform(true);
            System.out.println(this);
            return this.perform;
        }else return this.isPerform();
    }

    public boolean isPerform() {
        return perform;
    }

    public void setPerform(boolean perform) {

        if(perform && !this.perform)
        {
            if(this.getFromAccount().getTransactions().contains(this)) {
                this.perform = true;
            }
        }

    }

    public String getTransId() {
        return transId;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public LocalTime getTransTime() {
        return transTime;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public double getTransAmount() {
        return transAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId='" + transId + '\'' +
                ", transDate=" + transDate +
                ", fromAccount=" + fromAccount.getNameAccount() +
                ", toAccount=" + toAccount.getNameAccount() +
                ", transAmount=" + transAmount +
                ", currency=" +fromAccount.getCurrency()+

                '}';
    }
}
