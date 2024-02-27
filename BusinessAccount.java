package banksystem;

public class BusinessAccount extends Account{

    private String nameBusiness;
    private String licenceNo;
    public BusinessAccount(String nameBusiness, String licenceNo, Bank.Currency currency) {
        super(currency,0.0,Bank.AccountType.Business,nameBusiness);
        this.nameBusiness=nameBusiness;
        this.licenceNo=licenceNo;
    }

    public String getNameBusiness() {
        return nameBusiness;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    @Override
    public String toString() {
        return "BusinessAccount [" +
                "Account number="+super.getAccNo()+'\''+
                "nameBusiness='" + nameBusiness + '\'' +
                ", licenceNo=" + licenceNo +'\''+
                ", Balance="+super.getBalance()+'\''+
                ", Currency="+super.getCurrency()+
                " ]";
    }
}
