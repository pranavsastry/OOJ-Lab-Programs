import java.util.Scanner;

class FactorialException extends Exception{
  int given_val;

  FactorialException(int entered_val){
    given_val = entered_val;
  }

  public String toString(){
    return "The entered number " + given_val + " is greater than 15";
  }
}

class Factorial{
  int given_val;

  Factorial(int entered_val) throws FactorialException{
    given_val = entered_val;
    if(given_val>15){
      throw new FactorialException(given_val);
    }
  }

  public int calcFact(int val){
    if(val==0){
      return 1;
    }
    else{
      return val*calcFact(val-1);
    }
  }
}

class FactExc{
  public static void main(String[] args){
    int data;
    int fact;
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the integer: ");
    data = getData.nextInt();
    try{
      Factorial factObj = new Factorial(data);
      fact = factObj.calcFact(data);
      System.out.println("Factorial object created!");
      System.out.println("Factorial of " + data + " is: " + fact);
    }
    catch(FactorialException f){
      System.out.println("Entered data exception! " + f);
    }
  }
}
