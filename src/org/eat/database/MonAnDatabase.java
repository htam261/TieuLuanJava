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
	public ArrayList<MonAn> getMonAn(String mamon) {
		try {
			ResultSet rs = lib.executeQuery("SELECT * FROM MonAn where MaMonAn like '%"+mamon+"%'");
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
	public ArrayList<MonAn> getSearch(String maloai,int gia){
		try {
			String str="";
			String sql="";
			if(gia == 0)
				str=" gia < 50000";
			else if(gia == 1)
					str=" gia between 50000 and 100000";
				else if(gia == 2)
						str=" gia > 100000";
					else str=" gia > 0";
			ResultSet rs;
			sql="SELECT * FROM MonAn where Loai like '%"+maloai+"%' and "+str;
			rs = lib.executeQuery(sql);
			ArrayList<MonAn> list=new ArrayList<MonAn>();
			while (rs.next()) {
				MonAn s = new MonAn(
							rs.getString("MaMonAn")
							, rs.getString("TenMonAn")
							, rs.getString("HinhAnh")
							, rs.getString("Loai")
							, rs.getString("MoTa")
							, rs.getDouble("Gia")
							);
				list.add(s);
			}
			return list;
		} catch(Exception e) {
			lib.close();
		} finally {
			lib.close();
		}
		return null;
	}
	public ArrayList<MonAn> getSearch(String maloai,String tenmonan,int gia){
		try {
			String str="";
			String sql="";
			if(gia == 0)
				str=" gia < 50000";
			else if(gia == 1)
					str=" gia between 50000 and 100000";
				else if(gia == 2)
						str=" gia > 100000";
					else str=" gia > 0";
			ResultSet rs;
			sql="SELECT * FROM MonAn where Loai like '%"+maloai+"%' and "+str+" and tenmonan like '%"+tenmonan+"%'";
			rs = lib.executeQuery(sql);
			ArrayList<MonAn> list=new ArrayList<MonAn>();
			while (rs.next()) {
				MonAn s = new MonAn(
							rs.getString("MaMonAn")
							, rs.getString("TenMonAn")
							, rs.getString("HinhAnh")
							, rs.getString("Loai")
							, rs.getString("MoTa")
							, rs.getDouble("Gia")
							);
				list.add(s);
			}
			return list;
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
