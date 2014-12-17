package org.eat.model;

import java.io.*;

public class NhanVien extends KhachHang implements Comparable<KhachHang>, Serializable {
	public boolean isLaNhanVien() {
		return laNhanVien;
	}

	public void setLaNhanVien(boolean laNhanVien) {
		this.laNhanVien = laNhanVien;
	}
	@Override
	public String toString() {
		return "KhachHang \n ID: " + id + "\n Ho Ten: " + hoTen + "\n Dia Chi: "
				+ diaChi + "\n Email: " + email + "\n So Dien Thoai: " + soDienThoai
				+ "\nLa nhan vien: " + laNhanVien + "\n";
	}
	public NhanVien() {
		this("", "", "", "", "", "", false);
	}
	public NhanVien(String id, String hoTen,String matKhau, String diaChi, String email,
			String soDienThoai, boolean laNhanVien) {
		super(id, hoTen, matKhau, diaChi, email, soDienThoai);
		this.laNhanVien = laNhanVien;
	}
	public static String printHeader() {
		return "ID     Ho Ten    Dia Chi    Email	So Dien Thoai	La Nhan Vien";
	}
	private boolean laNhanVien;	
}
