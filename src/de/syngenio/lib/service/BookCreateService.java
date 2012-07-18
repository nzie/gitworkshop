package de.syngenio.lib.service;

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
