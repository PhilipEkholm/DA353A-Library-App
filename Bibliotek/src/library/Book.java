package library;

/**
*   The Book class for a book.
*/

public class Book extends Media{
	private String author, bookTitle;
	
	public Book(String id, int year, String author, String bookTitle){ 
		super(id, year);
		this.author = author;
		this.bookTitle = bookTitle;
	}
	
	/**
	 * 	@return the author of the book.
	 */

	public String getAuthor() {
		return author;
	}
	
	/**
	 * 	@return the title of the book.
	 */

	public String getBookTitle() {
		return bookTitle;
	}
	
	/**
	 * 	@return the data about the book as a string.
	 */

	public String toString(){
		return bookTitle + ", " + author + ", " + super.getYear() + ", ID: " + super.getId();
	} 
}









