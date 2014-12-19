package org.eat.model;

import java.io.*;

public class LoaiMonAn implements Comparable<LoaiMonAn>, Serializable {
	public String getMaLoaiMonAn() {
		return maLoaiMonAn;
	}
	public void setMaLoaiMonAn(String maLoaiMonAn) {
		this.maLoaiMonAn = maLoaiMonAn;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getVung() {
		return vung;
	}
	public void setVung(String vung) {
		this.vung = vung;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((maLoaiMonAn == null) ? 0 : maLoaiMonAn.hashCode());
		result = prime * result + ((tenLoai == null) ? 0 : tenLoai.hashCode());
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
		LoaiMonAn other = (LoaiMonAn) obj;
		if (maLoaiMonAn == null) {
			if (other.maLoaiMonAn != null)
				return false;
		} else if (!maLoaiMonAn.equals(other.maLoaiMonAn))
			return false;
		if (tenLoai == null) {
			if (other.tenLoai != null)
				return false;
		} else if (!tenLoai.equals(other.tenLoai))
			return false;
		return true;
	}
	@Override
	public int compareTo(LoaiMonAn o) {
		return this.maLoaiMonAn.compareTo(o.getMaLoaiMonAn());
	}
	@Override
	public String toString() {
		return  tenLoai;
	}
	public static String printHeader() {
		return "Ma Loai Mon An     Ten Loai Mon An    Vung    Mo Ta";
	}
	public LoaiMonAn() {
		this("","","","");
	}
	public LoaiMonAn(String maLoaiMonAn, String tenLoai, String vung,
			String moTa) {
		super();
		this.maLoaiMonAn = maLoaiMonAn;
		this.tenLoai = tenLoai;
		this.vung = vung;
		this.moTa = moTa;
	}

	private String maLoaiMonAn;
	private String tenLoai;
	private String vung;
	private String moTa;
}
