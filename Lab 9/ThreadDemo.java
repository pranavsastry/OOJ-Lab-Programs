class CollegeThread implements Runnable{
  Thread c,b;
  CollegeThread(){
    c = new Thread(this,"College Thread");
    b = new Thread(this,"Branch Thread");
  }
  public void run(){
    try{
      for(int i=0;i<5;i++){
        System.out.println("BMS College Of Engineering");
        for(int j=0;j<5;j++){
          System.out.println("CSE");
          b.sleep(2000);
        }
      }
    }
    catch(InterruptedException e){
      System.out.println("Thread interrupted!");
    }
  }
}


class ThreadDemo{
  public static void main(String[] args){
    CollegeThread college = new CollegeThread();
    college.c.start();
  }
}
