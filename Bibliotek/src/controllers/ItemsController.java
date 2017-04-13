package controllers;

import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import collections.PriorityQueue;
import models.LibraryModel;
import models.Person;
import models.PersonModel;
import views.BorrowedItemsView;
import views.ItemsView;
import library.Book;
import library.CompareDateBorrowed;
import library.DVD;
import library.Media;

/**
* ItemsController
*
* ItemsController is responsible for the exchange of items.
* It controls two views in this case. It also extends the
* LibraryController responsible for loading in media files.
*/

public class ItemsController{
	private ItemsView itemsView = new ItemsView(this);
	private BorrowedItemsView borrowedItemsView = new BorrowedItemsView(this);
	private Person currentlyLoggedOn;
	private PersonModel pm;
	private LibraryModel lm;
	private JFrame 	itemsFrame = new JFrame(),
			 		borrowedItemsFrame = new JFrame();

	/**
	 * 	File path is sent upwards to the GeneralController.
	 * 	The old frame is reused in the borrowed-window, and the
	 * 	person currently logged in will be passed upwards.
	 *
	 * 	@param filePath filePath for the persons (Lantagare.txt)
	 * 	@param oldFrame the old frame used for the login.
	 * 	@param currentlyLoggedIn the person that is currently
	 *	logged into the system.
	 */

	public ItemsController(PersonModel personsModel, LibraryModel libraryModel, Person currentlyLoggedIn) {
		this.currentlyLoggedOn = currentlyLoggedIn;
		this.pm = personsModel;
		this.lm = libraryModel;
		
		this.listItems();
		this.openUpWindows();
		
		borrowedItemsView.setWelcomeText("Välkommen, " + currentlyLoggedOn.getName());
	}
	
	/**
	* 	Refresh the views with new items,
	* 	and decide which ones are borrowed
	* 	and not borrowed.
	*/

	public void listItems(){
		String 	books = "",
				DVDs = "",
				borrowedObjects = "";

		Iterator<Media> iter = lm.iterator();
		PriorityQueue<Media> pq = new PriorityQueue<Media>(new CompareDateBorrowed());
		
		while(iter.hasNext()){
			Media media = iter.next();
			
			if(media instanceof Book && media.getBorrowedBy() == null){
				books += media.toString() + "\n";
			}
			else if(media instanceof DVD && media.getBorrowedBy() == null){
				DVDs += media.toString() + "\n";
			}
			else if(media.getBorrowedBy().equals(currentlyLoggedOn)){
				pq.enqueue(media);
			}
		}
		
		while(pq.size() > 0){
			borrowedObjects += pq.dequeue().toString() + "\n";
		}

		borrowedItemsView.setBorrowedItems(borrowedObjects);
		itemsView.setItems(books, DVDs);
	}
	
	private void openUpWindows(){
		
		itemsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borrowedItemsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		itemsFrame.add(itemsView);
		borrowedItemsFrame.add(borrowedItemsView);
		
		itemsFrame.pack();
		itemsFrame.setVisible(true);
		itemsFrame.setLocation(50, 50);
		borrowedItemsFrame.pack();
		borrowedItemsFrame.setVisible(true);
		
	}

	/**
	* Borrow a certain media-object from the collection.
	*
	* @param id the id of the media object to be borrowed.
	*/

	public void borrow(String id){
		if(lm.contains(id)){
			Media media = lm.get(id);
			
			media.setBorrowedBy(currentlyLoggedOn);
			media.setDateBorrowed(new Date());
		}
		
		this.listItems();
	}

	/**
	* Return an item currently borrowed to the collection.
	*
	* @param id the id of the media-object to be returned.
	*/
	
	public void returnItem(String id){
		if(lm.contains(id)){
			Media media = lm.get(id);
			media.setBorrowedBy(null);
			media.setDateBorrowed(null);
		}
		
		this.listItems();
	}
	
	/**
	 *	Change the user that is currently logged in.
	 *
	 * 	@param personId personnr to be used for verification
	 */
	
	public void changeUser(String personId){
		if(pm.contains(personId)){
			int result = JOptionPane.showConfirmDialog(null, "Byte av användare gick, vill du fortsätta?");
			
			if(result == JOptionPane.OK_OPTION){
				itemsFrame.setVisible(false);
				borrowedItemsFrame.setVisible(false);
				Person loggedInPerson = pm.get(personId);
				new ItemsController(pm, lm, loggedInPerson);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Byte av användare gick ej, försök igen.");
		}
	}
	
	/**
	 *	Log out the user 
	 */
	
	public void logOut(){
		new LoginController(pm, lm);
		this.itemsFrame.setVisible(false);
		this.borrowedItemsFrame.setVisible(false);
	}
}







