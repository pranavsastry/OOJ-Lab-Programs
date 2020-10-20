import java.util.Scanner;

class CircleDemo{
  static float radius,area,perimeter;
  public static float[][] calcAreaPeri(float rad){
    float[][] returnData = new float[1][2];
    float areaCircle, perimeterCircle;
    final float pi = 3.141F;
    areaCircle = pi*rad*rad;
    perimeterCircle = 2*pi*rad;
    returnData[0][0] = areaCircle;
    returnData[0][1] = perimeterCircle;
    return returnData;
  }
  public static void display(){
    System.out.println("\n***** Circle Details *****\n");
    System.out.println("Radius: " + CircleDemo.radius);
    System.out.println("Area: " + CircleDemo.area);
    System.out.println("Perimeter: " + CircleDemo.perimeter);
  }
  public static void main(String[] args){
    float[][] returnedArray = new float[1][2];
    System.out.println("Enter the radius of the circle: ");
    Scanner getData = new Scanner(System.in);
    CircleDemo.radius = getData.nextFloat();
    returnedArray = calcAreaPeri(CircleDemo.radius);
    CircleDemo.area = returnedArray[0][0];
    CircleDemo.perimeter = returnedArray[0][1];
    display();
  }
}
