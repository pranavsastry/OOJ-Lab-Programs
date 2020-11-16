import java.util.Scanner;
import java.util.Arrays;
import cie.*;
import see.*;

class TotalMarks{

  public static double[] addArrays(double[] arr1,double[] arr2){
    double[] added = new double[arr1.length];
    for(int i=0;i<arr1.length;i++){
      added[i] = arr1[i] + arr2[i];
    }
    return added;
  }

  public static double[] fromString2Array(String entered_str){
    String[] separated = entered_str.split(",");
    double[] returnArray = new double[separated.length];
    for(int i=0;i<separated.length;i++){
      returnArray[i] = Double.parseDouble(separated[i]);
    }
    return returnArray;
  }

  public static void main(String[] args){
    int num;
    String temp_name,temp_usn;
    int temp_sem;
    double[] temp_cie;
    double[] temp_see;
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the number of students: ");
    num = getData.nextInt();
    getData.nextLine();
    cie.Internals[] internals_marks = new cie.Internals[num];
    see.External[] external_marks = new see.External[num];
    double[][] added_marks = new double[num][5];
    for(int i=0;i<num;i++){
      System.out.println("Enter the details(USN,Name,Sem,ciemarks,seemarks) of Student " + (i+1) + ": ");
      temp_usn = getData.nextLine();
      temp_name = getData.nextLine();
      temp_sem = Integer.parseInt(getData.nextLine());
      temp_cie = fromString2Array(getData.nextLine());
      temp_see = fromString2Array(getData.nextLine());
      internals_marks[i] = new cie.Internals(temp_usn,temp_name,temp_sem,temp_cie);
      external_marks[i] = new see.External(temp_usn,temp_name,temp_sem,temp_see);
      added_marks[i] = addArrays(internals_marks[i].cie_marks,external_marks[i].see_marks);
    }
    System.out.println("\n***** STUDENTS DATA *****\n");
    for(int i=0;i<num;i++){
      System.out.println("Student " + (i+1) +": ");
      internals_marks[i].display();
      external_marks[i].display();
      System.out.println("TOTAL MARKS: " + Arrays.toString(added_marks[i]));
      System.out.println();
    }
  }
}
