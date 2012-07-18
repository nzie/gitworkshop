package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookRegistry;
import de.syngenio.lib.domainobject.Book;
import de.syngenio.lib.io.CharacterReader;

public class BookCreateService implements IMenuChoiceService{


	@Override
	public void optionSelected() {
		String name = CharacterReader.readString("Name:");
		String isbn = CharacterReader.readString("ISBN:");
		Book book = new Book();
		book.setName(name);
		book.setIsbn(isbn);

		BookRegistry.registerBook(book);
		System.out.println( "New ID:"+book.getId());
	}

}
