package library;

public class DVD extends Media{
	private String name;
	private String[] actors;

	public DVD(String id, int year, String name, String[] actors) {
		super(id, year);
		
		this.name = name;
		this.actors = actors;
	}

	public String getName() {
		return name;
	}

	public String[] getActors() {
		String[] newArray = new String[actors.length];
		
		for(int i = 0; i < newArray.length; i++){
			newArray[i] = actors[i];
		}
		
		return newArray;
	}
}
