package de.syngenio.lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.syngenio.lib.dao.BookDao;
import de.syngenio.lib.domainobject.Book;
import de.syngenio.lib.io.CharacterReader;
import de.syngenio.lib.service.BookCreateService;
import de.syngenio.lib.service.BookDeletionService;
import de.syngenio.lib.service.BookEditService;
import de.syngenio.lib.service.BookRentService;
import de.syngenio.lib.service.BookReturnService;
import de.syngenio.lib.service.BookShowService;
import de.syngenio.lib.service.DoNothingService;
import de.syngenio.lib.service.IMenuChoiceService;
import de.syngenio.lib.service.Service;

public class GitLibrary {

	final BookDao bookDao = new BookDao();

	CharacterReader characterReader = new CharacterReader();

	private BookShowService bookShowService = new BookShowService();

	private BookCreateService bookCreationService = new BookCreateService();

	private BookEditService bookEditService = new BookEditService();

	private Map<Integer, IMenuChoiceService> serviceHandlingChoice = new HashMap<Integer, IMenuChoiceService>();

	private BookDeletionService bookDeletionService = new BookDeletionService();

	private IMenuChoiceService bookRentService = new BookRentService();

	private IMenuChoiceService bookReturnService = new BookReturnService();


	public GitLibrary() {
		bookShowService.setBookDao(bookDao);
		bookDeletionService.setBookDao(bookDao);
		((Service)bookRentService).setBookDao(this.bookDao);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GitLibrary().start();
	}

	public void start() {
		createBook("Stephan Kings Es2" +
				"", "9983-78978");
		createBook("Pipi Langstrumpf", "9983-78978");
		createBook("Ronja Reubertochter", "790823-89079");
		printWelcomeMsg();
		printOptions();
		System.out.println("Goodbye dear user");
	}

	private void printWelcomeMsg() {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat();
		System.out.println("Welcome to the Lib! " + formatter.format(today));
	}

	private void printOptions() {
		int option = 0;
		while (option != 7) {
			printOption(1, "Bücher anzeigen", bookShowService);
			printOption(2, "Neues Buch anlegen", bookCreationService);
			printOption(3, "Buch löschen", bookDeletionService);
			printOption(4, "Buch bearbeiten", bookEditService);
			printOption(5, "Buch ausleihen", bookRentService);
			printOption(6, "Buch zurück geben", bookReturnService);
			printOption(7, "Git lib beenden", new DoNothingService());
			option = CharacterReader.readIntegerFromConsole();
			serviceHandlingChoice.get(option).optionSelected();
		}


	}

	private void printOption(int i, String string,
			IMenuChoiceService menuChoiceService) {
		System.out.println("(" + i + ") " + string);
		serviceHandlingChoice.put(i, menuChoiceService);
	}

	public void createBook(String nameOfBook, String isbn) {
		Book bookToSave = new Book();
		bookToSave.setName(nameOfBook);
		bookToSave.setIsbn(isbn);
		bookDao.saveBook(bookToSave);
	}

}
