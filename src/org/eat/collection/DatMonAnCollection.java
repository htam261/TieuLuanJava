package org.eat.collection;

import java.io.*;
import java.util.*;
import org.eat.model.*;

public class DatMonAnCollection implements Serializable {
	ArrayList<DatMonAn> ds;
	public DatMonAnCollection() {
		ds = new ArrayList<DatMonAn>();
	}
	public DatMonAnCollection(ArrayList<DatMonAn> a) {
		ds = new ArrayList<DatMonAn>();
		ds = a;
	}
	public int size() {
		return ds.size();
	}
	public DatMonAn getDatMonAn(int i) {
		if (i >= 0 && i < size()) {
			return ds.get(i);
		}
		return null;
	}
	public ArrayList<DatMonAn> getAllDatMonAn() {
		return ds;
	}
	public ArrayList<DatMonAn> getAllDatMonAn_MaMonAn(String id) {
		ArrayList<DatMonAn> ls = new ArrayList<DatMonAn>();
		for (DatMonAn s : ds) {
			if (s.getMaMonAn().equals(id))
				ls.add(s);
		}
		return ls;
	}
	public ArrayList<DatMonAn> getAllDatMonAn_MaHoaDon(String id) {
		ArrayList<DatMonAn> ls = new ArrayList<DatMonAn>();
		for (DatMonAn s : ds) {
			if (s.getMaHoaDon().equals(id))
				ls.add(s);
		}
		return ls;
	}
	public DatMonAn getDatMonAnID(String id) {
		for (DatMonAn k : ds) {
			if (k.getMaDatMonAn().equals(id))
				return k;
		}
		return null;
	}
	public boolean addDatMonAn(DatMonAn s) {
		if (!ds.contains(s)) {
			ds.add(s);
			return true;
		}
		return false;
	}
	public boolean updateDatMonAn(DatMonAn s) {
		if (ds.contains(s)) {
			ds.set(ds.indexOf(s), s);
			return true;
		}
		return false;
	}
	public boolean deleteDatMonAn(DatMonAn s) {
		if (ds.contains(s)) {
			ds.remove(ds.indexOf(s));
			return true;
		}
		return false;
	}
}
