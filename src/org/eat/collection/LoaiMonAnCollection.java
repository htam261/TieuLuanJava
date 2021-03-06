package org.eat.collection;

import java.io.*;
import java.util.*;
import org.eat.model.*;

public class LoaiMonAnCollection implements Serializable {
	ArrayList<LoaiMonAn> ds;

	public LoaiMonAnCollection() {
		ds = new ArrayList<LoaiMonAn>();
	}

	public LoaiMonAnCollection(ArrayList<LoaiMonAn> a) {
		ds = new ArrayList<LoaiMonAn>();
		ds = a;
	}

	public int size() {
		return ds.size();
	}

	public LoaiMonAn getLoaiMonAn(int i) {
		if (i >= 0 && i < size()) {
			return ds.get(i);
		}
		return null;
	}

	public ArrayList<LoaiMonAn> getAllLoaiMonAn() {
		return ds;
	}

	public LoaiMonAn getLoaiMonAnID(String id) {
		for (LoaiMonAn k : ds) {
			if (k.getMaLoaiMonAn().equals(id))
				return k;
		}
		return null;
	}

	public boolean addLoaiMonAn(LoaiMonAn s) {
		if (!ds.contains(s)) {
			ds.add(s);
			return true;
		}
		return false;
	}

	public boolean updateLoaiMonAn(LoaiMonAn s) {
		if (ds.contains(s)) {
			ds.set(ds.indexOf(s), s);
			return true;
		}
		return false;
	}

	public boolean deleteLoaiMonAn(LoaiMonAn s) {
		if (ds.contains(s)) {
			ds.remove(ds.indexOf(s));
			return true;
		}
		return false;
	}
}
