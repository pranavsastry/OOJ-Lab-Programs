package cie;

import java.util.Arrays;

public class Internals extends Student{
  public double[] cie_marks = new double[5];

  public Internals(String yourUSN,String yourName,int yourSem,double[] yourCIEMarks){
    super(yourUSN,yourName,yourSem);
    cie_marks = yourCIEMarks;
  }

  public void display(){
    super.display();
    System.out.println("CIE MARKS: " + Arrays.toString(cie_marks));
  }
}
