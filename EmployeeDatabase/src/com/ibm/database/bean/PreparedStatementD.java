package com.ibm.database.bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementD {
	Connection dbCon;
	PreparedStatement pstmt;
	public PreparedStatementD() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST", "root", "");
		}catch(Exception e) {
			System.out.println(e);
		}

}
}
