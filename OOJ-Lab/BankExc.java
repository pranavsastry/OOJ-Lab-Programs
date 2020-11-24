import java.util.Scanner;

class NegativeBalanceException extends Exception{
  double given_bal;

  NegativeBalanceException(double given_val){
    given_bal = given_val;
  }

  public String toString(){
    return "The balance in your account " + given_bal + " is negative! Balance cannot be negative!";
  }
}

class WithdrawalException extends Exception{
  double given_val;

  WithdrawalException(double entered_val){
    given_val = entered_val;
  }

  public String toString(){
    return "The entered amount " + given_val + " is greater than the balance in your account!";
  }
}

class Account{
  double balance;

  Account(double given_val) throws NegativeBalanceException{
    balance = given_val;
    if(balance<0){
      throw new NegativeBalanceException(balance);
    }
  }

  void deposit(double val) throws NegativeBalanceException{
    if(balance+val<0){
      throw new NegativeBalanceException(balance+val);
    }
    balance += val;
  }

  void withdraw(double val) throws WithdrawalException{
    if(val>balance){
      throw new WithdrawalException(val);
    }
    balance -= val;
  }

  void display(){
    System.out.println("The balance in your account is: " + balance);
  }
}

class BankExc{
  public static void main(String[] args){
    int operation;
    double amount;
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the initial balance in your account: ");
    try{
      Account accObj = new Account(getData.nextDouble());
      System.out.println("Enter the operation(0:Deposit,1:Withdraw,2:Display,3:Terminate): ");
      operation = getData.nextInt();
      while(operation!=3){
        switch(operation){
          case 0:
            System.out.println("Enter the amount to be deposited: ");
            amount = getData.nextDouble();
            try{
              accObj.deposit(amount);
              System.out.println("Amount deposited!");
            }
            catch(NegativeBalanceException b){
              System.out.println(b);
            }
            break;
          case 1:
            System.out.println("Enter the amount to be withdrawn: ");
            amount = getData.nextDouble();
            try{
              accObj.withdraw(amount);
              System.out.println("Amount withdrawn!");
            }
            catch(WithdrawalException c){
              System.out.println(c);
            }
            break;
          case 2:
            accObj.display();
            break;
          default:
            break;
        }
        System.out.println("Enter the operation(0:Deposit,1:Withdraw,2:Display,3:Terminate): ");
        operation = getData.nextInt();
      }
    }
    catch(NegativeBalanceException n){
      System.out.println("Negative Balance Exception! " + n);
    }
  }
}
