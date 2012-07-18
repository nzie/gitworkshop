package de.syngenio.lib.service;

import de.syngenio.lib.dao.BookDao;

public abstract class Service {
	
	private BookDao dao;
	
	public void setBookDao(BookDao bookDao) {
		this.dao = bookDao;
	}
	
	public BookDao getBookDao() {
		return this.dao;
	}

}
