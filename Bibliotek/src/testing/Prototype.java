package testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Prototype {
	public static void main(String[] args) {
		Prototype pt = new Prototype();
		try {
			pt.readFilesWithStream();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readFilesWithStream() throws FileNotFoundException, IOException{
		// Här skapas bl.a. lämplig datastruktur String str;
		try(BufferedReader br = new BufferedReader(new FileReader("Files/Lantagare.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    System.out.println(everything);
		}
	}
}
