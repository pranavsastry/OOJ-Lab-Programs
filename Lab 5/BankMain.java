import java.lang.Math;
import java.util.Scanner;

class Bank{
  double min_balance,service_charge;
  boolean provides_chq_book,provides_wdrawal,provides_interest;

}

abstract class Account extends Bank{
  String name;
  Long account_num;
  String account_type;
  double account_balance;

  Account(String your_name,Long your_account_num,String your_account_type){
    this.name = your_name;
    this.account_num = your_account_num;
    this.account_type = your_account_type;
    this.account_balance = 0;
  }

  public double depositCash(double your_cash){
    this.account_balance += your_cash;
    return this.account_balance;
  }

  public double withdrawCash(double cash_reqd){
    if(cash_reqd>this.account_balance){
      System.out.println("Cash to be withdrawn is greater than the balance in your account!");
    }
    else{
      this.account_balance -= cash_reqd;
    }
    return this.account_balance;
  }

  public void displayBalance(){
    System.out.println("ACCOUNT BALANCE: " + this.account_balance);
  }

  abstract boolean checkMinBalance();

  abstract double calcInterest(boolean print_interest);

  abstract double depositInterest();
}

class SavingsAccount extends Account{
  double min_balance = 0;
  double service_charge = 0;
  boolean provides_interest = true;
  boolean provides_wdrawal = true;
  boolean provides_chq_book = false;

  SavingsAccount(String your_name,Long your_account_num,String your_account_type){
    super(your_name,your_account_num,your_account_type);
  }

  boolean checkMinBalance(){
    System.out.println("No minimum balance required!");
    return true;
  }

  double calcInterest(boolean print_interest){
    double rate = 5;
    double time = 10;
    double interest = (this.account_balance*Math.pow((1+(rate/100)),(time))) - this.account_balance;
    if(print_interest==true){
      System.out.println("Interest on your balance is: " + interest);
    }
    return interest;
  }

  double depositInterest(){
    double calculated_interest = calcInterest(false);
    this.account_balance += calculated_interest;
    return this.account_balance;
  }
}

class CurrentAccount extends Account{
  double service_charge = 50;
  double min_balance = 1000;
  boolean provides_interest = false;
  boolean provides_wdrawal = true;
  boolean provides_chq_book = true;

  CurrentAccount(String your_name,Long your_account_num,String your_account_type){
    super(your_name,your_account_num,your_account_type);
  }

  boolean checkMinBalance(){
    if(this.account_balance<min_balance){
      System.out.println("Your balance is lower than the minimum balance! A service fee of Rs 50 will be levied!");
      this.account_balance -= service_charge;
      return false;
    }
    else{
      return true;
    }
  }

  double calcInterest(boolean print_interest){
    if(print_interest==true){
      System.out.println("Interest facility is not provided for Curent Account.");
    }
    return 0.0;
  }

  double depositInterest(){
    System.out.println("Interest facility is not provided for Curent Account.");
    return this.account_balance;
  }
}

class BankMain{
  public static void main(String[] args){
    String temp_name,temp_type;
    Long temp_num;
    int operation;
    Scanner getData = new Scanner(System.in);
    System.out.println("\n***** ACCOUNT *****\n");
    System.out.println("Name: ");
    temp_name = getData.nextLine();
    System.out.println("Account Type: ");
    temp_type = getData.next();
    System.out.println("Account Number: ");
    temp_num = getData.nextLong();
    Account new_account;
    if(temp_type.equals("SAVINGS")){
      new_account = new SavingsAccount(temp_name,temp_num,temp_type);
    }
    else{
      new_account = new CurrentAccount(temp_name,temp_num,temp_type);
    }
    System.out.println("Enter the type of transaction(0:Deposit,1:Withdraw,2:Display,3:Check Balance,4:Calc Interest,5:Deposit Interest,6:Terminate): ");
    operation = getData.nextInt();
    while(operation!=6){
      switch(operation){
        case 0:
          System.out.println("Enter the amount to be deposited: ");
          new_account.depositCash(getData.nextDouble());
          break;
        case 1:
          System.out.println("Enter the amount to be withdrawn: ");
          new_account.withdrawCash(getData.nextDouble());
          break;
        case 2:
          new_account.displayBalance();
          break;
        case 3:
          new_account.checkMinBalance();
          break;
        case 4:
          new_account.calcInterest(true);
          break;
        case 5:
          new_account.depositInterest();
          break;
        default:
          System.out.println("Invalid operation! Try again!");
          break;
      }
      System.out.println("Enter the type of transaction(0:Deposit,1:Withdraw,2:Display,3:Check Balance,4:Calc Interest,5:Deposit Interest,6:Terminate): ");
      operation = getData.nextInt();
    }
  }
}
