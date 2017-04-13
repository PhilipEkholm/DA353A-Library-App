package library;

/**
*   The Book class for book.
*/

public class Book extends Media{
	private String author, bookTitle;
	
	public Book(String id, int year, String author, String bookTitle){ 
		super(id, year);
		this.author = author;
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String toString(){
		return bookTitle + ", " + author + ", " + super.getYear() + ", ID: " + super.getId();
	} 
}









