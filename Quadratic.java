import java.util.Scanner;

class Quadratic{
  public static void main(String[] args){

    float a,b,c;
    Scanner takeInput = new Scanner(System.in);
    System.out.println("Enter the values of a, b, c: ");
    a = takeInput.nextFloat();
    b = takeInput.nextFloat();
    c = takeInput.nextFloat();

    double calcDiscriminant = Math.pow(b,2) - (4*a*c);
    double root1 = (-b + Math.sqrt(calcDiscriminant)) / (2*a);
    double root2 = (-b - Math.sqrt(calcDiscriminant)) / (2*a);

    if(calcDiscriminant > 0){
      System.out.println("The roots are real and distinct: " + root1 + ", " + root2);
    }
    else if(calcDiscriminant == 0){
      System.out.println("The roots are real and equal: " + root1);
    }
    else{
      System.out.println("There are no real solutions to this equation");
    }

  }
}
