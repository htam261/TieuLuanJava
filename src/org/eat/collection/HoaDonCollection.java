package org.eat.collection;

import java.io.*;
import java.util.*;
import org.eat.model.*;

public class HoaDonCollection implements Serializable {
	ArrayList<HoaDon> ds;
	public HoaDonCollection() {
		ds = new ArrayList<HoaDon>();
	}
	public HoaDonCollection(ArrayList<HoaDon> a) {
		ds = new ArrayList<HoaDon>();
		ds = a;
	}
	public int size() {
		return ds.size();
	}
	public HoaDon getHoaDon(int i) {
		if (i >= 0 && i < size()) {
			return ds.get(i);
		}
		return null;
	}
	public ArrayList<HoaDon> getAllHoaDon() {
		return ds;
	}
	public ArrayList<HoaDon> getAllHoaDon_MaKhachHang(String id) {
		ArrayList<HoaDon> ls = new ArrayList<HoaDon>();
		for (HoaDon s : ds) {
			if (s.getMaKhachHang().equals(id))
				ls.add(s);
		}
		return ls;
	}
	public HoaDon getHoaDonID(String id) {
		for (HoaDon k : ds) {
			if (k.getMaHoaDon().equals(id))
				return k;
		}
		return null;
	}
	public boolean addHoaDon(HoaDon s) {
		if (!ds.contains(s)) {
			ds.add(s);
			return true;
		}
		return false;
	}
	public boolean updateHoaDon(HoaDon s) {
		if (ds.contains(s)) {
			ds.set(ds.indexOf(s), s);
			return true;
		}
		return false;
	}
	public boolean deleteHoaDon(HoaDon s) {
		if (ds.contains(s)) {
			ds.remove(ds.indexOf(s));
			return true;
		}
		return false;
	}
}
