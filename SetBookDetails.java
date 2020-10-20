import java.util.Scanner;
import java.util.ArrayList;

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

  public String getName(){
    return this.name;
  }

  public String getAuthor(){
    return this.author;
  }

  public float getPrice(){
    return this.price;
  }

  public long getNumPages(){
    return this.num_pages;
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
    ArrayList<Book> bookList = new ArrayList<Book>();
    Scanner takeInput = new Scanner(System.in);
    for(int i=0;i<numBooks;i++){
      System.out.println("Enter the details of the book " + i + ": ");
      bookList.add(new Book(takeInput.next(),takeInput.next(),takeInput.nextFloat(),takeInput.nextInt()));
    }
    System.out.println("\n***** BOOK DETAILS *****\n");
    for(int j=0;j<numBooks;j++){
      bookList.get(j).toBookString();
    }
  }
}
