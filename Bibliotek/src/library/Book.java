package library;

public class Book extends Media{
	private String 	author,
					bookTitle;
	
	public Book(String id, int year, String author, String bookTitle){
		super(id, year);
		
		this.author = author;
		this.bookTitle = bookTitle;
	}
}
