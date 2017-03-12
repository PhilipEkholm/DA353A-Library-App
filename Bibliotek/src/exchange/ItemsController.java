package exchange;

import library.LibraryController;

public class ItemsController extends LibraryController{
	private ItemsView itemsView = new ItemsView();
	private BorrowedItemsView borrowedItemsView = new BorrowedItemsView();

	public ItemsController(String filePath) {
		super(filePath);
		super.loadWindow(itemsView, "Bibliotek");
	}
	
	
}
