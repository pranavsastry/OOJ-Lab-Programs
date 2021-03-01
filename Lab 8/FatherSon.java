import java.util.Scanner;

class AgeException extends Exception{
  int age_difference;

  AgeException(int fathers_age,int sons_age){
    age_difference = fathers_age - sons_age;
  }

  public String toString(){
    return "The age difference between the father and son is " + age_difference + ". The ages aren't appropriate";
  }
}

class WrongAgeException extends Exception{
  int entered_age;

  WrongAgeException(int given_age){
    entered_age = given_age;
  }

  public String toString(){
    return "The entered age " + entered_age + " is less than 0. Age cannot be negative!";
  }
}

class Father{
  int age_fath;

  Father(int fathers_age) throws WrongAgeException{
    age_fath = fathers_age;

    if(age_fath<0){
      throw new WrongAgeException(age_fath);
    }
  }
}

class Son extends Father{
  int age_son;

  Son(int fathers_age,int sons_age) throws WrongAgeException,AgeException{
    super(fathers_age);
    age_son = sons_age;
    if(age_son<0){
      throw new WrongAgeException(age_son);
    }
    if(age_son>=age_fath){
      throw new AgeException(age_fath,age_son);
    }
  }
}

class FatherSon{
  public static void main(String[] args){
    int fathers_age,sons_age;
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the Father's age: ");
    fathers_age = getData.nextInt();
    try{
      Father fathObj = new Father(fathers_age);
    }
    catch(WrongAgeException w){
      System.out.println("Age exception raised! " + w);
    }
    System.out.println("Enter the Son's age: ");
    sons_age = getData.nextInt();
    try{
      Son sonObj = new Son(fathers_age,sons_age);
      System.out.println("The entered ages are appropriate!");
    }
    catch(WrongAgeException t){
      System.out.println("Age exception raised! " + t);
    }
    catch(AgeException a){
      System.out.println("Age of the Son is greater than the Father." + a);
    }
  }
}
