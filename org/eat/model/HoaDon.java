package org.eat.model;

import java.io.Serializable;
import java.util.*;

public class HoaDon implements Serializable, Comparable<HoaDon> {
	
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getTenHoaDon() {
		return tenHoaDon;
	}
	public void setTenHoaDon(String tenHoaDon) {
		this.tenHoaDon = tenHoaDon;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public boolean isDaThanhToan() {
		return daThanhToan;
	}
	public void setDaThanhToan(boolean daThanhToan) {
		this.daThanhToan = daThanhToan;
	}
	public double getTongGia() {
		return tongGia;
	}
	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}
	
	public HoaDon() {
		this("","","",new Date(),false, 0);
	}
	
	public HoaDon(String maHoaDon, String tenHoaDon, String maKhachHang,
			Date ngayTao, boolean daThanhToan, double tongGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.tenHoaDon = tenHoaDon;
		this.maKhachHang = maKhachHang;
		this.ngayTao = ngayTao;
		this.daThanhToan = daThanhToan;
		this.tongGia = tongGia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
		result = prime * result
				+ ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HoaDon \nMa Hoa Don: " + maHoaDon + "\n Ten Hoa Don: " + tenHoaDon
				+ "\n Ma Khach Hang: " + maKhachHang + "\n Ngay Tao: " + ngayTao
				+ "\n Da Thanh Toan: " + daThanhToan + "\n Tong Gia: " + tongGia + "\n";
	}
	public static String printHeader() {
		return "Ma Hoa Don     Ten Hoa Don    Ma Khach Hang    Ngay Tao		Da Thanh Toan	Tong Gia";
	}
	@Override
	public int compareTo(HoaDon o) {
		return this.getMaHoaDon().compareTo(o.getMaHoaDon());
	}
	private String maHoaDon;
	private String tenHoaDon;
	private String maKhachHang;
	private Date ngayTao;
	private boolean daThanhToan;
	private double tongGia;
}
