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
				DatMonAn s = new DatMonAn(rs.getString("MaDatMonAn"),
						rs.getString("MaHoaDon"), rs.getString("MaMonAn"),
						rs.getInt("SoLuong"), rs.getDate("NgayDat"));
				collection.addDatMonAn(s);
			}
			return collection.getAllDatMonAn();
		} catch (Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}

	public ArrayList<DatMonAn> getMaMonAn(String mahd) {
		try {
			ResultSet rs = lib
					.executeQuery("Select * from DatMonAn where MaHoaDon like '%"
							+ mahd + "%'");
			ArrayList<DatMonAn> s = new ArrayList<>();
			while (rs.next()) {
				DatMonAn d = new DatMonAn(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getDate(5));
				s.add(d);
			}
			return s;
		} catch (Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}

	public int InsertDatMonAn(DatMonAn s) {
		try {
			int result = lib
					.executeUpdate("INSERT INTO DatMonAn(MaDatMonAn, MaHoaDon, MaMonAn, SoLuong, NgayDat) VALUES("
							+ "'"
							+ s.getMaDatMonAn()
							+ "'"
							+ ",'"
							+ s.getMaHoaDon()
							+ "'"
							+ ",'"
							+ s.getMaMonAn()
							+ "'"
							+ ","
							+ s.getSoLuong()
							+ ""
							+ ",'"
							+ s.getNgayDat().getYear()
							+ "/"
							+ s.getNgayDat().getMonth()
							+ "/"
							+ s.getNgayDat().getDate() + "')");
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
			int result = lib
					.executeUpdate("DELETE FROM DatMonAn WHERE MaDatMonAn="
							+ "'" + s.getMaDatMonAn() + "'");
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

	public int updateSoLuong(String mamonan, int soluong) {
		try {
			String sql = "Update DatMonAn set SoLuong =" + soluong
					+ " where MaMonAn = '" + mamonan + "'";
			int kq = lib.executeUpdate(sql);
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
			lib.close();
		}
		return 0;
	}

	public int UpdateDatMonAn(DatMonAn s) {
		try {
			int result = lib.executeUpdate("UPDATE DatMonAn SET "
			// + "MaHoaDon='" + s.getMaHoaDon() + "'"
			// + ", MaMonAn='" + s.getMaMonAn() + "'"
					+ "SoLuong=" + s.getSoLuong() + ""
					// + ", NgayDat='" + s.getNgayDat() + "'"
					+ " WHERE MaDatMonAn='" + s.getMaDatMonAn() + "'");
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
