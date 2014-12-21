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
							rs.getString("ID")
							, rs.getString("HoTen")
							, rs.getString("MatKhau")
							, rs.getString("DiaChi")
							, rs.getString("Email")
							, rs.getString("SoDienThoai")
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
			int result = lib.executeUpdate("INSERT INTO KhachHang(ID, HoTen, MatKhau, DiaChi, Email, SoDienThoai, LaNhanVien) VALUES("
					+ "'" + s.getId() + "'"
					+ ",'" + s.getHoTen() + "'"
					+ ",'" + s.getMatKhau() + "'"
					+ ",'" + s.getDiaChi() + "'"
					+ ",'" + s.getEmail() + "'"
					+ ",'"+ s.getSoDienThoai() +"'"
					+ ","+ false +")"
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
			int result = lib.executeUpdate("DELETE FROM KhachHang WHERE ID="
					+ "'"+ s.getId() +"'"
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
					+ "HoTen='" + s.getHoTen() + "'"
				    + ", DiaChi='" + s.getDiaChi() + "'"
				    + ", Email='" + s.getEmail() + "'"
					+ ", SoDienThoai='" + s.getSoDienThoai() + "'"
					+ " WHERE ID='"+ s.getId() +"'"
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
