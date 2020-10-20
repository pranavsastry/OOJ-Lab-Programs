import java.util.Scanner;

class Student{
  String name;
  String USN;
  int[] credits;
  int[] marks;

  Public Student(String yourName, String yourUSN, int[] yourCredits, int[] yourMarks){
    this.name = yourName;
    this.USN = yourUSN;
    this.credits = yourCredits;
    this.marks = yourMarks;
  }

  public int[] getGradePoints(int[] marksArray){
    int[] gradePoints;
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

  public float calcArraySum(int[] anyArray){
    float sum = 0;
    for(int j=0;j<anyArray.length;j++){
      sum += anyArray[j];
    }
    return sum;
  }

  public float calcCGPA(int[] creditsArray, int[] marksArray){
    int[] totalGradePoints;
    int[] gradepointsArray = getGradePoints(marksArray);
    for(int k=0;k<marksArray.length;k++){
      totalGradePoints[k] = creditsArray[k]*gradePointsArray[k];
    }
    float sumGradePoints = calcArraySum(totalGradePoints);
    float totalCredits = calcArraySum(creditsArray);
    float CGPA = sumGradePoints/totalCredits;
    return CGPA;
  }

  public void dispDetails(){
    System.out.println("Name: " + this.name);
    System.out.println("USN: " + this.USN);
    System.out.println("Credits: " + this.credits);
    System.out.println("Marks: " + this.marks);
    System.out.println("CGPA: " + calcCGPA(this.credits, this.marks));
  }

}

class CalculateCGPA{
  public static void main(String[] args){
    Scanner takeInput = new Scanner(System.in);
    
  }
}
