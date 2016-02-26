package de.stiffi.DPHelpers.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;


public class DatabaseHelpers {
	public static PreparedStatement prepareInsertStatement(Connection connection, String tableName, Hashtable<String, Object> values) throws SQLException {
		List<String> lstFields = new ArrayList<String>();
		List<Object> lstValues = new ArrayList<Object>();
		
		Enumeration<String> keys = values.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			Object val = values.get( key );
			
			lstFields.add( key );
			lstValues.add( val );
		}
		
		//Jetzt den String aufbauen
		String sql = "INSERT INTO " + tableName + " ( " ;
		for (int i=0; i<lstFields.size(); i++) {
			if (i > 0) {
				sql += ", ";
			}
			sql += lstFields.get(i)+ " "; 
		}
		sql += ") VALUES (";
		
		for (int i=0; i<lstValues.size(); i++) {
			if (i > 0) {
				sql += ", ";
			}
			sql += "? ";
		}
		
		sql += " ) ";
		
		PreparedStatement pStmt = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
		
		for (int i=0; i<lstValues.size(); i++) {
			Object val = lstValues.get( i );
			
			if (val instanceof CharSequence) {
				pStmt.setString( i+1, val.toString() );
			}else if (val instanceof Integer) {
				pStmt.setInt( i+1, ((Integer)val).intValue() );
			}else if (val instanceof Long){
				pStmt.setLong( i+1, ((Long)val ).longValue());
			}else if (val instanceof Boolean){
				pStmt.setBoolean( i+1, ((Boolean)val ).booleanValue());
			}				
		}
		
		return pStmt;
		
		
	}
}
