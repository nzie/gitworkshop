package de.syngenio.lib.service;

import java.util.Collection;

import de.syngenio.lib.dao.BookDao;
import de.syngenio.lib.domainobject.Book;
import de.syngenio.lib.io.CharacterReader;

public class BookRentService implements IMenuChoiceService{
	
	private BookDao dao;

	@Override
	public void optionSelected() {
		this.dao = new BookDao();
		Collection<Book> booksFound = dao.findAllBooks();
		System.out.println("Folgende Bücher sind registriert:");
		for (Book book : booksFound) {
			if(!book.isRented()) {
				System.out.println("" + book);	
			}
		}
		CharacterReader.readString("Bitte geben Sie das auszuleihende Buch an: ");
	}

}
