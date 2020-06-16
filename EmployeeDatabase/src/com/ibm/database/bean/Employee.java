package com.ibm.database.bean;

import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Employee {
	Connection dbCon;
	PreparedStatement pstmt;
	static Scanner scan = new Scanner(System.in);
	public Employee() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST", "root", "");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			}
	}
	static String name,gender,designation;
	//Integer id;
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("1. Add new Employee:");
			System.out.println("2. Update employee information according to id:");
			System.out.println("3. Display Employees of the organisation:");
			System.out.println("4. Delete Employee from the organisation:");
			System.out.println("5. Exit:");
			Integer input= scan.nextInt();
			scan.nextLine();
			switch(input) {
			case 1:	
					System.out.println("Enter the name:");
					name= scan.nextLine();
					System.out.println("Enter the designation:");
					designation = scan.nextLine();
					System.out.println("Enter the gender:");
					gender = scan.nextLine();
					new Employee().insertIntoTable(name,designation,gender);
					break;
					
			case 2:
					System.out.println("Enter the id you want to update:");
					Integer id= scan.nextInt();
					scan.nextLine();
					new Employee().updateTable(id);
					break;
			
			case 3:
					new Employee().displayTable();
					break;
					
			case 4:
					System.out.println("Enter the id for which you want to delete employee record:");
					Integer id1= scan.nextInt();
					new Employee().deleteTable(id1);
					break;
					
			case 5:
					System.exit(0);
			default:
					System.out.println("Invalid input");
			}	
		}
	}
	
	public void insertIntoTable(String name, String designation, String gender) {
		String fetchQry = "INSERT INTO employee(name, gender, designation) VALUES (?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, designation);
			//ResultSet rs = pstmt.executeQuery();
			if(pstmt.execute()) {
				System.out.println("Added succesfully");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void updateTable(Integer id) {
		System.out.println("Enter the new name:");
		name= scan.nextLine();
		System.out.println("Enter the new designation:");
		designation = scan.nextLine();
		System.out.println("Enter the new gender:");
		gender = scan.nextLine();
		String fetchQry = "update  employee set name=?, gender=?, designation=? where id = ?";
		try {
			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, designation);
			pstmt.setInt(4, id);
			//ResultSet rs = pstmt.executeQuery();
			if(pstmt.execute()) {
				System.out.println("Updated succesfully");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
	public void deleteTable(Integer id) {
		String fetchQry = "delete from employee where id = ?";
		try {
			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setInt(1, id);
			//ResultSet rs = pstmt.executeQuery();
			if(pstmt.execute()) {
				System.out.println("Updated succesfully");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void displayTable() {
		String fetchQry = "select * from employee";
		try {
			pstmt = dbCon.prepareStatement(fetchQry);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ID:"+rs.getInt("id")+" name: "+ rs.getString("name")+" Designation: "+rs.getString("designation")+" Gender: "+rs.getString("gender"));
			}
			//ResultSet rs = pstmt.executeQuery();
//			if(pstmt.execute()) {
//				System.out.println("Updated succesfully");
//			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}

