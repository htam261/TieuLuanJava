package org.eat.model;

import java.io.Serializable;
import java.sql.Date;

public class ChiTietDatMon implements Comparable<ChiTietDatMon>, Serializable {
	private String mamon;
	private String tenmon;
	private int soluong;
	private double gia;

	// private Date ngaydat;
	public ChiTietDatMon() {
		this("", "", 0, 0);
	}

	public ChiTietDatMon(String mamon, String tenmon, int soluong, double gia) {
		super();
		this.mamon = mamon;
		this.tenmon = tenmon;
		this.soluong = soluong;
		this.gia = gia;
		// this.ngaydat=ngaydat;
	}

	public String getMamon() {
		return mamon;
	}

	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

	public String getTenmon() {
		return tenmon;
	}

	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	// public Date getNgaydat() {
	// return ngaydat;
	// }
	// public void setNgaydat(Date ngaydat) {
	// this.ngaydat = ngaydat;
	// }
	public int compareTo(ChiTietDatMon o) {
		return this.mamon.compareTo(o.getMamon());
	}

	@Override
	public String toString() {
		return "ChiTietDatMon [mamon=" + mamon + ", tenmon=" + tenmon
				+ ", soluong=" + soluong + ", gia=" + gia + "]";
	}

}
