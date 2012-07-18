package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookDao;

public class BookRentService implements IMenuChoiceService{
	
	BookDao bookDao;
	
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
