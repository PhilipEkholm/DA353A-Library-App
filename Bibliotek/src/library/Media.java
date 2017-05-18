package library;
import java.util.Date;

import models.Person;

/**
* Media
*
* A generalized abstract object which is inherited by Book and DVD
*/

public abstract class Media {
	private String id;
	private Person borrowedBy;
	private Date dateBorrowed;
	private int year;
	
	public Media( String id, int year) {
		this.id = id;
		this.borrowedBy = null;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public int getYear(){
		return year;
	}

	public Person getBorrowedBy() {
		return borrowedBy;
	}

	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public void setBorrowedBy(Person borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	
	/**
	 *	Equals is overriden and will return true if the id of the media
	 *	matches the one passed.
	 *
	 *	@param obj the object to be matched to see if it's equal.
	 *	@return true if id matches, otherwise false.
	 */
	
	@Override
	
	public boolean equals( Object obj ) {
		if(obj instanceof Media) {
			Media media = (Media)obj;
			return id.equals( media.getId() );
		}
		return false;
	}
}








