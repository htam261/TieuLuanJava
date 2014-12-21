package org.eat.presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.eat.KhachHang.GUI;
import org.eat.collection.*;
import org.eat.database.*;
import org.eat.model.*;

public class login extends JFrame implements ActionListener {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin, btnCancel;
	private KhachHangDatabase khdb;
	private NhanVienDatabase nvdb;
	public login() {
		super("Đăng nhập");
		khdb = new KhachHangDatabase();
		nvdb = new NhanVienDatabase();
		JPanel pTop = new JPanel();
		JPanel pCen = new JPanel();
		JPanel pBot = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		add(pTop, BorderLayout.NORTH);
		add(pCen, BorderLayout.CENTER);
		add(pBot, BorderLayout.SOUTH);
		
		pTop.setBorder(BorderFactory.createLineBorder(Color.red));
		pCen.setBorder(BorderFactory.createLineBorder(Color.red));
		pTop.setBorder(BorderFactory.createTitledBorder("Tieu de"));
		
		JLabel lblTitle = new JLabel("Đăng Nhập", SwingConstants.CENTER);
		lblTitle.setForeground(Color.red);
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 35));
		ImageIcon imLogin = new ImageIcon("images/e.jpeg");
		JLabel lblImge = new JLabel(imLogin);
		pTop.add(lblTitle);
		//pTop.add(lblImge);
		
		
		pBot.add(btnLogin = new JButton("Logon", new ImageIcon("")));
		pBot.add(btnCancel = new JButton("Exit", new ImageIcon("")));
		
		btnCancel.addActionListener(this);
		btnLogin.addActionListener(this);
		
		btnLogin.setMnemonic('L');
		btnCancel.setMnemonic('x');
		
		JPanel pM = new JPanel();
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		p1.add(new JLabel("User name: "));
		p1.add(txtUsername = new JTextField(20));
		p2.add(new JLabel("Password: "));
		p2.add(txtPassword = new JPasswordField(20));
		
		Box b = Box.createVerticalBox();
		b.add(Box.createVerticalStrut(30));
		b.add(p1);b.add(p2);
		
		pM.add(b);
		
		
		pCen.add(pM, BorderLayout.CENTER);
		
		JLabel lblIMG = new JLabel(new ImageIcon("images/e.jpeg"));
		lblIMG.setBorder(BorderFactory.createLineBorder(Color.red));
		
		pCen.add(lblIMG, BorderLayout.WEST);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(400, 550));
		setResizable(false);
		setLocationRelativeTo(null);
		//this.add(pCen);
		//this.add(pBot);
		setUser();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnCancel)) {
			exitProgram();
		} else if (o.equals(btnLogin)) {
			loginMethod();
		}
	}
	
	private void loginMethod() {
		String user, pass;
		user = txtUsername.getText().trim();
		pass = txtPassword.getText().trim();
		if (user.equals("")) {
			JOptionPane.showMessageDialog(null, "User name must be filled");
			txtUsername.requestFocus();
			return;
		}
		if (pass.equals("")) {
			JOptionPane.showMessageDialog(this, "Password must be filled");
			txtPassword.requestFocus();
			return;
		}
		KhachHangCollection khcol = new KhachHangCollection(khdb.getAllKhachHang());
		NhanVienCollection nvcol = new NhanVienCollection(nvdb.getAllNhanVien());
		KhachHang kh = khcol.getKhachHangID(user);
		if (kh != null) {
			if (kh.getMatKhau().equals(pass)) {
				GUImain main = new GUImain(kh.getId());
				main.setVisible(true);
				this.setVisible(false);
				return;
			}
			JOptionPane.showMessageDialog(null, "password incorrect");
			return;
		}
		NhanVien nv = nvcol.getNhanVienID(user);
		if (nv != null) {
			if (nv.getMatKhau().equals(pass)) {
				GUI main = new GUI(nv.getId());
				main.setVisible(true);
				this.setVisible(false);
				return;		
			}
			JOptionPane.showMessageDialog(null, "password incorrect");
			return;
		}
	}
	
	public void exitProgram() {
		int selValue = JOptionPane.showConfirmDialog(this, "Are you sure to exit program ?", "Confirmation", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (selValue == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void setUser() {
		txtPassword.setText("minis");
		txtUsername.setText("1");
	}
	public static void main(String[] args) {
		Frame f = new login();
		f.setLocationRelativeTo(null);
		f.setSize(new Dimension(400, 300));
		f.setVisible(true);
	}
}
