import java.util.Scanner;

class Value<T extends Number,V extends Number>{
  T[] obj1;
  V[] obj2;

  Value(T[] val1, V[] val2){
    obj1 = val1;
    obj2 = val2;
  }

  int calcSum1(){
    int sum = 0;
    for(int i=0;i<obj1.length;i++){
      sum += obj1[i].intValue();
    }
    return sum;
  }

  double calcSum2(){
    double sum = 0;
    for(int i=0;i<obj2.length;i++){
      sum += obj2[i].doubleValue();;
    }
    return sum;
  }

  int calcMax1(){
    int max = obj1[0].intValue();
    for(int i=0;i<obj1.length;i++){
      if(obj1[i].intValue()>=max){
        max = obj1[i].intValue();
      }
    }
    return max;
  }

  double calcMax2(){
    double max = obj2[0].doubleValue();
    for(int i=0;i<obj2.length;i++){
      if(obj2[i].doubleValue()>=max){
        max = obj2[i].doubleValue();
      }
    }
    return max;
  }
}

class GenDemo{
  public static Integer[] fromString2IntArr(String given_str){
    String[] string_vals = given_str.split(",");
    Integer[] arr_vals = new Integer[string_vals.length];
    for(int i=0;i<string_vals.length;i++){
      arr_vals[i] = Integer.parseInt(string_vals[i]);
    }
    return arr_vals;
  }

  public static Double[] fromString2DoubArr(String given_str){
    String[] string_vals = given_str.split(",");
    Double[] arr_vals = new Double[string_vals.length];
    for(int i=0;i<string_vals.length;i++){
      arr_vals[i] = Double.parseDouble(string_vals[i]);
    }
    return arr_vals;
  }

  public static void main(String[] args){
    int sum1,max1;
    double sum2,max2;
    Integer[] temp1;
    Double[] temp2;
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the Integer values: ");
    temp1 = fromString2IntArr(getData.nextLine());
    System.out.println("Enter the Double values: ");
    temp2 = fromString2DoubArr(getData.nextLine());
    Value<Integer,Double> valueObj = new Value<Integer,Double>(temp1,temp2);
    sum1 = valueObj.calcSum1();
    sum2 = valueObj.calcSum2();
    max1 = valueObj.calcMax1();
    max2 = valueObj.calcMax2();
    System.out.println();
    System.out.println("INTEGER: Max = " + max1 + " Sum = " + sum1);
    System.out.println("DOUBLE: Max = " + max2 + " Sum = " + sum2);
  }
}
