package org.eat.model;

import java.io.*;

public class KhachHang implements Comparable<KhachHang>, Serializable {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KhachHang \n ID: " + id + "\n Ho Ten: " + hoTen
				+ "\n Dia Chi: " + diaChi + "\n Email: " + email
				+ "\n So Dien Thoai: " + soDienThoai + "\n";
	}

	@Override
	public int compareTo(KhachHang o) {
		return this.getId().compareTo(o.getId());
	}

	public static String printHeader() {
		return "ID     Ho Ten    Dia Chi    Email	So Dien Thoai";
	}

	public KhachHang() {
		this("", "", "", "", "", "");
	}

	public KhachHang(String id, String hoTen, String matKhau, String diaChi,
			String email, String soDienThoai) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.matKhau = matKhau;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	protected String id;
	protected String hoTen;
	protected String matKhau;
	protected String diaChi;
	protected String email;
	protected String soDienThoai;
}
