package org.eat.model;

import java.io.Serializable;

public class MonAn implements Comparable<MonAn>, Serializable {
	
	public String getMaMonAn() {
		return maMonAn;
	}
	public void setMaMonAn(String maMonAn) {
		this.maMonAn = maMonAn;
	}
	public String getTenMonAn() {
		return tenMonAn;
	}
	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public MonAn() {
		this("","","","","",0);
	}
	public MonAn(String maMonAn, String tenMonAn, String hinhAnh, String loai,
			String moTa, double gia) {
		super();
		this.maMonAn = maMonAn;
		this.tenMonAn = tenMonAn;
		this.hinhAnh = hinhAnh;
		this.loai = loai;
		this.moTa = moTa;
		this.gia = gia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maMonAn == null) ? 0 : maMonAn.hashCode());
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
		MonAn other = (MonAn) obj;
		if (maMonAn == null) {
			if (other.maMonAn != null)
				return false;
		} else if (!maMonAn.equals(other.maMonAn))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mon An \n Ma Mon An: " + maMonAn + "\n Ten Mon An: " + tenMonAn
				+ "\n Hinh Anh: " + hinhAnh + "\n Loai: " + loai + "\n Mo Ta: " + moTa
				+ "\n Gia: " + gia + "\n";
	}
	public static String printHeader() {
		return "Ma Mon An     Ten Mon An    Hinh Anh    Loai	Mo Ta	Gia";
	}
	@Override
	public int compareTo(MonAn o) {
		return this.getMaMonAn().compareTo(o.getMaMonAn());
	}
	private String maMonAn;
	private String tenMonAn;
	private String hinhAnh;
	private String loai;
	private String moTa;
	private double gia;
}
