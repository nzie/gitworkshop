package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookDao;

public class BookEditService implements IMenuChoiceService{

	BookDao bookDao;
	
	@Override
	public void optionSelected() {
		bookDao.findAllBooks();
		System.out.println("not implemented yet");
	}

}
