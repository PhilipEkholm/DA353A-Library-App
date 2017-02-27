package library;

import common.Person;

//Klassen Media är abstrakt och måste därför ärvas. Böcker och dvs- filmer
//ska representeras av klasser vilka ärver Media-klassen.

/**
 *	Media
 *
 * 	A generalized abstract object which is inherited by Book and DVD
 */

public abstract class Media {
	private String id;
	private Person borrowedBy;
	private int year;

	public Media( String id, int year) { 
		this.id = id;
		this.borrowedBy = null;
		this.year = year;
	}

	public String getId() { 
		return id;
	}

	public boolean equals( Object obj ) { 
		if(obj instanceof Media) {
			Media media = (Media)obj;
			return id.equals( media.getId() ); 
		}
		
		return false; 
	}
}















