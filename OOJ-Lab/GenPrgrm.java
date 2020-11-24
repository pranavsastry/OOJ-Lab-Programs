import java.util.Scanner;

class Student<T,V,E>{
  T obj1;
  V obj2;
  E obj3;

  Student(T data1,V data2,E data3){
    obj1 = data1;
    obj2 = data2;
    obj3 = data3;
  }

  T getObj1(){
    return obj1;
  }

  V getObj2(){
    return obj2;
  }

  E getObj3(){
    return obj3;
  }

}

class GenPrgrm{
  public static void main(String[] args){
    String usn,name;
    int sem;
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the student details(USN,Name,Sem): ");
    Student<String,String,Integer> studObj = new Student<String,String,Integer>(getData.nextLine(),getData.nextLine(),Integer.parseInt(getData.nextLine()));
    usn = studObj.getObj1();
    name = studObj.getObj2();
    sem = studObj.getObj3();
    System.out.println("\n***** STUDENT DETAILS *****\n");
    System.out.println("USN: " + usn);
    System.out.println("NAME: " + name);
    System.out.println("SEM: " + sem);
  }
}
