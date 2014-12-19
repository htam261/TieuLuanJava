package org.eat.collection;

import java.io.*;
import java.util.*;
import org.eat.model.*;

public class KhachHangCollection implements Serializable {
	ArrayList<KhachHang> ds;
	public KhachHangCollection() {
		ds = new ArrayList<KhachHang>();
	}
	public KhachHangCollection(ArrayList<KhachHang> a) {
		ds = new ArrayList<KhachHang>();
		ds = a;
	}
	public int size() {
		return ds.size();
	}
	public KhachHang getKhachHang(int i) {
		if (i >= 0 && i < size()) {
			return ds.get(i);
		}
		return null;
	}
	public ArrayList<KhachHang> getAllKhachHang() {
		return ds;
	}
	public ArrayList<KhachHang> getAllKhachHang_email(String id) {
		ArrayList<KhachHang> ls = new ArrayList<KhachHang>();
		for (KhachHang s : ds) {
			if (s.getEmail().equals(id))
				ls.add(s);
		}
		return ls;
	}
	public KhachHang getKhachHangID(String id) {
		for (KhachHang k : ds) {
			if (k.getId().equals(id))
				return k;
		}
		return null;
	}
	public boolean addKhachHang(KhachHang s) {
		if (!ds.contains(s)) {
			ds.add(s);
			return true;
		}
		return false;
	}
	public boolean updateKhachHang(KhachHang s) {
		if (ds.contains(s)) {
			ds.set(ds.indexOf(s), s);
			return true;
		}
		return false;
	}
	public boolean deleteKhachHang(KhachHang s) {
		if (ds.contains(s)) {
			ds.remove(ds.indexOf(s));
			return true;
		}
		return false;
	}
}

