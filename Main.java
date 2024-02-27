package banksystem;


import java.util.*;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void waitUser(){
        println("Enter to back");
        scanner.nextLine();
    }
    public static void main(String[] args) {



        Account acc1= new PersonalAccount("عبد الرحمن أحمد", "877563", Bank.Currency.SAR);
        Account acc2=new PersonalAccount("فاطمة محمد", "747567", Bank.Currency.YR);
        Account acc3=new PersonalAccount("أحمد علي", "87438", Bank.Currency.SAR);
        Account acc4=new BusinessAccount("مؤسسة فخر للمقاولات", "2222201", Bank.Currency.SAR);
        Account acc5=new BusinessAccount("Store", "20200", Bank.Currency.USD);

        acc1.increaseBalance(500);
        acc2.increaseBalance(550);
        acc3.increaseBalance(100);
        acc5.increaseBalance(390);

        startActivity();

    }

    private static void startActivity() {
        println("......Welcome to BankSystem .....");
        int i;
        do {
       i = selectMenu(new ArrayList<>(List.of(new String[]{"Accounts", "Deposit", "Withdraw", "Transaction"})));
        switch (i) {
            case 1:
                startAccount();
                break;
            case 2:
                startDeposit();


                waitUser();
                break;
            case 3:
                startWithdraw();
                waitUser();
                break;
            case 4:
                startTransaction();
                waitUser();
                break;

            case 0:

                break;

        }
    }while (i!=-0);
    }

    private static void startAccount() {
        println("......Welcome to Accounts .....");
        int i;
        do {
            i = selectMenu(new ArrayList<>(List.of(new String[]{"New Account", "Account info", "List Account", "Account statement"})));
            switch (i) {
                case 1:
                    newAccount();
                    waitUser();
                    break;
                case 2:
                    Account account=searchAccount("Account");
                    println(Objects.requireNonNullElse(account, "No account found!!"));
                    waitUser();
                    break;
                case 3:
                    listAccount();
                    waitUser();
                    break;
                case 4:
                    accountStatement();
                    waitUser();
                    break;

                case 0:

                    break;

            }
        }while (i!=0);
    }

    private static void accountStatement() {


        Account account=searchAccount("Account");

        if(account!=null){
            Bank.Transactions.printAllTransaction(account);
        }else {
            println("No account found !!");
        }

        scanner.next();
        scanner.nextLine();

    }

    private static void listAccount() {

        Bank.Accounts.printAllAccounts();

    }

    private static Account searchAccount(String typeAccount ) {

        println("Enter name of "+typeAccount+" or Number of "+typeAccount+" :");
        Account account;
        try {
                int noAcc=scanner.nextInt();
               account= Bank.Accounts.searchAccount(noAcc);
        }catch (Exception ignored){
            account=Bank.Accounts.searchAccount(scanner.next()+scanner.nextLine());
        }


        return account;


    }

    private static void newAccount() {
        int i=selectMenu(new ArrayList<>(List.of(new String[]{"Personal Account", "Business Account"})));
        switch (i){
            case 1:
                newPacc();
                break;
            case 2:
                newBacc();
                break;

            case 0:
                break;
        }
    }


    private static void newBacc() {
        println("Enter business name : ");
        String nameBusiness=scanner.next()+scanner.nextLine();
        println("Enter licence number : ");
        String licenceNo=scanner.next();
        println("Enter currency (SAR,RY,USA) : ");
        Bank.Currency currency=Bank.Currency.valueOf(scanner.next());

        BusinessAccount account =Bank.Accounts.newBusinessAccount(nameBusiness,licenceNo,currency);

        println(account);
    }

    private static void newPacc() {

        println("Enter full name : ");
        String nameCustomer=scanner.next()+scanner.nextLine();
        println("Enter id number : ");
        String idNo=scanner.next();
        println("Enter currency (SAR,RY,USA) : ");
        Bank.Currency currency=Bank.Currency.valueOf(scanner.next());

        PersonalAccount account =Bank.Accounts.newPersonalAccount(nameCustomer,idNo,currency);

        println(account);
    }

    private static void startWithdraw() {
        Account account=searchAccount("Account");

        if(account!=null){

                print("amount : ");
                Withdraw withdraw=Bank.Transactions.withdraw(account,scanner.nextDouble());
                if(withdraw!=null)
                    withdraw.performTrans();
                println("no money enough !!");



        }
        else {
            println("no Account found");
        }


    }

    private static void startDeposit() {

        Account account=searchAccount("Account");

        if(account!=null){

                print("amount :");
                Deposit deposit=Bank.Transactions.deposit(account,scanner.nextDouble());
                deposit.performTrans();



        }
        else {
            println("no Account found");
        }

    }

    private static void startTransaction() {


        Account fromaccount=searchAccount("From Account");

        if(fromaccount!=null){

            Account toaccount=searchAccount("To Account");

            if(toaccount!=null) {
                if(fromaccount.getCurrency()!=toaccount.getCurrency()){
                    println("not matching currency");
                    return;
                }
                print("amount :");
                Transaction transaction = Bank.Transactions.transaction(fromaccount,toaccount, scanner.nextDouble());
                if(transaction!=null)
                transaction.performTrans();
                else println("no money enough!!");
            }else println("no Account found");


        }
        else {
            println("no Account found");
        }

    }

    private static int selectMenu(ArrayList<String> selectedList) {

        for (int i=0;i<selectedList.size();i++){
         println((i+1)+". "+selectedList.get(i));
            }
        println("----------------------------");
        return getNumberChoice(selectedList.size());
    }

    private static int getNumberChoice(int maxList) {
        do {
            print("Enter Your Choice (0 for Exit):");
            try {
               int i= Integer.parseInt(getInput());

                if(i<=maxList&&i>=0)
                     return i;
                println("Your input not correct");
            }catch (Exception ignored){

            }
        }while (true);

    }

    private static String getInput() {
        return scanner.next()+scanner.nextLine();
    }

    public static void println(Object object){

        System.out.println(object.toString());

    }
    public static void print(Object object){

        System.out.print(object.toString());

    }
}

