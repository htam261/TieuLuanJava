package org.eat.database;

import java.sql.*;
import java.util.*;
import org.eat.collection.*;
import org.eat.model.*;

public class KhachHangDatabase {
	private LibSQL lib;
	public KhachHangDatabase() {
		lib = new LibSQL();
	}	
	public ArrayList<KhachHang> getAllKhachHang() {
		try {
			ResultSet rs = lib.executeQuery("SELECT * FROM KhachHang WHERE LaNhanVien=false");
			KhachHangCollection collection = new KhachHangCollection();
			while (rs.next()) {
				KhachHang s = new KhachHang(
							rs.getString("MaHoaDon")
							, rs.getString("TenHoaDon")
							, rs.getString("MaKhachHang")
							, rs.getDate("NgayTao")
							, rs.getBoolean("DaThanhToan")
							, rs.getDouble("TongGia")
							);
				collection.addKhachHang(s);
			}
			return collection.getAllKhachHang();
		} catch(Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}
	
	public int InsertKhachHang(KhachHang s) {
		try {
			int result = lib.executeUpdate("INSERT INTO KhachHang(MaHoaDon, TenHoaDon, MaKhachHang, NgayTao, DaThanhToan, TongGia) VALUES("
					+ "'" + s.getMaHoaDon() + "'"
					+ ",'" + s.getTenHoaDon() + "'"
					+ ",'" + s.getMaKhachHang() + "'"
					+ ",'" + s.getNgayTao() + "'"
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
	public int DeleteKhachHang(KhachHang s) {
		try {
			int result = lib.executeUpdate("DELETE FROM KhachHang WHERE MaHoaDon="
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
	public int UpdateKhachHang(KhachHang s) {
		try {
			int result = lib.executeUpdate("UPDATE KhachHang SET "
					+ "TenHoaDon='" + s.getMaHoaDon() + "'"
				   // + ", MaKhachHang='" + s.getMaKhachHang() + "'"
				   // + ", NgayTao='" + s.getNgayDat() + "'"
					+ ", DaThanhToan='" + s.isDaThanhToan() + "'"
					+ ", TongGia='" + s.getTongGia() + "'"
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
