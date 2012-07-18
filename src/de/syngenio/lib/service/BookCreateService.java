package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookDao;

public class BookCreateService implements IMenuChoiceService{

	BookDao bookDao;
	
	@Override
	public void optionSelected() {
		bookDao.deleteBook();
		System.out.println("hello");
		System.out.println("throw new UnsupportedOperationException ");
	}

}
