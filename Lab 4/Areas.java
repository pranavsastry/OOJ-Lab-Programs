import java.util.Scanner;

abstract class Shape{
  double a,b;
  Shape(double p, double q){
    this.a = p;
    this.b = q;
  }
  abstract void printArea();
}

class Rectangle extends Shape{
  Rectangle(double p, double q){
    super(p,q);
  }

  void printArea(){
    System.out.format("Area of Rectangle is: %f\n",this.a*this.b);
  }
}

class Triangle extends Shape{
  Triangle(double p, double q){
    super(p,q);
  }

  void printArea(){
    System.out.format("Area of Triangle is: %f\n",(this.a*this.b)/2);
  }
}

class Circle extends Shape{
  Circle(double p, double q){
    super(p,q);
  }

  void printArea(){
    System.out.format("Area of Circle is: %f\n",3.14*this.a*this.b);
  }
}

class ShapeMain{
  public static void main(String[] args){
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the dimensions of the the rectangle(length breadth): ");
    Rectangle r = new Rectangle(getData.nextDouble(),getData.nextDouble());
    System.out.println("Enter the dimensions of the triangle(height base_length): ");
    Triangle t = new Triangle(getData.nextDouble(),getData.nextDouble());
    System.out.println("Enter the dimension of the circle(radius): ");
    double rad = getData.nextDouble();
    Circle c = new Circle(rad,rad);
    r.printArea();
    t.printArea();
    c.printArea();
  }
}
