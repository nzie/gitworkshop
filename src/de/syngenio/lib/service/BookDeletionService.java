package de.syngenio.lib.service;

public class BookDeletionService implements IMenuChoiceService{

	private BookDao bookDao;

	@Override
	public void optionSelected() {
		CharacterReader.readString("Bitte geben Sie die Nummer des Buches zum löschen");
		Integer index = CharacterReader.readIntegerFromConsole();
		Book book = bookDao.findBookById(index);
		bookDao.deleteBook(book);
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
