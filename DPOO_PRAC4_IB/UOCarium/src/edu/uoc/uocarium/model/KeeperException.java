package edu.uoc.uocarium.model;

@SuppressWarnings("serial")
public class KeeperException extends Exception {
	
	public final static String MSG_ERR_ID_FIRST_LETTER_VALUE = "[ERROR] A keeper's id must start with letter 'G'!!";
	public final static String MSG_ERR_ID_SIZE = "[ERROR] A kepper's id must have 5 characters!!";	
	public final static String MSG_ERR_LIST_SIZE_VALUE = "[ERROR] A keeper cannot take care of more than 5 tanks!!";	
	
	public KeeperException() {
		super();
	}
	
	public KeeperException(String msg) {
		super(msg);
	}
}
