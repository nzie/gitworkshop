package de.syngenio.lib.service;

import java.util.Collection;

import de.syngenio.lib.domainobject.Book;
import de.syngenio.lib.io.CharacterReader;

public class BookRentService extends Service implements IMenuChoiceService{
	
	@Override
	public void optionSelected() {
		Collection<Book> booksFound = this.getBookDao().findAllBooks();
		System.out.println("Folgende Bücher sind registriert:");
		for (Book book : booksFound) {
			if(!book.isRented()) {
				System.out.println("" + book);
			}
		}
		CharacterReader.readString("Bitte geben Sie das auszuleihende Buch an: ");
	}

}
