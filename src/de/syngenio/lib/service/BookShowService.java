package de.syngenio.lib.service;

import java.util.Collection;

import de.syngenio.lib.domainobject.Book;
import de.syngenio.lib.io.CharacterReader;

public class BookShowService extends Service implements IMenuChoiceService{
	
	@Override
	public void optionSelected() {
		Collection<Book> booksFound = this.getBookDao().findAllBooks();
		System.out.println("Folgende Bücher sind registriert:");
		for (Book book : booksFound) {
			System.out.println("" + book);
		}
		CharacterReader.readString("Bitte drücken sie irgendeine Taste für weiter");
	}
	
}
