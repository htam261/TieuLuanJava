package org.eat.database;

import java.sql.*;
import java.util.*;
import org.eat.model.*;
import org.eat.collection.*;

public class DatMonAnDatabase {
	private LibSQL lib;
	public DatMonAnDatabase() {
		lib = new LibSQL();
	}	
	public ArrayList<DatMonAn> getAllDatMonAn() {
		try {
			ResultSet rs = lib.executeQuery("SELECT * FROM DatMonAn");
			DatMonAnCollection collection = new DatMonAnCollection();
			while (rs.next()) {
				DatMonAn s = new DatMonAn(
							rs.getString("MaDatMonAn")
							, rs.getString("MaHoaDon")
							, rs.getString("MaMonAn")
							, rs.getInt("SoLuong")
							, rs.getDate("NgayDat")
							);
				collection.addDatMonAn(s);
			}
			return collection.getAllDatMonAn();
		} catch(Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}
	
	public int InsertDatMonAn(DatMonAn s) {
		try {
			int result = lib.executeUpdate("INSERT INTO DatMonAn(MaDatMonAn, MaHoaDon, MaMonAn, SoLuong, NgayDat) VALUES("
					+ "'" + s.getMaDatMonAn() + "'"
					+ ",'" + s.getMaHoaDon() + "'"
					+ ",'" + s.getMaMonAn() + "'"
					+ "," + s.getSoLuong() + ""
					+ ",'"+ s.getNgayDat() +"')"
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
	public int DeleteDatMonAn(DatMonAn s) {
		try {
			int result = lib.executeUpdate("DELETE FROM DatMonAn WHERE MaDatMonAn="
					+ "'"+ s.getMaDatMonAn() +"'"
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
	public int UpdateDatMonAn(DatMonAn s) {
		try {
			int result = lib.executeUpdate("UPDATE DatMonAn SET "
					//+ "MaHoaDon='" + s.getMaHoaDon() + "'"
					//+ ", MaMonAn='" + s.getMaMonAn() + "'"
					+ "SoLuong=" + s.getSoLuong() + ""
					//+ ", NgayDat='" + s.getNgayDat() + "'"
					+ " WHERE MaDatMonAn='"+ s.getMaDatMonAn() +"'"
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
