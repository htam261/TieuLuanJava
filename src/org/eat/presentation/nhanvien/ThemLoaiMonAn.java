package org.eat.presentation.nhanvien;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;

import org.eat.collection.*;
import org.eat.database.*;
import org.eat.model.*;

import javax.swing.event.*;

public class ThemLoaiMonAn extends JInternalFrame implements ActionListener {
	public ThemLoaiMonAn() {
		this(null);
	}
	public ThemLoaiMonAn(LoaiMonAn l) {
		this.l = l; 
		addControl();
		showFrame();
		dblma = new LoaiMonAnDatabase();
	}
	public void showFrame() {
		setTitle("Them loai mon an");
		setSize(300, 250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setVisible(true);
	}
	public void addControl() {
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel b = new JPanel();
		b.setLayout(new BoxLayout(b, BoxLayout.Y_AXIS));
		
		// add ma loai
		p1.add(new JLabel("Ma loai: "));
		p1.add(tMaLoai = new JTextField(15));
		b.add(p1);
		// add ten loai
		p2.add(new JLabel("Ten loai: "));
		p2.add(tTenLoai = new JTextField(15));
		b.add(p2);
		// add vung
		p3.add(new JLabel("Vung : "));
		p3.add(tVung = new JTextField(15));
		b.add(p3);
		// add mo ta
		p4.add(new JLabel("Mo ta: "));
		p4.add(tMoTa = new JTextField(15));
		b.add(p4);

		// add mo ta
		p5.add(btnThem = new JButton("Them"));
		p5.add(btnHuyBo = new JButton("Huy bo"));
		b.add(p5);

		
		
		p.add(b);
		add(p);
		// add actionListener
		addActionListioner();
		if (this.l != null) {
			tMaLoai.setEditable(false);
			setLoaiMonAn(l);
		}
	}
	public void addActionListioner() {
		btnThem.addActionListener(this);
		btnHuyBo.addActionListener(this);
	}
	public void setLoaiMonAn(LoaiMonAn l) {
		tMaLoai.setText(l.getMaLoaiMonAn());
		tTenLoai.setText(l.getTenLoai());
		tVung.setText(l.getVung());
		tMoTa.setText(l.getMoTa());
	}
	public LoaiMonAn getLoaiMonAn() {
		LoaiMonAn l = new LoaiMonAn();
		CheckLoaiMonAn();
		l.setMaLoaiMonAn(tMaLoai.getText());
		l.setTenLoai(tTenLoai.getText());
		l.setVung(tVung.getText());
		l.setMoTa(tMoTa.getText());
		return l;
	}
	public void CheckLoaiMonAn() {
		if (CheckTextBoxNull(tMaLoai))
			JOptionPane.showMessageDialog(null, "Ma loai khong duoc rong");
		if (CheckTextBoxNull(tTenLoai))
			JOptionPane.showMessageDialog(null, "Ten loai khong duoc rong");
		if (CheckTextBoxNull(tVung))
			JOptionPane.showMessageDialog(null, "Vung khong duoc rong");
		if (CheckTextBoxNull(tMoTa))
			JOptionPane.showMessageDialog(null, "Mo ta khong duoc rong");
	}
	public boolean CheckTextBoxNull(JTextField t) {
		if (!t.getText().trim().equals("")) 
			return false;
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnThem)) {
			if (this.l == null) {
				LoaiMonAn lma = getLoaiMonAn();
				int kq = dblma.InsertLoaiMonAn(lma);
				JOptionPane.showMessageDialog(null, "" + kq);
			} else {
				LoaiMonAn lma = getLoaiMonAn();
				int kq = dblma.UpdateLoaiMonAn(lma);
				JOptionPane.showMessageDialog(null, "" + kq);
			}
			this.setVisible(false);
		} else if(e.getSource().equals(btnHuyBo)) {
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new ThemLoaiMonAn();
	}
	private JTextField tMaLoai, tTenLoai, tVung, tMoTa;
	private LoaiMonAnDatabase dblma;
	private JButton btnThem, btnHuyBo;
	private LoaiMonAn l;
}
