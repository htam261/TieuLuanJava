package org.eat.collection;

import java.io.*;
import java.util.*;
import org.eat.model.*;

public class NhanVienCollection implements Serializable {
	ArrayList<NhanVien> ds;

	public NhanVienCollection() {
		ds = new ArrayList<NhanVien>();
	}

	public NhanVienCollection(ArrayList<NhanVien> a) {
		ds = new ArrayList<NhanVien>();
		ds = a;
	}

	public int size() {
		return ds.size();
	}

	public NhanVien getNhanVien(int i) {
		if (i >= 0 && i < size()) {
			return ds.get(i);
		}
		return null;
	}

	public ArrayList<NhanVien> getAllNhanVien() {
		return ds;
	}

	public ArrayList<NhanVien> getAllNhanVien_email(String id) {
		ArrayList<NhanVien> ls = new ArrayList<NhanVien>();
		for (NhanVien s : ds) {
			if (s.getEmail().equals(id))
				ls.add(s);
		}
		return ls;
	}

	public NhanVien getNhanVienID(String id) {
		for (NhanVien k : ds) {
			if (k.getId().equals(id))
				return k;
		}
		return null;
	}

	public boolean addNhanVien(NhanVien s) {
		if (!ds.contains(s)) {
			ds.add(s);
			return true;
		}
		return false;
	}

	public boolean updateNhanVien(NhanVien s) {
		if (ds.contains(s)) {
			ds.set(ds.indexOf(s), s);
			return true;
		}
		return false;
	}

	public boolean deleteNhanVien(NhanVien s) {
		if (ds.contains(s)) {
			ds.remove(ds.indexOf(s));
			return true;
		}
		return false;
	}
}
