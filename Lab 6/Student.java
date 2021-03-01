package cie;

import java.util.Arrays;

public class Student{
  public String usn;
  public String name;
  public int sem;

  public Student(String yourUSN,String yourName,int yourSem){
    usn = yourUSN;
    name = yourName;
    sem = yourSem;
  }

  public void display(){
    System.out.println("USN: " + usn);
    System.out.println("NAME: " + name);
    System.out.println("SEM: " + sem);
  }
}
