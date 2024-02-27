package banksystem;

public class Withdraw extends Transaction{

    public Withdraw(Account account,  double amount){
        super(account,amount);
    }

    @Override
    public boolean performTrans() {


        if(!this.isPerform()&&super.getFromAccount().getBalance()>=super.getTransAmount())
        {

            super.getFromAccount().addTransaction(this);
            super.getFromAccount().decreaseBalance(super.getTransAmount());
            super.setPerform(true);
            System.out.println(this);

        }
        return super.isPerform();
    }
    @Override
    public String toString() {
        return "Withdraw{" +
                "Withdraw Id='" + super.getTransId() + '\'' +
                ", Withdraw Date=" + super.getTransDate() +
                ", Withdraw Account =" + super.getFromAccount().getNameAccount() +
                ", Withdraw Amount=" + super.getTransAmount() +
                ", currency=" +super.getFromAccount().getCurrency()+

                '}';
    }

}
