package banksystem;

public class Deposit extends Transaction {



    public Deposit(Account account,double transAmount) {
        super(account, transAmount);
    }


    @Override
    public boolean performTrans() {


        if(!this.isPerform())
        {

            super.getFromAccount().addTransaction(this);
            super.getFromAccount().increaseBalance(super.getTransAmount());
            super.setPerform(true);
            System.out.println(this);
        }
        return super.isPerform();
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "Deposit Id='" + super.getTransId() + '\'' +
                ", Deposit Date=" + super.getTransDate() +
                ", Deposit Account =" + super.getFromAccount().getNameAccount() +
                ", Deposit Amount=" + super.getTransAmount() +
                ", currency=" +super.getFromAccount().getCurrency()+
                '}';
    }
}
