package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookDao;

public class BookDeletionService implements IMenuChoiceService{

	BookDao bookDao;
	
	
	public BookDeletionService(){
		
	}
	
	
	private void deleteBook(){
		
	}
	
	@Override
	public void optionSelected() {
	bookDao.findAllBooks();
	System.err.println("throw new UnsupportedOperationException");
	}

}
