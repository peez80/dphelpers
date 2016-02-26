package de.stiffi.DPHelpers.DB;

import java.sql.SQLException;


public class DBObjectException extends Exception {

	
	public static final int TYPE_NOT_EXISTING_IN_DB = 0x1;
	public static final int TYPE_UNDEFINED_ERROR = 0x2;
	public static final int TYPE_PARTLY_NOT_FOUND = 0x3;
	public static final int TYPE_READ_ONLY_OBJECT = 0x4;
	public static final int TYPE_DELETE_ERROR = 0x5;
	public static final int TYPE_SAVE_ERROR = 0x6;
	public static final int TYPE_DATABASE_ERROR = 0x7;
	public static final int TYPE_LOAD_ERROR = 0x8;
	
	private int type;
	private Object source;
	
	public DBObjectException(String message, int type, Object source) {
		super(message);		
		this.type = type;
		this.source = source;
	}
	
	public DBObjectException(SQLException sqlException, Object source) {
		super(sqlException.getMessage());
		this.source=source;
		this.type = TYPE_DATABASE_ERROR;
	}
	
	public int getType() {
		return this.type;
	}
	
	public Object getSource() {
		return source;
	}
}
