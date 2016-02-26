package de.stiffi.DPHelpers.DB;


public interface DBObject {
	
	public int getID();
	
	/**
	 * 
	 * @return
	 */
	public boolean isInDB();
	public void save() throws DBObjectException;
	public void load(int id) throws DBObjectException;
	public void delete() throws DBObjectException;
}
