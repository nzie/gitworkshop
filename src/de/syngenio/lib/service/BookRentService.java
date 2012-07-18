package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookDao;

public class BookRentService implements IMenuChoiceService{
	
	BookDao bookDao;
	
	@Override
	public void optionSelected() {
		System.out.println("This operation is not supported yet");
	}
	
	private  void rentABook(){
		
	}

}
