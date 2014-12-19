package org.eat.collection;

import java.io.*;
import java.util.*;
import org.eat.model.*;

public class MonAnCollection implements Serializable {
	ArrayList<MonAn> ds;
	public MonAnCollection() {
		ds = new ArrayList<MonAn>();
	}
	public MonAnCollection(ArrayList<MonAn> a) {
		ds = new ArrayList<MonAn>();
		ds = a;
	}
	public int size() {
		return ds.size();
	}
	public MonAn getMonAn(int i) {
		if (i >= 0 && i < size()) {
			return ds.get(i);
		}
		return null;
	}
	public ArrayList<MonAn> getAllMonAn() {
		return ds;
	}
	public MonAn getMonAnID(String id) {
		for (MonAn k : ds) {
			if (k.getMaMonAn().equals(id))
				return k;
		}
		return null;
	}
	public boolean addMonAn(MonAn s) {
		if (!ds.contains(s)) {
			ds.add(s);
			return true;
		}
		return false;
	}
	public boolean updateMonAn(MonAn s) {
		if (ds.contains(s)) {
			ds.set(ds.indexOf(s), s);
			return true;
		}
		return false;
	}
	public boolean deleteMonAn(MonAn s) {
		if (ds.contains(s)) {
			ds.remove(ds.indexOf(s));
			return true;
		}
		return false;
	}
}

