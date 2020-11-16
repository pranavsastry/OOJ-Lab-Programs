package see;

import cie.*;
import java.util.Arrays;

public class External extends cie.Student{
  public double[] see_marks = new double[5];

  public External(String yourUSN,String yourName,int yourSem,double[] yourSEEMarks){
    super(yourUSN,yourName,yourSem);
    see_marks = yourSEEMarks;
  }

  public void display(){
    System.out.println("SEE MARKS: " + Arrays.toString(see_marks));
  }
}
