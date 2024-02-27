package banksystem;

public class PersonalAccount extends Account{

    private String nameCustomer;
    private String idNo;
    public PersonalAccount(String nameCustomer , String idNo, Bank.Currency currency) {
        super(currency,0.0,Bank.AccountType.Personal,nameCustomer);
        this.nameCustomer=nameCustomer;
        this.idNo=idNo;

    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public String  getIdNo() {
        return idNo;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "Account number="+super.getAccNo()+'\''+
                "nameCustomer='" + nameCustomer + '\'' +
                ", idNo=" + idNo +'\''+
                ", Balance="+super.getBalance()+'\''+
                ", Currency="+super.getCurrency()+
                '}';
    }
}
