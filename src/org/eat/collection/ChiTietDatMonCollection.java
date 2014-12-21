package org.eat.collection;

import java.util.ArrayList;

import org.eat.model.ChiTietDatMon;
import org.eat.model.DatMonAn;
import org.eat.model.MonAn;

public class ChiTietDatMonCollection {
	ArrayList<ChiTietDatMon> ds;
	public ChiTietDatMonCollection() {
		ds = new ArrayList<ChiTietDatMon>();
	}
	public int size() {
		return ds.size();
	}
	public ArrayList<ChiTietDatMon> addChiTietMonAn(ChiTietDatMon s) {
		if (!ds.contains(s)) {
			ds.add(s);
			return ds;
		}
		return null;
	}
}
