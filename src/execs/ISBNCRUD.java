package execs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DbConnection;
import declarations.ISBN;

public class ISBNCRUD {
	static Connection conn = null;
	static PreparedStatement objPreparedStatementObject = null;
	static ResultSet ojbResultSetObject = null;
	
	public static  String setFields() {
		String strfields = 
						"(ISBN,"      	  +
						"BookName,"       +
						"Description,"    +
						"Edition,"        +
						"PubYear,"        +
						"Author)";
		return strfields;
	}
	
	public static  String setValues() {
		String strfields = "VALUES(?,"+
								"?,"  + 
								"?,"  +
							    "?,"  +
							    "?,"  +
							    "?)";
		return strfields;
	}
	
	public static int CreateISBN (ISBN isbn) {
		conn =   DbConnection.getConnection();
		int intResult = 0;

		try {
			objPreparedStatementObject = conn.prepareStatement("INSERT INTO isbn_table " + setFields()
					+ setValues());
			objPreparedStatementObject.setString(1, isbn.getISBN());
			objPreparedStatementObject.setString(2, isbn.getBookName());
			objPreparedStatementObject.setString(3, isbn.getDescription());
			objPreparedStatementObject.setString(4, isbn.getEdition());
			objPreparedStatementObject.setDate(5, isbn.getPubYear());
			objPreparedStatementObject.setString(6, isbn.getAuthor());
			intResult = objPreparedStatementObject.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return intResult;
	}
	
	
}
