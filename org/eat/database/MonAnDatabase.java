package org.eat.database;

import java.sql.*;
import java.util.*;
import org.eat.collection.*;
import org.eat.model.*;

public class MonAnDatabase {
	private LibSQL lib;
	public MonAnDatabase() {
		lib = new LibSQL();
	}	
	public ArrayList<MonAn> getAllMonAn() {
		try {
			ResultSet rs = lib.executeQuery("SELECT * FROM MonAn");
			MonAnCollection collection = new MonAnCollection();
			while (rs.next()) {
				MonAn s = new MonAn(
							rs.getString("MaMonAn")
							, rs.getString("TenMonAn")
							, rs.getString("HinhAnh")
							, rs.getString("Loai")
							, rs.getString("MoTa")
							, rs.getDouble("Gia")
							);
				collection.addMonAn(s);
			}
			return collection.getAllMonAn();
		} catch(Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}
	
	public int InsertMonAn(MonAn s) {
		try {
			int result = lib.executeUpdate("INSERT INTO MonAn(MaMonAn, TenMonAn, HinhAnh, Loai, MoTa, Gia) VALUES("
					+ "'" + s.getMaMonAn() + "'"
					+ ",'" + s.getTenMonAn() + "'"
					+ ",'" + s.getHinhAnh() + "'"
					+ ",'" + s.getLoai() + "'"
					+ ",'" + s.getMoTa() + "'"
					+ ","  + s.getGia() + ""
					+ ")"
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
	public int DeleteMonAn(MonAn s) {
		try {
			int result = lib.executeUpdate("DELETE FROM MonAn WHERE MaMonAn="
					+ "'"+ s.getMaMonAn() +"'"
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
	public int UpdateMonAn(MonAn s) {
		try {
			int result = lib.executeUpdate("UPDATE MonAn SET "
					+ "TenMonAn='" + s.getTenMonAn() + "'"
				    + ", HinhAnh='" + s.getHinhAnh() + "'"
				    + ", Loai='" + s.getLoai() + "'"
				    + ", MoTa='" + s.getMoTa() + "'"
				    + ", Gia=" + s.getGia() + ""
					+ " WHERE MaMonAn='"+ s.getMaMonAn() +"'"
					);
			System.out.println("UPDATE MonAn SET "
					+ "TenMonAn='" + s.getTenMonAn() + "'"
				    + ", HinhAnh='" + s.getHinhAnh() + "'"
				    + ", Loai='" + s.getLoai() + "'"
				    + ", MoTa='" + s.getMoTa() + "'"
				    + ", Gia=" + s.getGia() + ""
					+ " WHERE MaMonAn='"+ s.getMaMonAn() +"'");
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
