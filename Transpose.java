import java.util.Scanner;

class Transpose{
  public static int[][] transpose(int[][] yourArray,int x,int y){
    int[][] transposedArray = new int[x][y];
    for(int i=0;i<x;i++){
      for(int j=0;j<y;j++){
        transposedArray[i][j] = yourArray[j][i];
      }
    }
    return transposedArray;
  }
  public static void display(int[][] yourArray,int x,int y){
    for(int i=0;i<x;i++){
      for(int j=0;j<y;j++){
        System.out.print(yourArray[i][j] + "\t");
      }
      System.out.print("\n");
    }
    System.out.println("\n");
  }
  public static void main(String[] args){
    Scanner getData = new Scanner(System.in);
    int m,n;
    System.out.println("Enter the number of rows and columns: ");
    m = getData.nextInt();
    n = getData.nextInt();
    int[][] array2d = new int[m][n];
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        System.out.format("Enter the value of array2d[%d][%d]: \n",i,j);
        array2d[i][j] = getData.nextInt();
      }
    }
    System.out.println("\n");
    System.out.println("Entered array: ");
    display(array2d,m,n);
    int[][] transposedArray = transpose(array2d,m,n);
    System.out.println("Transposed Array: ");
    display(transposedArray,m,n);
  }
}
