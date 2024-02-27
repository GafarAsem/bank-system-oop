package banksystem;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Bank {

    enum AccountType{Personal, Fund, Business}
    ArrayList<Account> accounts=new ArrayList<>();
    ArrayList<Transaction> transactions=new ArrayList<>();
    enum Currency {SAR, YR,USD}
  public abstract class Transactions{
      public static Deposit deposit(Account account,double transAmount){

              return new Deposit(account,transAmount);
      }

      public static Withdraw withdraw(Account account,  double transAmount){
          if(account.getBalance()>=transAmount){
              return new Withdraw(account,transAmount);
          }
          return null;
      }
      public static Transaction transaction(Account fromAccount, Account toAccount, double transAmount){
          if(fromAccount.getBalance()>=transAmount){
              return new Transaction(fromAccount,toAccount,transAmount);
          }
          return null;
      }
      public static void printAllTransaction(Account account){
         LinkedList<Transaction> transactionAccount= account.getTransactions();

          for (Transaction trans:
                transactionAccount) {
              System.out.println(trans);
          }

      }
  }
  public abstract class Accounts{
        public static PersonalAccount newPersonalAccount(String nameCustomer,String idNo,Currency currency){

            return new PersonalAccount(nameCustomer,idNo,currency);
        }

        public static BusinessAccount newBusinessAccount(String nameBusiness,String licenceNo,Currency currency){
            return new BusinessAccount(nameBusiness,licenceNo,currency);
        }


        public static Account searchAccount(String nameAccount){

            for (Account acc:
                    accounts ) {
                if(acc.getNameAccount().equals(nameAccount))
                    return acc;
            }
            return null;

        }
        public static Account searchAccount(int accNo){

            for (Account acc:
                    accounts ) {
                if(acc.getAccNo()==accNo)
                    return acc;
            }
            return null;

        }

        public static void printAllAccounts(){

            for (Account acc:
                accounts
            ) {

                System.out.println(acc);

            }
        }

    }



}
