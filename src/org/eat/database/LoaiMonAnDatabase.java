package org.eat.database;

import java.sql.*;
import java.util.*;

import org.eat.collection.*;
import org.eat.model.*;

public class LoaiMonAnDatabase {
	private LibSQL lib;
	public LoaiMonAnDatabase() {
		lib = new LibSQL();
	}	
	public ArrayList<LoaiMonAn> getAllLoaiMonAn() {
		try {
			ResultSet rs = lib.executeQuery("SELECT * FROM LoaiMonAn");
			LoaiMonAnCollection collection = new LoaiMonAnCollection();
			while (rs.next()) {
				LoaiMonAn s = new LoaiMonAn(
							rs.getString("MaLoai")
							, rs.getString("TenLoai")
							, rs.getString("Vung")
							, rs.getString("MoTa")
							);
				collection.addLoaiMonAn(s);
			}
			return collection.getAllLoaiMonAn();
		} catch(Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}
	public String getTenloai(String maloai){
		try {
			ResultSet rs=lib.executeQuery("Select TenLoai from LoaiMonAn where Maloai like '%"+maloai+"%'");
			String s="";
			while(rs.next()){
				s=rs.getString(1);
			}
			return s;
		} catch (Exception e) {
			lib.close();
		}finally{
			lib.close();
		}
		return null;
	}
	public LoaiMonAn getMaloai(int i){
		try {
			ResultSet rs=lib.executeQuery("Select * from LoaiMonAn limit "+i+","+1);
			LoaiMonAnCollection collection = new LoaiMonAnCollection();
			LoaiMonAn s=new LoaiMonAn();
			while(rs.next()){
				s=new LoaiMonAn(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				collection.addLoaiMonAn(s);
			}
			return s;
		} catch (Exception e) {
			lib.close();
		}finally{
			lib.close();
		}
		return null;
	}
	public int InsertLoaiMonAn(LoaiMonAn s) {
		try {
			int result = lib.executeUpdate("INSERT INTO LoaiMonAn(MaLoai, TenLoai, Vung, MoTa) VALUES("
					+ "'" + s.getMaLoaiMonAn() + "'"
					+ ",'" + s.getTenLoai() + "'"
					+ ",'" + s.getVung() + "'"
					+ ",'" + s.getMoTa() + "')"				
					);
			lib.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			lib.close();
		} finally {
			lib.close();
		}
		return -1;
	}
	public int DeleteLoaiMonAn(LoaiMonAn s) {
		try {
			int result = lib.executeUpdate("DELETE FROM LoaiMonAn WHERE MaLoai="
					+ "'"+ s.getMaLoaiMonAn() +"'"
					);
			lib.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			lib.close();
		} finally {
			lib.close();
		}
		return -1;
	}
	public int UpdateLoaiMonAn(LoaiMonAn s) {
		try {
			int result = lib.executeUpdate("UPDATE LoaiMonAn SET "
					+ "TenLoai='" + s.getTenLoai() + "'"
				    + ", Vung='" + s.getVung() + "'"
				    + ", MoTa='" + s.getMoTa() + "'"					
					+ " WHERE MaLoai='"+ s.getMaLoaiMonAn() +"'"
					);
			lib.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			lib.close();
		} finally {
			lib.close();
		}
		return -1;
	}
}
