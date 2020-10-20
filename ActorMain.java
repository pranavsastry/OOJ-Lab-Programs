import java.util.Scanner;

class Actor{
  String name;
  int id;
  int no_of_movies;
  int no_of_years_exp;
  double average_performance;
  static double highest_avg=0.0;
  static String highest_avg_name;

  Actor(String actorName, int actorId, int actorNumMovies, int actorNumYears){
    this.name = actorName;
    this.id = actorId;
    this.no_of_movies = actorNumMovies;
    this.no_of_years_exp = actorNumYears;
    this.average_performance = calcAvg();
    if(this.average_performance>highest_avg){
      highest_avg = this.average_performance;
      highest_avg_name = this.name;
    }
  }

  public double calcAvg(){
    double avg = (this.no_of_movies / this.no_of_years_exp);
    return avg;
  }

  public void display(){
    System.out.println("Name: " + this.name);
    System.out.println("ID: " + this.id);
    System.out.println("Number of movies: " + this.no_of_movies);
    System.out.println("Number of years experience: " + this.no_of_years_exp);
    System.out.println("Average performance: " + this.average_performance);
  }
}

class ActorMain{
  public static void main(String[] args){
    Scanner getData = new Scanner(System.in);
    System.out.println("Enter the number of actors: ");
    int num = getData.nextInt();
    Actor actorList[] = new Actor[num];
    String tempName;
    int tempId,tempNumMovies,tempNumYears;
    for(int i=0;i<num;i++){
      System.out.println("Enter the details of Actor " + (i+1) + ": ");
      getData.nextLine();
      System.out.println("Name: ");
      tempName = getData.nextLine();
      System.out.println("ID: ");
      tempId = getData.nextInt();
      System.out.println("Number of movies: ");
      tempNumMovies = getData.nextInt();
      System.out.println("Number of years experience: ");
      tempNumYears = getData.nextInt();
      actorList[i] = new Actor(tempName,tempId,tempNumMovies,tempNumYears);
    }
    System.out.println("\n***** ACTORS DETAILS *****\n");
    for(int j=0;j<num;j++){
      actorList[j].display();
      System.out.println("\n");
    }
    System.out.println("Actor " + Actor.highest_avg_name + " has the highest averge = " + Actor.highest_avg);
    System.out.println("\n");
  }
}
