package org.eat.model;

import java.io.*;
import java.util.*;

public class DatMonAn implements Comparable<DatMonAn>, Serializable {
	public String getMaDatMonAn() {
		return maDatMonAn;
	}
	public void setMaDatMonAn(String maDatMonAn) {
		this.maDatMonAn = maDatMonAn;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaMonAn() {
		return maMonAn;
	}
	public void setMaMonAn(String maMonAn) {
		this.maMonAn = maMonAn;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	
	@Override
	public String toString() {
		return "DatMonAn \n Ma Dat Mon An: " + maDatMonAn + "\n Ma Hoa Don: " + maHoaDon
				+ "\n Ma Mon An: " + maMonAn + "\n So Luong: " + soLuong
				+ "\n Ngay Dat: " + ngayDat + "\n";
	}
	public static String printHeader() {
		return "Ma Dat Mon An     Ma Hoa Don    Ma Mon An    So Luong	Ngay Dat";
	}
	public DatMonAn() {
		this("","","",0, new Date());
	}
	public DatMonAn(String maDatMonAn, String maHoaDon, String maMonAn,
			int soLuong, Date ngayDat) {
		super();
		this.maDatMonAn = maDatMonAn;
		this.maHoaDon = maHoaDon;
		this.maMonAn = maMonAn;
		this.soLuong = soLuong;
		this.ngayDat = ngayDat;
	}
	@Override
	public int compareTo(DatMonAn o) {
		return this.maDatMonAn.compareTo(o.getMaDatMonAn());
	}
	private String maDatMonAn;
	private String maHoaDon;
	private String maMonAn;
	private int soLuong;
	private Date ngayDat;
}
