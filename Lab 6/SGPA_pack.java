import java.util.Scanner;
import java.util.Arrays;
import cie.*;
import see.*;

class SGPA_pack{

  public static double[] addArrays(double[] arr1,double[] arr2){
    double[] added = new double[arr1.length];
    for(int i=0;i<arr1.length;i++){
      added[i] = arr1[i] + arr2[i];
    }
    return added;
  }

  public static double[] fromString2Array(String entered_str,int type){
    String[] separated = entered_str.split(",");
    double[] returnArray = new double[separated.length];
    for(int i=0;i<separated.length;i++){
      if(type==0){
        returnArray[i] = Double.parseDouble(separated[i]);
      }
      else if(type==1){
        returnArray[i] = Double.parseDouble(separated[i])/2;
      }
    }
    return returnArray;
  }

  public static int[] getGradePoints(double[] marksArray){
    int[] gradePoints = new int[marksArray.length];
    for(int i=0;i<marksArray.length;i++){
      if (marksArray[i]>=90){
        gradePoints[i] = 10;
      }
      else if (marksArray[i]>=80){
        gradePoints[i] = 9;
      }
      else if (marksArray[i]>=70){
        gradePoints[i] = 8;
      }
      else if (marksArray[i]>=60){
        gradePoints[i] = 7;
      }
      else if (marksArray[i]>=50){
        gradePoints[i] = 6;
      }
      else if (marksArray[i]>=40){
        gradePoints[i] = 5;
      }
      else{
        gradePoints[i] = 0;
      }
    }
    return gradePoints;
  }

  public static double calcArraySum(double[] anyArray){
    double sum = 0;
    for(int j=0;j<anyArray.length;j++){
      sum += anyArray[j];
    }
    return sum;
  }

  public static double calcCGPA(double[] creditsArray, double[] marksArray){
    double[] totalGradePoints = new double[marksArray.length];
    int[] gradePointsArray = getGradePoints(marksArray);
    for(int k=0;k<marksArray.length;k++){
      totalGradePoints[k] = creditsArray[k] * gradePointsArray[k];
    }
    double sumGradePoints = calcArraySum(totalGradePoints);
    double totalCredits = calcArraySum(creditsArray);
    double CGPA = sumGradePoints/totalCredits;
    return CGPA;
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
    double[] sgpa = new double[num];
    double[] credits_arr = new double[num];
    for(int i=0;i<num;i++){
      System.out.println("Enter the details(USN,Name,Sem,ciemarks,seemarks,credits) of Student " + (i+1) + ": ");
      temp_usn = getData.nextLine();
      temp_name = getData.nextLine();
      temp_sem = Integer.parseInt(getData.nextLine());
      temp_cie = fromString2Array(getData.nextLine(),0);
      temp_see = fromString2Array(getData.nextLine(),1);
      credits_arr = fromString2Array(getData.nextLine(),0);
      internals_marks[i] = new cie.Internals(temp_usn,temp_name,temp_sem,temp_cie);
      external_marks[i] = new see.External(temp_usn,temp_name,temp_sem,temp_see);
      added_marks[i] = addArrays(internals_marks[i].cie_marks,external_marks[i].see_marks);
      sgpa[i] = calcCGPA(credits_arr,added_marks[i]);
    }
    System.out.println("\n***** STUDENTS DATA *****\n");
    for(int i=0;i<num;i++){
      System.out.println("Student " + (i+1) +": ");
      internals_marks[i].display();
      external_marks[i].display();
      System.out.println("TOTAL MARKS: " + Arrays.toString(added_marks[i]));
      System.out.println("SGPA: " + sgpa[i]);
      System.out.println();
    }
  }
}
