package org.eat.database;

import java.sql.*;
import java.util.*;
import org.eat.collection.*;
import org.eat.model.*;

public class HoaDonDatabase {
	private LibSQL lib;
	public HoaDonDatabase() {
		lib = new LibSQL();
	}	
	public ArrayList<HoaDon> getAllHoaDon() {
		try {
			ResultSet rs = lib.executeQuery("SELECT * FROM HoaDon");
			HoaDonCollection collection = new HoaDonCollection();
			while (rs.next()) {
				HoaDon s = new HoaDon(
							rs.getString("MaHoaDon")
							, rs.getString("TenHoaDon")
							, rs.getString("MaKhachHang")
							, rs.getDate("NgayTao")
							, rs.getBoolean("DaThanhToan")
							, rs.getDouble("TongGia")
							);
				collection.addHoaDon(s);
			}
			return collection.getAllHoaDon();
		} catch(Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}
	
	public int InsertHoaDon(HoaDon s) {
		try {
			int result = lib.executeUpdate("INSERT INTO HoaDon(MaHoaDon, TenHoaDon, KhachHang, NgayTao, DaThanhToan, TongGia) VALUES("
					+ "'" + s.getMaHoaDon() + "'"
					+ ",'" + s.getTenHoaDon() + "'"
					+ ",'" + s.getMaKhachHang() + "'"
					+ ",'"+ s.getNgayTao().getYear() + "/" + s.getNgayTao().getMonth() + "/" + s.getNgayTao().getDate() +"'"
					+ ","+ s.isDaThanhToan() +""
					+ ","+ s.getTongGia() +")"
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
	public int DeleteHoaDon(HoaDon s) {
		try {
			int result = lib.executeUpdate("DELETE FROM HoaDon WHERE MaHoaDon="
					+ "'"+ s.getMaHoaDon() +"'"
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
	public int UpdateHoaDon(HoaDon s) {
		try {
			int result = lib.executeUpdate("UPDATE HoaDon SET "
					+ "TenHoaDon='" + s.getMaHoaDon() + "'"
				   // + ", MaKhachHang='" + s.getMaKhachHang() + "'"
				   // + ", NgayTao='" + s.getNgayDat() + "'"
					+ ", DaThanhToan=" + s.isDaThanhToan() + ""
					+ ", TongGia=" + s.getTongGia() + ""
					+ " WHERE MaHoaDon='"+ s.getMaHoaDon() +"'"
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
