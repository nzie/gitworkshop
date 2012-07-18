package de.syngenio.lib.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.syngenio.lib.domainobject.Book;
import de.syngenio.lib.io.CharacterReader;

public class BookRentService extends Service implements IMenuChoiceService{
	
	@Override
	public void optionSelected() {
		Collection<Book> booksFound = this.getBookDao().findAllBooks();
		List<Book> rentableBooks = new ArrayList<Book>();
		System.out.println("Folgende Bücher sind zurzeit ausleihbar:");
		for (Book book : booksFound) {
			if(!book.isRented()) {
				rentableBooks.add(book);
				System.out.println("" + book);
			}
		}
		String bookThis = CharacterReader.readString("Bitte geben Sie die ID des auszuleihenden Buches an: ");
		int chosenBookNumber = Integer.parseInt(bookThis);
		Book chosenBook = null;
		for (Book book : rentableBooks) {
			if(book.getId() == chosenBookNumber) {
				chosenBook = book;
			}
		}
		if(chosenBook != null) {
			chosenBook.setRented(true);
			System.out.println("Sie haben das Buch '" + chosenBook.getName() + "' gebucht. Vielen Dank!");	
		}
		else {
			System.out.println("Ups! Etwas ist schief gelaufen während dem Ausleihen. Versuchen Sie es erneut!");
		}
	}

}
