package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookDao;
import de.syngenio.lib.dao.BookRegistry;
import de.syngenio.lib.domainobject.Book;
import de.syngenio.lib.io.CharacterReader;

public class BookCreateService implements IMenuChoiceService{

	
	@Override
	public void optionSelected() {
		String bookanme = CharacterReader.readString("Please insert bookname");
		Book book = new Book();
		book.setName(bookanme);
		BookRegistry.registerBook(book);
	}

}
