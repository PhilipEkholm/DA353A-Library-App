package library;

import java.util.Comparator;

public class CompareDateBorrowed implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		if(o1.getDateBorrowed() != null && o2.getDateBorrowed() != null){
			return o1.getDateBorrowed().compareTo(o2.getDateBorrowed());
		}
		
		return 0;
	}

}
