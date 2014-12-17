package org.eat.database;

import java.sql.*;

public class LibSQL {
	public LibSQL() {
		
	}
	public LibSQL(Connection con) {
		this.con = con;
	}
	private Connection con;
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public void open(String database) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/"+ database;
			con = DriverManager.getConnection(url,"root","root");
			// System.out.println("Connected successfully");
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Open Connection Default
	 * @param null
	 * 
	 * */
	public void open() {
		this.open("java");
	}
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean setAutoCommit(boolean b){
		try {
			this.con.setAutoCommit(b);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean commit() {
		try {
			this.con.commit();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean rollback() {
		try {
			this.con.rollback();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	/**
	 * Only SELECT
	 * @return ResultSet
	 * */
	public ResultSet executeQuery(String sql) {
		try {
			this.open();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Only INSERT, UPDATE, DELETE
	 * @return int value
	 * */
	public int executeUpdate(String sql) {
		try {
			this.open();
			Statement state = con.createStatement();
			return state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * Execute many sentences sql
	 * @return int[] value
	 * */
	public int[] executeBath(String[] sql) {
		try {
			this.open();
			Statement state = con.createStatement();
			for (int i = 0; i < sql.length; i++) {
				state.addBatch(sql[i]);
			}
			return state.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
