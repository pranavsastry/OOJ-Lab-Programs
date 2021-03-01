import java.util.Scanner;

class Book{
  String name;
  String author;
  float price;
  long num_pages;

  public Book(String bookName, String authName, float book_price, long num){
    this.name = bookName;
    this.author = authName;
    this.price = book_price;
    this.num_pages = num;
  }

  public void setBook(String enteredName, String enteredAuthor, float enteredPrice, long enteredNumPages){
    this.name = enteredName;
    this.author = enteredAuthor;
    this.price = enteredPrice;
    this.num_pages = enteredNumPages;
  }


  public void toBookString(){
    System.out.println("Name : " + this.name);
    System.out.println("Author : " + this.author);
    System.out.println("Price : " + this.price);
    System.out.println("Number of Pages : " + this.num_pages);
    System.out.println("\n");
  }

}

class SetBookDetails{
  public static void main(String[] args){
    Scanner getNum = new Scanner(System.in);
    System.out.println("Enter the number of books: ");
    int numBooks = getNum.nextInt();
    Book[] bookList = new Book[numBooks];
    Scanner takeInput = new Scanner(System.in);
    for(int i=0;i<numBooks;i++){
      System.out.println("Enter the details of the book " + i + "(Name,Author,Price,Num Pages): ");
      bookList[i] = new Book(takeInput.nextLine(),takeInput.nextLine(),takeInput.nextFloat(),takeInput.nextInt());
      takeInput.nextLine();
    }
    System.out.println("\n***** BOOK DETAILS *****\n");
    for(int j=0;j<numBooks;j++){
      bookList[j].toBookString();
    }
  }
}
