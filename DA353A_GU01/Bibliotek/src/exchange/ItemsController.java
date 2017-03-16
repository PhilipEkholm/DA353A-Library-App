package exchange;

import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JFrame;

import arraylist.ArrayList;
import arraylist.List;
import common.Person;
import library.Book;
import library.DVD;
import library.LibraryController;

public class ItemsController extends LibraryController{
	private ItemsView itemsView = new ItemsView(this);
	private BorrowedItemsView borrowedItemsView = new BorrowedItemsView(this);
	private ArrayList borrowedItems = new ArrayList();

	public ItemsController(String filePath, JFrame oldFrame, Person currentlyLoggedIn) {
		super(filePath, currentlyLoggedIn);
		super.addFrame(oldFrame);
		super.loadWindow(itemsView, "Bibliotek");
		
		JFrame borrowedItemsFrame = super.getWindow(0);
		JFrame itemsFrame = super.getWindow(1);
		borrowedItemsFrame.setLocation(450, 5);
		borrowedItemsFrame.setTitle("Dina låneobjekt");
		borrowedItemsFrame.setSize(new Dimension(550, 420));
		borrowedItemsFrame.add(borrowedItemsView);
		borrowedItemsFrame.setResizable(false);
		itemsFrame.setLocation(200, 445);
		itemsFrame.setSize(new Dimension(1000, 400));
		itemsFrame.setResizable(false);
		
		this.listItems();
	}
	
	public void listItems(){
		String 	books = "",
				dvds = "",
				borrowedObjects = "";
		
		List<Book> 	booksList = bookTree.values();
		List<DVD>	DVDList = DVDTree.values();
		
		for(int i = 0; i < booksList.size(); i++){
			if(booksList.get(i).getBorrowedBy() == null){
				books += booksList.get(i).toString() + "\n";
			}
		}
		
		for(int i = 0; i < DVDList.size(); i++){
			if(DVDList.get(i).getBorrowedBy() == null){
				dvds += DVDList.get(i).toString() + "\n";
			}
		}
		
		Iterator iter = borrowedItems.iterator();
		
		while(iter.hasNext()){
			borrowedObjects += iter.next().toString() + "\n";
		}
		
		borrowedItemsView.setBorrowedItems(borrowedObjects);
		itemsView.setItems(books, dvds);
	}
	
	public void borrow(String id){
		if(bookTree.contains(id)){
			Book targetBook = bookTree.get(id);
			
			if(targetBook.getBorrowedBy() == null){
				targetBook.setBorrowedBy(super.currentlyLoggedIn);
				borrowedItems.add(targetBook);
				this.listItems();
			}
		}
		else if(DVDTree.contains(id)){
			DVD targetDVD = DVDTree.get(id);
			
			if(targetDVD.getBorrowedBy() == null){
				targetDVD.setBorrowedBy(super.currentlyLoggedIn);
				borrowedItems.add(targetDVD);
				this.listItems();
			}
		}
	}
	
	public void returnItem(String id){
		if(bookTree.contains(id)){
			Book targetBook = bookTree.get(id);
			
			if(targetBook.getBorrowedBy() != null && targetBook.getBorrowedBy().equals(currentlyLoggedIn)){
				targetBook.setBorrowedBy(null);
				int index = borrowedItems.indexOf(targetBook);
				borrowedItems.remove(index);
				this.listItems();
			}
		}
		else if(DVDTree.contains(id)){
			DVD targetDVD = DVDTree.get(id);
			
			if(targetDVD.getBorrowedBy() != null && targetDVD.getBorrowedBy().equals(currentlyLoggedIn)){
				targetDVD.setBorrowedBy(null);
				int index = borrowedItems.indexOf(targetDVD);
				borrowedItems.remove(index);
				this.listItems();
			}
		}
	}
}
















