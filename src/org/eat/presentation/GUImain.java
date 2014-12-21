package org.eat.presentation;

import javax.swing.*;
import org.eat.collection.*;
import org.eat.database.*;
import org.eat.model.*;
import java.awt.event.*;
import org.eat.presentation.nhanvien.*;

public class GUImain extends JFrame implements ActionListener {
	public GUImain(String id) {
		this.id = id;
		setTitle("Quản lý món ăn");
		setSize(1366, 768);
		// this.set
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopPane = new JDesktopPane();
		this.setContentPane(desktopPane);
		addMenu();
		this.setRootPaneCheckingEnabled(true);
	}

	public void addMenu() {
		mn = new JMenuBar();
		this.setJMenuBar(mn);
		mn.add(fileMenu = new JMenu("File"));
		mn.add(mNhanVien = new JMenu("Nhân viên"));
		mn.add(mKhachHang = new JMenu("Khách hàng"));
		mn.add(mMonAn = new JMenu("Món ăn"));
		mn.add(mHoaDon = new JMenu("Hóa đơn"));

		// Menu File
		mFileExit = new JMenuItem("Exit");
		mFileExit.addActionListener(this);
		fileMenu.add(mFileExit);
		// Menu khachhang
		mKhachHangQuanLy = new JMenuItem("Quản lý khách hàng");
		mKhachHangQuanLy.addActionListener(this);
		mKhachHang.add(mKhachHangQuanLy);
		mKhachHangThem = new JMenuItem("Thêm khách hàng");
		mKhachHang.addActionListener(this);
		mKhachHang.add(mKhachHangThem);
		// Menu nhan vien
		mNhanVienQuanLy = new JMenuItem("Quản lý nhân viên");
		mNhanVienQuanLy.addActionListener(this);
		mNhanVien.add(mNhanVienQuanLy);
		mNhanVienThem = new JMenuItem("Thêm nhân viên");
		mNhanVien.addActionListener(this);
		mNhanVien.add(mNhanVienThem);
		// Menu mon an
		mMonAnQuanLy = new JMenuItem("Quản lý món ăn");
		mMonAnQuanLy.addActionListener(this);
		mMonAn.add(mMonAnQuanLy);
		mMonAnThem = new JMenuItem("Thêm món ăn");
		mMonAn.addActionListener(this);
		mMonAn.add(mMonAnThem);
		// Menu hoa don
		mHoaDonQuanLy = new JMenuItem("Quản lý hóa đơn");
		mHoaDonQuanLy.addActionListener(this);
		mHoaDon.add(mHoaDonQuanLy);
		mHoaDonThem = new JMenuItem("Thêm hóa đơn");
		mHoaDon.addActionListener(this);
		mHoaDon.add(mHoaDonThem);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mFileExit)) {
			System.exit(0);
		} else if (e.getSource().equals(mKhachHangQuanLy)) {
			JInternalFrame mnKhachHang = new mnKhachHang("Quản lý khách hàng");
			desktopPane.add(mnKhachHang);
			mnKhachHang.setVisible(true);
		} else if (e.getSource().equals(mMonAnQuanLy)) {
			JInternalFrame mnMonAn = new mnMonAn("Quản lý món ăn");
			desktopPane.add(mnMonAn);
			mnMonAn.setVisible(true);
		} else if (e.getSource().equals(mHoaDonQuanLy)) {
			JInternalFrame mnHoaDon = new mnHoaDon("Quản lý món ăn", id);
			desktopPane.add(mnHoaDon);
			mnHoaDon.setVisible(true);
		}
	}
	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}
	public void addDesktopPane(JInternalFrame jif) {
		desktopPane.add(jif);
	}
	private JMenuBar mn;
	private JMenu fileMenu;
	private JMenu mNhanVien;
	private JMenu mKhachHang;
	private JMenu mMonAn;
	private JMenu mHoaDon;
	// menu file
	private JMenuItem mFileExit;
	// menu khach hang
	private JMenuItem mKhachHangQuanLy;
	private JMenuItem mKhachHangThem;
	// menu khach hang
	private JMenuItem mMonAnQuanLy;
	private JMenuItem mMonAnThem;
	// menu khach hang
	private JMenuItem mNhanVienQuanLy;
	private JMenuItem mNhanVienThem;
	// menu khach hang
	private JMenuItem mHoaDonQuanLy;
	private JMenuItem mHoaDonThem;

	private JDesktopPane desktopPane;
	private String id;
}
