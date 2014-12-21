package org.eat.database;

import java.sql.*;
import java.util.*;
import org.eat.collection.*;
import org.eat.model.*;

public class NhanVienDatabase {
	private LibSQL lib;

	public NhanVienDatabase() {
		lib = new LibSQL();
	}

	public ArrayList<NhanVien> getAllNhanVien() {
		try {
			ResultSet rs = lib
					.executeQuery("SELECT * FROM KhachHang WHERE LaNhanVien=true");
			NhanVienCollection collection = new NhanVienCollection();
			while (rs.next()) {
				NhanVien s = new NhanVien(rs.getString("ID"),
						rs.getString("HoTen"), rs.getString("MatKhau"),
						rs.getString("DiaChi"), rs.getString("Email"),
						rs.getString("SoDienThoai"),
						rs.getBoolean("LaNhanVien"));
				collection.addNhanVien(s);
			}
			return collection.getAllNhanVien();
		} catch (Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}

	public int InsertNhanVien(NhanVien s) {
		try {
			int result = lib
					.executeUpdate("INSERT INTO KhachHang(ID, HoTen, MatKhau, DiaChi, Email, SoDienThoai, LaNhanVien) VALUES("
							+ "'"
							+ s.getId()
							+ "'"
							+ ",'"
							+ s.getHoTen()
							+ "'"
							+ ",'"
							+ s.getMatKhau()
							+ "'"
							+ ",'"
							+ s.getDiaChi()
							+ "'"
							+ ",'"
							+ s.getEmail()
							+ "'"
							+ ",'"
							+ s.getSoDienThoai()
							+ "'"
							+ ","
							+ s.isLaNhanVien() + "" + ")");
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

	public int DeleteNhanVien(NhanVien s) {
		try {
			int result = lib.executeUpdate("DELETE FROM KhachHang WHERE ID="
					+ "'" + s.getId() + "'");
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

	public int UpdateNhanVien(NhanVien s) {
		try {
			int result = lib.executeUpdate("UPDATE KhachHang SET " + "HoTen='"
					+ s.getHoTen() + "'" + ", MatKhau='" + s.getMatKhau() + "'"
					+ ", DiaChi='" + s.getDiaChi() + "'" + ", Email='"
					+ s.getEmail() + "'" + ", SoDienThoai='"
					+ s.getSoDienThoai() + "'" + ", LaNhanVien="
					+ s.isLaNhanVien() + "" + " WHERE ID='" + s.getId() + "'");
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
